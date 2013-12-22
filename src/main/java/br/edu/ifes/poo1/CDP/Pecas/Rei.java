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
public class Rei extends PecaAbstrata{

    public Rei(Cor cor) {
        super(cor,PecaNome.REI);
    }

    @Override
    public boolean podeAndarQuanto(String posicaoAtual, String proximaPosicao){
        //Verifica se o jogador vai andar apenas uma posicao
        return((Math.abs(posicaoAtual.charAt(1) - proximaPosicao.charAt(1)) == 1) || 
                (Math.abs(posicaoAtual.charAt(0) - posicaoAtual.charAt(0)) == 1));
        
    }    
    /*
    public String comoAndar (String posicaoAtual, String proximaPosicao){
        if(andar(posicaoAtual, proximaPosicao)){
            posicaoAtual = proximaPosicao;
            return posicaoAtual;
        }
        return null;
    }
    */
    //capturar, tem que haver uma peca na posicao de captura e ser da outra cor.
    
    @Override
    public boolean podeCapturar(String posicaoAtual, String proximaPosicao){
        return true;
    }
}
