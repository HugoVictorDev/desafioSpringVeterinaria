package com.meli.desafiospringveterinaria.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.meli.desafiospringveterinaria.ArquivoUtil.ArquivoUtil;
import com.meli.desafiospringveterinaria.dao.DAOConsulta;
import com.meli.desafiospringveterinaria.model.Animal;
import com.meli.desafiospringveterinaria.model.Consulta;
import com.meli.desafiospringveterinaria.model.Medico;
import com.meli.desafiospringveterinaria.persistence.Persistivel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.File;
import java.io.IOException;
import java.sql.ClientInfoStatus;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DAOConsultaTest  {

    Consulta consulta = new Consulta();
    DAOConsulta daoConsulta = new DAOConsulta();
     ConsultaService consultaService = new ConsultaService();
     ArquivoUtil arquivoUtil = new ArquivoUtil();

    Consulta consulta1 = new Consulta(LocalDate.of(2021,10,04), "doenca","di","remedio",
            new Medico( "404313928", "hugo", "Victor", 12345, "medico"),
            new Animal(1232323L, "gato", "boaa", "amarelo",LocalDate.of(2021,10,04),"gatin"));

    Consulta consulta2 = new Consulta(LocalDate.of(2021,10,04), "cancer","di","cirurgia",new Medico( "404313928", "hugo", "Victor", 12345, "medico"),
            new Animal(12323234L, "cachorro", "boaa", "amarelo",LocalDate.of(2021,10,04),"gatin"));

    List<Consulta> listDeConsultas = new ArrayList<>();

    String mensagem = "java.io.IOException";
    String mensagemSystem = "";

//-- ----------- tests ------------------------//

    @Test
    public void cadastrandoConsultaOK() throws IOException {

        listDeConsultas.add(consulta1);

        consultaService = Mockito.mock(ConsultaService.class);

        Mockito.when(consultaService.validarConsulta(Mockito.anyString())).thenReturn(false);


        RuntimeException exception = Assertions.assertThrows(RuntimeException.class, ()->
        { daoConsulta.cadastrar(consulta1);});

        mensagem = "Consutada já cadastrada";
        mensagemSystem = exception.getMessage();

        assert (mensagem.contains(mensagemSystem));
    }

    @Test
    public void testCadastrarConsultaNaoOk() throws IOException {
        listDeConsultas.add(consulta);

        consultaService = Mockito.mock(ConsultaService.class);

        Mockito.when(consultaService.validarConsulta(Mockito.anyString())).thenReturn(false);


        RuntimeException exception = Assertions.assertThrows(RuntimeException.class, ()->
        { daoConsulta.cadastrar(consulta2);});

        mensagem = "Consutada já cadastrada";
        mensagemSystem = exception.getMessage();

        assert (mensagem.contains(mensagemSystem));
    }


    //testar editar consulta
    @Test
    public void testarEditarConsulta() throws IOException {

        listDeConsultas.add(consulta2);

        arquivoUtil = Mockito.mock(ArquivoUtil.class);
        Mockito.when(arquivoUtil.carregaArquivo(Mockito.anyString())).thenReturn(listDeConsultas);
        Mockito.when(arquivoUtil.gravaArquivo(listDeConsultas)).thenReturn(listDeConsultas);



        daoConsulta.editarConsulta(consulta1);

        assert(daoConsulta.getConsultaList().contains(consulta1));

    }

    //listagem por data
    @Test
    public void obterListaDeConsultaPorData() throws IOException {

        arquivoUtil = Mockito.mock(ArquivoUtil.class);
        Mockito.when(arquivoUtil.carregaArquivo(Mockito.anyString())).thenReturn(listDeConsultas);


        listDeConsultas.add(consulta1);
      daoConsulta.listagemPorData("2021-10-04");

        assert(daoConsulta.listagemPorData("2021-10-04").contains(consulta1));
    }
}
