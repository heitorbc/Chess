/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.poo1.CDP;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author 20121BSI0082
 */
public class Jogador {
      
   

    ArrayList<Integer> pontos = new ArrayList<>();
    private final HashMap<String, ArrayList<Integer>> jogador = new HashMap<>();

    
    // Fazer algo do tipo, jogador branco é o 0, e preto o 1
    public void criaJogador(String nome) {
        for (int i = 0; i < 3; i++) {
            pontos.add(0);
        }
        jogador.put(nome, pontos);

    }

    public String retornaPontos(String nome) {
        ArrayList<Integer> pontuacao = new ArrayList<>();
        Integer vitoria, derrota, empate;
        vitoria = jogador.get(nome).get(0);
        derrota = jogador.get(nome).get(1);
        empate = jogador.get(nome).get(2);
        return vitoria + "," + derrota + "," + empate;
    }

    public void addPontuacao(String nome, String tipo) {
        ArrayList<Integer> pontuacao = new ArrayList<>();
        Integer vitoria, derrota, empate;
        vitoria = jogador.get(nome).get(0);
        derrota = jogador.get(nome).get(1);
        empate = jogador.get(nome).get(2);

        switch (tipo) {
            case "v":
                vitoria++;
                break;
            case "d":
                derrota++;
                break;
            case "e":
                empate++;
                break;
        }
        pontuacao.add(vitoria);
        pontuacao.add(derrota);
        pontuacao.add(empate);
        jogador.put(nome, pontuacao);

    }

}
