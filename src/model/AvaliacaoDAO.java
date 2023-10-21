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
        Avaliacao av1 = new Avaliacao();
        av1.setPessoa(pdao.buscaPorNome("renato"));
        av1.setAltura(190);
        av1.setIdade(23);
        av1.setPeso(75);
        av1.setRotina(2);
        av1.setQuadril(100);
        av1.setCintura(80);
        av1.setPescoco(38);
        av1.calcBF();
        av1.calcIMC();
        av1.calcTMB();
        criaAval(av1);
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
            }
        }
        return null;
    }
    
    public Avaliacao[] buscaTodasAvals(){
        if(avals.length != 0){
            return avals;
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

    public boolean alteraMedidas(long id, int idade, double altura, double cintura, double quadril, double pescoco, double peso, int rotina) {
        for (int i = 0; i < avals.length; i++) {
            if (avals[i].getId() == id) {
                avals[i].setIdade(idade);
                avals[i].setAltura(altura);
                avals[i].setCintura(cintura);
                avals[i].setQuadril(quadril);
                avals[i].setPescoco(pescoco);
                avals[i].setPeso(peso);
                avals[i].setRotina(rotina);
                avals[i].calcIMC();
                avals[i].calcBF();
                avals[i].calcTMB();
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
