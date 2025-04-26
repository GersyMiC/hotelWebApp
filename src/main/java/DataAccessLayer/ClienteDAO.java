/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccessLayer;

import Connection.Uconnection;
import JavaBean.Cliente;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Gersy
 */
public class ClienteDAO {
    
    public void guardar(Cliente cliente) throws Exception {
        try {
            if (cliente.getClienteId() == -1) {  // Si el ID del cliente es -1, significa que es un nuevo cliente
                insertar(cliente);
            } else {
                actualizar(cliente);
            }
        } catch (Exception e) {
            throw e;
        }
    }
    public void insertar(Cliente cliente) throws Exception {
        Connection con = null;
        CallableStatement cstm = null;
        try {
            con = Uconnection.getConnection();
            String sql = "CALL sp_insertar_cliente(?,?,?,?,?,?,?)";  // Procedimiento almacenado para insertar cliente

            // Registrar parámetros de salida si es necesario
            cstm = con.prepareCall(sql);
            cstm.registerOutParameter(1, java.sql.Types.INTEGER); // El primer parámetro es el ID de salida

            // Parámetros de entrada
            cstm.setString(2, cliente.getApellidosNombres());
            cstm.setString(3, cliente.getTelefono());

            if (cliente.getCorreoElectronico() != null && !cliente.getCorreoElectronico().isEmpty()) {
                cstm.setString(4, cliente.getCorreoElectronico());
            } else {
                cstm.setNull(4, java.sql.Types.VARCHAR);  // Si está vacío, pasamos NULL
            }

            cstm.setInt(5, cliente.getUsuarioId());  // Relación con la clase Usuario
            cstm.setInt(6, cliente.getRecibo().getReciboId());  // Relación con la clase Recibo

            // Ejecutar la actualización
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

    public void actualizar(Cliente cliente) throws Exception {
        Connection con = null;
        CallableStatement cstm = null;
        try {
            con = Uconnection.getConnection();
            String sql = "CALL sp_actualizar_cliente(?,?,?,?,?,?,?)";  // Procedimiento almacenado para actualizar cliente

            cstm = con.prepareCall(sql);

            // Parámetros de entrada
            cstm.setInt(1, cliente.getClienteId());  // ID del cliente
            cstm.setString(2, cliente.getApellidosNombres());
            cstm.setString(3, cliente.getTelefono());

            if (cliente.getCorreoElectronico() != null && !cliente.getCorreoElectronico().isEmpty()) {
                cstm.setString(4, cliente.getCorreoElectronico());
            } else {
                cstm.setNull(4, java.sql.Types.VARCHAR);  // Si está vacío, pasamos NULL
            }

            cstm.setInt(5, cliente.getUsuarioId());  // Relación con la clase Usuario
            cstm.setInt(6, cliente.getRecibo().getReciboId());  // Relación con la clase Recibo

            // Ejecutar la actualización
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

    public void eliminar(int id) throws Exception {
        Connection con = null;
        CallableStatement cstm = null;
        try {
            con = Uconnection.getConnection();
            String sql = "CALL sp_eliminar_cliente(?)";  // Procedimiento almacenado para eliminar cliente

            cstm = con.prepareCall(sql);
            cstm.setInt(1, id);  // Pasamos el ID del cliente a eliminar

            // Ejecutar la eliminación
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

    public ArrayList<Cliente> buscarPorCliente(String cadena) throws Exception {
        Connection con = null;
        CallableStatement cstm = null;
        ResultSet rs = null;
        ArrayList<Cliente> clientes = new ArrayList<>();

        try {
            con = Uconnection.getConnection();
            String sql = "CALL sp_buscar_cliente_por_nombre(?)";  // Procedimiento almacenado para buscar clientes por nombre o teléfono

            cstm = con.prepareCall(sql);
            cstm.setString(1, cadena);  // Pasamos la cadena de búsqueda (nombre o teléfono)

            rs = cstm.executeQuery();  // Ejecutamos la consulta

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setClienteId(rs.getInt("cliente_id"));
                cliente.setApellidosNombres(rs.getString("apellidos_nombres"));
                cliente.setTelefono(rs.getString("telefono"));
                cliente.setCorreoElectronico(rs.getString("correo_electronico"));
                cliente.setUsuarioId(rs.getInt("usuario_id"));
                // Aquí podríamos configurar también el recibo si es necesario

                clientes.add(cliente);
            }

            return clientes;

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

    public Cliente buscarPorId(int id) throws Exception {
        Connection con = null;
        CallableStatement cstm = null;
        ResultSet rs = null;
        Cliente cliente = null;

        try {
            con = Uconnection.getConnection();
            String sql = "CALL sp_buscar_cliente_por_id(?)";  // Procedimiento almacenado para buscar cliente por ID

            cstm = con.prepareCall(sql);
            cstm.setInt(1, id);  // Pasamos el ID del cliente

            rs = cstm.executeQuery();  // Ejecutamos la consulta

            if (rs.next()) {
                cliente = new Cliente();
                cliente.setClienteId(rs.getInt("cliente_id"));
                cliente.setApellidosNombres(rs.getString("apellidos_nombres"));
                cliente.setTelefono(rs.getString("telefono"));
                cliente.setCorreoElectronico(rs.getString("correo_electronico"));
                cliente.setUsuarioId(rs.getInt("usuario_id"));
                // Aquí podríamos configurar también el recibo si es necesario
            }

            return cliente;

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
