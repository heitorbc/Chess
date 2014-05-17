/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifes.poo1.util;

/**
 *
 * @author Henrique
 */
public enum PecaNome {
    BISPO(" B "),CAVALO(" C "),PEAO(" P "),DAMA(" D "),REI(" K "),TORRE(" T ");

    public String getApelidoPeca() {
        return apelidoPeca;
    }
    
    private final String apelidoPeca;

    private PecaNome(String apelido) {
        apelidoPeca = apelido;
    }
    private String apelidoPeca(){
        return this.apelidoPeca;
    }
}
