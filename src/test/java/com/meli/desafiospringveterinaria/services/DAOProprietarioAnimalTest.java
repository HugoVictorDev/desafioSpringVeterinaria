package com.meli.desafiospringveterinaria.services;

import ch.qos.logback.core.read.ListAppender;
import com.meli.desafiospringveterinaria.model.Animal;
import com.meli.desafiospringveterinaria.model.ProprietarioAnimal;
import com.meli.desafiospringveterinaria.model.RespostaBase;
import com.meli.desafiospringveterinaria.persistence.Persistivel;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DAOProprietarioAnimalTest {


    //Teste do servico  mapear objeto Edenilson Mauricio
    @Test
    void deve_mapearObjeto() throws IOException {
        ProprietarioAnimal mock = Mockito.mock(ProprietarioAnimal.class);

        //Terminar servico
    }


    @Test
    void deve_cadastrar() throws ParseException {

        ArrayList<ProprietarioAnimal>  listaDeProprietarioAnimal = new ArrayList<>();
        Animal animal = new Animal(9876L,"Chiaua","Pink","Preta",LocalDate.now(),"toto");

        //Mockito.when(mock.cadastrar(Mockito.any(ProprietarioAnimal.class))).thenReturn(listaDeProprietarioAnimal);
        ProprietarioAnimal proprietarioAnimal = new ProprietarioAnimal("09878998765","ednilson","Pinto",LocalDate.now(),"rua texte, ","11987654321",animal);
        listaDeProprietarioAnimal.add(proprietarioAnimal);

        Persistivel mock = Mockito.mock(Persistivel.class);



        DAOProprietarioAnimal daoProprietarioAnimal = new DAOProprietarioAnimal();
       // Animal animalRetorno = new Animal();
        daoProprietarioAnimal.cadastrar(proprietarioAnimal);

        assert(daoProprietarioAnimal.cadastrar(proprietarioAnimal).equals(animal));

    }
}


