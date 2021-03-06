/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.BufferedReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Nathan
 */
public abstract class Resource {

    public abstract String getAll(HttpServletRequest request, HttpServletResponse response) throws ServletException;

    public abstract String getById(HttpServletRequest request, HttpServletResponse response, Integer id) throws ServletException;

    public void post(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        post_put(request, response, "Incluir", null);
    }

    public void put(HttpServletRequest request, HttpServletResponse response, Integer id) throws ServletException {
        post_put(request, response, "Editar", id);
    }

    public void delete(HttpServletRequest request, HttpServletResponse response, Integer id) throws ServletException {
        confirmarOperacao(request, response, null, "Excluir", id);
    }

    private void post_put(HttpServletRequest request, HttpServletResponse response, String operacao, Integer id) throws ServletException {
        String s;
        StringBuilder jb = new StringBuilder();
        String line;
        try {
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null) {
                jb.append(line);
            }
            s = jb.toString();
            confirmarOperacao(request, response, s, operacao, id);
        } catch (IOException e) {
            throw new ServletException(e);
        }
    }

    protected abstract void confirmarOperacao(HttpServletRequest request, HttpServletResponse response, String s, String operacao, Integer id) throws ServletException;
}
