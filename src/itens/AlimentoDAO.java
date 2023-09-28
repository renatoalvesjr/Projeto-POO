/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itens;

/**
 *
 * @author grang
 */
public class AlimentoDAO {
    Alimento[] alimentos = new Alimento[10];
    
    public AlimentoDAO(){
        Alimento ali1 = new Alimento();
        ali1.setNome("Peito de Frango Grelhado, sem pele");
        ali1.setCarb(0);
        ali1.setGord(2.5);
        ali1.setProt(32);
        ali1.setPorcao(100);
        this.adicionaAlimento(ali1);
        
        Alimento ali2 = new Alimento();
        ali2.setNome("Arroz Integral cozido");
        ali2.setCarb(28.8);
        ali2.setGord(1);
        ali2.setProt(2.6);
        ali2.setPorcao(100);
        this.adicionaAlimento(ali2);
        
        Alimento ali3 = new Alimento();
        ali3.setNome("Feijao Carioca cozido");
        ali3.setCarb(13.6);
        ali3.setGord(0.5);
        ali3.setProt(4.5);
        ali3.setPorcao(100);
        this.adicionaAlimento(ali3);
        
        Alimento ali4 = new Alimento();
        ali4.setNome("Couve");
        ali4.setCarb(4.3);
        ali4.setGord(0.5);
        ali4.setProt(2.9);
        ali4.setPorcao(100);
        this.adicionaAlimento(ali4);
    }
    
    private int proximoAlimentoLivre() {
        for (int i = 0; i < alimentos.length; i++) {
            if (alimentos[i] == null) {
                return i;
            }
        }
        return -1;
    }
        
    boolean adicionaAlimento(Alimento a){
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
    
    Alimento BuscaAlimento(long id){
        for (int i = 0; i < alimentos.length; i++) {
            if(alimentos[i].getId() == id){
                return alimentos[i];
            }
            
        }
        return null;
    }
    
    boolean removeAlimento(long id){
        for (int i = 0; i < alimentos.length; i++) {
            if(alimentos[i].getId() == id){
                alimentos[i] = null;
                return true;
            }
        }
        return false;
    }
    
    boolean alteraNomeAlimento(long id, String novoNome){
        for (int i = 0; i < alimentos.length; i++) {
            if(alimentos[i].getId() == id){
                alimentos[i].setNome(novoNome);
                alimentos[i].setModifyDate();
                return true;
            }
            
        }
        return false;
    }
    
    boolean alteraCarbAlimento(long id, double novoCarb){
        for (int i = 0; i < alimentos.length; i++) {
            if(alimentos[i].getId() == id){
                alimentos[i].setCarb(novoCarb);
                alimentos[i].setModifyDate();
                return true;
            }
            
        }
        return false;
    }
    
    boolean alteraProtAlimento(long id, double novoProt){
        for (int i = 0; i < alimentos.length; i++) {
            if(alimentos[i].getId() == id){
                alimentos[i].setProt(novoProt);
                alimentos[i].setModifyDate();
                return true;
            }
            
        }
        return false;
    }
    
    boolean alteraGordAlimento(long id, double novoGord){
        for (int i = 0; i < alimentos.length; i++) {
            if(alimentos[i].getId() == id){
                alimentos[i].setGord(novoGord);
                alimentos[i].setModifyDate();
                return true;
            }
        }
        return false;
    }
}
