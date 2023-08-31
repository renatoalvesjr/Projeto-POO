package itens;

import java.time.LocalDateTime;

public class Avaliacao {
    int id;
    Pessoa pessoa;
    double peso;
    double altura;
    int idade;
    double pescoco;
    double cintura;
    double quadril;
    int rotina;
    double imc;
    double tmb;
    double bf;
    double massGorda;
    double massMagra;
    LocalDateTime createDate;
    LocalDateTime modifyDate;

    public Avaliacao(int id, Pessoa pessoa, double peso, double altura, int idade, double pescoco, double cintura, double quadril, int rotina) {
        this.id = id;
        this.pessoa = pessoa;
        this.peso = peso;
        this.altura = altura;
        this.idade = idade;
        this.pescoco = pescoco;
        this.cintura = cintura;
        this.quadril = quadril;
        this.rotina = rotina;
        this.createDate = LocalDateTime.now();
        this.modifyDate = null;
    }
    
    void calcIMC(){
        this.imc = this.peso/Math.pow(this.altura,2);
        this.modifyDate = LocalDateTime.now();
    }
    void calcTMB(){
        if(this.pessoa.sexo == 'M'){
            this.tmb = this.rotina*(66+((13.7*this.peso)+(5*this.altura)-(6.8*this.idade)));
        }else{
            this.tmb = this.rotina*(655+((9.6*this.peso)+(1.8*this.altura)-(4.7*this.idade)));
        }
        this.modifyDate = LocalDateTime.now();
    }
    void calcBF(){
        if(this.pessoa.sexo == 'M'){
            this.bf = (163.205*Math.log10(this.cintura+this.quadril-this.pescoco))-(97.684*Math.log10(this.altura))-78.387;
        }else{
            this.bf = (86.010*Math.log10(this.cintura+this.quadril-this.pescoco))-(70.041*Math.log10(this.altura))+36.76;
        }
        this.massMagra = this.peso*(1-(this.bf/100));
        this.massGorda = this.peso*(this.bf/100);
        this.modifyDate = LocalDateTime.now();
    }
    
}
