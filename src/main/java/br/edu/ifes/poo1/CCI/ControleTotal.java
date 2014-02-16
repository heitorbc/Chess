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
    public boolean textual = true;

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
        String dado = scanner.nextLine();
        processaTipo(dado);

    }

    public void controlaJogadas(String jog) {

        //CONTROLA JOGADAS TEXTUAIS
        if (jog.equals("desistir") || jog.equals("DESISTIR")) {
            //COLOCA PONTO PARA JOGADORES

            if (vezBranco == true) {
                jogador.addPontuacao(nomeJogador[1], "v");
                jogador.addPontuacao(nomeJogador[0], "d");

            } else {
                jogador.addPontuacao(nomeJogador[1], "d");
                jogador.addPontuacao(nomeJogador[0], "v");
            }

            vezBranco = true;
            tabuleiro.reiniciaTabuleiro();
            if (textual == false) {
                new Visual().fechaTela();
            }
            iniciaMenu();

        } else if (jog.equals("empate") || jog.equals("EMPATE")) {
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
            //CONTROLA JOGADAS DE XADREZ
        } else {
            if (jog.length() == 3) {
                System.out.println("Em construção");
                imprimeJogada(nomeJogador[0], nomeJogador[1]);
                alteraVez();
                iniciaMenu();

            } //roque Maior

            //roqueMenor
            if ((jog.length() == 5) && (jog.charAt(0) == 'O')) {
                System.out.println("Em construção");
                imprimeJogada(nomeJogador[0], nomeJogador[1]);
                alteraVez();
                iniciaMenu();

            }

            String posAtual = "" + jog.charAt(0) + jog.charAt(1);
            String posProx = "" + jog.charAt(2) + jog.charAt(3);
            String peca = "";
            String corPeca = "";
            try {
                peca = tabuleiro.retornaPeca(posAtual).getNome().getApelidoPeca();
                corPeca = tabuleiro.retornaPeca(posAtual).getCor().toString();
            } catch (Exception e) {
                view.entradaInvalida();
                imprimeJogada(nomeJogador[0], nomeJogador[1]);
            }
            //JOGADA DE CAPTURA 
            if ((jog.length() == 5) && (jog.charAt(2) == 'x')) {
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
    }

    public void iniciaJogada() {
        if (textual == true) {
            impresso.Impressao(tabuleiro);
            if (vezBranco == true) {
                System.out.println("VEZ BRANCO");
            } else {
                System.out.println("VEZ PRETA");
            }
            imprimeJogada(nomeJogador[0], nomeJogador[1]);

        }
    }

    private void processaModoJogo(String dado) {
        if ((dado.equals("1")) || (dado.equals("2")) || (dado.equals("3"))) {

            switch (dado) {
                case "1":
                    processaJogador();
                    iniciaJogada();
                    break;
                case "2":
                    System.out.println("##ERRO##: Módulo Inativo!!");
                    impresso.imprimeModoJogo();
                    String comando = scanner.nextLine();
                    processaModoJogo(comando);
                    break;
                case "3":
                    System.exit(0);
                    break;

            }
        } else {
            view.entradaInvalida();
            impresso.imprimeModoJogo();
            String comando = scanner.nextLine();
            processaModoJogo(comando);
        }
    }

    private void processaMenu(String dado) {
        if ((dado.equals("1")) || (dado.equals("2")) || (dado.equals("3"))) {

            switch (dado) {
                case "1":
                    impresso.imprimeModoJogo();
                    String comando = scanner.nextLine();
                    processaModoJogo(comando);
                    break;
                case "2":
                    impresso.imprimeDados(jogador.jogadores);
                    impresso.imprimeMenu();
                    comando = scanner.nextLine();
                    processaMenu(comando);
                    break;
                case "3":
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

    private void processaTipo(String dado) {
        if ((dado.equals("1")) || (dado.equals("2")) || (dado.equals("3"))) {
            switch (dado) {
                case "1":
                    impresso.imprimeMenu();
                    String comando = scanner.nextLine();
                    processaMenu(comando);
                    break;
                case "2":
                    new Visual().show();
                    textual = false;
                    break;
                case "3":
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

    public void processaJogadorVisual(String j1, String j2) {
        if (!jogador.jogadores.containsKey(j1)) {
            nomeJogador[0] = j1;
            jogador.criaJogador(j1);
        }
        if (!jogador.jogadores.containsKey(j2)) {
            nomeJogador[1] = j2;
            jogador.criaJogador(j2);
        }
    }

    public void capturaPeca(String posAtual, String posProx, String peca, String corPeca) {
        if ((retornaVezBranco() == true && corPeca.equals("BRANCO")) || (retornaVezBranco() == false && corPeca.equals("PRETO"))) {

            if (peca == " P " && tabuleiro.retornaPeca(posAtual).getCor() == Cor.BRANCO) {//PEAO Branco
                if ((tabuleiro.retornaPeca(posAtual).podeCapturar(posAtual, posProx) == true) && (tabuleiro.retornaPeca(posProx) != null)) {
                    tabuleiro.trocaPeca(posAtual, posProx);
                    alteraVez();
                    iniciaJogada();
                } else {
                    if (textual == true) {
                        view.movimentoInvalido();
                        imprimeJogada(nomeJogador[0], nomeJogador[1]);
                    }
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
                    if (textual == true) {
                        view.movimentoInvalido();
                        imprimeJogada(nomeJogador[0], nomeJogador[1]);
                    }
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

    public void movimentaPeca(String posAtual, String posProx, String peca, String corPeca) {

        //Alguma situações não trocava a peça, acho que resolvi adicionando alteraVez() nas outras peças
        System.out.println(tabuleiro.retornaPeca(posAtual));

        if ((retornaVezBranco() == true && corPeca.equals("BRANCO")) || (retornaVezBranco() == false && corPeca.equals("PRETO"))) {

            if (peca == " P " && tabuleiro.retornaPeca(posAtual).getCor() == Cor.BRANCO) {//PEAO Branco
                if ((tabuleiro.retornaPeca(posAtual).podeAndarQuanto(posAtual, posProx) == true) && (tabuleiro.retornaPeca(posProx) == null) && caminhoLivre(posAtual, posProx, peca, corPeca)) {
                    tabuleiro.trocaPeca(posAtual, posProx);
                    alteraVez();
                    iniciaJogada();
                } else {
                    view.movimentoInvalido();
                    imprimeJogada(nomeJogador[0], nomeJogador[1]);
                }
            } else if (peca == " P " && tabuleiro.retornaPeca(posAtual).getCor() == Cor.PRETO) {//PEAO Preto

                if ((tabuleiro.retornaPeca(posAtual).podeAndarQuanto(posAtual, posProx) == true) && (tabuleiro.retornaPeca(posProx) == null) && caminhoLivre(posAtual, posProx, peca, corPeca)) {
                    tabuleiro.trocaPeca(posAtual, posProx);
                    alteraVez();
                    iniciaJogada();
                } else {
                    view.movimentoInvalido();
                    imprimeJogada(nomeJogador[0], nomeJogador[1]);
                }
            } else if (peca == " T ") {//TORRE
                //movimenta
                if ((tabuleiro.retornaPeca(posAtual).podeAndarQuanto(posAtual, posProx) == true) && (tabuleiro.retornaPeca(posProx) == null) && caminhoLivre(posAtual, posProx, peca, corPeca)) {
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
                if ((tabuleiro.retornaPeca(posAtual).podeAndarQuanto(posAtual, posProx) == true) && (tabuleiro.retornaPeca(posProx) == null) && caminhoLivre(posAtual, posProx, peca, corPeca)) {
                    tabuleiro.trocaPeca(posAtual, posProx);
                    alteraVez();
                    iniciaJogada();
                } else {
                    view.movimentoInvalido();
                    imprimeJogada(nomeJogador[0], nomeJogador[1]);
                }
            } else if (peca == " D ") {//DAMA
                //movimenta
                if ((tabuleiro.retornaPeca(posAtual).podeAndarQuanto(posAtual, posProx) == true) && (tabuleiro.retornaPeca(posProx) == null) && caminhoLivre(posAtual, posProx, peca, corPeca)) {
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

    public boolean caminhoLivre(String posAtual, String posProx, String peca, String corPeca) {
        //Branco Peão
        int i, j;
        String posAtualAux = posAtual;
        String posProxAux = posProx;
        int nposAtual, nposProx, nposProx1, nposAtual1;

        boolean podeIr = false;

        if (peca == " P " && tabuleiro.retornaPeca(posAtual).getCor() == Cor.BRANCO) {
            nposAtual = Character.getNumericValue(posAtual.charAt(0));
            nposAtual1 = Character.getNumericValue(posAtual.charAt(1));
            nposProx1 = Character.getNumericValue(posProx.charAt(1));
            nposAtual1++;
            if ((posAtual.charAt(0) == posProx.charAt(0)) && (posAtual.charAt(1) < posProx.charAt(1))) {
                while (!posAtualAux.equals(posProx)) {
                    posAtualAux = "" + nposAtual + nposAtual1;
                    podeIr = tabuleiro.retornaPeca(posAtualAux) == null;
                    if (podeIr == false) {
                        return podeIr;
                    }
                    nposAtual1++;
                }
                return podeIr;
            }

        } //Preto Peão
        else if (peca == " P " && tabuleiro.retornaPeca(posAtual).getCor() == Cor.PRETO) {
            nposAtual = Character.getNumericValue(posAtual.charAt(0));
            nposAtual1 = Character.getNumericValue(posAtual.charAt(1));
            nposProx1 = Character.getNumericValue(posProx.charAt(1));
            nposAtual1--;
            if ((posAtual.charAt(0) == posProx.charAt(0)) && (posAtual.charAt(1) > posProx.charAt(1))) {
                while (!posAtualAux.equals(posProx)) {
                    posAtualAux = "" + nposAtual + nposAtual1;
                    podeIr = tabuleiro.retornaPeca(posAtualAux) == null;
                    if (podeIr == false) {
                        return podeIr;
                    }
                    nposAtual1--;
                }
                return podeIr;
            }
        }//Torre
        else if (peca == " T ") {

            //Vertical
            if (posAtual.charAt(0) == posProx.charAt(0)) {
                //Movimento de baixo para cima
                if (posAtual.charAt(1) < posProx.charAt(1)) {
                    //convertendo Char para Int
                    nposAtual = Character.getNumericValue(posAtual.charAt(1));
                    nposAtual++;
                    nposProx = Character.getNumericValue(posProx.charAt(1));

                    for (i = nposAtual; i <= nposProx; i++) {
                        posAtualAux = "" + posAtual.charAt(0) + i;
                        podeIr = tabuleiro.retornaPeca(posAtualAux) == null;
                        if (podeIr == false) {
                            return podeIr;
                        }
                    }
                    return podeIr;

                } else//Movimento de baixo para cima
                if (posAtual.charAt(1) > posProx.charAt(1)) {
                    //convertendo Char para Int
                    nposAtual = Character.getNumericValue(posAtual.charAt(1));
                    nposAtual--;
                    nposProx = Character.getNumericValue(posProx.charAt(1));

                    for (i = nposAtual; i >= nposProx; i--) {
                        posAtualAux = "" + posAtual.charAt(0) + i;
                        podeIr = tabuleiro.retornaPeca(posAtualAux) == null;
                        if (podeIr == false) {
                            return podeIr;
                        }
                    }
                    return podeIr;

                }

            }

            //HORIZONTAL
            if (posAtual.charAt(1) == posProx.charAt(1)) {
                //Movimento esquerda para direita
                if (posAtual.charAt(0) < posProx.charAt(0)) {
                    //convertendo Char para Int
                    nposAtual = Character.getNumericValue(posAtual.charAt(0));
                    nposAtual++;
                    nposProx = Character.getNumericValue(posProx.charAt(0));

                    for (i = nposAtual; i <= nposProx; i++) {
                        posAtualAux = "" + i + posAtual.charAt(1);
                        podeIr = tabuleiro.retornaPeca(posAtualAux) == null;
                        if (podeIr == false) {
                            return podeIr;
                        }
                    }
                    return podeIr;

                } else//Movimento da direita para esquerda
                if (posAtual.charAt(0) > posProx.charAt(0)) {
                    //convertendo Char para Int
                    nposAtual = Character.getNumericValue(posAtual.charAt(0));
                    nposAtual--;
                    nposProx = Character.getNumericValue(posProx.charAt(0));

                    for (i = nposAtual; i >= nposProx; i--) {
                        posAtualAux = "" + i + posAtual.charAt(1);
                        podeIr = tabuleiro.retornaPeca(posAtualAux) == null;
                        if (podeIr == false) {
                            return podeIr;
                        }
                    }
                    return podeIr;

                }

            }

        }//BISPO
        else if (peca == " B ") {
            nposAtual = Character.getNumericValue(posAtual.charAt(0));
            nposAtual1 = Character.getNumericValue(posAtual.charAt(1));

            //Diagonal para direita
            //de baixo para cima
            if ((posAtual.charAt(0) < posProx.charAt(0)) && (posAtual.charAt(1) < posProx.charAt(1))) {
                nposAtual++;
                nposAtual1++;
                while (!posAtualAux.equals(posProx)) {
                    posAtualAux = "" + nposAtual + nposAtual1;
                    podeIr = tabuleiro.retornaPeca(posAtualAux) == null;
                    if (podeIr == false) {
                        return podeIr;
                    }
                    nposAtual++;
                    nposAtual1++;
                }
                return podeIr;
            }
            //de cima para baixo
            if ((posAtual.charAt(0) < posProx.charAt(0)) && (posAtual.charAt(1) > posProx.charAt(1))) {
                nposAtual++;
                nposAtual1--;
                while (!posAtualAux.equals(posProx)) {
                    posAtualAux = "" + nposAtual + nposAtual1;
                    podeIr = tabuleiro.retornaPeca(posAtualAux) == null;
                    if (podeIr == false) {
                        return podeIr;
                    }
                    nposAtual++;
                    nposAtual1--;
                }
                return podeIr;
            }
            //Diagonal para esquerda
            //de baixo para cima
            if ((posAtual.charAt(0) > posProx.charAt(0)) && (posAtual.charAt(1) < posProx.charAt(1))) {
                nposAtual--;
                nposAtual1++;
                while (!posAtualAux.equals(posProx)) {
                    posAtualAux = "" + nposAtual + nposAtual1;
                    podeIr = tabuleiro.retornaPeca(posAtualAux) == null;
                    if (podeIr == false) {
                        return podeIr;
                    }
                    nposAtual--;
                    nposAtual1++;
                }
                return podeIr;
            }

            //de cima para baixo
            if ((posAtual.charAt(0) > posProx.charAt(0)) && (posAtual.charAt(1) > posProx.charAt(1))) {
                nposAtual--;
                nposAtual1--;
                while (!posAtualAux.equals(posProx)) {
                    posAtualAux = "" + nposAtual + nposAtual1;
                    podeIr = tabuleiro.retornaPeca(posAtualAux) == null;
                    if (podeIr == false) {
                        return podeIr;
                    }
                    nposAtual--;
                    nposAtual1--;
                }
                return podeIr;
            }
        }//DAMA
        else if (peca == " D ") {
            //DAMA ADNDANDO COMO TORRE
            //Vertical
            if (posAtual.charAt(0) == posProx.charAt(0)) {
                //Movimento de baixo para cima
                if (posAtual.charAt(1) < posProx.charAt(1)) {
                    //convertendo Char para Int
                    nposAtual = Character.getNumericValue(posAtual.charAt(1));
                    nposAtual++;
                    nposProx = Character.getNumericValue(posProx.charAt(1));

                    for (i = nposAtual; i <= nposProx; i++) {
                        posAtualAux = "" + posAtual.charAt(0) + i;
                        podeIr = tabuleiro.retornaPeca(posAtualAux) == null;
                        if (podeIr == false) {
                            return podeIr;
                        }
                    }
                    return podeIr;

                } else//Movimento de baixo para cima
                if (posAtual.charAt(1) > posProx.charAt(1)) {
                    //convertendo Char para Int
                    nposAtual = Character.getNumericValue(posAtual.charAt(1));
                    nposAtual--;
                    nposProx = Character.getNumericValue(posProx.charAt(1));

                    for (i = nposAtual; i >= nposProx; i--) {
                        posAtualAux = "" + posAtual.charAt(0) + i;
                        podeIr = tabuleiro.retornaPeca(posAtualAux) == null;
                        if (podeIr == false) {
                            return podeIr;
                        }
                    }
                    return podeIr;

                }

            }

            //HORIZONTAL
            if (posAtual.charAt(1) == posProx.charAt(1)) {
                //Movimento esquerda para direita
                if (posAtual.charAt(0) < posProx.charAt(0)) {
                    //convertendo Char para Int
                    nposAtual = Character.getNumericValue(posAtual.charAt(0));
                    nposAtual++;
                    nposProx = Character.getNumericValue(posProx.charAt(0));

                    for (i = nposAtual; i <= nposProx; i++) {
                        posAtualAux = "" + i + posAtual.charAt(1);
                        podeIr = tabuleiro.retornaPeca(posAtualAux) == null;
                        if (podeIr == false) {
                            return podeIr;
                        }
                    }
                    return podeIr;

                } else//Movimento da direita para esquerda
                if (posAtual.charAt(0) > posProx.charAt(0)) {
                    //convertendo Char para Int
                    nposAtual = Character.getNumericValue(posAtual.charAt(0));
                    nposAtual--;
                    nposProx = Character.getNumericValue(posProx.charAt(0));

                    for (i = nposAtual; i >= nposProx; i--) {
                        posAtualAux = "" + i + posAtual.charAt(1);
                        podeIr = tabuleiro.retornaPeca(posAtualAux) == null;
                        if (podeIr == false) {
                            return podeIr;
                        }
                    }
                    return podeIr;

                }

            }
            //DAMA ANDANDO COMO BISPO
            nposAtual = Character.getNumericValue(posAtual.charAt(0));
            nposAtual1 = Character.getNumericValue(posAtual.charAt(1));

            //Diagonal para direita
            //de baixo para cima
            if ((posAtual.charAt(0) < posProx.charAt(0)) && (posAtual.charAt(1) < posProx.charAt(1))) {
                nposAtual++;
                nposAtual1++;
                while (!posAtualAux.equals(posProx)) {
                    posAtualAux = "" + nposAtual + nposAtual1;
                    podeIr = tabuleiro.retornaPeca(posAtualAux) == null;
                    if (podeIr == false) {
                        return podeIr;
                    }
                    nposAtual++;
                    nposAtual1++;
                }
                return podeIr;
            }
            //de cima para baixo
            if ((posAtual.charAt(0) < posProx.charAt(0)) && (posAtual.charAt(1) > posProx.charAt(1))) {
                nposAtual++;
                nposAtual1--;
                while (!posAtualAux.equals(posProx)) {
                    posAtualAux = "" + nposAtual + nposAtual1;
                    podeIr = tabuleiro.retornaPeca(posAtualAux) == null;
                    if (podeIr == false) {
                        return podeIr;
                    }
                    nposAtual++;
                    nposAtual1--;
                }
                return podeIr;
            }
            //Diagonal para esquerda
            //de baixo para cima
            if ((posAtual.charAt(0) > posProx.charAt(0)) && (posAtual.charAt(1) < posProx.charAt(1))) {
                nposAtual--;
                nposAtual1++;
                while (!posAtualAux.equals(posProx)) {
                    posAtualAux = "" + nposAtual + nposAtual1;
                    podeIr = tabuleiro.retornaPeca(posAtualAux) == null;
                    if (podeIr == false) {
                        return podeIr;
                    }
                    nposAtual--;
                    nposAtual1++;
                }
                return podeIr;
            }

            //de cima para baixo
            if ((posAtual.charAt(0) > posProx.charAt(0)) && (posAtual.charAt(1) > posProx.charAt(1))) {
                nposAtual--;
                nposAtual1--;
                while (!posAtualAux.equals(posProx)) {
                    posAtualAux = "" + nposAtual + nposAtual1;
                    podeIr = tabuleiro.retornaPeca(posAtualAux) == null;
                    if (podeIr == false) {
                        return podeIr;
                    }
                    nposAtual--;
                    nposAtual1--;
                }
                return podeIr;
            }

        }

        //Resto deu Merda
        view.deuMerda();
        return false;
    }

}
