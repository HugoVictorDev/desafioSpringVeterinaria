package com.meli.desafiospringveterinaria.persistence;

import com.meli.desafiospringveterinaria.model.Animal;

import java.util.List;

public interface Persistivel<T> {

    void cadastrar(T obj);
    Animal editar(T obj);
    void obter(T obj);
    List<T> listagem();

}
