package com.meli.desafiospringveterinaria.persistence;

import com.meli.desafiospringveterinaria.ArquivoUtil.ArquivoUtil;
import com.meli.desafiospringveterinaria.model.Medico;

import java.util.ArrayList;
import java.util.List;

public class Persistence {

    private static List<Medico> medicos = new ArrayList<>();

    public void cadastro(Medico medico){
        medicos.add(medico);
        ArquivoUtil arquivoUtil = new ArquivoUtil();
        arquivoUtil.gravaArquivo(medicos);
    }

    public List<Medico> listagem(){
        return medicos;
    }

}
