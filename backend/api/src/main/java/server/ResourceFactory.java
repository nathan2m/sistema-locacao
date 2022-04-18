/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import javax.servlet.ServletException;

/**
 *
 * @author Nathan
 */
public class ResourceFactory {
    private static Object objeto;

    public static Resource create(String nomeClasse) throws ServletException {
        objeto = instanciar(nomeClasse);
        if (!(objeto instanceof Resource)) {
            return null;
        }
        return (Resource) objeto;
    }
    
    public static ResourceExecute createExecute(String nomeClasse) throws ServletException {
        objeto = instanciar(nomeClasse);
        if (!(objeto instanceof ResourceExecute)) {
            return null;
        }
        return (ResourceExecute) objeto;
    }

    private static Object instanciar(String nomeClasse) throws ServletException {
        try {
            return Class.forName(nomeClasse).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            throw new ServletException(e);
        }
    }
}
