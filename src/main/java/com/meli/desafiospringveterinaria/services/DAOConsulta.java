package com.meli.desafiospringveterinaria.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;
import com.meli.desafiospringveterinaria.model.Consulta;
import com.meli.desafiospringveterinaria.persistence.Persistivel;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class DAOConsulta implements Persistivel<Consulta> {


    List<Consulta> consultaList = new ArrayList<>();

    ObjectMapper objectMapper = new ObjectMapper();
    private void mapearObjeto() {
        objectMapper.findAndRegisterModules();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
    }

    @Override
    public void cadastrar(Consulta consulta) {
        mapearObjeto();
        consultaList.add(consulta);
        try {
            objectMapper.writeValue(new File("consulta.json"), consultaList);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void editar(Consulta obj) {

    }

    @Override
    public void obter(Consulta obj) {}


    @Override
    public List<Consulta> listagem() {
        return null;
    }


    public Consulta consultarMedico(String nome) {
        mapearObjeto();
        try {
            consultaList = objectMapper.readValue(new File("consulta.json"), new TypeReference<List<Consulta>>(){});
            for (Consulta cosulta : consultaList){
                if (cosulta.getMedico().getNomeMedico().equals(nome)) {
                    return cosulta;
                }
            }throw new RuntimeException("Não há consultas para esse Médico");
        }catch (IOException e){
            e.printStackTrace();
        }return null;
    }

}
