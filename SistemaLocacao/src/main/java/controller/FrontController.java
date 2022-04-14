/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Nathan
 */
public class FrontController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.lang.ClassNotFoundException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.setHeader("Cache-Control", "no-cache"); //HTTP 1.1
        response.setHeader("Pragma", "no-cache"); //HTTP 1.0
        response.setHeader("Cache-Control", "no-store");
        response.setDateHeader("Expires", 0);
        String action = request.getParameter("action");
        if (action == null || action.equals("")) {
            response.sendRedirect("/SistemaLocacao");
        }
        Action actionObject = ActionFactory.create("action." + action + "Action");
        if (actionObject != null) {
            String acao = request.getParameter("acao");
            switch (acao) {
                case "pesquisar":
                    actionObject.pesquisar(request, response);
                    request.setAttribute("titulo", "Pesquisa " + action);
                    request.getRequestDispatcher("estrutura/corpo.jsp").include(request, response);
                    break;
                case "prepararOperacao":
                    actionObject.prepararOperacao(request, response);
                    request.setAttribute("titulo", "Manter " + action);
                    request.getRequestDispatcher("estrutura/corpo.jsp").include(request, response);
                    break;
                case "confirmarOperacao":
                    actionObject.confirmarOperacao(request, response);
                    break;
                default:
                    throw new ServletException("<b>Ação '" + acao + "' não encontrada na Action: " + action + ". Favor contactar o desenvolvedor</b>");
            }
        } else {
            ActionExecute actionExeObject = ActionFactory.createExecute("action." + action + "ActionExecute");
            if (actionExeObject != null) {
                actionExeObject.execute(request, response);
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            throw new ServletException(ex);
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
        } catch (ClassNotFoundException ex) {
            throw new ServletException(ex);
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
