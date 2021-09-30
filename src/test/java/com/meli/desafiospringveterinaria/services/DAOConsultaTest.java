package com.meli.desafiospringveterinaria.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.meli.desafiospringveterinaria.dao.DAOConsulta;
import com.meli.desafiospringveterinaria.model.Animal;
import com.meli.desafiospringveterinaria.model.Consulta;
import com.meli.desafiospringveterinaria.model.Medico;
import com.meli.desafiospringveterinaria.persistence.Persistivel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class DAOConsultaTest  {

    Consulta consulta = new Consulta();
    DAOConsulta daoConsulta = new DAOConsulta();

    Consulta consulta1 = new Consulta(LocalDate.now(), "dsds","di","dsd", new Medico(), new Animal());
    Consulta consulta2 = new Consulta(LocalDate.now(), "dsds","di","dsd", new Medico(), new Animal());

//-- ----------- tests ------------------------//





}
