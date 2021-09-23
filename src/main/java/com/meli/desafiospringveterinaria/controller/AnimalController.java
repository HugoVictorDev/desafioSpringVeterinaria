package com.meli.desafiospringveterinaria.controller;
import com.meli.desafiospringveterinaria.model.Animal;
import com.meli.desafiospringveterinaria.services.DAOAnimal;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/paciente")
public class AnimalController {

    DAOAnimal daoAnimal = new DAOAnimal();

    @PostMapping("/cadastrar/{animal}")
    public ResponseEntity<Animal> cadastrarAnimal(@RequestBody Animal objMedico){
        daoAnimal.cadastrar(objMedico);
        return ResponseEntity.ok(objMedico);
    }


}

