/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.poo1.CIH;

import br.edu.ifes.poo1.CDP.Tabuleiro;

/**
 *
 * @author Henrique
 */
public class Impressao {
    
    
    public void Impressao(Tabuleiro tab){
    
       
    for (int linha = 1; linha <= 8; linha++) {
        for (int coluna = 1; coluna <= 8; coluna++) {
            System.out.print(""+linha+coluna+" - ");
                if(tab.retornaPeca(""+coluna+linha) == null){
                    //Imprimi null ou barra
                    //System.out.print(tab.retornaPeca(""+coluna+linha));
                    System.out.print("[ ]");
                }else{
                    System.out.print(tab.retornaPeca(""+coluna+linha).getNome().getApelidoPeca());
                }
                System.out.print(" | ");
            }
            System.out.println("\n");
        }       
}    
}

    
    
    /*1ºFAzer as peças
     * 2ºFazer o tabuleiro
     * 3ºComeçar a criar o controle, validando as jogadas.
     * 4º
     * 
     * 
     * Controle Geral le do teclado e junta o CIH e CGT
    
    
    * Tratamento de erros(Exepection) fica no controle. 
    */ 
    
    

