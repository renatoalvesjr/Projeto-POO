/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Alunos
 */
public class AvaliacaoDAO {
    Avaliacao [] avals = new Avaliacao[10];
    
    public AvaliacaoDAO(PessoaDAO pdao){
        
    }
    
     private int proximAvalLivre() {
        for (int i = 0; i < avals.length; i++) {
            if (avals[i] == null) {
                return i;
            }
        }
        return -1;
    }

    public boolean criaAval(Avaliacao a) {
        int proximAvalLivre = proximAvalLivre();
        if (proximAvalLivre != -1) {
            avals[proximAvalLivre] = a;
            return true;
        } else {
            return false;
        }
    }
    
    public Avaliacao buscaAvalPessoa(Pessoa p){
        for (int i = 0; i < avals.length; i++) {
            if(avals[i] != null && avals[i].getPessoa().equals(p)){
                return avals[i];
            }else{
                return null;
            }
        }
        return null;
    }

    public void mostraTodasAval() {
        for (int i = 0; i < avals.length; i++) {
            if (avals[i] != null) {
                System.out.println(avals[i]);
            }

        }
    }

    public boolean removeAvals(long id) {
        for (int i = 0; i < avals.length; i++) {
            if (avals[i].getId() == id) {
                avals[i] = null;
                return true;
            }
        }
        return false;
    }

    public boolean alteraMedidas(long id, double altura, double cintura, double quadril, double pescoco, double peso) {
        for (int i = 0; i < avals.length; i++) {
            if (avals[i].getId() == id) {
                avals[i].setAltura(altura);
                avals[i].setCintura(cintura);
                avals[i].setQuadril(quadril);
                avals[i].setPescoco(pescoco);
                avals[i].setPeso(peso);
                return true;
            }

        }
        return false;
    }

    boolean avalsVazio() {
        for (int i = 0; i < avals.length; i++) {
            if (avals[i] != null) {
                return false;
            }

        }
        return true;
    }
    
}
