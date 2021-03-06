/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nl.bioinf.DiseaseFinder.view;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet(name = "SearchBarAutocomplete", urlPatterns = {"/SearchBarAutocomplete.do"})
public class SearchBarAutocompleteServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        HPOJsonObjectCreator hj = new HPOJsonObjectCreator();
        String path = JsTreePasserServlet.class.getClassLoader()
                .getResource(File.separator + "config" + File.separator
                        + "hp.obo").toString();
        HPOFileReader hr = new HPOFileReader(path.split(":")[1]);
        HashMap collection = hr.readFile().getHPOHashMap();
        ArrayList<String> terms = new ArrayList<String>();
        for (Object term : collection.values()) {
            HPOTerm idGetter = (HPOTerm) term;
            terms.add(idGetter.getName());
        }
        response.setContentType("text/html");
        response.setHeader("Cache-control", "no-cache, no-store");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Expires", "-1");
        JSONArray arrayObj = new JSONArray();
        String query = request.getParameter("term");
        query = query.toLowerCase();
        for (String term : terms) {
            String country = term.toLowerCase();
            if (country.startsWith(query)) {
                arrayObj.put(term);
            }
        }
        out.println(arrayObj.toString());
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
