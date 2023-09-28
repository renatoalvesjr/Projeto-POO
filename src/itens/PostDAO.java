package itens;

public class PostDAO {
    Post posts[] = new Post[10];
    
    public PostDAO(){
        
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
    
    public void mostraTodosPost(){
        for (int i = 0; i < posts.length; i++) {
            if(posts[i] != null) {
                System.out.println(posts[i]);
            } 
            
        }
    }
    
    boolean removePost(long id){
        for (int i = 0; i < posts.length; i++) {
            if(posts[i].getId() == id){
                posts[i] = null;
                return true;
            }
        }
        return false;
    }
    
    boolean alteraConteudo(long id, String conteudo){
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
