/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package maybeNotUsefull;

/**
 *
 * @author mkslofstra
 */
public class Body {
    /**
     * Contains the name of the feature.
     */
    private final String name = "body";
    /**
     * Contains the boolean for the feature if there is something wrong with it.
     */
    private Boolean exist;
    /**
     * Contains the information about the feature if the feature is present.
     */
    private String text;
    /**
     *
     * @return the name of the feature
     */
    public final String getName() {
        return name;
    }
    /**
     * If false nothing is wrong with the body part.
     * @return the True or False value of the feature
     */
    public final Boolean isExist() {
        return exist;
    }
    /**
     * Sets the True or False value of exist.
     * @param existValue should contain True or False
     */
    public final void setExist(final Boolean existValue) {
        this.exist = existValue;
    }
    /**
     *
     * @return the information about the abnormality
     */
    public final String getText() {
        return text;
    }
    /**
     * Sets the information about the abnormality of this feature.
     * @param textContent contains the information of the abnormality
     */
    public final void setText(final String textContent) {
        this.text = textContent;
    }
}
