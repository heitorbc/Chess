/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifes.poo1.CGD;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author Henrique
 */
public class Dados <T extends Serializable> {

    public void saveUsuario(T objeto) {

        try {
            /*Tenta salvar os dados do usuario*/
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("partida.dat"));           
            out.writeObject(objeto);
            out.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public T loadUsuario() throws ClassNotFoundException {

        try {
            File testeArquivo = new File("partida.dat");
            if (testeArquivo.exists()) {
                /*Se o arquivo existir ele faz o load*/
                ObjectInputStream in = new ObjectInputStream(new FileInputStream("partida.dat"));
                T usuarioReturn = (T) in.readObject();
                in.close();
                return (T) usuarioReturn;
            } 
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}