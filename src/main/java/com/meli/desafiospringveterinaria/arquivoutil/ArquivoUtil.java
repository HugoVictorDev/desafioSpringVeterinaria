package com.meli.desafiospringveterinaria.ArquivoUtil;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.gson.Gson;

import com.meli.desafiospringveterinaria.model.Consulta;

import com.meli.desafiospringveterinaria.model.Medico;


public class ArquivoUtil {

    public List<Consulta> carregaArquivo(String nomeArquivo) throws IOException {
        mapearObjeto();
        try {
            List<Consulta> list;
            list = objectMapper.readValue(new File(nomeArquivo), new TypeReference<List<Consulta>>(){});
            return list;
        }catch (IOException e){
            e.printStackTrace();
        } return null;
    }

    ObjectMapper objectMapper = new ObjectMapper();

    private void mapearObjeto() {
        objectMapper.findAndRegisterModules();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

    }

    public List gravaQualquerArquivo(List<Object> list, String nomeArquivo) {
        mapearObjeto();
        try {
            objectMapper.writeValue(new File(nomeArquivo), list);
            return list;
        }catch (IOException e) {
            e.printStackTrace();
        }return null;
    }


    public List gravaArquivo(List<Consulta> consultaList) {
        mapearObjeto();
        try {
            objectMapper.writeValue(new File("consulta.json"), consultaList);
            return consultaList;
        }catch (IOException e) {
            e.printStackTrace();
        }return null;
    }


public void gravaArquivoConsulta(List<Consulta> cosultaList) {
    Gson gson = new Gson();
    String json = gson.toJson(cosultaList);
    try {
        //Escreve Json convertido em arquivo chamado "file.json"
        FileWriter writer = new FileWriter("consulta.json");
        writer.write(json);
        writer.close();

    } catch (IOException e) {
        e.printStackTrace();
    }
}
}

