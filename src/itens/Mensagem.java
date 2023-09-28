package itens;

public class Mensagem {
    private long id;
    private Pessoa pOrigem;
    private Pessoa pDestino;
    private String conteudo;
    private String createDate;
    private String modifyDate;
    private static long serial;
    
    public Mensagem() {
        this.id = ++Mensagem.serial;
        this.createDate = Datas.dataAgora();
        this.modifyDate = "";
    }
    
    
}
