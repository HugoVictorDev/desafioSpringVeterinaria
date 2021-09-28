package com.meli.desafiospringveterinaria.controller;

import com.meli.desafiospringveterinaria.model.Medico;
import com.meli.desafiospringveterinaria.services.DAOMedico;
import com.meli.desafiospringveterinaria.services.DAOConsulta;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
    @RequestMapping("/medico")
    public  class MedicoController {

        DAOMedico daomedico = new DAOMedico();

        //responseEnity retorna um status
        @PostMapping("/cadastrar")
        public ResponseEntity<Medico> cadastroMedico(@RequestBody Medico objMedico){
            daomedico.cadastrar(objMedico);
            return ResponseEntity.ok(objMedico);
        }

        @GetMapping("/consulta/{numeroRegistro}")
        public Medico obterMedico(@PathVariable("numeroRegistro") Long numeroRegistro) {
            return daomedico.obterMedico(numeroRegistro);
        }

        @PutMapping("/editar")
        public Medico atualizarMedico(@RequestBody Medico objMedico){
            daomedico.edita(objMedico);
            return objMedico;

        }
        @DeleteMapping(value="/deleta/{numeroRegistro}")
        public void remove(@PathVariable("numeroRegistro") Long numeroRegistro){
           daomedico.remover(numeroRegistro);
        }
    }

