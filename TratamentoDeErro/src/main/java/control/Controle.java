/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package control;

import br.edu.ifes.poo1.model.Tratamento;

/**
 *
 * @author Henrique
 */
public class Controle {
    
    public boolean conta(double num1, double num2){
        Tratamento trata = new Tratamento();
        return trata.erro(num1, num2);
    }
    
}
