package model;

public class Preferencia {
    private long id;
    private Pessoa pessoa;
    private Alimento alimento[] = new Alimento[10];
    private String createDate;
    private String modifyDate;
    private static long serial;

    public Preferencia() {
        this.id = ++Preferencia.serial;
        this.createDate = Utils.dataAgora();
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

    public Alimento[] getAlimento() {
        return alimento;
    }

    public boolean setAlimento(Alimento alimento) {
        for (int i = 0; i < this.alimento.length; i++) {
            if(this.alimento[i] == null){
                this.alimento[i] = alimento;
                return true;
            }
            
        }
        return false;
    }
    
    public boolean setAlimento(long id){
        for (int i = 0; i < alimento.length; i++) {
            if(alimento[i].getId() == id){
                alimento[i] = null;
                return true;
            }
        }
        return false;
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
