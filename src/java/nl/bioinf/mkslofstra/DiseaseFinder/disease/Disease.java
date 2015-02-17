/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.bioinf.mkslofstra.DiseaseFinder.disease;

import java.lang.reflect.Array;

/**
 *
 * @author mkslofstra
 */
public class Disease {

    /**
     * mimNumber is the OMIM number of the disease.
     */
    int mimNumber;
    /**
     * title is the name of the disease.
     */
    String title;
    /**
     * features are the characteristics of the disease. 
     */
    Array features;
}
