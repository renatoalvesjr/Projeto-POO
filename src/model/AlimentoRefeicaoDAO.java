/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class AlimentoRefeicaoDAO {

    AlimentoRefeicao[] alimentoRefeicao = new AlimentoRefeicao[20];

    public AlimentoRefeicaoDAO(RefeicoesDAO refeicaoDAO, AlimentoDAO alimentoDAO, PessoaDAO pessoaDAO) {
        AlimentoRefeicao alrf1 = new AlimentoRefeicao();
        alrf1.setPessoa(pessoaDAO.buscaPorNome("renato"));
        alrf1.setRefeicao(refeicaoDAO.buscaPorId(1));
        alrf1.setAlimento(alimentoDAO.BuscaAlimento(1));
        alrf1.setAlimento(alimentoDAO.BuscaAlimento(2));
        alrf1.setAlimento(alimentoDAO.BuscaAlimento(3));
        alrf1.setAlimento(alimentoDAO.BuscaAlimento(4));
        alrf1.setPorcao(4);
        alrf1.setNutrientes();
        criaRefeicaoAlimento(alrf1);

        AlimentoRefeicao alrf2 = new AlimentoRefeicao();
        alrf2.setPessoa(pessoaDAO.buscaPorNome("renato"));
        alrf2.setRefeicao(refeicaoDAO.buscaPorId(2));
        alrf2.setAlimento(alimentoDAO.BuscaAlimento(1));
        alrf2.setAlimento(alimentoDAO.BuscaAlimento(2));
        alrf2.setAlimento(alimentoDAO.BuscaAlimento(3));
        alrf2.setAlimento(alimentoDAO.BuscaAlimento(4));
        alrf2.setPorcao(4);
        alrf2.setNutrientes();
        criaRefeicaoAlimento(alrf2);

        AlimentoRefeicao alrf3 = new AlimentoRefeicao();
        alrf3.setPessoa(pessoaDAO.buscaPorNome("renato"));
        alrf3.setRefeicao(refeicaoDAO.buscaPorId(4));
        alrf3.setAlimento(alimentoDAO.BuscaAlimento(1));
        alrf3.setAlimento(alimentoDAO.BuscaAlimento(2));
        alrf3.setAlimento(alimentoDAO.BuscaAlimento(3));
        alrf3.setAlimento(alimentoDAO.BuscaAlimento(4));
        alrf3.setPorcao(4);
        alrf3.setNutrientes();
        criaRefeicaoAlimento(alrf3);

        AlimentoRefeicao alrf4 = new AlimentoRefeicao();
        alrf4.setPessoa(pessoaDAO.buscaPorNome("renato"));
        alrf4.setRefeicao(refeicaoDAO.buscaPorId(3));
        alrf4.setAlimento(alimentoDAO.BuscaAlimento(1));
        alrf4.setAlimento(alimentoDAO.BuscaAlimento(2));
        alrf4.setAlimento(alimentoDAO.BuscaAlimento(3));
        alrf4.setAlimento(alimentoDAO.BuscaAlimento(4));
        alrf4.setPorcao(4);
        alrf4.setNutrientes();
        criaRefeicaoAlimento(alrf4);

    }

    public int proxLivre() {
        for (int i = 0; i < alimentoRefeicao.length; i++) {
            if (alimentoRefeicao[i] == null) {
                return i;
            }

        }
        return -1;
    }

    public boolean criaRefeicaoAlimento(AlimentoRefeicao alrf) {
        int proxLivre = proxLivre();
        for (int i = 0; i < alimentoRefeicao.length; i++) {
            if (proxLivre != -1) {
                alimentoRefeicao[proxLivre] = alrf;
                return true;
            }
        }
        return false;
    }

    public boolean removeAlimentoRefeicao(long id) {
        for (int i = 0; i < alimentoRefeicao.length; i++) {
            if (alimentoRefeicao[i] != null && alimentoRefeicao[i].getId() == id) {
                alimentoRefeicao[i] = null;
                return true;
            }
        }
        return false;
    }

    public boolean removeAlimentoPorId(long idAlimentoRefeicao, long idAlimento) {
        for (int i = 0; i < alimentoRefeicao.length; i++) {
            if (alimentoRefeicao[i].getId() == idAlimentoRefeicao) {
                Alimento[] alimentos = new Alimento[20];
                alimentos = alimentoRefeicao[i].getAlimento();
                for (int j = 0; j < alimentos.length; j++) {
                    if (alimentos[i] != null && alimentos[i].getId() == idAlimento) {
                        alimentos[i] = null;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public AlimentoRefeicao buscaPorId(long id) {
        for (int i = 0; i < alimentoRefeicao.length; i++) {
            if (alimentoRefeicao[i] != null && alimentoRefeicao[i].getId() == id) {
                return alimentoRefeicao[i];
            }
        }
        return null;
    }

    public AlimentoRefeicao buscaAlimentosRefeicaoNome(Pessoa p, String nome) {
        for (int i = 0; i < alimentoRefeicao.length; i++) {
            if (alimentoRefeicao[i] != null && alimentoRefeicao[i].getPessoa().equals(p) && alimentoRefeicao[i].getRefeicao().getNomeRefeicao().equalsIgnoreCase(nome)) {
                return alimentoRefeicao[i];
            }
        }
        return null;
    }

    public boolean removeAlimentoPorId(AlimentoRefeicao alrf, long id) {
        Alimento[] alimentos = alrf.getAlimento();
        for (int i = 0; i < alimentos.length; i++) {
            if (alimentos[i] != null && alimentos[i].getId() == id) {
                alimentos[i] = null;
                return true;
            }
        }
        return false;
    }

    public AlimentoRefeicao[] buscaTodosPorPessoa(Pessoa p) {
        AlimentoRefeicao[] alrfs = new AlimentoRefeicao[10];
        for (int i = 0; i < alimentoRefeicao.length; i++) {
            if (alimentoRefeicao[i] != null && alimentoRefeicao[i].getPessoa().equals(p)) {
                for (int j = 0; j < alrfs.length; j++) {
                    if (alrfs[i] == null) {
                        alrfs[i] = alimentoRefeicao[i];
                    }
                }
            }

        }
        return alrfs;
    }
}
