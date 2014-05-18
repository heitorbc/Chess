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
import br.edu.ifes.poo1.CGT.Movimentacao;
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
    private Jogador jogador = new Jogador();
    private Impressao impresso = new Impressao();
    private Scanner scanner = new Scanner(System.in);
    private String[] nomeJogador = new String[2];
    private Mensagens view ;
    private Azureus az = new Azureus();
    private Dados dados = new Dados();
    private ArrayList<Partida> partidas = new ArrayList<>();
    private boolean vezBranco = true;
    private boolean textual = true;
    private Movimentacao move ;

    //Construtor do Controle Total
    public ControleTotal(Tabuleiro tab) {
        tela = new Visual(tab, this,jogador);
        view = new Mensagens();
        move = new Movimentacao(this, impresso, view, tela);
        this.tabuleiro = tab;
        tela.setVisible(false);
    }

    //Inicia o menu de seleção de Modo
    public void iniciaMenu() throws ClassNotFoundException {
        impresso.imprimeTipo();
        String entrada = scanner.nextLine();
        processaTipo(entrada);
    }

    //Realiza a decisao das jogadas após a entrada do usuario
    public void controlaJogadas(String jog) throws ClassNotFoundException {
        //CONTROLA JOGADAS TEXTUAIS
        if (jog.equals("salvar") || jog.equals("SALVAR")) {
            Partida partidaAtual = new Partida(nomeJogador[0], jogador.retornaPontos(nomeJogador[0]), nomeJogador[1], jogador.retornaPontos(nomeJogador[1]), vezBranco, tabuleiro);
            salvarPartida(partidaAtual);
            if (textual == true) {
                scanner.nextLine();
            }
            iniciaMenu();

            //Sair da partida = desistir   
        } else if (jog.equals("desistir") || jog.equals("DESISTIR")) {
            //COLOCA PONTUAÇÃO PARA JOGADORES
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

                if (move.realizaRoques(jog, tabuleiro) == true) {

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
                
                if ((tabuleiro.retornaPeca(posAtual).podeAndarQuanto(posAtual, posProx) && tabuleiro.retornaPeca(posProx) == null)) {
                    tabuleiro.trocaPeca(posAtual, posProx);
                }
                if (textual == true) {
                    view.imprimeXeque();
                } else {
                    tela.alertaReiemXeque();
                }
                alteraVez();
                move.realizaXeque(posProx, tabuleiro,jogador);

            }//XEQUE MATE #####
            else if ((jog.length() == 5) && (jog.charAt(4) == '#') && (tabuleiro.retornaPeca(posProx) != null)) {
                if (tabuleiro.retornaPeca(posProx).getNome().toString().equals(" K ")) {
                    tabuleiro.trocaPeca(posAtual, posProx);
                    move.realizaXequeMate(tabuleiro,jogador);
                }

            } //antiga posicao try
            //JOGADA DE CAPTURA 
            else if ((jog.length() == 5) && (jog.charAt(2) == 'x')) {
                String posAtualCaptura = "" + jog.charAt(0) + jog.charAt(1);
                String posProxCaptura = "" + jog.charAt(3) + jog.charAt(4);
                move.capturaPeca(posAtualCaptura, posProxCaptura, peca, corPeca, tabuleiro);

            } //MOVIMENTAÇÂO NORMAL
            else if (jog.length() == 4) {
                move.movimentaPeca(posAtual, posProx, peca, corPeca, tabuleiro);

            } else {//erro de movimentação = JOGADA INVALIDA
                if (textual == true) {
                    view.movimentoInvalido();
                    processaJogada(nomeJogador[0], nomeJogador[1]);
                }else{
                    tela.alertaMovInvalido();
                }
            }
        }
    }

    //Processamento de inicio da jogada, recebimento da entrada do Usuário ou Jogada do IA
    public void iniciaJogada() throws ClassNotFoundException {
        String jog;
        if (textual == true) {
            impresso.Impressao(tabuleiro);
            view.imprimeVez(vezBranco);
            if ((!nomeJogador[1].equals("AZUREUS")) || (vezBranco)) {
                processaJogada(nomeJogador[0], nomeJogador[1]);
            } else {
                jog = az.processaJogadaAzureus(tabuleiro, this,move);
                view.imprimeFrase(jog);
                controlaJogadas(jog);
            }
        }
    }

    //processa entrada do usuario para seleção em menu de jogada multiplayer ou contra a maquina
    public void processaModoJogo(String dado) throws ClassNotFoundException {
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

    //processa entrada do usuario para seleção em menu do modo de jogo, carregamento de Partida salva em disco ou Ranking de Usuários
    public void processaMenu(String dado) throws ClassNotFoundException {
        if ((dado.equals("1")) || (dado.equals("2")) || (dado.equals("3")) || (dado.equals("4"))) {

            switch (dado) {
                case "1":
                    impresso.imprimeModoJogo();
                    String comando = scanner.nextLine();
                    processaModoJogo(comando);
                    break;
                case "2":
                    int contador = 0;
                    partidas = dados.loadPartida();
                    view.imprimeEscolhaPartida();
                    for (Partida p : partidas) {
                        contador++;
                        view.imprimeDadosPartida(contador, p);
                    }

                    if (contador != 0) {
                        int opcao = scanner.nextInt();
                        if (opcao <= contador) {
                            contador = 1;
                        } else {
                            scanner.nextLine();
                            view.opcaoInvalida();
                            iniciaMenu();
                        }
                        //Problema esta no tabuleiro que foi salvo.
                        for (Partida p : partidas) {
                            if (contador == opcao) {
                                tabuleiro = p.getTabuleiro();
                                vezBranco = p.isVezBranco();
                                nomeJogador[0] = p.getJogadorBranco();
                                nomeJogador[1] = p.getJogadorPreto();
                                jogador.setPontuacaoJogador(nomeJogador[0], p.retornaArrayPontos("b"));
                                jogador.setPontuacaoJogador(nomeJogador[1], p.retornaArrayPontos("p"));
                            }
                            contador++;
                        }
                    } else {
                        scanner.nextLine();
                        view.naoExistemSalvas();
                        iniciaMenu();
                    }
                    iniciaJogada();
                    break;
                case "3":
                    impresso.imprimeDados(jogador.getJogadores());
                    iniciaMenu();
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

    //recebe as entradas do jogador e realiza o controle do movimento analizando a vez do jogador preto ou branco
    public void processaJogada(String jogador1, String jogador2) throws ClassNotFoundException {
        if (isVezBranco() == true) {
            view.jogadaJ1(jogador1);
            String jogada = scanner.next();
            controlaJogadas(jogada);

        } else {
            view.jogadaJ2(jogador2);
            String jogada = scanner.next();
            controlaJogadas(jogada);
        }

    }

    //################SURPRISE#################
    //processa entrada do usuario para seleção em menu de Tipo Visual ou Textual
    public void processaTipo(String dado) throws ClassNotFoundException {
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
    
    //Processamento do nome do jogador em caso de Modo x Máquina
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
    
    //Processamento do nome do jogador em caso de Modo Multiplayer
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
    
    //################SURPRISE#################
    //Processamento do nome do jogador em caso de Modo VISUAL
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

    //Realiza salvamento da partida em disco atravez da classe Dados
    public void salvarPartida(Partida partidaAtual) throws ClassNotFoundException {
        String dataHora = new Date().toString();
        partidaAtual.setDataHoraPartida(dataHora);
        dados.savePartida(partidaAtual);
        view.partidaSalva();

    }

    public String getNomeJogadorBranco() {
        return nomeJogador[0];
    }

    public String getNomeJogadorPreto() {
        return nomeJogador[1];
    }

    public void alteraVez() {
        if (vezBranco == true) {
            vezBranco = false;
        } else {
            vezBranco = true;
        }
    }

    public boolean isVezBranco() {
        return vezBranco;
    }

    public boolean isTextual() {
        return textual;
    }

    public void setTextual(boolean textual) {
        this.textual = textual;
    }

}//fimClasse

