/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccessLayer;

import Connection.Uconnection;
import JavaBean.DetallesHabitacion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;


/**
 *
 * @author Gersy
 */
public class DetallesHabitacionDAO {
    
    public void guardar(DetallesHabitacion detallesHabitacion) throws Exception {
        /*try {
            if (usuario.getUsuarioId() == -1) {
                insertar(usuario);
            } else {
                actualizar(usuario);
            }
        } catch (Exception e) {
            throw e;
        }*/
    }
    
    public void insertar(DetallesHabitacion detallesHabitacion) throws Exception {
        /*Connection con = null;
        CallableStatement cstm = null;
        try {
            con = Uconnection.getConnection();
            String sql = "";

            sql = "CALL sp_usuario_insertar(?,?,?,?,?,?,?)";
            cstm.registerOutParameter(1, java.sql.Types.INTEGER);

            if (usuario.getDni().isEmpty()) {
                cstm.setNull(2, java.sql.Types.VARCHAR);
            } else {
                cstm.setString(2, usuario.getDni());
            }

            cstm.setString(3, usuario.getApellidoPaterno());
            cstm.setString(4, usuario.getApellidoMaterno());
            cstm.setString(5, usuario.getNombres());
            cstm.setDate(6, Date.valueOf(usuario.getFechaNacimiento()));

            cstm.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {
            if (cstm != null) {
                cstm.close();
            }
            if (con != null) {
                cstm.close();
            }

        }*/
    }

    public void actualizar(DetallesHabitacion detallesHabitacion) throws Exception {
        /*Connection con = null;
        CallableStatement cstm = null;
        try {
            con = Uconnection.getConnection();
            String sql = "";

            sql = "CALL sp_alumno_actualizar(?,?,?,?,?,?,?)";
            cstm = con.prepareCall(sql);
            // cstm.registerOutParameter(1, java.sql.Types.INTEGER);
            cstm.setInt(1, alumno.getAlumnoId());

            if (alumno.getDni().isEmpty()) {
                cstm.setNull(2, java.sql.Types.VARCHAR);
            } else {
                cstm.setString(2, alumno.getDni());
            }

            cstm.setString(3, alumno.getApellidoPaterno());
            cstm.setString(3, alumno.getApellidoMaterno());
            cstm.setString(3, alumno.getNombres());
            cstm.setDate(6, Date.valueOf(alumno.getFechaNacimiento()));

            if (alumno.getCorreoElectronico().isEmpty()) {
                cstm.setNull(7, java.sql.Types.VARCHAR);
            } else {
                cstm.setString(7, alumno.getCorreoElectronico());
            }

            cstm.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {
            if (cstm != null) {
                cstm.close();
            }
            if (con != null) {
                cstm.close();
            }

        }*/
    }

    public void eliminar(int id) throws Exception {

        /*Connection con = null;
        CallableStatement cstm = null;
        try {
            con = Uconnection.getConnection();
            String sql = "";

            sql = "CALL sp_alumno_eliminar(?)";
            cstm = con.prepareCall(sql);
            cstm.setInt(1, id);

            cstm.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {
            if (cstm != null) {
                cstm.close();
            }
            if (con != null) {
                cstm.close();
            }

        }*/
    }

    public ArrayList<DetallesHabitacion> buscarPorDetallesHabitacion(String cadena) throws Exception {
        /*Connection con = null;
        CallableStatement cstm = null;
        ResultSet rs = null;*/ // para métodos que usan instrucción SELECT

        ArrayList<DetallesHabitacion> detallesHabitaciones = new ArrayList<>(); // para métodos que usan instrucción SELECT
        /*Usuario usuario = null; // para métodos que usan instrucción SELECT

        try {
            con = Uconnection.getConnection();
            String sql = "";

            sql = "CALL sp_usuario_buscar_por_alumno(?)";
            cstm = con.prepareCall(sql);
            cstm.setString(1, cadena);

            // cstm.executeUpdate(); // Solo se usa para insert, update y delete
            rs = cstm.executeQuery(); // Solo si se usa SELECT

            while (rs.next()) {
                usuario = new Usuario();
                usuario.setUsuarioId(rs.getInt("usuario_id"));
                usuario.setDni(rs.getString("dni"));
                usuario.setApellidosNombres(rs.getString("apellidos_nombres"));

                usuarios.add(usuario);

            }

            return usuarios;

        } catch (Exception e) {
            throw e;
        } finally {
            if (cstm != null) {
                cstm.close();
            }
            if (con != null) {
                cstm.close();
            }
        }*/
        return detallesHabitaciones;//QUITAR AL MODIFICAR
    }

    public DetallesHabitacion buscarPorId(int id) throws Exception {
        /*Connection con = null;
        CallableStatement cstm = null;
        ResultSet rs = null; // para métodos que usan instrucción SELECT

        // ArrayList<Alumno>alumnos = new ArrayList<>();*/ // para métodos que usan instrucción SELECT
        DetallesHabitacion detallesHabitacion = null; // para métodos que usan instrucción SELECT

        /*try {
            con = Uconnection.getConnection();
            String sql = "";

            sql = "CALL sp_alumno_buscar_por_id(?)";
            cstm = con.prepareCall(sql);
            cstm.setInt(1, id);

            // cstm.executeUpdate(); // Solo se usa para insert, update y delete
            rs = cstm.executeQuery(); // Solo si se usa SELECT

            while (rs.next()) {
                alumno = new Alumno();
                alumno.setAlumnoId(rs.getInt("alumno_id"));
                alumno.setDni(rs.getString("dni"));
                alumno.setApellidosNombres(rs.getString("apellidos_nombres"));
                alumno.setApellidoPaterno(rs.getString("apellido_paterno"));
                alumno.setApellidoPaterno(rs.getString("apellido_materno"));
                alumno.setNombres(rs.getString("nombres"));
                alumno.setFechaNacimiento(rs.getDate("fecha_nacimiento").toLocalDate());
                alumno.setCorreoElectronico(rs.getString("correo_electronico"));

            }

            return usuario;

        } catch (Exception e) {
            throw e;
        } finally {
            if (cstm != null) {
                cstm.close();
            }
            if (con != null) {
                cstm.close();
            }
        }*/
        return detallesHabitacion;//QUITAR AL MODIFICAR
    }

    
    
}
