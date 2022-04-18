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

    private List<Filme> obterTsGeral() throws ServletException {
        List<Filme> fs = new ArrayList<>();
        params.clear();
        try {
            fs = super.obterClasses(sql, params, getMapa());
        } catch (SQLException | ClassNotFoundException e) {
            throw new ServletException(e);
        }
        sql = null;
        return fs;
    }

    @Override
    public List<Filme> obterTs() throws ServletException {
        sql = SQLConstructor.select(tabela, null);
        return obterTsGeral();
    }

    public List<Filme> obterTsRelatorio_FilmesNuncaAlugados() throws ServletException {
        sql = "SELECT f.* FROM `filme` AS f LEFT JOIN `locacao` AS l ON f.id = l.filme_id WHERE l.filme_id IS NULL";
        return obterTsGeral();
    }

    public List<Filme> obterTsRelatorio_FilmesMaisAlugados() throws ServletException {
        sql = "SELECT f.*, COUNT(l.filme_id) AS vezes_alugado_ultimo_ano FROM `filme` AS f INNER JOIN `locacao` AS l ON f.id = l.filme_id AND DATEDIFF(CURDATE(), l.data_locacao) < 365 GROUP BY l.filme_id ORDER BY vezes_alugado_ultimo_ano DESC LIMIT 5";
        return obterTsGeral();
    }

    public List<Filme> obterTsRelatorio_FilmesMenosAlugados() throws ServletException {
        sql = "SELECT f.*, COUNT(l.filme_id) AS vezes_alugado_ultima_semana FROM `filme` AS f INNER JOIN `locacao` AS l ON f.id = l.filme_id AND DATEDIFF(CURDATE(), l.data_locacao) < 7 GROUP BY l.filme_id ORDER BY vezes_alugado_ultima_semana ASC LIMIT 3";
        return obterTsGeral();
    }

    @Override
    public Filme obterT(int Id) throws ServletException {
        Filme f = new Filme();
        params.clear();
        sql = SQLConstructor.select(tabela, chavePrimaria);
        params.add(Id);
        try {
            f = super.obterClasse(sql, params, getMapa());
        } catch (ClassNotFoundException | SQLException e) {
            throw new ServletException(e);
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
        } catch (SQLException | ClassNotFoundException e) {
            throw new ServletException(e);
        }
        sql = null;
    }

    @Override
    protected RowMapping getMapa() {
        return new RowMapping() {
            @Override
            public Filme mapeamento(ResultSet rs) throws SQLException {
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
