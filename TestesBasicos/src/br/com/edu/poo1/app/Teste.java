/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.edu.poo1.app;

/**
 *
 * @author Henrique
 */
public class Teste {
    
    public static void ChamaEu() {
        System.out.println("Obrigado por me chamar");
    }
    
    public static void main(String[] args) {
        System.out.println("Hello Word!!");
        int[] vet = {1, 2, 3, 4};
        vet[1] = 33;
        System.out.println(vet[1]);

		//Scanner treco
		//System.out.println(treco);
        ChamaEu();

    }
}

