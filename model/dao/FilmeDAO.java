package br.com.fiap.model.dao;

import br.com.fiap.model.dto.Filme;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FilmeDAO {
    private Connection con; //para retornar objetos implementados na classe "ConnectionFactory".

    public FilmeDAO(Connection con) {
        this.con = con;
    }

    public Connection getCon() {
        return con;
    }

    public String inserir(Filme filme) {
        String insercaoSQL = "insert into ddd_filme(titulo,genero,produtora) values(?,?,?)";
        try (PreparedStatement ps = getCon().prepareStatement(insercaoSQL)) { //"PreparedStatement" → mantém a query pré-compilada, melhorando performance e tratando erros.
            ps.setString(1, filme.getTitulo());
            ps.setString(2, filme.getGenero());
            ps.setString(3, filme.getProdutora());
            if (ps.executeUpdate() > 0) {
                return "Inserido com sucesso.";
            } else {
                return "Erro ao inserir.";
            }
        } catch (SQLException e) {
            return "Erro de SQL.\n" + e.getMessage();
        }
    }

    public String alterar(Filme filme) {
        String alteracaoSQL = "update ddd_filme set titulo=?, genero=?, produtora=? where codigo=?";
        try (PreparedStatement ps = getCon().prepareStatement(alteracaoSQL)) {
            ps.setString(1, filme.getTitulo());
            ps.setString(2, filme.getGenero());
            ps.setString(3, filme.getProdutora());
            ps.setInt(4, filme.getCodigo());
            if (ps.executeUpdate() > 0) {
                return "Alterado com sucesso.";
            } else {
                return "Erro ao alterar.";
            }
        } catch (SQLException e) {
            return "Erro de SQL.\n" + e.getMessage();
        }
    }

    public String excluir(Filme filme) {
        String exclusaoSQL = "delete from ddd_filme where codigo=?";
        try (PreparedStatement ps = getCon().prepareStatement(exclusaoSQL)) {
            ps.setInt(1, filme.getCodigo());
            if (ps.executeUpdate() > 0) {
                return "Excluído com sucesso.";
            } else {
                return "Erro ao excluir.";
            }
        } catch (SQLException e) {
            return "Erro de SQL.\n" + e.getMessage();
        }
    }

    public ArrayList<Filme> listarTodos() {
        String listarTodosSQL = "select * from ddd_filme order by codigo";
        ArrayList<Filme> listaFilme = new ArrayList<Filme>();
        try (PreparedStatement ps = getCon().prepareStatement(listarTodosSQL)) {
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    Filme filme = new Filme();
                    filme.setCodigo(rs.getInt(1));
                    filme.setTitulo(rs.getString(2));
                    filme.setGenero(rs.getString(3));
                    filme.setProdutora(rs.getString(4));
                    listaFilme.add(filme);
                }
                return listaFilme;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro de SQL.\n" + e.getMessage());
            return null;
        }
    }
}
