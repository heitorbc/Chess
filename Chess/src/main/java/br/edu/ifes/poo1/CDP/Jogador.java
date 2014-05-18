/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.poo1.CDP;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author 20121BSI0082
 */
public class Jogador implements Serializable {

    private ArrayList<Integer> pontos = new ArrayList<>();
    private HashMap<String, ArrayList<Integer>> jogadores = new HashMap<>();

    public HashMap<String, ArrayList<Integer>> getJogadores() {
        return jogadores;
    }

    public void setJogadores(HashMap<String, ArrayList<Integer>> jogadores) {
        this.jogadores = jogadores;
    }

    
    public void criaJogador(String nome) {
        for (int i = 0; i < 3; i++) {
            pontos.add(0);
        }
        jogadores.put(nome, pontos);
    }
    public void setPontuacaoJogador(String nome, ArrayList<Integer> pontos){
        jogadores.put(nome, pontos);
    }

     
    public ArrayList<Integer> retornaArrayPontos(String nome) {
        ArrayList<Integer> pontuacao = new ArrayList<>();
        Integer vitoria, derrota, empate;
        pontuacao.add(jogadores.get(nome).get(0));
        pontuacao.add(jogadores.get(nome).get(1));
        pontuacao.add(jogadores.get(nome).get(2));

        return pontuacao;
    }

    public String retornaPontos(String nome) {
        ArrayList<Integer> pontuacao = new ArrayList<>();
        Integer vitoria, derrota, empate;
        vitoria = jogadores.get(nome).get(0);
        derrota = jogadores.get(nome).get(1);
        empate = jogadores.get(nome).get(2);
        return vitoria + "," + derrota + "," + empate;
    }
    
    

    public String retornaVitoria(String nome) {
        ArrayList<Integer> pontuacao = new ArrayList<>();
        Integer vitoria;
        vitoria = jogadores.get(nome).get(0);
        return vitoria + "";
    }

    public String retornaDerrota(String nome) {
        ArrayList<Integer> pontuacao = new ArrayList<>();
        Integer derrota;
        derrota = jogadores.get(nome).get(1);
        return derrota + "";
    }

    public String retornaEmpate(String nome) {
        ArrayList<Integer> pontuacao = new ArrayList<>();
        Integer empate;
        empate = jogadores.get(nome).get(2);
        return empate + "";
    }

    public void addPontuacao(String nome, String tipo) {
        ArrayList<Integer> pontuacao = new ArrayList<>();
        Integer vitoria, derrota, empate;
        vitoria = jogadores.get(nome).get(0);
        derrota = jogadores.get(nome).get(1);
        empate = jogadores.get(nome).get(2);

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
        jogadores.put(nome, pontuacao);

    }


}
