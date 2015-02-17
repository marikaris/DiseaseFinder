/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.bioinf.mkslofstra.DiseaseFinder.bodyFeatures;

/**
 *
 * @author mkslofstra
 */
public class FeatureCollection {

    public String[] globalFeatures;
    public FeatureCollection(){
        this.fillGlobalFeatures();        
    }
    private void fillGlobalFeatures() {
        globalFeatures = new String[]{"growth", "headAndNeck",
            "cardiovascular", "respiratory", "chest", "abdomen",
            "genitourinary", "skeletal", "skinNailsHair", "muscleSoftTissue",
            "neurologic", "voice", "metabolicFeatures", "endocrineFeatures",
            "hematology", "immunology", "neoplasia", "prenatalManifestations",
            "laboratoryAbnormalities", "miscellaneous", "molecularBasis"};
    }
    private String[] extendFeature(String feature){
        String [] extended = new String[]{};
        switch (feature) {
            case "growth":
                    extended = new String[]{"growthHeight", "growthWeight", "growthOther"};
                break;
            default:
                throw new AssertionError();
        }
        return null;
    }
    
}
