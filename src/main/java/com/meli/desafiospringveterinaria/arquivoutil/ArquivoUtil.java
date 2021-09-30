package com.meli.desafiospringveterinaria.ArquivoUtil;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import com.meli.desafiospringveterinaria.model.ProprietarioAnimal;

public class ArquivoUtil {

    ObjectMapper objectMapper = new ObjectMapper();


    private void mapearObjeto() {
        objectMapper.findAndRegisterModules();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
    }


    public List<Object> carregaArquivo(String nomeArquivo) throws IOException {
        mapearObjeto();
        try {

            return objectMapper.readValue(new File(nomeArquivo), new TypeReference<List<Object>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }
    return null;
    }

    public void gravaArquivo(List<Object> List, String nomeArquivo) {
        mapearObjeto();
        try {
            objectMapper.writeValue(new File(nomeArquivo), List);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

