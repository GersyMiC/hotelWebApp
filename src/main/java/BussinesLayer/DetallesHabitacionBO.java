/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BussinesLayer;

import DataAccessLayer.DetallesHabitacionDAO;
import JavaBean.DetallesHabitacion;
import java.util.ArrayList;

/**
 *
 * @author Gersy
 */
public class DetallesHabitacionBO {
    
    public void guardar(DetallesHabitacion detallesHabitacion) throws Exception {
        try {
            DetallesHabitacionDAO detallesHabitacionDAO = new DetallesHabitacionDAO();
            detallesHabitacionDAO.guardar(detallesHabitacion);
        } catch (Exception e) {
            throw e;
        }
    }

    public void eliminar(int id) throws Exception {

        try {
            DetallesHabitacionDAO detallesHabitacionDAO = new DetallesHabitacionDAO();
            detallesHabitacionDAO.eliminar(id);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public ArrayList<DetallesHabitacion> buscarPorDetallesHabitacion(String cadena) throws Exception {

        try {
            DetallesHabitacionDAO detallesHabitacionDAO = new DetallesHabitacionDAO();
            return detallesHabitacionDAO.buscarPorDetallesHabitacion(cadena);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public DetallesHabitacion buscarPorId(int id) throws Exception {
      try {
            DetallesHabitacionDAO detallesHabitacionDAO = new DetallesHabitacionDAO();
            return detallesHabitacionDAO.buscarPorId(id);
        } catch (Exception e) {
            throw e;
        }     
     }

    
}
