/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifes.poo1.CIH;

/**
 *
 * @author Henrique
 */
public class Mensagens {
    
    
    public void empate(){
        System.out.println("Partida empatada, deseja iniciar outra? ('S' ou 'N')");
    }
    
    public void opcaoInvalidaFim(){
        System.out.println("Opção inválida, jogo encerrado!");
    }
    
    public void opcaoInvalida(){
        System.out.println("Opção Inválida");
    }
    
    public void movimentoInvalido(){
        System.out.println("***Erro*** Movimento Inválido");
    }
    
    public void entradaInvalida(){
        System.out.println("***Erro*** Entrada Inválido");
    }
    public void nomeJogadorUm (){
        System.out.println("Nome: Jogador 1:");
    }
    
    public void nomeJogadorDois (){
        System.out.println("Nome: Jogador 2:");
    }
}
