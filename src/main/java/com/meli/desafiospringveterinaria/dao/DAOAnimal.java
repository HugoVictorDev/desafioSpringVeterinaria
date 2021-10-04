package com.meli.desafiospringveterinaria.dao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.desafiospringveterinaria.arquivoutil.ArquivoUtil;
import com.meli.desafiospringveterinaria.model.Animal;
import com.meli.desafiospringveterinaria.persistence.Persistivel;
import lombok.Getter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Getter
public class DAOAnimal implements Persistivel<Animal> {

    List<Animal> listaAnimal = new ArrayList<>();
    ArquivoUtil arquivoUtil = new ArquivoUtil();
    ObjectMapper objectMapper = new ObjectMapper();

    private static final String ANIMALJSON = "animal.json";

    private void mapearObjeto() {
        objectMapper.findAndRegisterModules();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
    }

    @Override
    public Animal cadastrar(Animal animal) {
        mapearObjeto();
        listaAnimal.add(animal);
        try {
            objectMapper.writeValue(new File(ANIMALJSON), listaAnimal);
        }catch (IOException e){
            e.printStackTrace();
        }
        return animal;
    }


    @Override
    public Animal editar(Animal obj) {
        return null;
    }

    @Override
    public Animal obter(Animal obj) {
        return null;
    }


    public Animal edita(Animal objAnimal) {
        mapearObjeto();
        try {
            listaAnimal = objectMapper.readValue(new File(ANIMALJSON), new TypeReference<List<Animal>>(){});
            for (Animal animal : listaAnimal){
                if (animal.getNumeroDoPaciente() == (objAnimal.getNumeroDoPaciente())){
                    listaAnimal.remove(animal);
                    listaAnimal.add(objAnimal);
                    objectMapper.writeValue(new File(ANIMALJSON), listaAnimal);
                    return animal;
                }
            } throw new RuntimeException("Animal nao atualizado");
        } catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }


    public Animal consultarAnimal (long numeroDoPaciente) {
        mapearObjeto();
        try {
            listaAnimal = objectMapper.readValue(new File(ANIMALJSON), new TypeReference<List<Animal>>() {});
            for (Animal animal : listaAnimal){
                if (animal.getNumeroDoPaciente() == (numeroDoPaciente)){
                    return animal;
                }
            } throw new RuntimeException("Animal nao encontrado");
        } catch (IOException e){
            e.printStackTrace();
        } return null;
    }

    @Override
    public List<Animal> listagem() {
        return listaAnimal;
    }

    public Animal obter2(Animal obj) {
        return obj;
    }

    public Animal obterPorIdentificador(String identificador) {
        return null;
    }


}