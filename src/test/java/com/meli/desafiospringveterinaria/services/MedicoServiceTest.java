package com.meli.desafiospringveterinaria.services;


import com.meli.desafiospringveterinaria.arquivoUtil.ArquivoUtil;
import com.meli.desafiospringveterinaria.model.Medico;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MedicoServiceTest {



    Medico medico = new Medico("12456879","Marco","Rocha", 500000000, "neuro");
    MedicoService medicoService = null;

    List<Medico> list = new ArrayList<>();

    ArquivoUtil arquivoUtilMock = null;

    String mensagem = "java.io.IOException";
    String mensagemSystem = "";

    @Test
    public void testCadastraMedicoNok() throws IOException {
        list.add(medico);
        medicoService = Mockito.mock(MedicoService.class);
        arquivoUtilMock = Mockito.mock(ArquivoUtil.class);

        Mockito.when(medicoService.validarMedico(Mockito.anyLong())).thenReturn(list);
        Mockito.when(arquivoUtilMock.carregaArquivo(Mockito.anyString())).thenReturn(list);

        medicoService= new MedicoService(arquivoUtilMock);

        RuntimeException exception = Assertions.assertThrows(RuntimeException.class, ()->
        { medicoService.validarMedico(500000000l);});

        mensagem = "Medico já cadastrado";
        mensagemSystem = exception.getMessage();

        assert (mensagem.contains(mensagemSystem));
    }

    @Test
    public void testCadastrarException() throws IOException {
        arquivoUtilMock = Mockito.mock(ArquivoUtil.class);
        Mockito.when(arquivoUtilMock.carregaArquivo(Mockito.anyString())).thenThrow(IOException.class);

        medicoService = new MedicoService(arquivoUtilMock);

        RuntimeException exception = Assertions.assertThrows(RuntimeException.class,()->
        { medicoService.validarMedico(5000000L);});

        mensagemSystem = exception.getMessage();
        assert (mensagem.contains(mensagemSystem));
    }

    @Test
    public void testCadastraMedicoArqVazio() throws IOException {
        medicoService = Mockito.mock(MedicoService.class);
        arquivoUtilMock = Mockito.mock(ArquivoUtil.class);

        Mockito.when(medicoService.validarMedico(Mockito.anyLong())).thenReturn(list);
        Mockito.when(arquivoUtilMock.carregaArquivo(Mockito.anyString())).thenReturn(list);

        medicoService= new MedicoService(arquivoUtilMock);

        medicoService.validarMedico(500000000l);

        assert (medicoService.medicosListService.size() == 0);
    }

}
