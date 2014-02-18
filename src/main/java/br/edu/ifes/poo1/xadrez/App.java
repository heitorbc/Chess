package br.edu.ifes.poo1.xadrez;

import br.edu.ifes.poo1.CCI.ControleTotal;
import br.edu.ifes.poo1.CDP.Jogador;
import br.edu.ifes.poo1.CDP.Tabuleiro;


public class App {
   
    public static void main(String[] args) {

        Tabuleiro tab = new Tabuleiro();
        ControleTotal controleTotal = new ControleTotal(tab);
        controleTotal.iniciaMenu();

    }

}
