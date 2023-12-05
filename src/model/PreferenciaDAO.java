package model;

public class PreferenciaDAO {
    Preferencia prefs[] = new Preferencia[10];

    public PreferenciaDAO(PessoaDAO p, AlimentoDAO al) {
        Preferencia p1 = new Preferencia();
        p1.setPessoa(p.buscaPorNome("renato"));
        p1.setAlimento((Alimento) al.buscaAlimento(1));
        p1.setAlimento((Alimento) al.buscaAlimento(2));
        criaPref(p1);
                
    }
    
    public Preferencia buscaPref(Pessoa p){
        for (int i = 0; i < prefs.length; i++) {
            if(prefs[i]!=null && prefs[i].getPessoa().equals(p)){
                return prefs[i];
            }
        }
        return null;
    }
    
    private int proximaPosicaoLivre() {
        for (int i = 0; i < prefs.length; i++) {
            if (prefs[i] == null) {
                return i;
            }
        }
        return -1;
    }
    
    public boolean criaPref(Preferencia p){
        int proximaPosicaoLivre = this.proximaPosicaoLivre();
        if (proximaPosicaoLivre != -1) {
            prefs[proximaPosicaoLivre] = p;
            return true;
        } else {
            return false;
        }
    }
    
    public boolean removePrefById(long id){
        for (int i = 0; i < prefs.length; i++) {
            if(prefs[i].getId() == id){
                prefs[i] = null;
                return true;
            }
        }
        return true;
    }
}
