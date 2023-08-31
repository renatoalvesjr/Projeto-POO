package itens;

public class Dieta {
    int id;
    String nome;
    double carb;
    double prot;
    double gord;
    String createDate;
    String modifyDate;
    
    public Dieta(int id, String nome, double carb, double prot, double gord) {
        this.id = id;
        this.nome = nome;
        this.carb = carb;
        this.prot = prot;
        this.gord = gord;
        this.createDate = Datas.dataAgora();
        this.modifyDate = null;
    }
    
    
}
