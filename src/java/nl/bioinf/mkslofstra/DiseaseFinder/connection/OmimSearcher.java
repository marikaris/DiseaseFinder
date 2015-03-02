/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.bioinf.mkslofstra.DiseaseFinder.connection;

import java.io.IOException;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Searches query on omim api and returns omimnumbers of possible diseases.
 *
 * @author mkslofstra
 */
public class OmimSearcher {

    /**
     * OmimSearcher is the constructor of OmimSearcher.
     *
     * @param features are the features which should be searched on.
     */
    public OmimSearcher(final String[] features) {
        String diseaseFeatures = this.parseFeatures(features);
    }

    /**
     * omimNumbers is an arraylist with all the found omim numbers given a few
     * features.
     */
    private ArrayList omimNumbers;

    public static void main(String[] args) {
        String[] features = new String[]{"dizziness", "blurry vision", "ptosis"};
        OmimSearcher os = new OmimSearcher(features);
    }

    /**
     * get OmimNumbers is the getter of the arraylist omimNumbers.
     *
     * @return omimNumbers the omimnumbers of the found diseases.
     */
    public final ArrayList getOmimNumbers() {
        return omimNumbers;
    }

    /**
     * parseFeatures creates a string which can be searhec in the omim api from
     * a list of strings.
     *
     * @param features are the features which should be searched.
     * @return featuresToReturn is a string which can be added to a url to
     * search the features in the api.
     * @author mkslofstra
     */
    private String parseFeatures(final String[] features) {
        StringBuilder buildFeatures = new StringBuilder();
        for (String feature : features) {
            //check if there is a whitespace in the feature
            if (feature.contains(" ")) {
                String featureToAppend = feature.replace(" ", "+");
                buildFeatures.append("\"").append(featureToAppend)
                        .append("\"+");
            } else {
                buildFeatures.append(feature).append("+");
            }
        }
        String allFeatures = buildFeatures.toString();
        //remove the last +
        String featuresToReturn = allFeatures.substring(0,
                (allFeatures.length() - 1));
        return featuresToReturn;
    }

    /**
     * getWebContent gets the content of the omimpage which is needed.
     *
     * @param diseaseFeatures the features of the disease in the good format.
     * @return the content of the webpage in a json object.
     * @throws JSONException if the json is invalid.
     * @throws IOException if the URL is invalid.
     * @author mkslofstra
     */
    private JSONObject getWebContent(String diseaseFeatures) throws
            IOException, JSONException {
        String site = "http://api.europe.omim.org/api/entry/search?search="
                + "%1$s&filter=&fields=&retrieve=&start=0&limit=10&sort="
                + "&operator=&format=json&apiKey=%2$s";
        OmimSite omimSite = new OmimSite(site, diseaseFeatures);
        return omimSite.getContent();
    }

}
