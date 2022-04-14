/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author Nathan
 */
public class ActionFactory {

    private static Object objeto;

    public static Action create(String nomeClasse) {
        objeto = instanciar(nomeClasse);
        if (!(objeto instanceof Action)) {
            return null;
        }
        return (Action) objeto;
    }

    public static ActionExecute createExecute(String nomeClasse) {
        objeto = instanciar(nomeClasse);
        if (!(objeto instanceof ActionExecute)) {
            return null;
        }
        return (ActionExecute) objeto;
    }

    private static Object instanciar(String nomeClasse) {
        try {
            return Class.forName(nomeClasse).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException ex) {
            return null;
        }
    }
}
