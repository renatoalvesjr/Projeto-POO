package view;

import java.util.Scanner;
import model.Pessoa;
import model.PessoaDAO;
import model.PostDAO;
import model.SeguindoDAO;

public class Menus {
    Scanner s = new Scanner(System.in);
    
    public int LoginPage(){
        StringBuilder menu = new StringBuilder("");
        
        menu.append("\n===== Login =====");
        menu.append("\n1 - Login");
        menu.append("\n2 - Cadastro");
        menu.append("\n0 - Sair");
        menu.append("\n->");
        System.out.println(menu);
        
        return Integer.parseInt(s.nextLine());
    }
    public Pessoa Logar(PessoaDAO p){
        System.out.println("Login: ");
        String login = s.nextLine();
        System.out.println("Senha: ");
        String senha = s.nextLine();
        return p.buscaPessoaLogin(login, senha);
        
    }
    
    public void MenuLogadoSemAvaliacao(Pessoa p){
        StringBuilder menu = new StringBuilder("");
        
        menu.append("\n===== Bem vindo "+p.getNome()+" =====");
        menu.append("\n1 - Realizar avaliacao");
        menu.append("\n0 - Sair");
        menu.append("\n->");
        
        System.out.println(menu);
        

    }
    
    public void realizarAval(){
        StringBuilder menu = new StringBuilder("");
        
        menu.append("\n===== Bem vindo "+p.getNome()+" =====");
        menu.append("\n1 - Realizar avaliacao");
        menu.append("\n0 - Sair");
        menu.append("\n->");
    }
    
    public Pessoa cadastrar(){
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
}
