package com.meli.desafiospringveterinaria.dao;

import com.meli.desafiospringveterinaria.arquivoutil.ArquivoUtil;
import com.meli.desafiospringveterinaria.model.Animal;
import com.meli.desafiospringveterinaria.model.Consulta;
import com.meli.desafiospringveterinaria.model.Medico;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.exceptions.misusing.UnfinishedStubbingException;
import org.opentest4j.AssertionFailedError;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DAOMedicoTest {
    @Test
    public void testCadastraMedicoNok() throws IOException {
        Medico medico = new Medico("12456879","Marco","Rocha", 500000000, "neuro");
        List<Medico> list = new ArrayList<>();
        list.add(medico);

        ArquivoUtil arquivoUtilMock = Mockito.mock(ArquivoUtil.class);
        Mockito.when(arquivoUtilMock.carregaArquivo(Mockito.anyString())).thenReturn(list);
        DAOMedico daoMedico = new DAOMedico(arquivoUtilMock);

        RuntimeException exception = Assertions.assertThrows(RuntimeException.class, ()->{ daoMedico.cadastrar(medico);});

        String mensagem = "Medico já cadastrado";
        String mensagemSystem = exception.getMessage();

        assert (mensagem.contains(mensagemSystem));
    }

    @Test
    public void testCadastraMedicoOk() throws IOException {
        Medico medico = new Medico("12456879","Marco","Rocha", 500000000, "neuro");
        Medico medico1 = new Medico("98745666","Eli","Silva", 600000000, "psico");
        List<Medico> list = new ArrayList<>();
        list.add(medico1);

        ArquivoUtil arquivoUtilMock = Mockito.mock(ArquivoUtil.class);
        Mockito.when(arquivoUtilMock.carregaArquivo(Mockito.anyString())).thenReturn(list);
        Mockito.when(arquivoUtilMock.gravaArquivo(list)).thenReturn(list);

        DAOMedico daoMedico = new DAOMedico(arquivoUtilMock);

        daoMedico.cadastrar(medico);

        assert(daoMedico.getMedicosList().contains(medico));
    }

    @Test
    public void testObterMedico() throws IOException {
        Medico medico = new Medico("12456879","Marco","Rocha", 500000000, "neuro");
        List<Medico> list = new ArrayList<>();
        list.add(medico);

        ArquivoUtil arquivoUtilMock = Mockito.mock(ArquivoUtil.class);
        Mockito.when(arquivoUtilMock.carregaArquivo(Mockito.anyString())).thenReturn(list);

        DAOMedico daoMedico = new DAOMedico(arquivoUtilMock);

        daoMedico.obter(500000000L);

        assert(daoMedico.getMedicosList().contains(medico));
    }

    @Test
    public void testObterMedicoNok() throws IOException {
        Medico medico = new Medico("12456879","Marco","Rocha", 500000000, "neuro");
        List<Medico> list = new ArrayList<>();
        list.add(medico);

        ArquivoUtil arquivoUtilMock = Mockito.mock(ArquivoUtil.class);
        Mockito.when(arquivoUtilMock.carregaArquivo(Mockito.anyString())).thenReturn(list);

        DAOMedico daoMedico = new DAOMedico(arquivoUtilMock);

        RuntimeException exception = Assertions.assertThrows(RuntimeException.class, ()->{ daoMedico.obter(777000000L);});

        String mensagem = "Médico não encontrado";
        String mensagemSystem = exception.getMessage();

        assert (mensagem.contains(mensagemSystem));
    }

    @Test
    public void testEditarMedico() throws IOException {
        Medico medico = new Medico("12456879","Marco","Rocha", 500000000, "neuro");
        Medico medico1 = new Medico("13456879","Marco","da Rocha", 500000000, "neuro");
        List<Medico> list = new ArrayList<>();
        list.add(medico1);

        ArquivoUtil arquivoUtilMock = Mockito.mock(ArquivoUtil.class);
        Mockito.when(arquivoUtilMock.carregaArquivo(Mockito.anyString())).thenReturn(list);
        Mockito.when(arquivoUtilMock.gravaArquivo(list)).thenReturn(list);

        DAOMedico daoMedico = new DAOMedico(arquivoUtilMock);

        daoMedico.editar(medico);

        assert(daoMedico.getMedicosList().contains(medico) && daoMedico.getMedicosList().size() == 1);

    }

    @Test
    public void testEditarMedicoNok() throws IOException {
        Medico medico = new Medico("12456879","Marco","Rocha", 500000000, "neuro");
        Medico medico1 = new Medico("13456879","Marco","da Rocha", 600000000, "neuro");
        List<Medico> list = new ArrayList<>();
        list.add(medico1);

        ArquivoUtil arquivoUtilMock = Mockito.mock(ArquivoUtil.class);
        Mockito.when(arquivoUtilMock.carregaArquivo(Mockito.anyString())).thenReturn(list);
        Mockito.when(arquivoUtilMock.gravaArquivo(list)).thenReturn(list);

        DAOMedico daoMedico = new DAOMedico(arquivoUtilMock);

        RuntimeException exception = Assertions.assertThrows(RuntimeException.class, ()->{ daoMedico.editar(medico);});

        String mensagem = "Médico não Atualizdo";
        String mensagemSystem = exception.getMessage();

        assert (mensagem.contains(mensagemSystem));
    }

    @Test
    public void testRemoverMedicoemConsulta() throws IOException {
        Medico medico = new Medico("13456879","Marco","da Rocha", 600000000, "neuro");
        Animal animal = new Animal(45546456L, "gato", "felino", "preto",LocalDate.now(),"toto");
        Consulta consulta = new Consulta(LocalDate.now(),"dor","operar", "remedios",  medico,animal);

        List<Medico> medicoList = new ArrayList<>();
        medicoList.add(medico);
        List<Consulta> consultaList = new ArrayList<>();
        consultaList.add(consulta);

        ArquivoUtil arquivoUtilMock = Mockito.mock(ArquivoUtil.class);
        Mockito.when(arquivoUtilMock.carregaArquivo(Mockito.anyString())).thenReturn(medicoList);
        Mockito.when(arquivoUtilMock.carregaArquivoConsulta(Mockito.anyString())).thenReturn(consultaList);
        Mockito.when(arquivoUtilMock.gravaArquivo(medicoList)).thenReturn(medicoList);

        DAOMedico daoMedico = new DAOMedico(arquivoUtilMock);

        RuntimeException exception = Assertions.assertThrows(RuntimeException.class, ()->{ daoMedico.remover(600000000L);});

        String mensagem = "Medico em consulta, ele não pode ser deletado!";
        String mensagemSystem = exception.getMessage();

        assert (mensagem.contains(mensagemSystem));
    }

    @Test
    public void testRemoverMedicoNaoCadastrado() throws IOException {
        Medico medico = new Medico("13456879","Marco","da Rocha", 600000000, "neuro");
        Animal animal = new Animal(45546456L, "gato", "felino", "preto",LocalDate.now(),"toto");
        Consulta consulta = new Consulta(LocalDate.now(),"dor","operar", "remedios",  medico,animal);
        List<Medico> medicoList = new ArrayList<>();
        medicoList.add(medico);
        List<Consulta> consultaList = new ArrayList<>();
        consultaList.add(consulta);

        ArquivoUtil arquivoUtilMock = Mockito.mock(ArquivoUtil.class);
        Mockito.when(arquivoUtilMock.carregaArquivo(Mockito.anyString())).thenReturn(medicoList);
        Mockito.when(arquivoUtilMock.carregaArquivoConsulta(Mockito.anyString())).thenReturn(consultaList);
        Mockito.when(arquivoUtilMock.gravaArquivo(medicoList)).thenReturn(medicoList);

        DAOMedico daoMedico = new DAOMedico(arquivoUtilMock);

        RuntimeException exception = Assertions.assertThrows(RuntimeException.class, ()->{ daoMedico.remover(900000000L);});

        String mensagem = "Medico não cadastrado!";
        String mensagemSystem = exception.getMessage();

        assert (mensagem.contains(mensagemSystem));
    }

    @Test
    public void testRemoverOK() throws IOException {
        Medico medico = new Medico("13456879","Marco","da Rocha", 600000000, "neuro");
        Medico medico1 = new Medico("13456879","Marco","da Rocha", 990000000, "neuro");
        Animal animal = new Animal(45546456L, "gato", "felino", "preto",LocalDate.now(),"toto");
        Consulta consulta = new Consulta(LocalDate.now(),"dor","operar", "remedios",  medico1,animal);
        List<Medico> medicoList = new ArrayList<>();
        medicoList.add(medico);
        List<Consulta> consultaList = new ArrayList<>();
        consultaList.add(consulta);

        ArquivoUtil arquivoUtilMock = Mockito.mock(ArquivoUtil.class);
        Mockito.when(arquivoUtilMock.carregaArquivo(Mockito.anyString())).thenReturn(medicoList);
        Mockito.when(arquivoUtilMock.carregaArquivoConsulta(Mockito.anyString())).thenReturn(consultaList);
        Mockito.when(arquivoUtilMock.gravaArquivo(medicoList)).thenReturn(medicoList);

        DAOMedico daoMedico = new DAOMedico(arquivoUtilMock);

        RuntimeException exception = Assertions.assertThrows(RuntimeException.class, ()->{ daoMedico.remover(600000000L);});

        String mensagem = "Medico deletado!";
        String mensagemSystem = exception.getMessage();

        assert (mensagem.contains(mensagemSystem));
    }

    @Test
    public void testRemoverNOK() throws IOException {

        ArquivoUtil arquivoUtilMock = Mockito.mock(ArquivoUtil.class);
        Mockito.when(arquivoUtilMock.carregaArquivo(Mockito.anyString())).thenThrow(IOException.class);


        DAOMedico daoMedico = new DAOMedico(arquivoUtilMock);

        UnfinishedStubbingException exception1 = Assertions.assertThrows(UnfinishedStubbingException.class, ()->
        { daoMedico.remover(600000000L);});

        Throwable mensagem = exception1.getCause();
        String mensagemSystem = exception1.toString();
        String mensagemSystem2 =     exception1.getLocalizedMessage();
        String mensagemSystem3 =    exception1.getMessage();
        StackTraceElement[] mensagemSystem5 =    exception1.getUnfilteredStackTrace();

    }
}
