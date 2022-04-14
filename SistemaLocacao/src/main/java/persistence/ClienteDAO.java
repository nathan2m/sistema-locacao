/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import model.Cliente;
import persistence.generico.DAO;
import persistence.generico.RowMapping;
import persistence.generico.SQLConstructor;

/**
 *
 * @author Nathan
 */
public class ClienteDAO extends DAO<Cliente> {

    private static ClienteDAO instance = new ClienteDAO();
    private final String tabela = "CLIENTE";
    private final String chavePrimaria = "ID";
    private final String[] chave = {"NOME", "CPF", "DATA_NASCIMENTO"};
    private final List<Object> params = new ArrayList<>();
    private String sql = null;

    public static ClienteDAO getInstance() {
        return instance;
    }

    @Override
    public List<Cliente> obterTs() throws ServletException {
        List<Cliente> cs = new ArrayList<>();
        params.clear();
        sql = SQLConstructor.select(tabela, null);
        try {
            cs = super.obterClasses(sql, params, getMapa());
        } catch (SQLException | ClassNotFoundException ex) {
            throw new ServletException(ex);
        }
        sql = null;
        return cs;
    }

    @Override
    public Cliente obterT(int Id) throws ServletException {
        Cliente c = new Cliente();
        params.clear();
        sql = SQLConstructor.select(tabela, chavePrimaria);
        params.add(Id);
        try {
            c = super.obterClasse(sql, params, getMapa());
        } catch (ClassNotFoundException | SQLException ex) {
            throw new ServletException(ex);
        }
        sql = null;
        return c;
    }

    @Override
    public void operacao(Cliente c, String operacao) throws ServletException {
        params.clear();
        if (operacao.equals("Excluir")) {
            sql = SQLConstructor.delete(tabela, chavePrimaria);
            params.add(c.getId());
        } else {
            params.add(c.getNome());
            params.add(c.getCPF());
            params.add(c.getDataNascimento());
            if (operacao.equals("Incluir")) {
                sql = SQLConstructor.insert(tabela, chave);
            } else if (operacao.equals("Editar")) {
                sql = SQLConstructor.update(tabela, chave, chavePrimaria);
                params.add(c.getId());
            }
        }
        try {
            super.operacaoClasse(sql, params);
        } catch (SQLException | ClassNotFoundException ex) {
            throw new ServletException(ex);
        }
        sql = null;
    }

    @Override
    protected RowMapping getMapa() throws ServletException {
        return new RowMapping() {
            @Override
            public Cliente mapeamento(ResultSet rs) throws SQLException, ServletException {
                Cliente c = new Cliente();
                c.setId(rs.getInt(chavePrimaria));
                c.setNome(rs.getString(chave[0]));
                c.setCPF(rs.getString(chave[1]));
                c.setDataNascimento(rs.getTimestamp(chave[2]) != null ? new java.util.Date(rs.getTimestamp(chave[2]).getTime()) : null);
                return c;
            }
        };
    }

}