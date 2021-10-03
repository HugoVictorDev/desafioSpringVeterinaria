package com.meli.desafiospringveterinaria.persistence;

import com.meli.desafiospringveterinaria.model.ProprietarioAnimal;
import com.meli.desafiospringveterinaria.model.RespostaBase;

public interface IntefaceProprietarioService {
    RespostaBase obterPorIdentificador(String Identificador);
    RespostaBase cadastrarProprietario(ProprietarioAnimal proprietario);
    RespostaBase atualizarProprietario(ProprietarioAnimal proprietario, ProprietarioAnimal propriet);
    RespostaBase listagemConsulta();

}

