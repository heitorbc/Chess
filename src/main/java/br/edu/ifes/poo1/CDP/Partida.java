/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifes.poo1.CDP;

import java.io.Serializable;

/**
 *
 * @author Henrique
 */
public class Partida implements Serializable{
    
    private Tabuleiro tabuleiro;
    private String jogadorBranco, jogadorPreto;
    private String pBranco,pPreto;
    private boolean vezBranco;
    private String dataHoraPartida;
    
    
    public Partida(Tabuleiro tabuleiro,String jog1,String pon1,String jog2,String pon2,boolean vez) {
        
        this.tabuleiro = tabuleiro;
        this.jogadorBranco=jog1;
        this.jogadorPreto=jog2;
        this.pBranco=pon1;
        this.pPreto=pon2;
        this.vezBranco=vez;
        
        
    }

    public String getDataHoraPartida() {
        return dataHoraPartida;
    }

    public void setDataHoraPartida(String nomePartida) {
        this.dataHoraPartida = nomePartida;
    }
    
    public String retornaNomesJodadores(){
        return jogadorBranco+" X "+jogadorPreto;
    }
    
    
}

