/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifes.poo1.CIH;

import br.edu.ifes.poo1.CDP.Partida;
import java.io.Serializable;

/**
 *
 * @author Henrique
 */
public class Mensagens implements Serializable {
    
    public void imprimeEscolhaPartida(){
        System.out.println("######### PARTIDAS SALVAS ##########");
        System.out.println("Digite o número da partida desejada:");
    }
    
    public void informaNomePartida(){
        System.out.println("Digite o nome da partida a ser salva:");
    }
    
    public void partidaSalva(){
        System.out.println("Partida Salva com Sucesso!!!");
    }
    
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
    
    public void movimentoCaptura(){
        System.out.println("Movimento para captura, use o x no meio.");
    }
    
    public void deuMerda(){
        System.out.println("Deu merda foi para o ultimo retorno");
    }
    
    public void imprimeVez(boolean vezBranco){
        if (vezBranco == true) {
                System.out.println("VEZ BRANCO");
            } else {
                System.out.println("VEZ PRETA");
            }
        
    }
    
    public void imprimeXeque(){
        System.out.println("ATENÇÃO: O SEU REI ESTÁ EM XEQUE!\n"
                + "MOVIMENTE O REI OU CAPTURE A PEÇA ADVERSÁRIA!!!");
    }
    
    public void imprimeXequeMate(){
        System.out.println("#### FIM DE JOGO ####\n XEQUE MATE ");
    }

    public void imprimeFrase(String jog) {
        System.out.println(jog);
    }

    public void imprimeDadosPartida(int contador, Partida p) {
        System.out.println(contador+" - "+p.getDataHoraPartida()+" | "+p.retornaNomesJodadores());
    }
    
    
}
