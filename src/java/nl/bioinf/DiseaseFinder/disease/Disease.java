/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.bioinf.DiseaseFinder.disease;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Disease collects all the information about one disease which is found.
 *
 * @author mkslofstra
 */
public class Disease {

    /**
     * constructor of the class disease.
     *
     * @param mimNumberValue is the id of the disease.
     * @param titleOfDisease is the most common title of the disease.
     * @param featuresHashMap are the properties of the disease.
     */
    public Disease(final String mimNumberValue,
            final String titleOfDisease, final HashMap featuresHashMap) {
        //the mimNumber length should always be 6, otherwise, it is invalid.
        if (mimNumberValue.length() != 6) {
            throw new IllegalArgumentException("The omimNumber should be a"
                    + "String of exactly six characters.");
        }
        this.mimNumber = mimNumberValue;
        this.title = titleOfDisease;
        this.features = featuresHashMap;
        this.hits++;
    }

    /**
     * mimNumber is the OMIM number of the disease.
     */
    private String mimNumber;
    /**
     * title is the name of the disease.
     */
    private String title;
    /**
     * features are the characteristics of the disease.
     */
    private HashMap features;
    /**
     * counts the number of hits which this disease has.
     */
    private Integer hits = 0;
    /**
     * the score which is given for this disease given the phenotype.
     */
    private Double score;

    /**
     * The getter of hits.
     *
     * @return hits the number of hits a disease has.
     */
    public final Integer getHits() {
        return hits;
    }

    /**
     * The setter of hits.
     *
     * @param count the current number of hits.
     */
    public final void setHits(final Integer count) {
        this.hits = count;
    }

    /**
     * The getter of the score.
     *
     * @return score which is determined given the fenotype.
     */
    public final Double getScore() {
        return score;
    }

    /**
     * toString method of the function.
     *
     * @return the string of the function.
     */
    @Override
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator it = features.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            sb.append("\n\n" + pair.getKey() + "\n" + pair.getValue());
            it.remove(); // avoids a ConcurrentModificationException
        }
        return title + "\nmimNumber : " + mimNumber
                + ", hits : " + hits + sb.toString();
    }

    /**
     * The setter of score.
     *
     * @param givenScore the score which is given.
     */
    public final void setScore(final Double givenScore) {
        this.score = givenScore;
    }

    /**
     * The getter of the omim number.
     *
     * @return mimNumber the omim number of the disease.
     */
    public final String getMimNumber() {
        return mimNumber;
    }

    /**
     * The getter of the title of the disease.
     *
     * @return title of the disease.
     */
    public final String getTitle() {
        return title;
    }

    /**
     * The getter of getFeatures.
     *
     * @return the features of the disease.
     */
    public final HashMap getFeatures() {
        return features;
    }

    /**
     * printSummary prints the summary of the disease.
     *
     * @return summary, the summary of the disease which can be shown on the
     * website.
     */
    public final String printSummary() {
        StringBuilder diseaseSummary = new StringBuilder();
        diseaseSummary.append("<li class =\"disease\" id=\"")
                .append(mimNumber).append("\">");
        diseaseSummary.append("<table>");
        diseaseSummary.append("<tr class=\"diseaseTitle\">"
                + "<td class=\"title\" colspan=\"3\">"
                + "<a href=\"#\"><b>").append(title).append("</td></tr>");
        diseaseSummary.append("<tr>\n"
                + "<td class=\"label\">Omimnumber: </td><td class=\"value\">")
                .append(mimNumber).append("</td></tr>");
        diseaseSummary.append("<tr><td class=\"label\">Score: "
                + "</td><td class=\"value\">").append(score)
                .append("</td></tr>");
        diseaseSummary.append("</table>");
        diseaseSummary.append("</li><br/>");
        String summary = diseaseSummary.toString();
        return summary;
    }
}
