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

    /**
     *
     * @param args
     * @throws IOException
     */
    public static void main(final String[] args) throws IOException {
        HPOReader hr = new HPOReader();

        HPOTermProcessor hp = new HPOTermProcessor();
        hp.hpoObjectCreator(hp.hpoTermSplitter(hr.readFile()));
    }

    /**
     * Splits the file in seperate hpo terms.
     *
     * @param hpoFile a file containing all hpo terms
     * @return a list of strings with all the seperate hpo terms
     */
    public final String[] hpoTermSplitter(final String hpoFile) {
        String[] hpoTerms = hpoFile.split("\\[Term\\]");
        return hpoTerms;
    }

    /**
     * Creates the hpoTerm objects and adds them to the HPOTermCollector.
     *
     * @param seperateHpoTerms String array of the seperate terms in the file
     */
    public final void hpoObjectCreator(final String[] seperateHpoTerms) {
        HPOTermCollector hc = new HPOTermCollector();

        for (String hpoTerm : seperateHpoTerms) {
            HPOTerm ht = new HPOTerm();
            String[] lines = hpoTerm.split("\n");
            for (String line : lines) {
                if (line.startsWith("id")) {
                    ht.setId(line.substring(line.lastIndexOf("HP")));
                } else if (line.startsWith("name")) {
                    ht.setName(line.split(": ")[1]);
                } else if (line.startsWith("def")) {
                    ht.setDef(line.split(": ")[1]);
                } else if (line.startsWith("comment")) {
                    ht.setComment(line.split(": ")[1]);
                } else if (line.startsWith("property_value")) {
                    ht.setPropertyValue(line.split(": ")[1]);
                } else if (line.startsWith("is_a")) {
                    ht.addIsA(line.split(": ")[1]);
                } else if (line.startsWith("synonym")) {
                    ht.addSynonym(line.split(": ")[1]);
                } else if (line.startsWith("alt_id")) {
                    ht.addAltId(line.split(": ")[1]);
                } else if (line.startsWith("xref")) {
                    ht.addXref(line.split(": ")[1]);
                }
            }
            hc.addToHPOList(ht);
        }

    }
}
