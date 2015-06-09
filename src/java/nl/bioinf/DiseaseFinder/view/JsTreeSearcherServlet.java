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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import nl.bioinf.DiseaseFinder.HPOProcessor.HPOFileReader;
import nl.bioinf.DiseaseFinder.HPOProcessor.HPOJsonObjectCreator;
import nl.bioinf.DiseaseFinder.HPOProcessor.HPOTerm;
import org.json.JSONArray;

/**
 *
 * @author aroeters
 */
@WebServlet(name = "JsTreeSearcherServlet", urlPatterns = {"/SearchTree.do"})
public class JsTreeSearcherServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HPOJsonObjectCreator hj = new HPOJsonObjectCreator();
        String path = JsTreePasserServlet.class.getClassLoader()
                .getResource(File.separator + "config" + File.separator
                        + "hp.obo").toString();
        HPOFileReader hr = new HPOFileReader(path.split(":")[1]);
        HashMap collection = hr.readFile().getHPOHashMap();

        PrintWriter out = response.getWriter();
        String autoComp = request.getParameter("autoCompleteResult")
                .toLowerCase();

        JSONArray nodesToShow = new JSONArray();
        String id = "";
        for (Object key: collection.keySet()) {
            HPOTerm node = (HPOTerm) collection.get(key.toString());
            if (node.getName().equalsIgnoreCase(autoComp)) {
                id = node.getId();
            }
        }
        while (!id.equals("HP:0000001")) {
            HPOTerm term = (HPOTerm) collection.get(id);
            nodesToShow.put(term.getName());
            id = term.getIsA().get(0).toString();
        }
        out.println(nodesToShow);
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
        processRequest(request, response);
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
        processRequest(request, response);
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
