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
        alrf1.setPorcao(1);
        criaRefeicaoAlimento(alrf1);

        AlimentoRefeicao alrf2 = new AlimentoRefeicao();
        alrf2.setPessoa(pessoaDAO.buscaPorNome("renato"));
        alrf2.setRefeicao(refeicaoDAO.buscaPorId(1));
        alrf2.setAlimento(alimentoDAO.BuscaAlimento(2));
        alrf2.setPorcao(1);
        criaRefeicaoAlimento(alrf2);

        AlimentoRefeicao alrf3 = new AlimentoRefeicao();
        alrf3.setPessoa(pessoaDAO.buscaPorNome("renato"));
        alrf3.setRefeicao(refeicaoDAO.buscaPorId(1));
        alrf3.setAlimento(alimentoDAO.BuscaAlimento(3));
        alrf3.setPorcao(1);
        criaRefeicaoAlimento(alrf3);

        AlimentoRefeicao alrf4 = new AlimentoRefeicao();
        alrf4.setPessoa(pessoaDAO.buscaPorNome("renato"));
        alrf4.setRefeicao(refeicaoDAO.buscaPorId(1));
        alrf4.setAlimento(alimentoDAO.BuscaAlimento(4));
        alrf4.setPorcao(1);
        criaRefeicaoAlimento(alrf4);
        
        AlimentoRefeicao alrf5 = new AlimentoRefeicao();
        alrf5.setPessoa(pessoaDAO.buscaPorNome("renato"));
        alrf5.setRefeicao(refeicaoDAO.buscaPorId(2));
        alrf5.setAlimento(alimentoDAO.BuscaAlimento(1));
        alrf5.setPorcao(1);
        criaRefeicaoAlimento(alrf5);

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
    
    public boolean removeRefeicaoPorNome(String nome, Pessoa p){
        for (int i = 0; i < alimentoRefeicao.length; i++) {
            if(alimentoRefeicao[i] != null && alimentoRefeicao[i].getPessoa().equals(p) && alimentoRefeicao[i].getRefeicao().getNomeRefeicao().equalsIgnoreCase(nome)){
                alimentoRefeicao[i] = null;
                return true;
            }
        }
        return false;
    }
    
    public boolean removeAlimentoDaRefeicao(long id, String nome){
        for (int i = 0; i < alimentoRefeicao.length; i++) {
            if(alimentoRefeicao[i] != null && alimentoRefeicao[i].getRefeicao().getNomeRefeicao().equalsIgnoreCase(nome) && alimentoRefeicao[i].getAlimento().getId() == id){
                alimentoRefeicao[i] = null;
                return true;
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

    public AlimentoRefeicao[] buscaTodosPorPessoa(Pessoa p) {
        if(alimentoRefeicao.length != 0){
            return alimentoRefeicao;
        }
        return null;
    }
    
    public AlimentoRefeicao[] buscaTodosPorRefeicao(Pessoa p, String nome) {
        AlimentoRefeicao[] alrf = new AlimentoRefeicao[20];
        int id = 0;
        for (int i = 0; i < alimentoRefeicao.length; i++) {
            if(alimentoRefeicao[i] != null && alimentoRefeicao[i].getPessoa().equals(p) && alimentoRefeicao[i].getRefeicao().getNomeRefeicao().equalsIgnoreCase(nome)){
                alrf[id] = alimentoRefeicao[i];
                id++;
            }
            
        }
        if(alrf.length > 0){
            return alrf;
        }
        return null;
    }
}
