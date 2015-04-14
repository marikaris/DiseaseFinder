/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.bioinf.DiseaseFinder.HPOProcessor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

//        Properties configFile = new Properties();
//        try {
//            // The HPOTermProcessor should be changed in the class this is used
//            configFile.load(HPOTermProcessor.class.getClassLoader().getResourceAsStream("config.properties"));
//            String key = configFile.getProperty("omimKey");
//            System.out.println(key);
//        } catch (IOException e) {
//            System.out.println("nope nope nope!!!!!!!!!!");
//        }

/**
 *
 * @author aroeters
 */
public class HPOFileReader {
    /**
     * Contains the name of the file including the path to the file.
     */
    private final String file;
    /**
     * The constructor of the class.
     * @param inFile the file that contains the HPO terms
     * @throws IOException when file not found
     */
    public HPOFileReader(final String inFile) throws IOException {
        file = inFile;
        if (inFile == null) {
            throw new NullPointerException();
        } else {
            this.readFile();
        }
    }
    /**
     * Reads the file line by line and processes it.
     * @return HPOTermCollector
     * @throws IOException when file not found
     */
    final HPOTermCollector readFile() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(this.file));
        HPOTermCollector hc = new HPOTermCollector();
        String line;
        HPOTerm hp = new HPOTerm();
        while ((line = br.readLine()) != null) {
            if (line.startsWith("id:")) {
                hp.setId(line.substring(4));
            } else if (line.startsWith("name:")) {
                hp.setName(line.substring(6));
            } else if (line.startsWith("def:")) {
                hp.setDef(line.substring(5));
            } else if (line.startsWith("comment:")) {
                hp.setComment(line.substring(9));
            } else if (line.startsWith("is_a:")) {
                hp.addIsA(line.substring(6, 16));
            } else if (line.startsWith("synonym:")) {
                hp.addSynonym(line.substring(9));
            } else if (line.contains("Term")) {
                if (hp.getId() != null) {
                    hc.addToHPOList(hp);
                    hp = new HPOTerm();
                }
            }
        }
        return hc; }
}


