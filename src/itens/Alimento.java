package itens;

import java.time.LocalDateTime;

public class Alimento {
    int id;
    String nome;
    double carb;
    double prot;
    double gord;
    double cal;
    double porcao;
    String userType;
    LocalDateTime createDate;
    LocalDateTime modifyDate;

    public Alimento(int id, String nome, double carb, double prot, double gord, double cal, double porcao, String userType) {
        this.id = id;
        this.nome = nome;
        this.carb = carb;
        this.prot = prot;
        this.gord = gord;
        this.cal = cal;
        this.porcao = porcao;
        this.userType = userType;
        this.createDate = LocalDateTime.now();
        this.modifyDate = null;
    }
    void calcCaloria(){
        this.cal = (4*this.carb)+(4*this.prot)+(4*this.gord);
        this.modifyDate = LocalDateTime.now();
    }
}
