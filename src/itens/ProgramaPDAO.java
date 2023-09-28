/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itens;

import java.util.Scanner;

/**
 *
 * @author heber
 */
public class ProgramaPDAO {
    PessoaDAO pessoaDAO = new PessoaDAO();
    Scanner s = new Scanner(System.in);

    public ProgramaPDAO() {

        int opcaoUsuario;
        do {

            opcaoUsuario = pegaOpcaoUsuario();
            switch (opcaoUsuario) {
                case 1:
                    Pessoa p = criaPessoa();

                    boolean pessoaFoiInserida = pessoaDAO.adiciona(p);
                    if (pessoaFoiInserida) {
                        System.out.println("Pessoa inserida com sucesso!!!");
                    } else {
                        System.out.println("Pessoa nao inserida!!");
                    }
                    break;
                    
                case 2:
                    pessoaDAO.mostrarTodas();
                    break;
                    
                case 3:
                    System.out.println("Pessoa procurada:  ");
                    String procurado = s.nextLine();
                    System.out.println("Novo nome:");
                    String novoNome = s.nextLine();
                    if (pessoaDAO.alterarNome(procurado, novoNome)) {
                        System.out.println("Pessoa alterada! ");
                    } else {
                        System.out.println("Pessoa nao alterada!! ");
                    }
                    break;
                    
                case 4:
                    System.out.println("Pessoa procurada:  ");
                    String nomeExclusao = s.nextLine();

                    if (pessoaDAO.remover(nomeExclusao)) {
                        System.out.println("Pessoa excluida!!");
                    } else {
                        System.out.println("Pessoa nao excluida!!");
                    }
                    break;
                    
                case 5:
                    System.out.println("5");
                    break;

                default:
                    System.out.println("sair");
                    break;
            }
        } while (opcaoUsuario != 5);
    }

    private Pessoa criaPessoa() {
        Pessoa p = new Pessoa();
        System.out.println("Nome: ");
        String nome = s.nextLine();
        p.setNome(nome);
        System.out.println("Sexo - M(Masculino) F(Feminino):  ");
        String sexo = s.nextLine();
        p.setSexo(sexo);
        System.out.println("Data de Nascimento - dd/mm/aaaa:  ");
        String nascimento = s.nextLine();
        p.setNascimento(nascimento);
        System.out.println("Login de Cadastro: ");
        String login = s.nextLine();
        p.setLogin(login);
        System.out.println("Senha: ");
        String senha = s.nextLine();
        p.setSenha(senha);
        return p;
    }

    private int pegaOpcaoUsuario() {

        System.out.println("1 - Cadastrar");
        System.out.println("2 - Mostrar Usuarios");
        System.out.println("3 - Alterar o nome");
        System.out.println("4 - Excluir");
        System.out.println("5 - Sair");
        System.out.print("Qual sua opcao ? R:  ");
        return Integer.parseInt(s.nextLine());
    }

    public static void main(String[] args) {
        new ProgramaPDAO();
    }
}
