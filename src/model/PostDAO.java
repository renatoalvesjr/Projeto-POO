package model;

public class PostDAO {
    Post posts[] = new Post[10];
    
    public PostDAO(PessoaDAO p1){
        Post post1 = new Post();
        post1.setConteudo("Minha dieta esta indo bem");
        post1.setPessoa(p1.buscaPorNome("renato"));
        criarPost(post1);
        
         Post post2 = new Post();
        post2.setConteudo("Minha dieta nao esta indo tao bem como eu ");
        post2.setPessoa(p1.buscaPorNome("renato"));
        criarPost(post2);
    }
    
    private int proximoPostLivre(){
        for (int i = 0; i < posts.length; i++) {
            if(posts[i] == null){
                return i;
            }
        }
        return -1;
    } 
    
    boolean criarPost(Post a){
        int proximoPostLivre = proximoPostLivre();
        if(proximoPostLivre != -1){
            posts[proximoPostLivre] = a;
            return true;
        } else {
            return false;
        }
    }
    
    public void mostraTodosPostPessoa(PessoaDAO p){
        for (int i = 0; i < posts.length; i++) {
            if(posts[i] != null) {
                System.out.println(posts[i].getConteudo());
            } 
            
        }
    }
    
    public boolean removePost(long id){
        for (int i = 0; i < posts.length; i++) {
            if(posts[i].getId() == id){
                posts[i] = null;
                return true;
            }
        }
        return false;
    }
    
    public boolean alteraConteudo(long id, String conteudo){
        for (int i = 0; i < posts.length; i++) {
            if(posts[i].getId() == id){
                posts[i].setConteudo(conteudo);
                return true;
            }
            
        }
        return false;
    }
    
    boolean postsVazio(){
        for (int i = 0; i < posts.length; i++) {
            if(posts[i] != null){
                return false;
            }
            
        }
        return true;
    }
}
