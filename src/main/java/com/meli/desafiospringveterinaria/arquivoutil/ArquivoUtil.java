package com.meli.desafiospringveterinaria.arquivoutil;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;


import com.meli.desafiospringveterinaria.model.Medico;

public class ArquivoUtil {

    ObjectMapper objectMapper = new ObjectMapper();

    private void mapearObjeto() {
        objectMapper.findAndRegisterModules();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
    }


    public List<Medico> carregaArquivo() throws IOException {
        mapearObjeto();
        try {
            List<Medico> list;
            list = objectMapper.readValue(new File("medico.json"), new TypeReference<List<Medico>>() {});
            return list;
        } catch (IOException e) {
            e.printStackTrace();
        }
    return null;
    }

    public void gravaArquivo(List<Medico> medicosList) {
        mapearObjeto();
        try {
            objectMapper.writeValue(new File("medico.json"), medicosList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

