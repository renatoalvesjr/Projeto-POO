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
import java.time.LocalDate;

/**
 *
 * @author Alunos
 */
public class AvaliacaoDAO {

    Avaliacao[] avals = new Avaliacao[10];

    public AvaliacaoDAO(PessoaDAO pdao) {
        Avaliacao av1 = new Avaliacao();
        av1.setPessoa(pdao.buscaPorNome("Renato"));
        av1.setAltura(190);
        av1.setIdade(23);
        av1.setPeso(75);
        av1.setRotina(2);
        av1.setQuadril(100);
        av1.setCintura(80);
        av1.setPescoco(38);
        av1.calcBF();
        av1.calcIMC();
        av1.calcTMB();
        criaAval(av1);
    }

    private int proximAvalLivre() {
        for (int i = 0; i < avals.length; i++) {
            if (avals[i] == null) {
                return i;
            }
        }
        return -1;
    }

    public boolean criaAval(Avaliacao aval) {
        String sql = "insert into avaliacao "
                + "(peso,altura,idade,pescoco,cintura,quadril,rotina,imc,tbm,bf,massGorda,massMagra,createDate,Pessoa_idPessoa)" + " values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement stmt = connection.prepareStatement(sql)) {
            // seta os valores
            stmt.setDouble(1, aval.getPeso());
            stmt.setDouble(2, aval.getAltura());
            stmt.setInt(3, aval.getIdade());
            stmt.setDouble(4, aval.getPescoco());
            stmt.setDouble(5, aval.getCintura());
            stmt.setDouble(6, aval.getQuadril());
            stmt.setDouble(7, aval.getRotina());
            stmt.setDouble(8, aval.getImc());
            stmt.setDouble(9, aval.getTMB());
            stmt.setDouble(10, aval.getBf());
            stmt.setDouble(11, aval.getMassGorda());
            stmt.setDouble(12, aval.getMassMagra());
            stmt.setDate(13, java.sql.Date.valueOf(aval.getCreateDate()));
            stmt.setLong(14, aval.getPessoa().getId());

            stmt.execute();

            System.out.println("Avaliacao inserida com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return true;
    }

    public Avaliacao buscaAvalPessoa(Pessoa p) {
        String sql = "select * from avaliacao where Pessoa_idPessoa = ?";
        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, p.getId());
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Long id = rs.getLong("idAvaliacao");
                    Double peso = rs.getDouble("peso");
                    Double altura = rs.getDouble("altura");
                    int idade = rs.getInt("idade");
                    Double pescoco = rs.getDouble("pescoco");
                    Double cintura = rs.getDouble("cintura");
                    Double quadril = rs.getDouble("quadril");
                    Double rotina = rs.getDouble("rotina");
                    Double imc = rs.getDouble("imc");
                    Double tbm = rs.getDouble("tbm");
                    Double bf = rs.getDouble("bf");
                    Double massGorda = rs.getDouble("massGorda");
                    Double massMagra = rs.getDouble("massMagra");

                    Avaliacao avaliacao = new Avaliacao();
                    avaliacao.setPessoa(p);
                    avaliacao.setPeso(peso);
                    avaliacao.setAltura(altura);
                    avaliacao.setIdade(idade);
                    avaliacao.setPescoco(pescoco);
                    avaliacao.setCintura(cintura);
                    avaliacao.setQuadril(quadril);
                    avaliacao.setRotina(rotina);
                    avaliacao.calcIMC();
                    avaliacao.calcTMB();
                    avaliacao.calcBF();
                    
                    return avaliacao;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public boolean removeAvals(long id) {
        for (int i = 0; i < avals.length; i++) {
            if (avals[i].getId() == id) {
                avals[i] = null;
                return true;
            }
        }
        return false;
    }

    public void alteraMedidas(Avaliacao aval) {
        String sql = "update avaliacao set idade = ?, altura = ?, cintura = ?, quadril = ?, pescoco = ?, peso = ?, rotina = ?,imc = ?,tbm = ?,bf = ?,massGorda = ?, massMagra = ? where Pessoa_idPessoa = ?";
        try (Connection connection = new ConnectionFactory().getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, aval.getIdade());
            stmt.setDouble(2, aval.getAltura());
            stmt.setDouble(3, aval.getCintura());
            stmt.setDouble(4, aval.getQuadril());
            stmt.setDouble(5, aval.getPescoco());
            stmt.setDouble(6, aval.getPeso());
            stmt.setDouble(7, aval.getRotina());
            stmt.setDouble(8, aval.getImc());
            stmt.setDouble(9, aval.getTMB());
            stmt.setDouble(10, aval.getBf());
            stmt.setDouble(11, aval.getMassGorda());
            stmt.setDouble(12, aval.getMassMagra());
            stmt.setLong(13, aval.getPessoa().getId());

            stmt.execute();
            
            System.out.println("Pessoa alterado com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
