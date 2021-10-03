package com.meli.desafiospringveterinaria.services;


import com.meli.desafiospringveterinaria.dao.DAOProprietarioAnimal;
import com.meli.desafiospringveterinaria.model.Animal;
import com.meli.desafiospringveterinaria.model.ProprietarioAnimal;
import com.meli.desafiospringveterinaria.persistence.Persistivel;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DAOProprietarioAnimalTest {
    Animal animal = null;
    ProprietarioAnimal proprietarioAnimal = null;
    DAOProprietarioAnimal daoProprietarioAnimal = null;

    @Before
    public void setUp() throws ParseException {
        animal =  new Animal(9876L,"Chiaua","Pink","Preta",LocalDate.now(),"toto");
        proprietarioAnimal = new ProprietarioAnimal("09878998765","ednilson","Pinto",LocalDate.now(),"rua texte, ","11987654321",animal);
        daoProprietarioAnimal = new DAOProprietarioAnimal();
    }

    //Teste do servico  mapear objeto Edenilson Mauricio
    @Test
    void deve_mapearObjeto() throws IOException {
        ProprietarioAnimal mock = Mockito.mock(ProprietarioAnimal.class);

        //Terminar servico
    }


    @Test
    void deve_cadastrar() throws ParseException {
        ProprietarioAnimal proprietarioAnimal = new ProprietarioAnimal
                ("09878998765",
                        "ednilson",
                        "Pinto",
                        LocalDate.now(),"rua texte, ",
                        "11987654321",
                        animal);

        assert(daoProprietarioAnimal.cadastrar(proprietarioAnimal).equals(proprietarioAnimal));

    }

    @Test
    void deve_edita() throws ParseException {
        ProprietarioAnimal proprietarioAnimal = new ProprietarioAnimal
                ("09878998765",
                        "ednilson",
                        "Pinto",
                        LocalDate.now(),"rua texte, ",
                        "11987654321",
                        animal);
        assert(daoProprietarioAnimal.editar(proprietarioAnimal).equals(proprietarioAnimal));

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