package model;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PostDAO {

    Post posts[] = new Post[20];

    public PostDAO(PessoaDAO p1) {
        Post post1 = new Post();
        post1.setConteudo("Minha dieta esta indo bem");
        post1.setPessoa(p1.buscaPorNome("Renato"));
        criarPost(post1);
    }

    public boolean criarPost(Post post) {
        String sql = "insert into post "
                + "(conteudo,Pessoa_idPessoa,createDate)" + " values (?,?,?)";

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement stmt = connection.prepareStatement(sql)) {
            // seta os valores
            stmt.setString(1, post.getConteudo());

            stmt.setLong(2, post.getPessoa().getId());

            stmt.setDate(3, java.sql.Date.valueOf(post.getCreateDate()));

            stmt.execute();

            System.out.println("Post criado com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return true;
    }

    public List<Post> mostraTodosPostPessoa(Pessoa p) {
        String sql = "select * from post where Pessoa_idPessoa = ?";
        List<Post> posts = new ArrayList<>();
        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, p.getId());
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Long id = rs.getLong("idPost");
                    String conteudo = rs.getString("conteudo");


                    Post post = new Post();
                    post.setId(id);
                    post.setConteudo(conteudo);
                    posts.add(post);

                    return posts;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public boolean removePost(long id) {
        
        String sql = "delete from post where id = ?";

        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setLong(1, id);
            
            stmt.execute();
            
            System.out.println("Post excluído com sucesso.");
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
