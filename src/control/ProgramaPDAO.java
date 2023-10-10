/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.util.Scanner;
import model.AvaliacaoDAO;
import model.Pessoa;
import model.PessoaDAO;
import model.PostDAO;
import model.SeguindoDAO;
import model.Utils;
import view.Menus;

/**
 *
 * @author heber
 */
public class ProgramaPDAO {

    Menus menu = new Menus();
    PessoaDAO pessoaDAO = new PessoaDAO();
    PostDAO postsDAO = new PostDAO(pessoaDAO);
    AvaliacaoDAO avalDAO = new AvaliacaoDAO(pessoaDAO);
    SeguindoDAO seguidoresDAO = new SeguindoDAO(pessoaDAO, postsDAO);
    Scanner s = new Scanner(System.in);

    public ProgramaPDAO() {
        int opc;

        do {
            opc = menu.LoginPage();
            switch (opc) {
                case 1:
                    Pessoa Plogada = menu.Logar(pessoaDAO);
                    if (Plogada != null) {
                        System.out.println("Logado com sucesso.");
                        Utils.setPessoaLogada(Plogada);
                        do {
                            if (avalDAO.buscaAvalPessoa(Utils.getPessoaLogada()) == null) {
                                menu.realizarAval(avalDAO);
                            } else {
                                menuPrincipal();
                                opc = 2;
                            }
                        } while (opc != 2);
                    } else {
                        System.out.println("Usuario nao encontrado");
                    }

                    break;
                case 2:
                    pessoaDAO.adiciona(menu.cadastrar());
                    System.out.println("Usuario cadastrado com sucesso");
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opcao invalida");
            }
        } while (opc != 0);

    }

    public void menuPrincipal() {
        int opc = 0;
        do {
            menu.feedPosts(postsDAO, seguidoresDAO);
            opc = menu.menuPrincipal();
            switch (opc) {
                case 1:
                    System.out.println("\n1 - Registrar Preferencias Alimentares");
                    break;
                case 2:
                    System.out.println("\n2 - Registrar Tipo de Dieta");
                    break;
                case 3:
                    System.out.println("\n3 - Registrar Dieta");
                    break;
                case 4:
                    System.out.println("\n4 - Registrar Refeicao");
                    break;
                case 5:
                    System.out.println("\n5 - Seguir usuario pelo nome");
                    break;
                case 6:
                    System.out.println("\n6 - Mostrar todos os usuarios para seguir");
                    break;
                case 7:
                    System.out.println("\n7 - Alterar avaliacao fisica completa");
                    break;
                case 0:
                    System.out.println("Deslogando...");
                    break;

            }

        } while (opc != 0);

    }

    public static void main(String[] args) {

        new ProgramaPDAO();
    }
}
