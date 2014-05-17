/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifes.poo1.CGT;


import br.edu.ifes.poo1.CDP.Tabuleiro;

/**
 *
 * @author Henrique
 */
//Classe que gerencia movmento das pecas
public class Movimentacao {
    Tabuleiro tabu = new Tabuleiro();
    //Rei rei = new Rei();
    //Torre torre = new Torre();
    
    public boolean existePeca(String proximaPosicao){
       
        return(new Tabuleiro().retornaPeca(proximaPosicao)!= null);
    }
    public void movePeca(String posicaoAtual,String proximaPosicao){
        if (!existePeca(proximaPosicao)){
            //if( podeAndarQuanto(posicaoAtual, proximaPosicao )){
               //Fazer uns condionais aqui para verificar a peça a ser movimentada
            }
        System.out.println(" ");
        }
    public void jogadasEspeciais(String moviment, String posAtual, String proxPosicao){
        switch(moviment){
            //Caputura
            case "captura":
                //if(tabu.retornaPeca(proxPosicao) !=  null && tabu.retornaPeca(proxPosicao).setCor(Cor.PRETO));
            //Roque menor    
            case "O-O":
                //rei.getCor().getCorPeca();
                //torre.getCor().getCorPeca();
                
            //Roque Maior    
            case "O-O-O":
            
            //Cheque mate
            case "xequeMate":
            
            default:
                System.out.println("Movimento desconhecido.");
            
                
        }

        
            
    }
}

