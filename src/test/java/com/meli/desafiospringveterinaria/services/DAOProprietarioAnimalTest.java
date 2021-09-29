package com.meli.desafiospringveterinaria.services;

import com.meli.desafiospringveterinaria.model.Animal;
import com.meli.desafiospringveterinaria.model.ProprietarioAnimal;
import com.meli.desafiospringveterinaria.model.RespostaBase;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
public class DAOProprietarioAnimalTest {

    //Teste do servico  mapear objeto Edenilson Mauricio
    @Test
    void deve_mapearObjeto() throws IOException {
        ProprietarioAnimal mock = Mockito.mock(ProprietarioAnimal.class);

        //Terminar servico
    }


    @Test
    void deve_cadastrar() throws ParseException {
      //  ProprietarioAnimal mock = Mockito.mock(ProprietarioAnimal.class);
        DAOProprietarioAnimal mock = Mockito.mock(DAOProprietarioAnimal.class);
      //  DAOProprietarioAnimal daoProprietarioAnimal = new DAOProprietarioAnimal();
        DAOAnimal daoAnimal = new DAOAnimal();
        Animal animal = new Animal(9876L,"Chiaua","Pink","Preta",LocalDate.now(),"toto");

        ProprietarioAnimal proprietarioAnimal = new ProprietarioAnimal("09878998765","ednilson","Pinto",LocalDate.now(),"rua texte, ","11987654321",animal);

        //ProprietarioAnimal prop = daoProprietarioAnimal.obterPorIdentificador(identificador);


        Mockito.when(mock.cadastrar(Mockito.any(DAOProprietarioAnimal.class),ProprietarioAnimal proprietarioAnimal)
                .thenReturn(proprietarioAnimal);
        Mockito.when(mock.listagem())
                .thenReturn(lista);

        VendedorService vendedorService = new VendedorService(mock);
        vendedorService.cadastrar(vendedor);
        assertNotNull(vendedor.getCodigo());
    }
    }
}