/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.util.Scanner;
import model.Pessoa;
import model.PessoaDAO;
import model.PostDAO;
import model.SeguindoDAO;
import view.Menus;

/**
 *
 * @author heber
 */
public class ProgramaPDAO {
    Menus menus = new Menus();
    PessoaDAO pessoaDAO = new PessoaDAO();
    PostDAO postsDAO = new PostDAO(pessoaDAO);
    SeguindoDAO seguidoresDAO = new SeguindoDAO(pessoaDAO, postsDAO);
    Scanner s = new Scanner(System.in);

    public ProgramaPDAO() {
        int opc;
        do{
            opc = menus.LoginPage();
            switch(opc){
                case 1:
                    Pessoa Plogada = menus.Logar(pessoaDAO);
                    if(Plogada!=null){
                        System.out.println("Logado com sucesso.");
                        postsDAO.mostraPostPessoa(pessoaDAO);
                    }else{
                        System.out.println("Usuario nao encontrado");
                    }
                    
                    break;
                case 2:
                    pessoaDAO.adiciona(menus.cadastrar());
                    break;
            }
        }while(opc!=0);
        
    }

    public static void main(String[] args) {
        new ProgramaPDAO();
    }
}
