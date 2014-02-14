package br.edu.ifes.poo1.xadrez;

import br.edu.ifes.poo1.CCI.ControleTotal;
import br.edu.ifes.poo1.CDP.Jogador;
import br.edu.ifes.poo1.CDP.Tabuleiro;


/**
 * Hello world!
 *
 */
public class App 
{
    
    public static void main( String[] args )
    {
        
        Tabuleiro tab = new Tabuleiro();
        Jogador jogador = new Jogador();
        
        ControleTotal controleTotal = new ControleTotal(tab);
        controleTotal.iniciaMenu();
        
        System.out.println();
        //Bispo b = new Bispo(Cor.PRETO);
    }
}
