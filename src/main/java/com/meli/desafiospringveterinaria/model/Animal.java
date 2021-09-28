package com.meli.desafiospringveterinaria.model;

import lombok.Getter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
public class Animal {
    private Long numeroDoPaciente;
    private String especie;
    private String raca;
    private String cor;
    private LocalDate dataDeNascimento;
    private String nome;


    public Animal(Long numeroDoPaciente, String especie, String raca, String cor, LocalDate dataDeNascimento, String nome) {
        this.numeroDoPaciente = numeroDoPaciente;
        this.especie = especie;
        this.raca = raca;
        this.cor = cor;
        this.dataDeNascimento = dataDeNascimento;
        this.nome = nome;
    }

    public static Animal obter(Animal animal) {return null;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "numeroDoPaciente=" + numeroDoPaciente +
                ", especie='" + especie + '\'' +
                ", raca='" + raca + '\'' +
                ", cor='" + cor + '\'' +
                ", dataDeNascimento=" + dataDeNascimento +
                ", nome='" + nome + '\'' +
                '}';
    }
}