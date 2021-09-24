package com.meli.desafiospringveterinaria.model;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Consulta {
    private LocalDateTime dataHora;
    private String motivo;
    private String diagnostico;
    private String tratamento;
    private Medico medico;
    private Animal animal;

    public Consulta(LocalDateTime dataHora, String motivo, String diagnostico, String tratamento, Medico medico, Animal animal) {
        this.dataHora = dataHora;
        this.motivo = motivo;
        this.diagnostico = diagnostico;
        this.tratamento = tratamento;
        this.medico = medico;
        this.animal = animal;
    }

    public Consulta() {
    }

    @Override
    public String toString() {
        return
                "Data da Consulta: " + dataHora +
                ", motivo: " + motivo +
                ", diagnostico: " + diagnostico +
                ", tratamento: " + tratamento + "\n" +
                "medico associado: " + medico + "\n" +
                "animal associado: " + animal
                ;
    }
}
