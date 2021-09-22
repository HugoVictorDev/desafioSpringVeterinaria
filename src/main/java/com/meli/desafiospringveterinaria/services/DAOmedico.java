package com.meli.desafiospringveterinaria.services;


import com.meli.desafiospringveterinaria.model.Medico;
import com.meli.desafiospringveterinaria.persistence.Persistivel;
import lombok.Getter;

import java.util.List;

@Getter
public class DAOmedico implements Persistivel<Medico> {


    @Override
    public void cadastrar(Medico obj) {

    }

    @Override
    public void editar(Medico obj) {

    }

    @Override
    public void obeter(Medico obj) {

    }

    @Override
    public List<Medico> listagem() {
        return null;
    }
}