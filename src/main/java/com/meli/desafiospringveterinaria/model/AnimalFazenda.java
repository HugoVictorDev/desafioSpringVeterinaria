package com.meli.desafiospringveterinaria.model;

import java.time.LocalDate;

//sem uso ate o momento
public class AnimalFazenda extends Animal{
    public AnimalFazenda(long numeroDoPaciente, String especie, String raca, String cor, LocalDate dataDeNascimento, String nome) {
        super(numeroDoPaciente, especie, raca, cor, dataDeNascimento, nome);
    }
}
