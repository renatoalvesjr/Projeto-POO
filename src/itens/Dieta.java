package itens;

import java.time.LocalDateTime;

public class Dieta {
    int id;
    String nome;
    double carb;
    double prot;
    double gord;
    LocalDateTime createDate;
    LocalDateTime modifyDate;

    public Dieta(int id, String nome, double carb, double prot, double gord, LocalDateTime createDate, LocalDateTime modifyDate) {
        this.id = id;
        this.nome = nome;
        this.carb = carb;
        this.prot = prot;
        this.gord = gord;
        this.createDate = LocalDateTime.now();
        this.modifyDate = null;
    }
    
    
}
