package com.meli.desafiospringveterinaria.services;

import com.fasterxml.jackson.core.type.TypeReference;
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

    //consulta estanciada
    Consulta consulta1 = new Consulta(LocalDate.now(), "dsds","di","dsd", new Medico(), new Animal());
    Consulta consulta2 = new Consulta(LocalDate.now(), "dsds","di","dsd", new Medico(), new Animal());

//-- ----------- tests ------------------------//

    @Test
    public void editarConsultaTestRetornaConsultaEditada(){

       Consulta editarConsulta = daoConsulta.editarConsulta(consulta1);

        Assertions.assertEquals(null, editarConsulta);


    }

//
//    public Consulta editarConsulta (Consulta objConsulta) {
//        mapearObjeto();
//        try {
//            consultaList = objectMapper.readValue(new File("consulta.json"), new TypeReference<List<Consulta>>(){});
//            for (Consulta consulta : consultaList){
//                if (consulta.getAnimal().getNome().equals(objConsulta.getAnimal().getNome())) {
//                    consultaList.remove(consulta);
//                    consultaList.add(objConsulta);
//                    objectMapper.writeValue(new File("consulta.json"), consultaList);
//                    return consulta;
//                }
//            }throw new RuntimeException("Consulta não encotrada");
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//        return null;
//    }
}
