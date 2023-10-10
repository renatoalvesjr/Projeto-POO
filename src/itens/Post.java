package itens;

public class Post {
    private long id;
    private Pessoa pessoa;
    private String conteudo;
    private String createDate;
    private String modifyDate;
    private static long serial;
    
    public Post() {
        this.id = ++Post.serial;
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

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
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
        int hash = 7;
        hash = 41 * hash + (int) (this.id ^ (this.id >>> 32));
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
        final Post other = (Post) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return "Post{" + "id=" + id + ", pessoa=" + pessoa + ", conteudo=" + conteudo + ", createDate=" + createDate + ", modifyDate=" + modifyDate + '}';
    }
    
    
}