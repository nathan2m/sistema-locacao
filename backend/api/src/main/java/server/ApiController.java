/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Nathan
 */
@WebServlet("/rest/*")
public class ApiController extends HttpServlet {

    private String resource = null;
    private Integer id = null;
    private Resource resourceObject = null;
    private ResourceExecute resourceExecuteObject = null;
    private String message = null;

    /**
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.print(message);
        out.flush();
    }

    private void checkPathInfo(HttpServletRequest request, HttpServletResponse response) {
        message = null;
        resourceObject = null;
        resourceExecuteObject = null;
        resource = null;
        id = null;
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        String pathInfo = request.getPathInfo();
        if (pathInfo != null) {
            String[] pathInfoS = pathInfo.split("/");
            if (pathInfoS.length >= 2) {
                resource = pathInfoS[1];
            }
            if (resource != null) {
                if (!resource.equals("Relatorio")) {
                    resourceObject = ResourceFactory.create("server.resources." + resource + "Resource");
                } else {
                    resourceExecuteObject = ResourceFactory.createExecute("server.resources." + resource + "ResourceExecute");
                }
            }
            if (pathInfoS.length == 3) {
                String idS = pathInfoS[2];
                try {
                    id = Integer.parseInt(idS);
                } catch (NumberFormatException e) {
                }
            }
        }
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
        checkPathInfo(request, response);
        if (resourceObject != null) {
            message = (id != null)
                    ? resourceObject.getById(request, response, id)
                    : resourceObject.getAll(request, response);
        }
        if (resourceExecuteObject != null) {
            message = resourceExecuteObject.execute(request, response);
        }
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
        checkPathInfo(request, response);
        if (resourceObject != null) {
            resourceObject.post(request, response);
        }
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>PUT</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        checkPathInfo(request, response);
        if (resourceObject != null && id != null) {
            resourceObject.put(request, response, id);
        }
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>DELETE</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        checkPathInfo(request, response);
        if (resourceObject != null && id != null) {
            resourceObject.delete(request, response, id);
        }
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
