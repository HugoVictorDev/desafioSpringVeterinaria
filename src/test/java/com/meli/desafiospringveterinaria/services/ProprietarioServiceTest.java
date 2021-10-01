package com.meli.desafiospringveterinaria.services;

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


    @Before
    public  void setUp(){
        proprietarioAnimalDao = mock(DAOProprietarioAnimal.class);
        animalDao = mock(DAOAnimal.class);

        service = new ProprietarioService(proprietarioAnimalDao, animalDao);
    }

    @Test
    public void obterPorIdentificadorTest() throws ParseException {
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

    @Test
    public void cadastrarProprietarioTeste() throws ParseException {

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
    public void atualizarProprietarioTeste() throws ParseException {
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

        RespostaBase respostaBase = service.atualizarProprietario(proprietarioAnimal);

        assertEquals(true, respostaBase.Sucesso);
    }

    @Test
    public void listagemConsultaTest() throws ParseException {
        List<ProprietarioAnimal> lista =  new ArrayList<ProprietarioAnimal>();

        when(proprietarioAnimalDao.listagem()).thenReturn(lista);

        RespostaBase respostaBase = service.listagemConsulta();

        assertEquals(true, respostaBase.Sucesso);
    }
}

