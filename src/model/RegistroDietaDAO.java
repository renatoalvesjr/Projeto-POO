package model;

public class RegistroDietaDAO {

    RegistroDieta[] rd = new RegistroDieta[10];

    public RegistroDietaDAO(PessoaDAO pessoaDAO, TipoDietaDAO tipodietaDAO, AvaliacaoDAO avaliacaoDAO) {
        RegistroDieta rd1 = new RegistroDieta();
      
        rd1.setPessoa(pessoaDAO.buscaPorNome("renato"));
        rd1.setAvaliacao(avaliacaoDAO.buscaAvalPessoa(pessoaDAO.buscaPorNome("renato")));
        rd1.setTipoDieta(tipodietaDAO.BuscaPorNome("EQUILIBRADA"));
        rd1.setObjetivo(2);
        rd1.setNumRefeicao(4);
        criaRD(rd1);
    }

    private int proxLivre() {
        for (int i = 0; i < rd.length; i++) {
            if (rd[i] == null) {
                return i;
            }

        }
        return -1;
    }

    public boolean criaRD(RegistroDieta reg) {
        int proxLivre = proxLivre();
        for (int i = 0; i < rd.length; i++) {
            if (proxLivre != -1) {
                rd[proxLivre] = reg;
                return true;
            }
        }
        return false;
    }

    public RegistroDieta buscaPorPessoa(Pessoa p) {
        for (int i = 0; i < rd.length; i++) {
            if (rd[i] != null && rd[i].getPessoa().equals(p)) {
                return rd[i];
            }
        }
        return null;
    }
    
    public boolean removeRD(long id) {
        for (int i = 0; i < rd.length; i++) {
            if (rd[i] != null && rd[i].getId() == id) {
                rd[i] = null;
                return true;
            }
        }
        return false;
    }
}
    

    