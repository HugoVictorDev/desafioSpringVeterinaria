package com.meli.desafiospringveterinaria.controller;

import com.meli.desafiospringveterinaria.model.*;
import com.meli.desafiospringveterinaria.persistence.Persistivel;
import com.meli.desafiospringveterinaria.services.DAOAnimal;
import com.meli.desafiospringveterinaria.services.DAOConsulta;
import com.meli.desafiospringveterinaria.services.DAOProprietarioAnimal;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/proprietario")
public class ProprietarioController
{

    DAOProprietarioAnimal daoProprietarioAnimal = new DAOProprietarioAnimal();
    DAOAnimal daoAnimal = new DAOAnimal();

    @GetMapping("/consulta/{identificador}")
    public RespostaBase obter(@PathVariable ("identificador") String identificador) throws IOException {
        RespostaBase retorno = new RespostaBase();
        ProprietarioAnimal prop = daoProprietarioAnimal.obterPorIdentificador(identificador);

        if(prop == null) {
            retorno.Sucesso = false;
            retorno.Erros.add("Proprietario não localizado");
            return retorno;
        }

        retorno.Sucesso = true;
        retorno.Data = prop;
        return retorno;
    }

    @PostMapping("/cadastrar")
    public RespostaBase cadastrarProprietario( @RequestBody ProprietarioAnimal proprietario) {
        RespostaBase retorno = new RespostaBase();

        if(proprietario == null) {
            retorno.Erros.add("Favor fornecer os dados do proprietario");
        }
        else if(proprietario.getCpf() == null || proprietario.getCpf().length() <= 0) {
            retorno.Erros.add("Favor fornecer o CPF do proprietario");
        }
        else if(proprietario.getNome() == null || proprietario.getNome().length() <= 0) {
            retorno.Erros.add("Favor fornecer o Nome do proprietario");
        }
        else if(proprietario.getSobrenome() == null || proprietario.getSobrenome().length() <= 0) {
            retorno.Erros.add("Favor fornecer o Sobrenome do proprietario");
        }
        else if(proprietario.getDataNascimento() == null || proprietario.getDataNascimento().equals(LocalDate.MIN)) {
            retorno.Erros.add("Favor fornecer a Data de Nascimento do proprietario");
        }
        else if(proprietario.getEndereco() == null || proprietario.getEndereco().length() <= 0) {
            retorno.Erros.add("Favor fornecer o endereço do proprietario");
        }
        else if(proprietario.getTelefone() == null || proprietario.getTelefone().length() <= 0) {
            retorno.Erros.add("Favor fornecer o telefone do proprietario");
        }
        else if(proprietario.getAnimal() == null) {
            retorno.Erros.add("Favor fornecer os dados do Animal do proprietario");
        }
        else if(proprietario.getAnimal().getNumeroDoPaciente() <= 0) {
            retorno.Erros.add("Favor fornecer os dados do Animal do proprietario");
        }

        if(retorno.Erros.size() > 0){
            retorno.Sucesso = false;
            return retorno;
        }

        Animal animal = daoAnimal.obter2(proprietario.getAnimal());

        if(animal == null){
            retorno.Erros.add("O Animal informado ainda não está cadastrado, favor cadastrar antes de registrarmos o proprietario.");
            retorno.Sucesso = false;
            return retorno;
        }

      //  ProprietarioAnimal prop = daoProprietarioAnimal.obter(proprietario);
        ProprietarioAnimal prop = daoProprietarioAnimal.obterAnimal(proprietario);

        if(prop != null){
            retorno.Erros.add("Proprietario já cadastrado!");
            retorno.Sucesso = false;
            return retorno;
        }

        daoProprietarioAnimal.cadastrar(proprietario);

        retorno.Sucesso = true;
        retorno.Data = proprietario;
        return retorno;
    }


    @PutMapping("/editar")
    public RespostaBase atualizarProprietario( @RequestBody ProprietarioAnimal proprietario) {
        RespostaBase retorno = new RespostaBase();

        if(proprietario == null) {
            retorno.Erros.add("Favor fornecer os dados do proprietario");
        }
        else if(proprietario.getCpf() == null || proprietario.getCpf().length() <= 0) {
            retorno.Erros.add("Favor fornecer o CPF do proprietario");
        }
        else if(proprietario.getNome() == null || proprietario.getNome().length() <= 0) {
            retorno.Erros.add("Favor fornecer o Nome do proprietario");
        }
        else if(proprietario.getSobrenome() == null || proprietario.getSobrenome().length() <= 0) {
            retorno.Erros.add("Favor fornecer o Sobrenome do proprietario");
        }
        else if(proprietario.getDataNascimento() == null || proprietario.getDataNascimento().equals(LocalDate.MIN)) {
            retorno.Erros.add("Favor fornecer a Data de Nascimento do proprietario");
        }
        else if(proprietario.getEndereco() == null || proprietario.getEndereco().length() <= 0) {
            retorno.Erros.add("Favor fornecer o endereço do proprietario");
        }
        else if(proprietario.getTelefone() == null || proprietario.getTelefone().length() <= 0) {
            retorno.Erros.add("Favor fornecer o telefone do proprietario");
        }
        else if(proprietario.getAnimal() == null) {
            retorno.Erros.add("Favor fornecer os dados do Animal do proprietario");
        }
        else if(proprietario.getAnimal().getNumeroDoPaciente() <= 0) {
            retorno.Erros.add("Favor fornecer os dados do Animal do proprietario");
        }

        if(retorno.Erros.size() > 0){
            retorno.Sucesso = false;
            return retorno;
        }

        daoProprietarioAnimal.edita(proprietario);

        retorno.Sucesso = true;
        retorno.Data = proprietario;
        return retorno;
    }

    @GetMapping("/consulta/pacientes")
    public List<ProprietarioAnimal> listarProprietario() {
        return daoProprietarioAnimal.listagemConsulta();
    }


}
