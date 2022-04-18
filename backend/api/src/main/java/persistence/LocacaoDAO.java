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
import model.Locacao;
import persistence.generico.DAO;
import persistence.generico.RowMapping;
import persistence.generico.SQLConstructor;

/**
 *
 * @author Nathan
 */
public class LocacaoDAO extends DAO<Locacao> {
    private static LocacaoDAO instance = new LocacaoDAO();
    private final String tabela = "LOCACAO";
    private final String chavePrimaria = "ID";
    private final String[] chave = {"CLIENTE_ID", "FILME_ID", "DATA_LOCACAO", "DATA_DEVOLUCAO"};
    private final List<Object> params = new ArrayList<>();
    private String sql = null;

    public static LocacaoDAO getInstance() {
        return instance;
    }

    @Override
    public List<Locacao> obterTs() throws ServletException {
        List<Locacao> ls = new ArrayList<>();
        params.clear();
        sql = SQLConstructor.select(tabela, null);
        try {
            ls = super.obterClasses(sql, params, getMapa());
        } catch (SQLException | ClassNotFoundException e) {
            throw new ServletException(e);
        }
        sql = null;
        return ls;
    }
    public List<Locacao> obterTs_RelatorioLocacoesCliente() throws ServletException {
        List<Locacao> ls = new ArrayList<>();
        params.clear();
        sql = "SELECT l.* FROM `locacao` AS l INNER JOIN (SELECT c.*, COUNT(l.cliente_id) AS locacoes FROM `cliente` AS c INNER JOIN `locacao` AS l ON c.id = l.cliente_id GROUP BY l.cliente_id ORDER BY locacoes DESC LIMIT 1, 1) AS c ON l.cliente_id = c.id";
        try {
            ls = super.obterClasses(sql, params, getMapa());
        } catch (SQLException | ClassNotFoundException e) {
            throw new ServletException(e);
        }
        sql = null;
        return ls;
    }

    @Override
    public Locacao obterT(int Id) throws ServletException {
        Locacao p = new Locacao();
        params.clear();
        sql = SQLConstructor.select(tabela, chavePrimaria);
        params.add(Id);
        try {
            p = super.obterClasse(sql, params, getMapa());
        } catch (ClassNotFoundException | SQLException e) {
            throw new ServletException(e);
        }
        sql = null;
        return p;
    }

    @Override
    public void operacao(Locacao l, String operacao) throws ServletException {
        params.clear();
        if (operacao.equals("Excluir")) {
            sql = SQLConstructor.delete(tabela, chavePrimaria);
            params.add(l.getId());
        } else {
            params.add(l.getCliente().getId());
            params.add(l.getFilme().getId());
            params.add(l.getDataLocacao());
            params.add(l.getDataDevolucao());
            if (operacao.equals("Incluir")) {
                sql = SQLConstructor.insert(tabela, chave);
            } else if (operacao.equals("Editar")) {
                sql = SQLConstructor.update(tabela, chave, chavePrimaria);
                params.add(l.getId());
            }
        }
        try {
            super.operacaoClasse(sql, params);
        } catch (SQLException | ClassNotFoundException e) {
            throw new ServletException(e);
        }
        sql = null;
    }

    @Override
    protected RowMapping getMapa() {
        return new RowMapping() {
            @Override
            public Locacao mapeamento(ResultSet rs) throws SQLException, ServletException {
                Locacao l = new Locacao();
                l.setId(rs.getInt(chavePrimaria));
                l.setCliente(ClienteDAO.getInstance().obterT(rs.getInt(chave[0])));
                l.setFilme(FilmeDAO.getInstance().obterT(rs.getInt(chave[1])));
                l.setDataLocacao(rs.getTimestamp(chave[2]) != null ? new java.util.Date(rs.getTimestamp(chave[2]).getTime()) : null);
                l.setDataDevolucao(rs.getTimestamp(chave[3]) != null ? new java.util.Date(rs.getTimestamp(chave[3]).getTime()) : null);
                return l;
            }
        };
    }
}
