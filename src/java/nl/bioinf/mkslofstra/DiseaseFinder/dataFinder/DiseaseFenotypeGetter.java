/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.bioinf.mkslofstra.DiseaseFinder.dataFinder;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import nl.bioinf.mkslofstra.DiseaseFinder.connection.OmimConnector;

/**
 *
 * @author mkslofstra
 */
public class DiseaseFenotypeGetter {
    public static void main(String[] args) throws IOException {
        DiseaseFenotypeGetter fenotype = new DiseaseFenotypeGetter();
        String data = fenotype.getOmimData();
        String features = fenotype.findClinicalFeatures(data);
        System.out.println(features);
        
    }
    private String getOmimData() throws IOException {
        OmimConnector omimConnection = new OmimConnector();
        String omimData = omimConnection.getData("606232");        
        return omimData;
    }
    public String findClinicalFeatures(String omimData) {
        Pattern pattern = Pattern.compile("(?s)\"Clinical Features\", \"textSectionContent\": (.+?)\"textSection\"");
        Matcher matchFeatures = pattern.matcher(omimData);
        matchFeatures.find();
        return matchFeatures.group(1);
    }
}
