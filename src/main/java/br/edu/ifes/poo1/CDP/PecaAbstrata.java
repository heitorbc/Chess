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
public class PecaAbstrata {
    protected Cor cor;
  
    public PecaAbstrata(Cor cor) {
        this.cor = cor;
    }   
    
    public Cor getCor() {
        return cor;
    }

    public void setCor(Cor cor) {
        this.cor = cor;
    }   
    
}
