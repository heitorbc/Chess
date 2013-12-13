package br.edu.ifes.poo1.xadrez;

import br.edu.ifes.poo1.CDP.Tabuleiro;
import br.edu.ifes.poo1.CIH.Principal;
import br.edu.ifes.poo1.util.Cor;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        System.out.println(Cor.BRANCO);
        System.out.println(Cor.PRETO);  
        System.out.println();
        Tabuleiro tab = new Tabuleiro();
        
        
        for (int linha = 1; linha <= 8; linha++) {
            for (int coluna = 1; coluna <= 8; coluna++) {
                System.out.print(""+linha+coluna+" - ");
                System.out.print(tab.retornaPeca(""+coluna+linha));
                System.out.print(" | ");
            }
            System.out.println("\n");
        }
        
        new Principal().show();
    }
}
