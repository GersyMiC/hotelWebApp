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
public class Habitacion {
    private int habitacionId;
    private String numeroHabitacion;
    private String tipoHabitacion;
    
    private int detallesHabitacionId;               //FORANEA
    private DetallesHabitacion detallesHabitacion;  //RELACION CLASE DETALLESHABITACION
    
    private Recibo recibo;      //RELACION CLASE RECIBO
    
    public Map<String, String> errores = new HashMap<>();
    
    public int getHabitacionId() {
        return habitacionId;
    }

    public void setHabitacionId(int habitacionId) {
        this.habitacionId = habitacionId;
    }

    public String getNumeroHabitacion() {
        return numeroHabitacion;
    }

    public void setNumeroHabitacion(String numeroHabitacion) {
        
        if ((numeroHabitacion == null) || (numeroHabitacion.isEmpty())) {
            errores.put("numeroHabitacion", "El número de habitación no puede estar en blanco.");
        }
        
        this.numeroHabitacion = numeroHabitacion;
    }

    public String getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(String tipoHabitacion) {
        
        if ((tipoHabitacion == null) || (tipoHabitacion.isEmpty())) {
            errores.put("tipoHabitacion", "El tipo de habitación no puede estar en blanco.");
        }
        
        this.tipoHabitacion = tipoHabitacion;
    }

    public int getDetallesHabitacionId() {
        return detallesHabitacionId;
    }

    public void setDetallesHabitacionId(int detallesHabitacionId) {
        this.detallesHabitacionId = detallesHabitacionId;
    }

    public DetallesHabitacion getDetallesHabitacion() {
        return detallesHabitacion;
    }

    public void setDetallesHabitacion(DetallesHabitacion detallesHabitacion) {
        this.detallesHabitacion = detallesHabitacion;
    }

    public Map<String, String> getErrores() {
        return errores;
    }

    public void setErrores(Map<String, String> errores) {
        this.errores = errores;
    }

    public Recibo getRecibo() {
        return recibo;
    }

    public void setRecibo(Recibo recibo) {
        this.recibo = recibo;
    }
    
    
    
}
