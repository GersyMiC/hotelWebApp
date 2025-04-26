/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BussinesLayer;

import DataAccessLayer.ReciboServicioDAO;
import JavaBean.ReciboServicio;
import java.util.ArrayList;

/**
 *
 * @author Gersy
 */
public class ReciboServicioBO {
    
    public void guardar(ReciboServicio reciboServicio) throws Exception {
        try {
            ReciboServicioDAO reciboServicioDAO = new ReciboServicioDAO();
            reciboServicioDAO.guardar(reciboServicio);
        } catch (Exception e) {
            throw e;
        }
    }

    public void eliminar(int id) throws Exception {

        try {
            ReciboServicioDAO reciboServicioDAO = new ReciboServicioDAO();
            reciboServicioDAO.eliminar(id);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public ArrayList<ReciboServicio> buscarPorReciboServicio(String cadena) throws Exception {

        try {
            ReciboServicioDAO reciboServicioDAO = new ReciboServicioDAO();
            return reciboServicioDAO.buscarPorReciboServicio(cadena);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public ReciboServicio buscarPorId(int id) throws Exception {
      try {
            ReciboServicioDAO reciboServicioDAO = new ReciboServicioDAO();
            return reciboServicioDAO.buscarPorId(id);
        } catch (Exception e) {
            throw e;
        }     
     }

    
}
