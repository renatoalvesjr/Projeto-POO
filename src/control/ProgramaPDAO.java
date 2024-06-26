package control;

import java.util.List;

import java.util.ListIterator;

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
import model.Refeicoes;
import model.RefeicoesDAO;
import model.RegistroDieta;
import model.RegistroDietaDAO;
import model.Seguindo;
import model.SeguindoDAO;
import model.TipoDieta;
import model.TipoDietaDAO;
import model.Utils;
import view.Menus;

public class ProgramaPDAO {

    Menus menu = new Menus();
    PessoaDAO pessoaDAO = new PessoaDAO();
    PostDAO postDAO = new PostDAO();
    AlimentoDAO alimentoDAO = new AlimentoDAO();
    PreferenciaDAO preferenciaDAOO = new PreferenciaDAO(pessoaDAO, alimentoDAO);
    AvaliacaoDAO avalDAO = new AvaliacaoDAO();
    SeguindoDAO seguindoDAO = new SeguindoDAO();
    MensagemDAO mensagemDAO = new MensagemDAO();

    TipoDietaDAO tipodietaDAO = new TipoDietaDAO();

    RefeicoesDAO refeicoesDAO = new RefeicoesDAO(tipodietaDAO);

    RefeicoesDAO refeicoesDAO = new RefeicoesDAO();

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
                    gerenciaSeguidores();
                    break;
                case 4:
                    gerenciaAval();
                    break;
                case 5:
                    gerenciaPost();
                    break;
                case 6:
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
                    Avaliacao aval = avalDAO.buscaAvalPessoa(Utils.getPessoaLogada());
                    if(aval != null){
                        menu.alteraAval(avalDAO, aval);
                    }
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
                    List<Alimento> alimentos = alimentoDAO.mostraAlimentos();
                    ListIterator<Alimento> li = alimentos.listIterator();
                    while (li.hasNext()) {
                        Alimento next = li.next();
                        li.remove();
                        System.out.println(next);
                    }
                    System.out.print("\nSelecione um dos alimentos acima para adicionar pelo seu numero à esquerda: ");
                    long idAdd = Integer.parseInt(s.nextLine());
                    Preferencia prefAdd = new Preferencia();
                    prefAdd.setAlimento(alimentoDAO.buscaAlimento(idAdd));
                    prefAdd.setPessoa(Utils.getPessoaLogada());
                    
                    preferenciaDAOO.criaPref(prefAdd);
                    break;
                case 3:
                    Preferencia prefAdd2 = new Preferencia();
                    prefAdd2.setPessoa(Utils.getPessoaLogada());
                    long ali = menu.addNovoAlimento();
                    prefAdd2.setAlimento(alimentoDAO.buscaAlimento(ali));
                    
                    preferenciaDAOO.criaPref(prefAdd2);

                    break;
                case 4:
                    menu.exibePreferenciasUsuario(preferenciaDAOO);
                    System.out.print("\nSelecione um dos alimentos acima para remover pelo seu numero à esquerda: ");
                    long idDel = Integer.parseInt(s.nextLine());
                    preferenciaDAOO.removePrefPorId(idDel);
                    break;
                case 0:
                    System.out.println("Voltando");
                    break;
            }
        } while (opc != 0);

    }

    void gerenciaSeguidores() {
        int opc;
        do {
            opc = menu.menuSeguidores();
            
            switch (opc) {
                case 1:
                    List<Pessoa> pessoas = new PessoaDAO().lista();
                    ListIterator<Pessoa> li = pessoas.listIterator();
                    while (li.hasNext()) {
                        Pessoa next = li.next();
                        li.remove();
                        System.out.println(next);
                    }
                    System.out.print("\nDigite o nome da pessoa que deseja seguir: ");
                    String nome = s.nextLine();
                    if (nome.equalsIgnoreCase(Utils.getPessoaLogada().getNome())) {
                        System.out.println("Nao e possivel seguir a si mesmo.");
                    } else if (pessoaDAO.buscaPorNome(nome) != null) {
                        Seguindo s = new Seguindo();
                        s.setPessoa(Utils.getPessoaLogada());
                        s.setSeguidores(pessoaDAO.buscaPorNome(nome));
                        seguindoDAO.criarSeguidor(s);
                    } else {
                        System.out.println("Usuario nao encontrado.");
                    }
                    break;
                case 2:
                    List<Pessoa> seguidores = new SeguindoDAO().mostraSeguidoresPessoa(Utils.getPessoaLogada());
                    ListIterator<Pessoa> li2 = seguidores.listIterator();
                    while (li2.hasNext()) {
                        Pessoa next = li2.next();
                        li2.remove();
                        System.out.println(next);
                    }
                    System.out.print("\nDigite o id da pessoa que deseja parar deseguir: ");
                    long id = Integer.parseInt(s.nextLine());
                    new SeguindoDAO().removeSeguidor(id);
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
                    if (postDAO.removePost(id) != true) {
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
                    gerenciaRD();

                case 4:
//                    gerenciaAlimentosDieta();
                    break;

                case 0:
                    System.out.println("Voltando");
                    break;
            }
        } while (opc != 0);
    }

    void gerenciaRD() {
        int opc3 =0;
        
        do{
            opc3 = menu.menuGerenciarDieta();
            
            switch (opc3) {
                case 1:
                    menu.criarRD(tipodietaDAO, avalDAO, registrodietaDAO);
                    break;
                case 2:
                    registrodietaDAO.buscaPorPessoa(Utils.getPessoaLogada());

                    break;

                case 0:
                    System.out.println("Voltando");
                    break;
            }  
        }while(opc3 != 0);
    }
    
//    void gerenciaAlimentosDieta() {
//        int opc2 = 0;
//        do {
//            opc2 = menu.menuAlimentosDieta();
//
//            switch (opc2) {
//                case 1:
//                    List<AlimentoRefeicao> showalrf = alimentorefeicaoDAO.buscaTodosPorPessoa(Utils.getPessoaLogada());
//                    System.out.print("Insira o nome da refeicao para mostra-la: ");
//                    String nome = s.nextLine();
//                    menu.exibeAlimentosEmRefeicao(showalrf, nome);
//                    nutrientesRestantes(alimentorefeicaoDAO.buscaTodosPorRefeicao(Utils.getPessoaLogada(), nome));
//                    
//                    break;
//                case 2:
//                    Refeicoes novaRefeicao = menu.menuCriarRefeicao(tipodietaDAO, refeicoesDAO);
//                    AlimentoRefeicao novoAlRf = new AlimentoRefeicao();
//                    novoAlRf.setPessoa(Utils.getPessoaLogada());
//                    novoAlRf.setRefeicao(novaRefeicao);
//                    alimentorefeicaoDAO.criaRefeicaoAlimento(novoAlRf);
//                    break;
//                case 3:
//                    AlimentoRefeicao[] alrfDel = alimentorefeicaoDAO.buscaTodosPorPessoa(Utils.getPessoaLogada());
//                    System.out.print("Insira o nome da refeicao para ser removido: ");
//                    String nomeDel = s.nextLine();
//                    int x = 0;
//                    for (int i = 0; i < alrfDel.length; i++) {
//                        if (alimentorefeicaoDAO.removeRefeicaoPorNome(nomeDel, Utils.getPessoaLogada())) {
//                            System.out.println("Refeicao removida com sucesso");
//                            x++;
//                        }
//                    }
//                    if (x > 0) {
//                        System.out.println("Refeicao removida com sucesso");
//                    } else {
//                        System.out.println("Refeicao nao encontrada");
//                    }
//
//                    break;
//                case 4:
//
//                    System.out.print("Insira o nome da refeicao para adicionar um alimento: ");
//                    String nome4 = s.nextLine();
//                    AlimentoRefeicao refeicao4 = alimentorefeicaoDAO.buscaAlimentosRefeicaoNome(Utils.getPessoaLogada(), nome4);
//                    alimentoDAO.mostraAlimentos();
//                    System.out.print("Escolha o id de um alimento acima para adicionar: ");
//                    long id4 = Integer.parseInt(s.nextLine());
//                    refeicao4.setAlimento((Alimento) alimentoDAO.buscaAlimento(id4));

//                    break;

////                    break;

//                case 5:
//                    System.out.print("Insira o nome da refeicao para adicionar um alimento: ");
//                    String nome2 = s.nextLine();
//                    AlimentoRefeicao refeicao2 = alimentorefeicaoDAO.buscaAlimentosRefeicaoNome(Utils.getPessoaLogada(), nome2);
//                    System.out.println("Adicionando alimento em: " + refeicao2.getRefeicao().getNomeRefeicao());
//                    System.out.print("Insira a quantidade de porcoes a adicionar(Ex.: 0.6 ou 1.5): ");
//                    int porcao = Integer.parseInt(s.nextLine());
//                    Alimento novoAlimento = menu.addNovoAlimento();
//                    refeicao2.setAlimento(novoAlimento);
//                    refeicao2.setPorcao(porcao * novoAlimento.getPorcao());
//                    break;
//                case 6:
//                    System.out.print("Insira o nome da refeicao: ");
//                    String nomeRef = s.nextLine();
//                    AlimentoRefeicao[] alrfdel = alimentorefeicaoDAO.buscaTodosPorPessoa(Utils.getPessoaLogada());
//                    menu.exibeAlimentosEmRefeicao(alrfdel, nomeRef);
//                    System.out.print("Insira o id para remocao: ");
//                    long idDel = Integer.parseInt(s.nextLine());
//                    if (alimentorefeicaoDAO.removeAlimentoDaRefeicao(idDel, nomeRef)) {
//                        System.out.println("Removido com sucesso");
//                    } else {
//                        System.out.println("Nao encontrado");
//                    }
//
//                    System.out.print("Insira o nome da refeicoes para adicionar um alimento: ");

//                    String nome5 = s.nextLine();
//                    AlimentoRefeicao refeicao5 = alimentorefeicaoDAO.buscaAlimentosRefeicaoNome(Utils.getPessoaLogada(), nome5);
//                    alimentoDAO.mostraAlimentos();
//                    System.out.print("Escolha o id de um alimento acima para adicionar: ");
//                    long id5 = Integer.parseInt(s.nextLine());
//                    refeicao5.setAlimento((Alimento) alimentoDAO.buscaAlimento(id5));
//                    break;
//               
//            }
//        } while (opc2 != 0);
//    }

               
            }
        } while (opc2 != 0);
    }


    public void nutrientesRestantes(AlimentoRefeicao alrf[]) {
        Refeicoes rf = null;
        if (alrf.length != 0) {

        }
        for (int i = 0; i < alrf.length; i++) {
            if (alrf[i] != null) {
                rf = alrf[i].getRefeicao();
                break;
            }

        }

        if (rf != null) {
            double metaCarb = rf.getCarb();
            double metaProt = rf.getProt();
            double metaGord = rf.getGord();

            double carb = 0;
            double prot = 0;
            double gord = 0;

            for (int i = 0; i < alrf.length; i++) {
                if (alrf[i] != null) {
                    carb += alrf[i].getAlimento().getCarb();
                    prot += alrf[i].getAlimento().getProt();
                    gord += alrf[i].getAlimento().getGord();
                }

            }

            double gordRestante = metaGord - gord;
            double protRestante = metaProt - prot;
            double carbRestante = metaCarb - carb;

            StringBuilder restantes = new StringBuilder();
            int change = 0;

            if (carbRestante > 5) {
                restantes.append(carbRestante + "g de Carboidratos faltando; ");
                change++;
            } else if (carbRestante < (-10)) {
                restantes.append(-carbRestante + "g de  Carboidratos a mais; ");
                change++;
            }

            if (protRestante > 5) {
                restantes.append(protRestante + "g de Proteinas faltando; ");
                change++;
            } else if (protRestante < (-10)) {
                restantes.append(-protRestante + "g de  Proteinas a mais; ");
                change++;
            }

            if (gordRestante > 5) {
                restantes.append(gordRestante + "g de  Gorduras faltando; ");
                change++;
            } else if (gordRestante < (-10)) {
                restantes.append(-gordRestante + "g de  Gorduras a mais; ");
                change++;
            }
            if (change != 0) {
                System.out.println(restantes);
            }
        }

    }
    
    public static void main(String[] args) {
        new ProgramaPDAO();
    }
}
