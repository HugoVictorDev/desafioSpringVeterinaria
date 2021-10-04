package com.meli.desafiospringveterinaria.persistence;

import com.meli.desafiospringveterinaria.model.Animal;
import com.meli.desafiospringveterinaria.model.ProprietarioAnimal;

import java.util.List;

public interface Persistivel<T> {
    T cadastrar(T obj);
    T editar(T obj);
    T obter(T obj);
    List<T> listagem();


//    T obterPorIdentificador(String identificador);
}