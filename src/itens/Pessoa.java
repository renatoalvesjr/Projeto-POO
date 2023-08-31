/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itens;

import java.time.LocalDateTime;

/**
 *
 * @author grang
 */
public class Pessoa {
    int id;
    String nome;
    char sexo;
    String nascimento;
    String login;
    String senha;
    String userType;
    LocalDateTime createDate;
    LocalDateTime modifyDate;

    public Pessoa(int id, String nome, char sexo, String nascimento, String login, String senha, String userType, LocalDateTime createDate, LocalDateTime modifyDate) {
        this.id = id;
        this.nome = nome;
        this.sexo = sexo;
        this.nascimento = nascimento;
        this.login = login;
        this.senha = senha;
        this.userType = userType;
        this.createDate = LocalDateTime.now();
        this.modifyDate = null;
    }
    
}
