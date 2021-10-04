package com.meli.desafiospringveterinaria.dto;

import com.meli.desafiospringveterinaria.model.Animal;

import java.time.LocalDate;

public class Proprietariodto {

    private String cpf;
    private String nome;
    private String sobrenome;
    private LocalDate dataNascimento;
    private String endereco;
    private String telefone;
    private Animal animal;


    //public Proprietariodto(String cpfProprietario, String nomeProprietario, String sobrenomeProprietario, LocalDate dataNascimentoProprietario, String endereco, String
    //        telefone, Animal animal) throws ParseException {
    public Proprietariodto (String cpf, String nome, String sobrenome, LocalDate dataNascimento, String endereco, String tefefone, Animal animal) {

        this.cpf = (cpf);
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.telefone = telefone;
        this.animal = animal;
    }


        public String Getcpf(){ return cpf; };
        public String Getnome(){ return nome; };
        public String Getsobrenome(){ return sobrenome; };
        public LocalDate GetdataNascimento(){ return dataNascimento; };
        public String Getendereco(){ return endereco; };
        public String Gettelefone(){ return telefone; };
        public Animal Getanimal(){ return animal; };


    public String getProprietario() {
        return this.Getnome();
    }
}
