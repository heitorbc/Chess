/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.poo1.CDP;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author 20121BSI0082
 */
public class Tabuleiro {

    private Map<String, Posicao> tabuleiro = new HashMap<>();

    public Tabuleiro() {
        for (int coluna = 1; coluna <= 8; coluna++) {
            for (int linha = 1; linha <= 8; linha++) {
                    tabuleiro.put(""+coluna+linha, null);
            }
        }
    }
}
