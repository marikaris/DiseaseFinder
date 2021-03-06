/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.bioinf.DiseaseFinder.HPOProcessor;

import java.util.ArrayList;
import java.util.HashMap;
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
public class HPOTermCollectionTest {
    public HPOTermCollectionTest() {
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
     * Test of addToHPOHashMap method, of class HPOTermCollection.
     */
    @Test
    public final void testAddToHPOHashMap() {
        System.out.println("addToHPOList");
        HPOTerm hpoTerm = new HPOTerm();
        hpoTerm.setId("hpoTerm");
        HPOTermCollection instance = new HPOTermCollection();
        instance.addToHPOHashMap(hpoTerm.getId(), hpoTerm);
        HashMap<String, HPOTerm> hpoHash = new HashMap();
        hpoHash.put("hpoTerm", hpoTerm);
        assertEquals(instance.getHPOHashMap(), hpoHash);
    }
    /**
     * Test of addToHPOHashMap method, of class HPOTermCollection.
     * With hpoTerm null
     */
    @Test(expected = NullPointerException.class)
    public final void testAddToHPOListNull() {
        System.out.println("addToHPOList");
        HPOTerm hpoTerm = null;
        HPOTermCollection instance = new HPOTermCollection();
        instance.addToHPOHashMap("hpoTerm", hpoTerm);
    }

    /**
     * Test of getHPOHashMap method, of class HPOTermCollection.
     */
    @Test
    public final void testGetHPOHashMap() {
        System.out.println("getHPOList");
        HPOTermCollection instance = new HPOTermCollection();
        HashMap<String, HPOTerm> expResult = new HashMap();
        HashMap<String, HPOTerm> result = instance.getHPOHashMap();
        assertEquals(expResult.getClass(), result.getClass());
    }
}
