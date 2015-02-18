/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.bioinf.mkslofstra.DiseaseFinder.disease;

import java.lang.reflect.Array;

/**
 * Disease collects all the information about one disease which is found.
 *
 * @author mkslofstra
 */
public class Disease {

    /**
     * mimNumber is the OMIM number of the disease.
     */
    private int mimNumber;
    /**
     * title is the name of the disease.
     */
    private String title;
    /**
     * features are the characteristics of the disease.
     */
    private Array features;
    /**
     * counts the number of hits which this disease has.
     */
    private Integer hits;
    /**
     * the score which is given for this disease given the fenotype.
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
    public final int getMimNumber() {
        return mimNumber;
    }

    /**
     * The setter of the mimNumber.
     *
     * @param setMimNumber the omim number of the disease.
     */
    public final void setMimNumber(final int setMimNumber) {
        this.mimNumber = setMimNumber;
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
     * The setter of the title.
     *
     * @param setTitle the title which should be set.
     */
    public final void setTitle(final String setTitle) {
        this.title = setTitle;
    }

    /**
     * The getter of getFeatures.
     *
     * @return the features of the disease.
     */
    public final Array getFeatures() {
        return features;
    }

    /**
     * The setter of features.
     *
     * @param setFeatures of the disease.
     */
    public final void setFeatures(final Array setFeatures) {
        this.features = setFeatures;
    }
}
