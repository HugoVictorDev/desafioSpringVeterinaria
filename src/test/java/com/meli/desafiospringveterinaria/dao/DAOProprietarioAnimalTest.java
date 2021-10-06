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
        animal =  new Animal(9876L,"Chiaua","Pink","Preta",LocalDate.now(),"toto");
        proprietarioAnimal = new ProprietarioAnimal("09878998765","ednilson","Pinto",LocalDate.now(),"rua texte, ","11987654321",animal);
        daoProprietarioAnimal = new DAOProprietarioAnimal();
        ProprietarioAnimal mock = Mockito.mock(ProprietarioAnimal.class);
        //list.add(medico1);

        arquivoUtilMock = Mockito.mock(ArquivoUtil.class);
        proprietarioService = Mockito.mock(ProprietarioService.class);
    }



    @Test
    void deve_cadastrar() throws ParseException {
        setUp();
        ProprietarioAnimal proprietarioAnimal = new ProprietarioAnimal
                ("09878998765",
                        "ednilson",
                        "Pinto",
                        LocalDate.now(),"rua texte, ",
                        "11987654321",
                        animal);

        //Mockito.when(proprietarioService.cadastrarProprietario(Mockito.any())).thenReturn(proprietarioAnimal);
        daoProprietarioAnimal = new DAOProprietarioAnimal(arquivoUtilMock, proprietarioService);

        assertTrue(daoProprietarioAnimal.cadastrarProprietario(proprietarioAnimal).equals(proprietarioAnimal));

    }

    @Test
    void deve_edita() throws ParseException, IOException {

        ProprietarioAnimal proprietarioAnimal = new ProprietarioAnimal
                ("09878998765",
                        "ednilson",
                        "Pinto",
                        LocalDate.now(),"rua texte, ",
                        "11987654321",
                        animal);

        //Mockito.when(proprietarioService.cadastrarProprietario(Mockito.any())).thenReturn(proprietarioAnimal);
        daoProprietarioAnimal = new DAOProprietarioAnimal(arquivoUtilMock, proprietarioService);


        ProprietarioAnimal proprietarioAnimal1 = new ProprietarioAnimal
                ("09878998765",
                        "ednilson",
                        "Grande",
                        LocalDate.now(),"rua texte, ",
                        "11987654321",
                        animal);


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