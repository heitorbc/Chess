/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.poo1.CCI;

import br.edu.ifes.poo1.CDP.Pecas.Peao;
import br.edu.ifes.poo1.CDP.Tabuleiro;
import br.edu.ifes.poo1.CIH.Impressao;
import br.edu.ifes.poo1.CIH.Principal;
import java.util.Scanner;

/**
 *
 * @author 20121BSI0082
 */
public class ControleTotal {

    //ExibeMEnu
    /*Pega os dados do usuários
     A cci chama alguma coisa do CGT, que é as jogadas.
     Assim pego aqui os dados e passo pra lá, algo assim...
     */
    Tabuleiro tabuleiro = new Tabuleiro();

    public ControleTotal(Tabuleiro tab) {
        tabuleiro = tab;
    }

    private Impressao impresso;
    Scanner scanner = new Scanner(System.in);

    public void iniciaMenu() {
        //Pega os nomes dos jogadores e chama o tabuleiro, lembrar que jogador Um e o branco
        //e inicia a partida
        //Mas primeiro exibi as três opções para os jogadores,
        //1ºIniciar nova partida, 2ºDados da partida, 3º Sair.
        imprimeMenu();

        int comando = scanner.nextInt();
        processaMenu(comando);

    }

    public void controlaJogadas(String jog) {
        String posAtual = jog.charAt(0) + jog.charAt(1) + "";
        String posProx = jog.charAt(2) + jog.charAt(3) + "";
        //if(retornaPeca(posAtual)==Peao){

        //}
    }

    public void iniciaJogada() {
        //Fazer um while aqui para ele ficar jogando.

        //new Principal().show();
        Impressao imp = new Impressao();
        imp.Impressao(tabuleiro);
        imprimeJogada();

    }

    private void imprimeMenu() {
        System.out.println("##MENU##");
        System.out.println("1 - Inicia Partida");
        System.out.println("2 - Dados da jogadas");
        System.out.println("3 - Sair");
    }

    private void processaMenu(int dado) {
        if((dado>=1)&&dado<=3){

            switch (dado) {
                case 1:
                    iniciaJogada();
                    break;
                case 2:
                    //exibeDados();
                    break;
                case 3:
                    System.exit(0);
                    break;

            }
        }else{
            System.out.println("##ERRO##: Entrada Inválida!!");
            iniciaMenu();
        }
    }

    private void imprimeJogada() {
        System.out.println("Digite a jogada:");
        String jogada = scanner.next();
        controlaJogadas(jogada);
    }

}
