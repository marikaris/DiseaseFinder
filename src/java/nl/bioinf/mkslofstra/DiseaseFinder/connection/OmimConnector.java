/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.bioinf.mkslofstra.DiseaseFinder.connection;

import java.io.IOException;
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
        this.getData(omimNr);
    }

    /**
     * getData This function gets all the data from the omim website, given an
     * id of an omimpage.
     *
     * @author mkslofstra
     * @param omimId the id of the omim page.
     * @throws java.io.IOException thrown when string of the webpage cannot be
     * made.
     * @throws org.json.JSONException when json is not valid.
     */
    public final void getData(final String omimId) throws IOException,
            JSONException {
        String omimUrl = "http://api.europe.omim.org/api/clinicalSynopsis?"
                + "mimNumber=%1$s&include=all&format=json&apiKey=%2$s";
        OmimSite websiteOmim = new OmimSite(omimUrl, omimId);
        features = websiteOmim.getContent();
    }
}
