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
 * @author Arne
 */
public class HPOTermTest {
    public HPOTermTest() {
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
     * Test of hasChildren method, of class HPOTerm.
     */
    @Test
    public final void testHasChildren() {
        System.out.println("hasChildren");
        HPOTerm instance = new HPOTerm();
        boolean expResult = false;
        boolean result = instance.hasChildren();
        assertEquals(expResult, result);
    }
    /**
     * Test of hasChildren method, of class HPOTerm.
     */
    @Test
    public final void testHasChildrenTrue() {
        System.out.println("hasChildren");
        HPOTerm instance = new HPOTerm();
        HPOTerm child = new HPOTerm();
        instance.addChild(child);
        boolean expResult = true;
        boolean result = instance.hasChildren();
        assertEquals(expResult, result);
    }
    /**
     * Test of addChild method, of class HPOTerm.
     */
    @Test
    public final void testAddChild() {
        System.out.println("addChild");
        HPOTerm child = new HPOTerm();
        HPOTerm instance = new HPOTerm();
        instance.addChild(child);
        boolean expResult = true;
        assertEquals(instance.hasChildren(), expResult);
    }
    /**
     * Test of addChild method, of class HPOTerm.
     * With child null.
     */
    @Test(expected = NullPointerException.class)
    public final void testAddChildNull() {
        System.out.println("addChild");
        HPOTerm instance = new HPOTerm();
        instance.addChild(null);
    }
    /**
     * Test of getChild method, of class HPOTerm.
     */
    @Test
    public final void testGetChild() {
        System.out.println("getChild");
        HPOTerm child = new HPOTerm();
        String childId = "term1";
        child.setId(childId);
        HPOTerm instance = new HPOTerm();
        instance.addChild(child);
        String expResult = "term1";
        HPOTerm result = instance.getChild(childId);
        assertEquals(expResult, result.getId());
    }
    /**
     * Test of getChildren method, of class HPOTerm.
     */
    @Test
    public final void testGetChildren() {
        System.out.println("getChildren");
        HPOTerm instance = new HPOTerm();
        List<HPOTerm> expResult = new ArrayList();
        List<HPOTerm> result = instance.getChildren();
        assertEquals(expResult, result);
    }

    /**
     * Test of getId method, of class HPOTerm.
     */
    @Test
    public final void testGetId() {
        System.out.println("getId");
        HPOTerm instance = new HPOTerm();
        instance.setId("term");
        String expResult = "term";
        String result = instance.getId();
        assertEquals(expResult, result);
    }
    /**
     * Test of setId method, of class HPOTerm.
     */
    @Test
    public final void testSetId() {
        System.out.println("setId");
        String newId = "term";
        HPOTerm instance = new HPOTerm();
        instance.setId(newId);
        String expResult = "term";
        assertEquals(expResult, instance.getId());
    }
    /**
     * Test of setId method, of class HPOTerm.
     * with null set.
     */
    @Test(expected = NullPointerException.class)
    public final void testSetIdNull() {
        System.out.println("setId");
        String newId = null;
        HPOTerm instance = new HPOTerm();
        instance.setId(newId);
    }
    /**
     * Test of getName method, of class HPOTerm.
     */
    @Test
    public final void testGetName() {
        System.out.println("getName");
        HPOTerm instance = new HPOTerm();
        instance.setName("justAName");
        String expResult = "justAName";
        String result = instance.getName();
        assertEquals(expResult, result);
    }
    /**
     * Test of setName method, of class HPOTerm.
     */
    @Test
    public final void testSetName() {
        System.out.println("setName");
        String setName = "justAName";
        HPOTerm instance = new HPOTerm();
        instance.setName(setName);
        String expResult = "justAName";
        assertEquals(expResult, instance.getName());
    }
    /**
     * Test of setName method, of class HPOTerm.
     * with name null.
     */
    @Test(expected = NullPointerException.class)
    public final void testSetNameNull() {
        System.out.println("setName");
        String setName = null;
        HPOTerm instance = new HPOTerm();
        instance.setName(setName);
    }

    /**
     * Test of getDef method, of class HPOTerm.
     */
    @Test
    public final void testGetDef() {
        System.out.println("getDef");
        HPOTerm instance = new HPOTerm();
        instance.setDef("just a definition");
        String expResult = "just a definition";
        String result = instance.getDef();
        assertEquals(expResult, result);

    }
    /**
     * Test of setDef method, of class HPOTerm.
     */
    @Test
    public final void testSetDef() {
        System.out.println("setDef");
        String setDef = "definition";
        HPOTerm instance = new HPOTerm();
        instance.setDef(setDef);
        String expResult = "definition";
        assertEquals(expResult, instance.getDef());
    }
    /**
     * Test of setDef method, of class HPOTerm.
     * with definition null
     */
    @Test(expected = NullPointerException.class)
    public final void testSetDefNull() {
        System.out.println("setDef");
        String setDef = null;
        HPOTerm instance = new HPOTerm();
        instance.setDef(setDef);
    }
    /**
     * Test of getIsA method, of class HPOTerm.
     */
    @Test
    public final void testGetIsA() {
        System.out.println("getIsA");
        HPOTerm instance = new HPOTerm();
        String parent = "parent";
        instance.addIsA(parent);
        List<String> expResult = new ArrayList();
        expResult.add(parent);
        List<String> result = instance.getIsA();
        assertEquals(expResult, result);
    }
    /**
     * Test of addIsA method, of class HPOTerm.
     */
    @Test
    public final void testAddIsA() {
        System.out.println("addIsA");
        String addIsARelation = "parent";
        HPOTerm instance = new HPOTerm();
        instance.addIsA(addIsARelation);
        List<String> expResult = new ArrayList();
        expResult.add(addIsARelation);
        assertEquals(expResult, instance.getIsA());
    }
    /**
     * Test of addIsA method, of class HPOTerm.
     * Adding a null
     */
    @Test(expected = NullPointerException.class)
    public final void testAddIsANull() {
        System.out.println("addIsA");
        String addIsARelation = null;
        HPOTerm instance = new HPOTerm();
        instance.addIsA(addIsARelation);
    }
}
