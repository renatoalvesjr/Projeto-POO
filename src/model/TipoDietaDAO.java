package model;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TipoDietaDAO {
    TipoDieta TDs[] = new TipoDieta[10];
    public TipoDietaDAO(){
//        TipoDieta td1 = new TipoDieta();
//        td1.setNome("EQUILIBRADA");
//        td1.setCarb(40);
//        td1.setProt(30);
//        td1.setGord(30);
//        criaTDs(td1);
    }

    public boolean criaTDs(TipoDieta td) {
        String sql = "insert into tipodieta "
                + "(nome,carb,prot,gord,createDate)" + " values (?,?,?,?,?)";

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement stmt = connection.prepareStatement(sql)) {
            // seta os valores
            stmt.setString(1, td.getNome());
            stmt.setDouble(2, td.getCarb());
            stmt.setDouble(3, td.getProt());
            stmt.setDouble(4, td.getGord());
            stmt.setDate(5, java.sql.Date.valueOf(td.getCreateDate()));

            stmt.execute();

            System.out.println("Tipo de dieta inserido com sucesso.");
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<TipoDieta> mostraTDs() {
        String sql = "select * from tipodieta";

        List<TipoDieta> tiposdieta = new ArrayList<>();

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement stmt = connection.prepareStatement(sql); ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Long id = rs.getLong("idTipoDieta");
                String nome = rs.getString("nome");
                Double carb = rs.getDouble("carb");
                Double prot = rs.getDouble("prot");
                Double gord = rs.getDouble("gord");

                TipoDieta td = new TipoDieta();
                td.setId(id);
                td.setNome(nome);
                td.setCarb(carb);
                td.setProt(prot);
                td.setGord(gord);;
                tiposdieta.add(td);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        // itera no ResultSet
        return tiposdieta;
    }
    
    public TipoDieta buscaTDId(long id) {
        String sql = "select * from tipodieta where id = ?";
        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Long id1 = rs.getLong("idTipoDieta");
                    String nome = rs.getString("nome");
                    Double carb = rs.getDouble("carb");
                    Double prot = rs.getDouble("prot");
                    Double gord = rs.getDouble("gord");

                    TipoDieta td = new TipoDieta();
                    td.setId(id1);
                    td.setNome(nome);
                    td.setCarb(carb);
                    td.setProt(prot);
                    td.setGord(gord);;
                    return td;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    
    public TipoDieta BuscaPorNome(String nome) {
        String sql = "select * from tipodieta where nome = ?";
        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, nome);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Long id = rs.getLong("idTipoDieta");
                    String nome1 = rs.getString("nome");
                    Double carb = rs.getDouble("carb");
                    Double prot = rs.getDouble("prot");
                    Double gord = rs.getDouble("gord");

                    TipoDieta td = new TipoDieta();
                    td.setId(id);
                    td.setNome(nome1);
                    td.setCarb(carb);
                    td.setProt(prot);
                    td.setGord(gord);;
                    return td;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
 
    public void removeTDs(TipoDieta td){
        String sql = "delete from tipodieta where id = ?";

        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setLong(1, td.getId());
            
            stmt.execute();
            
            System.out.println("Tipo dieta excluído com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    
}
