/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifes.poo1.CDP;

import br.edu.ifes.poo1.util.Cor;

/**
 *
 * @author Henrique
 */
public interface Peca {
    public Cor getCor();

    public boolean andar(String posicaoAtual, String proximaPosicao);
    
    public boolean capturar(String posicaoAtual, String proximaPosicao);


}
