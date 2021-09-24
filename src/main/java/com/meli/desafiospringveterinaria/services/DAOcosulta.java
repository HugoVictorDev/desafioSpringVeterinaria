package com.meli.desafiospringveterinaria.services;

import com.meli.desafiospringveterinaria.model.Consulta;
import com.meli.desafiospringveterinaria.persistence.Persistivel;
import java.util.List;

public class DAOcosulta implements Persistivel<Consulta> {


    @Override
    public void cadastrar(Consulta obj) {

    }

    @Override
    public Consulta editar(Consulta obj) {
        return null;
    }

    @Override
    public Consulta obter(Consulta obj) {
        return obj;
    }

    @Override
    public Consulta obterPorIdentificador(String identificador){
        return null;
    }


    @Override
    public List<Consulta> listagem() {
        return null;
    }


}