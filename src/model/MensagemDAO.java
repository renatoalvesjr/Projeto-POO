package model;

public class MensagemDAO {

    Mensagem mensagens[] = new Mensagem[10];

    public MensagemDAO(PessoaDAO p1) {
        Mensagem m1 = new Mensagem();
        m1.setConteudo("e ai, bahum???");
        m1.setpOrigem(p1.buscaPorNome("renato"));
        m1.setpDestino(p1.buscaPorNome("hebert"));
    }

    private int proximMensagemLivre() {
        for (int i = 0; i < mensagens.length; i++) {
            if (mensagens[i] == null) {
                return i;
            }
        }
        return -1;
    }

    public boolean criaMensagem(Mensagem a) {
        int proximMensagemLivre = proximMensagemLivre();
        if (proximMensagemLivre != -1) {
            mensagens[proximMensagemLivre] = a;
            return true;
        } else {
            return false;
        }
    }

    public void mostraTodasMensagens() {
        for (int i = 0; i < mensagens.length; i++) {
            if (mensagens[i] != null) {
                System.out.println(mensagens[i]);
            }

        }
    }

    public boolean removeMensagens(long id) {
        for (int i = 0; i < mensagens.length; i++) {
            if (mensagens[i].getId() == id) {
                mensagens[i] = null;
                return true;
            }
        }
        return false;
    }

    public boolean alteraConteudo(long id, String conteudo) {
        for (int i = 0; i < mensagens.length; i++) {
            if (mensagens[i].getId() == id) {
                mensagens[i].setConteudo(conteudo);
                return true;
            }

        }
        return false;
    }

    boolean mensagensVazio() {
        for (int i = 0; i < mensagens.length; i++) {
            if (mensagens[i] != null) {
                return false;
            }

        }
        return true;
    }
}