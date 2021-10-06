package com.meli.desafiospringveterinaria.services;


import com.meli.desafiospringveterinaria.arquivoUtil.ArquivoUtil;
import com.meli.desafiospringveterinaria.dao.DAOAnimal;
import com.meli.desafiospringveterinaria.dao.*;
import com.meli.desafiospringveterinaria.model.Animal;
import com.meli.desafiospringveterinaria.model.ProprietarioAnimal;
import com.meli.desafiospringveterinaria.model.RespostaBase;


import java.io.IOException;
import java.time.LocalDate;
import java.util.List;


public class ProprietarioService {

    ArquivoUtil arquivoUtil = new ArquivoUtil();
    List<ProprietarioAnimal> proprietarioAnimalList;
    DAOProprietarioAnimal daoProprietarioAnimal;
    DAOAnimal daoAnimal;


    public ProprietarioService(ArquivoUtil arquivoUtil){
        this.arquivoUtil = arquivoUtil;
    }

    public ProprietarioService(DAOProprietarioAnimal _daoProprietarioAnimal, DAOAnimal _daoAnimal)
    {
        daoProprietarioAnimal = _daoProprietarioAnimal;
    }


    public ProprietarioAnimal obterPorIdentificador(String Identificador)
    {
        RespostaBase retorno = new RespostaBase();

        if(Identificador == null || Identificador.length() == 0){
            retorno.Sucesso = false;
            retorno.Erros.add("Identificador vazio");
        }

        ProprietarioAnimal prop = daoProprietarioAnimal.obterPorIdentificador(Identificador);

        if(prop == null) {
            retorno.Sucesso = false;
            retorno.Erros.add("Proprietario não localizado");
        }
        else
        {
            retorno.Sucesso = true;
            retorno.Data = prop;
        }

        return prop;
    }

    public RespostaBase cadastrarProprietario(ProprietarioAnimal proprietario) throws IOException {
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

        if(retorno.Erros.size() > 0)
        {
            retorno.Sucesso = false;
            return retorno;
        }

        Animal animal = daoAnimal.obter2(proprietario.getAnimal());

        if(animal == null){
            retorno.Erros.add("O Animal informado ainda não está cadastrado, favor cadastrar antes de registrarmos o proprietario.");
            retorno.Sucesso = false;
            return retorno;
        }

        ProprietarioAnimal prop = daoProprietarioAnimal.obterProprietarioAnimal(proprietario);

        if(prop != null){
            retorno.Erros.add("Proprietario já cadastrado!");
            retorno.Sucesso = false;
            return retorno;
        }
        return retorno;

    }

    public  RespostaBase atualizarProprietario(ProprietarioAnimal proprietario, ProprietarioAnimal proprietario2) throws IOException {
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


        //Validacao do proprietario2

        if(proprietario2 == null) {
            retorno.Erros.add("Favor fornecer os dados do proprietario2");
        }

        else if(proprietario2.getCpf() == null || proprietario2.getCpf().length() <= 0) {
            retorno.Erros.add("Favor fornecer o CPF do proprietario2");
        }
        else if(proprietario2.getNome() == null || proprietario2.getNome().length() <= 0) {
            retorno.Erros.add("Favor fornecer o Nome do proprietario2");
        }
        else if(proprietario2.getSobrenome() == null || proprietario2.getSobrenome().length() <= 0) {
            retorno.Erros.add("Favor fornecer o Sobrenome do proprietario2");
        }
        else if(proprietario2.getDataNascimento() == null || proprietario2.getDataNascimento().equals(LocalDate.MIN)) {
            retorno.Erros.add("Favor fornecer a Data de Nascimento do proprietario2");
        }
        else if(proprietario2.getEndereco() == null || proprietario2.getEndereco().length() <= 0) {
            retorno.Erros.add("Favor fornecer o endereço do proprietario2");
        }
        else if(proprietario2.getTelefone() == null || proprietario2.getTelefone().length() <= 0) {
            retorno.Erros.add("Favor fornecer o telefone do proprietario2");
        }
        else if(proprietario2.getAnimal() == null) {
            retorno.Erros.add("Favor fornecer os dados do Animal do proprietario2");
        }
        else if(proprietario2.getAnimal().getNumeroDoPaciente() <= 0) {
            retorno.Erros.add("Favor fornecer os dados do Animal do proprietario2");
        }
        if(retorno.Erros.size() > 0){
            retorno.Sucesso = false;
            return retorno;
        }

        ProprietarioAnimal prop = daoProprietarioAnimal.obterProprietarioAnimal(proprietario);
        ProprietarioAnimal prop2 = daoProprietarioAnimal.obterProprietarioAnimal(proprietario2);


        if(prop == null)
        {
            retorno.Erros.add("Proprietario não cadastrado!");
            retorno.Sucesso = false;
            return retorno;
        }
        try {
            daoProprietarioAnimal.editar(prop, prop2);
        } catch (IOException e){
            e.printStackTrace();
        }


        retorno.Sucesso = true;
        retorno.Data = proprietario;
        return retorno;
    }

    public RespostaBase listagemConsulta()
    {
        RespostaBase retorno = new RespostaBase();

        try
        {
            List<ProprietarioAnimal> lista = daoProprietarioAnimal.listagem();
            retorno.Sucesso = true;
            retorno.Data = lista;
        }
        catch (Exception ex)
        {
            retorno.Sucesso = false;
            retorno.Erros.add(ex.getMessage());
        }

        return retorno;
    }
}