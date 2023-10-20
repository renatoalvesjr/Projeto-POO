package view;

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
        return p.buscaPessoaLogin(login, senha);

    }

    public Pessoa cadastrar() {
        Pessoa p = new Pessoa();
        System.out.println("Nome completo: ");
        p.setNome(s.nextLine());
        System.out.println("Sexo(M/F): ");
        p.setSexo(s.nextLine());
        System.out.println("Data de nascimento(DD/MM/YYYY): ");
        p.setNascimento(s.nextLine());
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
        menu.append("\n3 - Seguir usuario pelo nome");
        menu.append("\n4 - Gerenciar avaliacao fisica");
        menu.append("\n5 - Meus posts");
        menu.append("\n6 - Mensagens");
        menu.append("\n0 - Deslogar");
        menu.append("\n-> ");
        System.out.print(menu);

        return Integer.parseInt(s.nextLine());
    }

    public void feedPosts(PostDAO posts, SeguindoDAO seguidores) {
        System.out.println("\n\n====== BEM-VINDO "+Utils.getPessoaLogada().getNome().toUpperCase()+" ======");
        Seguindo logado = seguidores.buscaSeguidorPessoa(Utils.getPessoaLogada());
        if (logado != null) {
            Pessoa[] p = logado.getSeguidores();
            System.out.println("\n\n====== TIMELINE ======");
            for (int i = 0; i < p.length; i++) {
                if (p[i] != null) {
                    posts.mostraTodosPostPessoa(p[i]);
                }
            }
        } else {
            System.out.println("\n\n====== SEM POSTS DE SEGUIDORES ======");
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

    public void alteraAval(AvaliacaoDAO avalDAO, long id) {
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
        avalDAO.alteraMedidas(id, idade, altura, cintura, quadril, pescoco, peso, rotina);
    }

    public void listaSeguidores(SeguindoDAO seguidores) {
        Seguindo logado = seguidores.buscaSeguidorPessoa(Utils.getPessoaLogada());
        Pessoa[] p = logado.getSeguidores();

        for (int i = 0; i < p.length; i++) {
            if (p[i] != null) {
                System.out.println(p[i].getNome());
            }

        }
    }

    public int menuPreferencias(PreferenciaDAO preferencias) {
        StringBuilder menu = new StringBuilder("");

        menu.append("\n\n");
        menu.append("\n====== PREFERENCIAS ======");
        menu.append("\n1 - Exibir alimentos preferidos");
        menu.append("\n2 - Adicionar alimento registrado");
        menu.append("\n3 - Adicionar novo alimento");
        menu.append("\n4 - Remover alimento preferencial");
        menu.append("\n0 - Voltar");
        menu.append("\n-> ");
        System.out.print(menu);

        return Integer.parseInt(s.nextLine());
    }

    public void exibePreferenciasUsuario(PreferenciaDAO preferenciasDAO) {
        Preferencia preferencias = preferenciasDAO.buscaPref(Utils.getPessoaLogada());
        Alimento[] alimentos = preferencias.getAlimento();

        for (Alimento al : alimentos) {
            if (al != null) {
                System.out.println(al.toString());
            }
        }
    }

    public int menuSeguidores() {
        StringBuilder menu = new StringBuilder("");

        menu.append("\n\n");
        menu.append("\n====== SEGUIDORES ======");
        menu.append("\n1 - Busca usuario para seguir");
        menu.append("\n2 - Adicionar alimento registrado");
        menu.append("\n3 - Adicionar novo alimento");
        menu.append("\n4 - Remover alimento preferencial");
        menu.append("\n0 - Voltar");
        menu.append("\n-> ");
        System.out.print(menu);

        return Integer.parseInt(s.nextLine());
    }

    public Alimento addNovoAlimento() {
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
        return ali;
    }

    public int menuMensagens(MensagemDAO mensagens) {
        System.out.println("\n\nMensagens recebidas:");
        mensagens.mostraMensagemRecebida(Utils.getPessoaLogada());

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
        posts.mostraTodosPostPessoa(Utils.getPessoaLogada());

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
        menu.append("\n4 - Gerenciar alimentos na dieta");
        menu.append("\n0 - Voltar");
        menu.append("\n-> ");
        System.out.print(menu);

        return Integer.parseInt(s.nextLine());
    }
    
    public int menuGerenciarDieta(){
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
    
    public Refeicoes menuCriarRefeicao(TipoDietaDAO td, RefeicoesDAO refeicaoDAO){
        Refeicoes refeicao = new Refeicoes();
        TipoDieta[] tds = td.buscaTodosTipoDieta();
        System.out.print("Insira o nome da refeicao: ");
        String nome = s.nextLine();
        refeicao.setNomeRefeicao(nome);
        for (TipoDieta td1 : tds) {
            if(td1 != null)
            System.out.println(td1);
        }
        System.out.print("Selecione um tipo de dieta da sua refeicao pelo id: ");
        long tdid = Integer.parseInt(s.nextLine());
        refeicao.setTd(td.BuscaPorId(tdid));
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
                if(alrf[i] != null){
                    if(alrf[i].getRefeicao().getId() == id){
                        System.out.println(alrf[i].getRefeicao().getNomeRefeicao());
                        for (int j = 0; j < alrf.length; j++) {
                            if(alrf[j] != null && alrf[j].getRefeicao().getId()==id){
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
}


