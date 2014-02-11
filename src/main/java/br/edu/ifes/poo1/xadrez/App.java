package br.edu.ifes.poo1.xadrez;

import br.edu.ifes.poo1.CCI.ControleTotal;
import br.edu.ifes.poo1.CDP.Jogador;
import br.edu.ifes.poo1.CDP.Pecas.Bispo;
import br.edu.ifes.poo1.CDP.Pecas.Cavalo;
import br.edu.ifes.poo1.CDP.Pecas.Dama;
import br.edu.ifes.poo1.CDP.Pecas.Peao;
import br.edu.ifes.poo1.CDP.Pecas.Rei;
import br.edu.ifes.poo1.CDP.Pecas.Torre;
import br.edu.ifes.poo1.CDP.Tabuleiro;
import br.edu.ifes.poo1.CIH.Impressao;
import br.edu.ifes.poo1.util.Cor;
import br.edu.ifes.poo1.util.PecaNome;
import java.util.Scanner;

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
