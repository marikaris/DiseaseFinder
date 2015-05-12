/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.bioinf.DiseaseFinder.HPOProcessor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author aroeters
 */
public class HPOJsonObjectCreator {
    /**
     * Contains the hpoTerms.
     */
    private final HashMap<String, HPOTerm> hpoCollection;
    /**
     * The constructor of the class.
     * @throws IOException when the file is not found
     */
    public HPOJsonObjectCreator() throws IOException {
        HPOFileReader hr = new HPOFileReader(
                "/homes/aroeters/Desktop/Thema11/hp.obo");
        this.hpoCollection = hr.readFile().getHPOHashMap();
    }

    /**
     * main.
     *
     * @param args arguments
     * @throws IOException when file not found
     * @throws org.json.JSONException when Json structure is not correct
     */
    public static void main(final String[] args) throws IOException,
            JSONException {
        HPOJsonObjectCreator hj = new HPOJsonObjectCreator();
        HPOFileReader hr = new HPOFileReader(
                "/homes/aroeters/Desktop/Thema11/hp2.obo");
        hj.createJSONTree();
    }

    public final JSONArray createJSONTree()
            throws JSONException {
        HashMap jsonTree = new HashMap();
        HashMap childTree = new HashMap();
//        jsonTree = this.createJSONSubTree(this.hpoCollection.get("HP:0000001"));
        ArrayList<HashMap> rootArray = new ArrayList();
        rootArray.add(jsonTree);
        JSONObject finishedTree = new JSONObject(jsonTree);
        JSONArray arr = new JSONArray();
        arr.put(finishedTree);
        return arr;
    }

    public final HashMap createJSONSubTree(final HPOTerm hpoTerm, final String parent)
            throws JSONException {
        HashMap tree = new HashMap();
        HashMap<String, String> state = new HashMap<String, String>();

        if (hpoTerm.getId().equals("HP:0000001")) {
            state.put("opened", "true");
            state.put("selected", "false");
        } else {
            state.put("opened", "false");
            state.put("selected", "false");
        }
//        List<HashMap> childList = new ArrayList<HashMap>();
//        if (hpoTerm.hasChildren()) {
//            for (HPOTerm child : hpoTerm.getChildren()) {
//                childList.add(this.createJSONSubTree(child));
//            }
//        }
        tree.put("id", hpoTerm.getId());
        tree.put("text", hpoTerm.getName());
        tree.put("parent", parent);
        tree.put("icon", "glyphicon glyphicon-user");
        tree.put("state", state);
        if (hpoTerm.hasChildren()) {
            tree.put("children", "true");
        } else {
            tree.put("children", "false");
        }
        return tree;
    }
}

