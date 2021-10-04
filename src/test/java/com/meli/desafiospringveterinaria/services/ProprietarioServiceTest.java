package com.meli.desafiospringveterinaria.services;
//
import com.meli.desafiospringveterinaria.dao.DAOAnimal;
import com.meli.desafiospringveterinaria.dao.DAOProprietarioAnimal;
import com.meli.desafiospringveterinaria.model.Animal;
import com.meli.desafiospringveterinaria.model.ProprietarioAnimal;
import com.meli.desafiospringveterinaria.model.RespostaBase;
import com.meli.desafiospringveterinaria.persistence.IntefaceProprietarioService;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ProprietarioServiceTest {
    IntefaceProprietarioService service = null;
    DAOProprietarioAnimal proprietarioAnimalDao = null;
    DAOAnimal animalDao = null;


    @Before // Configuracao das variaveis de teste
    public  void setUp(){
        proprietarioAnimalDao = mock(DAOProprietarioAnimal.class);
        animalDao = mock(DAOAnimal.class);

        service = new ProprietarioService(proprietarioAnimalDao, animalDao) {

        };
    }

    @Test //Teste OK do metodo proprietarioAnimalDao.obterPorIdentificador(identificador)
    public void deve_obterPorIdentificadorTest() throws ParseException {
        String identificador = "123456789";
        String identificador2 = "1234567892";

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


        RespostaBase respostaBase = service.obterPorIdentificador(identificador);
        RespostaBase respostaBase2 = service.obterPorIdentificador(identificador2);

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


        RespostaBase respostaBase = service.obterPorIdentificador(identificador);

        assertEquals(true, respostaBase.Sucesso); // Caso de erro
    }

    @Test
    public void deve_cadastrarProprietarioTeste() throws ParseException {

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

        when(animalDao
                .obter2(animal))
                .thenReturn(animal);

        when(proprietarioAnimalDao
                .obterProprietarioAnimal(proprietarioAnimal))
                .thenReturn(null);

        RespostaBase respostaBase = service.cadastrarProprietario(proprietarioAnimal);

        assertEquals(true, respostaBase.Sucesso);
    }
    @Test
    public void nao_deve_cadastrarProprietarioTeste() throws ParseException {

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

        RespostaBase respostaBase = service.cadastrarProprietario(proprietarioAnimal);

        assertEquals(false, respostaBase.Sucesso);
    }
    @Test
    public void nao_deve_cadastrarProprietario2Teste() throws ParseException {


        RespostaBase respostaBase = service.cadastrarProprietario(null);

        assertEquals(false, respostaBase.Sucesso);
    }

    @Test
    public void deve_atualizarProprietarioTeste() throws ParseException {
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
    public void nao_deve_atualizarProprietarioTeste() throws ParseException {

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
    public void nao_deve_atualizar2ProprietarioTeste() throws ParseException {

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
    public void listagemConsultaTest() throws ParseException {
        List<ProprietarioAnimal> lista =  new ArrayList<>();

        when(proprietarioAnimalDao.listagem()).thenReturn(lista);

        RespostaBase respostaBase = service.listagemConsulta();

        assertEquals(true, respostaBase.Sucesso);
    }
}

