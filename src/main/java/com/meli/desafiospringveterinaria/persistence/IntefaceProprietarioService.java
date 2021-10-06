package com.meli.desafiospringveterinaria.persistence;

import com.meli.desafiospringveterinaria.model.ProprietarioAnimal;
import com.meli.desafiospringveterinaria.model.RespostaBase;

public interface IntefaceProprietarioService<P> {
    ProprietarioAnimal obterPorIdentificador(String Identificador);
    ProprietarioAnimal cadastrarProprietario(ProprietarioAnimal proprietario);
    RespostaBase atualizarProprietario(ProprietarioAnimal proprietario, ProprietarioAnimal propriet);
    RespostaBase listagemConsulta();

}

