package com.meli.desafiospringveterinaria.services;


import com.meli.desafiospringveterinaria.model.Medico;
import com.meli.desafiospringveterinaria.persistence.Persistence;
import com.meli.desafiospringveterinaria.persistence.Persistivel;
import lombok.Getter;

import java.util.List;

@Getter
public class DAOMedico implements Persistivel<Medico> {

  //  List<Medico> medicos = new ArrayList<>();
   // @Override


    Persistence persistence = new Persistence();

    @Override
    public void cadastrar(Medico objMedico) {
   //  medicos.add(objMedico);
        if(validaMedico(objMedico.getNumeroRegistro())) {
          persistence.cadastro(objMedico);
         }else{throw new RuntimeException("Médico já cadastrado");
        }
    }

    @Override
    public List<Medico> listagem(){
        return persistence.listagem();}

    @Override
    public void editar(Medico obj) {
    }

    @Override
    public void obeter(Medico obj) {

    }
//metodo que valida se o medico ja existe verificando o registro
    private boolean validaMedico(long registroMedico) {
        for(Medico medico: persistence.listagem()) {
            if(medico.getNumeroRegistro() == (registroMedico)) {
                return false;
            }
        }
        return true;
    }

}