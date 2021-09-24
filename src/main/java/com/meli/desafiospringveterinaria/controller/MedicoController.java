package com.meli.desafiospringveterinaria.controller;

import com.meli.desafiospringveterinaria.model.Medico;
import com.meli.desafiospringveterinaria.services.DAOMedico;
import com.meli.desafiospringveterinaria.services.DAOcosulta;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


    @RestController
    @RequestMapping("/medico")
    public  class MedicoController {

        DAOMedico daomedico = new DAOMedico();
        DAOcosulta daOcosulta = new DAOcosulta();

        //responseEnity retorna um status
        @PostMapping("/cadastrar")
        public ResponseEntity<Medico> cadastroMedico(@RequestBody Medico objMedico){
            daomedico.cadastrar(objMedico);
            return ResponseEntity.ok(objMedico);
        }

        @GetMapping("/consulta/{numeroRegistro}")
        public Medico obterMedico(@PathVariable("numeroRegistro") Long numeroRegistro) {
            return daomedico.obeterMedico(numeroRegistro);
        }

        @GetMapping("/consultas/{nome}")
        public DAOcosulta consultar(@PathVariable("nome") String nome) {
            daOcosulta.consultarMedico(nome);
            return null;
        }

        @PutMapping("/editar")
        public Medico atualizarMedico(@RequestBody Medico objMedico){
            daomedico.edita(objMedico);
            return objMedico;

        }
    }

