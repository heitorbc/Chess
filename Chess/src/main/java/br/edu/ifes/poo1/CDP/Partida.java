/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.poo1.CDP;

import br.edu.ifes.poo1.CIH.Impressao;
import java.io.Serializable;
import java.util.ArrayList;
/**
 *
 * @author Henrique
 */
public class Partida implements Serializable {

    private String jogadorBranco, jogadorPreto;
    private String pBranco, pPreto;
    private boolean vezBranco;
    private String dataHoraPartida;
    private Tabuleiro tabuleiro;

    public Partida(String jog1, String pon1, String jog2, String pon2, boolean vez,Tabuleiro tabEntrada) {

        
        jogadorBranco = jog1;
        jogadorPreto = jog2;
        pBranco = pon1;
        pPreto = pon2;
        vezBranco = vez;
        tabuleiro = tabEntrada;

    }

    public ArrayList<Integer> retornaArrayPontos(String j) {
        ArrayList<Integer> pontos = new ArrayList<>();
        if (j == "b") {
            pontos.add(Integer.parseInt(pBranco.charAt(0) + ""));
            pontos.add(Integer.parseInt(pBranco.charAt(2) + ""));
            pontos.add(Integer.parseInt(pBranco.charAt(4) + ""));
            return pontos;
        } else {
            pontos.add(Integer.parseInt(pPreto.charAt(0) + ""));
            pontos.add(Integer.parseInt(pPreto.charAt(2) + ""));
            pontos.add(Integer.parseInt(pPreto.charAt(4) + ""));
            return pontos;
        }
    }

    public String getDataHoraPartida() {
        return dataHoraPartida;
    }

    public void setDataHoraPartida(String nomePartida) {
        this.dataHoraPartida = nomePartida;
    }

    public String retornaNomesJodadores() {
        return jogadorBranco + " X " + jogadorPreto;
    }

    public Tabuleiro getTabuleiro() {
        return tabuleiro;
    }

    public void setTabuleiro(Tabuleiro tabuleiro) {
        this.tabuleiro = tabuleiro;
    }

    public String getJogadorBranco() {
        return jogadorBranco;
    }

    public void setJogadorBranco(String jogadorBranco) {
        this.jogadorBranco = jogadorBranco;
    }

    public String getJogadorPreto() {
        return jogadorPreto;
    }

    public void setJogadorPreto(String jogadorPreto) {
        this.jogadorPreto = jogadorPreto;
    }

    public String getpBranco() {
        return pBranco;
    }

    public void setpBranco(String pBranco) {
        this.pBranco = pBranco;
    }

    public String getpPreto() {
        return pPreto;
    }

    public void setpPreto(String pPreto) {
        this.pPreto = pPreto;
    }

    public boolean isVezBranco() {
        return vezBranco;
    }

    public void setVezBranco(boolean vezBranco) {
        this.vezBranco = vezBranco;
    }

}
