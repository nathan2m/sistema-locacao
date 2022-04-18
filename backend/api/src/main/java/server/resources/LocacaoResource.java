/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.resources;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Locacao;
import org.json.*;
import persistence.ClienteDAO;
import persistence.FilmeDAO;
import persistence.LocacaoDAO;
import server.Resource;

/**
 *
 * @author Nathan
 */
public class LocacaoResource extends Resource {

    @Override
    public String getAll(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        List<Locacao> locacoes = LocacaoDAO.getInstance().obterTs();
        JSONArray ts = new JSONArray(locacoes);
        return ts.toString();
    }

    @Override
    public String getById(HttpServletRequest request, HttpServletResponse response, Integer id) throws ServletException {
        Locacao locacao = LocacaoDAO.getInstance().obterT(id);
        JSONObject ts = new JSONObject(locacao);
        return ts.toString();
    }

    @Override
    protected void confirmarOperacao(HttpServletRequest request, HttpServletResponse response, String s, String operacao, Integer id) throws ServletException {
        Locacao locacao = new Locacao();
        if (!operacao.equals("Incluir") && id != null) {
            locacao.setId(id);
        }
        if (!operacao.equals("Excluir") && s != null) {
            JSONObject jo = new JSONObject(s);
            locacao.setCliente(ClienteDAO.getInstance().obterT(jo.getInt("idCliente")));
            locacao.setFilme(FilmeDAO.getInstance().obterT(jo.getInt("idFilme")));
            String dataLocacao = jo.getString("dataLocacao");
            String dataDevolucao = jo.getString("dataDevolucao");
            if (dataLocacao != null && !dataLocacao.equals("")) {
                try {
                    locacao.setDataLocacao(new SimpleDateFormat("yyyy-MM-dd").parse(dataLocacao));
                } catch (ParseException e) {
                    throw new ServletException(e);
                }
            }
            if (dataDevolucao != null && !dataDevolucao.equals("")) {
                try {
                    locacao.setDataDevolucao(new SimpleDateFormat("yyyy-MM-dd").parse(dataDevolucao));
                } catch (ParseException e) {
                    throw new ServletException(e);
                }
            }
        }
        LocacaoDAO.getInstance().operacao(locacao, operacao);
        response.setStatus(200);
    }
    
}
