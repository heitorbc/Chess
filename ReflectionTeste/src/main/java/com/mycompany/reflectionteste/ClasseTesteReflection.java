/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.reflectionteste;

/**
 *
 * @author Henrique
 */
public class ClasseTesteReflection {
    public int funcao1(Object p, int x) throws NullPointerException {
        if (p == null) {
            throw new NullPointerException();
        }
        return x;
    }
}
