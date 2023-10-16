package model;

public class TipoDietaDAO {
    TipoDieta TDs[] = new TipoDieta[10];
    public TipoDietaDAO(){
        TipoDieta td1 = new TipoDieta();
        td1.setNome("EQUILIBRADA");
        td1.setCarb(40);
        td1.setProt(30);
        td1.setGord(30);
        criaTDs(td1);
    }
    
    private int proximTDsLivre() {
        for (int i = 0; i < TDs.length; i++) {
            if (TDs[i] == null) {
                return i;
            }
        }
        return -1;
    }

    public boolean criaTDs(TipoDieta a) {
        int proximTDsLivre = proximTDsLivre();
        if (proximTDsLivre != -1) {
            TDs[proximTDsLivre] = a;
            return true;
        } else {
            return false;
        }
    }

    public void mostraTDs() {
        for (int i = 0; i < TDs.length; i++) {
            if (TDs[i] != null) {
                System.out.println(TDs[i]);
            }

        }
    }
    
    public TipoDieta BuscaPorNome(String nome){
        for (int i = 0; i < TDs.length; i++) {
            if(TDs[i] != null && TDs[i].getNome().equalsIgnoreCase(nome)){
                return TDs[i];
            }
        }
        return null;
    }

    public boolean removeTDs(long id) {
        for (int i = 0; i < TDs.length; i++) {
            if (TDs[i].getId() == id) {
                TDs[i] = null;
                return true;
            }
        }
        return false;
    }

    public boolean alteraNomeTDs(long id, String novoNome){
        for (int i = 0; i < TDs.length; i++) {
            if(TDs[i].getId() == id){
                TDs[i].setNome(novoNome);
                TDs[i].setModifyDate();
                return true;
            }
            
        }
        return false;
    }
    
    public boolean alteraCarbTDs(long id, double novoCarb){
        for (int i = 0; i < TDs.length; i++) {
            if(TDs[i].getId() == id){
                TDs[i].setCarb(novoCarb);
                TDs[i].setModifyDate();
                return true;
            }
            
        }
        return false;
    }
    
    public boolean alteraProtTDs(long id, double novoProt){
        for (int i = 0; i < TDs.length; i++) {
            if(TDs[i].getId() == id){
                TDs[i].setProt(novoProt);
                TDs[i].setModifyDate();
                return true;
            }
            
        }
        return false;
    }
    
    public boolean alteraGordTDs(long id, double novoGord){
        for (int i = 0; i < TDs.length; i++) {
            if(TDs[i].getId() == id){
                TDs[i].setGord(novoGord);
                TDs[i].setModifyDate();
                return true;
            }
        }
        return false;
    }

    boolean TDsVazio() {
        for (int i = 0; i < TDs.length; i++) {
            if (TDs[i] != null) {
                return false;
            }

        }
        return true;
    }
}
