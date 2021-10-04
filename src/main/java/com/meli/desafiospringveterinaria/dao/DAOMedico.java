package com.meli.desafiospringveterinaria.dao;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.desafiospringveterinaria.arquivoutil.ArquivoUtil;
import com.meli.desafiospringveterinaria.model.Consulta;
import com.meli.desafiospringveterinaria.model.Medico;
import com.meli.desafiospringveterinaria.persistence.MedicoPersistivel;

import com.meli.desafiospringveterinaria.services.MedicoService;
import lombok.Getter;
import lombok.SneakyThrows;

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


<<<<<<< HEAD
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

=======
    public Medico cadastrar(Medico objMedico) throws IOException {
        mapearObjeto();
        if(medicoService.validarMedico(objMedico.getNumeroRegistro())){
            medicosList.add(objMedico);
            arquivoUtil.gravaArquivo(medicosList);
        //    arquivoUtil.gravaQualquerArquivo(Collections.singletonList(medicosList),"medico2.json");
            return objMedico;
            }else {throw new RuntimeException("Medico já cadastrado");}
>>>>>>> 35da861b5219956d0996adbfc20a75adfa3b9179
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
        List<Consulta> listConsulta;
        try {
            medicosList = arquivoUtil.carregaArquivo("medico.json");
            for (Medico medico : medicosList) {
                if (medico.getNumeroRegistro() == (numeroRegistro)) {
                    listConsulta = arquivoUtil.carregaArquivoConsulta(  "consulta.json");
                    for (Consulta consulta : listConsulta) {
                        if (consulta.getMedico().getNumeroRegistro() == (numeroRegistro)) {
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