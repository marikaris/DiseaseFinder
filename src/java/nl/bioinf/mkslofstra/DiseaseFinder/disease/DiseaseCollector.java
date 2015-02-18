/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.bioinf.mkslofstra.DiseaseFinder.disease;

import java.util.HashMap;

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

    /**
     * the setter of diseaseCollection.
     *
     * @param setDiseaseCollection the hashmap with diseases in it.
     */
    public final void setDiseaseCollection(
            final HashMap<String, Disease> setDiseaseCollection) {
        this.diseaseCollection = setDiseaseCollection;
    }

    /**
     * The constructor of the class.
     */
    public DiseaseCollector() {
        this.diseaseCollection = new HashMap();
    }
}
