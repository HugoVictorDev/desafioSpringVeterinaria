package com.meli.desafiospringveterinaria.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.desafiospringveterinaria.model.ProprietarioAnimal;
import com.meli.desafiospringveterinaria.persistence.Persistivel;
import java.io.File;
import java.io.IOException;


import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DAOproprietarioAnimal implements Persistivel<ProprietarioAnimal> {

    List<ProprietarioAnimal> proprietarioAnimalList;
    ObjectMapper objectMapper;

    public DAOproprietarioAnimal(){
        objectMapper = new ObjectMapper();objectMapper.findAndRegisterModules();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        proprietarioAnimalList = new ArrayList<ProprietarioAnimal>();
        try
        {
            proprietarioAnimalList = objectMapper.readValue(new File("Proprietarios.json"), proprietarioAnimalList.getClass());

        }
        catch (Exception exception)
        {
            String a = "";
        }

        if(proprietarioAnimalList == null)
            proprietarioAnimalList = new ArrayList<ProprietarioAnimal>();
    }

    @Override
    public void cadastrar(ProprietarioAnimal obj) {
        this.proprietarioAnimalList.add(obj);

        try{
            objectMapper.writeValue(new File("Proprietarios.json"), proprietarioAnimalList);
        }
        catch (Exception exception){
            String erro = exception.toString();
        }
    }

    @Override
    public void editar(ProprietarioAnimal obj) {

    }

    @Override
    public ProprietarioAnimal obter(ProprietarioAnimal obj) {
        if(proprietarioAnimalList == null){
            return null;
        }

        boolean existe = false;

        for (int i = 0; i < proprietarioAnimalList.size(); i++) {
            ProprietarioAnimal prop = ((ProprietarioAnimal) proprietarioAnimalList.get(i));
            if (prop !=null && prop.getCpf().equals(obj.getCpf())) {
                existe = true;
            }
        }

        if(existe){
            return  null;
        }

        return obj;
    }

    @Override
    public List<ProprietarioAnimal> listagem() {
        return null;
    }
}