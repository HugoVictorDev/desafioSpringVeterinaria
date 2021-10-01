package com.meli.desafiospringveterinaria.controller;

import com.meli.desafiospringveterinaria.dao.DAOAnimal;
import com.meli.desafiospringveterinaria.dao.DAOProprietarioAnimal;
import com.meli.desafiospringveterinaria.model.*;
import com.meli.desafiospringveterinaria.services.ProprietarioService;
import com.meli.desafiospringveterinaria.persistence.IntefaceProprietarioService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.ParseException;

@RestController
@RequestMapping("/proprietario")
public class ProprietarioController
{
    IntefaceProprietarioService intefaceProprietarioService;


    public ProprietarioController() throws ParseException {
        DAOAnimal animal = new DAOAnimal();
        DAOProprietarioAnimal proprietarioAnimal = new DAOProprietarioAnimal();
        intefaceProprietarioService = new ProprietarioService(proprietarioAnimal, animal);
    }

    @GetMapping("/consulta/{identificador}")
    public RespostaBase obter(@PathVariable ("identificador") String identificador) throws IOException, ParseException {
        return intefaceProprietarioService.obterPorIdentificador(identificador);
    }

    @PostMapping("/cadastrar")
    public RespostaBase cadastrarProprietario( @RequestBody ProprietarioAnimal proprietario) {
        return intefaceProprietarioService.cadastrarProprietario(proprietario);
    }

    @PutMapping("/editar")
    public RespostaBase atualizarProprietario( @RequestBody ProprietarioAnimal proprietario) throws IOException {
        return intefaceProprietarioService.atualizarProprietario(proprietario);
    }

    @GetMapping("/consulta/proprietarios")
    public RespostaBase listarProprietario()
    {
        return intefaceProprietarioService.listagemConsulta();
    }
}