package datos;

import dominio.DVD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author PERSONAL
 */
public class DVDDAO {

//    private static final String SQL_SELECT = "SELECT  PK_id_registrovideo, nombre_registro, Codigo_registro, Clasificacion, Valor_registro FROM tbl_registro_productovideos";
//    private static final String SQL_INSERT = "INSERT INTO tbl_registro_productovideos (PK_id_registrovideo, nombre_registro, Codigo_registro, Clasificacion, Valor_registro) VALUES(?, ?, ?, ?, ?)";
//    //   private static final String SQL_UPDATE = "UPDATE tbl_articulos SET fecha_ingreso=?, nombre_articulo=?, talla_articuloXS=?, talla_articuloS=?, talla_articuloM=?, talla_articuloL=?, talla_articuloXL=?,  color_articulo=?, nombre_proveedor=?, existencia_articulo=?  WHERE PK_id_articulo = ?";
//    private static final String SQL_UPDATE = "UPDATE tbl_registro_productovideos SET nombre_registro=?, Codigo_registro=?, Clasificacion=?, Valor_registro=?  WHERE PK_id_registrovideo=?";
//    private static final String SQL_DELETE = "DELETE FROM  tbl_registro_productovideos WHERE PK_id_registrovideo=?";
//    private static final String SQL_QUERY = "SELECT PK_id_registrovideo, nombre_registro, Codigo_registro, Clasificacion, Valor_registro FROM tbl_registro_productovideos WHERE PK_id_registrovideo = ?";
    //*************************************************************
    private static final String SQL_SELECT = "SELECT PK_id_registrovideo, nombre_registro, Codigo_registro, Clasificacion, Valor_registro FROM tbl_registro_productovideos";
    private static final String SQL_INSERT = "INSERT INTO tbl_registro_productovideos (PK_id_registrovideo, nombre_registro, apellido_cliente, Codigo_registro, Clasificacion, Valor_registro) VALUES(?, ?, ?, ?, ?)";
    //   private static final String SQL_UPDATE = "UPDATE tbl_articulos SET fecha_ingreso=?, nombre_articulo=?, talla_articuloXS=?, talla_articuloS=?, talla_articuloM=?, talla_articuloL=?, talla_articuloXL=?,  color_articulo=?, nombre_proveedor=?, existencia_articulo=?  WHERE PK_id_articulo = ?";
    private static final String SQL_UPDATE = "UPDATE tbl_registro_productovideos SET nombre_registro=?, Codigo_registro=?, Clasificacion=?, Valor_registro=? WHERE PK_id_registrovideo=?";
    private static final String SQL_DELETE = "DELETE FROM tbl_registro_productovideos WHERE PK_id_registrovideo=?";
    private static final String SQL_QUERY = "SELECT PK_id_registrovideo, nombre_registro, Codigo_registro, Clasificacion, Valor_registro FROM tbl_cliente WHERE PK_id_registrovideo = ?";

    public List<DVD> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        DVD registodvd = null;
        List<DVD> registodvds = new ArrayList<DVD>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {

                int PK_id_registrovideo = rs.getInt("PK_id_registrovideo");
                String nombre_registro = rs.getString("nombre_registro");
                String Codigo_registro = rs.getString("Codigo_registro");
                String Clasificacion = rs.getString("Clasificacion");
                String Valor_registro = rs.getString("Valor_registro");

                registodvd = new DVD();
                registodvd.setPK_id_registrovideo(PK_id_registrovideo);
                registodvd.setNombre_registro(nombre_registro);
                registodvd.setCodigo_registro(Codigo_registro);
                registodvd.setClasificacion(Clasificacion);
                registodvd.setValor_registro(Valor_registro);

            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return registodvds;
    }

    public int insert(DVD videos) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);

            stmt.setInt(1, videos.getPK_id_registrovideo());
            stmt.setString(2, videos.getNombre_registro());
            stmt.setString(3, videos.getCodigo_registro());
            stmt.setString(4, videos.getClasificacion());
            stmt.setString(5, videos.getValor_registro());

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

    public DVD query(DVD dvd) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<DVD> registrodvds = new ArrayList<DVD>();
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, dvd.getPK_id_registrovideo());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int PK_id_registrovideo = rs.getInt("PK_id_registrovideo");
                String nombre_registro = rs.getString("nombre_registro");
                String Codigo_registro = rs.getString("Codigo_registro");
                String Clasificacion = rs.getString("Clasificacion");
                String Valor_registro = rs.getString("Valor_registro");

                dvd = new DVD();
                dvd.setNombre_registro(nombre_registro);
                dvd.setCodigo_registro(Codigo_registro);
                dvd.setClasificacion(Clasificacion);
                dvd.setValor_registro(Valor_registro);

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
        return dvd;
    }

    public int delete(DVD dvd) {

        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            //System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, dvd.getPK_id_registrovideo());
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

    public int update(DVD dvd) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);

            stmt.setString(1, dvd.getNombre_registro());
            stmt.setString(2, dvd.getCodigo_registro());
            stmt.setString(3, dvd.getClasificacion());
            stmt.setString(4, dvd.getValor_registro());

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
