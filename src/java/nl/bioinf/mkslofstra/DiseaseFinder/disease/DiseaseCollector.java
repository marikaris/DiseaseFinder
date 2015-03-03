/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.bioinf.mkslofstra.DiseaseFinder.disease;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import nl.bioinf.mkslofstra.DiseaseFinder.connection.OmimSearcher;
import nl.bioinf.mkslofstra.DiseaseFinder.dataFinder.DiseaseFenotypeGetter;
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
    private HashMap<String, Disease> diseaseCollection;

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
//            System.out.println("____________________"+disease+"***************"+id.toString());
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
        OmimSearcher search = new OmimSearcher(features);
        ArrayList<String> diseases = search.getDiseases();
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
    }
}
