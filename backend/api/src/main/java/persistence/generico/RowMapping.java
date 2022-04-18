/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence.generico;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;

/**
 *
 * @author Nathan
 * @param <T>
 */
public interface RowMapping<T> {

    T mapeamento(ResultSet rs) throws SQLException, ServletException;
}
