package com.meli.desafiospringveterinaria.controller;
<<<<<<< HEAD
import com.meli.desafiospringveterinaria.dao.DAOAnimal;
import com.meli.desafiospringveterinaria.model.Animal;
=======

import com.meli.desafiospringveterinaria.model.Animal;
import com.meli.desafiospringveterinaria.dao.DAOAnimal;
>>>>>>> 35da861b5219956d0996adbfc20a75adfa3b9179
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paciente")
public class AnimalController {

   DAOAnimal daoAnimal = new DAOAnimal();

    @PostMapping("/cadastrar")
    public ResponseEntity<Animal> cadastrarAnimal(@RequestBody Animal objAnimal){
        daoAnimal.cadastrar(objAnimal);
        return ResponseEntity.ok(objAnimal);
    }

    @GetMapping("/consultar/{numeroDoPaciente}")
    public Animal consultarAnimal (@PathVariable("numeroDoPaciente") long numeroDoPaciente){
        return daoAnimal.consultarAnimal(numeroDoPaciente);
    }

    @PutMapping("/editar")
    public Animal  editarAnimal(@RequestBody Animal objAnimal){
        daoAnimal.edita(objAnimal);
        return objAnimal;
    }

    @GetMapping("/consultar")
    public List<Animal> listarAnimal(){
        return daoAnimal.listagem();
    }
}