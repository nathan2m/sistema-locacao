/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence.generico;

/**
 *
 * @author Nathan
 */
public class SQLConstructor {

    public static String select(String tabela, String chavePrimaria) {
        String sql;
        sql = "SELECT * FROM " + tabela;
        if (chavePrimaria != null) {
            sql += " WHERE " + chavePrimaria + " = ?";
        }
        return sql;
    }

    public static String delete(String tabela, String chavePrimaria) {
        return "DELETE FROM " + tabela + " WHERE " + chavePrimaria + " = ?";
    }

    public static String insert(String tabela, String[] chave) {
        String sql = "INSERT INTO " + tabela + " (";
        for (int i = 0; i < chave.length; i++) {
            sql += chave[i];
            if (i < (chave.length - 1)) {
                sql += ", ";
            }
        }
        sql += " ) VALUES (";
        for (int i = 0; i < chave.length; i++) {
            sql += "?";
            if (i < (chave.length - 1)) {
                sql += ",";
            }
        }
        sql += ")";
        return sql;
    }

    public static String update(String tabela, String[] chave, String chavePrimaria) {
        String sql = "UPDATE " + tabela + " SET ";
        for (int i = 0; i < chave.length; i++) {
            sql += chave[i] + " = ?";
            if (i < (chave.length - 1)) {
                sql += ", ";
            }
        }
        sql += " WHERE " + chavePrimaria + " = ?";
        return sql;
    }
}
