/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.bioinf.mkslofstra.DiseaseFinder.connection;

import java.io.*;
import java.net.*;
import java.util.HashMap;

/**
 *
 * @author mkslofstra
 */
public class OmimConnector {

    public String getData(String omimId) throws IOException {
        String omimKey = "3F48B5AE34656CC9211E0A476E28AF0C370E3F94";
        String omimSite = getOmimUrl(omimId, omimKey);
        String omimResult = getOmimResult(omimSite);
        return omimResult;
    }

    private String getOmimUrl(String number, String key) {
//        String omimSite = String.format("http://api.europe.omim.org/api/entry?mimNumber=%1$s&include=all&format=json&apiKey=%2$s", number, key);
        String omimSite = String.format("http://api.europe.omim.org/api/clinicalSynopsis?mimNumber=%1$S&include=all&format=html&apiKey=%2$s", number, key);
        return omimSite;
    }

    private HashMap setOmimResult(String omimSite) {
        HashMap <String, String> omimMatch = new ObjectMapper().readValue(omimSite, HashMap.class);
        return new HashMap();
    }

    private String getOmimResult(String omimSite) throws MalformedURLException, IOException {
        URL omim = new URL(omimSite);
        BufferedReader omimContent = new BufferedReader(
                new InputStreamReader(omim.openStream()));
        String inputLine;
        StringBuilder resultBuilder = new StringBuilder();
        while ((inputLine = omimContent.readLine()) != null) {
            resultBuilder.append(inputLine);
        }
        omimContent.close();
        return resultBuilder.toString();
    }
}
