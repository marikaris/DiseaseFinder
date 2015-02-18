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

    JSONObject features;
    ArrayList<String> featuresToFind = new ArrayList();

    public static void main(String[] args) throws IOException, JSONException {
        DiseaseFenotypeGetter fenotype = new DiseaseFenotypeGetter();
        String data = fenotype.getOmimData();
        JSONObject features = fenotype.makeJSONObject(data);
        fenotype.checkFeature("growth");

//        allFeatures.add(fenotype.getFeatures());
        ArrayList<String> featuresToFind = fenotype.getFeatures();
        ArrayList<String> fenotypes = fenotype.collectFenotypes(featuresToFind);
    }

    /**
     * getOmimData gets all the data from the omim page of a given omim number
     * in a String.
     *
     * @throws IOException when the string of the website cannot be made.
     * @return omimData the webpage of omim in a string.
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

    private Boolean checkFeature(String feature) throws JSONException {
        feature = feature + "Exists";
        Boolean check = features.getBoolean(feature);
        return check;
    }

    private String getFenotypeOfFeature(String feature) throws JSONException {
        String fenotype = features.getString(feature);
        return fenotype;
    }

    public ArrayList<String> collectFenotypes(ArrayList<String> allFeatures) throws JSONException {
        ArrayList<String> fenotypes = new ArrayList();
        for (String feature : allFeatures) {
            if (features.getBoolean(feature + "Exists")) {
                System.out.println(feature);
                String fenotype = getFenotypeOfFeature(feature);
                System.out.println(fenotype);
                fenotypes.add(fenotype);
            }
        }
        return fenotypes;
    }

    private ArrayList<String> getFeatures() throws JSONException {
        String[] allFeatures = new String[]{};
        FeatureCollection possibleFeatures = new FeatureCollection();
        for (String pf : possibleFeatures.globalFeatures) {
            Boolean check = checkFeature(pf);
            if (check) {
                allFeatures = possibleFeatures.extendFeature(pf);
                for (String feature : allFeatures) {
                    featuresToFind.add(feature);
                }
            }

        }
        return featuresToFind;

    }
}
