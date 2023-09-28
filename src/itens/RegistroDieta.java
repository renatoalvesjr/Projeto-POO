package itens;

public class RegistroDieta {
    private int id;
    private Pessoa p;
    private Avaliacao av;
    private TipoDieta td;
    private int objetivo;
    private double cal;
    private int numRefeicao;
    private String createDate;
    private String modifyDate;
    
    public RegistroDieta(){
        
    }
    
    public RegistroDieta(int id, Pessoa p, Avaliacao av, TipoDieta td, int objetivo, double cal, int numRefeicao, String createDate, String modifyDate) {
        this.id = id;
        this.p = p;
        this.av = av;
        this.td = td;
        this.objetivo = objetivo;
        this.cal = cal;
        this.numRefeicao = numRefeicao;
        this.createDate = Datas.dataAgora();
        this.modifyDate = Datas.dataAgora();
    }
    
}
