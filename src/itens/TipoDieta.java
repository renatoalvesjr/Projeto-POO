package itens;

public class TipoDieta{
    private long id;
    private String nome;
    private double carb;
    private double prot;
    private double gord;
    private String createDate;
    private String modifyDate;
    private static long serial;

    public TipoDieta() {
        this.id = ++TipoDieta.serial;
        
        this.createDate = Datas.dataAgora();
        this.modifyDate = "";
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

    public String getCreateDate() {
        return createDate;
    }

    public String getModifyDate() {
        return modifyDate;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + (int) (this.id ^ (this.id >>> 32));
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
        final TipoDieta other = (TipoDieta) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return "TipoDieta{" + "id=" + id + ", nome=" + nome + ", carb=" + carb + ", prot=" + prot + ", gord=" + gord + ", createDate=" + createDate + ", modifyDate=" + modifyDate + '}';
    }
    
    
}
