/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.poo1.CDP.Pecas;

import br.edu.ifes.poo1.CDP.PecaAbstrata;
import br.edu.ifes.poo1.util.Cor;
import br.edu.ifes.poo1.util.PecaNome;

/**
 *
 * @author 20121BSI0082
 */
//O controle verifica se pode podeAndar.
public class PeaoBranco extends PecaAbstrata {

    public PeaoBranco(Cor cor) {
        super(cor, PecaNome.PEAO);
    }


    @Override
    public boolean podeAndarQuanto(String posicaoAtual, String proximaPosicao ) {
        //Andar Duas casas 1
        if ((posicaoAtual.charAt(1) == '2')
                && (posicaoAtual.charAt(1) < proximaPosicao.charAt(1))
                && (posicaoAtual.charAt(0) == proximaPosicao.charAt(0))) {
            return (Math.abs(proximaPosicao.charAt(1) - posicaoAtual.charAt(1)) <= 2);

        //Andar UMA casa
        
        } else if ((posicaoAtual.charAt(1) != '0')
                && (posicaoAtual.charAt(1) < proximaPosicao.charAt(1))
                && (posicaoAtual.charAt(0) == proximaPosicao.charAt(0))
                && (Math.abs(proximaPosicao.charAt(1) - posicaoAtual.charAt(1)) == 1)) {
            return (Math.abs(proximaPosicao.charAt(0) - posicaoAtual.charAt(0)) == 0);
         }
        return false;
    }
    
    @Override
    public boolean podeCapturar(String posicaoAtual, String proximaPosicao){
       
        if(proximaPosicao.charAt(1) - posicaoAtual.charAt(1) == 1){
            return ( Math.abs(posicaoAtual.charAt(0) - proximaPosicao.charAt(0)) == 1);
        }
        return false;
    }    
}