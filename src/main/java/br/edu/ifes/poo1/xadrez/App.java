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
        
        jogador.criaJogador("Heitor");
        System.out.println(jogador.retornaPontos("Heitor"));
        jogador.addPontuacao("Heitor", "v");
        System.out.println(jogador.retornaPontos("Heitor"));
        
        System.out.println(PecaNome.BISPO.getApelidoPeca());
        
        
        ControleTotal controleTotal = new ControleTotal(tab);
        controleTotal.iniciaMenu();
        
        
        
        //System.out.println(""+new Peao(Cor.PRETO).podeAndarQuanto("22", "42"));
      
        
        /*
        
        System.out.println("/n Teste Peão");
        //Tem que dar True
        System.out.println(""+new Peao(Cor.PRETO).podeAndarQuanto("71", "61"));
        //True
        System.out.println(""+new Peao(Cor.BRANCO).podeAndarQuanto("21", "41"));
        //False - Voltar
        System.out.println(""+new Peao(Cor.BRANCO).podeAndarQuanto("71", "81"));
        //False - Diagonal
        System.out.println(""+new Peao(Cor.BRANCO).podeAndarQuanto("61", "63"));
        
        
        
        System.out.println("/n Teste Bispo");
        System.out.println(""+new Bispo(Cor.PRETO).podeAndarQuanto("44", "72"));
        System.out.println(""+new Bispo(Cor.PRETO).podeAndarQuanto("44", "81"));
        System.out.println(""+new Bispo(Cor.PRETO).podeAndarQuanto("44", "17"));
        
        System.out.println("/n Teste Cavalo");
        System.out.println(""+new Cavalo(Cor.PRETO).podeAndarQuanto("44", "65"));
        System.out.println(""+new Cavalo(Cor.PRETO).podeAndarQuanto("44", "56"));
        System.out.println(""+new Cavalo(Cor.PRETO).podeAndarQuanto("44", "88"));
        
        
        System.out.println("/n Teste Dama");
        System.out.println(""+new Dama(Cor.PRETO).podeAndarQuanto("44", "88"));
        System.out.println(""+new Dama(Cor.PRETO).podeAndarQuanto("44", "44"));
        System.out.println(""+new Dama(Cor.PRETO).podeAndarQuanto("44", "71"));
        //False
        System.out.println(""+new Dama(Cor.PRETO).podeAndarQuanto("44", "82"));
        System.out.println(""+new Dama(Cor.PRETO).podeAndarQuanto("44", "56"));
        
        
        System.out.println("/n Teste Rei");
        System.out.println(""+new Rei(Cor.PRETO).podeAndarQuanto("44", "53"));
        System.out.println(""+new Rei(Cor.PRETO).podeAndarQuanto("44", "54"));
        System.out.println(""+new Rei(Cor.PRETO).podeAndarQuanto("44", "35"));
        //Falses
        System.out.println(""+new Rei(Cor.PRETO).podeAndarQuanto("44", "66"));
        System.out.println(""+new Rei(Cor.PRETO).podeAndarQuanto("44", "24"));
        
        System.out.println("/n Teste Torre");
        System.out.println(""+new Torre(Cor.PRETO).podeAndarQuanto("44", "54"));
        System.out.println(""+new Torre(Cor.PRETO).podeAndarQuanto("44", "14"));
        System.out.println(""+new Torre(Cor.PRETO).podeAndarQuanto("44", "48"));
        //Falses
        System.out.println(""+new Torre(Cor.PRETO).podeAndarQuanto("44", "81"));
        System.out.println(""+new Torre(Cor.PRETO).podeAndarQuanto("44", "33"));
        
        
        String teste = new Tabuleiro().retornaPeca("11").getDesenhoTabuleiro();
        System.out.println(""+teste);
        */
        
        
    }
}
