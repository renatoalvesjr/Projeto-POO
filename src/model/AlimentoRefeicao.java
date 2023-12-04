package model;

public class AlimentoRefeicao {

    private long id;
    private Pessoa pessoa;
    private Refeicoes refeicao;
    private Alimento alimento;
    private double porcao;
    private String createDate;
    private String modifyDate;
    private static long serial;

    public AlimentoRefeicao() {
        this.id = ++AlimentoRefeicao.serial;
        this.createDate = Utils.dataAgora();
        this.modifyDate = "";
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
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

    public Alimento getAlimento() {
        return alimento;
    }

    public void setAlimento(Alimento al) {
        this.alimento = al;
    }

    public double getPorcao() {
        return porcao;
    }

    public void setPorcao(double porcao) {
        this.porcao = alimento.getPorcao()*porcao;
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
        return "AlimentoRefeicao{" + "id=" + id + ", rf=" + refeicao + ", al=" + alimento + ", porcao=" + porcao + ", createDate=" + createDate + ", modifyDate=" + modifyDate + '}';
    }

}
