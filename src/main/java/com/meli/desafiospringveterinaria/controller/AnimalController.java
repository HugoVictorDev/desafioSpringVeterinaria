package com.meli.desafiospringveterinaria.controller;
import com.meli.desafiospringveterinaria.model.Animal;
import com.meli.desafiospringveterinaria.services.DAOAnimal;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paciente")
public class AnimalController {

    DAOAnimal daoAnimal = new DAOAnimal();
    List<Animal> listaDeAnimal = daoAnimal.listagem();


    @PostMapping("/cadastrar")
    public ResponseEntity<Animal> cadastrarAnimal(@RequestBody Animal objAnimal){
        daoAnimal.cadastrar(objAnimal);
        return ResponseEntity.ok(objAnimal);
    }

    @GetMapping("/consultar")
    public List<Animal> listarAnimal(){
        return listaDeAnimal;
    }

    @PutMapping("/editar")
    public ResponseEntity<Animal>  editarAnimal(@RequestBody Animal ObjAnimal){
        daoAnimal.editar(ObjAnimal);
        return ResponseEntity.ok(listaDeAnimal);
    }

}

