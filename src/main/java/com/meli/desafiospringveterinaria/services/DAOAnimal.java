package com.meli.desafiospringveterinaria.services;

import com.meli.desafiospringveterinaria.model.Animal;
import com.meli.desafiospringveterinaria.persistence.Persistivel;
import java.util.List;

public class DAOAnimal implements Persistivel<Animal> {

    @Override
    public void cadastrar(Animal objAnimal) {
        if (validaAnimal(objAnimal.getNumeroDoPaciente())){
            cadastrar(objAnimal);
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
        return listagem();
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