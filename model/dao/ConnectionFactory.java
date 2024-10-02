package br.com.fiap.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public static Connection abrirConexao() { //"static" → acesso à atributos/métodos sem criar objeto/instanciar.
        Connection con = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver"); //"Class.forName" → carrega uma classe, executando seus inicializadores estáticos. https://stackoverflow.com/questions/4202252/how-does-class-forname-work
            String url = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl";
            final String user = "rm555555"; //"final" → em atributos, garante que o valor não será alterado indevidamente.
            final String pass = "000000";
            con = DriverManager.getConnection(url, user, pass);
            //System.out.println("Conexão com o banco de dados aberta.");
        } catch (ClassNotFoundException e) {
            System.out.println("Erro: Classe de conexão não encontrada.\n" + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Erro de SQL.\n" + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
        return con;
    }

    public static void fecharConexao(Connection con) {
        try {
            con.close();
            //System.out.println("Conexão com o banco de dados fechada.");
        } catch (SQLException e) {
            System.out.println("Erro de SQL.\n" + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
