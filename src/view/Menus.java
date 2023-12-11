package view;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;
import model.Alimento;
import model.AlimentoDAO;
import model.AlimentoRefeicao;
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
import model.Seguindo;
import model.SeguindoDAO;
import model.RegistroDieta;
import model.RegistroDietaDAO;
import model.TipoDieta;
import model.TipoDietaDAO;
import model.Utils;

public class Menus {

    Scanner s = new Scanner(System.in);

    public int LoginPage() {
        StringBuilder menu = new StringBuilder("");

        menu.append("\n\n===== Login =====");
        menu.append("\n1 - Login");
        menu.append("\n2 - Cadastro");
        menu.append("\n0 - Sair");
        menu.append("\n-> ");
        System.out.print(menu);

        return Integer.parseInt(s.nextLine());
    }

    public Pessoa Logar(PessoaDAO p) {
        System.out.println("Login: ");
        String login = s.nextLine();
        System.out.println("Senha: ");
        String senha = s.nextLine();
        return p.logarPessoa(login, senha);

    }

    public Pessoa cadastrar() {
        Pessoa p = new Pessoa();
        System.out.println("Nome completo: ");
        p.setNome(s.nextLine());
        System.out.println("Sexo(M/F): ");
        p.setSexo(s.nextLine());
        System.out.println("Data de nascimento(yyyy-MM-dd): ");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String date = s.nextLine();
        LocalDate dateTime = LocalDate.parse(date);
        p.setNascimento(dateTime);
        System.out.println("Insira seu login: ");
        p.setLogin(s.nextLine());
        System.out.println("Insira sua senha: ");
        p.setSenha(s.nextLine());
        return p;
    }

    public int menuPrincipal() {
        StringBuilder menu = new StringBuilder("");

        menu.append("\n\n");
        menu.append("\n====== MENU PRINCIPAL ======");
        menu.append("\n1 - Minha Dieta");
        menu.append("\n2 - Preferencias Alimentares");
        menu.append("\n3 - Seguidores");
        menu.append("\n4 - Gerenciar avaliacao fisica");
        menu.append("\n5 - Meus posts");
        menu.append("\n6 - Mensagens");
        menu.append("\n0 - Deslogar");
        menu.append("\n-> ");
        System.out.print(menu);

        return Integer.parseInt(s.nextLine());
    }

    public void feedPosts(PostDAO posts, SeguindoDAO seguidores) {
        System.out.println("\n\n====== BEM-VINDO " + Utils.getPessoaLogada().getNome().toUpperCase() + " ======");
        List<Seguindo> listaSeguidores = seguidores.buscaSeguidoresPessoa(Utils.getPessoaLogada());
        if (listaSeguidores != null) {
            for (Seguindo listaSeguidor : listaSeguidores) {
                if (listaSeguidor != null) {
                    posts.mostraTodosPostPessoa(listaSeguidor.getSeguidores());
                }
            }
            List<Post> postlist = null;
            if (!listaSeguidores.isEmpty()) {
                for (Seguindo seguidor : listaSeguidores) {
                    if (seguidor != null) {
                        postlist = posts.mostraTodosPostPessoa(seguidor.getSeguidores());
                    }
                    ListIterator<Post> li = postlist.listIterator();
                    while (li.hasNext()) {
                        Post next = li.next();
                        li.remove();
                        System.out.println(next);
                    }
                }
            } else {
                System.out.println("\n\n====== SEM POSTS DE SEGUIDORES ======");
            }
        }
    }

    public Avaliacao realizarAval(AvaliacaoDAO avalDAO) {
        System.out.println("Insira sua idade: ");
        int idade = Integer.parseInt(s.nextLine());
        System.out.println("Insira sua altura em cm: ");
        double altura = Double.parseDouble(s.nextLine());
        System.out.println("Insira seu peso em kg: ");
        double peso = Double.parseDouble(s.nextLine());
        System.out.println("Insira sua cricunferencia de pesoco em cm: ");
        double pescoco = Double.parseDouble(s.nextLine());
        System.out.println("Insira sua cricunferencia de quadril em cm: ");
        double quadril = Double.parseDouble(s.nextLine());
        System.out.println("Insira sua cricunferencia de cintura em cm: ");
        double cintura = Double.parseDouble(s.nextLine());
        System.out.print("""
                           Escolha um estilo de rotina abaixo
                           1: sedentario (pouco ou nenhum exercicio)
                           2: levemente ativo (exercicio leve 1 a 3 dias por semana)
                           3: moderadamente ativo (exercicio moderado 6 a 7 dias por semana)
                           4: muito ativo (exerciedcio intenso todos os dias ou exercicio duas vezes ao dia)
                           5: extra ativo (exercicio muito dificil, treinamento ou trabalho fisico)
                           -> """);
        int rotina = Integer.parseInt(s.nextLine());

        Avaliacao aval = new Avaliacao();
        aval.setPessoa(Utils.getPessoaLogada());
        aval.setAltura(altura);
        aval.setPeso(peso);
        aval.setIdade(idade);
        aval.setPescoco(pescoco);
        aval.setQuadril(quadril);
        aval.setCintura(cintura);
        aval.setRotina(rotina);
        aval.calcIMC();
        aval.calcTMB();
        aval.calcBF();
        return aval;
    }

    public int menuAvaliacao() {
        StringBuilder menu = new StringBuilder();

        menu.append("\n====== AVALIACOES ======");
        menu.append("\n1 - Exibir avaliacao completa");
        menu.append("\n2 - Alterar Avaliacao");
        menu.append("\n0 - Voltar");
        menu.append("\n-> ");
        System.out.print(menu);

        return Integer.parseInt(s.nextLine());
    }

    public void alteraAval(AvaliacaoDAO avalDAO, Avaliacao aval) {
        System.out.println("Insira sua idade: ");
        aval.setIdade(Integer.parseInt(s.nextLine()));
        System.out.println("Insira sua altura em cm: ");
        aval.setAltura(Double.parseDouble(s.nextLine()));
        System.out.println("Insira seu peso em kg: ");
        aval.setPeso(Double.parseDouble(s.nextLine()));
        System.out.println("Insira sua cricunferencia de pesoco em cm: ");
        aval.setPescoco(Double.parseDouble(s.nextLine()));
        System.out.println("Insira sua cricunferencia de quadril em cm: ");
        aval.setQuadril(Double.parseDouble(s.nextLine()));
        System.out.println("Insira sua cricunferencia de cintura em cm: ");
        aval.setCintura(Double.parseDouble(s.nextLine()));
        System.out.print("""
                           Escolha um estilo de rotina abaixo
                           1: sedentario (pouco ou nenhum exercicio)
                           2: levemente ativo (exercicio leve 1 a 3 dias por semana)
                           3: moderadamente ativo (exercicio moderado 6 a 7 dias por semana)
                           4: muito ativo (exerciedcio intenso todos os dias ou exercicio duas vezes ao dia)
                           5: extra ativo (exercicio muito dificil, treinamento ou trabalho fisico)
                           -> """);
        aval.setRotina(Integer.parseInt(s.nextLine()));
        aval.calcBF();
        aval.calcIMC();
        aval.calcTMB();
        aval.setModifyDate();
        avalDAO.alteraMedidas(aval);
    }

    public int menuPreferencias(PreferenciaDAO preferencias) {
        StringBuilder menu = new StringBuilder("");

        menu.append("\n\n");
        menu.append("\n====== PREFERENCIAS ======");
        menu.append("\n1 - Exibir alimentos preferidos");
        menu.append("\n2 - Adicionar alimento registrado");
        menu.append("\n3 - Adicionar novo alimento preferido");
        menu.append("\n4 - Remover alimento preferencial");
        menu.append("\n0 - Voltar");
        menu.append("\n-> ");
        System.out.print(menu);

        return Integer.parseInt(s.nextLine());
    }

    public void exibePreferenciasUsuario(PreferenciaDAO preferenciasDAO) {
        List<Preferencia> preferencias = preferenciasDAO.buscaPrefPorPessoa(Utils.getPessoaLogada());

        ListIterator<Preferencia> li =  preferencias.listIterator();
        while (li.hasNext()) {
            Preferencia next = li.next();
            li.remove();
            System.out.println(next);            
        }
    }
    

    public int menuSeguidores() {
        System.out.println("\n====== SEGUIDORES ======");
       
        StringBuilder menu = new StringBuilder("");

        menu.append("\n\n");

        menu.append("\n1 - Busca usuario para seguir");
        menu.append("\n2 - Deixar de seguir pessoa");
        menu.append("\n0 - Voltar");
        menu.append("\n-> ");
        System.out.print(menu);

        return Integer.parseInt(s.nextLine());
    }

    public long addNovoAlimento() {
        System.out.print("Nome do alimento: ");
        String nome = s.nextLine();
        System.out.print("Tamanho da porcao em gramas: ");
        double porcao = Double.parseDouble(s.nextLine());
        System.out.print("Quantidade de carboidratos: ");
        double carb = Double.parseDouble(s.nextLine());
        System.out.print("Quantidade de proteinas: ");
        double prot = Double.parseDouble(s.nextLine());
        System.out.print("Quantidade de gorduras: ");
        double gord = Double.parseDouble(s.nextLine());
        Alimento ali = new Alimento();
        ali.setNome(nome);
        ali.setCarb(carb);
        ali.setGord(gord);
        ali.setProt(prot);
        ali.setPorcao(porcao);
        ali.setCal();
        long id = new AlimentoDAO().adiciona(ali);
        return id;
    }

    public int menuMensagens(MensagemDAO mensagens) {
        System.out.println("\n\nMensagens recebidas:");
        List<Mensagem> lista = mensagens.mostraMensagemRecebida(Utils.getPessoaLogada());
        
        ListIterator<Mensagem> li =  lista.listIterator();
        while (li.hasNext()) {
            Mensagem next = li.next();
            li.remove();
            System.out.println(next);            
        }

        StringBuilder menu = new StringBuilder();

        menu.append("\n====== MENSAGENS ======");
        menu.append("\n1 - Enviar mensagem");
        menu.append("\n2 - Ver mensagens enviadas");
        menu.append("\n0 - Voltar");
        menu.append("\n-> ");
        System.out.print(menu);

        return Integer.parseInt(s.nextLine());
    }

    public int menuPosts(PostDAO posts) {
        System.out.println("Meus posts: ");
        List<Post> postlist = posts.mostraTodosPostPessoa(Utils.getPessoaLogada());
        
        ListIterator<Post> li =  postlist.listIterator();
        while (li.hasNext()) {
            Post next = li.next();
            li.remove();
            System.out.println(next);            
        }

        StringBuilder menu = new StringBuilder();

        menu.append("\n====== POSTS ======");
        menu.append("\n1 - Criar post");
        menu.append("\n2 - Remover post");
        menu.append("\n0 - Voltar");
        menu.append("\n-> ");
        System.out.print(menu);

        return Integer.parseInt(s.nextLine());
    }

    public int menuDietas() {
        StringBuilder menu = new StringBuilder();

        menu.append("\n====== DIETAS ======");
        menu.append("\n1 - Ver minha dieta");
        menu.append("\n2 - Ver minhas refeicoes");
        menu.append("\n3 - Gerenciar dieta");
        menu.append("\n4 - Gerenciar refeicoes");
        menu.append("\n0 - Voltar");
        menu.append("\n-> ");
        System.out.print(menu);

        return Integer.parseInt(s.nextLine());
    }

    public int menuGerenciarDieta() {
        StringBuilder menu = new StringBuilder();

        menu.append("\n====== DIETAS ======");
        menu.append("\n1 - Criar dieta");
        menu.append("\n2 - Remover dieta");
        menu.append("\n0 - Voltar");
        menu.append("\n-> ");
        System.out.print(menu);

        return Integer.parseInt(s.nextLine());
    }

    public int menuAlimentosDieta() {
        StringBuilder menu = new StringBuilder();

        menu.append("\n====== GERENCIAR ALIMENTOS ======");
        menu.append("\n1 - Ver alimentos em uma refeicao");
        menu.append("\n2 - Adicionar nova refeicao");
        menu.append("\n3 - Remover refeicao");
        menu.append("\n4 - Adicionar alimento cadastrado em uma refeicao");
        menu.append("\n5 - Adicionar novo alimento em uma refeicao");
        menu.append("\n6 - Remover alimentos de uma refeicao");
        menu.append("\n0 - Voltar");
        menu.append("\n-> ");
        System.out.print(menu);

        return Integer.parseInt(s.nextLine());
    }

    public Refeicoes menuCriarRefeicao(TipoDietaDAO td, RefeicoesDAO refeicaoDAO) {
        Refeicoes refeicao = new Refeicoes();
        List<TipoDieta> tds = td.mostraTDs();
        System.out.print("Insira o nome da refeicao: ");
        String nome = s.nextLine();
        refeicao.setNomeRefeicao(nome);
        for (TipoDieta td1 : tds) {
            if (td1 != null) {
                System.out.println(td1);
            }
        }
        System.out.print("Selecione um tipo de dieta da sua refeicao pelo id: ");
        long tdid = Integer.parseInt(s.nextLine());
        refeicao.setTd(td.buscaTDId(tdid));
        System.out.print("Insira a quantidade de carboidratos desejados na refeicao: ");
        double carb = Double.parseDouble(s.nextLine());
        refeicao.setCarb(carb);
        System.out.print("Insira a quantidade de gorduras desejados na refeicao: ");
        double gord = Double.parseDouble(s.nextLine());
        refeicao.setGord(gord);
        System.out.print("Insira a quantidade de proteinas desejados na refeicao: ");
        double prot = Double.parseDouble(s.nextLine());
        refeicao.setProt(prot);
        refeicao.setCal();
        System.out.println("Sua refeicao possuirá " + refeicao.getCal() + " calorias.");
        refeicaoDAO.criaRfs(refeicao);
        return refeicao;
    }

    public void exibeRefeicoesCompleta(AlimentoRefeicao[] alrf) {
        if (alrf.length != 0) {
            long id = 1;

            for (int i = 0; i < alrf.length; i++) {
                if (alrf[i] != null) {
                    if (alrf[i].getRefeicao().getId() == id) {
                        System.out.println("\n" + alrf[i].getRefeicao());
                        for (int j = 0; j < alrf.length; j++) {
                            if (alrf[j] != null && alrf[j].getRefeicao().getId() == id) {
                                System.out.println(alrf[j].getAlimento());
                            }
                        }
                        id++;
                    }
                }
            }
        } else {
            System.out.println("Nenhuma refeicao cadastrada");
        }

    }

    public void exibeAlimentosEmRefeicao(AlimentoRefeicao[] alrfdel, String nome) {
        for (int i = 0; i < alrfdel.length; i++) {
            if (alrfdel[i] != null && alrfdel[i].getRefeicao().getNomeRefeicao().equalsIgnoreCase(nome)) {
                System.out.println(alrfdel[i].getAlimento());
            }
        }
    }
    
    public RegistroDieta menuCriarRD(TipoDietaDAO td, AvaliacaoDAO avals, RegistroDietaDAO rd) {
        RegistroDieta regDieta = new RegistroDieta();
        List<TipoDieta> tds = td.mostraTDs();
        System.out.print("""
                           Escolha seu objetivo pelo numero a esquerda:
                           1: Perder peso.
                           2: Manter peso.
                           3: Ganhar peso.
                           => """);
        int obj = Integer.parseInt(s.nextLine());
        regDieta.toString();
        for (TipoDieta td1 : tds) {
            if (td1 != null) {
                System.out.println(td1);
            }
        }
        System.out.print("Informe a quantidade de refeições desejadas:  ");
        int qtdRef = Integer.parseInt(s.nextLine());
        regDieta.toString();
        return regDieta;
    }
    
}
