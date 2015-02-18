/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.bioinf.mkslofstra.DiseaseFinder.bodyFeatures;

import java.util.Arrays;

/**
 *
 * @author mkslofstra
 */
public class FeatureCollection {

    public String[] globalFeatures;

    public FeatureCollection() {
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

    public final String[] extendFeature(final String feature) {
        String[] extended = new String[]{};
        BodyFeature bodyFeature = BodyFeature.valueOf(feature);
        switch (bodyFeature) {
            case growth:
                extended = new String[]{"growthHeight", "growthWeight",
                    "growthOther"};
                break;
            case headAndNeck:
                extended = new String[]{"headAndNeckHead", "headAndNeckFace",
                    "headAndNeckEars", "headAndNeckEyes", "headAndNeckNose",
                    "headAndNeckMouth", "headAndNeckTeeth", "headAndNeckNeck"
                };
                break;
            case cardiovascular:
                extended = new String[]{"cardiovascularHeart",
                    "cardiovascularVascular"};
                break;
            case respiratory:
                extended = new String[]{"respiratoryNasopharynx",
                    "respiratoryLarynx", "respiratoryAirways",
                    "respiratoryLung"};
                break;
            case chest:
                extended = new String[]{"chestExternalFeatures",
                    "chestRibsSternumClaviclesAndScapulae",
                    "chestBreasts", "chestDiaphragm"};
                break;
            case abdomen:
                extended = new String[]{"abdomenExternalFeatures",
                    "abdomenLiver", "abdomenPancreas", "abdomenBiliaryTract",
                    "abdomenSpleen", "abdomenGastrointestinal"};
                break;
            case genitourinary:
                extended = new String[]{"genitourinaryExternalGenitaliaMale",
                    "genitourinaryExternalGenitaliaFemale",
                    "genitourinaryInternalGenitaliaMale",
                    "genitourinaryInternalGenitaliaFemale",
                    "genitourinaryKidneys", "genitourinaryUreters",
                    "genitourinaryBladder"
                };
                break;
            case skeletal:
                extended = new String[]{"skeletalSkull", "skeletalSpine",
                    "skeletalPelvis", "skeletalLimbs", "skeletalHands",
                    "skeletalFeet"};
                break;
            case skinNailsHair:
                extended = new String[]{"skinNailsHairSkin",
                    "skinNailsHairSkinHistology",
                    "skinNailsHairSkinElectronMicroscopy", "skinNailsHairNails",
                    "skinNailsHairHair"
                };
                break;
            case muscleSoftTissue:
                extended = new String[]{"muscleSoftTissue"};
                break;
            case neurologic:
                extended = new String[]{"neurologicCentralNervousSystem",
                    "neurologicPeripheralNervousSystem",
                    "neurologicBehavioralPsychiatricManifestations"};
                break;
            case voice:
                extended = new String[]{"voice"};
                break;
            case metabolicFeatures:
                extended = new String[]{"metabolicFeatures"};
                break;
            case endocrineFeatures:
                extended = new String[]{"endocrineFeatures"};
                break;
            case hematology:
                extended = new String[]{"hematology"};
                break;
            case immunology:
                extended = new String[]{"immunology"};
                break;
            case neoplasia:
                extended = new String[]{"neoplasia"};
                break;
            case prenatalManifestations:
                extended = new String[]{"prenatalManifestationsMovement",
                "prenatalManifestationsAmnioticFluid",
                "prenatalManifestationsPlacentaAndUmbilicalCord",
                "prenatalManifestationsMaternal",
                "prenatalManifestationsDelivery"};
                break;
            case laboratoryAbnormalities:
                extended = new String[]{"laboratoryAbnormalities"};
                break;
            case miscellaneous:
                extended = new String[]{"miscellaneous"};
                break;
            case molecularBasis:
                extended = new String[]{"molecularBasis"};
                break;
            default:
                System.err.println("No extended value found for: " + feature);
        }
        return extended;
    }

}
