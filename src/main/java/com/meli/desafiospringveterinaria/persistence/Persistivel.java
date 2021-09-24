package com.meli.desafiospringveterinaria.persistence;

import java.util.List;

public interface Persistivel<T> {

    void cadastrar(T obj);
    T editar(T obj);
    T obter(T obj);
    T obterPorIdentificador(String identificador);
    List<T> listagem();

}
