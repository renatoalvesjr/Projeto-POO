package itens;

public class Avaliacao {
    private int id;
    private Pessoa pessoa;
    private double peso;
    private double altura;
    private int idade;
    private double pescoco;
    private double cintura;
    private double quadril;
    private int rotina;
    private double imc;
    private double tmb;
    private double bf;
    private double massGorda;
    private double massMagra;
    private String createDate;
    private String modifyDate;

    public Avaliacao() {
    }

    
    public Avaliacao(int id, Pessoa pessoa, double peso, double altura, int idade, double pescoco, double cintura, double quadril, int rotina) {
        this.id = id;
        this.pessoa = pessoa;
        this.peso = peso;
        this.altura = altura;
        this.idade = idade;
        this.pescoco = pescoco;
        this.cintura = cintura;
        this.quadril = quadril;
        this.createDate = Datas.dataAgora();
        this.modifyDate = "";
    }
    
    public void calcIMC(){
        this.imc = this.peso/Math.pow(this.altura,2);
        this.modifyDate += Datas.dataAgora();
    }
    public void calcTMB(){
        if(this.pessoa.getSexo().equalsIgnoreCase("m")){
            this.tmb = this.rotina*(66+((13.7*this.peso)+(5*this.altura)-(6.8*this.idade)));
        }else{
            this.tmb = this.rotina*(655+((9.6*this.peso)+(1.8*this.altura)-(4.7*this.idade)));
        }
        this.modifyDate += Datas.dataAgora();
    }
    public void calcBF(){
        if(this.pessoa.getSexo().equalsIgnoreCase("m")){
            this.bf = (163.205*Math.log10(this.cintura+this.quadril-this.pescoco))-(97.684*Math.log10(this.altura))-78.387;
        }else{
            this.bf = (86.010*Math.log10(this.cintura+this.quadril-this.pescoco))-(70.041*Math.log10(this.altura))+36.76;
        }
        this.massMagra = this.peso*(1-(this.bf/100));
        this.massGorda = this.peso*(this.bf/100);
        this.modifyDate += Datas.dataAgora();
    }
    
}
