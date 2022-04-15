/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import controller.ActionExecute;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistence.ClienteDAO;
import persistence.FilmeDAO;
import persistence.LocacaoDAO;

/**
 *
 * @author Nathan
 */
public class RelatoriosActionExecute implements ActionExecute {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {
        Date hoje = new Date();
        request.setAttribute("dataHoje", new SimpleDateFormat("dd-MM-yyyy").format(hoje));
        request.setAttribute("clientesAtraso", ClienteDAO.getInstance().obterTsRelatorio_ClientesAtraso());
        request.setAttribute("filmesNuncaAlugados", FilmeDAO.getInstance().obterTsRelatorio_FilmesNuncaAlugados());
        request.setAttribute("filmesMaisAlugados", FilmeDAO.getInstance().obterTsRelatorio_FilmesMaisAlugados());
        request.setAttribute("filmesMenosAlugados", FilmeDAO.getInstance().obterTsRelatorio_FilmesMenosAlugados());
        request.setAttribute("locacoesCliente", LocacaoDAO.getInstance().obterTs_RelatorioLocacoesCliente());
        
        request.setAttribute("conteudo", "/relatorios.jsp");
        request.setAttribute("titulo", "Relatórios");
        request.getRequestDispatcher("estrutura/corpo.jsp").include(request, response);
    }

}
