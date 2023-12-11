package model;

import java.time.LocalDate;

public class Refeicoes {
    private long id;
    private TipoDieta td;
    private double carb;
    private double prot;
    private double gord;
    private double cal;
    private String nomeRefeicao;
    private LocalDate createDate;
    private LocalDate modifyDate;
    

    public Refeicoes(){
        createDate = LocalDate.now();
    }
    
    public long getId() {
        return id;
    }

    public double getCal() {
        return cal;
    }

    public void setCal() {
        this.cal = (4*this.carb)+(4*this.prot)+(9*this.gord);
    }

    public TipoDieta getTd() {
        return td;
    }

    public void setTd(TipoDieta td) {
        this.td = td;
    }

    public double getCarb() {
        return carb;
    }

    public void setCarb(double carb) {
        this.carb = carb;
    }

    public double getProt() {
        return prot;
    }

    public void setProt(double prot) {
        this.prot = prot;
    }

    public double getGord() {
        return gord;
    }

    public void setGord(double gord) {
        this.gord = gord;
    }

    public String getNomeRefeicao() {
        return nomeRefeicao;
    }

    public void setNomeRefeicao(String nomeRefeicao) {
        this.nomeRefeicao = nomeRefeicao;
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
        int hash = 7;
        hash = 67 * hash + (int) (this.id ^ (this.id >>> 32));
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
        final Refeicoes other = (Refeicoes) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return id + " - Nome: "+ nomeRefeicao +"\nTipo de dieta: " + td.getNome() +"\nMetas - Carboidratos: " + carb + ", Proteinas: " + prot + ", Gorduas: " + gord+ ", Calorias: "+cal;
        
    }

    void setId(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}