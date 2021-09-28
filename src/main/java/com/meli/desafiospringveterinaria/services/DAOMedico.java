package com.meli.desafiospringveterinaria.services;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.desafiospringveterinaria.ArquivoUtil.ArquivoUtil;
import com.meli.desafiospringveterinaria.model.Animal;
import com.meli.desafiospringveterinaria.model.Consulta;
import com.meli.desafiospringveterinaria.model.Medico;
import com.meli.desafiospringveterinaria.persistence.Persistivel;

import lombok.Getter;
import lombok.SneakyThrows;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Getter
public class DAOMedico implements Persistivel<Medico> {

    List<Medico> medicosList = new ArrayList<>();
    ObjectMapper objectMapper = new ObjectMapper();

    private void mapearObjeto() {
        objectMapper.findAndRegisterModules();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
    }

    ArquivoUtil arquivoUtil = new ArquivoUtil();

    @Override
    public void cadastrar(Medico objMedico) {
        mapearObjeto();
        try {
                if(validaMedico(objMedico.getNumeroRegistro())){
                    medicosList.add(objMedico);
                    objectMapper.writeValue(new File("medico.json"), medicosList);
                }else{throw new RuntimeException("Medico já cadastrado");}
    //        }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void editar(Medico obj) {}

    @Override
    public void obter(Medico obj) {}


    @Override
    public List<Medico> listagem() {
        return null;
    }


    public Medico obterMedico(Long numeroRegistro) {
        try {
            medicosList = objectMapper.readValue(new File("medico.json"), new TypeReference<List<Medico>>() {
            });
            for (Medico medico : medicosList) {
                if (medico.getNumeroRegistro() == (numeroRegistro)) {
                    return medico;
                }
            }
            throw new RuntimeException("Médico não encontrado");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public Medico edita(Medico objMedico) {
        mapearObjeto();
        try {
            medicosList = objectMapper.readValue(new File("medico.json"), new TypeReference<List<Medico>>() {
            });
            for (Medico medico : medicosList) {
                if (medico.getNumeroRegistro() == (objMedico.getNumeroRegistro())) {
                    medicosList.remove(medico);
                    medicosList.add(objMedico);
                    objectMapper.writeValue(new File("medico.json"), medicosList);
                    return medico;
                }
            }
            throw new RuntimeException("Médico não Atualizdo");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private boolean validaMedico(long registroMedico) {
        mapearObjeto();
        try {
            medicosList = objectMapper.readValue(new File("medico.json"), new TypeReference<List<Medico>>() {});
             for (Medico medico : medicosList){
                if (medico.getNumeroRegistro() == (registroMedico)) {
                    return false;
                }
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }


    @SneakyThrows
    public List<Medico> remover(Long numeroRegistro) {
        mapearObjeto();
        List<Consulta> listConsulta;
        medicosList = objectMapper.readValue(new File("medico.json"), new TypeReference<List<Medico>>() {});
   try {
       for (Medico medico : medicosList) {
           if (medico.getNumeroRegistro() == (numeroRegistro)) {
               listConsulta = objectMapper.readValue(new File("consulta.json"), new TypeReference<List<Consulta>>() {
               });
               for (Consulta consulta : listConsulta) {
                   if (consulta.getMedico().getNumeroRegistro() == (numeroRegistro)) {
                            throw new RuntimeException("Medico em consulta, ele não pode ser deletado!");
                      }
               }  medicosList.remove(medico);
                  objectMapper.writeValue(new File("medico.json"), medicosList);
                  throw new RuntimeException("Medico deletado!");
           }
       }throw new RuntimeException("Medico não cadastrado!");
   } catch (IOException e) {
       e.printStackTrace();
   }
        return null;
    }
}