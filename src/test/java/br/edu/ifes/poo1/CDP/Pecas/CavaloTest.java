/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifes.poo1.CDP.Pecas;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Henrique
 */
public class CavaloTest {
    
    public CavaloTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of podeAndarQuanto method, of class Cavalo.
     */
    @Test
    public void testPodeAndarQuanto() {
        System.out.println("podeAndarQuanto");
        String posicaoAtual = "";
        String proximaPosicao = "";
        Cavalo instance = null;
        boolean expResult = false;
        boolean result = instance.podeAndarQuanto(posicaoAtual, proximaPosicao);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of podeCapturar method, of class Cavalo.
     */
    @Test
    public void testPodeCapturar() {
        System.out.println("podeCapturar");
        String posicaoAtual = "";
        String proximaPosicao = "";
        Cavalo instance = null;
        boolean expResult = false;
        boolean result = instance.podeCapturar(posicaoAtual, proximaPosicao);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
