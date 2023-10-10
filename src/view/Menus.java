package view;

import java.util.Scanner;
import model.Alimento;
import model.Avaliacao;
import model.AvaliacaoDAO;
import model.Pessoa;
import model.PessoaDAO;
import model.Post;
import model.PostDAO;
import model.Preferencia;
import model.PreferenciaDAO;
import model.Seguindo;
import model.SeguindoDAO;
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
        menu.append("\n1 - Gerenciar Preferencias Alimentares");
        menu.append("\n2 - Registrar Tipo de Dieta");
        menu.append("\n3 - Registrar Dieta");
        menu.append("\n4 - Registrar Refeicao");
        menu.append("\n5 - Seguir usuario pelo nome");
        menu.append("\n6 - Mostrar todos os usuarios para seguir");
        menu.append("\n7 - Alterar avaliacao fisica completa");
        menu.append("\n0 - Deslogar");
        menu.append("\n-> ");
        System.out.print(menu);

        return Integer.parseInt(s.nextLine());
    }

    public void feedPosts(PostDAO posts, SeguindoDAO seguidores) {
        Seguindo logado = seguidores.buscaPessoa(Utils.getPessoaLogada());
        if (logado != null) {
            Pessoa[] p = logado.getSeguidores();
            System.out.println("\n\n====== TIMELINE ======");
            for (int i = 0; i < p.length; i++) {
                if (p[i] != null) {
                    System.out.println(p[i].getNome() + " postou:");
                    System.out.println(posts.mostraTodosPostPessoa(p[i]) + "\n");
                }
            }
        }else{
            System.out.println("\n\n====== SEM POSTS DE SEGUIDORES ======");
        }

    }

    public void realizarAval(AvaliacaoDAO avalDAO) {       
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
        avalDAO.criaAval(aval);
        aval = null;
    }
    
    public void listaSeguidores(SeguindoDAO seguidores) {
        Seguindo logado = seguidores.buscaPessoa(Utils.getPessoaLogada());
        Pessoa[] p = logado.getSeguidores();

        for (int i = 0; i < p.length; i++) {
            if (p[i] != null) {
                System.out.println(p[i].getNome());
            }

        }
    }
    
    public int menuPreferencias(PreferenciaDAO preferencias){
        StringBuilder menu = new StringBuilder("");

        menu.append("\n\n");
        menu.append("\n====== PREFERENCIAS ======");
        menu.append("\n1 - Exibir alimentos preferidos");
        menu.append("\n2 - Adicionar alimento registrado");
        menu.append("\n3 - Adicionar novo alimento");
        menu.append("\n0 - Voltar");
        menu.append("\n-> ");
        System.out.print(menu);

        return Integer.parseInt(s.nextLine());
    }
    
    public void exibePreferenciasUsuario(PreferenciaDAO preferenciasDAO){
        Preferencia preferencias = preferenciasDAO.buscaPref(Utils.getPessoaLogada());
        Alimento[] alimentos = preferencias.getAlimento();
        
        for(Alimento al: alimentos){
            if(al!=null){
                System.out.println(al.toString());
            }
        }
    }
    
    public Alimento addNovoAlimento(){
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
        Alimento ali1 = new Alimento();
        ali1.setNome(nome);
        ali1.setCarb(carb);
        ali1.setGord(gord);
        ali1.setProt(prot);
        ali1.setPorcao(porcao);
        ali1.setCal();
        return ali1;
    }
    
}
