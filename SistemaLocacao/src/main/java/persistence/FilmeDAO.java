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
import model.Filme;
import persistence.generico.DAO;
import persistence.generico.RowMapping;
import persistence.generico.SQLConstructor;

/**
 *
 * @author Nathan
 */
public class FilmeDAO extends DAO<Filme> {

    private static FilmeDAO instance = new FilmeDAO();
    private final String tabela = "FILME";
    private final String chavePrimaria = "ID";
    private final String[] chave = {"TITULO", "CLASSIFICACAO_INDICATIVA", "LANCAMENTO"};
    private final List<Object> params = new ArrayList<>();
    private String sql = null;

    public static FilmeDAO getInstance() {
        return instance;
    }

    @Override
    public List<Filme> obterTs() throws ServletException {
        List<Filme> fs = new ArrayList<>();
        params.clear();
        sql = SQLConstructor.select(tabela, null);
        try {
            fs = super.obterClasses(sql, params, getMapa());
        } catch (SQLException | ClassNotFoundException ex) {
            throw new ServletException(ex);
        }
        sql = null;
        return fs;
    }

    @Override
    public Filme obterT(int Id) throws ServletException {
        Filme f = new Filme();
        params.clear();
        sql = SQLConstructor.select(tabela, chavePrimaria);
        params.add(Id);
        try {
            f = super.obterClasse(sql, params, getMapa());
        } catch (ClassNotFoundException | SQLException ex) {
            throw new ServletException(ex);
        }
        sql = null;
        return f;
    }

    @Override
    public void operacao(Filme f, String operacao) throws ServletException {
        params.clear();
        if (operacao.equals("Excluir")) {
            sql = SQLConstructor.delete(tabela, chavePrimaria);
            params.add(f.getId());
        } else {
            params.add(f.getTitulo());
            params.add(f.getClassificacaoIndicativa());
            params.add(f.getLancamento());
            if (operacao.equals("Incluir")) {
                sql = SQLConstructor.insert(tabela, chave);
            } else if (operacao.equals("Editar")) {
                sql = SQLConstructor.update(tabela, chave, chavePrimaria);
                params.add(f.getId());
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
            public Filme mapeamento(ResultSet rs) throws SQLException, ServletException {
                Filme f = new Filme();
                f.setId(rs.getInt(chavePrimaria));
                f.setTitulo(rs.getString(chave[0]));
                f.setClassificacaoIndicativa(rs.getInt(chave[1]));
                f.setLancamento(rs.getInt(chave[2]));
                return f;
            }
        };
    }

}
