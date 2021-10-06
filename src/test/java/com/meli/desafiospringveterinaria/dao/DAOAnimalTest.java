package com.meli.desafiospringveterinaria.dao;

import com.meli.desafiospringveterinaria.dao.DAOAnimal;
import com.meli.desafiospringveterinaria.model.Animal;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class DAOAnimalTest {

    List<Animal> listaAnimal = new ArrayList<>();
    Animal animal = new Animal(1111L, "Canina", "SRD", "Preto", LocalDate.parse("2020-05-01"), "Pingo");
    DAOAnimal daoAnimal = new DAOAnimal();

    @Test
    public void deveCadastrarAnimal() {

        daoAnimal.cadastrar(animal);

        assert(daoAnimal.cadastrar(animal).equals(animal));
    }

    @Test
    public void deveEditarAnimal(){
        Animal animal = new Animal(1111L, "Felino", "SRD", "Preto", LocalDate.parse("2020-05-01"), "Pingo");
        listaAnimal.add(animal);
        assert(daoAnimal.edita(animal).equals(animal));

    }

    @Test
    public void deveMapearObjeto(){

        DAOAnimal mock = Mockito.mock(DAOAnimal.class);
    }

//    @Test
//    public void deveConsultarPorNum(Animal novoAnimal){
//
//        for (Animal animal : listaAnimal) {
//            if (animal.getNumeroDoPaciente() == novoAnimal.getNumeroDoPaciente()){
//                daoAnimal.consultarAnimal(1111);
//            }
//        }
//
//    }

}
