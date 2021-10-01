package com.meli.desafiospringveterinaria.services;


import com.meli.desafiospringveterinaria.ArquivoUtil.ArquivoUtil;
import com.meli.desafiospringveterinaria.model.Animal;
import com.meli.desafiospringveterinaria.model.ProprietarioAnimal;
import lombok.SneakyThrows;

import java.io.IOException;


import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ProprietarioService implements IntefaceProprietarioService {

    private static ArquivoUtil arquivoUtil;
    List<ProprietarioAnimal> proprietarioAnimalList;


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


    public void editar(ProprietarioAnimal obj) {
    }


    public void obter(ProprietarioAnimal obj) {

    }



    public ProprietarioAnimal obterPorIdentificador(String identificador) throws ParseException {
        List<ProprietarioAnimal> proprietarioAnimalList = new ArrayList<>();
        ProprietarioAnimal proprietarioAnimal = new ProprietarioAnimal();

        try {
            proprietarioAnimalList.add((ProprietarioAnimal) arquivoUtil.carregaArquivo("Proprietarios.json"));
        }catch (IOException e){

        }

        proprietarioAnimalList.stream().filter(p -> p.getProprietario().equals(identificador));

        for (ProprietarioAnimal p : proprietarioAnimalList) {
            if (proprietarioAnimal.getProprietario() != null){
                return p;
            }
        }
       return null;
    }
}


    public List<ProprietarioAnimal> listagem() throws IOException {
        List<ProprietarioAnimal> proprietarioAnimalList = new ArrayList<>();

        proprietarioAnimalList.add((ProprietarioAnimal) arquivoUtil.carregaArquivo("Proprietarios.json"));
        return proprietarioAnimalList;
    }


    public List<ProprietarioAnimal> listagemConsulta(){

    }
}
