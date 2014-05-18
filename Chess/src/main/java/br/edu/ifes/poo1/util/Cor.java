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
public enum Cor implements Serializable{
    BRANCO("(B)"),PRETO("(P)");
    
    public String getCorPeca() {
        return corPeca;
    }    
    private final String corPeca;

    private Cor(String corPeca) {
        this.corPeca = corPeca;
    }
    private String corPeca(){
        return this.corPeca;
    }
}
