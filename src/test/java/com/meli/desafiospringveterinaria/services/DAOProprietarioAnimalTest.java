package com.meli.desafiospringveterinaria.services;

import com.meli.desafiospringveterinaria.model.Animal;
import com.meli.desafiospringveterinaria.model.ProprietarioAnimal;
import com.meli.desafiospringveterinaria.persistence.Persistivel;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DAOProprietarioAnimalTest {

    ArrayList<ProprietarioAnimal>  listaDeProprietarioAnimal = new ArrayList<>();
    Animal animal = new Animal(9876L,"Chiaua","Pink","Preta",LocalDate.now(),"toto");
    ProprietarioAnimal proprietarioAnimal = new ProprietarioAnimal("09878998765","ednilson","Pinto",LocalDate.now(),"rua texte, ","11987654321",animal);

    public DAOProprietarioAnimalTest() throws ParseException {
    }

    //Teste do servico  mapear objeto Edenilson Mauricio
    @Test
    void deve_mapearObjeto() throws IOException {
        ProprietarioAnimal mock = Mockito.mock(ProprietarioAnimal.class);

        //Terminar servico
    }


    @Test
    void deve_cadastrar() throws ParseException {

        //Mockito.when(mock.cadastrar(Mockito.any(ProprietarioAnimal.class))).thenReturn(listaDeProprietarioAnimal);

        listaDeProprietarioAnimal.add(proprietarioAnimal);

        Persistivel mock = Mockito.mock(Persistivel.class);



        DAOProprietarioAnimal daoProprietarioAnimal = new DAOProprietarioAnimal();
       // Animal animalRetorno = new Animal();
        daoProprietarioAnimal.cadastrar(proprietarioAnimal);

        assert(daoProprietarioAnimal.cadastrar(proprietarioAnimal).equals(animal));

    }

    @Test
    void deve_edita() throws ParseException {

        ArrayList<ProprietarioAnimal>  listaDeProprietarioAnimal = new ArrayList<>();
        Animal animal = new Animal(9876L,"Chiaua","Pink","Preta",LocalDate.now(),"toto");

        //Mockito.when(mock.cadastrar(Mockito.any(ProprietarioAnimal.class))).thenReturn(listaDeProprietarioAnimal);
        ProprietarioAnimal proprietarioAnimal = new ProprietarioAnimal("09878998765","ednilson","Pinto",LocalDate.now(),"rua texte, ","11987654321",animal);
        listaDeProprietarioAnimal.add(proprietarioAnimal);

        Persistivel mock = Mockito.mock(Persistivel.class);



        ProprietarioService daoProprietarioAnimal = new ProprietarioService();
        // Animal animalRetorno = new Animal();
        try {
            daoProprietarioAnimal.edita(proprietarioAnimal, proprietarioAnimal);
        } catch (IOException e) {
            e.printStackTrace();
        }

        assert(daoProprietarioAnimal.cadastrar(proprietarioAnimal).equals(animal));

    }


    @Test
    void deve_obterAnimal() throws ParseException, IOException {


        //Mockito.when(mock.cadastrar(Mockito.any(ProprietarioAnimal.class))).thenReturn(listaDeProprietarioAnimal);
        ProprietarioAnimal proprietarioAnimal = new ProprietarioAnimal("09878998765","ednilson","Pinto",LocalDate.now(),"rua texte, ","11987654321",animal);
        listaDeProprietarioAnimal.add(proprietarioAnimal);

        Persistivel mock = Mockito.mock(Persistivel.class);



        ProprietarioService daoProprietarioAnimal = new ProprietarioService();
        // Animal animalRetorno = new Animal();
        ProprietarioService.obterAnimal(proprietarioAnimal.getCpf()); //Edenilson

        assert(ProprietarioService.obterAnimal(proprietarioAnimal.getCpf()).equals(animal));

    }
    //POR CPF
    @Test
    void deve_obterProprietarioPorIdentificador() throws ParseException, IOException {

        Persistivel mock = Mockito.mock(Persistivel.class);

        IntefaceProprietarioService proprietarioService;
        // Animal animalRetorno = new Animal();

        IntefaceProprietarioService.obterAnimal("09878998765"); //Edenilson

        assert (IntefaceProprietarioService.obterAnimal(proprietarioAnimal.getCpf()).equals("09878998765"));
    }
}