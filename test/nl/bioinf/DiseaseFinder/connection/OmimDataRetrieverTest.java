/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.bioinf.DiseaseFinder.connection;

import java.io.IOException;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * This class tests the omimdataretriever object.
 * @author mkslofstra
 */
public class OmimDataRetrieverTest {

    public OmimDataRetrieverTest() {
    }
    @BeforeClass
    public static void setUpClass() {
    }
    @AfterClass
    public static void tearDownClass() {
    }
    @Before
    public void setUp() {
    }
    @After
    public void tearDown() {
    }
    /**
     * Test of getOmimResult method, of class OmimDataRetriever.
     *
     * @throws org.json.JSONException when JSON is invalid
     * @throws java.io.IOException when URL is malformed
     */
    @Test
    public void testGetOmimResult() throws JSONException, IOException {
        System.out.println("getOmimResult");
        String omimNumber = "520000";
        OmimDataRetriever instance = new OmimDataRetriever("http://api.europe."
                + "omim.org/api/clinicalSynopsis?"
                + "mimNumber=%1$s&include=all&format=json&apiKey=%2$s",
                "3F48B5AE34656CC9211E0A476E28AF0C370E3F94");
        JSONObject content = new JSONObject("{\"omim\": { \n\"version\": \"1.0"
                + "\",\n\"clinicalSynopsisList\": [ \n{\"clinicalSynopsis\": { "
                + "\n\"mimNumber\": 520000, \n\"prefix\": \"#\", \n"
                + "\"preferredTitle\": \"DIABETES AND DEAFNESS, MATERNALLY"
                + " INHERITED; MIDD\", \n\"inheritance\": \"Mitochondrial "
                + "{UMLS:C0521451} {HPO HP:0001427}\", \n\"headAndNeckEars\": "
                + "\"Deafness, neurosensory {SNOMEDCT:60700002} {ICD10CM:H90.5}"
                + " {ICD9CM:389.1,389.10} {UMLS:C0018784};\\nImpaired "
                + "vestibular function {UMLS:C3151930} {HPO HP:0001751 UMLS:"
                + "C1843865}\", \n\"headAndNeckEyes\": \"Pigmentary retinal "
                + "degeneration {UMLS:C1833999} {HPO HP:0001146 UMLS:C1833999};"
                + "\\nMacular pattern dystrophy {UMLS:C3551077};\\nNormal "
                + "visual acuity {SNOMEDCT:82132006} {UMLS:C0234631};\\n"
                + "Concentric narrowing of visual fields {UMLS:C3151931} "
                + "{HPO HP:0007981};\\nExternal ophthalmoplegia "
                + "{SNOMEDCT:19373007} {ICD10CM:H49.88} {ICD9CM:378.55} "
                + "{UMLS:C0162292} {HPO HP:0000544 UMLS:C0162292};\\nPtosis "
                + "(less common) {UMLS:C3277642} {HPO HP:0000508 UMLS:C0005745}"
                + " {EOM ID:1bd157b764ec7aea IMG:Ptosis-small.jpg}\", \n"
                + "\"cardiovascularHeart\": \"Cardiomyopathy (in some) "
                + "{UMLS:C3551078} {HPO HP:0001638 UMLS:C0878544}\", \n"
                + "\"neurologicCentralNervousSystem\": \"Dizziness "
                + "{UMLS:C1963093} {HPO HP:0002321 UMLS:C0042571};\\nUnsteady "
                + "gait {SNOMEDCT:394616008,22631008} {UMLS:C0231686} "
                + "{HPO HP:0002317 UMLS:C0231686};\\nSeizures "
                + "{SNOMEDCT:91175000} {ICD10CM:R56.9} {ICD9CM:780.3} "
                + "{UMLS:C0036572} {HPO HP:0001250 UMLS:C0036572};\\nDysarthria"
                + " {SNOMEDCT:8011004} {ICD9CM:438.13,784.51} {UMLS:C0013362} "
                + "{HPO HP:0001260 UMLS:C0013362}\", \n"
                + "\"endocrineFeatures\": \"Diabetes mellitus (NIDDM) "
                + "{UMLS:C3151929} {HPO HP:0000819}\", \n"
                + "\"laboratoryAbnormalities\": \"Hyperglycemia "
                + "{SNOMEDCT:237598005,80394007} {ICD10CM:R73.9} "
                + "{UMLS:C0020456} {HPO HP:0003074 UMLS:C0020456}\", \n"
                + "\"miscellaneous\": \"Variable features {UMLS:C2673413};"
                + "\\nOnset of deafness and diabetes in adulthood "
                + "{UMLS:C3554705}\", \n\"molecularBasis\": \""
                + "Caused by mutation in the mitochondrial tRNA-glutamic acid "
                + "gene (MTTE, {590025.0001});\\nCaused by mutation in the "
                + "mitochondrial tRNA-leucine 1 gene (MTTL1, {590050.0001});"
                + "\\nCaused by mutation in the mitochondrial tRNA-lysine gene"
                + " (MTTK, {590060.0005})\", \n\"inheritanceExists\": true, \n"
                + "\"growthExists\": false, \n\"growthHeightExists\": false, \n"
                + "\"growthWeightExists\": false, \n\"growthOtherExists\":"
                + " false, \n\"headAndNeckExists\": true, \n"
                + "\"headAndNeckHeadExists\": false, \n\"headAndNeckFaceExists"
                + "\": false, \n\"headAndNeckEarsExists\": true, \n"
                + "\"headAndNeckEyesExists\": true, \n\"headAndNeckNoseExists"
                + "\": false, \n\"headAndNeckMouthExists\": false, \n"
                + "\"headAndNeckTeethExists\": false, \n\"headAndNeckNeckExists"
                + "\": false, \n\"cardiovascularExists\": true, \n"
                + "\"cardiovascularHeartExists\": true, \n"
                + "\"cardiovascularVascularExists\": false, \n"
                + "\"respiratoryExists\": false, \n"
                + "\"respiratoryNasopharynxExists\": false, \n"
                + "\"respiratoryLarynxExists\": false, \n"
                + "\"respiratoryAirwaysExists\": false, \n"
                + "\"respiratoryLungExists\": false, \n"
                + "\"chestExists\": false, \n\"chestExternalFeaturesExists\": "
                + "false, \n\"chestRibsSternumClaviclesAndScapulaeExists\": "
                + "false, \n\"chestBreastsExists\": false, \n"
                + "\"chestDiaphragmExists\": false, \n\"abdomenExists\": false,"
                + " \n\"abdomenExternalFeaturesExists\": false, \n"
                + "\"abdomenLiverExists\": false, \n\"abdomenPancreasExists\": "
                + "false, \n\"abdomenBiliaryTractExists\": false, \n"
                + "\"abdomenSpleenExists\": false, \n"
                + "\"abdomenGastrointestinalExists\": false, \n"
                + "\"genitourinaryExists\": false, \n"
                + "\"genitourinaryExternalGenitaliaMaleExists\": false, \n"
                + "\"genitourinaryExternalGenitaliaFemaleExists\": false, \n"
                + "\"genitourinaryInternalGenitaliaMaleExists\": false, \n"
                + "\"genitourinaryInternalGenitaliaFemaleExists\": false, \n"
                + "\"genitourinaryKidneysExists\": false, \n"
                + "\"genitourinaryUretersExists\": false, \n"
                + "\"genitourinaryBladderExists\": false, \n\"skeletalExists\":"
                + " false, \n\"skeletalSkullExists\": false, \n"
                + "\"skeletalSpineExists\": false, \n\"skeletalPelvisExists\":"
                + " false, \n\"skeletalLimbsExists\": false, \n"
                + "\"skeletalHandsExists\": false, \n\"skeletalFeetExists\": "
                + "false, \n\"skinNailsHairExists\": false, \n"
                + "\"skinNailsHairSkinExists\": false, \n"
                + "\"skinNailsHairSkinHistologyExists\": false, \n"
                + "\"skinNailsHairSkinElectronMicroscopyExists\": false, \n"
                + "\"skinNailsHairNailsExists\": false, \n"
                + "\"skinNailsHairHairExists\": false, \n"
                + "\"muscleSoftTissueExists\": false, \n\"neurologicExists\": "
                + "true, \n\"neurologicCentralNervousSystemExists\": true, \n"
                + "\"neurologicPeripheralNervousSystemExists\": false, \n"
                + "\"neurologicBehavioralPsychiatricManifestationsExists\": "
                + "false, \n\"voiceExists\": false, \n\"metabolicFeaturesExists"
                + "\": false, \n\"endocrineFeaturesExists\": true, \n"
                + "\"hematologyExists\": false, \n\"immunologyExists\": false, "
                + "\n\"neoplasiaExists\": false, \n"
                + "\"prenatalManifestationsExists\": false, \n"
                + "\"prenatalManifestationsMovementExists\": false, \n"
                + "\"prenatalManifestationsAmnioticFluidExists\": false, \n"
                + "\"prenatalManifestationsPlacentaAndUmbilicalCordExists\": "
                + "false, \n\"prenatalManifestationsMaternalExists\": false, \n"
                + "\"prenatalManifestationsDeliveryExists\": false, \n"
                + "\"laboratoryAbnormalitiesExists\": true, \n"
                + "\"miscellaneousExists\": true, \n\"molecularBasisExists\": "
                + "true, \n\"oldFormatExists\": false, \n\"contributors\": \""
                + "Cassandra L. Kniffin - updated : 10/31/2012\", \n"
                + "\"creationDate\": \"John F. Jackson : 6/15/1995\", \n"
                + "\"editHistory\": \"joanna : 11/21/2012\\nckniffin : "
                + "10/31/2012\\njoanna : 4/29/2011\", \n\"epochCreated\": "
                + "803199600, \n\"dateCreated\": \"Thu, 15 Jun 1995 03:00:00 "
                + "EDT\", \n\"epochUpdated\": 1353484800, \n\"dateUpdated\": "
                + "\"Wed, 21 Nov 2012 03:00:00 EST\", \n\"externalLinks\": "
                + "{ \n\"mgiHumanDisease\": false, \n\"dermAtlas\": false, \n"
                + "\"orphanetDiseases\": \"225;;7037;;Maternally-inherited "
                + "diabetes and deafness\", \n\"ordrDiseases\": \"4003;;"
                + "Diabetes-deafness syndrome, maternally transmitted\", \n"
                + "\"geneticsHomeReferenceIDs\": \"condition;;maternally "
                + "inherited diabetes and deafness;;maternally-inherited-"
                + "diabetes-and-deafness\", \n\"omiaIDs\": \"000284;;Diabetes "
                + "mellitus, type II;;;000279;;Diabetes mellitus\", \n"
                + "\"snomedctIDs\": \"237619009\", \n\"umlsIDs\": \"C0342289\","
                + " \n\"nextGxDx\": false, \n\"gtr\": true, \n\"geneTests\": "
                + "false, \n\"cmgGene\": false, \n\"keggPathways\": false, \n"
                + "\"komp\": false\n} \n} \n} ] \n} }");
        String omim = content.get("omim").toString();
        content = new JSONObject(omim);
        JSONArray clinicalList = new JSONArray(content.get(
                "clinicalSynopsisList").toString());
        content = new JSONObject(clinicalList.get(0).toString());
        JSONObject expResult = new JSONObject(content.get("clinicalSynopsis")
                .toString());
        JSONObject result = instance.getOmimResult(omimNumber);
        //the whole object is the same, if the mimNumber is the same
        //so if this test is true, the object is correct
        assertEquals(expResult.getInt("mimNumber"), result.getInt("mimNumber"));
    }

    /**
     * Test of getOmimNumbers method, of class OmimDataRetriever.
     */
    @Test
    public void testGetOmimNumbers() throws Exception {
        System.out.println("getOmimNumbers");
        String[] features = new String[]{"dizziness", "blurry vision",
            "ptosis"};
        OmimDataRetriever instance = new OmimDataRetriever(
                "http://api.europe.omim.org/api/entry/search?search="
                + "%1$s&filter=&fields=&retrieve=&start=0&limit=10&sort="
                + "&operator=&format=json&apiKey=%2$s",
                "3F48B5AE34656CC9211E0A476E28AF0C370E3F94");
        ArrayList expResult = new ArrayList();
        expResult.add("614944");
        expResult.add("520000");
        expResult.add("615057");
        expResult.add("300245");
        expResult.add("314570");
        expResult.add("604690");
        expResult.add("608257");
        expResult.add("243310");
        expResult.add("613627");
        expResult.add("221320");
        ArrayList result = instance.getOmimNumbers(features);
        assertEquals(expResult, result);
    }

    /**
     * IOException should be thrown when URL is malformed.
     *
     * @throws java.io.IOException when url is malformed (expected).
     * @throws org.json.JSONException when json is malformed.
     */
    @Test(expected = IOException.class)
    public void testMalformedURL() throws IOException, JSONException {
        System.out.println("URL malformed");
        String omimNumber = "520000";
        OmimDataRetriever instance = new OmimDataRetriever("http://api.europe."
                + "omim.org/api/clinicalSynopsis?"
                + "mimNumber=%1$s&include=all&format=jso&apiKey=%2$s",
                "3F48B5AE34656CC9211E0A476E28AF0C370E3F94");
        String[] features = new String[]{"dizziness", "blurry vision",
            "ptosis"};
        ArrayList result = instance.getOmimNumbers(features);
    }

    /**
     * Test if the omim number is invalid. 
     */
    @Test(expected = IOException.class)
    public void testInvalidOmimNumber() throws IOException, JSONException {
        System.out.println("Omimnumber invalid");
        String omimNumber = "52000";
        OmimDataRetriever instance = new OmimDataRetriever("http://api.europe."
                + "omim.org/api/clinicalSynopsis?"
                + "mimNumber=%1$s&include=all&format=json&apiKey=%2$s",
                "3F48B5AE34656CC9211E0A476E28AF0C370E3F94");
        String[] features = new String[]{"dizziness", "blurry vision",
            "ptosis"};
        ArrayList result = instance.getOmimNumbers(features);
    }

}
