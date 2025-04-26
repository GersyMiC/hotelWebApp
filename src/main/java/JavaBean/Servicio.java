/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JavaBean;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Gersy
 */
public class Servicio {
    private int serviciosId;
    private String tipoServicio;
    private String detalles;
    private float precio;
    
    private ReciboServicio reciboServicios;  //RELACION CLASE RECIBODETALLES
    
    public Map<String, String> errores = new HashMap<>();

    public int getServiciosId() {
        return serviciosId;
    }

    public void setServiciosId(int serviciosId) {
        this.serviciosId = serviciosId;
    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(String tipoServicio) {
        List<String> LISTA_SERVICIOS = Arrays.asList("Alquiler", "Alimento", "Limpieza");
        
        if ((tipoServicio == null) || (tipoServicio.isEmpty())) {
            errores.put("tipoServicio", "El tipo de servicio no puede estar en blanco.");
        } else {
            if (!LISTA_SERVICIOS.contains(tipoServicio)) {
                errores.put("tipoServicio", "El valor del tipo de servicio es incorrecto. ");
            }
        }
        
        this.tipoServicio = tipoServicio;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        if ((detalles == null) || (detalles.isEmpty())) {
            errores.put("detalles", "Los detalles de servicio no puede estar en blanco.");
        }
        
        this.detalles = detalles;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        if (precio <= 0) {
            errores.put("total", "El precio del servicio debe ser mayor que cero.");
        }
        
        this.precio = precio;
    }
    
    
}
