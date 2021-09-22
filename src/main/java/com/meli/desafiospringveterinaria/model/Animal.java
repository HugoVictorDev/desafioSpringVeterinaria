package com.meli.desafiospringveterinaria.model;

import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
public class Animal {
    private Integer numeroDoPaciente;
    private String especie;
    private String raca;
    private String cor;
    private LocalDate dataDeNascimento;
    private String nome;
    List<Animal> animals = new ArrayList<>(); // sem uso por enquanto

    public Animal(int numeroDoPaciente, String especie, String raca, String cor, LocalDate dataDeNascimento, String nome) {
        this.numeroDoPaciente = numeroDoPaciente;
        this.especie = especie;
        this.raca = raca;
        this.cor = cor;
        this.dataDeNascimento = dataDeNascimento;
        this.nome = nome;
    }




    @Override
    public String toString() {
        return
                "numeroDoPaciente :" + numeroDoPaciente +
                ", especie :" + especie  +
                ", raca: " + raca  +
                ", cor: " + cor  +
                ", dataDeNascimento: " + dataDeNascimento +
                ", nome: " + nome

                ;
    }


}

