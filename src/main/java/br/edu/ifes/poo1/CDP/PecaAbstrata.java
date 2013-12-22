/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifes.poo1.CDP;

import br.edu.ifes.poo1.util.Cor;
import br.edu.ifes.poo1.util.PecaNome;

/**
 *
 * @author Henrique
 */
public abstract class PecaAbstrata implements Peca{
    protected Cor cor;
    protected PecaNome nome;

    public PecaAbstrata(Cor cor, PecaNome nome) {
        this.cor = cor;
        this.nome = nome;
    }


    @Override
    public Cor getCor() {
        return this.cor;
    }

    public void setCor(Cor cor) {
        this.cor = cor;
    }
    
    public PecaNome getNome() {
        return this.nome;
    }

    public void setNome(PecaNome nome) {
        this.nome = nome;
    }
    
    @Override
    public abstract boolean podeAndarQuanto(String posicaoAtual, String proximaPosicao);
    
    
    @Override
    public abstract boolean podeCapturar(String posicaoAtual, String proximaPosicao);    
}
