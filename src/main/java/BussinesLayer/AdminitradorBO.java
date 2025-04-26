/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BussinesLayer;

import DataAccessLayer.AdministradorDAO;
import JavaBean.Administrador;
import java.util.ArrayList;

/**
 *
 * @author Gersy
 */
public class AdminitradorBO {
    
    public void guardar(Administrador administrador) throws Exception {
        try {
            AdministradorDAO administradorDAO = new AdministradorDAO();
            if (administrador.getAdministradorId() == -1) {
                // Si el administrador no tiene ID, se inserta uno nuevo
                administradorDAO.insertar(administrador);
            } else {
                // Si ya tiene ID, se actualiza el administrador
                administradorDAO.actualizar(administrador);
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void eliminar(int id) throws Exception {
        try {
            AdministradorDAO administradorDAO = new AdministradorDAO();
            administradorDAO.eliminar(id);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public ArrayList<Administrador> buscarPorAdministrador(String cadena) throws Exception {
        try {
            AdministradorDAO administradorDAO = new AdministradorDAO();
            return administradorDAO.buscarPorAdministrador(cadena);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public Administrador buscarPorId(int id) throws Exception {
       try {
           AdministradorDAO administradorDAO = new AdministradorDAO();
           return administradorDAO.buscarPorId(id);
       } catch (Exception e) {
           throw e;
       }
   }

    
}
