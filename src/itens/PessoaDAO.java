/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itens;

/**
 *
 * @author heber
 */
public class PessoaDAO {
    Pessoa[] pessoas = new Pessoa[5];

    public PessoaDAO() {
        Pessoa p1 = new Pessoa();
        p1.setNome("Hebert");
        p1.setNascimento("21/09/2001");
        p1.setSexo("M");
        p1.setLogin("hebert");
        p1.setSenha("147852");
        this.adiciona(p1);

        Pessoa p2 = new Pessoa();
        p2.setNome("Renato");
        p2.setNascimento("21/08/2002");
        p2.setSexo("M");
        p2.setLogin("renato");
        p2.setSenha("124578");
        adiciona(p2);
    }

    boolean adiciona(Pessoa p) {
        int proximaPosicaoLivre = this.proximaPosicaoLivre();
        if (proximaPosicaoLivre != -1) {
            pessoas[proximaPosicaoLivre] = p;
            return true;
        } else {
            return false;
        }

    }

    public boolean Vazio() {
        for (Pessoa pessoas : pessoas) {
            if (pessoas != null) {
                return false;
            }
        }
        return true;

    }

    public void mostrarTodas() {
        boolean temPessoa = false;
        for (Pessoa p : pessoas) {
            if (p != null) {
                System.out.println(p);
                temPessoa = true;
            }
        }
        if (!temPessoa) {
            System.out.println("Nao possui nenhuma pessoa cadastrada!! ");
        }
    }

    public boolean alterarNome(String nome, String novoNome) {
        for (Pessoa pessoas : pessoas) {
            if (pessoas != null && pessoas.getNome().equals(nome)) {
                pessoas.setNome(novoNome);
                return true;
            }
        }
        return false;

    }

    Pessoa buscaPorNome(String nome) {
        for (Pessoa p : pessoas) {
            if (p != null && p.getNome().equals(nome)) {
                return p;
            }
        }
        return null;

    }

    public boolean remover(String nome) {
        for (int i = 0; i < pessoas.length; i++) {
            if (pessoas[i] != null && pessoas[i].getNome().equals(nome)) {
                pessoas[i] = null;
                return true;
            }
        }
        return false;
    }

    private int proximaPosicaoLivre() {
        for (int i = 0; i < pessoas.length; i++) {
            if (pessoas[i] == null) {
                return i;
            }

        }
        return -1;

    }
}