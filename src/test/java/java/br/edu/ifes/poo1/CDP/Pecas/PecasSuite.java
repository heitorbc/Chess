/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package java.br.edu.ifes.poo1.CDP.Pecas;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Henrique
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({br.edu.ifes.poo1.CDP.Pecas.CavaloTest.class, br.edu.ifes.poo1.CDP.Pecas.PeaoTest.class, br.edu.ifes.poo1.CDP.Pecas.BispoTest.class, br.edu.ifes.poo1.CDP.Pecas.TorreTest.class, br.edu.ifes.poo1.CDP.Pecas.ReiTest.class, br.edu.ifes.poo1.CDP.Pecas.DamaTest.class})
public class PecasSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
