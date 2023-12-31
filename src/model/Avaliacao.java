package model;

import static java.lang.Math.log10;
import java.time.LocalDate;

public class Avaliacao {
    private int id;
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
    private LocalDate createDate;
    private LocalDate modifyDate;
    
    public Avaliacao() {
        this.createDate = LocalDate.now();
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
            this.bf = 86.010 * Math.log10(cintura - pescoco) - 70.041 * Math.log10(altura) + 36.76;
        }else{
            this.bf = 163.205 * Math.log10(cintura + quadril - pescoco) - 97.684 * Math.log10(altura) - 78.387;
        }
        this.massMagra = this.peso*(1-(this.bf/100));
        this.massGorda = this.peso*(this.bf/100);
    }

    public void setId(int id) {
        this.id = id;
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

    public void setRotina(double rotina) {
        switch((int)rotina){
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

    public LocalDate getCreateDate() {
        return createDate;
    }

    public LocalDate getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate() {
        this.modifyDate = LocalDate.now();
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
