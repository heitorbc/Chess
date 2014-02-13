/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifes.poo1.CDP.Pecas;

import br.edu.ifes.poo1.CDP.PecaAbstrata;
import br.edu.ifes.poo1.util.Cor;
import br.edu.ifes.poo1.util.PecaNome;

/**
 *
 * @author Henrique
 */
public class PeaoPreto extends PecaAbstrata{

    public PeaoPreto(Cor cor) {
        super(cor, PecaNome.PEAO);
    }
    
    @Override
    public boolean podeAndarQuanto(String posicaoAtual, String proximaPosicao){
        //Andar duas posicoes
        if ((posicaoAtual.charAt(1) == '7')
                && (posicaoAtual.charAt(1) > proximaPosicao.charAt(1))
                && (posicaoAtual.charAt(0) == proximaPosicao.charAt(0))) {
            return (Math.abs(proximaPosicao.charAt(1) - posicaoAtual.charAt(1)) <= 2);
        }
        
        //Andar Uma Casa
        else if ((posicaoAtual.charAt(1) != '0')
                && (posicaoAtual.charAt(1) > proximaPosicao.charAt(1))
                && (posicaoAtual.charAt(0) == proximaPosicao.charAt(0))
                && (Math.abs(proximaPosicao.charAt(1) - posicaoAtual.charAt(1)) == 1)) {
            return (Math.abs(proximaPosicao.charAt(0) - posicaoAtual.charAt(0)) == 0);
         }
        
        return false;
    }

    @Override
    public boolean podeCapturar(String posicaoAtual, String proximaPosicao) {
        return false;
    }
    
}
