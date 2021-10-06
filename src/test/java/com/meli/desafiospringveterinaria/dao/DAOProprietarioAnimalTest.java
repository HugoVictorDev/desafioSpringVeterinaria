package com.meli.desafiospringveterinaria.dao;


import com.meli.desafiospringveterinaria.model.Animal;
import com.meli.desafiospringveterinaria.model.ProprietarioAnimal;

import com.meli.desafiospringveterinaria.services.ProprietarioService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;

import com.meli.desafiospringveterinaria.arquivoUtil.ArquivoUtil;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class DAOProprietarioAnimalTest {
    Animal animal;
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
        deve_cadastrar();
        daoProprietarioAnimal.editar(proprietarioAnimal, proprietarioAnimal1).equals(proprietarioAnimal1);
        assertTrue(daoProprietarioAnimal.editar(proprietarioAnimal, proprietarioAnimal1).equals(proprietarioAnimal1));
        //assert(resultado);

    }

    @Test
    void deve_obterProprietarioAnimal() throws ParseException, IOException {
        setUp();
        assert(daoProprietarioAnimal.obterProprietarioAnimal(proprietarioAnimal).equals(proprietarioAnimal));

    }

    //POR CPF
    @Test
    void deve_obterProprietarioPorIdentificador() throws ParseException, IOException {
        assert (daoProprietarioAnimal.obterPorIdentificador(proprietarioAnimal.getCpf()).equals(proprietarioAnimal));
    }
}