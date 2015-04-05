/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.bioinf.DiseaseFinder.dataFinder;

import java.io.IOException;
import java.util.ArrayList;
import nl.bioinf.DiseaseFinder.disease.Disease;
import org.json.JSONException;
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
public class DiseaseFenotypeGetterTest {
    
    public DiseaseFenotypeGetterTest() {
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
     * Test of getDisease method, of class DiseaseFenotypeGetter.
     */
    @Test
    public void testGetDisease() throws IOException, JSONException {
        System.out.println("getDisease");
        DiseaseFenotypeGetter instance = new DiseaseFenotypeGetter("520000");
        String expResult = "DIABETES AND DEAFNESS, MATERNALLY INHERITED; MIDD";
        //Test if the title can be given, if not, the disease object is not made
        //correctly.
        String result = instance.getDisease().getTitle();
        assertEquals(expResult, result);
    }
    
}
