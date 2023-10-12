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
import model.Seguindo;
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
    SeguindoDAO seguindoDAO = new SeguindoDAO(pessoaDAO, postsDAO);
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
            menu.feedPosts(postsDAO, seguindoDAO);
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
                    pessoaDAO.mostrarTodas();
                    System.out.print("\nDigite o nome da pessoa que deseja seguir: ");
                    String nome = s.nextLine();
                    if(!nome.equalsIgnoreCase(Utils.getPessoaLogada().getNome())){
                        Seguindo addSeguidor = seguindoDAO.buscaSeguidorPessoa(Utils.getPessoaLogada());
                        addSeguidor.setSeguidores(pessoaDAO.buscaPorNome(nome));
                    }else{
                        System.out.println("Não é possível seguir a si mesmo");
                        
                    }
                    
                    break;
                case 6:
                    menu.realizarAval(avalDAO);
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
                    alimentoDAO.mostraTodosAlimentos();
                    System.out.print("\nSelecione um dos alimentos acima para adicionar pelo seu numero à esquerda: ");
                    Preferencia prefAdd = preferenciaDAOO.buscaPref(Utils.getPessoaLogada());
                    long idAdd = Integer.parseInt(s.nextLine());
                    prefAdd.setAlimento(alimentoDAO.BuscaAlimento(idAdd));
                    break;
                case 3:
                    Preferencia prefNew = preferenciaDAOO.buscaPref(Utils.getPessoaLogada());
                    Alimento ali = menu.addNovoAlimento();
                    prefNew.setAlimento(ali);
                    break;
                case 4:
                    menu.exibePreferenciasUsuario(preferenciaDAOO);
                    System.out.print("\nSelecione um dos alimentos acima para remover pelo seu numero à esquerda: ");
                    Preferencia prefDel = preferenciaDAOO.buscaPref(Utils.getPessoaLogada());
                    long idDel = Integer.parseInt(s.nextLine());
                    prefDel.setAlimento(idDel);
                    break;
                case 0:
                    System.out.println("Voltando");
                    break;
            }
        }while(opc != 0);
        
    }
    public static void main(String[] args) {

        new ProgramaPDAO();
    }
}
