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
public class PeaoTest {
    
    public PeaoTest() {
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
     * Test of podeAndarQuanto method, of class Peao.
     */
    @Test
    public void testPodeAndarQuanto() {
        System.out.println("podeAndarQuanto");
        String posicaoAtual = "21";
        String proximaPosicao = "31";
        boolean expResult = true;
        boolean result = new Peao(Cor.PRETO).podeAndarQuanto(posicaoAtual, proximaPosicao);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testPodeAndarQuanto1() {
        System.out.println("podeAndarQuanto");
        String posicaoAtual = "22";
        String proximaPosicao = "42";
        boolean expResult = true;
        boolean result = new Peao(Cor.PRETO).podeAndarQuanto(posicaoAtual, proximaPosicao);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
   
    @Test
    public void testPodeAndarQuanto2() {
        System.out.println("podeAndarQuanto");
        String posicaoAtual = "72";
        String proximaPosicao = "62";
        boolean expResult = true;
        boolean result = new Peao(Cor.PRETO).podeAndarQuanto(posicaoAtual, proximaPosicao);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testPodeAndarQuanto3() {
        System.out.println("podeAndarQuanto");
        String posicaoAtual = "21";
        String proximaPosicao = "11";
        boolean expResult = false;
        boolean result = new Peao(Cor.PRETO).podeAndarQuanto(posicaoAtual, proximaPosicao);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testPodeAndarQuanto4() {
        System.out.println("podeAndarQuanto");
        String posicaoAtual = "72";
        String proximaPosicao = "82";
        boolean expResult = false;
        boolean result = new Peao(Cor.PRETO).podeAndarQuanto(posicaoAtual, proximaPosicao);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    public void testPodeAndarQuanto5() {
        System.out.println("podeAndarQuanto");
        String posicaoAtual = "31";
        String proximaPosicao = "31";
        boolean expResult = false;
        boolean result = new Peao(Cor.PRETO).podeAndarQuanto(posicaoAtual, proximaPosicao);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    

    /**
     * Test of podeCapturar method, of class Peao.
     */
    public void testPodeCapturar() {
        System.out.println("podeCapturar");
        String posicaoAtual = "";
        String proximaPosicao = "";
        Peao instance = null;
        boolean expResult = false;
        boolean result = instance.podeCapturar(posicaoAtual, proximaPosicao);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
