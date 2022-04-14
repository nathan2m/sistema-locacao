/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import controller.Action;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Filme;
import persistence.FilmeDAO;

/**
 *
 * @author Nathan
 */
public class FilmeAction implements Action {

    private Filme filme = new Filme();
    private final String f = "filme";
    private final String fs = f + "s";
    private final String F = "Filme";
    private final String Fs = F + "s";

    @Override
    public void pesquisar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {
        try {
            request.setAttribute(fs, FilmeDAO.getInstance().obterTs());
            //request.getRequestDispatcher("/pesquisa"+Fs+".jsp").include(request, response);
            request.setAttribute("conteudo", "/pesquisa" + Fs + ".jsp");
        } catch (ServletException ex) {
            throw new ServletException(ex);
        }
    }

    @Override
    public void prepararOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {
        try {
            String operacao = request.getParameter("operacao");
            request.setAttribute("operacao", operacao);
            if (!operacao.equals("Incluir")) {
                int idFilme = Integer.parseInt(request.getParameter("id" + F));
                filme = FilmeDAO.getInstance().obterT(idFilme);
                request.setAttribute(f, filme);
            }
            //request.getRequestDispatcher("/manter"+C+".jsp").include(request, response);
            request.setAttribute("conteudo", "/manter" + F + ".jsp");
        } catch (ServletException ex) {
            throw new ServletException(ex);
        }
    }

    @Override
    public void confirmarOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {
        String operacao = request.getParameter("operacao");
        if (!operacao.equals("Incluir")) {
            int idFilme = Integer.parseInt(request.getParameter("id" + F));
            filme.setId(idFilme);
        }
        if (!operacao.equals("Excluir")) {
            filme.setTitulo(request.getParameter("txtTitulo"));
            String classificacaoIndicativa = request.getParameter("optClassificacaoIndicativa");
            filme.setClassificacaoIndicativa(!classificacaoIndicativa.equals("") ? Integer.parseInt(classificacaoIndicativa) : null);
            filme.setLancamento(Integer.parseInt(request.getParameter("optLancamento")));
        }
        try {
            FilmeDAO.getInstance().operacao(filme, operacao);
            response.sendRedirect("FrontController?action=" + F + "&acao=pesquisar");
        } catch (IOException ex) {
            throw new ServletException(ex);
        }
    }

}
