package com.meli.desafiospringveterinaria.dao;



import com.meli.desafiospringveterinaria.arquivoUtil.ArquivoUtil;
import com.meli.desafiospringveterinaria.dao.DAOConsulta;
import com.meli.desafiospringveterinaria.model.Animal;
import com.meli.desafiospringveterinaria.model.Consulta;
import com.meli.desafiospringveterinaria.model.Medico;
import com.meli.desafiospringveterinaria.services.ConsultaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
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
            new Animal(1232323L, "gato", "boaa", "amarelo",LocalDate.of(2021,10,04),"felix"));

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
        listDeConsultas.add(consulta1);

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
    public void testarEditarConsultaOK() throws IOException {

        listDeConsultas.add(consulta2);

        arquivoUtil = Mockito.mock(ArquivoUtil.class);
        Mockito.when(arquivoUtil.carregaArquivoConsulta(Mockito.anyString())).thenReturn(listDeConsultas);
        Mockito.when(arquivoUtil.gravaArquivoConsulta1(listDeConsultas)).thenReturn(listDeConsultas);



        daoConsulta.editarConsulta(consulta1);
        assert(daoConsulta.getConsultaList().contains(consulta1) && daoConsulta.getConsultaList().size() == 3);

    }
    //editar medico nao OK


    @Test
    public void testEditarConsultaNok() throws IOException {

        listDeConsultas.add(consulta2);


        Mockito.when(arquivoUtil.carregaArquivoConsulta(Mockito.anyString())).thenReturn(listDeConsultas);
        Mockito.when(arquivoUtil.gravaArquivoConsulta1(listDeConsultas)).thenReturn(listDeConsultas);


        RuntimeException exception = Assertions.assertThrows(RuntimeException.class, ()->{ daoConsulta.editarConsulta(consulta1);});

        mensagem = "Consulta não encotrada";
        mensagemSystem = exception.getMessage();

        assert (mensagem.contains(mensagemSystem));
    }


    //listagem por data
    @Test
    public void obterListaDeConsultaPorData() throws IOException {
        listDeConsultas.add(consulta1);
        listDeConsultas.add(consulta2);
        arquivoUtil = Mockito.mock(ArquivoUtil.class);
        Mockito.when(arquivoUtil.carregaArquivoConsulta(Mockito.anyString())).thenReturn(listDeConsultas);



      daoConsulta.listagemPorData(consulta1.getDataHora().toString());

   assert(daoConsulta.getConsultaList().contains(consulta1));

    }
}
