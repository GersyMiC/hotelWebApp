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
public class DetallesHabitacion {
    private int detallesHabitacionId;
    private int numeroCamas;
    private float precioHabitacion;
    
    private int habitacionId;
    
    private Habitacion habitacion;  //RELACION CLASE HABITACION
    
    public Map<String, String> errores = new HashMap<>();
    
    public int getDetallesHabitacionId() {
        return detallesHabitacionId;
    }

    public void setDetallesHabitacionId(int detallesHabitacionId) {
        this.detallesHabitacionId = detallesHabitacionId;
    }

    public int getNumeroCamas() {
        return numeroCamas;
    }

    public void setNumeroCamas(int numeroCamas) {
        if (numeroCamas <= 0) {
            errores.put("subtotal", "El numero camas debe ser mayor que cero.");
        }
        
        this.numeroCamas = numeroCamas;
    }

    public float getPrecioHabitacion() {
        return precioHabitacion;
    }

    public void setPrecioHabitacion(float precioHabitacion) {
        if (precioHabitacion <= 0) {
            errores.put("precioHabitacion", "El precio de la habitacion debe ser mayor que cero.");
        }
        
        this.precioHabitacion = precioHabitacion;
    }

    public int getHabitacionId() {
        return habitacionId;
    }

    public void setHabitacionId(int habitacionId) {
        this.habitacionId = habitacionId;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public Map<String, String> getErrores() {
        return errores;
    }

    public void setErrores(Map<String, String> errores) {
        this.errores = errores;
    }
    
    
    
    
}
