package br.edu.ifes.poo1.xadrez;

import br.edu.ifes.poo1.CCI.ControleTotal;
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
        System.out.println( "Hello World!" );
        System.out.println(Cor.BRANCO);
        System.out.println(Cor.PRETO);  
        System.out.println(PecaNome.BISPO.getApelidoPeca());
        
        
        
        ControleTotal controlTotal = new ControleTotal();
        controlTotal.iniciaMenu();
        
    }
}
