/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.resources;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cliente;
import model.Filme;
import model.Locacao;
import org.json.JSONArray;
import persistence.ClienteDAO;
import persistence.FilmeDAO;
import persistence.LocacaoDAO;
import server.ResourceExecute;

/**
 *
 * @author Nathan
 */
public class RelatorioResourceExecute implements ResourceExecute {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String pathInfo = request.getPathInfo();
        if (pathInfo != null) {
            String[] pathInfoS = pathInfo.split("/");
            if (pathInfoS.length == 3 && pathInfoS[1].equals("Relatorio")) {
                String relatorio = pathInfoS[2];
                if (relatorio.equals("clientes_atraso_devolucao")) {
                    List<Cliente> clientes = ClienteDAO.getInstance().obterTsRelatorio_ClientesAtraso();
                    return clientesToJSON(clientes);
                }
                if (relatorio.equals("filmes_nunca_alugados")) {
                    List<Filme> filmes = FilmeDAO.getInstance().obterTsRelatorio_FilmesNuncaAlugados();
                    return filmesToJSON(filmes);
                }
                if (relatorio.equals("filmes_mais_alugados")) {
                    List<Filme> filmes = FilmeDAO.getInstance().obterTsRelatorio_FilmesMaisAlugados();
                    return filmesToJSON(filmes);
                }
                if (relatorio.equals("filmes_menos_alugados")) {
                    List<Filme> filmes = FilmeDAO.getInstance().obterTsRelatorio_FilmesMenosAlugados();
                    return filmesToJSON(filmes);
                }
                if (relatorio.equals("cliente_mais_alugou_filmes")) {
                    List<Locacao> locacoes = LocacaoDAO.getInstance().obterTs_RelatorioLocacoesCliente();
                    return locacoesToJSON(locacoes);
                }
            }
        }
        return "";
    }

    private String clientesToJSON(List<Cliente> clientes) {
        JSONArray ts = new JSONArray(clientes);
        return ts.toString();
    }

    private String filmesToJSON(List<Filme> filmes) {
        JSONArray ts = new JSONArray(filmes);
        return ts.toString();
    }

    private String locacoesToJSON(List<Locacao> locacoes) {
        JSONArray ts = new JSONArray(locacoes);
        return ts.toString();
    }

}
