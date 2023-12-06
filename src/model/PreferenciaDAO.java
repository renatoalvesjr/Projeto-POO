package model;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PreferenciaDAO {

    public PreferenciaDAO(PessoaDAO p, AlimentoDAO al) {
                
    }
    
    public List<Preferencia> buscaPrefPorPessoa(Pessoa p){
        String sql = "select * from preferencia where Pessoa_idPessoa = ?";
        List<Preferencia> preferencias = new ArrayList<>();
        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, p.getId());
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Long id = rs.getLong("idPreferencia");
                    Long id1 = rs.getLong("Pessoa_idPessoa");
                    Long id2 = rs.getLong("Alimento_idAlimento");

                    Preferencia preferencia = new Preferencia();
                    preferencia.setId(id);
                    preferencia.setPessoa(new PessoaDAO().buscaPorId(id1));
                    preferencia.setAlimento(new AlimentoDAO().buscaAlimento(id2));
                    preferencias.add(preferencia);
                }
                return preferencias;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    
    public boolean criaPref(Preferencia preferencia){
        String sql = "insert into preferencia "
                + "(Pessoa_idPessoa,Alimento_idAlimento,createDate)" + " values (?,?,?)";

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement stmt = connection.prepareStatement(sql)) {
            // seta os valores
            stmt.setLong(1, preferencia.getPessoa().getId());

            stmt.setLong(2, preferencia.getAlimento().getId());
            
            stmt.setDate(3, java.sql.Date.valueOf(preferencia.getCreateDate()));

            stmt.execute();

            System.out.println("Preferencia criada com sucesso.");
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public boolean removePrefPorId(long id){
        String sql = "delete from preferencia where idPreferencia = ?";

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
