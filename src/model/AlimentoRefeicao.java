package model;

import java.time.LocalDate;
import java.util.Objects;

public class AlimentoRefeicao {

    private Pessoa pessoa;
    private Refeicoes refeicao;
    private Alimento alimento;
    private TipoDieta tipodieta;
    private double porcao;
    private LocalDate createDate;
    private LocalDate modifyDate;

    public AlimentoRefeicao() {
        createDate = LocalDate.now();
    }
    
    
    
    public Pessoa getPessoa() {
        return pessoa;
    }

    public TipoDieta getTipodieta() {
        return tipodieta;
    }

    public void setTipodieta(TipoDieta tipodieta) {
        this.tipodieta = tipodieta;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
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
        hash = 71 * hash + Objects.hashCode(this.pessoa);
        hash = 71 * hash + Objects.hashCode(this.refeicao);
        hash = 71 * hash + Objects.hashCode(this.alimento);
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
        if (!Objects.equals(this.pessoa, other.pessoa)) {
            return false;
        }
        if (!Objects.equals(this.refeicao, other.refeicao)) {
            return false;
        }
        return Objects.equals(this.alimento, other.alimento);
    }

    

    @Override
    public String toString() {
        return "Refeicao: " + refeicao + ", Alimento: " + alimento + ", Porcao: " + porcao;
    }

}
