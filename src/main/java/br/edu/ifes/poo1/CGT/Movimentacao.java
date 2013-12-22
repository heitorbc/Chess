/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifes.poo1.CGT;

import br.edu.ifes.poo1.CDP.Pecas.Cavalo;
import br.edu.ifes.poo1.CDP.Pecas.Torre;
import br.edu.ifes.poo1.CDP.Tabuleiro;

/**
 *
 * @author Henrique
 */
//Classe que gerencia movmento das pecas
public class Movimentacao {
    
    public boolean existePeca(String proximaPosicao){
        //String teste = new Tabuleiro().retornaPeca(proximaPosicao).getDesenhoTabuleiro();
        return(new Tabuleiro().retornaPeca(proximaPosicao)!= null);
    }
    //Este pode ser o captura...
    public void movePeca(String posicaoAtual,String proximaPosicao){
        if (!existePeca(proximaPosicao)){
            //if( podeAndarQuanto(posicaoAtual, proximaPosicao )){
               //Fazer uns condionais aqui para verificar a peça a ser movimentada
            }
        System.out.println(" ");
        }
}

