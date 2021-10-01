package com.meli.desafiospringveterinaria.services;

import com.meli.desafiospringveterinaria.model.Animal;
import com.meli.desafiospringveterinaria.model.ProprietarioAnimal;
import com.meli.desafiospringveterinaria.persistence.Persistivel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Service
public class DAOProprietarioAnimal implements Persistivel<ProprietarioAnimal> {

    @Autowired
    private IntefaceProprietarioService intefaceProprietarioService;


    //ObjectMapper objectMapper;



    public DAOProprietarioAnimal() {
        ProprietarioService proprietarioService = new ProprietarioService();
        List<ProprietarioAnimal> proprietarioAnimalList;
        try {
            proprietarioAnimalList =  intefaceProprietarioService.listagem();//objectMapper.readValue(new File("Proprietarios.json"), new TypeReference<List<ProprietarioAnimal>>() {
            if (proprietarioAnimalList == null)
                throw new RuntimeException("Sem Proprietário na Lista");

        } catch (Exception exception) {
            String a = "";
        }


    }

    @Override
    public Animal cadastrar(ProprietarioAnimal obj) {
        return null;
    }

    @Override
    public void editar(ProprietarioAnimal obj) {

    }

    @Override
    public void obter(ProprietarioAnimal obj) {

    }

    @Override
    public List<ProprietarioAnimal> listagem() {
        return null;
    }

    public ProprietarioAnimal obterPorIdentificador(String cpf) {
        ArrayList<ProprietarioAnimal> proprietarioAnimalList = new ArrayList<>();

        try {
            proprietarioAnimalList.add(IntefaceProprietarioService.obterPorIdentificador(cpf));
        }catch (ParseException p){
            p.printStackTrace();
        }

        if (proprietarioAnimalList == null) {
            return null;
        }

        try {
            for (ProprietarioAnimal proprietarioAnimal : proprietarioAnimalList) {
                if (proprietarioAnimal.getCpf().equals(cpf)) {
                    return proprietarioAnimal;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

