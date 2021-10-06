package com.meli.desafiospringveterinaria.model;




import lombok.Getter;
import lombok.Setter;

import javax.swing.text.MaskFormatter;
import java.text.ParseException;
import java.time.LocalDate;

@Getter
@Setter
public class ProprietarioAnimal {

    private String cpf;
    private String nome;
    private String sobrenome;
    private LocalDate dataNascimento;
    private String endereco;
    private String telefone;
    private Animal animal;

    //ArquivoUtil arquivoUtil = new ArquivoUtil();
    public ProprietarioAnimal(String cpfProprietario, String nomeProprietario, String sobrenomeProprietario, LocalDate dataNascimentoProprietario, String endereco, String
            telefone, Animal animal) {

        this.cpf = (cpfProprietario);
        this.nome = nomeProprietario;
        this.sobrenome = sobrenomeProprietario;
        this.dataNascimento = dataNascimentoProprietario;
        this.endereco = endereco;
        this.telefone = telefone;
        this.animal = animal;


    }

    public ProprietarioAnimal() {
    }

    @Override
    public String toString() {
        return "ProprietarioAnimal{" +
                "cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", endereco='" + endereco + '\'' +
                ", telefone='" + telefone + '\'' +
                ", animal=" + animal +
                '}';
    }

    public String getProprietario() {
        return nome;
    }



}