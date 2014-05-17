package com.mycompany.reflectionteste2;

import java.lang.reflect.Array;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws ClassNotFoundException
    {
        Class cls = Class.forName("java.lang.String");
        Object arr = Array.newInstance(cls, 15);
        Array.set(arr, 5, "Isto é um teste");
        String s = (String) Array.get(arr, 5);
        System.out.println(s);
    }
}
