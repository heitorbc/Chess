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
    
    
    public void empate(String Jogador1,String Jogador2,boolean vezBranco){
        String alerta="??EMPATE?? :";
        if(vezBranco == true){
            System.out.println(alerta+Jogador1+" Deseja Aceitar Empate proposto por "+Jogador2+ " ??('S' ou 'N')");
        }else{
            System.out.println(alerta+Jogador2+" Deseja Aceitar Empate proposto por "+Jogador1+ " ??('S' ou 'N')");
        }
        
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
        System.out.println("Nome Jogador 1:");
    }
    
    public void nomeJogadorDois (){
        System.out.println("Nome Jogador 2:");
    }
    public void jogadaJ1(String jogador1){
            System.out.println("Digite a jogada "+ jogador1+" (B) :");
    }
    public void jogadaJ2(String jogador2){
            System.out.println("Digite a jogada "+ jogador2+" (P) :");
    }
                  
    public void naoEhSuaVez(){
        System.out.println("Não é a SUA Peça!!! Jogue Novamente...");
    }
}
