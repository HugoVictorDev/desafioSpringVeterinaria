package com.meli.desafiospringveterinaria.dao;

import com.meli.desafiospringveterinaria.model.ProprietarioAnimal;

import java.io.IOException;
import java.util.List;

public interface InterfaceProprietarioAnimal {
    /*    ObjectMapper objectMapper;


            private void mapearObjeto() {
                objectMapper.findAndRegisterModules();
                objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            }
        */
    //  com.meli.desafiospringveterinaria.ArquivoUtil.ArquivoUtil
    void DAOProprietarioAnimal();

    ProprietarioAnimal cadastrar(ProprietarioAnimal obj);

    ProprietarioAnimal editar(ProprietarioAnimal obj);

    ProprietarioAnimal editar(ProprietarioAnimal obj, ProprietarioAnimal obj2) throws IOException;

    ProprietarioAnimal obter(ProprietarioAnimal obj);

    ProprietarioAnimal obterProprietarioAnimal(ProprietarioAnimal obj);

    ProprietarioAnimal obterPorIdentificador(String identificador);

    List<ProprietarioAnimal> listagem();
}
