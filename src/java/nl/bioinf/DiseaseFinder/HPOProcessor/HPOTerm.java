/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nl.bioinf.DiseaseFinder.HPOProcessor;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aroeters
 */
public class HPOTerm {
    /**
     * Initializes the HPOTerm with the given id.
     * @param idGiven Should be the id of the Term
     */
    public HPOTerm(final String idGiven) {
    this.id = idGiven;
    }

    /**
     * Contains the id op the HPO term.
     */
    private final String id;
    /**
     * Contains the name of the HPO term.
     */
    private String name;
    /**
     * Contains the definition of the HPO term.
     */
    private String def;
    /**
     * Contains the comment of the HPO term.
     */
    private String comment;
    /**
     * isA list contains the is_a relations ships between the HPO terms.
     */
    private final List<String> isARelations = new ArrayList<String>();
    /**
     * synonym list contains the synonyms of the HPO term.
     */
    private final List<String> synonyms = new ArrayList<String>();

    /**
     * The getter of the id.
     * @return id of the HPO term
     */
    public final String getId() {
        return id;
    }
    /**
     * The getter of the name.
     * @return name of the HPO term
     */
    public final String getName() {
        return name;
    }
    /**
     * The setter of the name.
     * @param setName String containing the name of the HPO term
     */
    public final void setName(final String setName) {
        this.name = setName;
    }
    /**
     * The getter of the definition.
     * @return definition of the HPO term
     */
    public final String getDef() {
        return def;
    }
    /**
     * The setter of the Definition.
     * @param setDef String containing the def
     */
    public final void setDef(final String setDef) {
        this.def = setDef;
    }
    /**
     * The getter of the comment.
     * @return String containing the comment
     */
    public final String getComment() {
        return comment;
    }
    /**
     * The setter of the comment.
     * @param setComment String containing the comment
     */
    public final void setComment(final String setComment) {
        this.comment = setComment;
    }
    /**
     * returns all the isA relations in a list containing Strings.
     * @return isA relations in a list
     */
    public final List getIsA() {
        return isARelations;
    }
    /**
     * Should get a String with a is a relation.
     * @param addIsARelation should be a String with the isA relation
     */
    public final void addIsA(final String addIsARelation) {
        isARelations.add(addIsARelation);
    }
    /**
     * returns all the synonyms in a list containing Strings.
     * @return synonyms in a list
     */
    public final List getSynonyms() {
        return synonyms;
    }
    /**
     * Should get a String with a synonym in it.
     * @param addSynonym should be a String with a synonym in it
     */
    public final void addSynonym(final String addSynonym) {
        synonyms.add(addSynonym);
    }
}