package com.meli.desafiospringveterinaria.controller;


import com.meli.desafiospringveterinaria.dao.DAOAnimal;
import com.meli.desafiospringveterinaria.dao.DAOProprietarioAnimal;
import com.meli.desafiospringveterinaria.model.ProprietarioAnimal;
import com.meli.desafiospringveterinaria.model.RespostaBase;
import com.meli.desafiospringveterinaria.persistence.IntefaceProprietarioService;

import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.ParseException;

@RestController
@RequestMapping("/proprietario")
public class ProprietarioController
{
   DAOProprietarioAnimal daoProprietarioAnimal = new DAOProprietarioAnimal();
   DAOAnimal daoAnimal = new DAOAnimal();

    IntefaceProprietarioService intefaceProprietarioService;


    public ProprietarioController() throws ParseException {
        DAOAnimal animal = new DAOAnimal();
        DAOProprietarioAnimal proprietarioAnimal = new DAOProprietarioAnimal();
    }


    @GetMapping("/consulta/{identificador}")
    public ProprietarioAnimal obter(@PathVariable ("identificador") String identificador) throws IOException, ParseException {
        return intefaceProprietarioService.obterPorIdentificador(identificador);
    }

    @PostMapping("/cadastrar")
    public ProprietarioAnimal cadastrarProprietario( @RequestBody ProprietarioAnimal proprietario) {
        return intefaceProprietarioService.cadastrarProprietario(proprietario);
    }

    @PutMapping("/editar")
    public RespostaBase atualizarProprietario( @RequestBody ProprietarioAnimal proprietario, @RequestBody ProprietarioAnimal proprietarioNovo) throws IOException {
        return intefaceProprietarioService.atualizarProprietario(proprietario, proprietarioNovo);
    }

    @GetMapping("/consulta/proprietarios")
    public RespostaBase listarProprietario()
    {
        return intefaceProprietarioService.listagemConsulta();
    }
}