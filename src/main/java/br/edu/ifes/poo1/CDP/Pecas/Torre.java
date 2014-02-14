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
public class Torre extends PecaAbstrata {

    public Torre(Cor cor) {
        super(cor, PecaNome.TORRE);
    }  

    @Override
    public boolean podeAndarQuanto(String posicaoAtual, String proximaPosicao) {
        return (posicaoAtual.charAt(1) == proximaPosicao.charAt(1) || 
            (posicaoAtual.charAt(0) == proximaPosicao.charAt(0)));    
    }

    @Override
    public boolean podeCapturar(String posicaoAtual, String proximaPosicao) {
        
        return podeAndarQuanto(posicaoAtual, proximaPosicao);
    }   
}