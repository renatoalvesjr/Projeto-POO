package model;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SeguindoDAO {
    
    public SeguindoDAO() {

    }

    
    public boolean criarSeguidor(Seguindo seguindo){
        String sql = "insert into seguindo "
                + "(Pessoa_idPessoa,Pessoa_idPessoaSeguindo)" + " values (?,?)";

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement stmt = connection.prepareStatement(sql)) {
            // seta os valores
            stmt.setLong(1, seguindo.getPessoa().getId());

            stmt.setLong(2, seguindo.getSeguidores().getId());

            stmt.execute();

            System.out.println("Seguidor criado com sucesso.");
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
       
    }
    
    public List<Seguindo> buscaSeguidoresPessoa(Pessoa p) {
        String sql = "select * from seguindo where Pessoa_idPessoa = ?";
        List<Seguindo> seguindo = new ArrayList<>();
        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, p.getId());
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Long id1 = rs.getLong("Pessoa_idPessoa");
                    Long id2 = rs.getLong("Pessoa_idPessoaSeguindo");

                    Seguindo seguidor = new Seguindo();
                    seguidor.setPessoa(new PessoaDAO().buscaPorId(id1));
                    seguidor.setSeguidores(new PessoaDAO().buscaPorId(id2));
                    seguindo.add(seguidor);
                }
                return seguindo;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    
    public List<Pessoa> mostraSeguidoresPessoa(Pessoa p){
        String sql = "select * from seguindo where Pessoa_idPessoa = ?";
        List<Pessoa> seguidores = new ArrayList<>();
        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setLong(1, p.getId());
            try (ResultSet rs = ps.executeQuery()){
                while(rs.next()){
                    
                    Long id = rs.getLong("Pessoa_idPessoaSeguindo");
                
                    Pessoa pessoa = new PessoaDAO().buscaPorId(id);
                    seguidores.add(pessoa);
                }
                return seguidores;
            }
            
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public boolean removeSeguidor(long id){
       String sql = "delete from seguindo where Pessoa_idPessoaSeguindo = ?";

        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setLong(1, id);
            
            stmt.execute();
            
            System.out.println("Seguidor excluído com sucesso.");
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
