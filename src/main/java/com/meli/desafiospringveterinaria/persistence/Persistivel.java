package com.meli.desafiospringveterinaria.persistence;

import java.util.List;

public interface Persistivel<T> {

    void cadastrar(T objeto);
    void editar(T obejto);
    List<T> listagem();

}
