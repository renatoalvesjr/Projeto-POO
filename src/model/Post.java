package model;

import java.time.LocalDate;

public class Post {
    private long id;
    private Pessoa pessoa;
    private String conteudo;
    private LocalDate createDate;
    private LocalDate modifyDate;
    
    public Post() {
        this.createDate = LocalDate.now();
    }

    public void setId(long id) {
        this.id = id;
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

    public LocalDate getCreateDate() {
        return createDate;
    }

    public LocalDate getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate() {
        this.modifyDate = LocalDate.now();
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
        return id +" - "+ pessoa.getNome() + ":\n" + conteudo +"\nData: "+ createDate;
    }
    
    
}
