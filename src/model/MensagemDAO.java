package model;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class MensagemDAO {

    public MensagemDAO() {
//        Mensagem m1 = new Mensagem();
//        m1.setConteudo("E ai, bahum?");
//        m1.setpOrigem(p1.buscaPorNome("renato"));
//        m1.setpDestino(p1.buscaPorNome("hebert"));
//        criaMensagem(m1);
//        
//        Mensagem m2 = new Mensagem();
//        m2.setConteudo("Bahum de mais.");
//        m2.setpOrigem(p1.buscaPorNome("hebert"));
//        m2.setpDestino(p1.buscaPorNome("renato"));
//        criaMensagem(m2);
    }


    public boolean criaMensagem(Mensagem mensagem) {
        String sql = "insert into mensagem "
                + "(conteudo,Pessoa_idPessoaRemetente,Pessoa_idPessoaDestinatario,createDate)" + " values (?,?,?,?)";

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement stmt = connection.prepareStatement(sql)) {
            // seta os valores
            stmt.setString(1, mensagem.getConteudo());
            stmt.setLong(2, mensagem.getpOrigem().getId());
            stmt.setLong(3, mensagem.getpDestino().getId());
            stmt.setDate(4, java.sql.Date.valueOf(mensagem.getCreateDate()));

            stmt.execute();

            System.out.println("Mensagem inserida com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return true;
    }
    
    public List<Mensagem> mostraMensagemEnviada(Pessoa p){
        String sql = "select * from mensagem where Pessoa_idPessoaRemetente = ?";
        List<Mensagem> mensagens = new ArrayList<>();
        try(Connection connection = new ConnectionFactory().getConnection(); PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setLong(1, p.getId());
            try (ResultSet rs = ps.executeQuery()){
                while(rs.next()){
                    long id = rs.getLong("idMensagem");
                    String conteudo = rs.getString("conteudo");
                    long idD = rs.getLong("Pessoa_idPessoaDestinatario");
                    
                    Mensagem mensagem = new Mensagem();
                    mensagem.setId(id);
                    mensagem.setConteudo(conteudo);
                    mensagem.setpDestino(new PessoaDAO().buscaPorId(idD));
                    mensagem.setpOrigem(p);
                    mensagens.add(mensagem);
                }
                return mensagens;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<Mensagem> mostraMensagemRecebida(Pessoa p){
        String sql = "select * from mensagem where Pessoa_idPessoaDestinatario = ?";
        List<Mensagem> mensagens = new ArrayList<>();
        try(Connection connection = new ConnectionFactory().getConnection(); PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setLong(1, p.getId());
            try (ResultSet rs = ps.executeQuery()){
                while(rs.next()){
                    long id = rs.getLong("idMensagem");
                    String conteudo = rs.getString("conteudo");
                    long idD = rs.getLong("Pessoa_idPessoaRemetente");
                    
                    Mensagem mensagem = new Mensagem();
                    mensagem.setId(id);
                    mensagem.setConteudo(conteudo);
                    mensagem.setpDestino(p);
                    mensagem.setpOrigem(new PessoaDAO().buscaPorId(idD));
                    mensagens.add(mensagem);
                }
                return mensagens;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean removeMensagens(long id) {
        String sql = "delete from mensagem where idMensagem = ?";

        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setLong(1, id);
            
            stmt.execute();
            
            System.out.println("Mensagem excluida com sucesso.");
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
