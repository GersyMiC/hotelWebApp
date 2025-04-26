/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccessLayer;

import Connection.Uconnection;
import JavaBean.Usuario;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Gersy
 */
public class UsuarioDAO {

    public void guardar(Usuario usuario) throws Exception {
        try {
            if (usuario.getUsuarioId() == -1) {
                insertar(usuario);
            } else {
                actualizar(usuario);
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void insertar(Usuario usuario) throws Exception {
        Connection con = null;
        CallableStatement cstm = null;
        try {
            con = Uconnection.getConnection();
            String sql = "CALL insertar_usuario(?, ?, ?, ?, ?, ?, ?)";
            cstm = con.prepareCall(sql);

            cstm.setString(1, usuario.getApellidoPaterno());
            cstm.setString(2, usuario.getApellidoMaterno());
            cstm.setString(3, usuario.getNombres());
            cstm.setString(4, usuario.getDni());
            cstm.setDate(5, Date.valueOf(usuario.getFechaNacimiento()));
            cstm.setString(6, usuario.getNombreUsuario());
            cstm.setString(7, usuario.getContrasena());

            cstm.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            if (cstm != null) cstm.close();
            if (con != null) con.close();
        }
    }

    public void actualizar(Usuario usuario) throws Exception {
        Connection con = null;
        CallableStatement cstm = null;
        try {
            con = Uconnection.getConnection();
            String sql = "CALL actualizar_usuario(?, ?, ?, ?, ?, ?, ?, ?)";
            cstm = con.prepareCall(sql);

            cstm.setInt(1, usuario.getUsuarioId());
            cstm.setString(2, usuario.getApellidoPaterno());
            cstm.setString(3, usuario.getApellidoMaterno());
            cstm.setString(4, usuario.getNombres());
            cstm.setString(5, usuario.getDni());
            cstm.setDate(6, Date.valueOf(usuario.getFechaNacimiento()));
            cstm.setString(7, usuario.getNombreUsuario());
            cstm.setString(8, usuario.getContrasena());

            cstm.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            if (cstm != null) cstm.close();
            if (con != null) con.close();
        }
    }

    public void eliminar(int id) throws Exception {
        Connection con = null;
        CallableStatement cstm = null;
        try {
            con = Uconnection.getConnection();
            String sql = "CALL eliminar_usuario(?)";
            cstm = con.prepareCall(sql);
            cstm.setInt(1, id);

            cstm.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            if (cstm != null) cstm.close();
            if (con != null) con.close();
        }
    }

    public ArrayList<Usuario> buscarPorUsuario(String nombreUsuario) throws Exception {
        Connection con = null;
        CallableStatement cstm = null;
        ResultSet rs = null;
        ArrayList<Usuario> usuarios = new ArrayList<>();
        try {
            con = Uconnection.getConnection();
            String sql = "CALL buscar_usuario_por_nombre(?)";
            cstm = con.prepareCall(sql);
            cstm.setString(1, nombreUsuario);

            rs = cstm.executeQuery();
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setUsuarioId(rs.getInt("usuario_id"));
                usuario.setApellidoPaterno(rs.getString("apellidoPaterno"));
                usuario.setApellidoMaterno(rs.getString("apellidoMaterno"));
                usuario.setNombres(rs.getString("nombres"));
                usuario.setDni(rs.getString("dni"));
                usuario.setFechaNacimiento(rs.getDate("fecha_nacimiento").toLocalDate());
                usuario.setNombreUsuario(rs.getString("nombre_usuario"));
                usuario.setContrasena(rs.getString("contrasena"));
                usuarios.add(usuario);
            }
            return usuarios;
        } catch (Exception e) {
            throw e;
        } finally {
            if (cstm != null) cstm.close();
            if (con != null) con.close();
        }
    }

    public Usuario buscarPorId(int id) throws Exception {
        Connection con = null;
        CallableStatement cstm = null;
        ResultSet rs = null;
        Usuario usuario = null;
        try {
            con = Uconnection.getConnection();
            String sql = "CALL buscar_usuario_por_id(?)";
            cstm = con.prepareCall(sql);
            cstm.setInt(1, id);

            rs = cstm.executeQuery();
            if (rs.next()) {
                usuario = new Usuario();
                usuario.setUsuarioId(rs.getInt("usuario_id"));
                usuario.setApellidoPaterno(rs.getString("apellidoPaterno"));
                usuario.setApellidoMaterno(rs.getString("apellidoMaterno"));
                usuario.setNombres(rs.getString("nombres"));
                usuario.setDni(rs.getString("dni"));
                usuario.setFechaNacimiento(rs.getDate("fecha_nacimiento").toLocalDate());
                usuario.setNombreUsuario(rs.getString("nombre_usuario"));
                usuario.setContrasena(rs.getString("contrasena"));
            }
            return usuario;
        } catch (Exception e) {
            throw e;
        } finally {
            if (cstm != null) cstm.close();
            if (con != null) con.close();
        }
    }
    
}
