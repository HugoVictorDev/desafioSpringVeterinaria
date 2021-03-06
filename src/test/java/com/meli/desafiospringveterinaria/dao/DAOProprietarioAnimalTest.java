package com.meli.desafiospringveterinaria.dao;


import com.meli.desafiospringveterinaria.model.Animal;
import com.meli.desafiospringveterinaria.model.Consulta;
import com.meli.desafiospringveterinaria.model.Medico;
import com.meli.desafiospringveterinaria.model.ProprietarioAnimal;

import com.meli.desafiospringveterinaria.services.ProprietarioService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.meli.desafiospringveterinaria.arquivoUtil.ArquivoUtil;

import static org.junit.jupiter.api.Assertions.*;


public class DAOProprietarioAnimalTest {
    Animal animal, animal2;
    ProprietarioAnimal proprietarioAnimal;
    DAOProprietarioAnimal daoProprietarioAnimal;
    InterfaceProprietarioAnimal interfaceProprietarioAnimal;
    ArquivoUtil arquivoUtilMock;
    ProprietarioService proprietarioService;

    @Before
    public void setUp() throws ParseException {

        proprietarioAnimal = new ProprietarioAnimal("09878998765","ednilson","Pinto",LocalDate.now(),"rua texte, ","11987654321",animal);

        ProprietarioAnimal mock = Mockito.mock(ProprietarioAnimal.class);
        //list.add(medico1);

        arquivoUtilMock = Mockito.mock(ArquivoUtil.class);
        proprietarioService = Mockito.mock(ProprietarioService.class);
    }



    @Test
    void deve_cadastrar() throws ParseException {
        ProprietarioService proprietarioService;
        daoProprietarioAnimal = new DAOProprietarioAnimal();
        arquivoUtilMock = Mockito.mock(ArquivoUtil.class);
        proprietarioService = Mockito.mock(ProprietarioService.class);
        animal =  new Animal(9876L,"Chiaua","Pink","Preta",LocalDate.now(),"toto");
        //setUp();
        ProprietarioAnimal proprietarioAnimal = new ProprietarioAnimal
                ("09878998765",
                        "ednilson",
                        "Pinto",
                        LocalDate.now(),"rua texte, ",
                        "11987654321",
                        animal);

        //Mockito.when(proprietarioService.cadastrarProprietario(Mockito.any())).thenReturn(proprietarioAnimal);
        daoProprietarioAnimal = new DAOProprietarioAnimal(arquivoUtilMock, proprietarioService);
        ProprietarioAnimal proprietarioAnimal1 =  daoProprietarioAnimal.cadastrarProprietario(proprietarioAnimal);

        assertTrue(daoProprietarioAnimal.cadastrarProprietario(proprietarioAnimal).equals(proprietarioAnimal));

    }

    @Test
    void deve_edita() throws ParseException, IOException {
        ProprietarioService proprietarioService;
        daoProprietarioAnimal = new DAOProprietarioAnimal();
        arquivoUtilMock = Mockito.mock(ArquivoUtil.class);
        proprietarioService = Mockito.mock(ProprietarioService.class);
        animal =  new Animal(9876L,"Chiaua","Pink","Preta",LocalDate.now(),"toto");
        //setUp();
        List<ProprietarioAnimal> proprietarioAnimalList = new ArrayList<>();

        ProprietarioAnimal proprietarioAnimal = new ProprietarioAnimal
                ("09878998765",
                        "ednilson",
                        "Pinto",
                        LocalDate.now(),"rua texte, ",
                        "11987654321",
                        animal);

        ProprietarioAnimal proprietarioAnimal1 = new ProprietarioAnimal
                ("09878998765",
                        "ednilson",
                        "Grande",
                        LocalDate.now(),"rua texte, ",
                        "11987654321",
                        animal);

        proprietarioAnimalList.add(proprietarioAnimal1);
        daoProprietarioAnimal = new DAOProprietarioAnimal(arquivoUtilMock, proprietarioService);
        Mockito.when(arquivoUtilMock.metodoCarregaArquivo(Mockito.anyString())).thenReturn(proprietarioAnimalList);
        //deve_cadastrar();
        daoProprietarioAnimal.editar(proprietarioAnimal, proprietarioAnimal1).equals(proprietarioAnimal1);
        assertTrue(daoProprietarioAnimal.editar(proprietarioAnimal, proprietarioAnimal1).equals(proprietarioAnimal1));
        //assert(resultado);

    }

    @Test
    void deve_obterProprietarioAnimal() throws ParseException, IOException {
        ProprietarioService proprietarioService;
        daoProprietarioAnimal = new DAOProprietarioAnimal();
        arquivoUtilMock = Mockito.mock(ArquivoUtil.class);
        proprietarioService = Mockito.mock(ProprietarioService.class);
        animal =  new Animal(9876L,"Chiaua","Pink","Preta",LocalDate.now(),"toto");
        //setUp();
        List<ProprietarioAnimal> proprietarioAnimalList = new ArrayList<>();

        ProprietarioAnimal proprietarioAnimal = new ProprietarioAnimal
                ("09878998765",
                        "ednilson",
                        "Pinto",
                        LocalDate.now(),"rua texte, ",
                        "11987654321",
                        animal);


        proprietarioAnimalList.add(proprietarioAnimal);
        daoProprietarioAnimal = new DAOProprietarioAnimal(arquivoUtilMock, proprietarioService);

        Mockito.when(arquivoUtilMock.metodoCarregaArquivo(Mockito.anyString())).thenReturn(proprietarioAnimalList);

        //Mockito.when(daoProprietarioAnimal.obterProprietarioAnimal(Mockito.anyString())).thenReturn(proprietarioAnimal);

        daoProprietarioAnimal.obterProprietarioAnimal(proprietarioAnimal).equals(proprietarioAnimal);

        assert(daoProprietarioAnimal.obterProprietarioAnimal(proprietarioAnimal).equals(proprietarioAnimal));

    }

    //POR CPF
    @Test
    void deve_obterProprietarioPorIdentificador() throws ParseException, IOException {
        ProprietarioService proprietarioService;
        daoProprietarioAnimal = new DAOProprietarioAnimal();
        arquivoUtilMock = Mockito.mock(ArquivoUtil.class);
        proprietarioService = Mockito.mock(ProprietarioService.class);
        animal =  new Animal(9876L,"Chiaua","Pink","Preta",LocalDate.now(),"toto");
        //setUp();
        List<ProprietarioAnimal> proprietarioAnimalList = new ArrayList<>();

        ProprietarioAnimal proprietarioAnimal = new ProprietarioAnimal
                ("09878998765",
                        "ednilson",
                        "Pinto",
                        LocalDate.now(),"rua texte, ",
                        "11987654321",
                        animal);


        proprietarioAnimalList.add(proprietarioAnimal);
        daoProprietarioAnimal = new DAOProprietarioAnimal(arquivoUtilMock, proprietarioService);

        Mockito.when(arquivoUtilMock.metodoCarregaArquivo(Mockito.anyString())).thenReturn(proprietarioAnimalList);

        boolean proprietarioAnimal1 = daoProprietarioAnimal.obterPorIdentificador(proprietarioAnimal.getCpf()).equals(proprietarioAnimal);

        assert (daoProprietarioAnimal.obterPorIdentificador(proprietarioAnimal.getCpf()).equals(proprietarioAnimal));
    }
    //POR CPF
    @Test
    void deve_removerProprietario() throws ParseException, IOException {
        Consulta consulta;
        Medico medico;
        ProprietarioService proprietarioService;
        daoProprietarioAnimal = new DAOProprietarioAnimal();
        arquivoUtilMock = Mockito.mock(ArquivoUtil.class);
        proprietarioService = Mockito.mock(ProprietarioService.class);
        animal =  new Animal(9876L,"Chiaua","Pink","Preta",LocalDate.now(),"toto");
        animal2 =  new Animal(9176L,"Chiaua","Pink","Preta",LocalDate.now(),"toto");
        //setUp();
        List<ProprietarioAnimal> proprietarioAnimalList = new ArrayList<>();
        List<Medico> medicoList = new ArrayList<>();
        List<Consulta> consultaList = new ArrayList<>();

        ProprietarioAnimal proprietarioAnimal = new ProprietarioAnimal
                ("09878998765",
                        "ednilson",
                        "Pinto",
                        LocalDate.now(),"rua texte, ",
                        "11987654321",
                        animal);

        medico = new Medico ("123456879",
                     "marco",
                     "da Rocha",
                     2000006000,
                     "cardio");

        consulta = new Consulta(LocalDate.now(),"motivo","diagnostico","tratamento",medico, animal2);
        proprietarioAnimalList.add(proprietarioAnimal);
        consultaList.add(consulta);
        medicoList.add(medico);
        daoProprietarioAnimal = new DAOProprietarioAnimal(arquivoUtilMock, proprietarioService);

        Mockito.when(arquivoUtilMock.metodoCarregaArquivo(Mockito.anyString())).thenReturn(proprietarioAnimalList);
        Mockito.when(arquivoUtilMock.carregaArquivoConsulta(Mockito.anyString())).thenReturn(consultaList);
        Mockito.when(arquivoUtilMock.carregaArquivo(Mockito.anyString())).thenReturn(medicoList);
        proprietarioAnimalList = daoProprietarioAnimal.removerProprietario(proprietarioAnimal);

        assertFalse(daoProprietarioAnimal.removerProprietario(proprietarioAnimal).contains(proprietarioAnimalList));
    }
}