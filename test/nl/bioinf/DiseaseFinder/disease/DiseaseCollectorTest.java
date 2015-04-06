/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.bioinf.DiseaseFinder.disease;

import java.io.IOException;
import java.util.HashMap;
import org.json.JSONException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * This class tests the diseasecollector object.
 * @author mkslofstra
 */
public class DiseaseCollectorTest {

    public DiseaseCollectorTest() {
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
     * Test of getDiseaseCollection method, of class DiseaseCollector.
     */
    @Test
    public void testGetDiseaseCollection() throws JSONException, IOException {
        System.out.println("getDiseaseCollection");
        String mimNumber = "666666";
        HashMap features = new HashMap();
        features.put("Horns", "yes");
        features.put("Evil", "yes");
        Disease devilsDisease = new Disease("666666", "devils disease",
                features);
         String[] givenFeatures = new String[]{"dizziness", "blurry vision",
            "ptosis"};
        DiseaseCollector instance = new DiseaseCollector(givenFeatures);
        instance.addToDiseaseCollection(devilsDisease, mimNumber);
        HashMap<String, Disease> result = instance.getDiseaseCollection();
        assertTrue(result.containsKey("666666") && result.get("666666")
                != null);
    }

    /**
     * Test of addToDiseaseCollection method, of class DiseaseCollector.
     */
    @Test
    public void testAddToDiseaseCollection() throws JSONException, IOException {
        System.out.println("addToDiseaseCollection");
        String mimNumber = "666666";
        HashMap features = new HashMap();
        features.put("Horns", "yes");
        features.put("Evil", "yes");
        Disease devilsDisease = new Disease("666666", "devils disease",
                features);
         String[] givenFeatures = new String[]{"dizziness", "blurry vision",
            "ptosis"};
        DiseaseCollector instance = new DiseaseCollector(givenFeatures);
        instance.addToDiseaseCollection(devilsDisease, mimNumber);
    }
        /**
     * Test of addToDiseaseCollection method, of class DiseaseCollector.
     */
    @Test (expected=NullPointerException.class)
    public void testAddNull() throws JSONException, IOException {
        System.out.println("addToDiseaseCollection");
        String mimNumber = null;
        HashMap features = new HashMap();
        features.put("Horns", "yes");
        features.put("Evil", "yes");
        Disease devilsDisease = new Disease("666666", "devils disease",
                features);
         String[] givenFeatures = new String[]{"dizziness", "blurry vision",
            "ptosis"};
        DiseaseCollector instance = new DiseaseCollector(givenFeatures);
        instance.addToDiseaseCollection(null, mimNumber);
        System.out.println(instance.getDiseaseCollection());
    }

}
