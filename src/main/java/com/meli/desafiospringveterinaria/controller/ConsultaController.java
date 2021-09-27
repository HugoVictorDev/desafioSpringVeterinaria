package com.meli.desafiospringveterinaria.controller;


import com.meli.desafiospringveterinaria.model.Consulta;
import com.meli.desafiospringveterinaria.services.DAOConsulta;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consulta")
public class ConsultaController {


    DAOConsulta daOcosulta = new DAOConsulta();

    @PostMapping("/cadastrar")
    public Consulta cadastroConsulta(@RequestBody Consulta cosulta) {
        daOcosulta.cadastrar(cosulta);
        return cosulta;
    }

    @GetMapping("/medico/{nome}")
    public Consulta consultar(@PathVariable("nome") String nome) {
        Consulta consulta = daOcosulta.consultarMedico(nome);
        return consulta;
    }

    @PutMapping("/editar")
    public Consulta atualizarConsulta(@RequestBody Consulta consulta) {
        daOcosulta.editarConsulta(consulta);
        return consulta;
    }

    @GetMapping("/paciente/{numeroPaciente}")
    public List<Consulta> consultar(@PathVariable("numeroPaciente") Integer numeroPaciente) {
        return  daOcosulta.pacienteConsulta(numeroPaciente);
    }
}