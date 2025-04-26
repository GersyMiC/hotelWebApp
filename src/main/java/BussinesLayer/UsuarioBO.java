/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BussinesLayer;

import DataAccessLayer.UsuarioDAO;
import JavaBean.Usuario;
import java.util.ArrayList;

/**
 *
 * @author Gersy
 */
public class UsuarioBO {

    public void guardar(Usuario usuario) throws Exception {
        try {
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            usuarioDAO.guardar(usuario);
        } catch (Exception e) {
            throw e;
        }
    }

    public void eliminar(int id) throws Exception {

        try {
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            usuarioDAO.eliminar(id);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public ArrayList<Usuario> buscarPorAlumno(String cadena) throws Exception {

        try {
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            return usuarioDAO.buscarPorUsuario(cadena);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public Usuario buscarPorId(int id) throws Exception {
      try {
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            return usuarioDAO.buscarPorId(id);
        } catch (Exception e) {
            throw e;
        }     
     }

}
