package com.meli.desafiospringveterinaria.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.desafiospringveterinaria.model.Animal;
import com.meli.desafiospringveterinaria.model.ProprietarioAnimal;
import com.meli.desafiospringveterinaria.persistence.Persistivel;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.SneakyThrows;

import java.io.File;
import java.io.IOException;


import java.util.ArrayList;
import java.util.List;

public class DAOProprietarioAnimal implements Persistivel<ProprietarioAnimal> {

    List<ProprietarioAnimal> proprietarioAnimalList;
    ObjectMapper objectMapper;

    private void mapearObjeto() {
        objectMapper.findAndRegisterModules();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
    }

    public DAOProprietarioAnimal() {
        objectMapper = new ObjectMapper();
        mapearObjeto();

        proprietarioAnimalList = new ArrayList<ProprietarioAnimal>();
        try {
            proprietarioAnimalList = objectMapper.readValue(new File("Proprietarios.json"), new TypeReference<List<ProprietarioAnimal>>() {
            });

        } catch (Exception exception) { }

        if (proprietarioAnimalList == null)
            proprietarioAnimalList = new ArrayList<ProprietarioAnimal>();
    }

    @Override
    public ProprietarioAnimal cadastrar(ProprietarioAnimal obj) {
        this.proprietarioAnimalList.add(obj);

        try {
            objectMapper.writeValue(new File("Proprietarios.json"), proprietarioAnimalList);
        } catch (Exception exception) {
            String erro = exception.toString();
        }
        return null;
    }

    @Override
    public ProprietarioAnimal editar(ProprietarioAnimal obj) {
        try {
            for (ProprietarioAnimal proprietarioAnimal : proprietarioAnimalList) {
                if (proprietarioAnimal.getCpf().equals(obj.getCpf())) {
                    proprietarioAnimalList.remove(proprietarioAnimal);
                    proprietarioAnimalList.add(obj);
                    objectMapper.writeValue(new File("Proprietarios.json"), proprietarioAnimalList);
                    return proprietarioAnimal;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public ProprietarioAnimal obter(ProprietarioAnimal obj) {
        if (proprietarioAnimalList == null) {
            return null;
        }

        try {
            for (ProprietarioAnimal proprietarioAnimal : proprietarioAnimalList) {
                if (proprietarioAnimal.getCpf().equals(obj.getCpf())) {
                    return proprietarioAnimal;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ProprietarioAnimal obterProprietarioAnimal(ProprietarioAnimal obj) {
        if (proprietarioAnimalList == null) {
            return null;
        }

        try {
            for (ProprietarioAnimal proprietarioAnimal : proprietarioAnimalList) {
                if (proprietarioAnimal.getCpf().equals(obj.getCpf())) {
                    return proprietarioAnimal;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public ProprietarioAnimal obterPorIdentificador(String identificador) {
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

    @Override
    public List<ProprietarioAnimal> listagem() {
        return proprietarioAnimalList;
    }
}