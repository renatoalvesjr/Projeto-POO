package model;

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
        this.createDate = Utils.dataAgora();
        this.modifyDate = "";
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

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate() {
        this.createDate = Utils.dataAgora();
    }

    public String getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(String modifyDate) {
        this.modifyDate = modifyDate;
    }
    
    
}
