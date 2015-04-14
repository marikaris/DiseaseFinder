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
import org.json.JSONObject;

/**
 *
 * @author aroeters
 */
public class HPOJsonObjectCreator {

    /**
     *
     * @throws IOException when file not found
     */
    public static void main(String[] args) throws IOException {
        HPOJsonObjectCreator hj = new HPOJsonObjectCreator();
        HPOFileReader hr = new HPOFileReader("/homes/aroeters/Desktop/Thema11/hp.obo");
        hj.jsonObjectMaker(hr.readFile().getHPOList());

    }

    /**
     * creates a json object from a given hpoterm collection.
     *
     * @param hpoCollection the collection
     */
    public final JSONObject jsonObjectMaker(final List hpoCollection) {
        HashMap<String, ArrayList> preJson = new HashMap();
        ArrayList<HashMap> array = new ArrayList();

        for (Iterator it = hpoCollection.iterator(); it.hasNext();) {
            HPOTerm hp = (HPOTerm) it.next();

            if (hp.getIsA().isEmpty()) {
                HashMap<String, Object> node = new HashMap();
                HashMap<String, Boolean> state = new HashMap();
                state.put("opened", Boolean.TRUE);
                state.put("disabled", Boolean.FALSE);
                state.put("selected", Boolean.FALSE);
                node.put("id", hp.getId());
                node.put("parent", "#");
                node.put("text", hp.getName());
                node.put("icon", "/");
                node.put("state", state);
                array.add(node);
            } else if (hp.getIsA().contains("HP:0000001")) {
                HashMap<String, Object> node = new HashMap();
                HashMap<String, Boolean> state = new HashMap();
                state.put("opened", Boolean.TRUE);
                state.put("disabled", Boolean.FALSE);
                state.put("selected", Boolean.FALSE);
                node.put("id", hp.getId());
                node.put("parent", hp.getIsA().get(0));
                node.put("text", hp.getName());
                node.put("icon", "/");
                node.put("state", state);
                array.add(node);
            } else {
                for (int i = 0; i < hp.getIsA().size(); i++) {
                    HashMap<String, Object> node = new HashMap();
                    HashMap<String, Boolean> state = new HashMap();
                    state.put("opened", Boolean.FALSE);
                    state.put("disabled", Boolean.FALSE);
                    state.put("selected", Boolean.FALSE);
                    node.put("id", hp.getId());
                    node.put("parent", hp.getIsA().get(i));
                    node.put("text", hp.getName());
                    node.put("icon", "/");
                    node.put("state", state);
                    array.add(node);
                }

            }
        }
        preJson.put("data", array);
        JSONObject json = new JSONObject(preJson);
        System.out.println(json.toString());
        return json;
    }
}
//
// Alternative format of the node (id & parent are required)
//{
//  id          : "string" // required
//  parent      : "string" // required
//  text        : "string" // node text
//  icon        : "string" // string for custom
//  state       : {
//    opened    : boolean  // is the node open
//    disabled  : boolean  // is the node disabled
//    selected  : boolean  // is the node selected
//  },
//  li_attr     : {}  // attributes for the generated LI node
//  a_attr      : {}  // attributes for the generated A node
//}
//$('#using_json_2').jstree({ 'core' : {
//    'data' : [
//       { "id" : "ajson1", "parent" : "#", "text" : "Simple root node" },
//       { "id" : "ajson2", "parent" : "#", "text" : "Root node 2" },
//       { "id" : "ajson3", "parent" : "ajson2", "text" : "Child 1" },
//       { "id" : "ajson4", "parent" : "ajson2", "text" : "Child 2" },
//    ]
//} });
