package itens;

public class Alimento {
    private long id;
    private String nome;
    private double carb;
    private double prot;
    private double gord;
    private double cal;
    private double porcaoGramas;
    private String userType;
    private String createDate;
    private String modifyDate;
    private static long serial;

    public Alimento() {
        this.id = ++Alimento.serial;
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

    public double getCal() {
        return cal;
    }

    public void setCal() {
        this.cal = calcCaloria();
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

    public String getCreateDate() {
        return createDate;
    }

    public String getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate() {
        this.modifyDate = Datas.dataAgora();
    }

    private double calcCaloria(){
        setModifyDate();
        return (4*this.carb)+(4*this.prot)+(9*this.gord);
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
        return "Alimento{" + "id=" + id + ", nome=" + nome + ", carb=" + carb + ", prot=" + prot + ", gord=" + gord + ", cal=" + cal + ", porcao=" + porcaoGramas + ", userType=" + userType + ", createDate=" + createDate + ", modifyDate=" + modifyDate + '}';
    }
    
    
}