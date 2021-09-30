package com.meli.desafiospringveterinaria.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.desafiospringveterinaria.model.Animal;
import com.meli.desafiospringveterinaria.model.ProprietarioAnimal;
import com.meli.desafiospringveterinaria.persistence.Persistivel;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;


import java.util.ArrayList;
import java.util.List;

@Service
public class DAOProprietarioAnimal implements Persistivel<ProprietarioAnimal> {

    private Persistivel persistivel;


    //ObjectMapper objectMapper;



    public DAOProprietarioAnimal() {
        objectMapper = new ObjectMapper();
        mapearObjeto();

        ArrayList<ProprietarioAnimal> proprietarioAnimalList;
        try {
            proprietarioAnimalList = objectMapper.readValue(new File("Proprietarios.json"), new TypeReference<List<ProprietarioAnimal>>() {
            });

        } catch (Exception exception) {
            String a = "";
        }

        if (proprietarioAnimalList == null)
            proprietarioAnimalList = new ArrayList<ProprietarioAnimal>();
    }

    @Override
    public Animal cadastrar(ProprietarioAnimal obj) {
        return null;
    }

    @Override
    public void editar(ProprietarioAnimal obj) {

    }

    @Override
    public void obter(ProprietarioAnimal obj) {

    }

    @Override
    public List<ProprietarioAnimal> listagem() {
        return null;
    }
    @Override
    public ProprietarioAnimal obterPorIdentificador(String cpf) {
        if (proprietarioAnimalList == null) {
            return null;
        }

        try {
            for (ProprietarioAnimal proprietarioAnimal : proprietarioAnimalList) {
                if (proprietarioAnimal.getCpf().equals(identificador)) {
                    return proprietarioAnimal;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

