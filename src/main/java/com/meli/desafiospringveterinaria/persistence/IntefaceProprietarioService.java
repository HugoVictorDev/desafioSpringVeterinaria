package com.meli.desafiospringveterinaria.persistence;

import com.meli.desafiospringveterinaria.model.ProprietarioAnimal;
import com.meli.desafiospringveterinaria.model.RespostaBase;

import java.io.IOException;
import java.util.List;

public interface IntefaceProprietarioService<P> {
    List<ProprietarioAnimal> removerProprietario (ProprietarioAnimal proprietarioAnimal) throws IOException;
    ProprietarioAnimal obterPorIdentificador(String Identificador) throws IOException;
    ProprietarioAnimal cadastrarProprietario(ProprietarioAnimal proprietario);
    RespostaBase atualizarProprietario(ProprietarioAnimal proprietario, ProprietarioAnimal propriet);
    RespostaBase listagemConsulta();

}

