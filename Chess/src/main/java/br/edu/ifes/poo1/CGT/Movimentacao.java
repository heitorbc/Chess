/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.poo1.CGT;

import br.edu.ifes.poo1.CCI.ControleTotal;
import br.edu.ifes.poo1.CDP.Jogador;
import br.edu.ifes.poo1.CDP.Tabuleiro;
import br.edu.ifes.poo1.CIH.Impressao;
import br.edu.ifes.poo1.CIH.Mensagens;
import br.edu.ifes.poo1.CIH.Promocao;
import br.edu.ifes.poo1.CIH.Visual;
import br.edu.ifes.poo1.util.Cor;
import java.util.Scanner;

/**
 *
 * @author Henrique
 */
//Classe que gerencia movminto das pecas
public class Movimentacao {

    private ControleTotal control;
    private Scanner scanner = new Scanner(System.in);
    private Impressao impresso;
    private Mensagens view;
    private Visual tela;

    public Movimentacao(ControleTotal controle, Impressao impressora, Mensagens visao, Visual tela) {
        this.control = controle;
        this.impresso = impressora;
        this.view = visao;
        this.tela = tela;
    }

    public void capturaPeca(String posAtual, String posProx, String peca, String corPeca, Tabuleiro tabuleiro) throws ClassNotFoundException {
        if ((control.isVezBranco() == true && corPeca.equals("BRANCO")) || (control.isVezBranco() == false && corPeca.equals("PRETO"))) {
            String opcao;
            String posDir = "" + (Integer.parseInt(posAtual.charAt(0) + "") + 1) + posAtual.charAt(1);
            String posEsq = "" + (Integer.parseInt(posAtual.charAt(0) + "") - 1) + posAtual.charAt(1);
            if (peca == " P " && tabuleiro.retornaPeca(posAtual).getCor() == Cor.BRANCO) {//PEAO Branco
                if ((tabuleiro.retornaPeca(posAtual).podeCapturar(posAtual, posProx) == true) && (tabuleiro.retornaPeca(posProx) != null)) {
                    tabuleiro.trocaPeca(posAtual, posProx);
                    //verificaPromocaoparaPEAOpreto
                    if (posProx.charAt(1) == '8') {
                        if (control.isTextual() == true) {
                            scanner.nextLine();
                            impresso.imprimePromocao();
                            opcao = scanner.nextLine();
                            tabuleiro.promovePeca(opcao.charAt(0), posProx, control.isVezBranco());
                        } else {
                            tela.exibePromocao(posProx);

                        }
                    }
                    control.alteraVez();
                    control.iniciaJogada();
                    //EnPASSANT para peao BRANCO
                } else if ((posAtual.charAt(1) == '5') && ((tabuleiro.retornaPeca(posEsq) != null) || (tabuleiro.retornaPeca(posDir) != null)) && (tabuleiro.retornaPeca(posProx) == null)) {
                    tabuleiro.trocaPeca(posAtual, posProx);
                    if (posProx.charAt(0) == posDir.charAt(0)) {
                        tabuleiro.removePeca(posDir);
                    } else if (posProx.charAt(0) == posEsq.charAt(0)) {
                        tabuleiro.removePeca(posEsq);
                    }
                    control.alteraVez();
                    control.iniciaJogada();
                } else {
                    if (control.isTextual() == true) {
                        view.movimentoInvalido();
                        control.processaJogada(control.getNomeJogadorBranco(), control.getNomeJogadorPreto());
                    } else {
                        tela.alertaMovInvalido();
                    }
                }
            } else if (peca == " P " && tabuleiro.retornaPeca(posAtual).getCor() == Cor.PRETO) {//PEAO Preto

                if ((tabuleiro.retornaPeca(posAtual).podeCapturar(posAtual, posProx) == true) && (tabuleiro.retornaPeca(posProx) != null)) {
                    tabuleiro.trocaPeca(posAtual, posProx);
                    //verificaPromocaoparaPEAOpreto
                    if (posProx.charAt(1) == '1') {
                        if (control.isTextual() == true) {
                            impresso.imprimePromocao();
                            opcao = scanner.nextLine();
                            tabuleiro.promovePeca(opcao.charAt(0), posProx, control.isVezBranco());
                        } else {
                            tela.exibePromocao(posProx);
                            tela.atualizaTabuleiro();
                        }
                    }
                    control.alteraVez();
                    control.iniciaJogada();
                    //EnPASSANT para peao PRETO
                } else if ((posAtual.charAt(1) == '4') && ((tabuleiro.retornaPeca(posEsq) != null) || (tabuleiro.retornaPeca(posDir) != null)) && (tabuleiro.retornaPeca(posProx) == null)) {
                    tabuleiro.trocaPeca(posAtual, posProx);
                    if (posProx.charAt(0) == posDir.charAt(0)) {
                        tabuleiro.removePeca(posDir);
                    } else if (posProx.charAt(0) == posEsq.charAt(0)) {
                        tabuleiro.removePeca(posEsq);
                    }
                    control.alteraVez();
                    control.iniciaJogada();
                } else {
                    if (control.isTextual() == true) {
                        view.movimentoInvalido();
                        control.processaJogada(control.getNomeJogadorBranco(), control.getNomeJogadorPreto());
                    } else {
                        tela.alertaMovInvalido();
                    }
                }
            } else if (peca == " T ") {//TORRE
                //movimenta
                if ((tabuleiro.retornaPeca(posAtual).podeCapturar(posAtual, posProx) == true) && (tabuleiro.retornaPeca(posProx) != null)) {
                    tabuleiro.retornaPeca(posAtual).alteraMovimentado();
                    tabuleiro.trocaPeca(posAtual, posProx);
                    control.alteraVez();
                    control.iniciaJogada();
                } else {
                    if (control.isTextual() == true) {
                        view.movimentoInvalido();
                        control.processaJogada(control.getNomeJogadorBranco(), control.getNomeJogadorPreto());
                    } else {
                        tela.alertaMovInvalido();
                    }
                }
            } else if (peca == " C ") {//CAVALO
                //movimenta 
                if ((tabuleiro.retornaPeca(posAtual).podeCapturar(posAtual, posProx) == true) && (tabuleiro.retornaPeca(posProx) != null)) {
                    tabuleiro.trocaPeca(posAtual, posProx);
                    control.alteraVez();
                    control.iniciaJogada();

                } else {
                    if (control.isTextual() == true) {
                        view.movimentoInvalido();
                        control.processaJogada(control.getNomeJogadorBranco(), control.getNomeJogadorPreto());
                    } else {
                        tela.alertaMovInvalido();
                    }
                }
            } else if (peca == " B ") {//BISPO
                //Movimento
                if ((tabuleiro.retornaPeca(posAtual).podeCapturar(posAtual, posProx) == true) && (tabuleiro.retornaPeca(posProx) != null)) {
                    tabuleiro.trocaPeca(posAtual, posProx);
                    control.alteraVez();
                    control.iniciaJogada();
                } else {
                    if (control.isTextual() == true) {
                        view.movimentoInvalido();
                        control.processaJogada(control.getNomeJogadorBranco(), control.getNomeJogadorPreto());
                    } else {
                        tela.alertaMovInvalido();
                    }
                }
            } else if (peca == " D ") {//DAMA
                //movimenta
                if ((tabuleiro.retornaPeca(posAtual).podeCapturar(posAtual, posProx) == true) && (tabuleiro.retornaPeca(posProx) != null)) {
                    tabuleiro.trocaPeca(posAtual, posProx);
                    control.alteraVez();
                    control.iniciaJogada();
                } else {
                    if (control.isTextual() == true) {
                        view.movimentoInvalido();
                        control.processaJogada(control.getNomeJogadorBranco(), control.getNomeJogadorPreto());
                    } else {
                        tela.alertaMovInvalido();
                    }
                }
            } else if (peca == " K ") {//REI
                //movimenta 
                if ((tabuleiro.retornaPeca(posAtual).podeCapturar(posAtual, posProx) == true) && (tabuleiro.retornaPeca(posProx) != null)) {
                    tabuleiro.retornaPeca(posAtual).alteraMovimentado();
                    tabuleiro.trocaPeca(posAtual, posProx);

                    control.alteraVez();
                    control.iniciaJogada();
                } else {
                    if (control.isTextual() == true) {
                        view.movimentoInvalido();
                        control.processaJogada(control.getNomeJogadorBranco(), control.getNomeJogadorPreto());
                    } else {
                        tela.alertaMovInvalido();
                    }
                }
            } else {
                if (control.isTextual() == true) {
                    view.movimentoInvalido();
                    control.processaJogada(control.getNomeJogadorBranco(), control.getNomeJogadorPreto());
                } else {
                    tela.alertaMovInvalido();
                }
            }
        } else {
            //pos atual nao é a peca do jogador da vez
            if (control.isTextual() == true) {
                view.naoEhSuaVez();
                control.processaJogada(control.getNomeJogadorBranco(), control.getNomeJogadorPreto());
            }
        }
    }

    public void movimentaPeca(String posAtual, String posProx, String peca, String corPeca, Tabuleiro tabuleiro) throws ClassNotFoundException {

        view.imprimeFrase("");
        if ((control.isVezBranco() == true && corPeca.equals("BRANCO")) || (control.isVezBranco() == false && corPeca.equals("PRETO"))) {
            String opcao;
            if (peca == " P " && tabuleiro.retornaPeca(posAtual).getCor() == Cor.BRANCO) {//PEAO Branco
                if ((tabuleiro.retornaPeca(posAtual).podeAndarQuanto(posAtual, posProx) == true) && (tabuleiro.retornaPeca(posProx) == null) && caminhoLivre(posAtual, posProx, peca, corPeca, tabuleiro)) {

                    tabuleiro.trocaPeca(posAtual, posProx);
                    //verificaPromocaoparaPEAOpreto
                    if (posProx.charAt(1) == '8') {
                        if (control.isTextual() == true) {
                            impresso.imprimePromocao();
                            opcao = scanner.nextLine();
                            tabuleiro.promovePeca(opcao.charAt(0), posProx, control.isVezBranco());
                        } else {
                            tela.exibePromocao(posProx);
                            tela.atualizaTabuleiro();
                        }
                    }
                    control.alteraVez();
                    control.iniciaJogada();

                } else {
                    if (control.isTextual() == true) {
                        view.movimentoInvalido();
                        control.processaJogada(control.getNomeJogadorBranco(), control.getNomeJogadorPreto());
                    } else {
                        tela.alertaMovInvalido();
                    }
                }
            } else if (peca == " P " && tabuleiro.retornaPeca(posAtual).getCor() == Cor.PRETO) {//PEAO Preto

                if ((tabuleiro.retornaPeca(posAtual).podeAndarQuanto(posAtual, posProx) == true) && (tabuleiro.retornaPeca(posProx) == null) && caminhoLivre(posAtual, posProx, peca, corPeca, tabuleiro)) {

                    tabuleiro.trocaPeca(posAtual, posProx);
                    //verificaPromocaoparaPEAOpreto
                    if (posProx.charAt(1) == '1') {
                        if (control.isTextual() == true) {
                            impresso.imprimePromocao();
                            opcao = scanner.nextLine();
                            tabuleiro.promovePeca(opcao.charAt(0), posProx, control.isVezBranco());
                        } else {
                            tela.exibePromocao(posProx);
                            tela.atualizaTabuleiro();
                        }
                    }
                    control.alteraVez();
                    control.iniciaJogada();
                } else {
                    if (control.isTextual() == true) {
                        view.movimentoInvalido();
                        control.processaJogada(control.getNomeJogadorBranco(), control.getNomeJogadorPreto());
                    } else {
                        tela.alertaMovInvalido();
                    }
                }
            } else if (peca == " T ") {//TORRE
                //movimenta

                if ((tabuleiro.retornaPeca(posAtual).podeAndarQuanto(posAtual, posProx) == true) && (tabuleiro.retornaPeca(posProx) == null) && caminhoLivre(posAtual, posProx, peca, corPeca, tabuleiro)) {
                    tabuleiro.retornaPeca(posAtual).alteraMovimentado();
                    tabuleiro.trocaPeca(posAtual, posProx);
                    control.alteraVez();
                    control.iniciaJogada();
                } else {
                    if (control.isTextual() == true) {
                        view.movimentoInvalido();
                        control.processaJogada(control.getNomeJogadorBranco(), control.getNomeJogadorPreto());
                    } else {
                        tela.alertaMovInvalido();
                    }
                }
            } else if (peca == " C ") {//CAVALO
                //movimenta 
                if ((tabuleiro.retornaPeca(posAtual).podeAndarQuanto(posAtual, posProx) == true) && (tabuleiro.retornaPeca(posProx) == null)) {
                    tabuleiro.trocaPeca(posAtual, posProx);
                    control.alteraVez();
                    control.iniciaJogada();
                } else {
                    if (control.isTextual() == true) {
                        view.movimentoInvalido();
                        control.processaJogada(control.getNomeJogadorBranco(), control.getNomeJogadorPreto());
                    } else {
                        tela.alertaMovInvalido();
                    }
                }
            } else if (peca == " B ") {//BISPO
                //Movimento
                if ((tabuleiro.retornaPeca(posAtual).podeAndarQuanto(posAtual, posProx) == true) && (tabuleiro.retornaPeca(posProx) == null) && caminhoLivre(posAtual, posProx, peca, corPeca, tabuleiro)) {
                    tabuleiro.trocaPeca(posAtual, posProx);
                    control.alteraVez();
                    control.iniciaJogada();
                } else {
                    if (control.isTextual() == true) {
                        view.movimentoInvalido();
                        control.processaJogada(control.getNomeJogadorBranco(), control.getNomeJogadorPreto());
                    } else {
                        tela.alertaMovInvalido();
                    }
                }
            } else if (peca == " D ") {//DAMA
                //movimenta
                if ((tabuleiro.retornaPeca(posAtual).podeAndarQuanto(posAtual, posProx) == true) && (tabuleiro.retornaPeca(posProx) == null) && caminhoLivre(posAtual, posProx, peca, corPeca, tabuleiro)) {
                    tabuleiro.trocaPeca(posAtual, posProx);
                    control.alteraVez();
                    control.iniciaJogada();
                } else {
                    if (control.isTextual() == true) {
                        view.movimentoInvalido();
                        control.processaJogada(control.getNomeJogadorBranco(), control.getNomeJogadorPreto());
                    } else {
                        tela.alertaMovInvalido();
                    }
                }
            } else if (peca == " K ") {//REI
                //movimenta 
                if ((tabuleiro.retornaPeca(posAtual).podeAndarQuanto(posAtual, posProx) == true) && (tabuleiro.retornaPeca(posProx) == null)) {
                    tabuleiro.retornaPeca(posAtual).alteraMovimentado();
                    tabuleiro.trocaPeca(posAtual, posProx);
                    control.alteraVez();
                    control.iniciaJogada();
                } else {
                    if (control.isTextual() == true) {
                        view.movimentoInvalido();
                        control.processaJogada(control.getNomeJogadorBranco(), control.getNomeJogadorPreto());
                    } else {
                        tela.alertaMovInvalido();
                    }
                }
            } else {
                if (control.isTextual() == true) {
                    view.opcaoInvalida();
                    control.processaJogada(control.getNomeJogadorBranco(), control.getNomeJogadorPreto());
                } else {
                    tela.alertaOpcaoInvalida();
                }
            }
        } else {
            //pos atual nao é a peca do jogador da vez
            if (control.isTextual() == true) {
                view.naoEhSuaVez();
                control.processaJogada(control.getNomeJogadorBranco(), control.getNomeJogadorPreto());
            } else {
                tela.alertaNaoEhSuaVez();
            }
        }

    }

    public boolean caminhoLivre(String posAtual, String posProx, String peca, String corPeca, Tabuleiro tabuleiro) {
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

    public boolean realizaRoques(String entrada, Tabuleiro tabuleiro) {
        if ((control.isVezBranco()) && (tabuleiro.retornaPeca("51") != null)) {
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

    public void realizaXeque(String posPecaXeque, Tabuleiro tabuleiro, Jogador jogador) throws ClassNotFoundException {
        String jogada;
        impresso.Impressao(tabuleiro);
        view.imprimeVez(control.isVezBranco());
        if (control.isVezBranco() == true) {
            view.jogadaJ1(control.getNomeJogadorBranco());
            jogada = scanner.next();
        } else {
            view.jogadaJ2(control.getNomeJogadorPreto());
            jogada = scanner.next();

        }

        if ((jogada.length() == 5) && (jogada.charAt(2) == 'x') && (posPecaXeque.equals("" + jogada.charAt(3) + jogada.charAt(4)))) { //verifica se é captura OU

            capturaPeca("" + jogada.charAt(0) + jogada.charAt(1), "" + jogada.charAt(3) + jogada.charAt(4), tabuleiro.retornaPeca("" + jogada.charAt(0) + jogada.charAt(1)).getNome().getApelidoPeca().toString(), tabuleiro.retornaPeca("" + jogada.charAt(0) + jogada.charAt(1)).getCor().toString(), tabuleiro);

        } else if ((jogada.length() == 4) && (tabuleiro.retornaPeca("" + jogada.charAt(0) + jogada.charAt(1)).getNome().getApelidoPeca().toString() == " K ")) { //movimento com o REI

            movimentaPeca("" + jogada.charAt(0) + jogada.charAt(1), "" + jogada.charAt(2) + jogada.charAt(3), tabuleiro.retornaPeca("" + jogada.charAt(0) + jogada.charAt(1)).getNome().getApelidoPeca().toString(), tabuleiro.retornaPeca("" + jogada.charAt(0) + jogada.charAt(1)).getCor().toString(), tabuleiro);
        } else {
            //xequemate
            realizaXequeMate(tabuleiro, jogador);
        }

    }

    public void realizaXequeMate(Tabuleiro tabuleiro, Jogador jogador) throws ClassNotFoundException {
        control.alteraVez();
        scanner.nextLine();
        view.imprimeXequeMate();
        if (control.isVezBranco() == true) {
            jogador.addPontuacao(control.getNomeJogadorBranco(), "v");
            jogador.addPontuacao(control.getNomeJogadorPreto(), "d");

        } else {
            jogador.addPontuacao(control.getNomeJogadorBranco(), "d");
            jogador.addPontuacao(control.getNomeJogadorPreto(), "v");
        }
        tabuleiro.reiniciaTabuleiro();
        control.processaMenu("2");
    }

}//fim Movimentação

