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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author heber
 */
public class PessoaDAO {
    //List<Pessoa> pessoas = new ArrayList<>();

    public PessoaDAO() {
//        Pessoa p1 = new Pessoa();
//        p1.setNome("Hebert");
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//        LocalDate date = LocalDate.parse("29-03-2019", formatter);
//        p1.setNascimento(date);
//        p1.setUserType(0);
//        p1.setSexo("M");
//        p1.setLogin("hebert");
//        p1.setSenha("hebert");
//        this.adiciona(p1);
//        System.out.println(this.lista());
//        
//        if(this.logarPessoa("renato", "rento") != null){
//            System.out.println("logado com sucesso");
//        }else{
//            System.out.println("usuario nao encontrado");
//        }

    }

    public static void main(String[] args) {
        new PessoaDAO();
    }
    
    public Pessoa logarPessoa(String login, String senha){
        String sql = "select * from pessoa where login = ? and senha = ?";
        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, login);
            ps.setString(2, senha);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Long ids = rs.getLong("idPessoa");
                    String nome = rs.getString("nome");
                    String sexo = rs.getString("sexo");
                    LocalDate nascimento = rs.getDate("nascimento").toLocalDate();
                    String login1 = rs.getString("login");
                    String senha1 = rs.getString("senha");

                    Pessoa pessoa = new Pessoa();
                    pessoa.setId(ids);
                    pessoa.setNome(nome);
                    pessoa.setSexo(sexo);
                    pessoa.setNascimento(nascimento);
                    pessoa.setLogin(login1);
                    pessoa.setSenha(senha1);
                    return pessoa;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    
    public boolean adiciona(Pessoa pessoa) {
        String sql = "insert into pessoa "
                + "(nome,sexo,nascimento,login,senha,usertype,createDate)" + " values (?,?,?,?,?,?,?)";

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement stmt = connection.prepareStatement(sql)) {
            // seta os valores
            stmt.setString(1, pessoa.getNome());
            stmt.setString(2, pessoa.getSexo());
            stmt.setDate(3, java.sql.Date.valueOf(pessoa.getNascimento()));
            stmt.setString(4, pessoa.getLogin());
            stmt.setString(5, pessoa.getSenha());
            stmt.setInt(6, pessoa.getUserType());
            stmt.setDate(7, java.sql.Date.valueOf(pessoa.getCreateDate()));

            stmt.execute();

            System.out.println("Pessoa inserida com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return true;
    }

    public List<Pessoa> lista() {
        String sql = "select * from pessoa";

        List<Pessoa> pessoas = new ArrayList<>();

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement stmt = connection.prepareStatement(sql); ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Long id = rs.getLong("idPessoa");
                String nome = rs.getString("nome");
                String sexo = rs.getString("sexo");
                LocalDate nascimento = rs.getDate("nascimento").toLocalDate();
                String login = rs.getString("login");
                String senha = rs.getString("senha");

                Pessoa pessoa = new Pessoa();
                pessoa.setId(id);
                pessoa.setNome(nome);
                pessoa.setSexo(sexo);
                pessoa.setNascimento(nascimento);
                pessoa.setLogin(login);
                pessoa.setSenha(senha);
                pessoas.add(pessoa);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        // itera no ResultSet
        return pessoas;
    }

    public Pessoa buscaPorId(long id) {
        String sql = "select * from pessoa where idPessoa = ?";
        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Long ids = rs.getLong("idPessoa");
                    String nome = rs.getString("nome");
                    String sexo = rs.getString("sexo");
                    LocalDate nascimento = rs.getDate("nascimento").toLocalDate();
                    String login = rs.getString("login");
                    String senha = rs.getString("senha");

                    Pessoa pessoa = new Pessoa();
                    pessoa.setId(ids);
                    pessoa.setNome(nome);
                    pessoa.setSexo(sexo);
                    pessoa.setNascimento(nascimento);
                    pessoa.setLogin(login);
                    pessoa.setSenha(senha);
                    return pessoa;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    
    public void altera(Pessoa pessoa) {
        String sql = "update pessoa set nome = ?, sexo = ?, senha = ? where idPessoa = ?";

        try (Connection connection = new ConnectionFactory().getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, pessoa.getNome());
            stmt.setString(2, pessoa.getSexo());
            stmt.setString(3, pessoa.getSenha());
            stmt.setLong(4, pessoa.getId());

            stmt.execute();
            
            System.out.println("Pessoa alterado com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void remover(Pessoa pessoa){
        String sql = "delete from contatos where idPessoa = ?";

        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setLong(1, pessoa.getId());
            
            stmt.execute();
            
            System.out.println("Pessoa excluído com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Pessoa buscaPorNome(String nome) {
        String sql = "select * from pessoa where nome = ?";
        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, nome);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Long ids = rs.getLong("idPessoa");
                    String nome1 = rs.getString("nome");
                    String sexo = rs.getString("sexo");
                    LocalDate nascimento = rs.getDate("nascimento").toLocalDate();
                    String login = rs.getString("login");
                    String senha = rs.getString("senha");

                    Pessoa pessoa = new Pessoa();
                    pessoa.setId(ids);
                    pessoa.setNome(nome1);
                    pessoa.setSexo(sexo);
                    pessoa.setNascimento(nascimento);
                    pessoa.setLogin(login);
                    pessoa.setSenha(senha);
                    return pessoa;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
