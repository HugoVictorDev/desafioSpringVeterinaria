package com.meli.desafiospringveterinaria.services;

import com.meli.desafiospringveterinaria.dao.DAOAnimal;
import com.meli.desafiospringveterinaria.model.Animal;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class AnimalServiceTest {

    List<Animal> listaAnimal = new ArrayList<>();
    Animal animal = new Animal(1111L, "Canina", "SRD", "Preto", LocalDate.parse("2020-05-01"), "Pingo");
    DAOAnimal daoAnimal = new DAOAnimal();

    @Test
    public void deveCadastrarAnimal() {

        listaAnimal.add(animal);
        daoAnimal.cadastrar(animal);

        assert(daoAnimal.cadastrar(animal).equals(animal));
    }

    @Test
    public void deveEditarAnimal(){

        for (Animal animal : listaAnimal){
            listaAnimal.add(daoAnimal.cadastrar(animal));
            listaAnimal.remove(animal);
            daoAnimal.edita(new Animal(1111L, "Felino", "SRD", "Amarelo", LocalDate.parse("2020-05-01"), "Castro"));
        }
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
