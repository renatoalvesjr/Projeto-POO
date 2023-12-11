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
import model.RefeicoesDAO;


public class AlimentoRefeicaoDAO {

    AlimentoRefeicao[] alimentoRefeicao = new AlimentoRefeicao[20];

    public AlimentoRefeicaoDAO(RefeicoesDAO refeicaoDAO, AlimentoDAO alimentoDAO, PessoaDAO pessoaDAO) {

    }

    
    public boolean criaRefeicaoAlimento(AlimentoRefeicao alrf) {
        String sql = "insert into alimentorefeicao"
                + "(Refeicoes_idRefeicoes,Refeicoes_TipoDieta_idTipoDieta,Alimento_idAlimento,Pessoa_idPessoa,porcao,createDate)" + " values (?,?,?,?,?,?)";

        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {
            // seta os valores
            stmt.setLong(1, alrf.getRefeicao().getId());
            stmt.setLong(2, alrf.getRefeicao().getTd().getId());
            stmt.setLong(3, alrf.getAlimento().getId());
            stmt.setLong(4, alrf.getPessoa().getId());
            stmt.setDouble(5, alrf.getPorcao());
            stmt.setDate(6, java.sql.Date.valueOf(alrf.getCreateDate()));
            
            stmt.execute();
            
            System.out.println("Alimento Refeicao inserido com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }    

    
    public boolean removeAlimentoRefeicao(AlimentoRefeicao alrf){
        String sql = "delete from alimentorefeicao where Pessoa_idPessoa = ? AND Refeicao_idRefeicao = ?";

        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setLong(2, alrf.getRefeicao().getId());
            stmt.setLong(1, alrf.getPessoa().getId());
            
            stmt.execute();
            
            System.out.println("Alimento Refeicao excluído com sucesso.");
             return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public boolean removeRefeicaoPorNome(AlimentoRefeicao alrf){
        String sql = "delete from alimentorefeicao where id = ?";

        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setLong(1, alrf.getId());
            
            stmt.execute();
            
            System.out.println("Alimento Refeicao excluído com sucesso.");
             return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    //PAREI AQUI


    public AlimentoRefeicao buscaPorId(long id) {
        for (int i = 0; i < alimentoRefeicao.length; i++) {
            if (alimentoRefeicao[i] != null && alimentoRefeicao[i].getId() == id) {
                return alimentoRefeicao[i];
            }
        }
        return null;
    }

    public AlimentoRefeicao buscaAlimentosRefeicaoNome(Pessoa p, String nome) {
        for (int i = 0; i < alimentoRefeicao.length; i++) {
            if (alimentoRefeicao[i] != null && alimentoRefeicao[i].getPessoa().equals(p) && alimentoRefeicao[i].getRefeicao().getNomeRefeicao().equalsIgnoreCase(nome)) {
                return alimentoRefeicao[i];
            }
        }
        return null;
    }

    public List<AlimentoRefeicao> buscaTodosPorPessoa(Pessoa p) {
        String sql = "select * from alimentorefeicao where Pessoa_idPessoa = ?";

        List<AlimentoRefeicao> refeicoes = new ArrayList<>();

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement stmt = connection.prepareStatement(sql); ResultSet rs = stmt.executeQuery(sql)) {
            stmt.setLong(1, p.getId());
            while (rs.next()) {
                Long idAlimento = rs.getLong("Alimento_idAlimento");
                Long idRefeicao = rs.getLong("Alimento_idAlimento");
                Long idTipoDieta = rs.getLong("Alimento_idAlimento");
                int porcao = rs.getInt("Porcao");
                
                AlimentoRefeicao alrf = new AlimentoRefeicao();
                alrf.setAlimento(new AlimentoDAO().buscaAlimento(idAlimento));
                alrf.setRefeicao(new RefeicoesDAO().buscaPorId(idRefeicao));
                alrf.setTipodieta(new TipoDietaDAO().buscaTDId(idTipoDieta));
                refeicoes.add(alrf);
            }
            return refeicoes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        // itera no ResultSet
    }
    
    public AlimentoRefeicao[] buscaTodosPorRefeicao(Pessoa p, String nome) {
        AlimentoRefeicao[] alrf = new AlimentoRefeicao[20];
        int id = 0;
        for (int i = 0; i < alimentoRefeicao.length; i++) {
            if(alimentoRefeicao[i] != null && alimentoRefeicao[i].getPessoa().equals(p) && alimentoRefeicao[i].getRefeicao().getNomeRefeicao().equalsIgnoreCase(nome)){
                alrf[id] = alimentoRefeicao[i];
                id++;
            }
            
        }
        if(alrf.length > 0){
            return alrf;
        }
        return null;
    }
}
