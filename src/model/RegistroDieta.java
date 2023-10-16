package model;

public class RegistroDieta {
    private long id;
    private Pessoa p;
    private Avaliacao av;
    private TipoDieta td;
    private int objetivo;
    private double cal;
    private int numRefeicao;
    private String createDate;
    private String modifyDate;
    private static long serial;
    
    public RegistroDieta() {
        this.id = ++RegistroDieta.serial;
        this.createDate = Utils.dataAgora();
        this.modifyDate = "";
    }

    public long getId() {
        return id;
    }

    public Pessoa getPessoa() {
        return p;
    }

    public void setPessoa(Pessoa p) {
        this.p = p;
    }

    public Avaliacao getAvaliacao() {
        return av;
    }

    public void setAvaliacao(Avaliacao av) {
        this.av = av;
    }

    public TipoDieta getTipoDieta() {
        return td;
    }

    public void setTipoDieta(TipoDieta td) {
        this.td = td;
    }

    public int getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(int objetivo) {
        this.objetivo = objetivo;
        switch(objetivo){
            case 1:
                setCal(((int) av.getTMB())-300);
                break;
            case 2:
                setCal((int) av.getTMB());
                break;
            case 3:
                setCal(((int) av.getTMB())+300);
                break;
        }
    }

    public double getCal() {
        return cal;
    }

    private void setCal(double cal) {
        this.cal = cal;
    }

    public int getNumRefeicao() {
        return numRefeicao;
    }

    public void setNumRefeicao(int numRefeicao) {
        this.numRefeicao = numRefeicao;
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
        hash = 29 * hash + (int) (this.id ^ (this.id >>> 32));
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
        final RegistroDieta other = (RegistroDieta) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        String objetivo = "";
        if(this.objetivo == 1){
                objetivo = "Perder peso";
        } else if(this.objetivo == 2){
                objetivo = "Manter peso";
        }
            else if(this.objetivo == 2){
                objetivo = "Ganhar peso";
        }          
        return id + " : " + "\nDieta de: " + p.getNome() + "\nTipo de dieta: " + td + "\nObjetivo da dieta: " + objetivo + "\nQuantidade de calorias: " + cal + "\nNumero de refeicoes: " + numRefeicao;
    }
    
    
}
