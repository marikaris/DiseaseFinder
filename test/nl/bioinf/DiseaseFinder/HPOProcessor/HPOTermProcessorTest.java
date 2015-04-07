/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.bioinf.DiseaseFinder.HPOProcessor;

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
public class HPOTermProcessorTest {
    public HPOTermProcessorTest() {
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
     * Test of main method, of class HPOTermProcessor.
     */
    @Test
    public final void testMain() throws Exception {
        System.out.println("main");
        String[] args = {"test"};
        HPOTermProcessor.main(args);
    }
    /**
     * Test of hpoTermSplitter method, of class HPOTermProcessor.
     */
    @Test
    public void testHpoTermSplitter() {
        System.out.println("hpoTermSplitter");
        String hpoFile = "term1[Term]term2";
        HPOTermProcessor instance = new HPOTermProcessor();
        String[] expResult = {"term1", "term2"};
        String[] result = instance.hpoTermSplitter(hpoFile);
        assertArrayEquals(expResult, result);
    }
    /**
     * Test of hpoTermSplitter method, of class HPOTermProcessor.
     * With hpoFile null
     */
    @Test(expected = NullPointerException.class)
    public void testHpoTermSplitterNull() {
        System.out.println("hpoTermSplitter");
        String hpoFile = null;
        HPOTermProcessor instance = new HPOTermProcessor();
        String[] expResult = {};
        String[] result = instance.hpoTermSplitter(hpoFile);
        assertArrayEquals(expResult, result);
    }
    /**
     * Test of hpoObjectCreator method, of class HPOTermProcessor.
     */
    @Test
    public void testHpoObjectCreator() {
        System.out.println("hpoObjectCreator");
        String[] seperateHpoTerms = {"term1", "term2"};
        HPOTermProcessor instance = new HPOTermProcessor();
        HPOTermCollector expResult = new HPOTermCollector();
        HPOTermCollector result = instance.hpoObjectCreator(seperateHpoTerms);
        assertEquals(expResult.getClass(), result.getClass());
    }
}
