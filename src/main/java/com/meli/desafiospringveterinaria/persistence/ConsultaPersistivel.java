package com.meli.desafiospringveterinaria.persistence;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.util.List;


public class ConsultaPersistivel {

    public interface Persistivel<T> {

        void cadastrar(T obj);
        void editar(T obj);
        void obter(T obj);
        List<T> listagem();

    }



}
