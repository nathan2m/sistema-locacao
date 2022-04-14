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
import model.Cliente;
import persistence.ClienteDAO;

/**
 *
 * @author Nathan
 */
public class ClienteAction implements Action {

    private Cliente cliente = new Cliente();
    private final String c = "cliente";
    private final String cs = c + "s";
    private final String C = "Cliente";
    private final String Cs = C + "s";

    @Override
    public void pesquisar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {
        try {
            request.setAttribute(cs, ClienteDAO.getInstance().obterTs());
            //request.getRequestDispatcher("/pesquisa"+Cs+".jsp").include(request, response);
            request.setAttribute("conteudo", "/pesquisa" + Cs + ".jsp");
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
                int idCliente = Integer.parseInt(request.getParameter("id" + C));
                cliente = ClienteDAO.getInstance().obterT(idCliente);
                request.setAttribute(c, cliente);
            }
            //request.getRequestDispatcher("/manter"+C+".jsp").include(request, response);
            request.setAttribute("conteudo", "/manter" + C + ".jsp");
        } catch (ServletException ex) {
            throw new ServletException(ex);
        }
    }

    @Override
    public void confirmarOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {
        String operacao = request.getParameter("operacao");
        if (!operacao.equals("Incluir")) {
            int idCliente = Integer.parseInt(request.getParameter("id" + C));
            cliente.setId(idCliente);
        }
        if (!operacao.equals("Excluir")) {
            cliente.setNome(request.getParameter("txtNome"));
            cliente.setCPF(request.getParameter("txtCPF"));
            String dataNascimento = request.getParameter("txtDataNascimento");
            if (dataNascimento != null && !dataNascimento.equals("")) {
                try {
                    cliente.setDataNascimento(new SimpleDateFormat("yyyy-MM-dd").parse(dataNascimento));
                } catch (ParseException ex) {
                    throw new ServletException(ex);
                }
            }
        }
        try {
            ClienteDAO.getInstance().operacao(cliente, operacao);
            response.sendRedirect("FrontController?action=" + C + "&acao=pesquisar");
        } catch (IOException ex) {
            throw new ServletException(ex);
        }
    }

}
