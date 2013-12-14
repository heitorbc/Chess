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
    BISPO("b"),CAVALO("c"),PEAO("p"),RAINHA("r"),REI("r"),TORRE("t");
    
    public String apelidoPeca;

    PecaNome(String apelido) {
        apelidoPeca = apelido;
    }       
}
