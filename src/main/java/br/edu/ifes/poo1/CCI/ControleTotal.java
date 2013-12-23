/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.poo1.CCI;

import br.edu.ifes.poo1.CDP.Jogador;
import br.edu.ifes.poo1.CDP.Peca;
import br.edu.ifes.poo1.CDP.Pecas.Bispo;
import br.edu.ifes.poo1.CDP.Pecas.Cavalo;
import br.edu.ifes.poo1.CDP.Pecas.Dama;
import br.edu.ifes.poo1.CDP.Pecas.Peao;
import br.edu.ifes.poo1.CDP.Pecas.Rei;
import br.edu.ifes.poo1.CDP.Pecas.Torre;
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

    Tabuleiro tabuleiro = new Tabuleiro();
    Jogador jogador = new Jogador();
    Impressao impresso = new Impressao();
    Scanner scanner = new Scanner(System.in);
    String []nomeJogador = new String[2];
        
    public ControleTotal(Tabuleiro tab) {
        tabuleiro = tab;
    }

    public void iniciaMenu() {
        //Pega os nomes dos jogadores e chama o tabuleiro, lembrar que jogador Um e o branco
        //e inicia a partida
        //Mas primeiro exibi as três opções para os jogadores,
        //1ºIniciar nova partida, 2ºDados da partida, 3º Sair.
        impresso.imprimeTipo();
        int dado = scanner.nextInt();
        processaTipo(dado);
        
    }

    public void controlaJogadas(String jog) {

        if ("desistir".equals(jog)) {
            //COLOCAR INTELIGENCIA COMPUTANDO PONTO PARA OUTRO JOGADOR
            System.exit(0);
        }
        if ("empate".equals(jog)) {
            //Se ambos entrarem em acordo, rola um empate               
            System.out.println("Partida empatada, deseja iniciar outra? ('S' ou 'N')");
            char desejo = scanner.next().charAt(0);
            if (desejo == 'N') {
                System.exit(0);
            } else if (desejo == 'S') {
                iniciaMenu();
            } else {
                System.out.println("Opção inválida, jogo encerrado!");
                jogador.imprimiDados();
            }
        }    
        //roqueMenor
        if (jog.length() == 3) {
                System.out.println("Em construção");
                imprimeJogada(nomeJogador[0],nomeJogador[1]);
                iniciaMenu();
        }
            //roque Maior
        if ((jog.length() == 5) && (jog.charAt(0) == 'O')) {
                System.out.println("Em construção");
                imprimeJogada(nomeJogador[0],nomeJogador[1]);
                iniciaMenu();
            }
        if ((jog.length() == 5) && (jog.charAt(2) == 'x')) {
                //JOGADA DE CAPTURA
                System.out.println("Em construção");
                iniciaMenu();            
        }
            //MOVIMENTAÇÂO NORMAL
        if (jog.length() == 4) {
                String posAtual = "" + jog.charAt(0) + jog.charAt(1);
                String posProx = "" + jog.charAt(2) + jog.charAt(3);
                String peca = tabuleiro.retornaPeca(posAtual).getNome().getApelidoPeca();
                if (peca == " P ") {//PEAO
                    if ((tabuleiro.retornaPeca(posAtual).podeAndarQuanto(posAtual, posProx) == true) && (tabuleiro.retornaPeca(posProx) == null)) {
                        tabuleiro.trocaPeca(posAtual, posProx);
                        iniciaJogada();
                    } else {
                        System.out.println("##ERRO##: Movimento Inválido");
                        imprimeJogada(nomeJogador[0],nomeJogador[1]);
                    }
                }
                if (peca == " T ") {//TORRE
                    //movimenta
                    if ((tabuleiro.retornaPeca(posAtual).podeAndarQuanto(posAtual, posProx) == true) && (tabuleiro.retornaPeca(posProx) == null)) {
                        tabuleiro.trocaPeca(posAtual, posProx);
                        iniciaJogada();
                    } else {
                        System.out.println("##ERRO##: Movimento Inválido");
                        imprimeJogada(nomeJogador[0],nomeJogador[1]);
                    }
                }    
                if (peca == " C ") {//CAVALO
                    //movimenta 
                    if ((tabuleiro.retornaPeca(posAtual).podeAndarQuanto(posAtual, posProx) == true) && (tabuleiro.retornaPeca(posProx) == null)) {
                        tabuleiro.trocaPeca(posAtual, posProx);
                        iniciaJogada();
                    } else {
                        System.out.println("##ERRO##: Movimento Inválido");
                        imprimeJogada(nomeJogador[0],nomeJogador[1]);
                    }
                }    
                if (peca == " B ") {//BISPO
                    //Movimento
                    if ((tabuleiro.retornaPeca(posAtual).podeAndarQuanto(posAtual, posProx) == true) && (tabuleiro.retornaPeca(posProx) == null)) {
                        tabuleiro.trocaPeca(posAtual, posProx);
                        iniciaJogada();
                    } else {
                        System.out.println("##ERRO##: Movimento Inválido");
                        imprimeJogada(nomeJogador[0],nomeJogador[1]);
                    }
                }
                if (peca == " D ") {//DAMA
                    //movimenta
                    if ((tabuleiro.retornaPeca(posAtual).podeAndarQuanto(posAtual, posProx) == true) && (tabuleiro.retornaPeca(posProx) == null)) {
                        tabuleiro.trocaPeca(posAtual, posProx);
                        iniciaJogada();
                    } else {
                        System.out.println("##ERRO##: Movimento Inválido");
                        imprimeJogada(nomeJogador[0],nomeJogador[1]);
                    }
                }                    
                if (peca == " R ") {//REI
                    //movimenta 
                    if ((tabuleiro.retornaPeca(posAtual).podeAndarQuanto(posAtual, posProx) == true) && (tabuleiro.retornaPeca(posProx) == null)) {
                        tabuleiro.trocaPeca(posAtual, posProx);
                        iniciaJogada();
                    } else {
                        System.out.println("##ERRO##: Movimento Inválido");
                        imprimeJogada(nomeJogador[0],nomeJogador[1]);
                    }
                }
        }
}        

    public void iniciaJogada() {

        //new Principal().show();
        Impressao imp = new Impressao();
        imp.Impressao(tabuleiro);
        imprimeJogada(nomeJogador[0],nomeJogador[1]);        

    }

    private void processaModoJogo(int dado) {
        if ((dado >= 1) && dado <= 3) {

            switch (dado) {
                case 1:
                    processaJogador();
                    iniciaJogada();
                    break;
                case 2:
                    System.out.println("##ERRO##: Móduo Inativo!!");
                    impresso.imprimeModoJogo();
                    int comando = scanner.nextInt();
                    processaModoJogo(comando);
                    break;
                case 3:
                    System.exit(0);
                    break;

            }
        } else {
            System.out.println("##ERRO##: Entrada Inválida!!");
            impresso.imprimeModoJogo();
            int comando = scanner.nextInt();
            processaModoJogo(comando);
        }
    }

    private void processaMenu(int dado) {
        if ((dado >= 1) && dado <= 3) {

            switch (dado) {
                case 1:
                    impresso.imprimeModoJogo();
                    int comando = scanner.nextInt();
                    processaModoJogo(comando);
                    break;
                case 2:
                    //exibeDados();
                    break;
                case 3:
                    System.exit(0);
                    break;

            }
        } else {
            System.out.println("##ERRO##: Entrada Inválida!!");
            iniciaMenu();
        }
    }

    private void imprimeJogada(String jogador1, String jogador2) {
        if(jogador.jogador.containsKey(jogador1)){
            System.out.println("Digite a jogada:"+ jogador1+" (B) ");
            String jogada = scanner.next();
            controlaJogadas(jogada);
        }
            if(jogador.jogador.containsKey(jogador2)){
            System.out.println("Digite a jogada:"+ jogador2+" (P) ");
            String jogada = scanner.next();
            controlaJogadas(jogada);
            }
    }

    private void processaTipo(int dado) {
        if ((dado >= 1) && dado <= 3) {

            switch (dado) {
                case 1:
                    impresso.imprimeMenu();
                    int comando = scanner.nextInt();
                    processaMenu(comando);
                    break;
                case 2:
                    new Principal().show();
                    break;
                case 3:
                    System.exit(0);
                    break;            }
        } else {
            System.out.println("##ERRO##: Entrada Inválida!!");
            iniciaMenu();
        }
    }
    //Identificação do jogador, falta implementar outras coiass.
    public void processaJogador(){
        System.out.println("Nome: Jogador 1:");
        nomeJogador[0] = scanner.next();
        jogador.criaJogador(nomeJogador[0]);
        
        System.out.println("Nome: Jogador 2:");
        nomeJogador[1] = scanner.next();
        jogador.criaJogador(nomeJogador[1]);
    }
}