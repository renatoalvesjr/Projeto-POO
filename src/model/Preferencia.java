package model;

import java.time.LocalDate;

public class Preferencia {
    private long id;
    private Pessoa pessoa;
    private Alimento alimento;
    private LocalDate createDate;
    private LocalDate modifyDate;

    public Preferencia() {
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

    public Alimento getAlimento() {
        return alimento;
    }

    public void setAlimento(Alimento alimento) {
        this.alimento = alimento;
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
        return id + " - Alimento: " + alimento.getNome();
    }
    
    
    
}
