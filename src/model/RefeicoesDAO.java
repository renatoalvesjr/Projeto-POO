/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author grang
 */
public class RefeicoesDAO {
    Refeicoes rfs[] = new Refeicoes[10];
    
    public RefeicoesDAO(TipoDietaDAO td){
        Refeicoes rf1 = new Refeicoes();
        rf1.setTd(td.BuscaPorNome("equilibrada"));
        rf1.setNomeRefeicao("Cafe da manha");
        rf1.setCarb(60);
        rf1.setGord(45);
        rf1.setProt(45);
        rf1.setCal();
        criaRfs(rf1);
        
        Refeicoes rf2 = new Refeicoes();
        rf2.setTd(td.BuscaPorNome("equilibrada"));
        rf2.setNomeRefeicao("Almoco");
        rf2.setCarb(56);
        rf2.setGord(42);
        rf2.setProt(42);
        rf2.setCal();
        criaRfs(rf2);
        
        Refeicoes rf3 = new Refeicoes();
        rf3.setTd(td.BuscaPorNome("equilibrada"));
        rf3.setNomeRefeicao("Jantar");
        rf3.setCarb(40);
        rf3.setGord(30);
        rf3.setProt(30);
        rf3.setCal();
        criaRfs(rf3);
        
        Refeicoes rf4 = new Refeicoes();
        rf4.setTd(td.BuscaPorNome("equilibrada"));
        rf4.setNomeRefeicao("Cafe da Tarde");
        rf4.setCarb(40);
        rf4.setGord(30);
        rf4.setProt(30);
        rf4.setCal();
        criaRfs(rf4);
    }
    
    public boolean criaRfs(Refeicoes a) {
        String sql = "insert into refeicoes "
                + "(nome,carb,prot,gord,cal,TipoDieta_idTipoDieta,createDate)" + " values (?,?,?,?,?,?,?)";

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement stmt = connection.prepareStatement(sql)) {
            // seta os valores
            stmt.setString(1, a.getNomeRefeicao());
            stmt.setDouble(2, a.getCarb());
            stmt.setDouble(3, a.getProt());
            stmt.setDouble(4, a.getGord());
            stmt.setDouble(5, a.getCal());
            //stmt.setInt(6, a.getTd());
            stmt.setDate(7, java.sql.Date.valueOf(a.getCreateDate()));

            stmt.execute();

            System.out.println("Refeicao inserida com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return true;
    }
    

    public List<Refeicoes> mostraRfs() {
        String sql = "select * from refeicoes";

        List<Refeicoes> refeicoes = new ArrayList<>();

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement stmt = connection.prepareStatement(sql); ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Long id = rs.getLong("idRefeicoes");
                String nomeRefeicao = rs.getString("nome");
                Double carb = rs.getDouble("carb");
                Double prot = rs.getDouble("prot");
                Double gord = rs.getDouble("gord");
                Double cal = rs.getDouble("cal");
                //TipoDieta td = rs.getTd(TipoDieta_idTipoDieta);

                Refeicoes a = new Refeicoes();
                a.setId(id);
                a.setNomeRefeicao(nomeRefeicao);
                a.setCarb(carb);
                a.setProt(prot);
                a.setGord(gord);
                refeicoes.add(a);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return refeicoes;
    }

    public void removeRfsById(Refeicoes a){
        String sql = "delete from refeicoes where id = ?";

        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setLong(1, a.getId());
            
            stmt.execute();
            
            System.out.println("Refeicao excluída com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public Refeicoes buscaPorId(long id1) {
        String sql = "select * from refeicoes where id = ?";
        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, id1);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                Long id = rs.getLong("idRefeicoes");
                String nomeRefeicao = rs.getString("nome");
                Double carb = rs.getDouble("carb");
                Double prot = rs.getDouble("prot");
                Double gord = rs.getDouble("gord");
                Double cal = rs.getDouble("cal");
                //TipoDieta td = rs.getTd(TipoDieta_idTipoDieta);

                Refeicoes a = new Refeicoes();
                a.setId(id);
                a.setNomeRefeicao(nomeRefeicao);
                a.setCarb(carb);
                a.setProt(prot);
                a.setGord(gord);
                return a;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
       
    
}
