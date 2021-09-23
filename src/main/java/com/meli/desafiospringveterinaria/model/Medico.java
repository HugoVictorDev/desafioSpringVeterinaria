package com.meli.desafiospringveterinaria.model;


import lombok.Data;
import lombok.Getter;


@Data
@Getter
public class Medico {
    private String cpfMedico;
    private String nomeMedico;
    private String sobrenomeMedico;
    private long numeroRegistro;
    private String especielidade;

    public Medico(String cpfMedico, String nomeMedico, String sobrenomeMedico, long numeroRegistro, String especielidade) {
        this.cpfMedico = cpfMedico;
        this.nomeMedico = nomeMedico;
        this.sobrenomeMedico = sobrenomeMedico;
        this.numeroRegistro = numeroRegistro;
        this.especielidade = especielidade;
    }

    public Medico(){};


    @Override
    public String toString() {
        return "cpfMedico: " + this.cpfMedico + ", nomeMedico: " + this.nomeMedico + ", sobrenomeMedico: " + this.sobrenomeMedico + ", numeroRegistro: " + this.numeroRegistro + ", especielidade: " + this.especielidade;
    }
}
