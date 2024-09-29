package br.com.fiap.view;

import br.com.fiap.controller.FilmeController;
import br.com.fiap.model.dto.Filme;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FilmeView {
    public static void main(String[] args) {
        int codigo;
        String titulo, genero, produtora;
        String[] escolha = {"Inserir", "Alterar", "Excluir", "Listar"};
        int opcao;
        FilmeController filmeController = new FilmeController();
        Scanner scan = new Scanner(System.in);
        do {
            try {
                opcao = JOptionPane.showOptionDialog(null, "Escolha uma das opções abaixo para prosseguir:", "Escolha", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, escolha, escolha[0]);
                switch (opcao) {
                    case 0:
                        System.out.println("Informe o título do filme.");
                        titulo = scan.nextLine();

                        System.out.println("Informe o gênero do filme.");
                        genero = scan.nextLine();

                        System.out.println("Informe a produtora do filme.");
                        produtora = scan.nextLine();

                        System.out.println(filmeController.inserirFilme(titulo,genero,produtora));
                        break;
                    case 1:
                        System.out.println("Digite o código do filme.");
                        codigo = scan.nextInt(); scan.nextLine();

                        System.out.println("Informe o novo título do filme.");
                        titulo = scan.nextLine();

                        System.out.println("Digite o novo gênero do filme.");
                        genero = scan.nextLine();

                        System.out.println("Digite a nova produtora do filme.");
                        produtora = scan.nextLine();

                        System.out.println(filmeController.alterarFilme(codigo,titulo,genero,produtora));
                        break;
                    case 2:
                        System.out.println("Digite o código do filme.");
                        codigo = scan.nextInt(); scan.nextLine();

                        System.out.println(filmeController.excluirFilme(codigo));
                    case 3:
                        ArrayList<Filme> listaFilmes = filmeController.listarTodosFilmes();
                        String texto = "";
                        for (Filme filme : listaFilmes) {
                            texto += "Código: " + filme.getCodigo() + "\n";
                            texto += "Título: " + filme.getTitulo() + "\n";
                            texto += "Gênero: " + filme.getGenero() + "\n";
                            texto += "Produtora: " + filme.getProdutora() + "\n\n";
                        }
                        if (texto.isEmpty()) {
                            texto = "Nenhum filme encontrado.";
                        }
                        JOptionPane.showMessageDialog(null, texto, "Lista de Filmes", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        } while (JOptionPane.showConfirmDialog(null, "Deseja continuar?", "Atenção", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0);
        JOptionPane.showMessageDialog(null, "Fim do Programa");
    }
}
