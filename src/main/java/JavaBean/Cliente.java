/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JavaBean;

import Utilities.Validator;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Gersy
 */
public class Cliente {

    private int clienteId;
    private String telefono;
    private String correoElectronico;

    private String apellidosNombres;
    
    private int usuarioId;      //FORANEA
    private Usuario usuario;    //RELACION CLASE USUARIO
    
    private Recibo recibo;      //RELACION CLASE RECIBO

    public Map<String, String> errores = new HashMap<>();

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        if ((telefono == null) && (telefono.isEmpty())) {
            errores.put("telefono", "El campo telefono no puede estar blanco.");
        } else {
            if (!Validator.isTelefono(telefono)) {
                errores.put("telefono", "Formato de telefono es incorrecto.");
            }
        }
        
        this.telefono = telefono;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        if((correoElectronico!=null)&&(!correoElectronico.isEmpty())){
            if(correoElectronico.length()>50){
                errores.put("correoElectronico", "El campo correo Electronico no puede exceder de 50 caracteres.");
            }else{
                if(!Validator.isCorreoElectronico(correoElectronico)){
                    errores.put("correoElectronico", "El campo correo Electronico tiene formato incorrecto.");
                }
            }
        } 
        this.correoElectronico = correoElectronico;
    }

    public String getApellidosNombres() {
        return apellidosNombres;
    }

    public void setApellidosNombres(String apellidosNombres) {
        this.apellidosNombres = apellidosNombres;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Recibo getRecibo() {
        return recibo;
    }

    public void setRecibo(Recibo recibo) {
        this.recibo = recibo;
    }

    public Map<String, String> getErrores() {
        return errores;
    }

    public void setErrores(Map<String, String> errores) {
        this.errores = errores;
    }
    
    

}
