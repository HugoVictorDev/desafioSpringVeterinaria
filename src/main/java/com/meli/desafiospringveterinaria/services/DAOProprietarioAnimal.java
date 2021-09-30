package com.meli.desafiospringveterinaria.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.desafiospringveterinaria.model.Animal;
import com.meli.desafiospringveterinaria.model.ProprietarioAnimal;
import com.meli.desafiospringveterinaria.persistence.Persistivel;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;


import java.util.ArrayList;
import java.util.List;

@Service
public class DAOProprietarioAnimal implements Persistivel<ProprietarioAnimal> {

    private Persistivel persistivel;

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

        } catch (Exception exception) {
            String a = "";
        }

        if (proprietarioAnimalList == null)
            proprietarioAnimalList = new ArrayList<ProprietarioAnimal>();
    }

    @Override
    //Alterar para retornar objeto proprietarioAnimal
    public Animal cadastrar(ProprietarioAnimal proprietarioAnimal) {


        try {
            this.proprietarioAnimalList.add(proprietarioAnimal);
            objectMapper.writeValue(new File("Proprietarios.json"), proprietarioAnimalList);
            return proprietarioAnimal.getAnimal();

        } catch (Exception exception) {
            System.out.println("Proprietario cadastrado");
            throw new RuntimeException("Erro no momento de cadastrar o proprietario");
        }

    }

    @Override
    public void editar(ProprietarioAnimal obj) {
    }

    @Override
    public void obter(ProprietarioAnimal obj) {

    }


    public ProprietarioAnimal edita(ProprietarioAnimal obj) {
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


    public ProprietarioAnimal obterAnimal(ProprietarioAnimal obj) {
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


    @SneakyThrows
    public List<ProprietarioAnimal> listagemConsulta(){
        mapearObjeto();
        proprietarioAnimalList = objectMapper.readValue(new File("Proprietarios.json"), new TypeReference<List<ProprietarioAnimal>>(){});
        return proprietarioAnimalList;
    }
}

