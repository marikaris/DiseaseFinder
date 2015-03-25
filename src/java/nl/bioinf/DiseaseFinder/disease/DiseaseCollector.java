/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.bioinf.DiseaseFinder.disease;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import nl.bioinf.DiseaseFinder.connection.OmimDataRetriever;
import nl.bioinf.DiseaseFinder.dataFinder.DiseaseFenotypeGetter;
import org.json.JSONException;

/**
 * This class collects all the possible diseases which are found.
 *
 * @author mkslofstra
 */
public class DiseaseCollector {

    /**
     * diseaseCollection is the collection of all found diseases given a
     * fenotype. This hashmap has as id the omim number and as value the Disease
     * object which belongs to this omim number.
     */
    private HashMap<String, Disease> diseaseCollection = new HashMap();

    /**
     * getDiseaseCollection is the getter of diseaseCollection.
     *
     * @return diseaseCollection the collection of all found diseases.
     */
    public final HashMap<String, Disease> getDiseaseCollection() {
        return diseaseCollection;
    }

    public static void main(String[] args) throws JSONException, IOException {
        String[] features = new String[]{"dizziness", "blurry vision",
            "ptosis"};
        DiseaseCollector diseaseCollection = new DiseaseCollector(features);
    }

    /**
     * DiseaseCollector is the constructor of the class.
     *
     * @param features the features to look for
     * @throws JSONException when the page is not valid JSON
     * @throws IOException if the URL is invalid.
     */
    public DiseaseCollector(final String[] features) throws JSONException,
            IOException {
        ArrayList omimNumbers = this.getOmimNumbers(features);
        for (Object id : omimNumbers) {
            Disease disease = this.getDiseaseContent(id.toString());
            addToDiseaseCollection(disease, id.toString());
        }
    }

    /**
     * getOmimNumbers gets the id's of the possible diseases.
     *
     * @param features is the list of features to look for.
     * @throws JSONException when page is invalid JSON.
     * @throws IOException when URL is invalid.
     * @return diseases, an arraylist of diseases.
     */
    private ArrayList<String> getOmimNumbers(final String[] features)
            throws JSONException, IOException {
//        OmimSearcher search = new OmimSearcher(features);
        //test url
        String url = "http://api.europe.omim.org/api/entry/search?search="
                + "%1$s&filter=&fields=&retrieve=&start=0&limit=10&sort="
                + "&operator=&format=json&apiKey=%2$s";
        String apiKey = "3F48B5AE34656CC9211E0A476E28AF0C370E3F94";
        OmimDataRetriever omimResultGetter = new OmimDataRetriever(url, apiKey);
        ArrayList<String> diseases = omimResultGetter.getOmimNumbers(features);
        return diseases;
    }

    private Disease getDiseaseContent(String disease) throws IOException, JSONException {
        DiseaseFenotypeGetter diseaseFenotype = new DiseaseFenotypeGetter(disease);
        return diseaseFenotype.getDisease();
    }

    /**
     * the setter of diseaseCollection.
     *
     * @param disease the disease of the id.
     * @param mimNumber the id of the disease.
     */
    public final void addToDiseaseCollection(
            final Disease disease, final String mimNumber) {
        System.out.println(mimNumber);
        diseaseCollection.put(mimNumber, disease);
        System.out.println(disease);
    }
}
