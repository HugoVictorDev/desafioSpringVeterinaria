package com.meli.desafiospringveterinaria.services;


import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.desafiospringveterinaria.ArquivoUtil.ArquivoUtil;
import com.meli.desafiospringveterinaria.model.Animal;
import com.meli.desafiospringveterinaria.model.ProprietarioAnimal;
import com.meli.desafiospringveterinaria.persistence.Persistivel;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ProprietarioService {

    private static ArquivoUtil arquivoUtil;
    List<ProprietarioAnimal> proprietarioAnimalList;

    @Override
    //Alterar para retornar objeto proprietarioAnimal
    public Animal cadastrar(ProprietarioAnimal proprietarioAnimal) {

        try {
            this.proprietarioAnimalList.add(proprietarioAnimal);
            arquivoUtil.gravaArquivo(Collections.singletonList(proprietarioAnimalList),"Proprietarios.json");
            //objectMapper.writeValue(new File(), );
            return proprietarioAnimal.getAnimal();

        } catch (Exception exception) {
            System.out.println("Proprietario cadastrado");
            throw new RuntimeException("Erro no momento de cadastrar o proprietario");
        }

    }

    @Override
    public void editar(ProprietarioAnimal obj) {
    }

    @Override
    public void obter(ProprietarioAnimal obj) {

    }


    public static ProprietarioAnimal edita(ProprietarioAnimal obj, ProprietarioAnimal obj2) throws IOException {

        List<ProprietarioAnimal> proprietarioAnimalList = new ArrayList<>();
        //proprietarioAnimalList;
        proprietarioAnimalList.add((ProprietarioAnimal) arquivoUtil.carregaArquivo("Proprietarios.json"));

        for (ProprietarioAnimal proprietarioAnimal : proprietarioAnimalList) {
            if (proprietarioAnimal.getCpf().equals(obj.getCpf())) {
                proprietarioAnimalList.remove(proprietarioAnimal);
                proprietarioAnimalList.add(obj2);
                proprietarioAnimalList.add(proprietarioAnimal);

                return proprietarioAnimal;
            }
        }

        return null;
    }


    //public ProprietarioAnimal obterAnimal(ProprietarioAnimal obj) {
    public static Animal obterAnimal(String cpfMedico) throws IOException {


        List<ProprietarioAnimal> proprietarioAnimalList = new ArrayList<>();
        //proprietarioAnimalList;
        proprietarioAnimalList.add((ProprietarioAnimal) arquivoUtil.carregaArquivo("Proprietarios.json"));

        if (proprietarioAnimalList == null) {
            return null;
        }

        try {
            for (ProprietarioAnimal proprietarioAnimal : proprietarioAnimalList) {
                if (proprietarioAnimal.getCpf().equals(cpfMedico)){//obj.getCpf())) {
                    return proprietarioAnimal.getAnimal();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public ProprietarioAnimal obterPorIdentificador(String identificador) {

    }

    @Override
    public List<ProprietarioAnimal> listagem() {
        return proprietarioAnimalList;
    }


    @SneakyThrows
    public List<ProprietarioAnimal> listagemConsulta(){
        mapearObjeto();
        proprietarioAnimalList = objectMapper.readValue(new File("Proprietarios.json"), new TypeReference<List<ProprietarioAnimal>>(){});
        return proprietarioAnimalList;
    }
}
