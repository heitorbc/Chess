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
public class Cavalo extends PecaAbstrata{

    public Cavalo(Cor cor) {
        super(cor, PecaNome.CAVALO);
    }
    
    
    
    @Override
    public boolean andar(String posicaoAtual, String proximaPosicao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean capturar(String posicaoAtual, String proximaPosicao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
