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
public class Dama extends PecaAbstrata{

    public Dama(Cor cor) {
        super(cor, PecaNome.DAMA);
    }
            
    @Override
    public boolean podeAndarQuanto(String posicaoAtual, String proximaPosicao) {
        //Junção de Bispo com Torre +/-
        return ((posicaoAtual.charAt(1) == proximaPosicao.charAt(1) || 
               (posicaoAtual.charAt(0) == proximaPosicao.charAt(0))) || 
               (Math.abs(posicaoAtual.charAt(0) - proximaPosicao.charAt(0)) == (Math.abs(posicaoAtual.charAt(1) - proximaPosicao.charAt(1))) &&
               !posicaoAtual.equals(proximaPosicao)));
    }

    @Override
    public boolean podeCapturar(String posicaoAtual, String proximaPosicao) {
        return true;
    }
    
    
}