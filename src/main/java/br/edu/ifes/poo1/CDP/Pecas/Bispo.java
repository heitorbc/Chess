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
public class Bispo extends PecaAbstrata{

    public Bispo(Cor cor) {
        super(cor, PecaNome.BISPO);
    }

    @Override
    public boolean podeAndarQuanto(String posicaoAtual, String proximaPosicao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean podeCapturar(String posicaoAtual, String proximaPosicao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
