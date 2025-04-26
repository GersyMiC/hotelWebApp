/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BussinesLayer;

import DataAccessLayer.ReciboDAO;
import JavaBean.Recibo;
import java.util.ArrayList;

/**
 *
 * @author Gersy
 */
public class ReciboBO {
    
    public void guardar(Recibo recibo) throws Exception {
        try {
            ReciboDAO reciboDAO = new ReciboDAO();
            reciboDAO.guardar(recibo);
        } catch (Exception e) {
            throw e;
        }
    }

    public void eliminar(int id) throws Exception {

        try {
            ReciboDAO reciboDAO = new ReciboDAO();
            reciboDAO.eliminar(id);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public ArrayList<Recibo> buscarPorRecibo(String cadena) throws Exception {

        try {
            ReciboDAO reciboDAO = new ReciboDAO();
            return reciboDAO.buscarPorRecibo(cadena);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public Recibo buscarPorId(int id) throws Exception {
      try {
            ReciboDAO reciboDAO = new ReciboDAO();
            return reciboDAO.buscarPorId(id);
        } catch (Exception e) {
            throw e;
        }     
     }

    
}
