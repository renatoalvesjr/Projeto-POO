package model;

public class SeguindoDAO {
    Seguindo seguidores[] = new Seguindo[10];
    
    public SeguindoDAO(PessoaDAO pessoa, PostDAO posts) {
        Seguindo s1 = new Seguindo();
        s1.setPessoa(pessoa.buscaPorNome("renato"));
        s1.setSeguidores(pessoa.buscaPorNome("hebert"));
        criarSeguidor(s1);
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
    
    public Pessoa buscaPorNome(String nome) {
        for (int i = 0; i < seguidores.length; i++) {
            if(seguidores[i].getPessoa().getNome().equals(nome)){
                return seguidores[i].getPessoa();
            }
            
        }
        return null;

    }
    
    public void mostraTodosSeguidor(){
        for (int i = 0; i < seguidores.length; i++) {
            if(seguidores[i] != null) {
                System.out.println(seguidores[i]);
            } 
            
        }
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
