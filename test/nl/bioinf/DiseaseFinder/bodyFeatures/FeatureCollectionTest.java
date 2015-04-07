/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.bioinf.DiseaseFinder.bodyFeatures;

import java.util.Arrays;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mkslofstra
 */
public class FeatureCollectionTest {

    public FeatureCollectionTest() {
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
     * Test of getGlobalFeatures method, of class FeatureCollection.
     */
    @Test
    public void testGetGlobalFeatures() {
        System.out.println("getGlobalFeatures");
        FeatureCollection instance = new FeatureCollection();
        String[] expResult = new String[]{"growth", "headAndNeck",
            "cardiovascular", "respiratory", "chest", "abdomen",
            "genitourinary", "skeletal", "skinNailsHair", "muscleSoftTissue",
            "neurologic", "voice", "metabolicFeatures", "endocrineFeatures",
            "hematology", "immunology", "neoplasia", "prenatalManifestations",
            "laboratoryAbnormalities", "miscellaneous", "molecularBasis",
            "oldFormat"};
        String[] result = instance.getGlobalFeatures();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of extendFeature method, of class FeatureCollection.
     */
    @Test
    public void testExtendFeature() {
        System.out.println("extendFeature");
        String feature = "growth";
        FeatureCollection instance = new FeatureCollection();
        String[] expResult = new String[]{"growthHeight", "growthWeight",
            "growthOther"};
        String[] result = instance.extendFeature(feature);
        assertArrayEquals(expResult, result);
    }
    /**
     * Test of extendFeature method, of class FeatureCollection.
     */
    @Test(expected=IllegalArgumentException.class)
    public void testExtendFeatureWrongFeature() {
        System.out.println("extendFeature");
        String feature = "hoi";
        FeatureCollection instance = new FeatureCollection();
        String[] expResult = new String[]{"growthHeight", "growthWeight",
            "growthOther"};
        String[] result = instance.extendFeature(feature);
        assertArrayEquals(expResult, result);
    }

}
