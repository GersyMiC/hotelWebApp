/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccessLayer;

import Connection.Uconnection;
import JavaBean.Administrador;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Gersy
 */
public class AdministradorDAO {
    
    public void guardar(Administrador administrador) throws Exception {
        try {
            if (administrador.getAdministradorId() == -1) {  // Si el ID es -1, insertamos
                insertar(administrador);
            } else {  // Si tiene un ID, actualizamos
                actualizar(administrador);
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void insertar(Administrador administrador) throws Exception {
        Connection con = null;
        CallableStatement cstm = null;
        try {
            con = Uconnection.getConnection();
            String sql = "CALL sp_insertar_administrador(?, ?)";  // Usamos el procedimiento de insertar
            cstm = con.prepareCall(sql);

            // Asignamos los parámetros
            cstm.setString(1, administrador.getCargo());
            cstm.setInt(2, administrador.getUsuarioId());  // Suponiendo que administrador tiene un usuarioId

            cstm.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            if (cstm != null) {
                cstm.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

    public void actualizar(Administrador administrador) throws Exception {
        Connection con = null;
        CallableStatement cstm = null;
        try {
            con = Uconnection.getConnection();
            String sql = "CALL sp_actualizar_administrador(?, ?, ?)";  // Usamos el procedimiento de actualizar
            cstm = con.prepareCall(sql);

            // Asignamos los parámetros
            cstm.setInt(1, administrador.getAdministradorId());  // El ID del administrador a actualizar
            cstm.setString(2, administrador.getCargo());  // El cargo actualizado
            cstm.setInt(3, administrador.getUsuarioId());  // El ID del usuario actualizado

            cstm.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            if (cstm != null) {
                cstm.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

    public void eliminar(int administradorId) throws Exception {
        Connection con = null;
        CallableStatement cstm = null;
        try {
            con = Uconnection.getConnection();
            String sql = "CALL sp_eliminar_administrador(?)";  // Usamos el procedimiento de eliminar
            cstm = con.prepareCall(sql);

            // Asignamos el parámetro
            cstm.setInt(1, administradorId);

            cstm.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            if (cstm != null) {
                cstm.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

    public Administrador buscarPorId(int administradorId) throws Exception {
       Connection con = null;
       CallableStatement cstm = null;
       ResultSet rs = null;
       Administrador administrador = null;
       try {
           con = Uconnection.getConnection();
           String sql = "CALL sp_buscar_administrador_por_id(?)";  // Usamos el procedimiento para buscar por ID
           cstm = con.prepareCall(sql);

           // Asignamos el parámetro
           cstm.setInt(1, administradorId);

           // Ejecutamos la consulta
           rs = cstm.executeQuery();

           if (rs.next()) {
               administrador = new Administrador();
               administrador.setAdministradorId(rs.getInt("administrador_id"));
               administrador.setCargo(rs.getString("cargo"));
               administrador.setUsuarioId(rs.getInt("usuario_id"));
           }
           return administrador;
       } catch (Exception e) {
           throw e;
       } finally {
           if (rs != null) {
               rs.close();
           }
           if (cstm != null) {
               cstm.close();
           }
           if (con != null) {
               con.close();
           }
       }
   }

   public ArrayList<Administrador> buscarPorAdministrador(String cadena) throws Exception {
       Connection con = null;
       CallableStatement cstm = null;
       ResultSet rs = null;
       ArrayList<Administrador> administradores = new ArrayList<>();
       try {
           con = Uconnection.getConnection();
           String sql = "CALL sp_buscar_administrador_por_id(?)";  // Usamos el procedimiento de búsqueda por cadena
           cstm = con.prepareCall(sql);

           // Asignamos el parámetro
           cstm.setString(1, cadena);

           // Ejecutamos la consulta
           rs = cstm.executeQuery();

           while (rs.next()) {
               Administrador administrador = new Administrador();
               administrador.setAdministradorId(rs.getInt("administrador_id"));
               administrador.setCargo(rs.getString("cargo"));
               administrador.setUsuarioId(rs.getInt("usuario_id"));

               administradores.add(administrador);
           }
           return administradores;
       } catch (Exception e) {
           throw e;
       } finally {
           if (rs != null) {
               rs.close();
           }
           if (cstm != null) {
               cstm.close();
           }
           if (con != null) {
               con.close();
           }
       }
   }
}
