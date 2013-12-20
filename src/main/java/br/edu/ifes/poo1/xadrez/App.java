package br.edu.ifes.poo1.xadrez;

import br.edu.ifes.poo1.CCI.ControleTotal;
import br.edu.ifes.poo1.CDP.Jogador;
import br.edu.ifes.poo1.CDP.Pecas.Peao;
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
        //Tabuleiro tab = new Tabuleiro();
        //Jogador jogador = new Jogador();
//        
//        jogador.criaJogador("Heitor");
//        System.out.println(jogador.retornaPontos("Heitor"));
//        jogador.addPontuacao("Heitor", "v");
//        System.out.println(jogador.retornaPontos("Heitor"));
        
        //System.out.println(PecaNome.BISPO.getApelidoPeca());
        
                
        //ControleTotal controleTotal = new ControleTotal(tab);
        //controleTotal.iniciaMenu();
        //Tem que dar True
        System.out.println(""+new Peao(Cor.PRETO).podeAndarQuanto("71", "61"));
        //True
        System.out.println(""+new Peao(Cor.BRANCO).podeAndarQuanto("21", "41"));   
        //False
        System.out.println(""+new Peao(Cor.BRANCO).podeAndarQuanto("71", "81"));
        
        
        
        //new Peao(Cor.PRETO).podeAndarQuanto(null, null)
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
}
