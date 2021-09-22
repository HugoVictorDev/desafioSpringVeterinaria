package com.meli.desafiospringveterinaria.model;



import lombok.Getter;

import javax.swing.text.MaskFormatter;
import java.text.ParseException;
import java.time.LocalDate;

@Getter
public class ProprietarioAnimal {

    private String cpf;
    private String nome;
    private String sobrenome;
    private LocalDate dataNascimento;
    private String endereco;
    private String telefone;
    private Animal animal;


    public ProprietarioAnimal(String cpfProprietario, String nomeProprietario, String sobrenomeProprietario, LocalDate dataNascimentoProprietario, String endereco, String
            telefone, Animal animal) throws ParseException {

        this.cpf = formatarCpf(cpfProprietario);
        this.nome = nomeProprietario;
        this.sobrenome = sobrenomeProprietario;
        this.dataNascimento = dataNascimentoProprietario;
        this.endereco = endereco;
        this.telefone = telefone;
        this.animal = animal;


    }


    public String formatarCpf(String cpf) throws ParseException {
        MaskFormatter mf = new MaskFormatter("###.###.###-##");
        mf.setValueContainsLiteralCharacters(false);
        return mf.valueToString(cpf);
    }


}