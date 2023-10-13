/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class AlimentoRefeicaoDAO {

    AlimentoRefeicao[] alimentoRefeicao = new AlimentoRefeicao[20];

    public AlimentoRefeicaoDAO(RefeicoesDAO refeicaoDAO, AlimentoDAO alimentoDAO) {

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
    
    public boolean removeAlimentoPorId(long idAlimentoRefeicao, long idAlimento){
        for (int i = 0; i < alimentoRefeicao.length; i++) {
            if(alimentoRefeicao[i].getId() == idAlimentoRefeicao){
                Alimento[] alimentos = new Alimento[20];
                alimentos = alimentoRefeicao[i].getAlimento();
                for (int j = 0; j < alimentos.length; j++) {
                    if(alimentos[i] != null && alimentos[i].getId() == idAlimento){
                        alimentos[i] = null;
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public AlimentoRefeicao buscaPorId(long id){
        for (int i = 0; i < alimentoRefeicao.length; i++) {
            if(alimentoRefeicao[i] != null && alimentoRefeicao[i].getId() == id){
                return alimentoRefeicao[i];
            }
        }
        return null;
    }
}
