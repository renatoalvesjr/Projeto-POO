package itens;

public class Pessoa {

    int id;
    String nome;
    char sexo;
    String nascimento;
    String login;
    String senha;
    String userType;
    String createDate;
    String modifyDate;

    public Pessoa() {
    }
    public Pessoa(int id, String nome, char sexo, String nascimento, String login, String senha, String userType) {
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

}
