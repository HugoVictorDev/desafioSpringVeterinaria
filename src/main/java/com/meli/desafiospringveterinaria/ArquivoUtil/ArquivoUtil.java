package com.meli.desafiospringveterinaria.ArquivoUtil;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import com.google.gson.Gson;
import com.meli.desafiospringveterinaria.model.Animal;
import com.meli.desafiospringveterinaria.model.Medico;

public class ArquivoUtil {

public void gravaArquivo(List<Medico> medico){

      Gson gson = new Gson();
      String json = gson.toJson(medico);

    try {
        //Escreve Json convertido em arquivo chamado "file.json"
        FileWriter writer = new FileWriter("medico.json");
        writer.write(json);
        writer.close();

    } catch (IOException e) {
        e.printStackTrace();
    }
    }

    public void gravarAnimal(List<Animal> animal){
    Gson gson = new Gson();
    String json = gson.toJson(animal);

    try {
        FileWriter writer = new FileWriter("animal.json");
        writer.write(json);
        writer.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
    }
}

