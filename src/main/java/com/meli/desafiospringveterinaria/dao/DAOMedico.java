package com.meli.desafiospringveterinaria.dao;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import com.meli.desafiospringveterinaria.arquivoUtil.ArquivoUtil;
import com.meli.desafiospringveterinaria.model.Medico;
import com.meli.desafiospringveterinaria.persistence.MedicoPersistivel;

import com.meli.desafiospringveterinaria.services.MedicoService;
import lombok.Getter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
public class DAOMedico implements MedicoPersistivel<Medico> {


    List<Medico> medicosList = new ArrayList<>();
    ObjectMapper objectMapper = new ObjectMapper();
    ArquivoUtil arquivoUtil;
    MedicoService medicoService;

    //Gestão de dependencia
    public DAOMedico(ArquivoUtil arquivoUtil){
        this.arquivoUtil = arquivoUtil;
    }
    public DAOMedico(MedicoService medicoService){
        this.medicoService = medicoService;
    }
    public DAOMedico(ArquivoUtil arquivoUtil, MedicoService medicoService){
        this.arquivoUtil = arquivoUtil;
        this.medicoService = medicoService;
    }

    public DAOMedico(){
    }

    private void mapearObjeto() {
        objectMapper.findAndRegisterModules();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
    }


    public Medico cadastrar(Medico objMedico) throws IOException {
        mapearObjeto();
        if(medicoService.validarMedico(objMedico.getNumeroRegistro())){
            medicosList.add(objMedico);
            arquivoUtil.gravaArquivo(medicosList);
            //    arquivoUtil.gravaQualquerArquivo(Collections.singletonList(medicosList),"medico2.json");
            return objMedico;
        }else {throw new RuntimeException("Medico já cadastrado");}
    }


    public Medico obter(Long numeroRegistro) {
        mapearObjeto();
        try {
            medicosList = arquivoUtil.carregaArquivo("medico.json");
//            medicosList.add((Medico) arquivoUtil.carregaQualquerArquivo("medico2.json"));

            for (Medico medico : medicosList) {
                if (medico.getNumeroRegistro() == (numeroRegistro)) {
                    return medico;
                }
            }throw new RuntimeException("Médico não encontrado");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public Medico editar(Medico objMedico) {
        mapearObjeto();
        try {
            medicosList = arquivoUtil.carregaArquivo("medico.json");
            for (Medico medico : medicosList) {
                if (medico.getNumeroRegistro() == (objMedico.getNumeroRegistro())) {
                    medicosList.remove(medico);
                    medicosList.add(objMedico);
                    arquivoUtil.gravaArquivo(medicosList);
                    return medico;
                }
            }throw new RuntimeException("Médico não Atualizdo");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Medico> remover(Long numeroRegistro) throws IOException {
        mapearObjeto();
        List<Medico> listConsulta;
        try {
            medicosList = arquivoUtil.carregaArquivo("medico.json");
            for (Medico medico : medicosList) {
                if (medico.getNumeroRegistro() == (numeroRegistro)) {
                    listConsulta = arquivoUtil.carregaArquivo(  "consulta.json");
                    for (Medico consulta : listConsulta) {
                        if (consulta.getNumeroRegistro() == (numeroRegistro)) {
                            throw new RuntimeException("Medico em consulta, ele não pode ser deletado!");
                        }
                    }  medicosList.remove(medico);
                    arquivoUtil.gravaArquivo(medicosList);
                    arquivoUtil.gravaQualquerArquivo(Collections.singletonList(medicosList),"medico2.json");
                    throw new RuntimeException("Medico deletado!");
                }
            }throw new RuntimeException("Medico não cadastrado!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}