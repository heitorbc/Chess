/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifes.poo1.CDP;

import br.edu.ifes.poo1.CCI.ControleTotal;
import br.edu.ifes.poo1.CGT.Movimentacao;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import static org.junit.Assert.*;

/**
 *
 * @author Henrique
 */
public class AzureusTest {
    
    public AzureusTest() {
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
     * Test of processaJogadaAzureus method, of class Azureus.
     */
    //@Test
    public void testProcessaJogadaAzureus() {
        System.out.println("processaJogadaAzureus");
        Tabuleiro tabuleiro = null;
        ControleTotal control = null;
        Movimentacao move = null;
        Azureus instance = new Azureus();
        String expResult = "";
        String result = instance.processaJogadaAzureus(tabuleiro,control,move);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
