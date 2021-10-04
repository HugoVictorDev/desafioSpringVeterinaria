package com.meli.desafiospringveterinaria.persistence;

import com.meli.desafiospringveterinaria.model.Medico;

import java.io.IOException;
import java.util.List;

public interface MedicoPersistivel<T> {

    Medico cadastrar(T obj) throws IOException;
    Medico editar(T obj);

}
