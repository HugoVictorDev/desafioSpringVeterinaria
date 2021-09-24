package com.meli.desafiospringveterinaria.ArquivoUtil;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.gson.Gson;

import com.meli.desafiospringveterinaria.model.Medico;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import org.json.simple.JSONArray;

import org.json.simple.parser.JSONParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ArquivoUtil {

    public void gravaArquivo(List<Medico> medico) {

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

    public Medico lerArquivo() throws JSONException, IOException, ParseException {

        return null;
    }





}

