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

//Informações importantes: id, nome, carboidrato,  proteína, gordura, 
//dataCriacao, dataModificacao.

public class Dieta {
    int id;
    String nome;
    double carb;
    double prot;
    double gord;
    LocalDateTime createDate;
    LocalDateTime modifyDate;
}
