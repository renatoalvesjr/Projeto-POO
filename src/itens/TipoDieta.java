/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itens;

/**
 *
 * @author grang
 */
public class TipoDieta extends Dieta{
    int id;
    String nome;
    String createDate;
    String modifyDate;

    public TipoDieta(int id, String nome) {
        this.id = id;
        
        this.createDate = Datas.dataAgora();
        this.modifyDate = "";
        if(id==0){
            this.nome = nome;
        }else if(id==1){
            this.nome = nome;
        }else if(id==2){
            this.nome = nome;
        }else if(id==3){
            this.nome = nome;
        }else{
        
        }
}
