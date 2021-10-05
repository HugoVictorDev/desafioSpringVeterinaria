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

    Consulta consulta1 = new Consulta(LocalDate.of(2021,11,04), "doenca","di","remedio",
            new Medico( "404313928", "hugo", "Victor", 12345, "medico"),
            new Animal(1232323L, "gato", "boaa", "amarelo",LocalDate.of(2021,10,04),"felix"));

    Consulta consulta2 = new Consulta(LocalDate.of(2021,10,05), "cancer","di","cirurgia",new Medico( "404313928", "hugo", "Victor", 12345, "medico"),
            new Animal(12323234L, "cachorro", "boaa", "amarelo",LocalDate.of(2021,10,04),"felix"));

    List<Consulta> listDeConsultas = new ArrayList<>();

    String mensagem = "java.io.IOException";
    String mensagemSystem = "";

//-- ----------- tests ------------------------//

    //CADASTRAR CONSULTA OK
    @Test
    public void cadastrandoConsultaOK() throws IOException {

//        listDeConsultas.add(consulta1);

        arquivoUtil = Mockito.mock(ArquivoUtil.class);
        consultaService = Mockito.mock(ConsultaService.class);

        Mockito.when(arquivoUtil.gravaArquivoConsulta1(Mockito.anyList())).thenReturn(listDeConsultas);
        Mockito.when(consultaService.validarConsulta(Mockito.anyString())).thenReturn(true);

        daoConsulta = new DAOConsulta(arquivoUtil, consultaService);
        daoConsulta.cadastrar(consulta2);

        assert(daoConsulta.getConsultaList().contains(consulta2));
    }


    //CADASTRAR CONSULTA NOK
    @Test
    public void testCadastrarConsultaNaoOk() throws IOException {
        listDeConsultas.add(consulta2);

        consultaService = Mockito.mock(ConsultaService.class);

        Mockito.when(consultaService.validarConsulta(Mockito.anyString())).thenReturn(false);
        daoConsulta = new DAOConsulta(consultaService);

        RuntimeException exception = Assertions.assertThrows(RuntimeException.class, ()->
        { daoConsulta.cadastrar(consulta2);});

        mensagem = "Consulta já cadastrada";
        mensagemSystem = exception.getMessage();

        assert (mensagem.contains(mensagemSystem));
    }


    //testar editar consulta
    @Test
    public void testarEditarConsultaOK() throws IOException {

        listDeConsultas.add(consulta2);

        arquivoUtil = Mockito.mock(ArquivoUtil.class);

        Mockito.when(arquivoUtil.carregaArquivoConsulta1(Mockito.anyString())).thenReturn(listDeConsultas);
        Mockito.when(arquivoUtil.gravaArquivoConsulta1(listDeConsultas)).thenReturn(listDeConsultas);

        daoConsulta = new DAOConsulta(arquivoUtil);

        daoConsulta.editarConsulta(consulta1);
        assert(daoConsulta.getConsultaList().contains(consulta1) && daoConsulta.getConsultaList().size() == 1);

    }
    //editar medico nao OK
    @Test
    public void testEditarConsultaNok() throws IOException {

        listDeConsultas.add(consulta1);
        arquivoUtil = Mockito.mock(ArquivoUtil.class);

        Mockito.when(arquivoUtil.carregaArquivoConsulta1(Mockito.anyString())).thenReturn(listDeConsultas);
        Mockito.when(arquivoUtil.gravaArquivoConsulta1(listDeConsultas)).thenReturn(listDeConsultas);

        daoConsulta = new DAOConsulta(arquivoUtil);
        RuntimeException exception = Assertions.assertThrows(RuntimeException.class, ()->{
            daoConsulta.editarConsulta(consulta2);});

        mensagem = "Consulta não encotrada";
        mensagemSystem = exception.getMessage();

        assert (mensagem.contains(mensagemSystem));
    }


    //obter listagem por data
    @Test
    public void obterListaDeConsultaPorData() throws IOException {

        listDeConsultas.add(consulta1);

        arquivoUtil = Mockito.mock(ArquivoUtil.class);
        Mockito.when(arquivoUtil.carregaArquivoConsulta1(Mockito.anyString())).thenReturn(listDeConsultas);

        daoConsulta = new DAOConsulta(arquivoUtil);

      daoConsulta.listagemPorData("2021-11-04");


      assert(daoConsulta.consultaList2.contains(consulta1));

    }


//obter listagem por cpfmedico
    @Test
    public void obterConsultaPorCpfDoMedicoOK() throws IOException {

        listDeConsultas.add(consulta1);

        arquivoUtil = Mockito.mock(ArquivoUtil.class);
        Mockito.when(arquivoUtil.carregaArquivoConsulta1(Mockito.anyString())).thenReturn(listDeConsultas);

        daoConsulta = new DAOConsulta(arquivoUtil);

        daoConsulta.listagemMedicoConsulta("404313928");


        assert(daoConsulta.consultaList2.contains(consulta1));

    }

        //Teste por paciente
    @Test
    public void obterConsultaPorPacienteOk() throws IOException {

        listDeConsultas.add(consulta1);

        arquivoUtil = Mockito.mock(ArquivoUtil.class);
        Mockito.when(arquivoUtil.carregaArquivoConsulta1(Mockito.anyString())).thenReturn(listDeConsultas);

        daoConsulta = new DAOConsulta(arquivoUtil);

        daoConsulta.pacienteConsulta(1232323L);


        assert(daoConsulta.consultaList2.contains(consulta1));

    }
}