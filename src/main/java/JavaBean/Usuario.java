/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JavaBean;

import Utilities.Validator;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Gersy
 */
public class Usuario {

    private int usuarioId;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String nombres;
    private String dni;
    private LocalDate fechaNacimiento;
    private String nombreUsuario;
    private String contrasena;
    
    private String apellidosNombres;

    public Map<String, String> errores = new HashMap<>();

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }
    
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        if ((apellidoPaterno == null) || (apellidoPaterno.isEmpty())) {
            errores.put("apellidoPaterno", "El campo apellido paterno no puede estar en blanco.");
        } else {
            if (apellidoPaterno.length() > 20) {
                errores.put("apellidoPaterno", "El campo apellido paterno no puede exceder de 20 caracteres.");
            }
        }
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        if ((apellidoMaterno == null) || (apellidoMaterno.isEmpty())) {
            errores.put("apellidoMaterno", "El campo apellido materno no puede estar en blanco.");
        } else {
            if (apellidoMaterno.length() > 20) {
                errores.put("apellidoMaterno", "El campo apellido materno no puede exceder de 20 caracteres.");
            }
        }
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        if ((nombres == null) || (nombres.isEmpty())) {
            errores.put("nombres", "El campo nombres no puede estar en blanco.");
        } else {
            if (nombres.length() > 20) {
                errores.put("nombres", "El campo nombres no puede exceder de 20 caracteres.");
            }
        }
        this.nombres = nombres;
    }

    public String getApellidosNombres() {
        return apellidosNombres;
    }

    public void setApellidosNombres(String apellidosNombres) {
        apellidosNombres = apellidoPaterno + " " + apellidoMaterno + " " + nombres; 
        if ((apellidosNombres == null) || (apellidosNombres.isEmpty())) {
            errores.put("apellidosNombres", "El campo apellidos y nombres no puede estar en blanco.");
        } else {
            if (nombres.length() > 50) {
                errores.put("apellidosNombres", "El campo apellidos y nombres no puede exceder de 50 caracteres.");
            }
        }
        
        this.apellidosNombres = apellidosNombres;
    }
    
    

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        if ((dni == null) && (dni.isEmpty())) {
            errores.put("dni", "El campo DNI no puede estar blanco.");
        } else {
            if (!Validator.isDNI(dni)) {
                errores.put("dni", "Formato de DNI es incorrecto.");
            }
        }

        this.dni = dni;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        if(fechaNacimiento==null){
            errores.put("fechaNacimiento", "El campo fecha de nacimiento no puede estar en vacio.");
        }
        
        this.fechaNacimiento = fechaNacimiento;
    }


    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        if ((nombreUsuario == null) || (nombreUsuario.isEmpty())) {
            errores.put("nombreUsuario", "El nombre de usuario no puede estar en blanco.");
        } else {
            if (nombreUsuario.length() > 20) {
                errores.put("nombreUsuario", "El nombre de usuario no puede exceder de 20 caracteres.");
            }
        }

        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {

        boolean tieneMayuscula = false;
        boolean tieneMinuscula = false;
        boolean tieneNumero = false;
        boolean tieneCaracterEspecial = false;

        if ((contrasena == null) || (contrasena.isEmpty())) {
            errores.put("contrasena", "La contraseña no puede estar en blanco.");

        } else {
            if (contrasena.length() < 8) {
                errores.put("contrasena", "La contraseña debe tener como mínimo 8 caracteres.");

            } else {
                for (char c : contrasena.toCharArray()) {
                    if (Character.isUpperCase(c)) {
                        tieneMayuscula = true;
                    } else if (Character.isLowerCase(c)) {
                        tieneMinuscula = true;
                    } else if (Character.isDigit(c)) {
                        tieneNumero = true;
                    } else if (!Character.isLetterOrDigit(c)) {
                        tieneCaracterEspecial = true;
                    }
                }

                String condicionesContrasena = "";

                if (!tieneMayuscula) {
                    condicionesContrasena += "La contraseña no tiene una letra mayúscula. ";
                } else if (!tieneMinuscula) {
                    condicionesContrasena += "La contraseña no tiene una letra minúscula. ";
                } else if (!tieneNumero) {
                    condicionesContrasena += "La contraseña no tiene un número. ";
                } else if (!tieneCaracterEspecial) {
                    condicionesContrasena += "La contraseña no tiene un caracter especial.";
                }

                if (condicionesContrasena.length() > 0) {
                    errores.put("contrasena", condicionesContrasena);
                    return;
                }

            }
        }

        this.contrasena = contrasena;
    }

    public Map<String, String> getErrores() {
        return errores;
    }

    public void setErrores(Map<String, String> errores) {
        this.errores = errores;
    }
    
    
    
}
