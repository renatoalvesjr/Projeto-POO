package model;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.AvaliacaoDAO;

public class RegistroDietaDAO {

    RegistroDieta[] rd = new RegistroDieta[10];

    public RegistroDietaDAO(PessoaDAO pessoaDAO, TipoDietaDAO tipodietaDAO, AvaliacaoDAO avaliacaoDAO) {
        RegistroDieta rd1 = new RegistroDieta();
      
//        rd1.setPessoa(pessoaDAO.buscaPorNome("renato"));
//        rd1.setAvaliacao(avaliacaoDAO.buscaAvalPessoa(pessoaDAO.buscaPorNome("renato")));
//        rd1.setTipoDieta(tipodietaDAO.BuscaPorNome("EQUILIBRADA"));
//        rd1.setObjetivo(2);
//        rd1.setNumRefeicao(4);
//        criaRD(rd1);
    }


    public boolean criaRD(RegistroDieta reg) {
        String sql = "insert into registrodieta "
                + "(Pessoa_idPessoa,Avaliacao_idAvaliacao,TipoDieta_idTipoDieta,objetivo,cal,numRefeicoes,createDate)" + " values (?,?,?,?,?,?,?)";

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement stmt = connection.prepareStatement(sql)) {
            // seta os valores
            stmt.setLong(1, reg.getPessoa().getId());
            stmt.setLong(2, reg.getAvaliacao().getId());
            stmt.setLong(3, reg.getTipoDieta().getId()); 
            stmt.setInt(4, reg.getObjetivo());
            stmt.setDouble(5, reg.getCal());
            stmt.setInt(6, reg.getNumRefeicao());           
            stmt.setDate(7, java.sql.Date.valueOf(reg.getCreateDate()));

            stmt.execute();

            System.out.println("Registro de dieta inserido com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return true;
    }

    public RegistroDieta buscaPorPessoa(Pessoa p) {
        String sql = "select * from registrodieta where Pessoa_idPessoa = ?";
        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, p.getId());
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Long id = rs.getLong("idRegistroDieta");
                    int objetivo = rs.getInt("objetivo");
                    Double cal = rs.getDouble("cal");
                    int numRefeicao = rs.getInt("numRefeicoes");
                    Long idTD = rs.getLong("TipoDieta_idTipoDieta");

                    RegistroDieta reg = new RegistroDieta();
                    reg.setId(id);
                    reg.setObjetivo(objetivo);
                    reg.setCal(cal);
                    reg.setNumRefeicao(numRefeicao);
                    reg.setPessoa(p);
                    reg.setTipoDieta(new TipoDietaDAO().buscaTDId(idTD));
                    reg.setAvaliacao(new AvaliacaoDAO().buscaAvalPessoa(p));
                    return reg;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    

    public boolean removeRD(RegistroDieta reg){
        String sql = "delete from registrodieta where id = ?";

        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setLong(1, reg.getId());
            
            stmt.execute();
            
            System.out.println("Refeicao excluída com sucesso.");
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } 
    }

}
