package com.meli.desafiospringveterinaria.persistence;

import java.util.List;

public interface Persistivel<T> {

    void cadastrar(T obj);
    void editar(T obj);
    void obeter(T obj);
    List<T> listagem();

}
