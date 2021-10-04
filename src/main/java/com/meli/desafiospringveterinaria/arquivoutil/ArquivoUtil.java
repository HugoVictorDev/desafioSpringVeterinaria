package com.meli.desafiospringveterinaria.arquivoutil;

import java.io.File;
import java.io.IOException;
import java.util.List;
<<<<<<< HEAD


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.gson.Gson;

=======
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
>>>>>>> 35da861b5219956d0996adbfc20a75adfa3b9179
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

<<<<<<< HEAD
    }

    public List gravaQualquerArquivo(List<Object> list, String nomeArquivo) {
        mapearObjeto();
        try {
            objectMapper.writeValue(new File(nomeArquivo), list);
=======
    public List<Consulta> carregaArquivoConsulta(String nomeArquivo) throws IOException {
        mapearObjeto();
        try {
            List<Consulta> list;
            list = objectMapper.readValue(new File(nomeArquivo), new TypeReference<List<Consulta>>() {
            });
>>>>>>> 35da861b5219956d0996adbfc20a75adfa3b9179
            return list;
        }catch (IOException e) {
            e.printStackTrace();
<<<<<<< HEAD
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

=======
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

    public List gravaArquivo(List<Medico> medicosList) {
        mapearObjeto();
        try {
            objectMapper.writeValue(new File("medico.json"), medicosList);
            return medicosList;
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
}
>>>>>>> 35da861b5219956d0996adbfc20a75adfa3b9179
