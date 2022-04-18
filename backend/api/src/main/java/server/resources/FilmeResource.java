/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.resources;

import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Filme;
import org.json.*;
import persistence.FilmeDAO;
import server.Resource;

/**
 *
 * @author Nathan
 */
public class FilmeResource extends Resource {

    @Override
    public String getAll(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        List<Filme> filmes = FilmeDAO.getInstance().obterTs();
        JSONArray ts = new JSONArray(filmes);
        return ts.toString();
    }

    @Override
    public String getById(HttpServletRequest request, HttpServletResponse response, Integer id) throws ServletException {
        Filme filme = FilmeDAO.getInstance().obterT(id);
        JSONObject ts = new JSONObject(filme);
        return ts.toString();
    }
    
    @Override
    protected void confirmarOperacao(HttpServletRequest request, HttpServletResponse response, String s, String operacao, Integer id) throws ServletException {
        Filme filme = new Filme();
        if (!operacao.equals("Incluir") && id != null) {
            filme.setId(id);
        }
        if (!operacao.equals("Excluir") && s != null) {
            JSONObject jo = new JSONObject(s);
            filme.setTitulo(jo.getString("titulo"));
            filme.setClassificacaoIndicativa(jo.getInt("classificacaoIndicativa"));
            filme.setLancamento(jo.getInt("lancamento"));
        }
        FilmeDAO.getInstance().operacao(filme, operacao);
        response.setStatus(200);
    }
    
}
