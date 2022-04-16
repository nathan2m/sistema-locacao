/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence.generico;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nathan
 */
public class DataBaseLocator {
    private static DataBaseLocator instance = new DataBaseLocator();

    public static DataBaseLocator getInstance() {
        return instance;
    }

    private DataBaseLocator() {
    }

    public Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/sistema_locacao", "root", "jbSKQPRjQtBKuDDS");
        } catch (SQLException e) {
            Logger lgr = Logger.getLogger(Connection.class.getName());
            lgr.log(Level.SEVERE, e.getMessage(), e);
        }
        return conn;
    }

    public static void closeResources(Connection conn, Statement st) throws SQLException {
        try {
            if (st != null) {
                st.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            Logger lgr = Logger.getLogger(Connection.class.getName());
            lgr.log(Level.SEVERE, e.getMessage(), e);
        }
    }
}
