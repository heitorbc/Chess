/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.poo1.CIH;

import br.edu.ifes.poo1.CDP.Jogador;
import br.edu.ifes.poo1.CDP.Tabuleiro;
import br.edu.ifes.poo1.util.Cor;

/**
 *
 * @author Henrique
 */
public class Impressao {

    public void Impressao(Tabuleiro tab) {

        System.out.println("PRETAS");
        int linha = 8;
        System.out.println("       1           2           3           4           5           6          7           8");
        while (linha != 0) {
            //for (int linha = 8; linha <= 1; linha--) {
            System.out.print(linha + "  ");
            for (int coluna = 1; coluna <= 8; coluna++) {
                System.out.print("" + coluna + linha + " - ");
                if (tab.retornaPeca("" + coluna + linha) == null) {
                    System.out.print("[  ]");
                } else {
                    System.out.print(tab.retornaPeca("" + coluna + linha).getNome().getApelidoPeca());
                    if (tab.retornaPeca("" + coluna + linha).getCor() == Cor.BRANCO) {
                        System.out.print("b");
                    } else {
                        if (tab.retornaPeca("" + coluna + linha).getCor() == Cor.PRETO) {
                            System.out.print("p");
                        }
                    }
                }
                System.out.print(" | ");
            }
            System.out.println("\n");
            linha--;
        }
        System.out.println("BRANCAS");
    }

    public void imprimeJogador(Jogador jog) {

    }

    public static void cls() {
        for (int i = 0; i < 25; i++) {
            System.out.println("");
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
