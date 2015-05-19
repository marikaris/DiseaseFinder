/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.bioinf.DiseaseFinder.disease;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import nl.bioinf.DiseaseFinder.connection.OmimDataRetriever;
import nl.bioinf.DiseaseFinder.dataFinder.DiseasePhenotypeGetter;
import org.json.JSONException;

/**
 * This class collects all the possible diseases which are found.
 *
 * @author mkslofstra
 */
public class DiseaseCollector {

    /**
     * diseaseCollection is the collection of all found diseases given a
     * phenotype. This HashMap has as id the OMIM number and as value the
     * Disease object which belongs to this OMIM number.
     */
    private HashMap<String, Disease> diseaseCollection = new HashMap();

    /**
     * DiseaseCollector is the constructor of the class.
     *
     * @param features the features to look for
     * @throws JSONException when the page is not valid JSON
     * @throws IOException if the URL is invalid.
     */
    public DiseaseCollector(final String[] features) throws JSONException,
            IOException {
        HashMap diseaseMatches = this.getOmimNumbers(features);
        Iterator it = diseaseMatches.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            String id = (String) pair.getKey();
            Disease disease = this.getDiseaseContent(id);
            String match = (String) pair.getValue();
            List matches = Arrays.asList(match.split(","));
            try {
                //if the disease is not empty
                disease.setMatches(matches);
            } catch (Exception e) {
                String importance = "not";
            }
            addToDiseaseCollection(disease, id);
            it.remove(); // avoids a ConcurrentModificationException
        }
    }

    /**
     * getDiseaseCollection is the getter of diseaseCollection.
     *
     * @return diseaseCollection the collection of all found diseases.
     */
    public final HashMap<String, Disease> getDiseaseCollection() {
        return diseaseCollection;
    }

    /**
     * getOmimNumbers gets the id's of the possible diseases.
     *
     * @param features is the list of features to look for.
     * @throws JSONException when page is invalid JSON.
     * @throws IOException when URL is invalid.
     * @return diseases, an ArrayList of diseases.
     */
    private HashMap<String, String> getOmimNumbers(final String[] features)
            throws JSONException, IOException {
        // Using the config files for security reasons
        Properties config = new Properties();
        InputStream in = getClass().getResourceAsStream(
                "/config/config.properties");
        config.load(in);

        String url = config.getProperty("omimUrlNumbers");
        String apiKey = config.getProperty("omimKey");
        OmimDataRetriever omimResultGetter = new OmimDataRetriever(url, apiKey);
        HashMap<String, String> diseases = omimResultGetter
                .getOmimNumbers(features);
        in.close();
        return diseases;
    }

    /**
     * Retrieves the content of the disease.
     *
     * @param disease the disease to get the content from
     * @return a disease Object
     * @throws IOException if the URL is malformed
     * @throws JSONException if the JSON format is not correct
     */
    private Disease getDiseaseContent(final String disease) throws IOException,
            JSONException {
        DiseasePhenotypeGetter diseasePhenotype
                = new DiseasePhenotypeGetter(disease);
        return diseasePhenotype.getDisease();
    }

    /**
     * the setter of diseaseCollection.
     *
     * @param disease the disease of the id.
     * @param mimNumber the id of the disease.
     */
    public final void addToDiseaseCollection(
            final Disease disease, final String mimNumber) {
        //input should not be null
        if (mimNumber != null && disease != null) {
            diseaseCollection.put(mimNumber, disease);
        }
        // this is covered later
    }

    /**
     * getInfoOfDisease needs an OMIM number and gets the information of this
     * disease.
     *
     * @param omimNumber is the OMIM number of the disease a person wants
     * information of.
     * @return info the information about the disease.
     */
    public final String getInfoOfDisease(final String omimNumber) {
        String info = this.diseaseCollection.get(omimNumber).toString();
        return info;
    }
}
