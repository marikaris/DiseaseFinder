/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nl.bioinf.mkslofstra.DiseaseFinder.bodyFeatures;

/**
 *
 * @author aroeters
 */
public class GrowthWeight extends Growth {
    /**
    * Contains the name of the feature.
    */
    private final String name = "growthWeight";
    /**
     * Contains the boolean for the feature if there is something wrong with it.
     */
    private Boolean exist;
    /**
     * Contains the information about the feature if the feature is present.
     */
    private String text;
}
