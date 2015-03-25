/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.bioinf.DiseaseFinder.connection;

/**
 * This class stores the omimKey so that it can be assessed from each other
 * class in the programm.
 *
 * @author mkslofstra
 */
public class OmimKey {

    /**
     * The key to open the omim api.
     */
    private final String omimKey = "3F48B5AE34656CC9211E0A476E28AF0C370E3F94";

    /**
     * The getter of the omimKey.
     *
     * @return omimKey the key to open the omim api.
     */
    public final String getOmimKey() {
        return omimKey;
    }

}
