/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.bioinf.mkslofstra.DiseaseFinder.dataFinder;

import java.io.IOException;
import java.util.ArrayList;
import nl.bioinf.mkslofstra.DiseaseFinder.bodyFeatures.FeatureCollection;
import nl.bioinf.mkslofstra.DiseaseFinder.connection.OmimConnector;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * DiseaseFenotypeGetter gets the fenotype of a disease.
 *
 * @author mkslofstra
 */
public class DiseaseFenotypeGetter {

    /**
     * features: The selected content of the webpage from omim in json
     * structure.
     */
    private JSONObject features;
    /**
     * featuresToFind: the features selected from the webpage where the parent
     * is true.
     */
    private ArrayList<String> featuresToFind = new ArrayList();

    /**
     * The main of this class.
     *
     * @param args the arguments which are given when running the file.
     * @throws java.io.IOException thrown when the url from the connector is
     * invalid.
     * @throws org.json.JSONException when the structure of the website is not
     * valid json.
     * @author mkslofstra
     */
    public static void main(final String[] args) throws IOException,
            JSONException {
        DiseaseFenotypeGetter fenotype = new DiseaseFenotypeGetter();
        String data = fenotype.getOmimData();
        JSONObject features = fenotype.makeJSONObject(data);
        fenotype.checkFeature("growth");
        ArrayList<String> featuresToFind = fenotype.getFeatures();
        ArrayList<String> fenotypes = fenotype.collectFenotypes(featuresToFind);
    }

    /**
     * getOmimData gets all the data from the omim page of a given omim number
     * in a String.
     *
     * @throws IOException when the string of the website cannot be made.
     * @return omimData the webpage of omim in a string.
     * @author mkslofstra
     */
    private String getOmimData() throws IOException {
        OmimConnector omimConnection = new OmimConnector();
        String omimData = omimConnection.getData("606232");
        int length = omimData.length();
        /*The webpage is be shortend, so that a jsonobject can be made
         later, wherefrom information about the clinical features of a
         disease can be gotten easily.*/
        omimData = omimData.substring(75, length - 8);
        return omimData;
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

    /**
     * checkFeature: checks if the given feature is true in the json structure.
     *
     * @param feature the feature which should be checked.
     * @throws JSONException when the website has not a valid json structure.
     * @return check tells if the given feature in this disease is true or not.
     * @author mkslofstra
     */
    private Boolean checkFeature(final String feature) throws JSONException {
        String featureExists = feature + "Exists";
        //getBoolean gets the value of the given String in featureExists which
        //is in the json structure.
        Boolean check = features.getBoolean(featureExists);
        return check;
    }

    /**
     * getFenotypeOfFeature gets the fenotype from a given feature of the
     * website in the json structure.
     *
     * @param feature the feature wherefrom the fenotype is needed.
     * @throws JSONException when the website has not a vali json structure.
     * @return fenotpe the fenotype of the feature.
     * @author mkslofstra
     */
    private String getFenotypeOfFeature(final String feature)
            throws JSONException {
        //getString gets the string which belongs to the given
        //string in the json structure.
        String fenotype = features.getString(feature);
        return fenotype;
    }

    /**
     * collectFenotypes collects all the fenotypes of a disease.
     *
     * @param allFeatures an arraylist which contains all the features which can
     * be true.
     * @throws JSONException when the website has not a valid json structure.
     * @return fenotypes all the fenotypes of the disease.
     * @author mkslofstra
     */
    public final ArrayList<String> collectFenotypes(
            final ArrayList<String> allFeatures) throws JSONException {
        ArrayList<String> fenotypes = new ArrayList();
        for (String feature : allFeatures) {
            //check for each feature if the value of it is true or false.
            System.out.println(feature);
            //get the value of the feature from the json structure
            //if the feature does exist.
            String fenotype = getFenotypeOfFeature(feature);
            System.out.println(fenotype);
            //add the fenotype to the global variable fenotypes
            //which contains the full fenotype of a disease.
            fenotypes.add(fenotype);
        }
        return fenotypes;
    }

    /**
     * getFeatures gets all the possible features and uses checkFeature to check
     * if they are true or false, then calls the next function to get the child
     * features of these parent and adds this to featuresToFind.
     *
     * @throws JSONException when the website is not a valid json structure.
     * @return featuresToFind is the global ArrayList of all features which are
     * possible true.
     * @author mkslofstra
     */
    private ArrayList<String> getFeatures() throws JSONException {
        String[] allFeatures;
        FeatureCollection possibleFeatures = new FeatureCollection();
        //iterate over all possible features.
        for (String pf : possibleFeatures.getGlobalFeatures()) {
            Boolean check = checkFeature(pf);
            if (check) {
                //if the check is true, get the extension of the main feature
                //to get the specific features of the main feature.
                allFeatures = possibleFeatures.extendFeature(pf);
                //add all specific features to the features list,
                //if the feature exists in the disease.
                for (String feature : allFeatures) {
                    if (features.getBoolean(feature + "Exists")) {
                        featuresToFind.add(feature);
                    }
                }
            }
        }
        return featuresToFind;

    }
}
