package br.edu.ifes.poo1.xadrez;

import br.edu.ifes.poo1.CCI.ControleTotal;
import br.edu.ifes.poo1.CDP.Tabuleiro;
import br.edu.ifes.poo1.CIH.Impressao;
import br.edu.ifes.poo1.util.Cor;
import br.edu.ifes.poo1.util.PecaNome;

/**
 * Hello world!
 *
 */
public class App 
{
    
    public static void main( String[] args )
    {
        Tabuleiro tab = new Tabuleiro();
                
        System.out.println(PecaNome.BISPO.getApelidoPeca());
        
                
        ControleTotal controlTotal = new ControleTotal(tab);
        controlTotal.iniciaMenu();
        
    }
}
