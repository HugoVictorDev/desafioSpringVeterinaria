package com.meli.desafiospringveterinaria.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class Consulta {
    private LocalDate dataHora;
    private String motivo;
    private String diagnostico;
    private String tratamento;
    private Medico medico;
    private Animal animal;

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
