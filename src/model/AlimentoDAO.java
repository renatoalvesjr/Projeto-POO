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

    public boolean adiciona(Alimento alimento) {
        String sql = "insert into alimento"
                + "(nome,carb,prot,gord,cal,porcao,createDate)" + " values (?,?,?,?,?,?,?)";

        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {
            // seta os valores
            stmt.setString(1, alimento.getNome());
            stmt.setDouble(2, alimento.getCarb());
            stmt.setDouble(3, alimento.getProt());
            stmt.setDouble(4, alimento.getGord());
            stmt.setDouble(5, alimento.getCal());
            stmt.setDouble(6, alimento.getPorcao());
            stmt.setDate(7, java.sql.Date.valueOf(alimento.getCreateDate()));
            
            stmt.execute();
            Alimento al = new Alimento();
            double alsdl = al.carb;
            System.out.println("Alimento inserido com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //na verdade deveria retornar o elemento que foi inserido agora
        return true;
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
    
    public List<Alimento> buscaAlimento(long code) {
        String sql = "select * from alimento where idAlimento = ?";
        List<Alimento> alimentos = new ArrayList<>();
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

                    alimentos.add(ali);
                }
            }
        } catch (SQLException e) {
             throw new RuntimeException(e);
        }
        return alimentos;
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
// VERIFICAR SE NECESSARIO ALTERACAO PARA BOOLEAN
    public Alimento alterarNomeAlimento(Alimento alimento) {
        String sql = "update alimento set nome = ? where idAlimento = ?";

        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, alimento.getNome());
            stmt.setLong(2, alimento.getId());
            //ADICIONAR O MODIFYDATE
            
            stmt.execute();
            
            System.out.println("Nome alterado com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return alimento;
    }

    public Alimento alteraCarbAlimento(Alimento alimento) {
        String sql = "update alimento set carb = ? where idAlimento = ?";

        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setDouble(1, alimento.getCarb());
            stmt.setLong(2, alimento.getId());
            //ADICIONAR O MODIFYDATE
            
            stmt.execute();
            
            System.out.println("Carboidrato alterado com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return alimento;
    }
//    
//    public boolean alteraCarbAlimento(long id, double novoCarb){
//        for (int i = 0; i < alimentos.length; i++) {
//            if(alimentos[i].getId() == id){
//                alimentos[i].setCarb(novoCarb);
//                alimentos[i].setModifyDate();
//                return true;
//            }
//            
//        }
//        return false;
//    }
      public Alimento alteraProtAlimento(Alimento alimento) {
        String sql = "update alimento set prot = ? where idAlimento = ?";

        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setDouble(1, alimento.getProt());
            stmt.setLong(2, alimento.getId());
            //ADICIONAR O MODIFYDATE
            
            stmt.execute();
            
            System.out.println("Proteina alterada com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return alimento;
    }
//    public boolean alteraProtAlimento(long id, double novoProt){
//        for (int i = 0; i < alimentos.length; i++) {
//            if(alimentos[i].getId() == id){
//                alimentos[i].setProt(novoProt);
//                alimentos[i].setModifyDate();
//                return true;
//            }
//            
//        }
//        return false;
//    }
    public Alimento alteraGordAlimento(Alimento alimento) {
        String sql = "update alimento set gord = ? where idAlimento = ?";

        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setDouble(1, alimento.getGord());
            stmt.setLong(2, alimento.getId());
            //ADICIONAR O MODIFYDATE
            
            stmt.execute();
            
            System.out.println("Gordura alterada com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return alimento;
    }       
//    public boolean alteraGordAlimento(long id, double novoGord){
//        for (int i = 0; i < alimentos.length; i++) {
//            if(alimentos[i].getId() == id){
//                alimentos[i].setGord(novoGord);
//                alimentos[i].setModifyDate();
//                return true;
//            }
//        }
//        return false;
//    }
//    
}
