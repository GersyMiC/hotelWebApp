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
public class Administrador {
    private int administradorId;
    private String cargo;
    
    private Recibo recibo;      //RELACION CLASE RECIBO
    
    public Map<String, String> errores = new HashMap<>();
        
    private int usuarioId;      //FORANEA
    private Usuario usuario;    //RELACION CLASE USUARIO
    

    public int getAdministradorId() {
        return administradorId;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        if ((cargo == null) || (cargo.isEmpty())) {
            errores.put("cargo", "El campo cargo no puede estar en blanco.");
        } else {
            if (cargo.length() > 20) {
                errores.put("cargo", "El campo cargo no puede exceder de 20 caracteres.");
            }
        }
        
        this.cargo = cargo;
    }
    
    

    public void setAdministradorId(int administradorId) {
        this.administradorId = administradorId;
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
    
    public Map<String, String> getErrores() {
        return errores;
    }

    public void setErrores(Map<String, String> errores) {
        this.errores = errores;
    }
    
    
}
