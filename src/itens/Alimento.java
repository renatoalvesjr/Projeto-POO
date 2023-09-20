package itens;

public class Alimento {
    private int id;
    private String nome;
    private double carb;
    private double prot;
    private double gord;
    private double cal;
    private double porcao;
    private String userType;
    private String createDate;
    private String modifyDate;

    public Alimento() {
    }

    
    public Alimento(int id, String nome, double carb, double prot, double gord, double cal, double porcao, String userType) {
        this.id = id;
        this.nome = nome;
        this.carb = carb;
        this.prot = prot;
        this.gord = gord;
        this.cal = cal;
        this.porcao = porcao;
        this.userType = userType;
        this.createDate = Datas.dataAgora();
        this.modifyDate = "";
    }
    void calcCaloria(){
        this.cal = (4*this.carb)+(4*this.prot)+(9*this.gord);
        this.modifyDate += Datas.dataAgora();
    }
}
