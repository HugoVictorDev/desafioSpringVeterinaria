package com.meli.desafiospringveterinaria.arquivoutil;

import com.meli.desafiospringveterinaria.model.ProprietarioAnimal;
import com.meli.desafiospringveterinaria.model.RespostaBase;

import java.util.List;

public interface InterfaceAquivoUtil {
        void mapearObjeto();
        RespostaBase carregaArquivo(String nomeArquivo, List<ProprietarioAnimal> proprietarioAnimalList);
        void gravaArquivo(List<Object> List, String nomeArquivo);
}
