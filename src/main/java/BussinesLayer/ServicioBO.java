/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BussinesLayer;

import DataAccessLayer.ServicioDAO;
import JavaBean.Servicio;
import java.util.ArrayList;

/**
 *
 * @author Gersy
 */
public class ServicioBO {
    
    public void guardar(Servicio servicio) throws Exception {
        try {
            ServicioDAO servicioDAO = new ServicioDAO();
            servicioDAO.guardar(servicio);
        } catch (Exception e) {
            throw e;
        }
    }

    public void eliminar(int id) throws Exception {

        try {
            ServicioDAO servicioDAO = new ServicioDAO();
            servicioDAO.eliminar(id);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public ArrayList<Servicio> buscarPorServicio(String cadena) throws Exception {

        try {
            ServicioDAO servicioDAO = new ServicioDAO();
            return servicioDAO.buscarPorServicio(cadena);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public Servicio buscarPorId(int id) throws Exception {
      try {
            ServicioDAO servicioDAO = new ServicioDAO();
            return servicioDAO.buscarPorId(id);
        } catch (Exception e) {
            throw e;
        }     
     }

    
}
