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
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * This class gets retrieves from the omim api. It needs to have a omimURL and
 * an omimKey to access the website. Then it retrieves the content of the site
 * in jsonstructure. Then dependant on what is asked, the class gives the
 * information asked (this can be an array with omimnumbers or a jsonstructure
 * with clinical features of a disease).
 *
 * @author mkslofstra
 */
public class OmimDataRetriever {

    String omimURL;
    String omimKey;

    /**
     * The constructor of the class.
     */
    public OmimDataRetriever(String url, String key) {
        omimURL = url;
        omimKey = key;
    }

    /**
     * Gets the result from the website given an omim number.
     */
    public JSONObject getOmimResult(String omimNumber) {
        return null;
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
        return jsonSite;
    }
    private JSONObject getSuitableContent(JSONObject content, String search) throws JSONException{
        String found = content.get(search).toString();
        content = makeJSONObject(found);
        return content;
    }
    /**
     * This function gets the OmimNumbers of diseases given features of a
     * disease.
     */
    public ArrayList getOmimNumbers(String[] features) throws IOException, JSONException {
        String urlToSearch = this.buildFeatureURL(features, omimURL, omimKey);
        String siteContentString = this.getSiteContent(urlToSearch);
        JSONObject content = getSuitableContent(makeJSONObject(siteContentString), "omim");
        content=getSuitableContent(content, "searchResponse");
        content=getSuitableContent(content, "entryList");
        return null;
    }

    /**
     * getSiteContent This function gets the page of the given omim url and
     * saves it in a String.
     *
     * @author mkslofstra
     * @param omimSite the URL of the site which should be opened.
     * @return resultBuilder.toString(), the string of the content of the
     * webpage.
     * @throws IOException when the url cannot be made.
     */
    private String getSiteContent(final String omimSite)
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
     * buildFeatureURL creates a string which can be converted to a url for the
     * omim api from a list of strings.
     *
     * @param features are the features which should be searched.
     * @param omimSite the url of the site where the features and key should be
     * added to.
     * @param apiKey the key of the omim api.
     * @return siteUrl is a string which can be converted to a url.
     * @author mkslofstra
     */
    private String buildFeatureURL(final String[] features,
            final String omimSite, final String apiKey) {
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
        String siteUrl = String.format(omimSite, featuresToReturn, apiKey);
        return siteUrl;
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
