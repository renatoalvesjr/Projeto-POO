/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itens;

/**
 *
 * @author grang
 */
public class TipoDieta{
    private int id;
    private String nome;
    private double carb;
    private double prot;
    private double gord;
    private String createDate;
    private String modifyDate;

    public TipoDieta(int id) {
        this.id = id;
        
        this.createDate = Datas.dataAgora();
        this.modifyDate = "";
        
    }
}
