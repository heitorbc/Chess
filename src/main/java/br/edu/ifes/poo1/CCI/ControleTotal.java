/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.poo1.CCI;

import br.edu.ifes.poo1.CDP.Azureus;
import br.edu.ifes.poo1.CDP.Jogador;
import br.edu.ifes.poo1.CDP.Partida;
import br.edu.ifes.poo1.CDP.Tabuleiro;
import br.edu.ifes.poo1.CGD.Dados;
import br.edu.ifes.poo1.CIH.Impressao;
import br.edu.ifes.poo1.CIH.Mensagens;
import br.edu.ifes.poo1.CIH.Visual;
import br.edu.ifes.poo1.util.Cor;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author 20121BSI0082
 */
public class ControleTotal implements Serializable {

    //ExibeMEnu
    private Visual tela = null;
    private Tabuleiro tabuleiro = new Tabuleiro();
    public Jogador jogador = new Jogador();
    private Impressao impresso = new Impressao();
    private Scanner scanner = new Scanner(System.in);
    public String[] nomeJogador = new String[2];
    private Mensagens view = new Mensagens();
    private Azureus az = new Azureus();
    private Dados dados = new Dados();
    private ArrayList<Partida> partidas = new ArrayList<>();
    private boolean vezBranco = true;
    private boolean textual = true;

    public boolean isVezBranco() {
        return vezBranco;
    }

    public void setVezBranco(boolean vezBranco) {
        this.vezBranco = vezBranco;
    }

    public boolean isTextual() {
        return textual;
    }

    public void setTextual(boolean textual) {
        this.textual = textual;
    }

    public ControleTotal(Tabuleiro tab) {
        tela = new Visual(tab, this);
        this.tabuleiro = tab;
        tela.setVisible(false);

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

    public void iniciaMenu() throws ClassNotFoundException {

        impresso.imprimeTipo();
        String entrada = scanner.nextLine();
        processaTipo(entrada);

    }

    public void controlaJogadas(String jog) throws ClassNotFoundException {
        //CONTROLA JOGADAS TEXTUAIS
        if (jog.equals("salvar") || jog.equals("SALVAR")) {
            // Salva de uma vez, tabuleiro com o estado atual + os Jogadores em questão.
            //Como passar cada jogador?
            Partida partidaAtual = new Partida(tabuleiro, nomeJogador[0], jogador.retornaPontos(nomeJogador[0]), nomeJogador[1], jogador.retornaPontos(nomeJogador[1]), vezBranco);
            salvarPartida(partidaAtual);
            if (textual == true) {
                scanner.nextLine();
            }
            iniciaMenu();

            //Sair da partida = desistir   
        } else if (jog.equals("desistir") || jog.equals("DESISTIR")) {
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
            if (textual == true) {
                scanner.nextLine();
            }
            iniciaMenu();

        } else if (jog.equals("empate") || jog.equals("EMPATE")) {
            //Se ambos entrarem em acordo, rola um empate               

            if (textual == true) {
                alteraVez();
                view.empate(nomeJogador[0], nomeJogador[1], vezBranco);
                String leitura = scanner.next().toUpperCase();
                char desejo = leitura.charAt(0);
                if (desejo == 'N') {
                    alteraVez();
                    processaJogada(nomeJogador[0], nomeJogador[1]);
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
            } else {
                jogador.addPontuacao(nomeJogador[0], "e");
                jogador.addPontuacao(nomeJogador[1], "e");
                tabuleiro.reiniciaTabuleiro();
                vezBranco = true;
                scanner.nextLine();
                iniciaMenu();
            }

        } else {
            //CONTROLA JOGADAS DE XADREZ
            //roques
            if ((jog.equals("O-O-O")) || (jog.equals("O-O"))) {

                if (realizaRoques(jog) == true) {

                    alteraVez();
                    iniciaJogada();

                } else {
                    if (textual == true) {
                        view.movimentoInvalido();
                        processaJogada(nomeJogador[0], nomeJogador[1]);
                    }
                }
                //jogada de XEQUE
            }
            String posAtual = "";
            String posProx = "";
            String peca = "";
            String corPeca = "";
            try {
                posAtual = "" + jog.charAt(0) + jog.charAt(1);
                posProx = "" + jog.charAt(2) + jog.charAt(3);
                peca = tabuleiro.retornaPeca(posAtual).getNome().getApelidoPeca();
                corPeca = tabuleiro.retornaPeca(posAtual).getCor().toString();
            } catch (Exception e) {
                view.entradaInvalida();
                processaJogada(nomeJogador[0], nomeJogador[1]);
            }

            if ((jog.length() == 5) && (jog.charAt(4) == '+')) {
                //movimentaPeca(posAtual, posProx, peca, corPeca);
                if ((tabuleiro.retornaPeca(posAtual).podeAndarQuanto(posAtual, posProx) && tabuleiro.retornaPeca(posProx) == null)) {
                    tabuleiro.trocaPeca(posAtual, posProx);
                }
                if (textual == true) {
                    view.imprimeXeque();
                } else {
                    tela.alertaReiemXeque();
                }
                alteraVez();
                realizaXeque(posProx);

            }//XEQUE MATE #####
            else if ((jog.length() == 5) && (jog.charAt(4) == '#') && (tabuleiro.retornaPeca(posProx) != null)) {
                if (tabuleiro.retornaPeca(posProx).getNome().toString().equals(" K ")) {
                    tabuleiro.trocaPeca(posAtual, posProx);
                    realizaXequeMate();
                }

            } //antiga posicao try
            //JOGADA DE CAPTURA 
            else if ((jog.length() == 5) && (jog.charAt(2) == 'x')) {
                String posAtualCaptura = "" + jog.charAt(0) + jog.charAt(1);
                String posProxCaptura = "" + jog.charAt(3) + jog.charAt(4);
                capturaPeca(posAtualCaptura, posProxCaptura, peca, corPeca);

            } //MOVIMENTAÇÂO NORMAL
            else if (jog.length() == 4) {
                //System.out.println("entrou movimento normal peca");
                movimentaPeca(posAtual, posProx, peca, corPeca);

            } else {//erro de movimentação = JOGADA INVALIDA
                if (textual == true) {
                    view.movimentoInvalido();
                    processaJogada(nomeJogador[0], nomeJogador[1]);
                }
            }
        }
    }

    public void iniciaJogada() throws ClassNotFoundException {
        String jog;
        if (textual == true) {
            impresso.Impressao(tabuleiro);
            view.imprimeVez(vezBranco);
            if ((!nomeJogador[1].equals("AZUREUS")) || (vezBranco)) {
                processaJogada(nomeJogador[0], nomeJogador[1]);
            } else {

                jog = az.processaJogadaAzureus(tabuleiro, this);
                view.imprimeFrase(jog);
                controlaJogadas(jog);

            }
        }
    }

    private void processaModoJogo(String dado) throws ClassNotFoundException {
        if ((dado.equals("1")) || (dado.equals("2")) || (dado.equals("3"))) {

            switch (dado) {
                case "1":
                    processaJogador();
                    iniciaJogada();
                    break;
                case "2":
                    processaJogadorAzureus();
                    iniciaJogada();
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

    private void processaMenu(String dado) throws ClassNotFoundException {
        if ((dado.equals("1")) || (dado.equals("2")) || (dado.equals("3")) || (dado.equals("4"))) {

            switch (dado) {
                case "1":
                    impresso.imprimeModoJogo();
                    String comando = scanner.nextLine();
                    processaModoJogo(comando);
                    break;
                case "2":
                    //RETOMAR PARTIDA
                    // 1 fazer load das partidas
                    // 2 imprimir partidas disponiveis
                    // 3 setar partida selecionada (tabuleiro, jogador, vez)
                    int contador=1;
                    partidas = dados.loadPartida();
                    view.imprimeEscolhaPartida();
                        for(Partida p: partidas){
                            view.imprimeDadosPartida(contador,p);
                            contador++;
                        }
                    impresso.imprimeMenu();
                    comando = scanner.nextLine();
                    processaMenu(comando);
                    break;
                case "3":
                    impresso.imprimeDados(jogador.getJogadores());
                    impresso.imprimeMenu();
                    comando = scanner.nextLine();
                    processaMenu(comando);
                    break;
                case "4":
                    System.exit(0);
                    break;

            }
        } else {
            view.entradaInvalida();
            impresso.imprimeMenu();
            String comando = scanner.nextLine();
            processaMenu(comando);
        }
    }

    private void processaJogada(String jogador1, String jogador2) throws ClassNotFoundException {
        if (retornaVezBranco() == true) {
            view.jogadaJ1(jogador1);
            String jogada = scanner.next();
            controlaJogadas(jogada);

        } else {
            view.jogadaJ2(jogador2);
            String jogada = scanner.next();
            controlaJogadas(jogada);
        }

    }

    private void processaTipo(String dado) throws ClassNotFoundException {
        if ((dado.equals("1")) || (dado.equals("2")) || (dado.equals("3"))) {
            String comando = "";
            switch (dado) {
                case "1":
                    textual = true;
                    impresso.imprimeMenu();
                    comando = scanner.nextLine();
                    processaMenu(comando);
                    break;
                case "2":
                    tela.setVisible(true);
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

    public void processaJogadorAzureus() {
        view.nomeJogadorUm();
        nomeJogador[0] = scanner.next().toUpperCase();
        if (!jogador.getJogadores().containsKey(nomeJogador[0])) {
            jogador.criaJogador(nomeJogador[0]);
        }
        nomeJogador[1] = "AZUREUS";
        if (!jogador.getJogadores().containsKey(nomeJogador[1])) {
            jogador.criaJogador(nomeJogador[1]);
        }
    }

    public void processaJogador() {

        view.nomeJogadorUm();
        nomeJogador[0] = scanner.next().toUpperCase();
        if (!jogador.getJogadores().containsKey(nomeJogador[0])) {
            jogador.criaJogador(nomeJogador[0]);
        }
        view.nomeJogadorDois();
        nomeJogador[1] = scanner.next().toUpperCase();
        if (!jogador.getJogadores().containsKey(nomeJogador[1])) {
            jogador.criaJogador(nomeJogador[1]);
        }
    }

    public void processaJogadorVisual(String j1, String j2) {
        nomeJogador[0] = j1;
        nomeJogador[1] = j2;
        if (!jogador.getJogadores().containsKey(nomeJogador[1])) {
            jogador.criaJogador(nomeJogador[0]);
        }
        if (!jogador.getJogadores().containsKey(nomeJogador[1])) {
            jogador.criaJogador(nomeJogador[1]);
        }
    }

    public void capturaPeca(String posAtual, String posProx, String peca, String corPeca) throws ClassNotFoundException {
        if ((retornaVezBranco() == true && corPeca.equals("BRANCO")) || (retornaVezBranco() == false && corPeca.equals("PRETO"))) {
            String opcao;
            String posDir = "" + (Integer.parseInt(posAtual.charAt(0) + "") + 1) + posAtual.charAt(1);
            String posEsq = "" + (Integer.parseInt(posAtual.charAt(0) + "") - 1) + posAtual.charAt(1);
            if (peca == " P " && tabuleiro.retornaPeca(posAtual).getCor() == Cor.BRANCO) {//PEAO Branco
                if ((tabuleiro.retornaPeca(posAtual).podeCapturar(posAtual, posProx) == true) && (tabuleiro.retornaPeca(posProx) != null)) {
                    tabuleiro.trocaPeca(posAtual, posProx);
                    //verificaPromocaoparaPEAOpreto
                    if (posProx.charAt(1) == '8') {
                        scanner.nextLine();
                        impresso.imprimePromocao();
                        opcao = scanner.nextLine();
                        tabuleiro.promovePeca(opcao.charAt(0), posProx, vezBranco);
                    }
                    alteraVez();
                    iniciaJogada();
                    //EnPASSANT para peao BRANCO
                } else if ((posAtual.charAt(1) == '5') && ((tabuleiro.retornaPeca(posEsq) != null) || (tabuleiro.retornaPeca(posDir) != null)) && (tabuleiro.retornaPeca(posProx) == null)) {
                    tabuleiro.trocaPeca(posAtual, posProx);
                    if (posProx.charAt(0) == posDir.charAt(0)) {
                        tabuleiro.removePeca(posDir);
                    } else if (posProx.charAt(0) == posEsq.charAt(0)) {
                        tabuleiro.removePeca(posEsq);
                    }
                    alteraVez();
                    iniciaJogada();
                } else {
                    if (textual == true) {
                        view.movimentoInvalido();
                        processaJogada(nomeJogador[0], nomeJogador[1]);
                    } else {
                        tela.alertaMovInvalido();
                    }
                }
            } else if (peca == " P " && tabuleiro.retornaPeca(posAtual).getCor() == Cor.PRETO) {//PEAO Preto

                if ((tabuleiro.retornaPeca(posAtual).podeCapturar(posAtual, posProx) == true) && (tabuleiro.retornaPeca(posProx) != null)) {
                    tabuleiro.trocaPeca(posAtual, posProx);
                    //verificaPromocaoparaPEAOpreto
                    if (posProx.charAt(1) == '1') {
                        impresso.imprimePromocao();
                        opcao = scanner.nextLine();
                        tabuleiro.promovePeca(opcao.charAt(0), posProx, vezBranco);
                    }
                    alteraVez();
                    iniciaJogada();
                    //EnPASSANT para peao PRETO
                } else if ((posAtual.charAt(1) == '4') && ((tabuleiro.retornaPeca(posEsq) != null) || (tabuleiro.retornaPeca(posDir) != null)) && (tabuleiro.retornaPeca(posProx) == null)) {
                    tabuleiro.trocaPeca(posAtual, posProx);
                    if (posProx.charAt(0) == posDir.charAt(0)) {
                        tabuleiro.removePeca(posDir);
                    } else if (posProx.charAt(0) == posEsq.charAt(0)) {
                        tabuleiro.removePeca(posEsq);
                    }
                    alteraVez();
                    iniciaJogada();
                } else {
                    if (textual == true) {
                        view.movimentoInvalido();
                        processaJogada(nomeJogador[0], nomeJogador[1]);
                    } else {
                        tela.alertaMovInvalido();
                    }
                }
            } else if (peca == " T ") {//TORRE
                //movimenta
                if ((tabuleiro.retornaPeca(posAtual).podeCapturar(posAtual, posProx) == true) && (tabuleiro.retornaPeca(posProx) != null)) {
                    tabuleiro.retornaPeca(posAtual).alteraMovimentado();
                    tabuleiro.trocaPeca(posAtual, posProx);
                    alteraVez();
                    iniciaJogada();
                } else {
                    if (textual == true) {
                        view.movimentoInvalido();
                        processaJogada(nomeJogador[0], nomeJogador[1]);
                    } else {
                        tela.alertaMovInvalido();
                    }
                }
            } else if (peca == " C ") {//CAVALO
                //movimenta 
                if ((tabuleiro.retornaPeca(posAtual).podeCapturar(posAtual, posProx) == true) && (tabuleiro.retornaPeca(posProx) != null)) {
                    tabuleiro.trocaPeca(posAtual, posProx);
                    alteraVez();
                    iniciaJogada();

                } else {
                    if (textual == true) {
                        view.movimentoInvalido();
                        processaJogada(nomeJogador[0], nomeJogador[1]);
                    } else {
                        tela.alertaMovInvalido();
                    }
                }
            } else if (peca == " B ") {//BISPO
                //Movimento
                if ((tabuleiro.retornaPeca(posAtual).podeCapturar(posAtual, posProx) == true) && (tabuleiro.retornaPeca(posProx) != null)) {
                    tabuleiro.trocaPeca(posAtual, posProx);
                    alteraVez();
                    iniciaJogada();
                } else {
                    if (textual == true) {
                        view.movimentoInvalido();
                        processaJogada(nomeJogador[0], nomeJogador[1]);
                    } else {
                        tela.alertaMovInvalido();
                    }
                }
            } else if (peca == " D ") {//DAMA
                //movimenta
                if ((tabuleiro.retornaPeca(posAtual).podeCapturar(posAtual, posProx) == true) && (tabuleiro.retornaPeca(posProx) != null)) {
                    tabuleiro.trocaPeca(posAtual, posProx);
                    alteraVez();
                    iniciaJogada();
                } else {
                    if (textual == true) {
                        view.movimentoInvalido();
                        processaJogada(nomeJogador[0], nomeJogador[1]);
                    } else {
                        tela.alertaMovInvalido();
                    }
                }
            } else if (peca == " K ") {//REI
                //movimenta 
                if ((tabuleiro.retornaPeca(posAtual).podeCapturar(posAtual, posProx) == true) && (tabuleiro.retornaPeca(posProx) != null)) {
                    tabuleiro.retornaPeca(posAtual).alteraMovimentado();
                    tabuleiro.trocaPeca(posAtual, posProx);

                    alteraVez();
                    iniciaJogada();
                } else {
                    if (textual == true) {
                        view.movimentoInvalido();
                        processaJogada(nomeJogador[0], nomeJogador[1]);
                    } else {
                        tela.alertaMovInvalido();
                    }
                }
            } else {
                if (textual == true) {
                    view.movimentoInvalido();
                    processaJogada(nomeJogador[0], nomeJogador[1]);
                } else {
                    tela.alertaMovInvalido();
                }
            }
        } else {
            //pos atual nao é a peca do jogador da vez
            if (textual == true) {
                view.naoEhSuaVez();
                processaJogada(nomeJogador[0], nomeJogador[1]);
            }
        }
    }

    public void movimentaPeca(String posAtual, String posProx, String peca, String corPeca) throws ClassNotFoundException {
        //Alguma situações não trocava a peça, acho que resolvi adicionando alteraVez() nas outras peças
        view.imprimeFrase("");
        if ((retornaVezBranco() == true && corPeca.equals("BRANCO")) || (retornaVezBranco() == false && corPeca.equals("PRETO"))) {
            String opcao;
            if (peca == " P " && tabuleiro.retornaPeca(posAtual).getCor() == Cor.BRANCO) {//PEAO Branco
                if ((tabuleiro.retornaPeca(posAtual).podeAndarQuanto(posAtual, posProx) == true) && (tabuleiro.retornaPeca(posProx) == null) && caminhoLivre(posAtual, posProx, peca, corPeca)) {

                    tabuleiro.trocaPeca(posAtual, posProx);
                    //verificaPromocaoparaPEAOpreto
                    if (posProx.charAt(1) == '8') {
                        scanner.nextLine();
                        impresso.imprimePromocao();
                        opcao = scanner.nextLine();
                        tabuleiro.promovePeca(opcao.charAt(0), posProx, vezBranco);
                    }
                    alteraVez();
                    iniciaJogada();

                } else {
                    if (textual == true) {
                        view.movimentoInvalido();
                        processaJogada(nomeJogador[0], nomeJogador[1]);
                    } else {
                        tela.alertaMovInvalido();
                    }
                }
            } else if (peca == " P " && tabuleiro.retornaPeca(posAtual).getCor() == Cor.PRETO) {//PEAO Preto

                if ((tabuleiro.retornaPeca(posAtual).podeAndarQuanto(posAtual, posProx) == true) && (tabuleiro.retornaPeca(posProx) == null) && caminhoLivre(posAtual, posProx, peca, corPeca)) {

                    tabuleiro.trocaPeca(posAtual, posProx);
                    //verificaPromocaoparaPEAOpreto
                    if (posProx.charAt(1) == '1') {
                        scanner.nextLine();
                        impresso.imprimePromocao();
                        opcao = scanner.nextLine();
                        tabuleiro.promovePeca(opcao.charAt(0), posProx, vezBranco);
                    }
                    alteraVez();
                    iniciaJogada();
                } else {
                    if (textual == true) {
                        view.movimentoInvalido();
                        processaJogada(nomeJogador[0], nomeJogador[1]);
                    } else {
                        tela.alertaMovInvalido();
                    }
                }
            } else if (peca == " T ") {//TORRE
                //movimenta

                if ((tabuleiro.retornaPeca(posAtual).podeAndarQuanto(posAtual, posProx) == true) && (tabuleiro.retornaPeca(posProx) == null) && caminhoLivre(posAtual, posProx, peca, corPeca)) {
                    tabuleiro.retornaPeca(posAtual).alteraMovimentado();
                    tabuleiro.trocaPeca(posAtual, posProx);
                    alteraVez();
                    iniciaJogada();
                } else {
                    if (textual == true) {
                        view.movimentoInvalido();
                        processaJogada(nomeJogador[0], nomeJogador[1]);
                    } else {
                        tela.alertaMovInvalido();
                    }
                }
            } else if (peca == " C ") {//CAVALO
                //movimenta 
                if ((tabuleiro.retornaPeca(posAtual).podeAndarQuanto(posAtual, posProx) == true) && (tabuleiro.retornaPeca(posProx) == null)) {
                    tabuleiro.trocaPeca(posAtual, posProx);
                    alteraVez();
                    iniciaJogada();
                } else {
                    if (textual == true) {
                        view.movimentoInvalido();
                        processaJogada(nomeJogador[0], nomeJogador[1]);
                    } else {
                        tela.alertaMovInvalido();
                    }
                }
            } else if (peca == " B ") {//BISPO
                //Movimento
                if ((tabuleiro.retornaPeca(posAtual).podeAndarQuanto(posAtual, posProx) == true) && (tabuleiro.retornaPeca(posProx) == null) && caminhoLivre(posAtual, posProx, peca, corPeca)) {
                    tabuleiro.trocaPeca(posAtual, posProx);
                    alteraVez();
                    iniciaJogada();
                } else {
                    if (textual == true) {
                        view.movimentoInvalido();
                        processaJogada(nomeJogador[0], nomeJogador[1]);
                    } else {
                        tela.alertaMovInvalido();
                    }
                }
            } else if (peca == " D ") {//DAMA
                //movimenta
                if ((tabuleiro.retornaPeca(posAtual).podeAndarQuanto(posAtual, posProx) == true) && (tabuleiro.retornaPeca(posProx) == null) && caminhoLivre(posAtual, posProx, peca, corPeca)) {
                    tabuleiro.trocaPeca(posAtual, posProx);
                    alteraVez();
                    iniciaJogada();
                } else {
                    if (textual == true) {
                        view.movimentoInvalido();
                        processaJogada(nomeJogador[0], nomeJogador[1]);
                    } else {
                        tela.alertaMovInvalido();
                    }
                }
            } else if (peca == " K ") {//REI
                //movimenta 
                if ((tabuleiro.retornaPeca(posAtual).podeAndarQuanto(posAtual, posProx) == true) && (tabuleiro.retornaPeca(posProx) == null)) {
                    tabuleiro.retornaPeca(posAtual).alteraMovimentado();
                    tabuleiro.trocaPeca(posAtual, posProx);
                    alteraVez();
                    iniciaJogada();
                } else {
                    if (textual == true) {
                        view.movimentoInvalido();
                        processaJogada(nomeJogador[0], nomeJogador[1]);
                    } else {
                        tela.alertaMovInvalido();
                    }
                }
            } else {
                if (textual == true) {
                    view.opcaoInvalida();
                    processaJogada(nomeJogador[0], nomeJogador[1]);
                } else {
                    tela.alertaOpcaoInvalida();
                }
            }
        } else {
            //pos atual nao é a peca do jogador da vez
            if (textual == true) {
                view.naoEhSuaVez();
                processaJogada(nomeJogador[0], nomeJogador[1]);
            } else {
                tela.alertaNaoEhSuaVez();
            }
        }

    }

    public boolean caminhoLivre(String posAtual, String posProx, String peca, String corPeca) {
        //Branco Peão
        int i, j;
        String posAtualAux = posAtual;
        String posProxAux = posProx;
        int nposAtual, nposProx, nposProx1, nposAtual1;

        boolean podeIr = false;
        if (peca == " C ") {
            return true;
        } else if (peca == " P " && tabuleiro.retornaPeca(posAtual).getCor() == Cor.BRANCO) {
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
        return false;
    }

    public boolean realizaRoques(String entrada) {
        if ((retornaVezBranco()) && (tabuleiro.retornaPeca("51") != null)) {
            //roqueMaiorBranco
            if (tabuleiro.retornaPeca("11") != null) {
                if (entrada.equals("O-O-O") && (!tabuleiro.retornaPeca("51").getMovimentado()) && ((!tabuleiro.retornaPeca("11").getMovimentado())) && (tabuleiro.retornaPeca("21") == null) && (tabuleiro.retornaPeca("31") == null) && (tabuleiro.retornaPeca("41") == null)) {
                    //trocandoREi
                    tabuleiro.trocaPeca("51", "31");
                    //trocandoTorre
                    tabuleiro.trocaPeca("11", "41");
                    return true;
                }
            }  //roqueMenorBranco
            if (tabuleiro.retornaPeca("81") != null) {
                if (entrada.equals("O-O") && (!tabuleiro.retornaPeca("51").getMovimentado()) && ((!tabuleiro.retornaPeca("81").getMovimentado())) && (tabuleiro.retornaPeca("61") == null) && (tabuleiro.retornaPeca("71") == null)) {
                    //trocandoREi
                    tabuleiro.trocaPeca("51", "71");
                    //trocandoTorre
                    tabuleiro.trocaPeca("81", "61");
                    return true;

                }
            }
        } else if (tabuleiro.retornaPeca("58") != null) {
            //roqueMaiorPreto
            if (tabuleiro.retornaPeca("18") != null) {
                if (entrada.equals("O-O-O") && (!tabuleiro.retornaPeca("58").getMovimentado()) && ((!tabuleiro.retornaPeca("18").getMovimentado())) && (tabuleiro.retornaPeca("28") == null) && (tabuleiro.retornaPeca("38") == null) && (tabuleiro.retornaPeca("48") == null)) {
                    //trocandoREi
                    tabuleiro.trocaPeca("58", "38");
                    //trocandoTorre
                    tabuleiro.trocaPeca("18", "48");
                    return true;
                }
            }//roqueMaiorBranco
            if (tabuleiro.retornaPeca("88") != null) {
                if (entrada.equals("O-O") && (!tabuleiro.retornaPeca("58").getMovimentado()) && ((!tabuleiro.retornaPeca("88").getMovimentado())) && (tabuleiro.retornaPeca("68") == null) && (tabuleiro.retornaPeca("78") == null)) {
                    //trocandoREi
                    tabuleiro.trocaPeca("58", "78");
                    //trocandoTorre
                    tabuleiro.trocaPeca("88", "68");
                    return true;

                }
            }

        }
        return false;

    }

    public void realizaXeque(String posPecaXeque) throws ClassNotFoundException {
        String jogada;
        impresso.Impressao(tabuleiro);
        view.imprimeVez(vezBranco);
        if (retornaVezBranco() == true) {
            view.jogadaJ1(nomeJogador[0]);
            jogada = scanner.next();
        } else {
            view.jogadaJ2(nomeJogador[1]);
            jogada = scanner.next();

        }

        if ((jogada.length() == 5) && (jogada.charAt(2) == 'x') && (posPecaXeque.equals("" + jogada.charAt(3) + jogada.charAt(4)))) { //verifica se é captura OU

            capturaPeca("" + jogada.charAt(0) + jogada.charAt(1), "" + jogada.charAt(3) + jogada.charAt(4), tabuleiro.retornaPeca("" + jogada.charAt(0) + jogada.charAt(1)).getNome().getApelidoPeca().toString(), tabuleiro.retornaPeca("" + jogada.charAt(0) + jogada.charAt(1)).getCor().toString());

        } else if ((jogada.length() == 4) && (tabuleiro.retornaPeca("" + jogada.charAt(0) + jogada.charAt(1)).getNome().getApelidoPeca().toString() == " K ")) { //movimento com o REI

            movimentaPeca("" + jogada.charAt(0) + jogada.charAt(1), "" + jogada.charAt(2) + jogada.charAt(3), tabuleiro.retornaPeca("" + jogada.charAt(0) + jogada.charAt(1)).getNome().getApelidoPeca().toString(), tabuleiro.retornaPeca("" + jogada.charAt(0) + jogada.charAt(1)).getCor().toString());
        } else {
            //xequemate
            realizaXequeMate();
        }

    }

    public void realizaXequeMate() throws ClassNotFoundException {
        alteraVez();
        scanner.nextLine();
        view.imprimeXequeMate();
        if (vezBranco == true) {
            jogador.addPontuacao(nomeJogador[0], "v");
            jogador.addPontuacao(nomeJogador[1], "d");

        } else {
            jogador.addPontuacao(nomeJogador[0], "d");
            jogador.addPontuacao(nomeJogador[1], "v");
        }
        tabuleiro.reiniciaTabuleiro();
        processaMenu("2");
    }

    public void salvarPartida(Partida partidaAtual) throws ClassNotFoundException {

        String dataHora = new Date().toString();
        partidaAtual.setDataHoraPartida(dataHora);
        dados.savePartida(partidaAtual);
        view.partidaSalva();

    }

}//fimClasse

