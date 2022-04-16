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
import java.util.logging.Level;
import java.util.logging.Logger;
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
    public List<Cliente> obterTs() {
        List<Cliente> cs = new ArrayList<>();
        params.clear();
        sql = SQLConstructor.select(tabela, null);
        try {
            cs = super.obterClasses(sql, params, getMapa());
        } catch (SQLException | ClassNotFoundException e) {
            Logger lgr = Logger.getLogger(ClienteDAO.class.getName());
            lgr.log(Level.SEVERE, e.getMessage(), e);
        }
        sql = null;
        return cs;
    }

    public List<Cliente> obterTsRelatorio_ClientesAtraso() {
        List<Cliente> cs = new ArrayList<>();
        params.clear();
        sql = "SELECT c.* FROM `cliente` AS c INNER JOIN `locacao` AS l INNER JOIN `filme` AS f ON l.filme_id = f.id AND l.cliente_id = c.id AND l.data_devolucao IS NULL AND ((f.lancamento = 1 AND DATEDIFF(CURDATE(), l.data_locacao) > 2) OR (f.lancamento = 0 AND DATEDIFF(CURDATE(), l.data_locacao) > 3)) GROUP BY c.id";
        try {
            cs = super.obterClasses(sql, params, getMapa());
        } catch (SQLException | ClassNotFoundException e) {
            Logger lgr = Logger.getLogger(ClienteDAO.class.getName());
            lgr.log(Level.SEVERE, e.getMessage(), e);
        }
        sql = null;
        return cs;
    }

    @Override
    public Cliente obterT(int Id) {
        Cliente c = new Cliente();
        params.clear();
        sql = SQLConstructor.select(tabela, chavePrimaria);
        params.add(Id);
        try {
            c = super.obterClasse(sql, params, getMapa());
        } catch (ClassNotFoundException | SQLException e) {
            Logger lgr = Logger.getLogger(ClienteDAO.class.getName());
            lgr.log(Level.SEVERE, e.getMessage(), e);
        }
        sql = null;
        return c;
    }

    @Override
    public void operacao(Cliente c, String operacao) {
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
        } catch (SQLException | ClassNotFoundException e) {
            Logger lgr = Logger.getLogger(ClienteDAO.class.getName());
            lgr.log(Level.SEVERE, e.getMessage(), e);
        }
        sql = null;
    }

    @Override
    protected RowMapping getMapa() {
        return new RowMapping() {
            @Override
            public Cliente mapeamento(ResultSet rs) throws SQLException {
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
