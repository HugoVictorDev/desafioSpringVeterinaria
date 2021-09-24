package com.meli.desafiospringveterinaria.controller;


import com.meli.desafiospringveterinaria.model.Consulta;
import com.meli.desafiospringveterinaria.services.DAOcosulta;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consulta")
public class ConsultaController {


    DAOcosulta daOcosulta = new DAOcosulta();

    @PostMapping("/cadastrar")
    public void cadastroConsulta(@RequestBody Consulta cosulta ){
        daOcosulta.cadastrar(cosulta);
    }



}