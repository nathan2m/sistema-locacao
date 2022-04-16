/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.BufferedReader;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Nathan
 */
public abstract class Resource {
    
    public abstract String getAll(HttpServletRequest request, HttpServletResponse response);
    
    public abstract String getById(HttpServletRequest request, HttpServletResponse response, Integer id);
    
    public void post(HttpServletRequest request, HttpServletResponse response) {
        String s;
        StringBuilder jb = new StringBuilder();
        String line;
        try {
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null) {
                jb.append(line);
            }
            s = jb.toString();
            confirmarOperacao(request, response, s, "Incluir", null);
        } catch (IOException e) {
        }
    }
    
    public void put(HttpServletRequest request, HttpServletResponse response, Integer id) {
        String s;
        StringBuilder jb = new StringBuilder();
        String line;
        try {
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null) {
                jb.append(line);
            }
            s = jb.toString();
            confirmarOperacao(request, response, s, "Editar", id);
        } catch (IOException e) {
        }
    }
    
    public void delete(HttpServletRequest request, HttpServletResponse response, Integer id) {
        confirmarOperacao(request, response, null, "Excluir", id);
    }
    
    protected abstract void confirmarOperacao(HttpServletRequest request, HttpServletResponse response, String s, String operacao, Integer id);
}
