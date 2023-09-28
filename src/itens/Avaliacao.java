package itens;

public class Avaliacao {
    private long id;
    private Pessoa pessoa;
    private double peso;
    private double altura;
    private int idade;
    private double pescoco;
    private double cintura;
    private double quadril;
    private int rotina;
    private double imc;
    private double tmb;
    private double bf;
    private double massGorda;
    private double massMagra;
    private String createDate;
    private String modifyDate;
    private static long serial;
    
    public Avaliacao() {
        this.id = ++serial;
        this.createDate = Datas.dataAgora();
        this.modifyDate = "";
    }
    
    public void calcIMC(){
        this.imc = this.peso/Math.pow(this.altura,2);
        this.modifyDate += Datas.dataAgora();
    }
    public void calcTMB(){
        if(this.pessoa.getSexo().equalsIgnoreCase("m")){
            this.tmb = this.rotina*(66+((13.7*this.peso)+(5*this.altura)-(6.8*this.idade)));
        }else{
            this.tmb = this.rotina*(655+((9.6*this.peso)+(1.8*this.altura)-(4.7*this.idade)));
        }
        this.modifyDate += Datas.dataAgora();
    }
    public void calcBF(){
        if(this.pessoa.getSexo().equalsIgnoreCase("m")){
            this.bf = (163.205*Math.log10(this.cintura+this.quadril-this.pescoco))-(97.684*Math.log10(this.altura))-78.387;
        }else{
            this.bf = (86.010*Math.log10(this.cintura+this.quadril-this.pescoco))-(70.041*Math.log10(this.altura))+36.76;
        }
        this.massMagra = this.peso*(1-(this.bf/100));
        this.massGorda = this.peso*(this.bf/100);
        this.modifyDate += Datas.dataAgora();
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

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getPescoco() {
        return pescoco;
    }

    public void setPescoco(double pescoco) {
        this.pescoco = pescoco;
    }

    public double getCintura() {
        return cintura;
    }

    public void setCintura(double cintura) {
        this.cintura = cintura;
    }

    public double getQuadril() {
        return quadril;
    }

    public void setQuadril(double quadril) {
        this.quadril = quadril;
    }

    public int getRotina() {
        return rotina;
    }

    public void setRotina(int rotina) {
        this.rotina = rotina;
    }

    public double getImc() {
        return imc;
    }

    public double getBf() {
        return bf;
    }

    public double getMassGorda() {
        return massGorda;
    }

    public double getMassMagra() {
        return massMagra;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(String modifyDate) {
        this.modifyDate = modifyDate;
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final Avaliacao other = (Avaliacao) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return "Avaliacao{" + "id=" + id + ", pessoa=" + pessoa + ", peso=" + peso + ", altura=" + altura + ", idade=" + idade + ", pescoco=" + pescoco + ", cintura=" + cintura + ", quadril=" + quadril + ", rotina=" + rotina + ", imc=" + imc + ", tmb=" + tmb + ", bf=" + bf + ", massGorda=" + massGorda + ", massMagra=" + massMagra + ", createDate=" + createDate + ", modifyDate=" + modifyDate + '}';
    }
    
    
    
}
