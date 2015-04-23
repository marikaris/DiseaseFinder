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
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author aroeters
 */
public class HPOJsonObjectCreator {

    private HashMap<String, HashMap<String, List>> hash;
    private HashMap<String, HPOTerm> hpoCollection;

    public HPOJsonObjectCreator() throws IOException {
        HPOFileReader hr = new HPOFileReader(
                "/homes/aroeters/Desktop/Thema11/hp.obo");
        makeTree(hr.readFile().getHPOList());
    }

    /**
     * main.
     *
     * @param args arguments
     * @throws IOException when file not found
     * @throws org.json.JSONException
     */
    public static void main(final String[] args) throws IOException, JSONException {
        HPOJsonObjectCreator hj = new HPOJsonObjectCreator();
        HPOFileReader hr = new HPOFileReader(
                "/homes/aroeters/Desktop/Thema11/hp.obo");
        hj.createJSONTree(hr.readFile().getHPOList());

    }

    /**
     * creates a tree from a given hpoterm collection.
     *
     * @param hpoCollection the collection
     * @return HashMap
     */
    public final void makeTree(final List hpoCollection) {
        HashMap preJSONTree = new HashMap();
        for (Iterator it = hpoCollection.iterator(); it.hasNext();) {
            HPOTerm hp = (HPOTerm) it.next();
            if (!preJSONTree.containsKey(hp.getId())) {
                HashMap value = new HashMap();
                ArrayList children = new ArrayList();
                value.put("name", hp.getName());
                value.put("parents", hp.getIsA());
                value.put("children", children);
                preJSONTree.put(hp.getId(), value);
                for (int i = 0; i < hp.getIsA().size(); i++) {
                    if (!preJSONTree.containsKey(hp.getIsA().get(i))) {
                        HashMap values = new HashMap();
                        ArrayList child = new ArrayList();
                        children.add(hp.getId());
                        values.put("children", child);
                        preJSONTree.put(hp.getIsA().get(i), values);
                    } else {
                        HashMap parentMap = (HashMap) preJSONTree.get(hp.getIsA().get(i));
                        ArrayList childList = (ArrayList) parentMap.get("children");
                        childList.add(hp.getId());
                        parentMap.put("children", childList);
                    }
                }
            } else {
                HashMap node = (HashMap) preJSONTree.get(hp.getId());
                node.put("name", hp.getName());
                node.put("parents", hp.getIsA());
            }
        }
        this.hash = preJSONTree;
    }

    public final JSONObject createJSONTree(final List hpoCollection)
            throws JSONException {
        JSONObject jsonTree = new JSONObject();
        jsonTree = this.createJSONSubTree("HP:0000001");
        System.out.println(jsonTree);
        return jsonTree;
    }

    public final JSONObject createJSONSubTree(final String id) throws JSONException {
        HashMap root = (HashMap) hash.get(id);
        System.out.println(root);
        ArrayList children = (ArrayList) root.get("children");
        HashMap child = (HashMap) hash.get(id);
        JSONObject childTree = new JSONObject();
        JSONObject state = new JSONObject();

        childTree.put("id", id);
        childTree.put("text", child.get("name"));
        if (id.equals("HP:0000001")) {
            state.put("opened", true);
            state.put("selected", false);
        } else {
            state.put("opened", false);
            state.put("selected", false);
        }
        if (!children.isEmpty()) {
//            System.out.println(children);
            JSONArray childArray = new JSONArray();
            for (Object newChild : children) {
                childArray.put(this.createJSONSubTree(newChild.toString()));
            }
            childTree.put("children", childArray);
        } else {
            System.out.println(id + children);
        }
        return childTree;
    }

    public final JSONObject _createJSONTree(final List hpoCollection)
            throws JSONException {
        JSONObject jsonTree = new JSONObject();

        JSONObject childTree = new JSONObject();
        jsonTree = this._createJSONSubTree(this.hpoCollection.get("HP:0000001"), childTree);
        System.out.println(jsonTree);
        return jsonTree;
    }

    public final JSONObject _createJSONSubTree(final HPOTerm hpoTerm, JSONObject tree) throws JSONException {
//        HashMap root = (HashMap) hash.get(id);
        System.out.println("recursing from " + hpoTerm);
        JSONObject state = new JSONObject();
        if (hpoTerm.getId().equals("HP:0000001")) {
            state.put("opened", true);
            state.put("selected", false);
        } else {
            state.put("opened", false);
            state.put("selected", false);
        }

        if (hpoTerm.hasChildren()) {
            JSONArray childArray = new JSONArray();
            for (HPOTerm child : hpoTerm.getChildren()) {
                childArray.put(this._createJSONSubTree(child, tree));
                _createJSONSubTree(child, tree);
            }
            tree.put("children", childArray);
        } else {
            System.out.println("no children on " + hpoTerm);
        }
//        ArrayList children = (ArrayList) root.get("children");
//        HashMap child = (HashMap) hash.get(id);
//        JSONObject childTree = new JSONObject();
//        JSONObject state = new JSONObject();
//
//        childTree.put("id", id);
//        childTree.put("text", child.get("name"));
//        if (id.equals("HP:0000001")) {
//            state.put("opened", true);
//            state.put("selected", false);
//        } else {
//            state.put("opened", false);
//            state.put("selected", false);
//        }
//        if (!children.isEmpty()) {
////            System.out.println(children);
//            JSONArray childArray = new JSONArray();
//            for (Object newChild : children) {
//                childArray.put(this._createJSONSubTree(newChild.toString()));
//            }
//            childTree.put("children", childArray);
//        } else {
//            System.out.println(id + children);
//        }
//        return childTree;
    }

}
//"[{\"id\":1,\"text\":\"Root node\",\"children\":[{\"id\":2,\"text\":\"Child node 1\","
//+ "\"children\":[\"child3\",\"child4\"]}, {\"id\":3,\"text\":\"Child node 2\"}]}]"

