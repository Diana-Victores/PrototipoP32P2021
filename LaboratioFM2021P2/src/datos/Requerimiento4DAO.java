/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import dominio.Requerimiento4;
import datos.Conexion;
import datos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author SIPAQUE.RITA
 */
public class Requerimiento4DAO {

    private static final String SQL_SELECT = "SELECT ID, Nombre, Apellido, DPI, Tipo, Genero, FechaAlquiler, FechaCaducidad, FechaTarde, ImporteCargo, Total FROM tbl_tbl_registrosatrasados";
    private static final String SQL_INSERT = "INSERT INTO tbl_Registrosatrasados (ID, Nombre, Apellido, DPI, Tipo, Genero, FechaAlquiler, FechaCaducidad, FechaTarde, ImporteCargo, Total ) VALUES (?,?,?,?,?,?,?,?,?,?,?) ";

// private static final String SQL_UPDATE = "UPDATE tbl_proveedor SET   nombre_proveedor= ?, direccion_proveedor= ?, contacto_proveedor= ?, telefono_proveedor= ?, nit_proveedor= ?,  email_proveedor= ?, estatus_proveedor= ?    WHERE PK_id_proveedor= ?";
    private static final String SQL_UPDATE = "UPDATE tbl_Registrosatrasados SET   Nombre= ?, Apellido= ?, DPI= ?, Tipo= ?, Genero= ?, FechaAlquiler= ?, FechaCaducidad= ?, FechaTarde= ?, ImporteCargo = ?, Total=?     WHERE ID= ?";
    private static final String SQL_QUERY = "SELECT  ID, Nombre, Apellido, DPI, Tipo, Genero, FechaAlquiler, FechaCaducidad, FechaTarde, ImporteCargo, Total WHERE ID= ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_Registrosatrasados WHERE ID=?";

    public List<Requerimiento4> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Requerimiento4 proveedor = null;
        List<Requerimiento4> proveedores = new ArrayList<Requerimiento4>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int ID = rs.getInt("ID");
                String Nombre = rs.getString("Nombre");
                String Apellido = rs.getString("Apellido");
                String DPI = rs.getString("DPI");
                String Tipo = rs.getString("Tipo");
                String genero = rs.getString("Genero");
                String fecha1 = rs.getString("FechaAlquiler");
                String fecha2 = rs.getString("FechaCaducidad");
                String fecha3 = rs.getString("FechaTarde");
                String importe = rs.getString("ImporteCargo");
                String total = rs.getString("Total");

                proveedor = new Requerimiento4();
                proveedor.setID(ID);
                proveedor.setNombre(Nombre);
                proveedor.setApellido(Apellido);
                proveedor.setDPI(DPI);
                proveedor.setTipo(Tipo);
                proveedor.setGenero(genero);
                proveedor.setFechaAlquiler(fecha1);
                proveedor.setFechaCaducidad(fecha2);
                proveedor.setFechaTarde(fecha3);
                proveedor.setImporteCargo(importe);
                proveedor.setTotal(total);
                proveedores.add(proveedor);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return proveedores;
    }

    public int insert(Requerimiento4 aplicacion) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, aplicacion.getID());
            stmt.setString(2, aplicacion.getNombre());
            stmt.setString(3, aplicacion.getApellido());
            stmt.setString(4, aplicacion.getDPI());
            stmt.setString(5, aplicacion.getTipo());
            stmt.setString(6, aplicacion.getGenero());
            stmt.setString(7, aplicacion.getFechaAlquiler());
            stmt.setString(8, aplicacion.getFechaCaducidad());
            stmt.setString(9, aplicacion.getFechaTarde());
            stmt.setString(10, aplicacion.getImporteCargo());
            stmt.setString(11, aplicacion.getTotal());

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

    public Requerimiento4 query(Requerimiento4 proveedor) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Requerimiento4> proveedores = new ArrayList<Requerimiento4>();
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, proveedor.getID());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int ID = rs.getInt("ID");
                String Nombre = rs.getString("Nombre");
                String Apellido = rs.getString("Apellido");
                String DPI = rs.getString("DPI");
                String Tipo = rs.getString("Tipo");
                String genero = rs.getString("Genero");
                String fecha1 = rs.getString("FechaAlquiler");
                String fecha2 = rs.getString("FechaCaducidad");
                String fecha3 = rs.getString("FechaTarde");
                String importe = rs.getString("ImporteCargo");
                String total = rs.getString("Total");

                proveedor = new Requerimiento4();
                proveedor.setID(ID);
                proveedor.setNombre(Nombre);
                proveedor.setApellido(Apellido);
                proveedor.setDPI(DPI);
                proveedor.setTipo(Tipo);
                proveedor.setGenero(genero);
                proveedor.setFechaAlquiler(fecha1);
                proveedor.setFechaCaducidad(fecha2);
                proveedor.setFechaTarde(fecha3);
                proveedor.setImporteCargo(importe);
                proveedor.setTotal(total);
                proveedores.add(proveedor);

                //empleados.add(empleado); // Si se utiliza un ArrayList
            }
            //System.out.println("Registros buscado:" + empleado);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        //return empleados;  // Si se utiliza un ArrayList
        return proveedor;
    }

    public int delete(Requerimiento4 aplicacion) {

        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            //System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, aplicacion.getID());
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

    public int update(Requerimiento4 aplicacion) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);

            stmt.setString(1, aplicacion.getNombre());
            stmt.setString(2, aplicacion.getApellido());
            stmt.setString(3, aplicacion.getDPI());
            stmt.setString(4, aplicacion.getTipo());
            stmt.setString(5, aplicacion.getGenero());
            stmt.setString(6, aplicacion.getFechaAlquiler());
            stmt.setString(7, aplicacion.getFechaCaducidad());
            stmt.setString(8, aplicacion.getFechaTarde());
            stmt.setString(9, aplicacion.getImporteCargo());
            stmt.setString(10, aplicacion.getTotal());

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
