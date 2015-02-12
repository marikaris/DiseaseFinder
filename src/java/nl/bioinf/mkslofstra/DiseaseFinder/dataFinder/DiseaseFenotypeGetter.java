/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.bioinf.mkslofstra.DiseaseFinder.dataFinder;

import java.io.IOException;
import nl.bioinf.mkslofstra.DiseaseFinder.connection.OmimConnector;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * DiseaseFenotypeGetter gets the fenotype of a disease.
 *
 * @author mkslofstra
 */
public class DiseaseFenotypeGetter {

    public static void main(String[] args) throws IOException, JSONException {
        DiseaseFenotypeGetter fenotype = new DiseaseFenotypeGetter();
        String data = fenotype.getOmimData();
        System.out.println(data);
        JSONObject features = fenotype.makeJSONObject(data);

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
//        Integer number = jsonSite.getInt("mimNumber");
//        String feature = jsonSite.getString("growthHeight");
        return jsonSite;
    }
}
