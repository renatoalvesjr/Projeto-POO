/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import connection.ConnectionFactory;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author grang
 */
public class AlimentoDAO {
   // List<Alimento> alimentos = new ArrayList<>();
    
    
    public AlimentoDAO(){
              
//        Alimento ali1 = new Alimento();
//        ali1.setNome("Peito de Frango Grelhado, sem pele");
//        ali1.setCarb(0);
//        ali1.setGord(2.5);
//        ali1.setProt(32);
//        ali1.setPorcao(100);
//        ali1.setCal();
//        adiciona(ali1);
        
//        List lista = mostraAlimentos();
//        System.out.println(lista);
    }
    
    public static void main(String[] args) {
        new AlimentoDAO();
    }

    public long adiciona(Alimento alimento) {
        String sql = "insert into alimento"
                + "(nome,carb,prot,gord,cal,porcao,createDate)" + " values (?,?,?,?,?,?,?)";

        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)) {
            // seta os valores
            stmt.setString(1, alimento.getNome());
            stmt.setDouble(2, alimento.getCarb());
            stmt.setDouble(3, alimento.getProt());
            stmt.setDouble(4, alimento.getGord());
            stmt.setDouble(5, alimento.getCal());
            stmt.setDouble(6, alimento.getPorcao());
            stmt.setDate(7, java.sql.Date.valueOf(alimento.getCreateDate()));
            
            stmt.execute();
            
            ResultSet rs=stmt.getGeneratedKeys();
            
            int retorno=0;
            if(rs.next()){
                retorno = rs.getInt(1);
            }
            System.out.println("Alimento inserido com sucesso.");

            return retorno;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //na verdade deveria retornar o elemento que foi inserido agora
    }
    
    public List<Alimento> mostraAlimentos() {
        String sql = "select * from alimento";

        List<Alimento> alimentos = new ArrayList<>();

        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Long id = rs.getLong("idAlimento");
                String nome = rs.getString("nome");
                Double carb = rs.getDouble("carb");
                Double prot = rs.getDouble("prot");
                Double gord = rs.getDouble("gord");
                Double porcao = rs.getDouble("porcao");

                Alimento ali = new Alimento();
                ali.setId(id);
                ali.setNome(nome);
                ali.setCarb(carb);
                ali.setProt(prot);
                ali.setGord(gord);
                ali.setPorcao(porcao);
                
                alimentos.add(ali);
            }
        } catch (SQLException e) {
             throw new RuntimeException(e);
        }

        return alimentos;
    }
    
    public Alimento buscaAlimento(long code) {
        String sql = "select * from alimento where idAlimento = ?";
        try (Connection connection = new ConnectionFactory().getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)) {           
            ps.setLong(1, code);
            
            try (ResultSet rs = ps.executeQuery()) {
                while(rs.next()) {
                    Long id = rs.getLong("idAlimento");
                    String nome = rs.getString("nome");
                    Double carb = rs.getDouble("carb");
                    Double prot = rs.getDouble("prot");
                    Double gord = rs.getDouble("gord");
                    Double porcao = rs.getDouble("porcao");

                    Alimento ali = new Alimento();
                    ali.setId(id);
                    ali.setNome(nome);
                    ali.setCarb(carb);
                    ali.setProt(prot);
                    ali.setGord(gord);
                    ali.setPorcao(porcao);

                    return ali;
                }
            }
        } catch (SQLException e) {
             throw new RuntimeException(e);
        }
        return null;
    }
//    
        public Alimento removeAlimento(Alimento alimento) {
            String sql = "delete from alimento where idAlimento = ?";

            try (Connection connection = new ConnectionFactory().getConnection();
                    PreparedStatement stmt = connection.prepareStatement(sql)) {

                stmt.setLong(1, alimento.getId());

                stmt.execute();

                System.out.println("Alimento excluído com sucesso.");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return alimento;
        }
}
