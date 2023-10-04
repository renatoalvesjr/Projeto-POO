package view;

import java.util.Scanner;
import model.Pessoa;
import model.PessoaDAO;

public class Menus {
    Scanner s = new Scanner(System.in);
    
    public int Login(){
        StringBuilder menu = new StringBuilder("");
        
        menu.append("\n===== Login =====");
        menu.append("\n1 - Login");
        menu.append("\n2 - Cadastro");
        menu.append("\n0 - Sair");
        menu.append("\n->");
        
        return Integer.parseInt(s.nextLine());
    }
    
    public int Timeline(Pessoa p,){
        StringBuilder menu = new StringBuilder("");
        
        menu.append("\n===== Bem vindo "+p.getNome()+" =====");
        
        menu.append("\n0 - Sair");
        menu.append("\n->");
        
        return Integer.parseInt(s.nextLine());
    }
}
