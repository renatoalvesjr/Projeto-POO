package itens;

public class Seguindo {
    private long id;
    private Pessoa pessoa;
    private Pessoa[] seguidores = new Pessoa[5];
    private String createDate;
    private String modifyDate;
    private static long serial;
    
    public Seguindo() {
        this.id = ++Seguindo.serial;
        this.createDate = Datas.dataAgora();
        this.modifyDate = "";
    }
}
