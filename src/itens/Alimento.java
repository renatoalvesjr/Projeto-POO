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

//Informações importantes: id, nome, carboidratos, proteínas, gorduras, calorias, porcao, tipoUsuario, dataCriacao, dataModificacao.
public class Alimento {
    int id;
    String nome;
    double carb;
    double prot;
    double gord;
    double cal;
    int porcao;
    String userType;
    LocalDateTime createDate;
    LocalDateTime modifyDate;
    
    void calcCaloria(){
        this.cal = (4*this.carb)+(4*this.prot)+(4*this.gord);
    }
}
