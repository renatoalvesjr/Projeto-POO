package model;

import java.time.LocalDate;

public class Alimento {
    private long id;
    private String nome;
    private double carb;
    private double prot;
    private double gord;
    private double cal;
    private double porcaoGramas;
    private String userType;
    private LocalDate createDate;
    private LocalDate modifyDate;
    private static long serial;

    public Alimento() {
     createDate = LocalDate.now();
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public double getCal() {
        return cal;
    }

    public void setCal() {
        this.cal = (4*this.carb)+(4*this.prot)+(9*this.gord);
    }

    public double getPorcao() {
        return porcaoGramas;
    }

    public void setPorcao(double porcao) {
        this.porcaoGramas = porcao;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
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
        hash = 43 * hash + (int) (this.id ^ (this.id >>> 32));
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
        final Alimento other = (Alimento) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return (id+": "+nome + "\n|| Carboidratos: " + carb + " || Proteinas: " + prot + " || Gorduras: " + gord + " || Calorias: " + cal+ " ||" + " Porcao: " + porcaoGramas + "g ||");
    }

    void setId(Long id) {
        this.id = id;
    }
    
    
}
