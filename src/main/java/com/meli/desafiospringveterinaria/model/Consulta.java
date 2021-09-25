package com.meli.desafiospringveterinaria.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class Consulta {
    private LocalDate dataHora;
    private String motivo;
    private String diagnostico;
    private String tratamento;
    private Medico medico;
    private Animal animal;

    public Consulta(LocalDate dataHora, String motivo, String diagnostico, String tratamento, Medico medico, Animal animal) {
        this.dataHora = dataHora;
        this.motivo = motivo;
        this.diagnostico = diagnostico;
        this.tratamento = tratamento;
        this.medico = medico;
        this.animal = animal;
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
