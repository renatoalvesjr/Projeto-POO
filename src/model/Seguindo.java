package model;

import java.util.Objects;

public class Seguindo {

    private Pessoa pessoa;
    private Pessoa seguidor;

    public Seguindo() {
            
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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.pessoa);
        hash = 97 * hash + Objects.hashCode(this.seguidor);
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
        if (!Objects.equals(this.pessoa, other.pessoa)) {
            return false;
        }
        return Objects.equals(this.seguidor, other.seguidor);
    }



    @Override
    public String toString() {
        return "Seguindo{ " + ", pessoa=" + pessoa + ", seguidores=" + seguidor + " }";
    }

}
