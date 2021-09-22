package com.meli.desafiospringveterinaria.controller;

import com.meli.desafiospringveterinaria.model.Medico;
import com.meli.desafiospringveterinaria.services.DAOmedico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/medico")
public class MedicoController {


    DAOmedico daomedico = new DAOmedico();


    @GetMapping("/consulta")
    public String obter(){

        return  daomedico.obeter();

    }


    @PostMapping("/cadastrar")
    public void cadastrarMedico(){

    }

    @PutMapping("/editar")
    public void atualizarMedico(){

        daomedico.editar();


    }



}
