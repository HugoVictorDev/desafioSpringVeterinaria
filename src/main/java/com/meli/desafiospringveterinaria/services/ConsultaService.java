package com.meli.desafiospringveterinaria.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.desafiospringveterinaria.arquivoUtil.ArquivoUtil;
import com.meli.desafiospringveterinaria.model.Consulta;

import com.meli.desafiospringveterinaria.persistence.ConsultaPersistivel;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ConsultaService extends ConsultaPersistivel {

    ObjectMapper objectMapper = new ObjectMapper();
    ArquivoUtil arquivoUtil;

    public void mapearObjeto() {
        objectMapper.findAndRegisterModules();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
    }


    List<Consulta> consultaList = new ArrayList<>();
    public boolean validarConsulta(String nome) {
        mapearObjeto();
        try {
            consultaList = arquivoUtil.carregaArquivoConsulta1("consulta.json");
            for (Consulta consulta : consultaList){
                if (consulta.getAnimal().getNome().equals(nome)) {

                }else {return false;}
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }
}

