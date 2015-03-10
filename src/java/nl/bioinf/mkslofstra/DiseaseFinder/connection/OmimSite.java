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
 *
 * @author mkslofstra
 */
public class OmimSite {

    /**
     * The constructor of the class.
     *
     * @param site is the url of the site
     * @param data is the data which should be in the url
     * @throws IOException when the URL is not valid.
     * @throws org.json.JSONException when the content is not valid json.
     */
    public OmimSite(final String site, final String data) throws IOException,
            JSONException {
        OmimKey key = new OmimKey();
        String omimKey = key.getOmimKey();
        String omimURL = this.getOmimUrl(site, data, omimKey);
        String webContent = this.getOmimResult(omimURL);
        //check if the content of a disease is asked or the numbers
        //of possible diseases.
        if (webContent.contains("clinicalSynopsisList")) {
            /*The webpage is be shortend, so that a jsonobject can be made
             later, wherefrom information about the clinical features of a
             disease can be gotten easily.*/
            int length = webContent.length();
            
            webContent = webContent.substring(75, length - 8);
            System.out.println(webContent);
        }
        this.makeJSONObject(webContent);
    }

    /**
     * The getter of content.
     *
     * @return content of the omimpage.
     */
    public final JSONObject getContent() {
        return content;
    }

    /**
     * features: The selected content of the webpage from omim in json
     * structure.
     */
    private JSONObject content;

    /**
     * getOmimUrl This function makes the url of the website complete with the
     * asked omim number and the api-key.
     *
     * @author mkslofstra
     * @param data is the information which should be provided in the url.
     * @param key the api-key.
     * @param site is the url of the omimSite.
     * @return omimSite, the complete URL which should be used to get
     * information.
     */
    private String getOmimUrl(final String site, final String data,
            final String key) {
        String omimSite = String.format(site, data, key);
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
        content = jsonSite;
        return jsonSite;
    }
}
