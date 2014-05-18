/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifes.poo1.CGD;

import java.io.Serializable;
import java.util.ArrayList;
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
public class DadosTest {
    
    public DadosTest() {
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
     * Test of savePartida method, of class Dados.
     */
    
    public void testSavePartida() throws Exception {
        System.out.println("savePartida");
        Object partida = null;
        Dados instance = new Dados();
        instance.savePartida((Serializable) partida);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of loadPartida method, of class Dados.
     */
    
    public void testLoadPartida() throws Exception {
        System.out.println("loadPartida");
        Dados instance = new Dados();
        ArrayList expResult = null;
        ArrayList result = instance.loadPartida();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
