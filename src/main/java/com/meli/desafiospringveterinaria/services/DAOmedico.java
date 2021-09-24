package com.meli.desafiospringveterinaria.services;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.desafiospringveterinaria.ArquivoUtil.ArquivoUtil;
import com.meli.desafiospringveterinaria.model.Medico;
import com.meli.desafiospringveterinaria.persistence.Persistivel;

import lombok.Getter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Getter
public class DAOMedico implements Persistivel<Medico> {

    List<Medico> medicos = new ArrayList<>();

    ObjectMapper objectMapper = new ObjectMapper();

    private void mapearObjeto() {
        objectMapper.findAndRegisterModules();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
    }

    ArquivoUtil arquivoUtil = new ArquivoUtil();

    @Override
    public void cadastrar(Medico objMedico) {
        if(validaMedico(objMedico.getNumeroRegistro())) {
            medicos.add(objMedico);
            arquivoUtil.gravaArquivo(medicos);
         }else{throw new RuntimeException("Médico já cadastrado");
        }
    }

    @Override
    public List<Medico> listagem() {
       return medicos;
    }


    public Medico obeterMedico(Long numeroRegistro){
        try {
            medicos = objectMapper.readValue(new File("medico.json"), new TypeReference<List<Medico>>(){});
            for (Medico medico : medicos){
                if (medico.getNumeroRegistro() == (numeroRegistro)) {
                    return medico;
                }
            }throw new RuntimeException("Médico não encontrado");
        }catch (IOException e){
            e.printStackTrace();
        }return null;
    }

    @Override
    public void obeter(Medico obj) {

    }

    @Override
    public void editar(Medico obj) {
    }

//metodo que valida se o medico ja existe verificando o registro
    private boolean validaMedico(long registroMedico) {
        for(Medico medico:listagem()) {
            if(medico.getNumeroRegistro() == (registroMedico)) {
                return false;
            }
        }
        return true;
    }



}