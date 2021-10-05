package com.meli.desafiospringveterinaria.persistence;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.desafiospringveterinaria.model.Animal;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AnimalPersistence {

    private List<Animal> listaAnimal = new ArrayList<>();
    ObjectMapper objectMapper = new ObjectMapper();

    public void mapearObjeto(){
        objectMapper.findAndRegisterModules();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
    }

    public boolean validar(Long numeroDoPaciente){
        mapearObjeto();
        try {
            listaAnimal = objectMapper.readValue(new File("animal.json"), new TypeReference<List<Animal>>() {});
            for (Animal animal : listaAnimal){
                if (animal.getNumeroDoPaciente() == numeroDoPaciente){
                    return false;
                }
            }
            return true;
        } catch (IOException e){
            e.printStackTrace();
        }
        return true;
    }

    public Animal cadastrar(Animal objAnimal) throws IOException {
//        mapearObjeto();
//        try {
//            if (validar(objAnimal.getNumeroDoPaciente())){
//                listaAnimal.add(objAnimal);
                objectMapper.writeValue(new File("animal.json"), listaAnimal);
//            } else {
//                throw new RuntimeException("Animal já cadastrado.");
//            }
//        } catch (IOException e){
//            e.printStackTrace();
//        }
        return objAnimal;
    }

    public Animal editar(Animal objAnimal) {
        mapearObjeto();
        try {
            listaAnimal = objectMapper.readValue(new File("animal.json"), new TypeReference<List<Animal>>(){});
            for (Animal animal : listaAnimal){
                if (animal.getNumeroDoPaciente() == (objAnimal.getNumeroDoPaciente())){
                    listaAnimal.remove(animal);
                    listaAnimal.add(objAnimal);
                    objectMapper.writeValue(new File("animal.json"), listaAnimal);
                    return animal;
                }
            } throw new RuntimeException("Animal não atualizado.");
        } catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

    public Animal consultar(long numeroDoPaciente) {
        mapearObjeto();
        try {
            listaAnimal = objectMapper.readValue(new File("animal.json"), new TypeReference<List<Animal>>() {});
            for (Animal animal : listaAnimal){
                if (animal.getNumeroDoPaciente() == (numeroDoPaciente)){
                    return animal;
                }
            } throw new RuntimeException("Animal nao encontrado.");
        } catch (IOException e){
            e.printStackTrace();
        } return null;
    }

    public List<Animal> listagem() {
        return listaAnimal;
    }



}
