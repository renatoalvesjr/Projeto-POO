package model;

public class AlimentoRefeicao {

    private long id;
    private Refeicoes refeicao;
    private Alimento[] alimento = new Alimento[20];
    private int porcao;
    private double prot;
    private double gord;
    private double carb;
    private double cal;
    private String createDate;
    private String modifyDate;
    private static long serial;

    public AlimentoRefeicao() {
        this.id = ++AlimentoRefeicao.serial;
        this.createDate = Utils.dataAgora();
        this.modifyDate = "";
    }
    
    private void calcPorcao(){
        for (int i = 0; i < alimento.length; i++) {
            if(!alimentoVazio()){
                if(alimento[i] != null){
                    this.porcao += alimento[i].getPorcao();
                }
            }    
        }
    }
    
    private void calcProt(){
        for (int i = 0; i < alimento.length; i++) {
            if(!alimentoVazio()){
                if(alimento[i] != null){
                    this.prot += alimento[i].getProt();
                }
            }    
        }
    }
    
    private void calcCarb(){
        for (int i = 0; i < alimento.length; i++) {
            if(!alimentoVazio()){
                if(alimento[i] != null){
                    this.carb += alimento[i].getCarb();
                }
            }    
        }
    }
    
    private void calcGord(){
        for (int i = 0; i < alimento.length; i++) {
            if(!alimentoVazio()){
                if(alimento[i] != null){
                    this.gord += alimento[i].getGord();
                }
            }    
        }
    }
    
    private void calcCal(){
        for (int i = 0; i < alimento.length; i++) {
            if(!alimentoVazio()){
                if(alimento[i] != null){
                    this.cal += alimento[i].getCal();
                }
            }    
        }
    }
    
    public void setNutrientes(){
        calcCarb();
        calcGord();
        calcProt();
        calcCal();
    }
    
    public long getId() {
        return id;
    }

    public Refeicoes getRefeicao() {
        return refeicao;
    }

    public void setRefeicao(Refeicoes refeicao) {
        this.refeicao = refeicao;
    }

    public Alimento[] getAlimento() {
        return alimento;
    }

    public void setAl(Alimento al) {
        if (!alimentoCheio()) {
            for (int i = 0; i < this.alimento.length; i++) {
                if (alimento[i] == null) {
                    alimento[i] = al;
                }
            }
        }
    }
    
    
    
    public boolean alimentoVazio() {
        for (int i = 0; i < alimento.length; i++) {
            if (alimento[i] != null) {
                return false;
            }
        }
        return true;
    }

    public boolean alimentoCheio() {
        for (int i = 0; i < alimento.length; i++) {
            if (alimento[i] == null) {
                return false;
            }
        }
        return true;
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
        this.modifyDate = Utils.dataAgora();
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
        return "AlimentoRefeicao{" + "id=" + id + ", rf=" + refeicao + ", al=" + alimento + ", porcao=" + porcao + ", prot=" + prot + ", gord=" + gord + ", carb=" + carb + ", cal=" + cal + ", createDate=" + createDate + ", modifyDate=" + modifyDate + '}';
    }

}
