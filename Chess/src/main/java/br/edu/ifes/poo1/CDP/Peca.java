/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifes.poo1.CDP;

import br.edu.ifes.poo1.util.Cor;
import java.io.Serializable;

/**
 *
 * @author Henrique
 */
public interface Peca{
    public Cor getCor();
    
    //public PecaNome getPecaNome();
    
    public boolean podeAndarQuanto(String posicaoAtual, String proximaPosicao);
    
    public boolean podeCapturar(String posicaoAtual, String proximaPosicao);
}
