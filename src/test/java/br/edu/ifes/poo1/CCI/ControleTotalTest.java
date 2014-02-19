/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifes.poo1.CCI;

import br.edu.ifes.poo1.CDP.Tabuleiro;
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
public class ControleTotalTest {
    
    public ControleTotalTest() {
        
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
     * Test of iniciaMenu method, of class ControleTotal.
     */
    @Test
    public void testIniciaMenu() throws ClassNotFoundException {
        System.out.println("iniciaMenu");
        ControleTotal instance = null;
        instance.iniciaMenu();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of controlaJogadas method, of class ControleTotal.
     */
    @Test
    
    
    
    public void testControlaJogadas() throws ClassNotFoundException {
        Tabuleiro inst = new Tabuleiro();
        System.out.println("controlaJogadas");
        String jog = "desistir";
        ControleTotal instance = null;
        instance.controlaJogadas(jog);

        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    
    
    
    /**
     * Test of iniciaJogada method, of class ControleTotal.
     */
    
    
    
    
    
    
    @Test
    public void testIniciaJogada() throws ClassNotFoundException {
        System.out.println("iniciaJogada");
        ControleTotal instance = null;
        instance.iniciaJogada();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of processaJogador method, of class ControleTotal.
     */
    @Test
    public void testProcessaJogador() {
        System.out.println("processaJogador");
        ControleTotal instance = null;
        instance.processaJogador();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
