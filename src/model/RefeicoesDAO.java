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
        Refeicoes rf1 = new Refeicoes();
        rf1.setTd(td.BuscaPorNome("equilibrada"));
        rf1.setNomeRefeicao("Cafe da manha");
        rf1.setCarb(60);
        rf1.setGord(45);
        rf1.setProt(45);
        rf1.setCal();
        criaRfs(rf1);
        
        Refeicoes rf2 = new Refeicoes();
        rf2.setTd(td.BuscaPorNome("equilibrada"));
        rf2.setNomeRefeicao("Almoco");
        rf2.setCarb(56);
        rf2.setGord(42);
        rf2.setProt(42);
        rf2.setCal();
        criaRfs(rf2);
        
        Refeicoes rf3 = new Refeicoes();
        rf3.setTd(td.BuscaPorNome("equilibrada"));
        rf3.setNomeRefeicao("Jantar");
        rf3.setCarb(40);
        rf3.setGord(30);
        rf3.setProt(30);
        rf3.setCal();
        criaRfs(rf3);
        
        Refeicoes rf4 = new Refeicoes();
        rf4.setTd(td.BuscaPorNome("equilibrada"));
        rf4.setNomeRefeicao("Cafe da Tarde");
        rf4.setCarb(40);
        rf4.setGord(30);
        rf4.setProt(30);
        rf4.setCal();
        criaRfs(rf4);
    }
    
    private int proximRfsLivre() {
        for (int i = 0; i < rfs.length; i++) {
            if (rfs[i] == null) {
                return i;
            }
        }
        return -1;
    }

    public boolean criaRfs(Refeicoes a) {
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
    
    public Refeicoes buscaPorId(long id){
        for (int i = 0; i < rfs.length; i++) {
            if(rfs[i] != null && rfs[i].getId() == id)
                return rfs[i];
        }
        return null;
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
