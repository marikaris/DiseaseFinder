/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.bioinf.DiseaseFinder.dataFinder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.logging.Level;
import nl.bioinf.DiseaseFinder.bodyFeatures.FeatureCollection;
import nl.bioinf.DiseaseFinder.connection.OmimDataRetriever;
import nl.bioinf.DiseaseFinder.disease.Disease;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.logging.Logger;

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
     * fenotypes are the fenotypes of the disease.
     */
    private HashMap<String, String> fenotypes = new HashMap();
    /**
     * Disease is the disease object of the found disease.
     */
    private Disease disease;

    /**
     * The getter of the created diseaseobject.
     *
     * @return disease the disease object.
     */
    public Disease getDisease() {
        return disease;
    }

    /**
     * The constructor of this class.
     *
     * @param omimNumber the id of the disease to get information from.
     * @throws java.io.IOException thrown when the url from the connector is
     * invalid.
     * @throws org.json.JSONException when the structure of the website is not
     * valid json.
     * @author mkslofstra
     */
    public DiseaseFenotypeGetter(final String omimNumber)
            throws IOException, JSONException {
        try {
            this.getOmimData(omimNumber);
            this.getFeatures();
            this.collectFenotypes(featuresToFind);
            String title = this.getTitleOfDisease();
            this.saveDisease(omimNumber, title);
        } catch (org.json.JSONException ex) {
            Logger logger = Logger.getLogger(DiseaseFenotypeGetter.class
                    .getName());
            logger.log(Level.FINEST, omimNumber + " not usefulll, clinical"
                    + " synopsis misses, which causes invalid JSON. This"
                    + " disease is deleted from the results.", ex);
        }

    }

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
//        DiseaseFenotypeGetter fenotype = new DiseaseFenotypeGetter("606232");
        DiseaseFenotypeGetter fenotype = new DiseaseFenotypeGetter("275000");
    }

    /**
     * getOmimData gets all the data from the omim page of a given omim number
     * in a String.
     *
     * @throws IOException when the string of the website cannot be made.
     * @throws JSONException if the stirng from the website is not valid json.
     * @return omimData the webpage of omim in a string.
     * @param omimNr the number of the disease.
     * @author mkslofstra
     */
    private JSONObject getOmimData(final String omimNr)
            throws IOException, JSONException {
        //this url is for testing
        String url = "http://api.europe.omim.org/api/clinicalSynopsis?mimNumber=%1$s&include=all&format=json&apiKey=%2$s";
        //apiKey for testing, will be in config file
        String apiKey = "3F48B5AE34656CC9211E0A476E28AF0C370E3F94";
        OmimDataRetriever omimConnector = new OmimDataRetriever(url, apiKey);
        features = omimConnector.getOmimResult(omimNr);
        return features;
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
    private final void collectFenotypes(
            final ArrayList<String> allFeatures) throws JSONException {
        for (String feature : allFeatures) {
            //check for each feature if the value of it is true or false.
            //get the value of the feature from the json structure
            //if the feature does exist.
            String fenotype = getFenotypeOfFeature(feature);
            //add the fenotype to the global variable fenotypes
            //which contains the full fenotype of a disease.
            fenotypes.put(feature, fenotype);
        }
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
    private void getFeatures() throws JSONException {
        String[] allFeatures;
        FeatureCollection possibleFeatures = new FeatureCollection();
        //iterate over all possible features.
        for (String pf : possibleFeatures.getGlobalFeatures()) {
            Boolean check = checkFeature(pf);
            if (check) {
                if (pf.equals("oldFormat")) {
                    Object old = features.get(pf);
                    JSONObject jsonSite = new JSONObject(old.toString());
                    Iterator<String> keys = jsonSite.keys();
                    while (keys.hasNext()) {
                        String key = keys.next();
                        String val = jsonSite.getString(key);
                        fenotypes.put(key, val);

                    }
                } else {
                    //if the check is true and not oldformat, get the
                    // extension of the main feature to get the specific
                    //features of the main feature.
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
        }

    }

    /**
     * getTitleOfDisease gets the title of a disease from the json structure.
     *
     * @return title is the title of the disease.
     * @author mkslofstra
     */
    private String getTitleOfDisease() throws JSONException {
        String title = features.getString("preferredTitle");
        return title;
    }

    /**
     * This funcion saves the information about the disesase in a disease
     * object.
     *
     * @param mimNumber is the id of the disease
     * @param title is the name of the disease
     * @param fenotypes are the characteristics of the disease
     * @author mkslofstra
     */
    private void saveDisease(final String mimNumber,
            final String title) {
        disease = new Disease(mimNumber, title, fenotypes);
    }
}
