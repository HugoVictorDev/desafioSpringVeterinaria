package com.meli.desafiospringveterinaria.model;

import java.util.ArrayList;
import java.util.List;

public class RespostaBase
{
    public RespostaBase(){
        this.Erros = new ArrayList<String>();
    }

    public boolean Sucesso;
    public List<String> Erros;
    public Object Data;
}
