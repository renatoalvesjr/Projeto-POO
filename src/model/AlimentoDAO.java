/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author grang
 */
public class AlimentoDAO {
    Alimento[] alimentos = new Alimento[20];
    
    public AlimentoDAO(){
        Alimento ali1 = new Alimento();
        ali1.setNome("Peito de Frango Grelhado, sem pele");
        ali1.setCarb(0);
        ali1.setGord(2.5);
        ali1.setProt(32);
        ali1.setPorcao(100);
        ali1.setCal();
        this.adicionaAlimento(ali1);
        
        Alimento ali2 = new Alimento();
        ali2.setNome("Arroz Integral cozido");
        ali2.setCarb(28.8);
        ali2.setGord(1);
        ali2.setProt(2.6);
        ali2.setPorcao(100);
        ali2.setCal();
        this.adicionaAlimento(ali2);
        
        Alimento ali3 = new Alimento();
        ali3.setNome("Feijao Carioca cozido");
        ali3.setCarb(13.6);
        ali3.setGord(0.5);
        ali3.setProt(4.5);
        ali3.setPorcao(100);
        ali3.setCal();
        this.adicionaAlimento(ali3);
        
        Alimento ali4 = new Alimento();
        ali4.setNome("Couve");
        ali4.setCarb(4.3);
        ali4.setGord(0.5);
        ali4.setProt(2.9);
        ali4.setPorcao(100);
        ali4.setCal();
        this.adicionaAlimento(ali4);

        
        Alimento ali5 = new Alimento();
        ali5.setNome("Cereal matinal - Milho");
        ali5.setCarb(83.9);
        ali5.setGord(1.0);
        ali5.setProt(7.2);
        ali5.setPorcao(100);
        ali5.setCal();
        this.adicionaAlimento(ali5);
        
        Alimento ali6 = new Alimento();
        ali6.setNome("Batata inglesa cozida");
        ali6.setCarb(11.9);
        ali6.setGord(0.1);
        ali6.setProt(1.2);
        ali6.setPorcao(100);
        ali6.setCal();
        this.adicionaAlimento(ali6);
        
        Alimento ali7 = new Alimento();
        ali7.setNome("Abacate");
        ali7.setCarb(6.0);
        ali7.setGord(8.4);
        ali7.setProt(1.9);
        ali7.setPorcao(100);
        ali7.setCal();
        this.adicionaAlimento(ali7);
        
        Alimento ali8 = new Alimento();
        ali8.setNome("Atum conserva em oleo");
        ali8.setCarb(0.0);
        ali8.setGord(6.0);
        ali8.setProt(26.2);
        ali8.setPorcao(100);
        ali8.setCal();
        this.adicionaAlimento(ali8);
        
        Alimento ali9 = new Alimento();
        ali9.setNome("Acem moido cozido");
        ali9.setCarb(0.0);
        ali9.setGord(10.9);
        ali9.setProt(26.7);
        ali9.setPorcao(100);
        ali9.setCal();
        this.adicionaAlimento(ali9);
        
        
        

    }
    
    private int proximoAlimentoLivre() {
        for (int i = 0; i < alimentos.length; i++) {
            if (alimentos[i] == null) {
                return i;
            }
        }
        return -1;
    }
        
    public boolean adicionaAlimento(Alimento a){
        int proximoAlimentoLivre = proximoAlimentoLivre();
        if(proximoAlimentoLivre != -1){
            alimentos[proximoAlimentoLivre] = a;
            return true;
        } else {
            return false;
        }
    }
    
    public void mostraTodosAlimentos(){
        for (int i = 0; i < alimentos.length; i++) {
            if(alimentos[i] != null) {
                System.out.println(alimentos[i]);
            } 
            
        }
    }
    
    public Alimento BuscaAlimento(long id){
        for (int i = 0; i < alimentos.length; i++) {
            if(alimentos[i] != null && alimentos[i].getId() == id){
                return alimentos[i];
            }
            
        }
        return null;
    }
    
    public boolean removeAlimento(long id){
        for (int i = 0; i < alimentos.length; i++) {
            if(alimentos[i].getId() == id){
                alimentos[i] = null;
                return true;
            }
        }
        return false;
    }
    
    public boolean alteraNomeAlimento(long id, String novoNome){
        for (int i = 0; i < alimentos.length; i++) {
            if(alimentos[i].getId() == id){
                alimentos[i].setNome(novoNome);
                alimentos[i].setModifyDate();
                return true;
            }
            
        }
        return false;
    }
    
    public boolean alteraCarbAlimento(long id, double novoCarb){
        for (int i = 0; i < alimentos.length; i++) {
            if(alimentos[i].getId() == id){
                alimentos[i].setCarb(novoCarb);
                alimentos[i].setModifyDate();
                return true;
            }
            
        }
        return false;
    }
    
    public boolean alteraProtAlimento(long id, double novoProt){
        for (int i = 0; i < alimentos.length; i++) {
            if(alimentos[i].getId() == id){
                alimentos[i].setProt(novoProt);
                alimentos[i].setModifyDate();
                return true;
            }
            
        }
        return false;
    }
    
    public boolean alteraGordAlimento(long id, double novoGord){
        for (int i = 0; i < alimentos.length; i++) {
            if(alimentos[i].getId() == id){
                alimentos[i].setGord(novoGord);
                alimentos[i].setModifyDate();
                return true;
            }
        }
        return false;
    }
    
    public boolean alimentoVazio(){
        for (int i = 0; i < alimentos.length; i++) {
            if(alimentos[i] != null){
                return false;
            }
            
        }
        return true;
    }
}
