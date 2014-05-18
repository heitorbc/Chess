/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifes.poo1.util;

import java.io.Serializable;

/**
 *
 * @author Henrique
 */
public enum PecaNome implements Serializable{
    BISPO(" B "),CAVALO(" C "),PEAO(" P "),DAMA(" D "),REI(" K "),TORRE(" T ");

    public String getApelidoPeca() {
        return apelidoPeca;
    }
    
    private final String apelidoPeca;

    PecaNome(String apelidoPeca) {
        this.apelidoPeca = apelidoPeca;
    }
    private String apelidoPeca(){
        return this.apelidoPeca;
    }
}
