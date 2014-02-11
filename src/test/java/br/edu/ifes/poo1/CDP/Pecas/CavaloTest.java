/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifes.poo1.CDP.Pecas;

import br.edu.ifes.poo1.util.Cor;
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
        String posicaoAtual = "46";
        String proximaPosicao = "65";
        boolean expResult = true;
        boolean result = new Cavalo(Cor.PRETO).podeAndarQuanto(posicaoAtual, proximaPosicao);
        assertEquals("Espero Verdadeiro",expResult, result);
        // FAil, espero que ocorra um erro.
        //fail("The test case is a prototype.");
    }

   @Test
    public void testPodeAndarQuanto1() {
        System.out.println("podeAndarQuanto");
        String posicaoAtual = "46";
        String proximaPosicao = "27";
        boolean expResult = true;
        boolean result = new Cavalo(Cor.PRETO).podeAndarQuanto(posicaoAtual, proximaPosicao);
        assertEquals("Espero Verdadeiro",expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    @Test
    public void testPodeAndarQuanto2() {
        System.out.println("podeAndarQuanto");
        String posicaoAtual = "46";
        String proximaPosicao = "25";
        boolean expResult = true;
        boolean result = new Cavalo(Cor.PRETO).podeAndarQuanto(posicaoAtual, proximaPosicao);
        assertEquals("Espero Verdadeiro",expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    @Test
    public void testPodeAndarQuanto3() {
        System.out.println("podeAndarQuanto");
        String posicaoAtual = "46";
        String proximaPosicao = "38";
        boolean expResult = true;
        boolean result = new Cavalo(Cor.PRETO).podeAndarQuanto(posicaoAtual, proximaPosicao);
        assertEquals("Espero Verdadeiro",expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    @Test
    public void testPodeAndarQuanto4() {
        System.out.println("podeAndarQuanto");
        String posicaoAtual = "46";
        String proximaPosicao = "67";
        boolean expResult = true;
        boolean result = new Cavalo(Cor.PRETO).podeAndarQuanto(posicaoAtual, proximaPosicao);
        assertEquals("Espero Verdadeiro",expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    @Test
    public void testPodeAndarQuantoFalse() {
        System.out.println("podeAndarQuanto");
        String posicaoAtual = "46";
        String proximaPosicao = "16";
        boolean expResult = false;
        boolean result = new Cavalo(Cor.PRETO).podeAndarQuanto(posicaoAtual, proximaPosicao);
        assertEquals(" Espero False",expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testPodeAndarQuantoFalse1() {
        System.out.println("podeAndarQuanto");
        String posicaoAtual = "46";
        String proximaPosicao = "56";
        boolean expResult = false;
        boolean result = new Cavalo(Cor.PRETO).podeAndarQuanto(posicaoAtual, proximaPosicao);
        assertEquals(" Espero False",expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /**
     * Test of podeCapturar method, of class Cavalo.
     */
   
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
