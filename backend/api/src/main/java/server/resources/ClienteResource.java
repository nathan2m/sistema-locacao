/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.resources;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cliente;
import org.json.*;
import persistence.ClienteDAO;
import server.Resource;

/**
 *
 * @author Nathan
 */
public class ClienteResource extends Resource {

    @Override
    public String getAll(HttpServletRequest request, HttpServletResponse response) {
        List<Cliente> clientes = ClienteDAO.getInstance().obterTs();
        JSONArray ts = new JSONArray(clientes);
        return ts.toString();
    }

    @Override
    public String getById(HttpServletRequest request, HttpServletResponse response, Integer id) {
        Cliente cliente = ClienteDAO.getInstance().obterT(id);
        JSONObject ts = new JSONObject(cliente);
        return ts.toString();
    }

    @Override
    protected void confirmarOperacao(HttpServletRequest request, HttpServletResponse response, String s, String operacao, Integer id) {
        Cliente cliente = new Cliente();
        if (!operacao.equals("Incluir") && id != null) {
            cliente.setId(id);
        }
        if (!operacao.equals("Excluir") && s != null) {
            JSONObject jo = new JSONObject(s);
            cliente.setNome(jo.getString("nome"));
            cliente.setCPF(jo.getString("CPF"));
            String dataNascimento = jo.getString("dataNascimento");
            if (dataNascimento != null && !dataNascimento.equals("")) {
                try {
                    cliente.setDataNascimento(new SimpleDateFormat("yyyy-MM-dd").parse(dataNascimento));
                } catch (ParseException ex) {
                    Logger.getLogger(ClienteResource.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        ClienteDAO.getInstance().operacao(cliente, operacao);
        response.setStatus(200);
    }

}
