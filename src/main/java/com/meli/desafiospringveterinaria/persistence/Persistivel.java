package com.meli.desafiospringveterinaria.persistence;

<<<<<<< HEAD
import java.util.List;


    public interface Persistivel<T> {

        void cadastrar(T obj);
        void editar(T obj);
        void obter(T obj);
        List<T> listagem();

    }
=======
import com.meli.desafiospringveterinaria.model.Animal;
import com.meli.desafiospringveterinaria.model.ProprietarioAnimal;

import java.util.List;

public interface Persistivel<T> {
    T cadastrar(T obj);
    T editar(T obj);
    T obter(T obj);
    List<T> listagem();
>>>>>>> 35da861b5219956d0996adbfc20a75adfa3b9179


