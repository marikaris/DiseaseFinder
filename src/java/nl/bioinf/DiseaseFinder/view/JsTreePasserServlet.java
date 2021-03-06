/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.bioinf.DiseaseFinder.view;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import nl.bioinf.DiseaseFinder.HPOProcessor.HPOFileReader;
import nl.bioinf.DiseaseFinder.HPOProcessor.HPOJsonObjectCreator;
import nl.bioinf.DiseaseFinder.HPOProcessor.HPOTerm;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author aroeters
 */
@WebServlet(name = "JsTreePasserServlet", urlPatterns = {"/PassTree.do" })
public class JsTreePasserServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws JSONException when the JSON format is not correct
     */
    protected final void processRequest(final HttpServletRequest request,
            final HttpServletResponse response)
            throws ServletException, IOException, JSONException {
        response.setContentType("application/json");

        HPOJsonObjectCreator hj = new HPOJsonObjectCreator();
        String path = JsTreePasserServlet.class.getClassLoader()
                .getResource(File.separator + "config" + File.separator
                        + "hp.obo").toString();
        HPOFileReader hr = new HPOFileReader(path.split(":")[1]);
        HashMap collection = hr.readFile().getHPOHashMap();
        String requestedNodeChildren = request.getParameter("id");
        HashMap<String, String> icons = new HashMap<String, String>();
        icons.put("HP:0000005", "img/dna.png");
        icons.put("HP:0000118", "img/human.png");
        icons.put("HP:0040006", "img/skull.png");
        icons.put("HP:0012823", "img/clock.png");
        String jsonChildren = "";
        if (requestedNodeChildren.equals("#")) {
            /*based on request attribute "id", fetch the children for that ID.*/
            jsonChildren = "["
                    + "{\"children\":true,\"icon\":\"glyphicon glyphicon-user\""
                    + ",\"id\":\"HP:0000001\", \"text\": \"All\", "
                    + "\"state\": {\"opened\": true,"
                    + " \"selected\": false}}"
                    + "]";
        } else {
            HPOTerm parent = (HPOTerm) collection.get(requestedNodeChildren);
            JSONArray children = new JSONArray();
            for (HPOTerm child : parent.getChildren()) {
                JSONObject childNode = new JSONObject(hj.createSubTree(
                        child, parent.getId()));
                if (icons.containsKey(child.getId())) {
                    childNode.put("icon", icons.get(child.getId()));
                } else {
                    childNode.put("icon", request.getParameter("icon"));
                }
                children.put(childNode);
            }
            jsonChildren = children.toString();
        }
        PrintWriter out = response.getWriter();
        out.write(jsonChildren);
        out.close();
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (JSONException ex) {
            Logger.getLogger(JsTreePasserServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (JSONException ex) {
            Logger.getLogger(JsTreePasserServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
