package com.meli.desafiospringveterinaria.services;


import com.meli.desafiospringveterinaria.model.Animal;
import com.meli.desafiospringveterinaria.persistence.AnimalPersistence;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class AnimalService {

    private List<Animal> listaAnimal = new ArrayList<>();
    private static AnimalPersistence persistence;

    public AnimalService() {
    }

    public AnimalService(AnimalPersistence persistence) {
        this.persistence = persistence;
    }

    public Animal cadastrar(Animal animal) throws IOException {
        persistence.mapearObjeto();
        if (persistence.validar(animal.getNumeroDoPaciente())) {
            listaAnimal.add(animal);
        }else {
            throw new RuntimeException("Animal já cadastrado.");
        }
        return animal;
    }
}
