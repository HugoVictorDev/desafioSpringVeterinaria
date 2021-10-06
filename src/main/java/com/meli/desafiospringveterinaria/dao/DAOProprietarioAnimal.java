package com.meli.desafiospringveterinaria.dao;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.desafiospringveterinaria.model.ProprietarioAnimal;
import com.meli.desafiospringveterinaria.model.RespostaBase;
import com.meli.desafiospringveterinaria.persistence.IntefaceProprietarioService;
import com.meli.desafiospringveterinaria.arquivoUtil.ArquivoUtil;
import com.meli.desafiospringveterinaria.services.ProprietarioService;
import lombok.Getter;

import java.io.IOException;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
public class DAOProprietarioAnimal implements IntefaceProprietarioService<ProprietarioAnimal> {

    ObjectMapper objectMapper = new ObjectMapper();
    ArquivoUtil arquivoUtil = new ArquivoUtil();
    ProprietarioService  proprietarioService;


    List<ProprietarioAnimal> proprietarioAnimalList;

    public DAOProprietarioAnimal(ArquivoUtil arquivoUtil){this.arquivoUtil = arquivoUtil;}
    public DAOProprietarioAnimal(ProprietarioService proprietarioService){this.proprietarioService = proprietarioService;}


    public DAOProprietarioAnimal(ArquivoUtil arquivoUtil, ProprietarioService proprietarioService){
        this.arquivoUtil = arquivoUtil;
        this.proprietarioService = proprietarioService;
    }
    public DAOProprietarioAnimal() {

    }

    private void mapearObjeto() {
        objectMapper.findAndRegisterModules();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
    }

    public ProprietarioAnimal cadastrarProprietario(ProprietarioAnimal obj) { // OK

        this.proprietarioAnimalList.add(obj);

        try {
            arquivoUtil.gravaQualquerArquivo(Collections.singletonList(proprietarioAnimalList), "Proprietarios.json");
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
        return obj;
    }

    public RespostaBase atualizarProprietario(ProprietarioAnimal proprietario, ProprietarioAnimal propriet) {
        return null;
    }

    public RespostaBase listagemConsulta() {
        return null;
    }

    public ProprietarioAnimal editar(ProprietarioAnimal obj) {
        return null;
    }


    public ProprietarioAnimal editar(ProprietarioAnimal obj, ProprietarioAnimal obj2) throws IOException { // Edenilson - Correcao de parametros



        proprietarioAnimalList = arquivoUtil.metodoCarregaArquivo("Proprietario.json");
        for (ProprietarioAnimal proprietarioAnimal : proprietarioAnimalList) {
            if (proprietarioAnimal.getCpf().equals(obj.getCpf())) {
                proprietarioAnimalList.remove(proprietarioAnimal);
                proprietarioAnimalList.add(obj2);
                arquivoUtil.gravaQualquerArquivo(Collections.singletonList((List<ProprietarioAnimal>) proprietarioAnimalList), "Proprietarios.json");
                return obj2;
            }
        }

        return null;
    }


    public ProprietarioAnimal obter(ProprietarioAnimal obj) {
        if (proprietarioAnimalList == null) {
            return null;
        }

        try {
            for (ProprietarioAnimal proprietarioAnimal : proprietarioAnimalList) {
                if (proprietarioAnimal.getCpf().equals(obj.getCpf())) {
                    return proprietarioAnimal;
                }
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return null;
    }


    public ProprietarioAnimal obterProprietarioAnimal(ProprietarioAnimal obj) throws IOException {

        proprietarioAnimalList =arquivoUtil.metodoCarregaArquivo("Proprietario.json");
        if (proprietarioAnimalList == null) {
            return null;
        }

        try {
            for (ProprietarioAnimal proprietarioAnimal : proprietarioAnimalList) {
                if (proprietarioAnimal.getCpf().equals(obj.getCpf())) {
                    return proprietarioAnimal;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }



    public ProprietarioAnimal obterPorIdentificador(String identificador) {
        if (proprietarioAnimalList == null) {
            return null;
        }

        try {
            for (ProprietarioAnimal proprietarioAnimal : proprietarioAnimalList) {
                if (proprietarioAnimal.getCpf().equals(identificador)) {
                    return proprietarioAnimal;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }



    public List<ProprietarioAnimal> listagem() {
        return proprietarioAnimalList;
    }
}