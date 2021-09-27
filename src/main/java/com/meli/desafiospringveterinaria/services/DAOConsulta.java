package com.meli.desafiospringveterinaria.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;
import com.meli.desafiospringveterinaria.model.Animal;
import com.meli.desafiospringveterinaria.model.Consulta;
import com.meli.desafiospringveterinaria.persistence.Persistivel;
import lombok.SneakyThrows;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class DAOConsulta implements Persistivel<Consulta> {

    List<Consulta> consultaList = new ArrayList<>();

    ObjectMapper objectMapper = new ObjectMapper();
    private void mapearObjeto() {
        objectMapper.findAndRegisterModules();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
    }

    @Override
    public void cadastrar(Consulta consulta) {
        mapearObjeto();
        consultaList.add(consulta);
        try {
            objectMapper.writeValue(new File("consulta.json"), consultaList);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void editar(Consulta obj) {
    }

    @Override
    public void obter(Consulta obj) {

    }


    public Consulta editarConsulta (Consulta objConsulta) {
        mapearObjeto();
        try {
            consultaList = objectMapper.readValue(new File("consulta.json"), new TypeReference<List<Consulta>>(){});
            for (Consulta consulta : consultaList){
                if (consulta.getAnimal().getNome().equals(objConsulta.getAnimal().getNome())) {
                    consultaList.remove(consulta);
                    consultaList.add(objConsulta);
                    objectMapper.writeValue(new File("consulta.json"), consultaList);
                   return consulta;
                }
            }throw new RuntimeException("Consulta não encotrada");
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }


    public Consulta consultarMedico(String nome) {
        mapearObjeto();
        try {
            consultaList = objectMapper.readValue(new File("consulta.json"), new TypeReference<List<Consulta>>(){});
            for (Consulta cosulta : consultaList){
                if (cosulta.getMedico().getNomeMedico().equals(nome)) {
                    return cosulta;
                }
            }throw new RuntimeException("Não há consultas para esse Médico");
        }catch (IOException e){
            e.printStackTrace();
        }return null;
    }

    @SneakyThrows
    public List<Consulta> listagemMedicoConsulta(String cpfDoMedico) {
        mapearObjeto();
        consultaList = objectMapper.readValue(new File("consulta.json"), new TypeReference<List<Consulta>>(){});
        return consultaList.stream().filter(consulta -> consulta.getMedico().getCpfMedico().equals(cpfDoMedico)).collect(Collectors.toList());
    }

    public List<Consulta> pacienteConsulta(int numeroPaciente) {
        mapearObjeto();
        List<Consulta >listConsulta = new ArrayList<>();
        try {
            consultaList = objectMapper.readValue(new File("consulta.json"), new TypeReference<List<Consulta>>(){});
            for (Consulta consulta : consultaList){
                if (consulta.getAnimal().getNumeroDoPaciente().equals(numeroPaciente)) {
                  listConsulta.add(consulta);
                }
            } if(listConsulta.size() == 0){
                 throw new RuntimeException("Não há consultas para esse paciente");
            }else return listConsulta;
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

    @SneakyThrows
    public List<Consulta> listagem2(String data) {

        mapearObjeto();
        consultaList = objectMapper.readValue(new File("consulta.json"), new TypeReference<List<Consulta>>() {
        });
        return consultaList.stream().filter(consulta -> consulta.getDataHora().toString()
                .equals(data)).sorted(Comparator.comparing(lista -> lista.getDataHora()))
                .collect(Collectors.toList());
    }


    @Override
    public List<Consulta> listagem() {return null;}


}
