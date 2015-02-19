/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.bioinf.mkslofstra.DiseaseFinder.HPOProcessor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author aroeters
 */
public class HPOReader {

    /**
     * Reads the file and returns it as a String.
     *
     * @return the contents of the file
     * @throws IOException if file not found
     */
    final String readFile() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("/homes/aroeters/"
                + "Desktop/Thema11/hp.obo"));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append("\n");
                line = br.readLine();
            }
            return sb.toString();
        } finally {
            br.close();
        }
    }
}
