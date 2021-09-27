package com.meli.desafiospringveterinaria.persistence;

import com.meli.desafiospringveterinaria.model.ProprietarioAnimal;

import java.util.List;

public interface Persistivel<T> {

    void cadastrar(T obj);
    ProprietarioAnimal editar(T obj);
    ProprietarioAnimal obter(T obj);
    List<T> listagem();

    T obterPorIdentificador(String identificador);
}
