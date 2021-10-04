package com.meli.desafiospringveterinaria.dao;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.desafiospringveterinaria.arquivoutil.InterfaceAquivoUtil;
import com.meli.desafiospringveterinaria.model.Animal;
import com.meli.desafiospringveterinaria.model.ProprietarioAnimal;
import com.meli.desafiospringveterinaria.persistence.Persistivel;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.SneakyThrows;

import java.io.File;
import java.io.IOException;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DAOProprietarioAnimal implements Persistivel<ProprietarioAnimal>, InterfaceProprietarioAnimal {

    InterfaceAquivoUtil iAquivoUtil;

    List<ProprietarioAnimal> proprietarioAnimalList;
/*    ObjectMapper objectMapper;


    private void mapearObjeto() {
        objectMapper.findAndRegisterModules();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
    }
*/
  //  com.meli.desafiospringveterinaria.ArquivoUtil.ArquivoUtil
    @Override
    public void DAOProprietarioAnimal() {
//        objectMapper = new ObjectMapper();
//        mapearObjeto();

        List<ProprietarioAnimal> proprietarioAnimalList = new ArrayList<ProprietarioAnimal>();
        try {
            // Carregando a lista com o arquivo existente
            proprietarioAnimalList = (List<ProprietarioAnimal>) iAquivoUtil.carregaArquivo("Proprietarios.json", proprietarioAnimalList);
        } catch (RuntimeException exception) { }

        if (proprietarioAnimalList == null)
            proprietarioAnimalList = new ArrayList<ProprietarioAnimal>();
    }

    @Override
<<<<<<< HEAD
    public void cadastrar(ProprietarioAnimal obj) {
=======
    public ProprietarioAnimal cadastrar(ProprietarioAnimal obj) {
>>>>>>> 35da861b5219956d0996adbfc20a75adfa3b9179
        this.proprietarioAnimalList.add(obj);

        try {
            iAquivoUtil.gravaArquivo(Collections.singletonList((List<ProprietarioAnimal>) proprietarioAnimalList), "Proprietarios.json");
        } catch (Exception exception) {
            String erro = exception.toString();
        }

    }

    @Override
    public ProprietarioAnimal editar(ProprietarioAnimal obj) {
        return null;
    }

    @Override
    public ProprietarioAnimal editar(ProprietarioAnimal obj, ProprietarioAnimal obj2) throws IOException { // Edenilson - Correcao de parametros
        for (ProprietarioAnimal proprietarioAnimal : proprietarioAnimalList) {
            if (proprietarioAnimal.getCpf().equals(obj.getCpf())) {
                proprietarioAnimalList.remove(proprietarioAnimal);
                proprietarioAnimalList.add(obj2);
                iAquivoUtil.gravaArquivo(Collections.singletonList((List<ProprietarioAnimal>) proprietarioAnimalList), "Proprietarios.json");
                return obj2;
            }
        }

        return null;
    }

    @Override
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

    @Override
    public ProprietarioAnimal obterProprietarioAnimal(ProprietarioAnimal obj) {
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


    @Override
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

    @Override
    public List<ProprietarioAnimal> listagem() {
        return proprietarioAnimalList;
    }
}