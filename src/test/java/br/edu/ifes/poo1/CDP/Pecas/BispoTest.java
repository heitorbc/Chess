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
public class BispoTest {
    
    public BispoTest() {
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
     * Test of podeAndarQuanto method, of class Bispo.
     */
    @Test
    public void testPodeAndarQuanto() {
        System.out.println("podeAndarQuanto");
        String posicaoAtual = "44";
        String proximaPosicao = "54";
        boolean expResult = false;
        boolean result = new Bispo(Cor.PRETO).podeAndarQuanto(posicaoAtual, proximaPosicao);
        System.out.println(result);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
            
    }
    
    @Test
    public void testPodeAndarQuanto1() {
        System.out.println("podeAndarQuanto");
        String posicaoAtual = "44";
        String proximaPosicao = "45";
        boolean expResult = false;
        boolean result = new Bispo(Cor.PRETO).podeAndarQuanto(posicaoAtual, proximaPosicao);
        System.out.println(result);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testPodeAndarQuanto2() {
        System.out.println("podeAndarQuanto");
        String posicaoAtual = "44";
        String proximaPosicao = "45";
        boolean expResult = false;
        boolean result = new Bispo(Cor.PRETO).podeAndarQuanto(posicaoAtual, proximaPosicao);
        System.out.println(result);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    
    @Test
    public void testPodeAndarQuanto3() {
        System.out.println("podeAndarQuanto");
        String posicaoAtual = "44";
        String proximaPosicao = "34";
        boolean expResult = false;
        boolean result = new Bispo(Cor.PRETO).podeAndarQuanto(posicaoAtual, proximaPosicao);
        System.out.println(result);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testPodeAndarQuanto4() {
        System.out.println("podeAndarQuanto");
        String posicaoAtual = "44";
        String proximaPosicao = "41";
        boolean expResult = false;
        boolean result = new Bispo(Cor.PRETO).podeAndarQuanto(posicaoAtual, proximaPosicao);
        System.out.println(result);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testPodeAndarQuanto5() {
        System.out.println("podeAndarQuanto");
        String posicaoAtual = "44";
        String proximaPosicao = "48";
        boolean expResult = false;
        boolean result = new Bispo(Cor.PRETO).podeAndarQuanto(posicaoAtual, proximaPosicao);
        System.out.println(result);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testPodeAndarQuanto6() {
        System.out.println("podeAndarQuanto");
        String posicaoAtual = "72";
        String proximaPosicao = "82";
        boolean expResult = false;
        boolean result = new Bispo(Cor.PRETO).podeAndarQuanto(posicaoAtual, proximaPosicao);
        System.out.println(result);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testPodeAndarQuanto7() {
        System.out.println("podeAndarQuanto");
        String posicaoAtual = "72";
        String proximaPosicao = "73";
        boolean expResult = false;
        boolean result = new Bispo(Cor.PRETO).podeAndarQuanto(posicaoAtual, proximaPosicao);
        System.out.println(result);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    /**
     * Test of podeCapturar method, of class Bispo.
     */

    public void testPodeCapturar() {
        System.out.println("podeCapturar");
        String posicaoAtual = "";
        String proximaPosicao = "";
        Bispo instance = null;
        boolean expResult = false;
        boolean result = instance.podeCapturar(posicaoAtual, proximaPosicao);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
