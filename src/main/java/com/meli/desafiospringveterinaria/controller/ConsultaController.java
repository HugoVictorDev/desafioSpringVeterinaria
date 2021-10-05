package com.meli.desafiospringveterinaria.controller;



import com.meli.desafiospringveterinaria.dao.DAOConsulta;
import com.meli.desafiospringveterinaria.model.Consulta;


import com.meli.desafiospringveterinaria.dao.DAOConsulta;
import com.meli.desafiospringveterinaria.model.Consulta;

import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/consulta")
public class ConsultaController {

    DAOConsulta daoConsulta = new DAOConsulta();

    @PostMapping("/cadastrar")
    public Consulta cadastroConsulta(@RequestBody Consulta consulta) throws IOException {
        daoConsulta.cadastrar(consulta);
        return consulta;
    }

    @PutMapping("/editar")
    public Consulta atualizarConsulta(@RequestBody Consulta consulta) {
        daoConsulta.editarConsulta(consulta);
        return consulta;
    }

    @GetMapping("/paciente/{numeroDoPaciente}")
    public List<Consulta> consultar(@PathVariable("numeroDoPaciente") long numeroDoPaciente) throws IOException {
        return  daoConsulta.pacienteConsulta(numeroDoPaciente);
    }

    @GetMapping("/listadeconsultas/{data}")
    public List<Consulta> consultarPorData(@PathVariable("data") String data) throws IOException {
        return daoConsulta.listagemPorData(data);
    }

    @GetMapping("/consultasporcpf/{cpfDoMedico}")
    public List<Consulta> listagemMedicoConsultas(@PathVariable("cpfDoMedico") String cpfDoMedico) throws IOException {
        return daoConsulta.listagemMedicoConsulta(cpfDoMedico);
    }
}