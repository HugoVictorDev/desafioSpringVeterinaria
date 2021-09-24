package com.meli.desafiospringveterinaria.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.desafiospringveterinaria.ArquivoUtil.ArquivoUtil;
import com.meli.desafiospringveterinaria.model.Consulta;
import com.meli.desafiospringveterinaria.persistence.Persistivel;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DAOcosulta implements Persistivel<Consulta> {

    List<Consulta> cosultaList = new ArrayList<>();

    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void cadastrar(Consulta consulta) {
        cosultaList.add(consulta);
        ArquivoUtil arquivoUtil = new ArquivoUtil();
        arquivoUtil.gravaArquivoConsulta(cosultaList);
    }

    @Override
    public void editar(Consulta obj) {

    }

    @Override
    public void obter(Consulta obj) {}


    @Override
    public List<Consulta> listagem() {
        return null;
    }


    public List<Consulta> consultarMedico(String nome) {
        try {
            cosultaList = objectMapper.readValue(new File("consulta.json"), new TypeReference<List<Consulta>>(){});
            for (Consulta cosulta : cosultaList){
                if (cosulta.getMedico().getNomeMedico().equals(nome)) {
                    listagem().add((Consulta) cosultaList);
                    return listagem();
                }
            }throw new RuntimeException("Não há consultas para esse Médico");
        }catch (IOException e){
            e.printStackTrace();
        }return null;
    }
}
