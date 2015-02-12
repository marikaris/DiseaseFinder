/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.bioinf.mkslofstra.DiseaseFinder.dataFinder;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import nl.bioinf.mkslofstra.DiseaseFinder.connection.OmimConnector;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;

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
//        String features = fenotype.findClinicalFeatures(data);

    }

    private String getOmimData() throws IOException {
        OmimConnector omimConnection = new OmimConnector();
        String omimData = omimConnection.getData("606232");

        int length = omimData.length();
        System.out.println(omimData.substring(length - 8));
        omimData = omimData.substring(75, length - 8);

        return omimData;
    }

    private JSONObject makeJSONObject(String jsonString) throws JSONException {
        JSONObject jsonSite = new JSONObject(jsonString);
//        Integer number = jsonSite.getInt("mimNumber");
//        String feature = jsonSite.getString("growthHeight");
        return jsonSite;
    }

    public String findClinicalFeatures(String omimData) {
        Pattern pattern = Pattern.compile("(?s)\"Clinical Features\", \"textSectionContent\": \".+} }?");
        Matcher matchFeatures = pattern.matcher(omimData);
        return matchFeatures.group(1);
    }
}
