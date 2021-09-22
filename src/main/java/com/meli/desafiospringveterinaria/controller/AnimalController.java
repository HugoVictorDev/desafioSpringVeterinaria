package com.meli.desafiospringveterinaria.controller;
import com.meli.desafiospringveterinaria.services.DAOAnimal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/paciente")
public class AnimalController {

    DAOAnimal daoAnimal = new DAOAnimal();


        @GetMapping("/consultar")
        public void obter(){

        }


        @PostMapping("/cadastrar")
        public void cadastrarAnimal(){

        }

        @PutMapping("/editar")
        public void atualizarAnimal() {

        }
    }

