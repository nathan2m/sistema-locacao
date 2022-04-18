/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence.generico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;

/**
 *
 * @author Nathan
 * @param <T>
 */
public abstract class DAO<T> {

    protected List<T> obterClasses(String sql, List<Object> params, RowMapping rm) throws ClassNotFoundException, SQLException, ServletException {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs;
        List<T> rows = new ArrayList();
        try {
            conn = DataBaseLocator.getInstance().getConnection();
            conn.setAutoCommit(false);
            pst = conn.prepareStatement(sql);
            this.receiveParameters(pst, params);
            rs = pst.executeQuery();
            while (rs.next()) {
                rows.add((T) rm.mapeamento(rs));
            }
            conn.commit();
        } catch (ClassNotFoundException | SQLException e) {
            throw new ServletException(e);
        } finally {
            DataBaseLocator.closeResources(conn, pst);
        }
        return rows;
    }

    protected T obterClasse(String sql, List<Object> params, RowMapping rm) throws SQLException, ClassNotFoundException, ServletException {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs;
        T row = null;
        try {
            conn = DataBaseLocator.getInstance().getConnection();
            conn.setAutoCommit(false);
            pst = conn.prepareStatement(sql);
            this.receiveParameters(pst, params);
            rs = pst.executeQuery();
            if (rs.next()) {
                row = (T) rm.mapeamento(rs);
            } else {
                throw new SQLException("Registration not found!");
            }
            conn.commit();
        } catch (ClassNotFoundException | SQLException e) {
            throw new ServletException(e);
        } finally {
            DataBaseLocator.closeResources(conn, pst);
        }
        return row;
    }

    protected void operacaoClasse(String sql, List<Object> params) throws SQLException, ClassNotFoundException, ServletException {
        Connection conn = null;
        PreparedStatement pst = null;
        try {
            conn = DataBaseLocator.getInstance().getConnection();
            conn.setAutoCommit(false);
            pst = conn.prepareStatement(sql);
            this.receiveParameters(pst, params);
            pst.execute();
            conn.commit();
        } catch (ClassNotFoundException | SQLException e) {
            throw new ServletException(e);
        } finally {
            DataBaseLocator.closeResources(conn, pst);
        }
    }

    private void receiveParameters(PreparedStatement pst, List<Object> params) throws SQLException {
        int paramPos = 1;
        for (Object p : params) {
            if (p == null) {
                pst.setNull(paramPos, 1);
            } else {
                pst.setObject(paramPos, p);
            }
            paramPos++;
        }
    }

    public abstract List<T> obterTs() throws ServletException;

    public abstract T obterT(int Id) throws ServletException;

    public abstract void operacao(T t, String operacao) throws ServletException;

    protected abstract RowMapping getMapa() throws ServletException;
}
