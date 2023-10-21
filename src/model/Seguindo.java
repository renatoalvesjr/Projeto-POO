package model;

public class Seguindo {

    private long id;
    private Pessoa pessoa;
    private Pessoa seguidor;
    private String createDate;
    private String modifyDate;
    private static long serial;

    public Seguindo() {
        this.id = ++Seguindo.serial;
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

    public Pessoa getSeguidores() {
        return seguidor;
    }

    public void setSeguidores(Pessoa seguidor) {
        this.seguidor = seguidor;
    }

    public String getCreateDate() {
        return createDate;
    }

    public String getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(String modifyDate) {
        this.modifyDate = Utils.dataAgora();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + (int) (this.id ^ (this.id >>> 32));
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
        final Seguindo other = (Seguindo) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return "Seguindo{" + "id=" + id + ", pessoa=" + pessoa + ", seguidores=" + seguidor + ", createDate=" + createDate + ", modifyDate=" + modifyDate + '}';
    }

}
