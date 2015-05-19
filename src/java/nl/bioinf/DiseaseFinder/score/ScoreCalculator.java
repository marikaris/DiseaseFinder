/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.bioinf.DiseaseFinder.score;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import nl.bioinf.DiseaseFinder.disease.Disease;
import nl.bioinf.DiseaseFinder.disease.DiseaseCollector;
import org.json.JSONException;

/**
 * This class will check if hits are true positive and score them.
 *
 * @author mkslofstra
 */
public class ScoreCalculator {

    public static void main(String[] args) throws JSONException, IOException {
        String[] features = new String[]{"dizziness", "blurry vision",
            "ptosis"};
        DiseaseCollector dc = new DiseaseCollector(features);
        ScoreCalculator sc = new ScoreCalculator(dc);

    }
    /**
     * matchCount is the hashmap with the occurence of all matches in the
     * search.
     */
    private HashMap<String, Double> matchCount = new HashMap();
    /**
     * The diseasecollection which is getting a score.
     */
    private HashMap diseases;
    /**
     * diseaseScore is the score given the matches and their score.
     */
    private HashMap<String, Double> diseaseScore = new HashMap();

    /**
     * ScoreCalculator calculates the score of a disease hit. This is the
     * constructor.
     *
     * @param collection the diseasecollection to calculate the score on.
     */
    public ScoreCalculator(final DiseaseCollector collection) {
        diseases = collection.getDiseaseCollection();
        this.processMatches();
        this.processDiseases();
    }

    /**
     * countMatches fills the hashmap matchCount which contains all the matches
     * and their number of occurrence through the search.
     *
     * @param matches the list of matches of a certain disease.
     */
    private void countMatches(List matches) {
        String matchWord;
        for (Object match : matches) {
            if (match.toString().startsWith(" ")) {
                matchWord = match.toString().substring(1);
            } else {
                matchWord = match.toString();
            }
            if (matchWord.endsWith(" ")) {
                matchWord = matchWord.substring(0, matchWord.length() - 1);
            }
            if (!matchCount.containsKey(matchWord)) {
                matchCount.put(matchWord, 1.0);
            } else {
                Double total = matchCount.get(matchWord) + 1;
                matchCount.put(matchWord, total);
            }
        }
    }

    /**
     * This class runs through the matches and processes them by calling the
     * method to process them.
     */
    private void processMatches() {
        HashMap<String, Disease> diseasesCopy = (HashMap<String, Disease>) diseases.clone();
        Iterator it = diseasesCopy.entrySet().iterator();
        while (it.hasNext()) {
            HashMap.Entry pair = (HashMap.Entry) it.next();
            String omimNumber = (String) pair.getKey();
            Disease disease = (Disease) pair.getValue();
            List matches = disease.getMatches();
            this.countMatches(matches);
//            this.calculateDiseaseScore(omimNumber, matches);
            it.remove(); // avoids a ConcurrentModificationException
        }
    }

    /**
     * This class runs through the diseases and processes them by calling the
     * method to process them.
     */
    private void processDiseases() {
        HashMap<String, Disease> diseasesCopy = (HashMap<String, Disease>) diseases.clone();
        Iterator it = diseasesCopy.entrySet().iterator();
        while (it.hasNext()) {
            HashMap.Entry pair = (HashMap.Entry) it.next();
            String omimNumber = (String) pair.getKey();
            Disease disease = (Disease) pair.getValue();
            List matches = disease.getMatches();
            Double score = this.calculateDiseaseScore(omimNumber, matches);
            score = new BigDecimal(score ).setScale(3, BigDecimal
                    .ROUND_HALF_UP).doubleValue();
            disease.setScore(score);
            disease.setHits(matches.size());
            it.remove(); // avoids a ConcurrentModificationException
        }
    }

    /**
     * This void fills diseaseScore given the matches a disease has and their
     * importance.
     */
    private Double calculateDiseaseScore(String omimNumber, List matches) {
        //score per match = 1/totalOfMatch, which will give a max score of 1 per match.
        Double score = 0.0;
        String matchWord;
        System.out.println("\n***" + omimNumber);
        for (Object match : matches) {
            System.out.println("match:"+match);
            if (match.toString().startsWith(" ")) {
                matchWord = match.toString().substring(1);
            } else {
                matchWord = match.toString();
            }
            if (matchWord.endsWith(" ")) {
                matchWord = matchWord.substring(0, matchWord.length() - 1);
            }
            System.out.println(matchWord+":"+matchCount.get(matchWord));
            score += 1 / matchCount.get(matchWord);
            System.out.println("1/"+matchCount.get(matchWord)+"="+1/ matchCount.get(matchWord));
        }
        return score;

    }
}
