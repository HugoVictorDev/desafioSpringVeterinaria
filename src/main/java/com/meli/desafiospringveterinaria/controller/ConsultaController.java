package com.meli.desafiospringveterinaria.controller;


import com.meli.desafiospringveterinaria.model.Consulta;
import com.meli.desafiospringveterinaria.services.DAOConsulta;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/consulta")
public class ConsultaController {

    DAOConsulta daoConsulta = new DAOConsulta();

    @PostMapping("/cadastrar")
    public Consulta cadastroConsulta(@RequestBody Consulta cosulta) {
        daoConsulta.cadastrar(cosulta);
        return cosulta;
    }

    @PutMapping("/editar")
    public Consulta atualizarConsulta(@RequestBody Consulta consulta) {
        daoConsulta.editarConsulta(consulta);
        return consulta;
    }

    @GetMapping("/paciente/{numeroPaciente}")
    public List<Consulta> consultar(@PathVariable("numeroPaciente") Integer numeroPaciente) {
        return  daoConsulta.pacienteConsulta(numeroPaciente);
    }

    @GetMapping("/listadeconsultas/{data}")
    public List<Consulta> consultarPorData(@PathVariable("data") String data) throws IOException {
        return daoConsulta.listagem2(data);
    }

    @GetMapping("/consultasporcpf/{cpfDoMedico}")
    public List<Consulta> listagemMedicoConsultas(@PathVariable("cpfDoMedico") String cpfDoMedico) throws IOException {
    return daoConsulta.listagemMedicoConsulta(cpfDoMedico);
    }
}