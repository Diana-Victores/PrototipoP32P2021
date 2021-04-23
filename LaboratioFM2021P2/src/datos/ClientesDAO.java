/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import dominio.Clientes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Diana
 */
public class ClientesDAO {
    
    private static final String SQL_SELECT = "SELECT PK_id_cliente, nombre_cliente, apellido_cliente, edad_cliente, CodigoCorreo_cliente, CodigoDireccion_cliente, CodigoTelefono_cliente, DPI_cliente FROM tbl_cliente";
    private static final String SQL_INSERT = "INSERT INTO tbl_cliente (PK_id_cliente, nombre_cliente, apellido_cliente, edad_cliente, CodigoCorreo_cliente, CodigoDireccion_cliente,  CodigoTelefono_cliente, DPI_cliente) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
    //   private static final String SQL_UPDATE = "UPDATE tbl_articulos SET fecha_ingreso=?, nombre_articulo=?, talla_articuloXS=?, talla_articuloS=?, talla_articuloM=?, talla_articuloL=?, talla_articuloXL=?,  color_articulo=?, nombre_proveedor=?, existencia_articulo=?  WHERE PK_id_articulo = ?";
    private static final String SQL_UPDATE = "UPDATE tbl_cliente SET nombre_cliente=?, apellido_cliente=?, edad_cliente=?, CodigoCorreo_cliente=?, CodigoDireccion_cliente=?, CodigoTelefono_cliente=?, DPI_cliente=? WHERE PK_id_cliente=?";
    private static final String SQL_DELETE = "DELETE FROM tbl_cliente WHERE PK_id_cliente=?";
    private static final String SQL_QUERY = "SELECT PK_id_cliente, nombre_cliente, apellido_cliente, edad_cliente, CodigoCorreo_cliente, CodigoDireccion_cliente, CodigoTelefono_cliente, DPI_cliente FROM tbl_cliente WHERE PK_id_cliente = ?";

    public List<Clientes> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Clientes registocliente = null;
        List<Clientes> registoclientes = new ArrayList<Clientes>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {

                int PK_id_cliente = rs.getInt("PK_id_cliente");
                String nombre_cliente = rs.getString("nombre_cliente");
                String apellido_cliente = rs.getString("apellido_cliente");
                String edad_cliente = rs.getString("edad_cliente");
                String CodigoCorreo_cliente = rs.getString("CodigoCorreo_cliente");
                String CodigoDireccion_cliente = rs.getString("CodigoDireccion_cliente");
                String CodigoTelefono_cliente = rs.getString("CodigoTelefono_cliente");
                String DPI_cliente = rs.getString("DPI_cliente");
                

                registocliente = new Clientes();
                registocliente.setPK_id_cliente(PK_id_cliente);
                registocliente.setNombre_cliente(nombre_cliente);
                registocliente.setApellido_cliente(apellido_cliente);
                registocliente.setEdad_cliente(edad_cliente);
                registocliente.setCodigoCorreo_cliente(CodigoCorreo_cliente);
                registocliente.setCodigoDireccion_cliente(CodigoDireccion_cliente);
                registocliente.setCodigoTelefono_cliente(CodigoTelefono_cliente);
                registocliente.setDPI_cliente(DPI_cliente);
                registoclientes.add(registocliente);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return registoclientes;
    }

    public int insert(Clientes clientes) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);

            stmt.setInt(1, clientes.getPK_id_cliente());
            stmt.setString(2, clientes.getNombre_cliente());
            stmt.setString(3, clientes.getApellido_cliente());
            stmt.setString(4, clientes.getEdad_cliente());
            stmt.setString(5, clientes.getCodigoCorreo_cliente());
            stmt.setString(6, clientes.getCodigoDireccion_cliente());
            stmt.setString(7, clientes.getCodigoTelefono_cliente());
            stmt.setString(8, clientes.getDPI_cliente());
            

            //System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            //System.out.println("Registros afectados:" + rows);
            JOptionPane.showMessageDialog(null, "Registro Exitoso");
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public Clientes query(Clientes cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Clientes> registroarticulos = new ArrayList<Clientes>();
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, cliente.getPK_id_cliente());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int PK_id_cliente = rs.getInt("PK_id_cliente");
                String nombre_cliente = rs.getString("nombre_cliente");
                String apellido_cliente = rs.getString("apellido_cliente");
                String edad_cliente = rs.getString("edad_cliente");
                String CodigoCorreo_cliente = rs.getString("CodigoCorreo_cliente");
                String CodigoDireccion_cliente = rs.getString("CodigoDireccion_cliente");
                String CodigoTelefono_cliente = rs.getString("CodigoTelefono_cliente");
                String DPI_cliente = rs.getString("DPI_cliente");
               

                cliente = new Clientes();
                cliente.setNombre_cliente(nombre_cliente);
                cliente.setApellido_cliente(apellido_cliente);
                cliente.setEdad_cliente(edad_cliente);
                cliente.setCodigoCorreo_cliente(CodigoCorreo_cliente);
                cliente.setCodigoDireccion_cliente(CodigoDireccion_cliente);
                cliente.setCodigoTelefono_cliente(CodigoTelefono_cliente);
                cliente.setDPI_cliente(DPI_cliente);
               

                //empleados.add(empleado); // Si se utiliza un ArrayList
            }
            //System.out.println("Registros buscado:" + empleado);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
//            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        //return empleados;  // Si se utiliza un ArrayList
        return cliente;
    }

    public int delete(Clientes cliente) {

        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            //System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, cliente.getPK_id_cliente());
            rows = stmt.executeUpdate();
            //System.out.println("Registros eliminados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int update(Clientes cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);

            stmt.setString(1, cliente.getNombre_cliente());
            stmt.setString(2, cliente.getApellido_cliente());
            stmt.setString(3, cliente.getEdad_cliente());
            stmt.setString(4, cliente.getCodigoCorreo_cliente());
            stmt.setString(5, cliente.getCodigoDireccion_cliente());
            stmt.setString(6, cliente.getCodigoTelefono_cliente());
            stmt.setString(7, cliente.getDPI_cliente());
            

            rows = stmt.executeUpdate();
            System.out.println("Registros actualizado:" + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }
    
    
    
    
    
}
