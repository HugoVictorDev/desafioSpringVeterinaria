package com.meli.desafiospringveterinaria.arquivoutil;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.desafiospringveterinaria.model.Consulta;
import com.meli.desafiospringveterinaria.model.Medico;


public class ArquivoUtil {
    public ArquivoUtil() {
    }

    ObjectMapper objectMapper = new ObjectMapper();
    private String nomeArquivo;

    private void mapearObjeto() {
        objectMapper.findAndRegisterModules();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
    }


    public List<Consulta> carregaArquivoConsulta(String nomeArquivo) throws IOException {
        mapearObjeto();
        try {
            List<Consulta> list;
            list = objectMapper.readValue(new File(nomeArquivo), new TypeReference<List<Consulta>>() {
            });
            return list;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Medico> carregaArquivo(String nomeArquivo) throws IOException {
        mapearObjeto();
        List<Medico> list = new ArrayList<>();
        try {
            list = objectMapper.readValue(new File(nomeArquivo), new TypeReference<List<Medico>>(){});
            return list;
        }catch (IOException e){
            e.printStackTrace();
        } return list;
    }

    public void gravaArquivo(List<Medico> list, String nomeArquivo) {
        mapearObjeto();
        try {
            objectMapper.writeValue(new File(nomeArquivo), list);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }


    public Object carregaQualquerArquivo( String nomeArquivo) {
        try {
            List<Object> list;
            list = objectMapper.readValue(new File(nomeArquivo), new TypeReference<List<Object>>() {});
            return list;
        } catch (IOException e) {
            e.printStackTrace();
        }return null;
    }
}
