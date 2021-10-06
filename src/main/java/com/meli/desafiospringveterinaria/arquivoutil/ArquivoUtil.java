package com.meli.desafiospringveterinaria.arquivoUtil;

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
import com.meli.desafiospringveterinaria.model.ProprietarioAnimal;


public class ArquivoUtil {

    ObjectMapper objectMapper = new ObjectMapper();

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
        try {
            List<Medico> list;
            list = objectMapper.readValue(new File(nomeArquivo), new TypeReference<List<Medico>>(){});
            return list;
        }catch (IOException e){
            e.printStackTrace();
        } return null;
    }
    public List<Consulta> carregaArquivoConsulta1(String nomeArquivo) throws IOException {
        mapearObjeto();
        try {
            List<Consulta> list;
            list = objectMapper.readValue(new File(nomeArquivo), new TypeReference<List<Consulta>>(){});
            return list;
        }catch (IOException e){
            e.printStackTrace();
        } return null;
    }



    public void gravaArquivo(List<Medico> list, String nomeArquivo) {
        mapearObjeto();
        try {
            objectMapper.writeValue(new File(nomeArquivo), list);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }



    public List gravaArquivoConsulta1(List<Consulta> consultaList) {
        mapearObjeto();
        try {
            objectMapper.writeValue(new File("consulta.json"), consultaList);
            return consultaList;
        }catch (IOException e) {
            e.printStackTrace();
        }return null;
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


    public Object carregaQualquerArquivo(String nomeArquivo) {
        try {
            List<Object> list;
            list = objectMapper.readValue(new File(nomeArquivo), new TypeReference<List<Object>>() {});
            return list;
        } catch (IOException e) {
            e.printStackTrace();
        }return null;
    }

    public List<Object> carregaArquivo(List<Object> ObjetolList, String nomeArquivo) {
        ArrayList<Object> objectArrayList = new ArrayList<>(ObjetolList.size());

        for (Object o : (ObjetolList)) {
            objectArrayList.add(o);
        }

        this.gravaQualquerArquivo(objectArrayList, nomeArquivo);
        return Collections.singletonList(ObjetolList);
    }

    public List<ProprietarioAnimal> metodoCarregaArquivo(String nomeArquivo) throws IOException {
        mapearObjeto();

        List<ProprietarioAnimal> list;
        try {

            return objectMapper.readValue(new File(nomeArquivo), new TypeReference<List<ProprietarioAnimal>>(){});

        }catch (IOException e){
            e.printStackTrace();
            return null;
        }

    }



}