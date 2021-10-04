package com.meli.desafiospringveterinaria.services;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.desafiospringveterinaria.arquivoutil.ArquivoUtil;
import com.meli.desafiospringveterinaria.model.Medico;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MedicoService {

    ObjectMapper objectMapper = new ObjectMapper();
    ArquivoUtil arquivoUtil = new ArquivoUtil();

    List<Medico> medicosListService = new ArrayList<>();

    public MedicoService(ArquivoUtil arquivoUtil) {
        this.arquivoUtil = arquivoUtil;
    }

    public MedicoService() {
    }

    private void mapearObjeto() {
        objectMapper.findAndRegisterModules();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
    }


    public List validarMedico(long registroMedico) throws IOException {
        mapearObjeto();
        try {
            medicosListService = arquivoUtil.carregaArquivo("medico.json");
            if(medicosListService.size() == 0){
                return medicosListService;
            }else{
                for (Medico medico : medicosListService){
                    if (medico.getNumeroRegistro() == (registroMedico)) {
                        throw new RuntimeException("Medico já cadastrado");
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }return medicosListService;
    }
}
