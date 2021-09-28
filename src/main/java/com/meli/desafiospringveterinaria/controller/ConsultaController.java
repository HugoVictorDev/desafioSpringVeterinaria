package com.meli.desafiospringveterinaria.controller;


import com.meli.desafiospringveterinaria.model.Consulta;
import com.meli.desafiospringveterinaria.model.Medico;
import com.meli.desafiospringveterinaria.services.DAOConsulta;

import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/consulta")
public class ConsultaController {


    DAOConsulta daOcosulta = new DAOConsulta();

    @PostMapping("/cadastrar")
    public Consulta cadastroConsulta(@RequestBody Consulta cosulta ){
        daOcosulta.cadastrar(cosulta);
        return cosulta;
    }

    @GetMapping("/medico/{nome}")
    public Consulta consultar(@PathVariable("nome") String nome) {
        Consulta consulta = daOcosulta.consultarMedico(nome);
        return consulta;
    }

    @GetMapping("/listadeconsultas/{data}")
    public List<Consulta> listagemMedicoConsulta(@PathVariable("data") String data) throws IOException {

        return daOcosulta.listagem2(data);
    }

    @GetMapping("/consultasporcpf/{cpfDoMedico}")
    public List<Consulta> listagemMedicoConsultas(@PathVariable("cpfDoMedico") String cpfDoMedico) throws IOException {

        return daOcosulta.listagemMedicoConsulta(cpfDoMedico);
    }

    @PutMapping("/editar")
    public Consulta atualizarMedico(@RequestBody Consulta consulta){
        daOcosulta.edita(consulta);
        return consulta;

    }




}