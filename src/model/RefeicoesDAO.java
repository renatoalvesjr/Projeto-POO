/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author grang
 */
public class RefeicoesDAO {
    Refeicoes rfs[] = new Refeicoes[10];
    
    public RefeicoesDAO(TipoDietaDAO td){
        
    }
    
    private int proximRfsLivre() {
        for (int i = 0; i < rfs.length; i++) {
            if (rfs[i] == null) {
                return i;
            }
        }
        return -1;
    }

    public boolean criaTDs(Refeicoes a) {
        int proximRfsLivre = proximRfsLivre();
        if (proximRfsLivre != -1) {
            rfs[proximRfsLivre] = a;
            return true;
        } else {
            return false;
        }
    }

    public void mostraRfs() {
        for (int i = 0; i < rfs.length; i++) {
            if (rfs[i] != null) {
                System.out.println(rfs[i]);
            }

        }
    }

    public boolean removeRfsById(long id) {
        for (int i = 0; i < rfs.length; i++) {
            if (rfs[i].getId() == id) {
                rfs[i] = null;
                return true;
            }
        }
        return false;
    }

    public boolean alteraNomeRfs(long id, String novoNome){
        for (int i = 0; i < rfs.length; i++) {
            if(rfs[i].getId() == id){
                rfs[i].setNomeRefeicao(novoNome);
                rfs[i].setModifyDate();
                return true;
            }
            
        }
        return false;
    }
    
    public boolean alteraCarbRfs(long id, double novoCarb){
        for (int i = 0; i < rfs.length; i++) {
            if(rfs[i].getId() == id){
                rfs[i].setCarb(novoCarb);
                rfs[i].setModifyDate();
                return true;
            }
            
        }
        return false;
    }
    
    public boolean alteraProtRfs(long id, double novoProt){
        for (int i = 0; i < rfs.length; i++) {
            if(rfs[i].getId() == id){
                rfs[i].setProt(novoProt);
                rfs[i].setModifyDate();
                return true;
            }
            
        }
        return false;
    }
    
    public boolean alteraGordRfs(long id, double novoGord){
        for (int i = 0; i < rfs.length; i++) {
            if(rfs[i].getId() == id){
                rfs[i].setGord(novoGord);
                rfs[i].setModifyDate();
                return true;
            }
        }
        return false;
    }

    boolean RfsVazio() {
        for (int i = 0; i < rfs.length; i++) {
            if (rfs[i] != null) {
                return false;
            }

        }
        return true;
    }
}
