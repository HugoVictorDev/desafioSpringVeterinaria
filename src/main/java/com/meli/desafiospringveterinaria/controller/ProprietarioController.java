package com.meli.desafiospringveterinaria.controller;

import com.meli.desafiospringveterinaria.dao.DAOAnimal;
<<<<<<< HEAD
import com.meli.desafiospringveterinaria.model.*;
import com.meli.desafiospringveterinaria.persistence.Persistivel;


import com.meli.desafiospringveterinaria.services.DAOProprietarioAnimal;
=======
import com.meli.desafiospringveterinaria.dao.DAOProprietarioAnimal;
import com.meli.desafiospringveterinaria.model.*;
import com.meli.desafiospringveterinaria.services.ProprietarioService;
import com.meli.desafiospringveterinaria.persistence.IntefaceProprietarioService;
>>>>>>> 35da861b5219956d0996adbfc20a75adfa3b9179
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.ParseException;

@RestController
@RequestMapping("/proprietario")
public class ProprietarioController
{
<<<<<<< HEAD

    DAOProprietarioAnimal daoProprietarioAnimal = new DAOProprietarioAnimal();
   DAOAnimal daoAnimal = new DAOAnimal();
=======
    IntefaceProprietarioService intefaceProprietarioService;


    public ProprietarioController() throws ParseException {
        DAOAnimal animal = new DAOAnimal();
        DAOProprietarioAnimal proprietarioAnimal = new DAOProprietarioAnimal();
        intefaceProprietarioService = new ProprietarioService(proprietarioAnimal, animal) {
            @Override
            public RespostaBase atualizarProprietario(ProprietarioAnimal proprietario, ProprietarioAnimal proprietario2) {
                return null;
            }
        };
    }
>>>>>>> 35da861b5219956d0996adbfc20a75adfa3b9179

    @GetMapping("/consulta/{identificador}")
    public RespostaBase obter(@PathVariable ("identificador") String identificador) throws IOException, ParseException {
        return intefaceProprietarioService.obterPorIdentificador(identificador);
    }

    @PostMapping("/cadastrar")
    public RespostaBase cadastrarProprietario( @RequestBody ProprietarioAnimal proprietario) {
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