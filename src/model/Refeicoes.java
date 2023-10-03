package model;

public class Refeicoes {
    private long id;
    private TipoDieta td;
    private double carb;
    private double prot;
    private double gord;
    private String nomeRefeicao;
    private String createDate;
    private String modifyDate;
    private static long serial;
    
    public Refeicoes(){
        this.id = ++Refeicoes.serial;
        this.createDate = Datas.dataAgora();
        this.modifyDate = "";
    }

    public long getId() {
        return id;
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
        return "Refeicoes{" + "id=" + id + ", td=" + td + ", carb=" + carb + ", prot=" + prot + ", gord=" + gord + ", nomeRefeicao=" + nomeRefeicao + ", createDate=" + createDate + ", modifyDate=" + modifyDate + '}';
    }
    
    
}