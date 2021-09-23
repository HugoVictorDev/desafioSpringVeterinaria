package com.meli.desafiospringveterinaria.controller;

import com.meli.desafiospringveterinaria.services.DAOmedico;
import com.meli.desafiospringveterinaria.model.Medico;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/medico")
public class MedicoController {

    DAOmedico daomedico = new DAOmedico();


   //responseEnity retorna um status
    @PostMapping("/cadastrar")
    public ResponseEntity<Medico> cadastroMedico(@RequestBody Medico objMedico){
        daomedico.cadastrar(objMedico);
        return ResponseEntity.ok(objMedico);
    }


    @GetMapping("/consulta")
    public String obter(){
        return  null;

    }

    @PutMapping("/editar")
    public void atualizarMedico(){

        return;

    }

}
