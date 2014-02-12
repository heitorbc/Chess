/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.poo1.CDP;

import br.edu.ifes.poo1.CDP.Pecas.Bispo;
import br.edu.ifes.poo1.CDP.Pecas.Cavalo;
import br.edu.ifes.poo1.CDP.Pecas.Peao;
import br.edu.ifes.poo1.CDP.Pecas.Dama;
import br.edu.ifes.poo1.CDP.Pecas.Rei;
import br.edu.ifes.poo1.CDP.Pecas.Torre;
import br.edu.ifes.poo1.util.Cor;
import java.util.HashMap;

/**
 *
 * @author 20121BSI0082
 */
public class Tabuleiro {
    
    
    private final HashMap<String, PecaAbstrata> tabuleiro = new HashMap<>();

    public Tabuleiro() {
//        for (int coluna = 1; coluna <= 8; coluna++) {
//            for (int linha = 1; linha <= 8; linha++) {
//                tabuleiro.put(""+coluna+linha,null);                
//                //INSERINDO PECAS DE FIGURAS BRANCOS
//                if(linha==1){
//                    
//                    if((coluna==1)){
//                        tabuleiro.put(""+coluna+linha,new Torre(Cor.BRANCO));
//                    }
//                    else if((coluna==2)){
//                        tabuleiro.put(""+coluna+linha,new Cavalo(Cor.BRANCO));
//                    }
//                    else if((coluna==3)){
//                        tabuleiro.put(""+coluna+linha,new Bispo(Cor.BRANCO));
//                    }
//                    else if(coluna==4){
//                        tabuleiro.put(""+coluna+linha,new Rei(Cor.BRANCO));
//                    }
//                    else if(coluna==5){
//                        tabuleiro.put(""+coluna+linha,new Dama(Cor.BRANCO));
//                    }
//                    else if(coluna==6){
//                        tabuleiro.put(""+coluna+linha,new Bispo(Cor.BRANCO));
//                    }
//                    else if(coluna==7){
//                        tabuleiro.put(""+coluna+linha,new Cavalo(Cor.BRANCO));
//                    }
//                    else if(coluna==8){
//                        tabuleiro.put(""+coluna+linha,new Torre(Cor.BRANCO));
//                    }
//                    
//                }
//                //INSERINDO PEOES BRANCOS
//                else if(linha==2){
//                    tabuleiro.put(""+coluna+linha,new Peao(Cor.BRANCO));
//                }
//                
//                //INSERINDO PEOES PRETOS
//                if(linha==7){
//                    tabuleiro.put(""+coluna+linha,new Peao(Cor.PRETO));
//                }
//                //INSERINDO PECAS DE FIGURAS PRETAS
//                if(linha==8){
//                    if((coluna==8)){
//                        tabuleiro.put(""+coluna+linha,new Torre(Cor.PRETO));
//                    }
//                    else if((coluna==7)){
//                        tabuleiro.put(""+coluna+linha,new Cavalo(Cor.PRETO));
//                    }
//                    else if((coluna==6)){
//                        tabuleiro.put(""+coluna+linha,new Bispo(Cor.PRETO));
//                    }
//                    else if(coluna==5){
//                        tabuleiro.put(""+coluna+linha,new Rei(Cor.PRETO));
//                    }
//                    else if(coluna==4){
//                        tabuleiro.put(""+coluna+linha,new Dama(Cor.PRETO));
//                    }
//                    else if(coluna==3){
//                        tabuleiro.put(""+coluna+linha,new Bispo(Cor.PRETO));
//                    }
//                    else if(coluna==2){
//                        tabuleiro.put(""+coluna+linha,new Cavalo(Cor.PRETO));
//                    }
//                    else if(coluna==1){
//                        tabuleiro.put(""+coluna+linha,new Torre(Cor.PRETO));
//                    }
//                }                    
//            }
//        }
        instanciaTabuleiro();
    }
    
    public PecaAbstrata retornaPeca(String posicao){
        return tabuleiro.get(posicao);
        
    }   
    
    public void trocaPeca(String posAtual,String posProx){
        PecaAbstrata aux = retornaPeca(posAtual);
        tabuleiro.remove(posAtual);
        tabuleiro.put(posProx, aux);
    }
    public void reiniciaTabuleiro(){
        instanciaTabuleiro();
    }
    
    private void instanciaTabuleiro(){
                for (int coluna = 1; coluna <= 8; coluna++) {
            for (int linha = 1; linha <= 8; linha++) {
                tabuleiro.put(""+coluna+linha,null);                
                //INSERINDO PECAS DE FIGURAS BRANCOS
                if(linha==1){
                    
                    if((coluna==1)){
                        tabuleiro.put(""+coluna+linha,new Torre(Cor.BRANCO));
                    }
                    else if((coluna==2)){
                        tabuleiro.put(""+coluna+linha,new Cavalo(Cor.BRANCO));
                    }
                    else if((coluna==3)){
                        tabuleiro.put(""+coluna+linha,new Bispo(Cor.BRANCO));
                    }
                    else if(coluna==4){
                        tabuleiro.put(""+coluna+linha,new Rei(Cor.BRANCO));
                    }
                    else if(coluna==5){
                        tabuleiro.put(""+coluna+linha,new Dama(Cor.BRANCO));
                    }
                    else if(coluna==6){
                        tabuleiro.put(""+coluna+linha,new Bispo(Cor.BRANCO));
                    }
                    else if(coluna==7){
                        tabuleiro.put(""+coluna+linha,new Cavalo(Cor.BRANCO));
                    }
                    else if(coluna==8){
                        tabuleiro.put(""+coluna+linha,new Torre(Cor.BRANCO));
                    }
                    
                }
                //INSERINDO PEOES BRANCOS
                else if(linha==2){
                    tabuleiro.put(""+coluna+linha,new Peao(Cor.BRANCO));
                }
                
                //INSERINDO PEOES PRETOS
                if(linha==7){
                    tabuleiro.put(""+coluna+linha,new Peao(Cor.PRETO));
                }
                //INSERINDO PECAS DE FIGURAS PRETAS
                if(linha==8){
                    if((coluna==8)){
                        tabuleiro.put(""+coluna+linha,new Torre(Cor.PRETO));
                    }
                    else if((coluna==7)){
                        tabuleiro.put(""+coluna+linha,new Cavalo(Cor.PRETO));
                    }
                    else if((coluna==6)){
                        tabuleiro.put(""+coluna+linha,new Bispo(Cor.PRETO));
                    }
                    else if(coluna==5){
                        tabuleiro.put(""+coluna+linha,new Rei(Cor.PRETO));
                    }
                    else if(coluna==4){
                        tabuleiro.put(""+coluna+linha,new Dama(Cor.PRETO));
                    }
                    else if(coluna==3){
                        tabuleiro.put(""+coluna+linha,new Bispo(Cor.PRETO));
                    }
                    else if(coluna==2){
                        tabuleiro.put(""+coluna+linha,new Cavalo(Cor.PRETO));
                    }
                    else if(coluna==1){
                        tabuleiro.put(""+coluna+linha,new Torre(Cor.PRETO));
                    }
                }                    
            }
        }

    }
}