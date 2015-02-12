/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.bioinf.mkslofstra.DiseaseFinder.connection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * OmimConnector connects with the omimdatabase via the omim api site.
 *
 * @author mkslofstra
 */
public class OmimConnector {

    /**
     * getData This function gets all the data from the omim website, given an
     * id of an omimpage.
     *
     * @author mkslofstra
     * @param omimId the id of the omim page.
     * @return omimResult, this is a string with the whole content of the omim
     * page in json format.
     * @throws java.io.IOException thrown when string of the webpage cannot be
     * made.
     */
    public final String getData(final String omimId) throws IOException {
        String omimKey = "3F48B5AE34656CC9211E0A476E28AF0C370E3F94";
        String omimSite = getOmimUrl(omimId, omimKey);
        String omimResult = getOmimResult(omimSite);
        return omimResult;
    }

    /**
     * getOmimUrl This function makes the url of the website complete with the
     * asked omim number and the api-key.
     *
     * @author mkslofstra
     * @param number the omim number.
     * @param key the api-key.
     * @return omimSite, the complete URL which should be used to get
     * information.
     */
    private String getOmimUrl(final String number, final String key) {
        String omimSite = String.format(
                "http://api.europe.omim.org/api/clinicalSynopsis?mimNumber=%1$s"
                + "&include=all&format=json&apiKey=%2$s", number, key);
        return omimSite;
    }

    /**
     * getOmimResult This function gets the page of the given omim number and
     * saves it in a String.
     *
     * @author mkslofstra
     * @param omimSite the URL of the site which should be opened.
     * @return resultBuilder.toString(), the string of the content of the
     * webpage.
     * @throws IOException when the string cannot be made.
     */
    private String getOmimResult(final String omimSite)
            throws IOException {
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
