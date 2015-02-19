/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nl.bioinf.mkslofstra.DiseaseFinder.HPOProcessor;

import java.io.IOException;

/**
 *
 * @author aroeters
 */
public class HPOTermProcessor {

    public static void main(String[] args) throws IOException {
        HPOReader hr = new HPOReader();

        HPOTermProcessor hp = new HPOTermProcessor();
        hp.hpoObjectCreator(hp.hpoTermSplitter(hr.readFile()));
    }
    /**
     * Splits the file in seperate hpo terms.
     * @param hpoFile a file containing all hpo terms
     * @return a list of strings with all the seperate hpo terms
     */
    public final String[] hpoTermSplitter(final String hpoFile) {
        String[] hpoTerms = hpoFile.split("\\[Term\\]");
        return hpoTerms;
    }
    /**
     * Creates the hpoTerm objects and adds them to the HPOTermCollector.
     * @param seperateHpoTerms String array of the seperate terms in the file
     */
    public final void hpoObjectCreator(final String[] seperateHpoTerms) {
        HPOTermCollector hc = new HPOTermCollector();
        for (String hpoTerm : seperateHpoTerms) {

        }
    }

}
