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
public class TorreTest {
    
    public TorreTest() {
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
     * Test of podeAndarQuanto method, of class Torre.
     */
    @Test
    public void testPodeAndarQuanto() {
        System.out.println("podeAndarQuanto");
        String posicaoAtual = "44";
        String proximaPosicao = "84";        
        boolean expResult = true;
        boolean result = new Torre(Cor.PRETO).podeAndarQuanto(posicaoAtual, proximaPosicao);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testPodeAndarQuanto1() {
        System.out.println("podeAndarQuanto");
        String posicaoAtual = "44";
        String proximaPosicao = "64";        
        boolean expResult = true;
        boolean result = new Torre(Cor.PRETO).podeAndarQuanto(posicaoAtual, proximaPosicao);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testPodeAndarQuanto2() {
        System.out.println("podeAndarQuanto");
        String posicaoAtual = "44";
        String proximaPosicao = "54";        
        boolean expResult = true;
        boolean result = new Torre(Cor.PRETO).podeAndarQuanto(posicaoAtual, proximaPosicao);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testPodeAndarQuanto3() {
        System.out.println("podeAndarQuanto");
        String posicaoAtual = "44";
        String proximaPosicao = "41";        
        boolean expResult = true;
        boolean result = new Torre(Cor.PRETO).podeAndarQuanto(posicaoAtual, proximaPosicao);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testPodeAndarQuanto4() {
        System.out.println("podeAndarQuanto");
        String posicaoAtual = "44";
        String proximaPosicao = "35";        
        boolean expResult = false;
        boolean result = new Torre(Cor.PRETO).podeAndarQuanto(posicaoAtual, proximaPosicao);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testPodeAndarQuanto5() {
        System.out.println("podeAndarQuanto");
        String posicaoAtual = "44";
        String proximaPosicao = "52";        
        boolean expResult = false;
        boolean result = new Torre(Cor.PRETO).podeAndarQuanto(posicaoAtual, proximaPosicao);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testPodeAndarQuanto6() {
        System.out.println("podeAndarQuanto");
        String posicaoAtual = "88";
        String proximaPosicao = "77";        
        boolean expResult = false;
        boolean result = new Torre(Cor.PRETO).podeAndarQuanto(posicaoAtual, proximaPosicao);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testPodeAndarQuanto7() {
        System.out.println("podeAndarQuanto");
        String posicaoAtual = "88";
        String proximaPosicao = "17";        
        boolean expResult = false;
        boolean result = new Torre(Cor.PRETO).podeAndarQuanto(posicaoAtual, proximaPosicao);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of podeCapturar method, of class Torre.
     */
    public void testPodeCapturar() {
        System.out.println("podeCapturar");
        String posicaoAtual = "";
        String proximaPosicao = "";
        Torre instance = null;
        boolean expResult = false;
        boolean result = instance.podeCapturar(posicaoAtual, proximaPosicao);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
