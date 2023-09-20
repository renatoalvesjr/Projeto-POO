package itens;

public class Pessoa {

    private int id;
    private String nome;
    private String sexo;
    private String nascimento;
    private String login;
    private String senha;
    private String userType;
    private String createDate;
    private String modifyDate;

    public Pessoa() {
    }
    public Pessoa(int id, String nome, String sexo, String nascimento, String login, String senha, String userType) {
        this.id = id;
        this.nome = nome;
        this.sexo = sexo;
        this.nascimento = nascimento;
        this.login = login;
        this.senha = senha;
        this.userType = userType;
        this.createDate = Datas.dataAgora();
        this.modifyDate = "";
    }
    public String getSexo(){
        return this.sexo;
    }
}
