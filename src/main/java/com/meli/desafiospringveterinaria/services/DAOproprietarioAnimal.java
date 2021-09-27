package com.meli.desafiospringveterinaria.services;

import com.meli.desafiospringveterinaria.model.Animal;
import com.meli.desafiospringveterinaria.model.ProprietarioAnimal;
import com.meli.desafiospringveterinaria.persistence.Persistivel;


import java.util.List;

public class DAOproprietarioAnimal implements Persistivel<ProprietarioAnimal> {


    @Override
    public void cadastrar(ProprietarioAnimal obj) {

    }

    @Override
    public Animal editar(ProprietarioAnimal obj) {
        return null;
    }

    @Override
    public void obter(ProprietarioAnimal obj) {

    }

    @Override
    public List<ProprietarioAnimal> listagem() {
        return null;
    }
}

