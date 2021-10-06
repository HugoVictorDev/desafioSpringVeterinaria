package com.meli.desafiospringveterinaria.persistence;

import com.meli.desafiospringveterinaria.model.ProprietarioAnimal;
import com.meli.desafiospringveterinaria.model.RespostaBase;

import java.io.IOException;

public interface IntefaceProprietarioService<P> {
    ProprietarioAnimal obterPorIdentificador(String Identificador) throws IOException;
    ProprietarioAnimal cadastrarProprietario(ProprietarioAnimal proprietario);
    RespostaBase atualizarProprietario(ProprietarioAnimal proprietario, ProprietarioAnimal propriet);
    RespostaBase listagemConsulta();

}

