package itens;

public class Preferencia {
    private long id;
    private Pessoa pessoa;
    private Alimento alimento;
    private String createDate;
    private String modifyDate;
    private static long serial;

    public Preferencia() {
        this.id = ++Preferencia.serial;
        this.createDate = Datas.dataAgora();
        this.modifyDate = "";
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

    public Alimento getAlimento() {
        return alimento;
    }

    public void setAlimento(Alimento alimento) {
        this.alimento = alimento;
    }

    public String getCreateDate() {
        return createDate;
    }

    public String getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(String modifyDate) {
        this.modifyDate = modifyDate;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + (int) (this.id ^ (this.id >>> 32));
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
        final Preferencia other = (Preferencia) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return "Preferencia{" + "id=" + id + ", pessoa=" + pessoa + ", alimento=" + alimento + ", createDate=" + createDate + ", modifyDate=" + modifyDate + '}';
    }
    
    
    
}
