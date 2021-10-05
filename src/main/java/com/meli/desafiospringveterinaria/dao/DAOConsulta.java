package com.meli.desafiospringveterinaria.dao;

import com.fasterxml.jackson.core.type.TypeReference;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.desafiospringveterinaria.arquivoUtil.ArquivoUtil;
import com.meli.desafiospringveterinaria.model.Consulta;
import com.meli.desafiospringveterinaria.model.Medico;
import com.meli.desafiospringveterinaria.persistence.ConsultaPersistivel;

import com.meli.desafiospringveterinaria.services.ConsultaService;
import com.meli.desafiospringveterinaria.services.MedicoService;
import lombok.Getter;
import lombok.SneakyThrows;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class DAOConsulta extends ConsultaPersistivel {

    List<Consulta> consultaList = new ArrayList<>();
    ConsultaService consultaService = new ConsultaService();
    ObjectMapper objectMapper = new ObjectMapper();
    ArquivoUtil arquivoUtil = new ArquivoUtil();
    List<Consulta> consultaList2 = new ArrayList<>();


    //Gestão de dependencia
    public DAOConsulta(ArquivoUtil arquivoUtil){
        this.arquivoUtil = arquivoUtil;
    }
    public DAOConsulta(ConsultaService consultaService){
        this.consultaService = consultaService;
    }

    public DAOConsulta(ArquivoUtil arquivoUtil, ConsultaService consultaService){
        this.arquivoUtil = arquivoUtil;
        this.consultaService = consultaService;
    }

    public DAOConsulta(){
    }





    public Consulta cadastrar(Consulta consulta) throws IOException {
        consultaService.mapearObjeto();


        consultaList.add(consulta);

        try {
            if(consultaService.validarConsulta(consulta.getAnimal().getNome())){
                consultaList.add(consulta);
                consultaService.objectMapper.writeValue(new File("consulta.json"), consultaList);
            }else{throw new RuntimeException("Consutada já cadastrada");
            }

        } catch (IOException e){
            e.printStackTrace();
        }


        return consulta;
    }


    public Consulta editarConsulta(Consulta objConsulta) {
        consultaService.mapearObjeto();
        try {
            consultaList = arquivoUtil.carregaArquivoConsulta1("consulta.json");
            for (Consulta consulta : consultaList){
                if (consulta.getAnimal().getNome().equals(objConsulta.getAnimal().getNome())) {
                    consultaList.remove(consulta);
                    consultaList.add(objConsulta);
                    arquivoUtil.gravaArquivoConsulta1(consultaList);
                    return consulta;
                }
            }throw new RuntimeException("Consulta não encotrada");
        }catch (IOException e){
            throw new RuntimeException(e);
        }

    }




    @SneakyThrows
    public List<Consulta> listagemMedicoConsulta(String cpfDoMedico) {
        consultaService.mapearObjeto();
        consultaList = consultaService.objectMapper.readValue(new File("consulta.json"), new TypeReference<List<Consulta>>(){});
        return
       consultaList2 = consultaList.stream().filter(consulta -> consulta.getMedico().getCpfMedico().equals(cpfDoMedico)).collect(Collectors.toList());
    }

    public List<Consulta> pacienteConsulta(int numeroPaciente) {
        consultaService.mapearObjeto();
        List<Consulta >listConsulta = new ArrayList<>();
        try {
            consultaList = consultaService.objectMapper.readValue(new File("consulta.json"), new TypeReference<List<Consulta>>(){});
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
    public List<Consulta> listagemPorData(String data) {

        consultaService.mapearObjeto();
        consultaList = arquivoUtil.carregaArquivoConsulta1("consulta.json");
        consultaList2 = consultaList.stream().filter(consulta -> consulta.getDataHora().toString()
                .equals(data)).sorted(Comparator.comparing(lista -> lista.getDataHora()))
                .collect(Collectors.toList());
        return  consultaList2;
    }







}