package br.edu.ifes.poo1.xadrez;

import br.edu.ifes.poo1.CCI.ControleTotal;
import br.edu.ifes.poo1.CDP.Jogador;
import br.edu.ifes.poo1.CDP.Tabuleiro;
import br.edu.ifes.poo1.CIH.Visual;

/**
 * Hello world!
 *
 */
public class App {
    private Visual tela = new Visual();
    
    public static void main(String[] args) {

        Tabuleiro tab = new Tabuleiro();
        Jogador jogador = new Jogador();
        

        ControleTotal controleTotal = new ControleTotal(tab);
        controleTotal.iniciaMenu();

    }

    public void exibetela() {
        tela.setVisible(true);
    }

    public void fechatela() {
        tela.setVisible(false);
    }

}
