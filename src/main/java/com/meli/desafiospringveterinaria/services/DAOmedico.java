package com.meli.desafiospringveterinaria.services;


import com.meli.desafiospringveterinaria.model.Medico;
import com.meli.desafiospringveterinaria.persistence.Persistivel;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class DAOmedico implements Persistivel<Medico> {

    List<Medico> medicos = new ArrayList<>();
   // @Override

    @Override
    public void cadastrar(Medico objMedico) {
        if(validaMedico(objMedico.getNumeroRegistro())) {
            medicos.add(objMedico);
        }else{throw new RuntimeException("Médico já cadastrado");
        }
    }

    @Override
    public List<Medico> listagem(){
        return medicos;
    }

    @Override
    public void editar(Medico obj) {
    }

    @Override
    public void obter(Medico obj) {

    }
    //metodo que valida se o medico ja existe verificando o registro
    private boolean validaMedico(long registroMedico) {
        for(Medico medico: listagem()) {
            if(medico.getNumeroRegistro() == (registroMedico)) {
                return false;
            }
        }
        return true;
    }

}
