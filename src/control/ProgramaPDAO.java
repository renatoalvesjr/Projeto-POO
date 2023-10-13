/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.util.Scanner;
import model.Alimento;
import model.AlimentoDAO;
import model.AlimentoRefeicao;
import model.AlimentoRefeicaoDAO;
import model.Avaliacao;
import model.AvaliacaoDAO;
import model.Mensagem;
import model.MensagemDAO;
import model.Pessoa;
import model.PessoaDAO;
import model.Post;
import model.PostDAO;
import model.Preferencia;
import model.PreferenciaDAO;
import model.RefeicoesDAO;
import model.RegistroDietaDAO;
import model.Seguindo;
import model.SeguindoDAO;
import model.TipoDietaDAO;
import model.Utils;
import view.Menus;

/**
 *
 * @author heber
 */
public class ProgramaPDAO {

    Menus menu = new Menus();
    PessoaDAO pessoaDAO = new PessoaDAO();
    PostDAO postDAO = new PostDAO(pessoaDAO);
    AlimentoDAO alimentoDAO = new AlimentoDAO();
    PreferenciaDAO preferenciaDAOO = new PreferenciaDAO(pessoaDAO, alimentoDAO);
    AvaliacaoDAO avalDAO = new AvaliacaoDAO(pessoaDAO);
    SeguindoDAO seguindoDAO = new SeguindoDAO(pessoaDAO, postDAO);
    MensagemDAO mensagemDAO = new MensagemDAO(pessoaDAO);
    TipoDietaDAO tipodietaDAO = new TipoDietaDAO();
    RefeicoesDAO refeicoesDAO = new RefeicoesDAO(tipodietaDAO);
    AlimentoRefeicaoDAO alimentorefeicaoDAO = new AlimentoRefeicaoDAO(refeicoesDAO, alimentoDAO, pessoaDAO);
    RegistroDietaDAO registrodietaDAO = new RegistroDietaDAO(pessoaDAO, tipodietaDAO, avalDAO);
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
                                avalDAO.criaAval(menu.realizarAval(avalDAO));
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

    void menuPrincipal() {
        int opc = 0;
        do {
            menu.feedPosts(postDAO, seguindoDAO);
            opc = menu.menuPrincipal();
            switch (opc) {
                case 1:
                    gerenciaDieta();
                    break;
                case 2:
                    gerenciaPreferencia();
                    break;
                case 3:
                    System.out.println("\n3 - Registrar Dieta");
                    break;
                case 4:
                    System.out.println("\n4 - Registrar Refeicao");
                    break;
                case 5:
                    pessoaDAO.mostrarTodas();
                    System.out.print("\nDigite o nome da pessoa que deseja seguir: ");
                    String nome = s.nextLine();
                    if (!nome.equalsIgnoreCase(Utils.getPessoaLogada().getNome())) {
                        Seguindo addSeguidor = seguindoDAO.buscaSeguidorPessoa(Utils.getPessoaLogada());
                        addSeguidor.setSeguidores(pessoaDAO.buscaPorNome(nome));
                    } else {
                        System.out.println("Não é possível seguir a si mesmo");
                    }
                    break;
                case 6:
                    gerenciaAval();
                    break;
                case 7:
                    gerenciaPost();
                    break;
                case 8:
                    gerenciaMensagens();
                    break;
                case 0:
                    System.out.println("Deslogando...");
                    break;

            }

        } while (opc != 0);

    }

    void gerenciaAval() {
        int opc = 0;
        do {
            opc = menu.menuAvaliacao();
            switch (opc) {
                case 1:
                    System.out.println(avalDAO.buscaAvalPessoa(Utils.getPessoaLogada()));
                    break;
                case 2:
                    long updateAval = avalDAO.buscaAvalPessoa(Utils.getPessoaLogada()).getId();
                    menu.alteraAval(avalDAO, updateAval);
                    break;
            }
        } while (opc != 0);
    }

    void gerenciaPreferencia() {
        int opc = 0;
        do {
            opc = menu.menuPreferencias(preferenciaDAOO);
            switch (opc) {
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
        } while (opc != 0);

    }

    void gerenciaMensagens() {
        int opc = 0;
        do {
            opc = menu.menuMensagens(mensagemDAO);

            switch (opc) {
                case 1:
                    System.out.println("Destinatario: ");
                    String nome = s.nextLine();
                    System.out.println("Mensagem: ");
                    String conteudo = s.nextLine();
                    if (!Utils.getPessoaLogada().getNome().equalsIgnoreCase(nome)) {
                        Mensagem m = new Mensagem();
                        m.setpOrigem(Utils.getPessoaLogada());
                        m.setpDestino(pessoaDAO.buscaPorNome(nome));
                        m.setConteudo(conteudo);
                        mensagemDAO.criaMensagem(m);
                    } else {
                        System.out.println("Nao e possivel enviar mensagem para voce mesmo.");
                    }

                    break;
                case 2:
                    System.out.println("Mensagens enviadas: ");
                    mensagemDAO.mostraMensagemEnviada(Utils.getPessoaLogada());
                    break;
            }
        } while (opc != 0);

    }

    public static void main(String[] args) {

        new ProgramaPDAO();
    }

    void gerenciaPost() {
        int opc = 0;
        do {
            opc = menu.menuPosts(postDAO);
            switch (opc) {
                case 1:
                    System.out.println("Post: ");
                    String conteudo = s.nextLine();
                    Post post = new Post();
                    post.setPessoa(Utils.getPessoaLogada());
                    post.setConteudo(conteudo);
                    postDAO.criarPost(post);
                    break;
                case 2:
                    System.out.println("Insira o id de um post para ser removido: ");
                    long id = Integer.parseInt(s.nextLine());
                    if (!postDAO.removePost(id, Utils.getPessoaLogada())) {
                        System.out.println("Post nao encontrado");
                    }
                    break;
            }
        } while (opc != 0);
    }

    void gerenciaDieta() {
        int opc = 0;
        do {
            opc = menu.menuDietas();
            switch (opc) {
                case 1:
                    if (registrodietaDAO.buscaPorPessoa(Utils.getPessoaLogada()) != null) {
                        System.out.println(registrodietaDAO.buscaPorPessoa(Utils.getPessoaLogada()));
                    } else {
                        System.out.println("Nenhuma dieta criada.");
                    }
                    break;
                case 2:
                    menu.exibeRefeicoesCompleta(alimentorefeicaoDAO.buscaTodosPorPessoa(Utils.getPessoaLogada()));
                    break;
                case 3:
                    break;
            }
        } while (opc != 0);
    }
}
