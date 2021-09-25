package com.meli.desafiospringveterinaria.services;

import com.meli.desafiospringveterinaria.ArquivoUtil.ArquivoUtil;
import com.meli.desafiospringveterinaria.model.Animal;
import com.meli.desafiospringveterinaria.persistence.Persistivel;

import java.util.ArrayList;
import java.util.List;

public class DAOAnimal implements Persistivel<Animal> {

    List<Animal> listaAnimal = new ArrayList<>();
    ArquivoUtil arquivoUtil = new ArquivoUtil();

    @Override
    public void cadastrar(Animal objAnimal) {
        if (validaAnimal(objAnimal.getNumeroDoPaciente())){
            listaAnimal.add(objAnimal);
            arquivoUtil.gravarAnimal(listaAnimal);
        } else {
            throw new RuntimeException("Animal já cadastrado.");
        }
    }

    @Override
    public void editar(Animal obj) {

    }

    @Override
    public void obter(Animal obj) {

    }

    @Override
    public List<Animal> listagem() {
        return listaAnimal;
    }

    // validando se animal existe
    private boolean validaAnimal(Integer numeroAnimal){
        for(Animal animal: listagem()){
            if (animal.getNumeroDoPaciente() == (numeroAnimal)){
                return false;
            }
        }
        return true;
    }


}