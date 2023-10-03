package model;

public class AlimentoRefeicao {
    private long id;
    private Refeicoes rf;
    private Alimento al;
    private int porcao;
    private double prot;
    private double gord;
    private double carb;
    private double cal;
    private String createDate;
    private String modifyDate;
    private static long serial;
    
    public AlimentoRefeicao(){
        this.id = ++AlimentoRefeicao.serial;
        this.createDate = Datas.dataAgora();
        this.modifyDate = "";
    }

    public long getId() {
        return id;
    }

    public Refeicoes getRf() {
        return rf;
    }

    public void setRf(Refeicoes rf) {
        this.rf = rf;
    }

    public Alimento getAl() {
        return al;
    }

    public void setAl(Alimento al) {
        this.al = al;
    }

    public int getPorcao() {
        return porcao;
    }

    public void setPorcao(int porcao) {
        this.porcao = porcao;
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

    public double getCarb() {
        return carb;
    }

    public void setCarb(double carb) {
        this.carb = carb;
    }

    public double getCal() {
        return cal;
    }

    public void setCal(double cal) {
        this.cal = cal;
    }

    public String getCreateDate() {
        return createDate;
    }
    
    public String getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate() {
        this.modifyDate = Datas.dataAgora();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + (int) (this.id ^ (this.id >>> 32));
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
        final AlimentoRefeicao other = (AlimentoRefeicao) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return "AlimentoRefeicao{" + "id=" + id + ", rf=" + rf + ", al=" + al + ", porcao=" + porcao + ", prot=" + prot + ", gord=" + gord + ", carb=" + carb + ", cal=" + cal + ", createDate=" + createDate + ", modifyDate=" + modifyDate + '}';
    }
    
    
}
