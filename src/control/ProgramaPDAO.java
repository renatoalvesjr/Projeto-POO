/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.util.Scanner;
import model.Alimento;
import model.AlimentoDAO;
import model.AvaliacaoDAO;
import model.Pessoa;
import model.PessoaDAO;
import model.PostDAO;
import model.Preferencia;
import model.PreferenciaDAO;
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
    AlimentoDAO alimentoDAO = new AlimentoDAO();
    PreferenciaDAO preferenciaDAOO = new PreferenciaDAO(pessoaDAO, alimentoDAO);
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
                                System.out.println(Utils.getPessoaLogada().getNome() + ", voce ainda nao possui uma avaliacao fisica, insira os dados abaixo para realizar uma.");
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
                    gerenciaPreferencia();
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
    
    public void gerenciaPreferencia(){
        int opc = 0;
        do{
            opc = menu.menuPreferencias(preferenciaDAOO);
            switch(opc){
                case 1:
                    menu.exibePreferenciasUsuario(preferenciaDAOO);
                    break;
                case 2:
                    
                    menu.exibePreferenciasUsuario(preferenciaDAOO);
                    break;
                case 3:
                    criaPref();
                    break;
                case 0:
                    System.out.println("Voltando");
                    break;
            }
        }while(opc != 0);
        
    }
    void criaPref(){
        Preferencia pref = new Preferencia();
        pref.setPessoa(Utils.getPessoaLogada());
        pref.setAlimento(menu.addNovoAlimento());
        preferenciaDAOO.criaPref(pref);
    }
    public static void main(String[] args) {

        new ProgramaPDAO();
    }
}
