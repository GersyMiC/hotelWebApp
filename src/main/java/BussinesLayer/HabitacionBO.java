/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BussinesLayer;

import DataAccessLayer.HabitacionDAO;
import JavaBean.Habitacion;
import java.util.ArrayList;

/**
 *
 * @author Gersy
 */
public class HabitacionBO {
    
    public void guardar(Habitacion habitacion) throws Exception {
        try {
            HabitacionDAO habitacionDAO = new HabitacionDAO();
            habitacionDAO.guardar(habitacion);
        } catch (Exception e) {
            throw e;
        }
    }

    public void eliminar(int id) throws Exception {

        try {
            HabitacionDAO habitacionDAO = new HabitacionDAO();
            habitacionDAO.eliminar(id);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public ArrayList<Habitacion> buscarPorAlumno(String cadena) throws Exception {

        try {
            HabitacionDAO habitacionDAO = new HabitacionDAO();
            return habitacionDAO.buscarPorHabitacion(cadena);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public Habitacion buscarPorId(int id) throws Exception {
      try {
            HabitacionDAO habitacionDAO = new HabitacionDAO();
            return habitacionDAO.buscarPorId(id);
        } catch (Exception e) {
            throw e;
        }     
     }

    
}
