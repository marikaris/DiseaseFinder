/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.bioinf.DiseaseFinder.HPOProcessor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author aroeters
 */
public class HPOJsonObjectCreator {

    /**
     * main.
     *
     * @param args arguments
     * @throws IOException when file not found
     */
    public static void main(final String[] args) throws IOException {
        HPOJsonObjectCreator hj = new HPOJsonObjectCreator();
        HPOFileReader hr = new HPOFileReader(
                "/homes/aroeters/Desktop/Thema11/hp.obo");
        hj.makeJSONObject(hr.readFile().getHPOList());

    }

    /**
     * creates a JSONObject from a given hpoterm collection.
     *
     * @param hpoCollection the collection
     * @return JSONObject
     */
    public final JSONArray makeJSONObject(final List hpoCollection) {
        HashMap<String, ArrayList> preJson = new HashMap();
        JSONArray array = new JSONArray();
        for (Iterator it = hpoCollection.iterator(); it.hasNext();) {
            HPOTerm hp = (HPOTerm) it.next();
            if (hp.getIsA().isEmpty()) {
                try {
                    JSONObject node = new JSONObject();
                    JSONObject state = new JSONObject();
                    state.put("opened", Boolean.TRUE);
                    state.put("disabled", Boolean.FALSE);
                    state.put("selected", Boolean.FALSE);
                    node.put("id", hp.getId());
                    node.put("parent", "#");
                    node.put("text", hp.getName());
                    node.put("icon", "glyphicon glyphicon-user");
                    node.put("state", state);
                    array.put(node);
                } catch (JSONException ex) {
                    Logger.getLogger(HPOJsonObjectCreator.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (hp.getIsA().contains("HP:0000001")) {
                try {
                    JSONObject node = new JSONObject();
                    JSONObject state = new JSONObject();
                    state.put("opened", Boolean.TRUE);
                    state.put("disabled", Boolean.FALSE);
                    state.put("selected", Boolean.FALSE);
                    node.put("id", hp.getId());
                    node.put("parent", hp.getIsA().get(0));
                    node.put("text", hp.getName());
                    node.put("icon", "glyphicon glyphicon-user");
                    node.put("state", state);
                    array.put(node);
                } catch (JSONException ex) {
                    Logger.getLogger(HPOJsonObjectCreator.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                for (int i = 0; i < hp.getIsA().size(); i++) {
                    try {
                        JSONObject node = new JSONObject();
                        JSONObject state = new JSONObject();
                        state.put("opened", Boolean.FALSE);
                        state.put("disabled", Boolean.FALSE);
                        state.put("selected", Boolean.FALSE);
                        node.put("id", hp.getId());
                        node.put("parent", hp.getIsA().get(i));
                        node.put("text", hp.getName());
                        node.put("icon", "glyphicon glyphicon-user");
                        node.put("state", state);
                        array.put(node);
                    } catch (JSONException ex) {
                        Logger.getLogger(HPOJsonObjectCreator.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        return array;
    }
}
