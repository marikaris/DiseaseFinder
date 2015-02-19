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
import org.json.JSONException;
import org.json.JSONObject;

/**
 * OmimConnector connects with the omimdatabase via the omim api site.
 *
 * @author mkslofstra
 */
public class OmimConnector {

    /**
     * features: The selected content of the webpage from omim in json
     * structure.
     */
    private JSONObject features;

    /**
     * The getter for the JSONObject features.
     *
     * @return features the json object with the content of the website.
     */
    public final JSONObject getFeatures() {
        return features;
    }

    /**
     * getOmimData gets all the data from the omim page of a given omim number
     * in a String.
     *
     * @throws IOException when the string of the website cannot be made.
     * @return omimData the webpage of omim in a string.
     * @param omimNr the number of the disease.
     * @author mkslofstra
     */
    public final void OmimConnector(final String omimNr) throws
            IOException, JSONException {
        System.out.println("hoi");
    }

    /**
     * OmimConnector gets all the data from the omim page of a given omim number
     * in a String.
     *
     * @throws IOException when the string of the website cannot be made.
     * @throws JSONException when the given string is not valid json code.
     * @param omimNr the number of the disease.
     * @author mkslofstra
     */
    public OmimConnector(final String omimNr) throws
            IOException, JSONException {
        String omimData = this.getData(omimNr);
        int length = omimData.length();
        /*The webpage is be shortend, so that a jsonobject can be made
         later, wherefrom information about the clinical features of a
         disease can be gotten easily.*/
        omimData = omimData.substring(75, length - 8);
        makeJSONObject(omimData);
    }

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

    /**
     * makeJSONObject makes a JSONObject from which can easily information be
     * obtained.
     *
     * @author mkslofstra
     * @param jsonString a string with json content from the omim website.
     * @return jsonSite the page in a json object.
     * @throws JSONException when the given structure in the string is not a
     * viable json structure.
     */
    private JSONObject makeJSONObject(final String jsonString)
            throws JSONException {
        JSONObject jsonSite = new JSONObject(jsonString);
        features = jsonSite;
        return jsonSite;
    }
}
