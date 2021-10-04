package com.meli.desafiospringveterinaria.model;

import lombok.Data;
import java.time.LocalDate;

@Data
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