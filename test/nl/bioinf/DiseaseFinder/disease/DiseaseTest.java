/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.bioinf.DiseaseFinder.disease;

import java.util.HashMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * This class tests the disease object.
 * @author mkslofstra
 */
public class DiseaseTest {

    public DiseaseTest() {
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
     * Test of getHits method, of class Disease.
     */
    @Test
    public void testGetHits() {
        System.out.println("getHits");
        HashMap features = new HashMap();
        features.put("Horns", "yes");
        features.put("Evil", "yes");
        Disease instance = new Disease("666666", "devils disease", features);
        Integer expResult = 1;
        Integer result = instance.getHits();
        assertEquals(expResult, result);
    }

    /**
     * Test of setHits method, of class Disease.
     */
    @Test
    public void testSetHits() {
        System.out.println("setHits");
        HashMap features = new HashMap();
        features.put("Horns", "yes");
        features.put("Evil", "yes");
        Disease instance = new Disease("666666", "devils disease", features);
        Integer count = 2;
        instance.setHits(count);
    }

    /**
     * Test of getScore method, of class Disease.
     */
    @Test
    public void testGetScore() {
        System.out.println("getScore");
        HashMap features = new HashMap();
        features.put("Horns", "yes");
        features.put("Evil", "yes");
        Disease instance = new Disease("666666", "devils disease", features);
        Double expResult = 3.2;
        instance.setScore(3.2);
        Double result = instance.getScore();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Disease.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        HashMap features = new HashMap();
        features.put("Horns", "yes");
        features.put("Evil", "yes");
        Disease instance = new Disease("666666", "devils disease", features);
        String expResult = "devils disease\n"
                + "mimNumber : 666666, hits : 1\n"
                + "\n"
                + "Horns\n"
                + "yes\n"
                + "\n"
                + "Evil\n"
                + "yes";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of setScore method, of class Disease.
     */
    @Test
    public void testSetScore() {
        System.out.println("setScore");
        Double givenScore = 3.2;
        HashMap features = new HashMap();
        features.put("Horns", "yes");
        features.put("Evil", "yes");
        Disease instance = new Disease("666666", "devils disease", features);
        instance.setScore(givenScore);
    }

    /**
     * Test of getMimNumber method, of class Disease.
     */
    @Test
    public void testGetMimNumber() {
        System.out.println("getMimNumber");
        HashMap features = new HashMap();
        features.put("Horns", "yes");
        features.put("Evil", "yes");
        Disease instance = new Disease("666666", "devils disease", features);
        String expResult = "666666";
        String result = instance.getMimNumber();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTitle method, of class Disease.
     */
    @Test
    public void testGetTitle() {
        System.out.println("getTitle");
        HashMap features = new HashMap();
        features.put("Horns", "yes");
        features.put("Evil", "yes");
        Disease instance = new Disease("666666", "devils disease", features);
        String expResult = "devils disease";
        String result = instance.getTitle();
        assertEquals(expResult, result);
    }

    /**
     * Test of getFeatures method, of class Disease.
     */
    @Test
    public void testGetFeatures() {
        System.out.println("getFeatures");
        HashMap features = new HashMap();
        features.put("Horns", "yes");
        features.put("Evil", "yes");
        Disease instance = new Disease("666666", "devils disease", features);
        HashMap expResult = features;
        HashMap result = instance.getFeatures();
        assertEquals(expResult, result);
    }

    /**
     * Test if the class throws an illegalArgumentException if the length of
     * the omim number is not 6.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testLengthMimNumber() {
        System.out.println("getFeatures");
        HashMap features = new HashMap();
        features.put("Horns", "yes");
        features.put("Evil", "yes");
        Disease instance = new Disease("666", "devils disease", features);
    }

}
