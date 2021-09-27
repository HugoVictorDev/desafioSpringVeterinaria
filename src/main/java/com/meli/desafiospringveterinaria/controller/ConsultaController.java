package com.meli.desafiospringveterinaria.controller;


import com.meli.desafiospringveterinaria.model.Consulta;
import com.meli.desafiospringveterinaria.model.Medico;
import com.meli.desafiospringveterinaria.services.DAOConsulta;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/editar")
    public Consulta atualizarMedico(@RequestBody Consulta consulta){
        daOcosulta.edita(consulta);
        return consulta;

    }

}