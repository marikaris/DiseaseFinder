/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nl.bioinf.DiseaseFinder.HPOProcessor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author aroeters
 */
public class HPOTerm {
    /**
     * Contains the id op the HPO term.
     */
    private String id;
    /**
     * Contains the name of the HPO term.
     */
    private String name;
    /**
     * Contains the definition of the HPO term.
     */
    private String def;
    /**
     * isA list contains the is_a relations ships between the HPO terms.
     */
    private final List<String> isARelations = new ArrayList<String>();
//    /**
//     * synonym list contains the synonyms of the HPO term.
//     */
//    private final List<String> synonyms = new ArrayList<String>();
    /**
     * Contains all the children of the HPOTerm.
     */
    private HashMap<String, HPOTerm> children;
    /**
     * Checks if the HPOTerm has children.
     * @return True if the HPOTerm has children
     */
    public final boolean hasChildren() {
        return children != null && !children.isEmpty();
    }
    /**
     * Adds children to the HPOTerm.
     * @param hpoTerm the term that has to be added.
     */
    public final void addChild(final HPOTerm hpoTerm) {
        if (children == null) {
            children = new HashMap<String, HPOTerm>();
        }
        if (children.containsKey(hpoTerm.getId())) {
            throw new IllegalArgumentException("child already "
                    + "exists on this node: " + hpoTerm);
        }
        children.put(hpoTerm.getId(), hpoTerm);
    }
    /**
     * Gets a single child out of the HPOTerm.
     * @param childId the id of the child
     * @return the child with the given id
     */
    public final HPOTerm getChild(final String childId) {
        return children.get(childId);
    }
    /**
     * Returns all the children of the HPOTerm.
     * @return all the children in a List
     */
    public final List<HPOTerm> getChildren() {
        List<HPOTerm> terms = new ArrayList<HPOTerm>();
        if (this.children == null) {
            terms.addAll(Collections.EMPTY_LIST);
        } else {
            terms.addAll(this.children.values());
        }
        return terms;
    }
    /**
     * The getter of the id.
     * @return id of the HPO term
     */
    public final String getId() {
        return id;
    }
    /**
     * The setter of the id.
     * @param newId the id of the HPOTerm
     */
    public final void setId(final String newId) {
        if (newId == null) {
            throw new NullPointerException("No id is given.");
        }
        this.id = newId;
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
        if (setName ==  null) {
            throw new NullPointerException("No name is given.");
        }
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
        if (setDef == null) {
            throw new NullPointerException("No definition is given.");
        }
        this.def = setDef;
    }
//    /**
//     * The getter of the comment.
//     * @return String containing the comment
//     */
//    public final String getComment() {
//        return comment;
//    }
//    /**
//     * The setter of the comment.
//     * @param setComment String containing the comment
//     */
//    public final void setComment(final String setComment) {
//        this.comment = setComment;
//    }
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
        if (addIsARelation == null) {
            throw new NullPointerException("No relation given");
        }
        isARelations.add(addIsARelation);
    }
//    /**
//     * returns all the synonyms in a list containing Strings.
//     * @return synonyms in a list
//     */
//    public final List getSynonyms() {
//        return synonyms;
//    }
//    /**
//     * Should get a String with a synonym in it.
//     * @param addSynonym should be a String with a synonym in it
//     */
//    public final void addSynonym(final String addSynonym) {
//        synonyms.add(addSynonym);
//    }
}