/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BussinesLayer;

import DataAccessLayer.ClienteDAO;
import JavaBean.Cliente;
import java.util.ArrayList;

/**
 *
 * @author Gersy
 */
public class ClienteBO {

    public void guardar(Cliente cliente) throws Exception {
        try {
            ClienteDAO clienteDAO = new ClienteDAO();
            // Llamamos al método guardar del ClienteDAO
            clienteDAO.guardar(cliente);  // El DAO manejará si es insertar o actualizar
        } catch (Exception e) {
            throw e;
        }
    }

    public void eliminar(int id) throws Exception {
        try {
            ClienteDAO clienteDAO = new ClienteDAO();
            // Llamamos al método eliminar del ClienteDAO
            clienteDAO.eliminar(id);
        } catch (Exception e) {
            throw e;
        }
    }

    public ArrayList<Cliente> buscarPorCliente(String cadena) throws Exception {
        try {
            ClienteDAO clienteDAO = new ClienteDAO();
            // Llamamos al método buscarPorCliente del ClienteDAO
            return clienteDAO.buscarPorCliente(cadena);
        } catch (Exception e) {
            throw e;
        }
    }

    public Cliente buscarPorId(int id) throws Exception {
        try {
            ClienteDAO clienteDAO = new ClienteDAO();
            // Llamamos al método buscarPorId del ClienteDAO
            return clienteDAO.buscarPorId(id);
        } catch (Exception e) {
            throw e;
        }
    }
}
