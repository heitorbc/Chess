/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifes.poo1.model;

import java.util.InputMismatchException;

/**
 *
 * @author Henrique
 */
public class Tratamento {
    double result;
    //boolean bug = true;
    
    public boolean erro(double num1, double num2) throws InputMismatchException, ArithmeticException{
        
        try{
            System.out.println("Resultado" + num1 / num2 );
            return false;
        }catch (InputMismatchException e1 ){
            System.out.println("Digite números");
            e1.getMessage();
            return true;
        }
        catch(ArithmeticException e2){
            System.out.println("Não é possível fazer a divisão");
            e2.getMessage();
            return true;
        }
    } 
}
