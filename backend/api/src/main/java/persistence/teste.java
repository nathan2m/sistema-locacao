/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.util.List;
import model.Cliente;

/**
 *
 * @author Nathan
 */
public class teste {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Cliente> clientes = ClienteDAO.getInstance().obterTs();
        for (Cliente cliente : clientes) {
            System.out.println(cliente.getNome());
        }
    }
    
}
