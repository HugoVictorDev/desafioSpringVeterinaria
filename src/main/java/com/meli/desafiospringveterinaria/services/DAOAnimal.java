package com.meli.desafiospringveterinaria.services;

import com.meli.desafiospringveterinaria.model.Animal;
import com.meli.desafiospringveterinaria.persistence.Persistivel;

import java.util.ArrayList;
import java.util.List;

public class DAOAnimal implements Persistivel<Animal> {

    List<Animal> listaAnimal = new ArrayList<>();

    @Override
    public void cadastrar(Animal objAnimal) {
        if (validaAnimal(objAnimal.getNumeroDoPaciente())){
            listaAnimal.add(objAnimal);
        } else {
            throw new RuntimeException("Animal já cadastrado.");
        }
    }

    @Override
    public void editar(Animal obj) {

    }

    @Override
    public Animal obter(Animal obj) {
        return obj;
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