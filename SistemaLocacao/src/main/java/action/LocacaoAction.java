/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import controller.Action;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Locacao;
import persistence.ClienteDAO;
import persistence.FilmeDAO;
import persistence.LocacaoDAO;

/**
 *
 * @author Nathan
 */
public class LocacaoAction implements Action {

    private Locacao locacao = new Locacao();
    private final String l = "locacao";
    private final String ls = "locacoes";
    private final String L = "Locacao";
    private final String Ls = "Locacoes";

    @Override
    public void pesquisar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {
        try {
            request.setAttribute(ls, LocacaoDAO.getInstance().obterTs());
            //request.getRequestDispatcher("/pesquisa"+Ps+".jsp").include(request, response);
            request.setAttribute("conteudo", "/pesquisa" + Ls + ".jsp");
        } catch (ServletException ex) {
            throw new ServletException(ex);
        }
    }

    @Override
    public void prepararOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {
        try {
            String operacao = request.getParameter("operacao");
            request.setAttribute("operacao", operacao);
            request.setAttribute("clientes", ClienteDAO.getInstance().obterTs());
            request.setAttribute("filmes", FilmeDAO.getInstance().obterTs());
            if (!operacao.equals("Incluir")) {
                int idLocacao = Integer.parseInt(request.getParameter("id" + L));
                locacao = (Locacao) LocacaoDAO.getInstance().obterT(idLocacao);
                request.setAttribute(l, locacao);
            }
            //request.getRequestDispatcher("/manter"+P+".jsp").include(request, response);
            request.setAttribute("conteudo", "/manter" + L + ".jsp");
        } catch (ServletException ex) {
            throw new ServletException(ex);
        }
    }

    @Override
    public void confirmarOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {
        String operacao = request.getParameter("operacao");
        if (!operacao.equals("Incluir")) {
            int idLocacao = Integer.parseInt(request.getParameter("id" + L));
            locacao.setId(idLocacao);
        }
        if (!operacao.equals("Excluir")) {
            String optCliente = request.getParameter("optCliente");
            locacao.setCliente(ClienteDAO.getInstance().obterT(Integer.parseInt(optCliente)));
            locacao.setFilme(FilmeDAO.getInstance().obterT(Integer.parseInt(request.getParameter("optFilme"))));
            String dataLocacao = request.getParameter("txtDataLocacao");
            String dataDevolucao = request.getParameter("txtDataDevolucao");
            if (dataLocacao != null && !dataLocacao.equals("")) {
                try {
                    locacao.setDataLocacao(new SimpleDateFormat("yyyy-MM-dd").parse(dataLocacao));
                } catch (ParseException ex) {
                    throw new ServletException(ex);
                }
            }
            if (dataDevolucao != null && !dataDevolucao.equals("")) {
                try {
                    locacao.setDataDevolucao(new SimpleDateFormat("yyyy-MM-dd").parse(dataDevolucao));
                } catch (ParseException ex) {
                    throw new ServletException(ex);
                }
            }
        }
        try {
            LocacaoDAO.getInstance().operacao(locacao, operacao);
            response.sendRedirect("FrontController?action=" + L + "&acao=pesquisar");
        } catch (IOException ex) {
            throw new ServletException(ex);
        }
    }

}
