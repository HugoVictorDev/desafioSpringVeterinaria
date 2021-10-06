package com.meli.desafiospringveterinaria.services;

import com.meli.desafiospringveterinaria.dao.DAOAnimal;
import com.meli.desafiospringveterinaria.dao.DAOProprietarioAnimal;
import com.meli.desafiospringveterinaria.model.Animal;
import com.meli.desafiospringveterinaria.model.ProprietarioAnimal;
import com.meli.desafiospringveterinaria.model.RespostaBase;
import com.meli.desafiospringveterinaria.persistence.IntefaceProprietarioService;
import org.junit.Test;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ProprietarioServiceTest {
    IntefaceProprietarioService service;
    DAOProprietarioAnimal proprietarioAnimalDao;
    DAOAnimal animalDao;
    RespostaBase respostaBase;

    Animal animal = new Animal(
            123456789L,
            "Cachorro",
            "Yorkshire",
            "preto",
            LocalDate.now(),
            "Fadinha"
    );

    ProprietarioAnimal proprietarioAnimal = new ProprietarioAnimal(
            "123456789",
            "Teste",
            "Mockado",
            LocalDate.now(),
            "Rua Teste Unitario",
            "11999999999",
            animal
    );



    @Test //Teste OK do metodo proprietarioAnimalDao.obterPorIdentificador(identificador)
    public void deve_obterPorIdentificadorTest() throws ParseException {

        proprietarioAnimalDao = mock(DAOProprietarioAnimal.class);
        //proprietariolDao = new DAOAnimal(ProprietarioService.class);
        animalDao = mock(DAOAnimal.class);
        String identificador = "123456789";
        String identificador2 = "1234567892";

        when(proprietarioAnimalDao.obterPorIdentificador(identificador))
                .thenReturn(proprietarioAnimal);


        ProprietarioAnimal proprietarioAnimal = service.obterPorIdentificador(identificador);
        //RespostaBase respostaBase2 = service.obterPorIdentificador(identificador2);

        assertEquals(true, respostaBase.Sucesso);
        //assertEquals(true, respostaBase2.Sucesso); // Caso de erro
    }

    @Test //Teste de Recusa do metodo obterPorIdentificador(identificador)
    public void nao_deve_obterPorIdentificadorTest() throws ParseException {
        String identificador = "1234567892";

        when(proprietarioAnimalDao.obterPorIdentificador(identificador))
                .thenReturn(
                        new ProprietarioAnimal(
                                identificador,
                                "Teste",
                                "Mockado",
                                LocalDate.now(),
                                "Rua Teste Unitario",
                                "11999999999",
                                null
                        ));


    //    RespostaBase respostaBase = proprietarioService.obterPorIdentificador(identificador);

        assertEquals(true, respostaBase.Sucesso); // Caso de erro
    }

    @Test
    public void deve_cadastrarProprietarioTeste() throws ParseException, IOException {

        Animal animal = new Animal(
                123456789L,
                "Cachorro",
                "Yorkshire",
                "preto",
                LocalDate.now(),
                "Fadinha"
        );

        ProprietarioAnimal proprietarioAnimal = new ProprietarioAnimal(
                "123456789",
                "Teste",
                "Mockado",
                LocalDate.now(),
                "Rua Teste Unitario",
                "11999999999",
                animal
        );

        when(animalDao.obter2(animal)).thenReturn(animal);

        when(proprietarioAnimalDao
                .obterProprietarioAnimal(proprietarioAnimal))
                .thenReturn(null);

        proprietarioAnimal = proprietarioAnimalDao.cadastrarProprietario(proprietarioAnimal);

        assertEquals(true, respostaBase);
    }
    @Test
    public void nao_deve_cadastrarProprietarioTeste() throws ParseException, IOException {

        Animal animal = new Animal(
                123456789L,
                "Cachorro",
                "Yorkshire",
                "preto",
                LocalDate.now(),
                "Fadinha"
        );

        ProprietarioAnimal proprietarioAnimal = new ProprietarioAnimal(
                "123456789",
                "Teste",
                "Mockado",
                LocalDate.now(),
                "Rua Teste Unitario",
                "11999999999",
                null
        );

        when(animalDao
                .obter2(animal))
                .thenReturn(animal);

        when(proprietarioAnimalDao
                .obterProprietarioAnimal(proprietarioAnimal))
                .thenReturn(null);

        ProprietarioAnimal proprietarioAnimal1 = service.cadastrarProprietario(proprietarioAnimal);

        assertEquals(proprietarioAnimal, proprietarioAnimal1);
    }

    @Test
    public void nao_deve_cadastrarProprietario2Teste() throws ParseException {


        ProprietarioAnimal proprietarioAnimal = service.cadastrarProprietario(null);

        assertEquals(proprietarioAnimal, respostaBase.Sucesso);
    }

    @Test
    public void deve_atualizarProprietarioTeste() throws ParseException, IOException {
        Animal animal = new Animal(
                123456789L,
                "Cachorro",
                "Yorkshire",
                "preto",
                LocalDate.now(),
                "Fadinha"
        );

        ProprietarioAnimal proprietarioAnimal = new ProprietarioAnimal(
                "123456789",
                "Teste",
                "Mockado",
                LocalDate.now(),
                "Rua Teste Unitario",
                "11999999999",
                animal
        );

        when(animalDao.obter2(animal)).thenReturn(animal);

        when(proprietarioAnimalDao.obterProprietarioAnimal(proprietarioAnimal))
                .thenReturn(proprietarioAnimal);

        RespostaBase respostaBase = service.atualizarProprietario(proprietarioAnimal, proprietarioAnimal);

        assertEquals(true, respostaBase.Sucesso);
    }

    @Test
    public void nao_deve_atualizarProprietarioTeste() throws ParseException, IOException {

        Animal animal = new Animal(
                123456789L,
                "Cachorro",
                "Yorkshire",
                "preto",
                LocalDate.now(),
                "Fadinha"
        );

        ProprietarioAnimal proprietarioAnimal = new ProprietarioAnimal(
                "123456789",
                "Teste",
                "Mockado",
                LocalDate.now(),
                "Rua Teste Unitario",
                "11999999999",
                animal
        );

        ProprietarioAnimal proprietarioAnimal2 = new ProprietarioAnimal(
                null,
                null,
                null,
                LocalDate.now(),
                null,
                null,
                animal
        );

        when(animalDao.obter2(animal)).thenReturn(animal);

        when(proprietarioAnimalDao.obterProprietarioAnimal(proprietarioAnimal))
                .thenReturn(proprietarioAnimal);

        RespostaBase respostaBase = service.atualizarProprietario(proprietarioAnimal, proprietarioAnimal2);

        assertEquals(false, respostaBase.Sucesso);
    }

    @Test
    public void nao_deve_atualizar2ProprietarioTeste() throws ParseException, IOException {

        Animal animal = new Animal(
                123456789L,
                "Cachorro",
                "Yorkshire",
                "preto",
                LocalDate.now(),
                "Fadinha"
        );

        ProprietarioAnimal proprietarioAnimal = new ProprietarioAnimal(
                null,
                null,
                null,
                LocalDate.now(),
                null,
                null,
                animal
        );

        ProprietarioAnimal proprietarioAnimal2 = new ProprietarioAnimal(
                null,
                null,
                null,
                LocalDate.now(),
                null,
                null,
                animal
        );

        when(animalDao.obter2(animal)).thenReturn(animal);

        when(proprietarioAnimalDao.obterProprietarioAnimal(proprietarioAnimal))
                .thenReturn(proprietarioAnimal);

        RespostaBase respostaBase = service.atualizarProprietario(proprietarioAnimal, proprietarioAnimal2);

        assertEquals(false, respostaBase.Sucesso);
    }


    @Test
    public void nao_deve_atualizar3ProprietarioTeste() throws ParseException, IOException {

        Animal animal = new Animal(
                123456789L,
                "Cachorro",
                "Yorkshire",
                "preto",
                LocalDate.now(),
                "Fadinha"
        );

        ProprietarioAnimal proprietarioAnimal = new ProprietarioAnimal(
                null,
                null,
                null,
                LocalDate.now(),
                null,
                null,
                null
        );

        ProprietarioAnimal proprietarioAnimal2 = new ProprietarioAnimal(
                null,
                null,
                null,
                LocalDate.now(),
                null,
                null,
                null
        );

        when(animalDao.obter2(animal)).thenReturn(animal);

        when(proprietarioAnimalDao.obterProprietarioAnimal(proprietarioAnimal))
                .thenReturn(proprietarioAnimal);

        RespostaBase respostaBase = service.atualizarProprietario(proprietarioAnimal, proprietarioAnimal2);

        assertEquals(false, respostaBase.Sucesso);
    }







    @Test
    public void listagemConsultaTest() throws ParseException {
        List<ProprietarioAnimal> lista =  new ArrayList<>();

        when(proprietarioAnimalDao.listagem()).thenReturn(lista);

        RespostaBase respostaBase = service.listagemConsulta();

        assertEquals(true, respostaBase.Sucesso);
    }
}

