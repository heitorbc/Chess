/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.poo1.CCI;

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
        impresso.cls();
        imprimeTipo();
        int dado = scanner.nextInt();
        impresso.cls();
        processaTipo(dado);
        
    }

    public void controlaJogadas(String jog) {
        if (jog == "desistir") {
            //COLOCAR INTELIGENCIA COMPUTANDO PONTO PARA OUTRO JOGADOR
            System.exit(0);
        } else {
            if (jog == "empate") {
                //COOCAR INTELIGENCIA PERGUNTANDO SE AMBOS JOGADORES QUEREM EMPATE:
                System.out.println("Oponente aceita Empate [S/N] ? ");
                String resultado = scanner.nextLine().toUpperCase();
                
            } else {

                //roqueMenor
                if (jog.length() == 3) {

                }
                //roque Maior
                if ((jog.length() == 5) && (jog.charAt(0) == 'O')) {

                } else {
                    //JOGADA DE CAPTURA
                }
                //MOVIMENTAÇÂO NORMAL
                if (jog.length() == 4) {
                    String posAtual = "" + jog.charAt(0) + jog.charAt(1);
                    System.out.println(posAtual + " - " + tabuleiro.retornaPeca(posAtual));
                    String posProx = "" + jog.charAt(2) + jog.charAt(3);
                    System.out.println(posProx + " - " + tabuleiro.retornaPeca(posProx));
                    System.out.println(posProx);
                    String peca = tabuleiro.retornaPeca(posAtual).getNome().getApelidoPeca();
                    if (peca == " P ") {//PEAO
                        //analiza se PEAO pode andar
                        if (tabuleiro.retornaPeca(posAtual).podeAndarQuanto(posAtual, posProx) == true) {
                            //movimenta
                            System.out.println("pode movimentaar");
                            tabuleiro.trocaPeca(posAtual, posProx);

                            iniciaJogada();
                        } else {
                            System.out.println("##ERRO##: Movimento Inválido");
                            imprimeJogada();
                        }

                    } else {
                        if (peca == " T ") {//TORRE
                            //analiza se TORRE pode andar

                            //movimenta 
                        } else {
                            if (peca == " C ") {//CAVALO
                                //analiza se CAVALO pode andar

                                //movimenta 
                            } else {
                                if (peca == " B ") {//BISPO
                                    //analiza se BISPO pode andar

                                    //movimenta 
                                } else {
                                    if (peca == " D ") {//DAMA
                                        //analiza se DAMA pode andar

                                        //movimenta 
                                    } else {
                                        if (peca == " R ") {//REI
                                            //analiza se REI pode andar

                                            //movimenta 
                                        }
                                    }
                                }

                            }
                        }
                    }

                }
            }
        }
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

    private void imprimeModoJogo() {
        System.out.println("##    MENU    ##");
        System.out.println("##TIPO DE JOGO##");
        System.out.println("1 - Humano vs Humano");
        System.out.println("2 - Humano vs Computador");
        System.out.println("3 - Sair");
    }

    private void processaModoJogo(int dado) {
        if ((dado >= 1) && dado <= 3) {

            switch (dado) {
                case 1:
                    iniciaJogada();
                    break;
                case 2:
                    System.out.println("##ERRO##: Móduo Inativo!!");
                    imprimeModoJogo();
                    int comando = scanner.nextInt();
                    processaModoJogo(comando);
                    break;
                case 3:
                    System.exit(0);
                    break;

            }
        } else {
            System.out.println("##ERRO##: Entrada Inválida!!");
            imprimeModoJogo();
            int comando = scanner.nextInt();
            processaModoJogo(comando);
        }
    }

    private void processaMenu(int dado) {
        if ((dado >= 1) && dado <= 3) {

            switch (dado) {
                case 1:
                    imprimeModoJogo();
                    int comando = scanner.nextInt();
                    impresso.cls();
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

    private void imprimeJogada() {
        System.out.println("Digite a jogada:");
        String jogada = scanner.next();
        impresso.cls();
        controlaJogadas(jogada);
    }

    private void imprimeTipo() {
        System.out.println("##         MENU         ##");
        System.out.println("##  ESCOLHA A INTERFACE ##");
        System.out.println("1 - Textual");
        System.out.println("2 - Gráfica");
        System.out.println("3 - Sair");
    }

    private void processaTipo(int dado) {
        if ((dado >= 1) && dado <= 3) {

            switch (dado) {
                case 1:
                    imprimeMenu();
                    int comando = scanner.nextInt();
                    impresso.cls();
                    processaMenu(comando);
                    break;
                case 2:
                    new Principal().show();
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

}
