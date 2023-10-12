package model;

public class SeguindoDAO {
    Seguindo seguidores[] = new Seguindo[10];
    
    public SeguindoDAO(PessoaDAO pessoa, PostDAO posts) {
        Seguindo s1 = new Seguindo();
        s1.setPessoa(pessoa.buscaPorNome("Renato"));
        s1.setSeguidores(pessoa.buscaPorNome("Hebert"));
        s1.setSeguidores(pessoa.buscaPorNome("root"));
        criarSeguidor(s1);
        
        Seguindo s2 = new Seguindo();
        s2.setPessoa(pessoa.buscaPorNome("Hebert"));
        s2.setSeguidores(pessoa.buscaPorNome("Renato"));
        criarSeguidor(s2);
    }
    
    private int proximoSeguidorLivre(){
        for (int i = 0; i < seguidores.length; i++) {
            if(seguidores[i] == null){
                return i;
            }
        }
        return -1;
    } 
    
    boolean criarSeguidor(Seguindo a){
        int proximoSeguidorLivre = proximoSeguidorLivre();
        if(proximoSeguidorLivre != -1){
            seguidores[proximoSeguidorLivre] = a;
            return true;
        } else {
            return false;
        }
    }
    
    public Seguindo buscaSeguidorPessoa(Pessoa p) {
        for (int i = 0; i < seguidores.length; i++) {
            if(seguidores[i] != null && seguidores[i].getPessoa().getId() == p.getId()){
                return seguidores[i];
            }
        }
        return null;

    }
    
    public Pessoa mostraSeguidoresPessoa(Pessoa p){
        for (int i = 0; i < seguidores.length; i++) {
            if(seguidores[i].getPessoa() == p) {
                return seguidores[i].getPessoa();
            } 
            
        }
        return null;
    }
    
    public boolean removeSeguidor(long id){
        for (int i = 0; i < seguidores.length; i++) {
            if(seguidores[i].getId() == id){
                seguidores[i] = null;
                return true;
            }
        }
        return false;
    }
    
    boolean seguidoresVazio(){
        for (int i = 0; i < seguidores.length; i++) {
            if(seguidores[i] != null){
                return false;
            }
            
        }
        return true;
    }
}
