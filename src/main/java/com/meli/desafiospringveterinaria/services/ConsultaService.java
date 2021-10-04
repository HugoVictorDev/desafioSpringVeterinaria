package com.meli.desafiospringveterinaria.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.desafiospringveterinaria.model.Consulta;

import com.meli.desafiospringveterinaria.persistence.ConsultaPersistivel;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ConsultaService extends ConsultaPersistivel {

    public ObjectMapper objectMapper = new ObjectMapper();

    public void mapearObjeto() {
        objectMapper.findAndRegisterModules();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
    }


    List<Consulta> consultaList2 = new ArrayList<>();
    public boolean validarConsulta(String nome) {
        mapearObjeto();
        try {
            consultaList2 = objectMapper.readValue(new File("consulta.json"), new TypeReference<List<Consulta>>() {});
            for (Consulta consulta : consultaList2){
                if (consulta.getAnimal().getNome().equals(nome)) {

                }else {return false;}
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }
}

