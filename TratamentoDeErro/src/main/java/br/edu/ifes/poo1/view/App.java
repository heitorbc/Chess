package br.edu.ifes.poo1.view;


import br.edu.ifes.poo1.model.Tratamento;
import control.Controle;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    
    
    public static void main( String[] args )
    {
        double num1,num2;
        //Controle controle = new Controle();
        Tratamento trata = new Tratamento();
        Scanner entrada = new Scanner(System.in);
        do{
            System.out.println("Numero 1");
            num1 = entrada.nextDouble();
            entrada.nextLine();
            System.out.println("Numero 2");
            num2 = entrada.nextDouble();
            entrada.nextLine();

            trata.erro(num1, num2);
            
        }while(trata.erro(num1,num2) == true);
    }
}
