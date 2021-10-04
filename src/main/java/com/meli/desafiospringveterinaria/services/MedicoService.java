package com.meli.desafiospringveterinaria.services;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.desafiospringveterinaria.arquivoUtil.ArquivoUtil;

import com.meli.desafiospringveterinaria.model.Medico;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MedicoService {

    ObjectMapper objectMapper = new ObjectMapper();
    ArquivoUtil arquivoUtil;

    List<Medico> medicosList = new ArrayList<>();

    private void mapearObjeto() {
        objectMapper.findAndRegisterModules();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
    }

    public boolean validarMedico(long registroMedico) throws IOException {
        mapearObjeto();
        try {
            medicosList = arquivoUtil.carregaArquivo("medico.json");
            for (Medico medico : medicosList){
                if (medico.getNumeroRegistro() == (registroMedico)) {
                    return false;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }return true;
    }



}
