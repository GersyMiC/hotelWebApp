/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JavaBean;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Gersy
 */
public class ReciboServicio {
    private int reciboServicioId;
    private int reciboId;       //FORANEA
    private int serviciosId;    //FORANEA
    private int cantidad;
    private float subtotal;
    
    private Recibo recibo;      //RELACION CLASE RECIBO
    private Servicio servicio;//RELACION CLASE SERVICIOS

    public int getReciboServicioId() {
        return reciboServicioId;
    }

    public void setReciboServicioId(int reciboServicioId) {
        this.reciboServicioId = reciboServicioId;
    }
    
    
    
    public Recibo getRecibo() {
        return recibo;
    }

    public void setRecibo(Recibo recibo) {
        this.recibo = recibo;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }
    
    //------------------------------------------------------
    
    public Map<String, String> errores = new HashMap<>();

    public int getReciboId() {
        return reciboId;
    }

    public void setReciboId(int reciboId) {
        this.reciboId = reciboId;
    }

    public int getServiciosId() {
        return serviciosId;
    }

    public void setServiciosId(int serviciosId) {
        this.serviciosId = serviciosId;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        if (cantidad <= 0) {
            errores.put("cantidad", "La cantidad debe ser mayor que cero.");
        }
        
        this.cantidad = cantidad;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        if (subtotal <= 0) {
            errores.put("subtotal", "El subtotal debe ser mayor que cero.");
        }
        
        this.subtotal = subtotal;
    }

    public Map<String, String> getErrores() {
        return errores;
    }

    public void setErrores(Map<String, String> errores) {
        this.errores = errores;
    }
    
    
    
}
