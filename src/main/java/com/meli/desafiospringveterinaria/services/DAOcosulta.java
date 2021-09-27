package com.meli.desafiospringveterinaria.services;

import com.meli.desafiospringveterinaria.model.Animal;
import com.meli.desafiospringveterinaria.model.Cosulta;
import com.meli.desafiospringveterinaria.persistence.Persistivel;
import java.util.List;

public class DAOcosulta implements Persistivel<Cosulta> {


    @Override
    public void cadastrar(Cosulta obj) {

    }

    @Override
    public Animal editar(Cosulta obj) {
        return null;
    }

    @Override
    public void obter(Cosulta obj) {

    }

    @Override
    public List<Cosulta> listagem() {
        return null;
    }
}
