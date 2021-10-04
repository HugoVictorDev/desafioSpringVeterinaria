package com.meli.desafiospringveterinaria.controller;

import com.meli.desafiospringveterinaria.dao.DAOMedico;
import com.meli.desafiospringveterinaria.model.Medico;

import com.meli.desafiospringveterinaria.dao.*;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;


@RestController
    @RequestMapping("/medico")
    public  class MedicoController {

        DAOMedico daomedico = new DAOMedico();

        @PostMapping("/cadastrar")
        public ResponseEntity<Medico> cadastroMedico(@RequestBody Medico objMedico) throws IOException {
            daomedico.cadastrar(objMedico);
            return ResponseEntity.ok(objMedico);
        }

        @GetMapping("/consulta/{numeroRegistro}")
        public Medico obterMedico(@PathVariable("numeroRegistro") Long numeroRegistro) {
            return daomedico.obter(numeroRegistro);
        }

        @PutMapping("/editar")
        public Medico atualizarMedico(@RequestBody Medico objMedico){
            daomedico.editar(objMedico);
            return objMedico;

        }
        @DeleteMapping(value="/deleta/{numeroRegistro}")
        public void remove(@PathVariable("numeroRegistro") Long numeroRegistro) throws IOException {
           daomedico.remover(numeroRegistro);
        }
    }

