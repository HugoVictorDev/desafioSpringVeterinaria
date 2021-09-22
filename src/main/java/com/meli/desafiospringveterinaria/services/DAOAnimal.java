package com.meli.desafiospringveterinaria.services;

import com.meli.desafiospringveterinaria.model.Animal;
import com.meli.desafiospringveterinaria.persistence.Persistivel;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DAOAnimal implements Persistivel<Animal> {

    @Override
    public void cadastrar(Animal objeto) {

    }

    @Override
    public void editar(Animal obejto) {

    }

    @Override
    public List<Animal> listagem() {
        return null;
    }
}