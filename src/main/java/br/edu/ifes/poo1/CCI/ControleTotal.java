/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.poo1.CCI;

import br.edu.ifes.poo1.CDP.Jogador;
import br.edu.ifes.poo1.CDP.Tabuleiro;
import br.edu.ifes.poo1.CIH.Impressao;
import br.edu.ifes.poo1.CIH.Mensagens;
import br.edu.ifes.poo1.CIH.Visual;
import br.edu.ifes.poo1.util.Cor;
import java.util.Scanner;

/**
 *
 * @author 20121BSI0082
 */
public class ControleTotal {

    //ExibeMEnu
    Tabuleiro tabuleiro = new Tabuleiro();
    public Jogador jogador = new Jogador();
    Impressao impresso = new Impressao();
    Scanner scanner = new Scanner(System.in);
    String[] nomeJogador = new String[2];
    Mensagens view = new Mensagens();
    public boolean vezBranco = true;

    public ControleTotal(Tabuleiro tab) {
        this.tabuleiro = tab;
    }

    public boolean retornaVezBranco() {
        return vezBranco;
    }

    public void alteraVez() {
        if (vezBranco == true) {
            vezBranco = false;
        } else {
            vezBranco = true;
        }
    }

    public void iniciaMenu() {
        //Pega os nomes dos jogadores e chama o tabuleiro, (lembrar que jogador Um eh o branco)
        //e inicia a partida
        //Mas primeiro exibi as três opções para os jogadores,
        //1ºIniciar nova partida, 2ºDados da partida, 3º Sair.
        impresso.imprimeTipo();
        int dado = scanner.nextInt();
        processaTipo(dado);

    }

    public void controlaJogadas(String jog) {
        String posAtual = "" + jog.charAt(0) + jog.charAt(1);
        String posProx = "" + jog.charAt(2) + jog.charAt(3);
        String peca = tabuleiro.retornaPeca(posAtual).getNome().getApelidoPeca();
        String corPeca = tabuleiro.retornaPeca(posAtual).getCor().toString();
        
        System.out.println("Atual + Prox " + posAtual + posProx);
        
        if (jog.equals("desistir") ) {
            //COLOCA INTELIGENCIA COMPUTANDO PONTO PARA OUTRO JOGADOR
            if (vezBranco == true) {
                jogador.addPontuacao(nomeJogador[1], "v");
                jogador.addPontuacao(nomeJogador[0], "d");
            } else {
                jogador.addPontuacao(nomeJogador[1], "d");
                jogador.addPontuacao(nomeJogador[0], "v");
            }
            vezBranco = true;
            tabuleiro.reiniciaTabuleiro();
            iniciaMenu();

        } else if (jog.equals("empate")) {
            //Se ambos entrarem em acordo, rola um empate               
            alteraVez();
            view.empate(nomeJogador[0], nomeJogador[1], vezBranco);
            String leitura = scanner.next().toUpperCase();
            char desejo = leitura.charAt(0);
            if (desejo == 'N') {
                alteraVez();
                imprimeJogada(nomeJogador[0], nomeJogador[1]);
            } else if (desejo == 'S') {
                jogador.addPontuacao(nomeJogador[0], "e");
                jogador.addPontuacao(nomeJogador[1], "e");
                tabuleiro.reiniciaTabuleiro();
                vezBranco = true;
                iniciaMenu();
            } else {
                view.opcaoInvalida();
                controlaJogadas("empate");
            }

        } //roqueMenor
        else if (jog.length() == 3) {
            System.out.println("Em construção");
            imprimeJogada(nomeJogador[0], nomeJogador[1]);
            alteraVez();
            iniciaMenu();

        } //roque Maior
        else if ((jog.length() == 5) && (jog.charAt(0) == 'O')) {
            System.out.println("Em construção");
            imprimeJogada(nomeJogador[0], nomeJogador[1]);
            alteraVez();
            iniciaMenu();

        }//JOGADA DE CAPTURA 
        else if ((jog.length() == 5) && (jog.charAt(2) == 'x')) {
            String posAtualCaptura = "" + jog.charAt(0) + jog.charAt(1);
            String posProxCaptura = "" + jog.charAt(3) + jog.charAt(4);
            capturaPeca(posAtualCaptura, posProxCaptura, peca, corPeca);

        } //MOVIMENTAÇÂO NORMAL
        else if (jog.length() == 4) {
            movimentaPeca(posAtual, posProx, peca, corPeca);
        } else {
            view.movimentoInvalido();
            imprimeJogada(nomeJogador[0], nomeJogador[1]);

        }

    }

    public void iniciaJogada() {

        impresso.Impressao(tabuleiro);
        if (vezBranco == true) {
            System.out.println("VEZ BRANCO");
        } else {
            System.out.println("VEZ PRETA");
        }
        imprimeJogada(nomeJogador[0], nomeJogador[1]);

    }

    private void processaModoJogo(int dado) {
        if ((dado >= 1) && dado <= 3) {

            switch (dado) {
                case 1:
                    processaJogador();
                    iniciaJogada();
                    break;
                case 2:
                    System.out.println("##ERRO##: Módulo Inativo!!");
                    impresso.imprimeModoJogo();
                    int comando = scanner.nextInt();
                    processaModoJogo(comando);
                    break;
                case 3:
                    System.exit(0);
                    break;

            }
        } else {
            view.entradaInvalida();
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
                    impresso.imprimeDados(jogador.jogadores);
                    impresso.imprimeMenu();
                    comando = scanner.nextInt();
                    processaMenu(comando);
                    break;
                case 3:
                    System.exit(0);
                    break;

            }
        } else {
            view.entradaInvalida();
            iniciaMenu();
        }
    }

    private void imprimeJogada(String jogador1, String jogador2) {
        if (retornaVezBranco() == true) {
            view.jogadaJ1(jogador1);
            //System.out.println("Digite a jogada " + jogador1+ " (B) :");
            String jogada = scanner.next();
            controlaJogadas(jogada);

        } else {
            view.jogadaJ2(jogador2);
            //System.out.println("Digite a jogada "+ jogador2+" (P) :");
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
                    new Visual().show();
                    
                    break;
                case 3:
                    System.exit(0);
                    break;
            }
        } else {
            view.entradaInvalida();
            iniciaMenu();
        }
    }

    //Identificação do jogador, falta implementar outras coiass.
    public void processaJogador() {
        view.nomeJogadorUm();
        nomeJogador[0] = scanner.next().toUpperCase();
        if (!jogador.jogadores.containsKey(nomeJogador[0])) {
            jogador.criaJogador(nomeJogador[0]);
        }
        view.nomeJogadorDois();
        nomeJogador[1] = scanner.next().toUpperCase();
        if (!jogador.jogadores.containsKey(nomeJogador[1])) {
            jogador.criaJogador(nomeJogador[1]);
        }
    }
    
    public void processaJogadorVisual(String j1,String j2) {
        if (!jogador.jogadores.containsKey(j1)) {
            jogador.criaJogador(j1);
        }
        if (!jogador.jogadores.containsKey(j2)) {
            jogador.criaJogador(j2);
        }
    }
    
    public void capturaPeca(String posAtual, String posProx, String peca, String corPeca){
        if ((retornaVezBranco() == true && corPeca.equals("BRANCO")) || (retornaVezBranco() == false && corPeca.equals("PRETO"))) {

            if (peca == " P " && tabuleiro.retornaPeca(posAtual).getCor() == Cor.BRANCO) {//PEAO Branco
                if ((tabuleiro.retornaPeca(posAtual).podeCapturar(posAtual, posProx) == true) && (tabuleiro.retornaPeca(posProx) != null)) {
                    tabuleiro.trocaPeca(posAtual, posProx);
                    alteraVez();
                    iniciaJogada();
                } else {
                    view.movimentoInvalido();
                    imprimeJogada(nomeJogador[0], nomeJogador[1]);
                }
            } else if (peca == " P " && tabuleiro.retornaPeca(posAtual).getCor() == Cor.PRETO) {//PEAO Preto

                if ((tabuleiro.retornaPeca(posAtual).podeCapturar(posAtual, posProx) == true) && (tabuleiro.retornaPeca(posProx) != null)) {
                    tabuleiro.trocaPeca(posAtual, posProx);
                    alteraVez();
                    iniciaJogada();
                } else {
                    view.movimentoInvalido();
                    imprimeJogada(nomeJogador[0], nomeJogador[1]);
                }
            } else if (peca == " T ") {//TORRE
                //movimenta
                if ((tabuleiro.retornaPeca(posAtual).podeCapturar(posAtual, posProx) == true) && (tabuleiro.retornaPeca(posProx) != null)) {
                    tabuleiro.trocaPeca(posAtual, posProx);
                    alteraVez();
                    iniciaJogada();
                } else {
                    view.movimentoInvalido();
                    imprimeJogada(nomeJogador[0], nomeJogador[1]);
                }
            } else if (peca == " C ") {//CAVALO
                //movimenta 
                if ((tabuleiro.retornaPeca(posAtual).podeCapturar(posAtual, posProx) == true) && (tabuleiro.retornaPeca(posProx) != null)) {
                    tabuleiro.trocaPeca(posAtual, posProx);
                    iniciaJogada();
                    alteraVez();
                } else {
                    view.movimentoInvalido();
                    imprimeJogada(nomeJogador[0], nomeJogador[1]);
                }
            } else if (peca == " B ") {//BISPO
                //Movimento
                if ((tabuleiro.retornaPeca(posAtual).podeCapturar(posAtual, posProx) == true) && (tabuleiro.retornaPeca(posProx) != null)) {
                    tabuleiro.trocaPeca(posAtual, posProx);
                    alteraVez();
                    iniciaJogada();
                } else {
                    view.movimentoInvalido();
                    imprimeJogada(nomeJogador[0], nomeJogador[1]);
                }
            } else if (peca == " D ") {//DAMA
                //movimenta
                if ((tabuleiro.retornaPeca(posAtual).podeCapturar(posAtual, posProx) == true) && (tabuleiro.retornaPeca(posProx) != null)) {
                    tabuleiro.trocaPeca(posAtual, posProx);
                    alteraVez();
                    iniciaJogada();
                } else {
                    view.movimentoInvalido();
                    imprimeJogada(nomeJogador[0], nomeJogador[1]);
                }
            } else if (peca == " R ") {//REI
                //movimenta 
                if ((tabuleiro.retornaPeca(posAtual).podeCapturar(posAtual, posProx) == true) && (tabuleiro.retornaPeca(posProx) != null)) {
                    tabuleiro.trocaPeca(posAtual, posProx);
                    alteraVez();
                    iniciaJogada();
                } else {
                    view.movimentoInvalido();
                    imprimeJogada(nomeJogador[0], nomeJogador[1]);
                }
            } else {
                view.opcaoInvalida();
                imprimeJogada(nomeJogador[0], nomeJogador[1]);
            }
        } else {
            //pos atual nao é a peca do jogador da vez
            view.naoEhSuaVez();
            imprimeJogada(nomeJogador[0], nomeJogador[1]);
        }
    }

    public void movimentaPeca(String posAtual, String posProx, String peca, String corPeca){
        
        //Alguma situações não trocava a peça, acho que resolvi adicionando alteraVez() nas outras peças
            System.out.println(tabuleiro.retornaPeca(posAtual));

            if ((retornaVezBranco() == true && corPeca.equals("BRANCO")) || (retornaVezBranco() == false && corPeca.equals("PRETO"))) {

                if (peca == " P " && tabuleiro.retornaPeca(posAtual).getCor() == Cor.BRANCO) {//PEAO Branco
                    if ((tabuleiro.retornaPeca(posAtual).podeAndarQuanto(posAtual, posProx) == true) && caminhoLivre(posAtual, posProx, peca, corPeca)) {
                        tabuleiro.trocaPeca(posAtual, posProx);
                        alteraVez();
                        iniciaJogada();
                    } else {
                        view.movimentoInvalido();
                        imprimeJogada(nomeJogador[0], nomeJogador[1]);
                    }
                } else if (peca == " P " && tabuleiro.retornaPeca(posAtual).getCor() == Cor.PRETO) {//PEAO Preto

                    if ((tabuleiro.retornaPeca(posAtual).podeAndarQuanto(posAtual, posProx) == true) && (tabuleiro.retornaPeca(posProx) == null)) {
                        tabuleiro.trocaPeca(posAtual, posProx);
                        alteraVez();
                        iniciaJogada();
                    } else {
                        view.movimentoInvalido();
                        imprimeJogada(nomeJogador[0], nomeJogador[1]);
                    }
                } else if (peca == " T ") {//TORRE
                    //movimenta
                    if ((tabuleiro.retornaPeca(posAtual).podeAndarQuanto(posAtual, posProx) == true) && (tabuleiro.retornaPeca(posProx) == null)) {
                        tabuleiro.trocaPeca(posAtual, posProx);
                        alteraVez();
                        iniciaJogada();
                    } else {
                        view.movimentoInvalido();
                        imprimeJogada(nomeJogador[0], nomeJogador[1]);
                    }
                } else if (peca == " C ") {//CAVALO
                    //movimenta 
                    if ((tabuleiro.retornaPeca(posAtual).podeAndarQuanto(posAtual, posProx) == true) && (tabuleiro.retornaPeca(posProx) == null)) {
                        tabuleiro.trocaPeca(posAtual, posProx);
                        alteraVez();
                        iniciaJogada();
                    } else {
                        view.movimentoInvalido();
                        imprimeJogada(nomeJogador[0], nomeJogador[1]);
                    }
                } else if (peca == " B ") {//BISPO
                    //Movimento
                    if ((tabuleiro.retornaPeca(posAtual).podeAndarQuanto(posAtual, posProx) == true) && (tabuleiro.retornaPeca(posProx) == null)) {
                        tabuleiro.trocaPeca(posAtual, posProx);
                        alteraVez();
                        iniciaJogada();
                    } else {
                        view.movimentoInvalido();
                        imprimeJogada(nomeJogador[0], nomeJogador[1]);
                    }
                } else if (peca == " D ") {//DAMA
                    //movimenta
                    if ((tabuleiro.retornaPeca(posAtual).podeAndarQuanto(posAtual, posProx) == true) && (tabuleiro.retornaPeca(posProx) == null)) {
                        tabuleiro.trocaPeca(posAtual, posProx);
                        alteraVez();
                        iniciaJogada();
                    } else {
                        view.movimentoInvalido();
                        imprimeJogada(nomeJogador[0], nomeJogador[1]);
                    }
                } else if (peca == " R ") {//REI
                    //movimenta 
                    if ((tabuleiro.retornaPeca(posAtual).podeAndarQuanto(posAtual, posProx) == true) && (tabuleiro.retornaPeca(posProx) == null)) {
                        tabuleiro.trocaPeca(posAtual, posProx);
                        alteraVez();
                        iniciaJogada();
                    } else {
                        view.movimentoInvalido();
                        imprimeJogada(nomeJogador[0], nomeJogador[1]);
                    }
                } else {
                    view.opcaoInvalida();
                    imprimeJogada(nomeJogador[0], nomeJogador[1]);
                }
            } else {
                //pos atual nao é a peca do jogador da vez
                view.naoEhSuaVez();
                imprimeJogada(nomeJogador[0], nomeJogador[1]);
            }
        
    }
    
    
    public boolean caminhoLivre(String posAtual, String posProx, String peca, String corPeca){
        //Branco Peão
        int i;
        String posAtualAux = posAtual;
        //String posProxAux = posProx;
        boolean podeIr = false;
        if (peca == " P " && tabuleiro.retornaPeca(posAtual).getCor() == Cor.BRANCO){
            for(i=3;i < 9; i++){

                posAtualAux = ""+posAtual.charAt(0)+ i;

                podeIr = tabuleiro.retornaPeca(posAtualAux) == null;
                
                if(posAtualAux.equals(posProx)){
                    break;
                }
             }
             return podeIr;   
        }
        //Preto Peão
        
        //Resto
        return false;
    }

}
