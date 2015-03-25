/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.bioinf.DiseaseFinder.HPOProcessor;

import java.io.IOException;
import java.util.Properties;

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


        Properties configFile = new Properties();
        try {
            // The HPOTermProcessor should be changed in the class this is used
            configFile.load(HPOTermProcessor.class.getClassLoader().getResourceAsStream("config.properties"));
            String key = configFile.getProperty("omimKey");
            System.out.println(key);
        } catch (IOException e) {
            System.out.println("nope nope nope!!!!!!!!!!");
        }
//        }

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
     * @return collection of HPOTerms
     */
    public final HPOTermCollector hpoObjectCreator(final String[] seperateHpoTerms) {
        HPOTermCollector hc = new HPOTermCollector();

        for (String hpoTerm : seperateHpoTerms) {
            String[] lines = hpoTerm.split("\n");
            for (String line : lines) {
                if (line.equals("")) {
                    System.out.println(line + "hoi");
                }
//                HPOTerm ht = new HPOTerm(line.substring(line.lastIndexOf("HP")));

            }

        }
        return null;
    }
}
