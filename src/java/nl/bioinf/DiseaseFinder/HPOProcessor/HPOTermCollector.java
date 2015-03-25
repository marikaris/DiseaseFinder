/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nl.bioinf.DiseaseFinder.HPOProcessor;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aroeters
 */
public class HPOTermCollector {
        /**
         * Contains the HPOTerm objects.
         */
    private final List<Object> hpoList = new ArrayList<Object>();
    /**
     * Adds a hpo term to the hpoList.
     * @param hpoTerm Object of a HPOTerm
     */
    public final void addToHPOList(final Object hpoTerm) {
        hpoList.add(hpoTerm);
    }
    /**
     * The getter of the hpoList.
     * @return list containing the HPOTerm objects
     */
    public final List getHPOList() {
        return hpoList;
    }
}
