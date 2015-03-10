/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.bioinf.mkslofstra.DiseaseFinder.connection;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Searches query on omim api and returns omimnumbers of possible diseases.
 *
 * @author mkslofstra
 */
public class OmimSearcher {

    /**
     * diseases is the arraylist with the omimnumbers of the found diseases.
     */
    private ArrayList<String> diseases;

    /**
     * The getter of the arraylist diseases.
     *
     * @return diseases the arraylist with omimnumbers of possible diseases.
     */
    public ArrayList<String> getDiseases() {
        return diseases;
    }

    /**
     * OmimSearcher is the constructor of OmimSearcher.
     *
     * @param features are the features which should be searched on.
     * @throws java.io.IOException when url is invalid.
     * @throws org.json.JSONException when json structure is invalid.
     */
    public OmimSearcher(final String[] features) throws IOException,
            JSONException {
        String diseaseFeatures = this.parseFeatures(features);
        String entries = this.getWebContent(diseaseFeatures);
        diseases = this.getDiseases(entries);
    }

    /**
     * omimNumbers is an arraylist with all the found omim numbers given a few
     * features.
     */
    private ArrayList omimNumbers;

    public static void main(String[] args) throws IOException, JSONException {
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
     * parseFeatures creates a string which can be searched in the omim api url
     * from a list of strings.
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
    private String getWebContent(final String diseaseFeatures) throws
            IOException, JSONException {
        String site = "http://api.europe.omim.org/api/entry/search?search="
                + "%1$s&filter=&fields=&retrieve=&start=0&limit=10&sort="
                + "&operator=&format=json&apiKey=%2$s";
        OmimSite omimSite = new OmimSite(site, diseaseFeatures);
        Object content = omimSite.getContent().get("omim");
        JSONObject omimContent = new JSONObject(content.toString());
        Object search = omimContent.get("searchResponse");
        JSONObject entryList = new JSONObject(search.toString());
        String foundEntries = entryList.get("entryList").toString();
        return foundEntries;
    }

    /**
     * getDiseases searches with regex in the entrylist of omim to get the
     * omimnumbers.
     *
     * @param entries the found diseases in the format of the jsonstructure on
     * the omim website.
     * @return diseases is an arraylist of strings which are the omimnumbers.
     */
    private ArrayList<String> getDiseases(final String entries) {
        ArrayList<String> diseases = new ArrayList();
        Pattern numbers = Pattern.compile("\\d{6}");
        Matcher match = numbers.matcher(entries);
        while (match.find()) {
            diseases.add(match.group());
        }
        return diseases;
    }

}
