/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JavaBean;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Gersy
 */
public class Recibo {
    private int reciboId;
    private LocalDate fecha;
    private float total;
    private String metodoPago;
    
    private int clienteId;          //foranea
    private Cliente cliente;        //RELACION CLASE CLIENTE
    
    private int administradorId;                //foranea
    private Administrador administrador;        //RELACION CLASE ADMINISTRADOR
    
    private int habitacionId;       //FORANEA
    private Habitacion habitacion;  //RELACION CLASE HABITACION
    
    public List<ReciboServicio>reciboServicios;    //RELACION CLASE RECIBODETALLES
    
    public Map<String, String> errores = new HashMap<>();

    public int getReciboId() {
        return reciboId;
    }

    public void setReciboId(int reciboId) {
        this.reciboId = reciboId;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        if (fecha == null) {
            errores.put("fecha", "El campo fecha del recibo no puede estar en vacio.");
        }

        this.fecha = fecha;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        if (total <= 0) {
            errores.put("total", "El precio total debe ser mayor que cero.");
        }

        this.total = total;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        
        List<String> LISTA_PAGOS = Arrays.asList("Efectivo", "Tarjeta");
        
        if ((metodoPago == null) || (metodoPago.isEmpty())) {
            errores.put("metodoPago", "El metodo de pago no puede estar en blanco.");
        } else {
            if (!LISTA_PAGOS.contains(metodoPago)) {
                errores.put("metodoPago", "El valor del metodo de pago es incorrecto.");
            }
        }
        
        this.metodoPago = metodoPago;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getAdministradorId() {
        return administradorId;
    }

    public void setAdministradorId(int administradorId) {
        this.administradorId = administradorId;
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
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

    public List<ReciboServicio> getReciboServicios() {
        return reciboServicios;
    }

    public void setReciboServicios(List<ReciboServicio> reciboServicios) {
        this.reciboServicios = reciboServicios;
    }
    
    
    
}
