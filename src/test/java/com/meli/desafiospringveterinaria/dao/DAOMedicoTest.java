package com.meli.desafiospringveterinaria.dao;

import com.meli.desafiospringveterinaria.arquivoutil.ArquivoUtil;
import com.meli.desafiospringveterinaria.model.Animal;
import com.meli.desafiospringveterinaria.model.Consulta;
import com.meli.desafiospringveterinaria.model.Medico;
import com.meli.desafiospringveterinaria.services.MedicoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class DAOMedicoTest {

    DAOMedico daoMedico = null;

    Medico medico = new Medico("12456879","Marco","Rocha", 500000000, "neuro");
    Animal animal = new Animal(45546456L, "gato", "felino", "preto",LocalDate.now(),"toto");
    Consulta consulta = new Consulta(LocalDate.now(),"dor","operar", "remedios",  medico,animal);
    MedicoService medicoService = null;

    List<Medico> list = new ArrayList<>();
    List<Consulta> consultaList = new ArrayList<>();

    ArquivoUtil arquivoUtilMock = null;

    String mensagem = "java.io.IOException";
    String mensagemSystem = "";

    @Test
    public void testCadastraMedicoOk() throws IOException {
        Medico medico1 = new Medico("98745666","Eli","Silva", 600000000, "psico");
        list.add(medico1);

        arquivoUtilMock = Mockito.mock(ArquivoUtil.class);
        medicoService = Mockito.mock(MedicoService.class);

        Mockito.when(medicoService.validarMedico(Mockito.anyLong())).thenReturn(list);

        daoMedico = new DAOMedico(arquivoUtilMock, medicoService);

        daoMedico.cadastrar(medico);

        assert(daoMedico.getMedicosList().contains(medico));
    }

    @Test
    public void testObterMedico() throws IOException {
        list.add(medico);

        arquivoUtilMock = Mockito.mock(ArquivoUtil.class);
        Mockito.when(arquivoUtilMock.carregaArquivo(Mockito.anyString())).thenReturn(list);

        daoMedico = new DAOMedico(arquivoUtilMock);

        daoMedico.obter(500000000L);

        assert(daoMedico.getMedicosList().contains(medico));
    }

    @Test
    public void testObterMedicoNok() throws IOException {
        List<Medico> list = new ArrayList<>();
        list.add(medico);

        arquivoUtilMock = Mockito.mock(ArquivoUtil.class);
        Mockito.when(arquivoUtilMock.carregaArquivo(Mockito.anyString())).thenReturn(list);

        daoMedico = new DAOMedico(arquivoUtilMock);

        RuntimeException exception = Assertions.assertThrows(RuntimeException.class, ()->
        { daoMedico.obter(777000000L);});

        mensagem = "Médico não encontrado";
        mensagemSystem = exception.getMessage();

        assert (mensagem.contains(mensagemSystem));
    }

    @Test
    public void testEditarMedico() throws IOException {
        Medico medico1 = new Medico("13456879","Marco Aurelio","da Rocha", 500000000, "nutri");
        list.add(medico1);

        arquivoUtilMock = Mockito.mock(ArquivoUtil.class);
        Mockito.when(arquivoUtilMock.carregaArquivo(Mockito.anyString())).thenReturn(list);

        daoMedico = new DAOMedico(arquivoUtilMock);

        daoMedico.editar(medico);

        assert(daoMedico.getMedicosList().contains(medico) && daoMedico.getMedicosList().size() == 1);
    }

    @Test
    public void testEditarMedicoNok() throws IOException {
        Medico medico1 = new Medico("13456879","Marco","da Rocha", 600000000, "neuro");
        list.add(medico1);

        arquivoUtilMock = Mockito.mock(ArquivoUtil.class);
        Mockito.when(arquivoUtilMock.carregaArquivo(Mockito.anyString())).thenReturn(list);

        daoMedico = new DAOMedico(arquivoUtilMock);

        RuntimeException exception = Assertions.assertThrows(RuntimeException.class, ()->{ daoMedico.editar(medico);});

        mensagem = "Médico não Atualizdo";
        mensagemSystem = exception.getMessage();

        assert (mensagem.contains(mensagemSystem));
    }

    @Test
    public void testRemoverMedicoEmConsulta() throws IOException {
        list.add(medico);
        consultaList.add(consulta);

        arquivoUtilMock = Mockito.mock(ArquivoUtil.class);
        Mockito.when(arquivoUtilMock.carregaArquivo(Mockito.anyString())).thenReturn(list);
        Mockito.when(arquivoUtilMock.carregaArquivoConsulta(Mockito.anyString())).thenReturn(consultaList);

        daoMedico = new DAOMedico(arquivoUtilMock);

        RuntimeException exception = Assertions.assertThrows(RuntimeException.class, ()->{ daoMedico.remover(500000000L);});

        mensagem = "Medico em consulta, ele não pode ser deletado!";
        mensagemSystem = exception.getMessage();

        assert (mensagem.contains(mensagemSystem));
    }

    @Test
    public void testRemoverMedicoNaoCadastrado() throws IOException {
        list.add(medico);
        consultaList.add(consulta);

        arquivoUtilMock = Mockito.mock(ArquivoUtil.class);
        Mockito.when(arquivoUtilMock.carregaArquivo(Mockito.anyString())).thenReturn(list);
        Mockito.when(arquivoUtilMock.carregaArquivoConsulta(Mockito.anyString())).thenReturn(consultaList);

        daoMedico = new DAOMedico(arquivoUtilMock);

        RuntimeException exception = Assertions.assertThrows(RuntimeException.class, ()->{ daoMedico.remover(900000000L);});

        mensagem = "Medico não cadastrado!";
        mensagemSystem = exception.getMessage();

        assert (mensagem.contains(mensagemSystem));
    }

    @Test
    public void testRemoverOK() throws IOException {
        Medico medico1 = new Medico("13456879","Marco","da Rocha", 990000000, "neuro");
        Consulta consulta = new Consulta(LocalDate.now(),"dor","operar", "remedios",  medico1,animal);
        List<Medico> medicoList = new ArrayList<>();
        medicoList.add(medico);
        consultaList.add(consulta);

        arquivoUtilMock = Mockito.mock(ArquivoUtil.class);
        Mockito.when(arquivoUtilMock.carregaArquivo(Mockito.anyString())).thenReturn(medicoList);
        Mockito.when(arquivoUtilMock.carregaArquivoConsulta(Mockito.anyString())).thenReturn(consultaList);

        daoMedico = new DAOMedico(arquivoUtilMock);

        RuntimeException exception = Assertions.assertThrows(RuntimeException.class, ()->{ daoMedico.remover(500000000L);});

        mensagem = "Medico deletado!";
        mensagemSystem = exception.getMessage();

        assert (mensagem.contains(mensagemSystem));
    }

    @Test
    public void testRemoverException() throws IOException {
        arquivoUtilMock = Mockito.mock(ArquivoUtil.class);
        Mockito.when(arquivoUtilMock.carregaArquivo(Mockito.anyString())).thenThrow(IOException.class);

        daoMedico = new DAOMedico(arquivoUtilMock);

        RuntimeException exception = Assertions.assertThrows(RuntimeException.class,()->
        { daoMedico.remover(600000000L);});

        mensagemSystem = exception.getMessage();
        assert (mensagem.contains(mensagemSystem));
    }

    @Test
    public void testEditarException() throws IOException {
        arquivoUtilMock = Mockito.mock(ArquivoUtil.class);
        Mockito.when(arquivoUtilMock.carregaArquivo(Mockito.anyString())).thenThrow(IOException.class);

        daoMedico = new DAOMedico(arquivoUtilMock);

        RuntimeException exception = Assertions.assertThrows(RuntimeException.class,()->
        { daoMedico.editar(medico);});

        mensagemSystem = exception.getMessage();
        assert (mensagem.contains(mensagemSystem));
    }

    @Test
    public void testObterException() throws IOException {
        arquivoUtilMock = Mockito.mock(ArquivoUtil.class);
        Mockito.when(arquivoUtilMock.carregaArquivo(Mockito.anyString())).thenThrow(IOException.class);

        daoMedico = new DAOMedico(arquivoUtilMock);

        RuntimeException exception = Assertions.assertThrows(RuntimeException.class,()->
        { daoMedico.obter(5000000L);});

        mensagemSystem = exception.getMessage();
        assert (mensagem.contains(mensagemSystem));
    }
}
