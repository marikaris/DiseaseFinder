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
public class HPOFileReaderTest {
    public HPOFileReaderTest() {
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
     * Test of readFile method, of class HPOFileReader.
     * @throws NullPointerException when infile is null
     */
    @Test
    public final void testReadFile() throws Exception {
        System.out.println("readFile");
        HPOFileReader instance = new HPOFileReader("file.txt");
        instance.readFile();
    }
}
