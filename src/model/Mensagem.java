package model;

import java.time.LocalDate;

public class Mensagem {
    private long id;
    private Pessoa pOrigem;
    private Pessoa pDestino;
    private String conteudo;
    private LocalDate createDate;
    private LocalDate modifyDate;
    
    public Mensagem() {
        this.createDate = LocalDate.now();
    }

    public void setId(long id) {
        this.id = id;
    }
    
    public long getId() {
        return id;
    }

    public Pessoa getpOrigem() {
        return pOrigem;
    }

    public void setpOrigem(Pessoa pOrigem) {
        this.pOrigem = pOrigem;
    }

    public Pessoa getpDestino() {
        return pDestino;
    }

    public void setpDestino(Pessoa pDestino) {
        this.pDestino = pDestino;
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
        hash = 97 * hash + (int) (this.id ^ (this.id >>> 32));
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
        final Mensagem other = (Mensagem) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return "\nDe: " + pOrigem.getNome() + "\nPara: " + pDestino.getNome() + "\n\"" + conteudo + "\"";
    }
    
    
}
