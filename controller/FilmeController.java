package br.com.fiap.controller;

import br.com.fiap.model.dao.ConnectionFactory;
import br.com.fiap.model.dao.FilmeDAO;
import br.com.fiap.model.dto.Filme;

import java.sql.Connection;
import java.util.ArrayList;

public class FilmeController {
    public String inserirFilme(String titulo, String genero, String produtora) {
        String resultado;
        Connection con = ConnectionFactory.abrirConexao();
        Filme filme = new Filme();
        filme.setTitulo(titulo);
        filme.setGenero(genero);
        filme.setProdutora(produtora);
        FilmeDAO filmeDAO = new FilmeDAO(con);
        resultado = filmeDAO.inserir(filme);
        ConnectionFactory.fecharConexao(con);
        return resultado;
    }

    public String alterarFilme(int codigo, String titulo, String genero, String produtora) {
        String resultado;
        Connection con = ConnectionFactory.abrirConexao();
        Filme filme = new Filme();
        filme.setCodigo(codigo);
        filme.setTitulo(titulo);
        filme.setGenero(genero);
        filme.setProdutora(produtora);
        FilmeDAO filmeDAO = new FilmeDAO(con);
        resultado = filmeDAO.alterar(filme);
        ConnectionFactory.fecharConexao(con);
        return resultado;
    }

    public String excluirFilme(int codigo) {
        String resultado;
        Connection con = ConnectionFactory.abrirConexao();
        Filme filme = new Filme();
        filme.setCodigo(codigo);
        FilmeDAO filmeDAO = new FilmeDAO(con);
        resultado = filmeDAO.excluir(filme);
        ConnectionFactory.fecharConexao(con);
        return resultado;
    }

    public ArrayList<Filme> listarTodosFilmes() {
        ArrayList<Filme> listaFilmes = new ArrayList<Filme>();
        Connection con = ConnectionFactory.abrirConexao();
        FilmeDAO filmeDAO = new FilmeDAO(con);
        listaFilmes = filmeDAO.listarTodos();
        ConnectionFactory.fecharConexao(con);
        return listaFilmes;
    }
}
