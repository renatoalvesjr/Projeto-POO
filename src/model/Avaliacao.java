package model;

public class Avaliacao {
    private long id;
    private Pessoa pessoa;
    private double peso;
    private double altura;
    private int idade;
    private double pescoco;
    private double cintura;
    private double quadril;
    private double rotina;
    private double imc;
    private double tmb;
    private double bf;
    private double massGorda;
    private double massMagra;
    private String createDate;
    private String modifyDate;
    private static long serial;
    
    public Avaliacao() {
        this.id = ++Avaliacao.serial;
        
        this.createDate = Utils.dataAgora();
        this.modifyDate = "";
    }
    
    public void calcIMC(){
        this.imc = this.peso/((this.altura/100)*(this.altura/100));
    }
    public void calcTMB(){
        if(this.pessoa.getSexo().equalsIgnoreCase("M")){
            this.tmb = this.rotina*(66+((13.7*this.peso)+(5*this.altura)-(6.8*this.idade)));
        }else{
            this.tmb = this.rotina*(655+((9.6*this.peso)+(1.8*this.altura)-(4.7*this.idade)));
        }
    }
    public void calcBF(){
        if(this.pessoa.getSexo().equalsIgnoreCase("M")){
            this.bf = 495 / (1.0324 - 0.19077 * Math.log10(cintura - pescoco) + 0.15456 * Math.log10(altura)) - 450;
        }else{
            this.bf = (163.205*Math.log10(this.cintura-this.pescoco))-(97.684*Math.log10(this.altura))-78.387;
            this.bf = 163.205 - (97.684 * Math.log10(cintura + quadril - pescoco)) - (78.387 * Math.log10(altura)) + (4.369 * Math.log10(peso));
        }
        this.massMagra = this.peso*(1-(this.bf/100));
        this.massGorda = this.peso*(this.bf/100);
    }

    public long getId() {
        return id;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getPescoco() {
        return pescoco;
    }

    public void setPescoco(double pescoco) {
        this.pescoco = pescoco;
    }

    public double getCintura() {
        return cintura;
    }

    public void setCintura(double cintura) {
        this.cintura = cintura;
    }

    public double getQuadril() {
        return quadril;
    }

    public void setQuadril(double quadril) {
        this.quadril = quadril;
    }

    public double getRotina() {
        return rotina;
    }

    public void setRotina(int rotina) {
        switch(rotina){
            case 1:
                this.rotina = 1.2;
                break;
            case 2:
                this.rotina = 1.375;
                break;
            case 3:
                this.rotina = 1.55;
                break;
            case 4:
                this.rotina = 1.725;
                break;
            case 5:
                this.rotina = 1.9;
                break;
            default:
                this.rotina = 1.375;
                break;
        }
        
    }
    
    public double getTMB(){
        return tmb;
    }

    public double getImc() {
        return imc;
    }

    public double getBf() {
        return bf;
    }

    public double getMassGorda() {
        return massGorda;
    }

    public double getMassMagra() {
        return massMagra;
    }

    public String getCreateDate() {
        return createDate;
    }

    public String getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate() {
        this.modifyDate = Utils.dataAgora();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + (int) (this.id ^ (this.id >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Avaliacao other = (Avaliacao) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return id + " - Nome: " + pessoa.getNome() + "\nPeso: " + peso + "\nAltura: " + altura + "\nIdade: " + idade + "\nPescoco: " + pescoco + "\nCintura: " + cintura + "\nQuadril: " + quadril + "\nRotina: " + rotina + "\nImc: " + imc + "\nTaxa metabolica basal: " + tmb + "\nIndice de gordura corporal: " + bf + "\nMassa gorda: " + massGorda + "\nMassa magra: " + massMagra;
    }
    
    
    
}
