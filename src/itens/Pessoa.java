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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
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
    

}
