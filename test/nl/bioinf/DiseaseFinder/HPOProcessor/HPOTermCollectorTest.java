/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.bioinf.DiseaseFinder.HPOProcessor;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Arne
 */
public class HPOTermCollectorTest {
    public HPOTermCollectorTest() {
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
     * Test of addToHPOList method, of class HPOTermCollector.
     */
    @Test
    public final void testAddToHPOList() {
        System.out.println("addToHPOList");
        Object hpoTerm = "hpoTerm";
        HPOTermCollector instance = new HPOTermCollector();
        instance.addToHPOList(hpoTerm);
    }
    /**
     * Test of addToHPOList method, of class HPOTermCollector.
     * With hpoTerm null
     */
    @Test(expected = NullPointerException.class)
    public final void testAddToHPOListNull() {
        System.out.println("addToHPOList");
        Object hpoTerm = null;
        HPOTermCollector instance = new HPOTermCollector();
        instance.addToHPOList(hpoTerm);
    }

    /**
     * Test of getHPOList method, of class HPOTermCollector.
     */
    @Test
    public final void testGetHPOList() {
        System.out.println("getHPOList");
        HPOTermCollector instance = new HPOTermCollector();
        List expResult = new ArrayList();
        List result = instance.getHPOList();
        assertEquals(expResult.getClass(), result.getClass());
    }
}
