/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

/**
 *
 * @author Diana
 */
public class Clientes {
    int PK_id_cliente;
    String nombre_cliente;
    String apellido_cliente;
    String edad_cliente;
    String CodigoCorreo_cliente;
    String CodigoDireccion_cliente;
    String CodigoTelefono_cliente;
    String DPI_cliente;

    public int getPK_id_cliente() {
        return PK_id_cliente;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public String getApellido_cliente() {
        return apellido_cliente;
    }

    public String getEdad_cliente() {
        return edad_cliente;
    }

    public String getCodigoCorreo_cliente() {
        return CodigoCorreo_cliente;
    }

    public String getCodigoDireccion_cliente() {
        return CodigoDireccion_cliente;
    }

    public String getCodigoTelefono_cliente() {
        return CodigoTelefono_cliente;
    }

    public String getDPI_cliente() {
        return DPI_cliente;
    }

    public void setPK_id_cliente(int PK_id_cliente) {
        this.PK_id_cliente = PK_id_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public void setApellido_cliente(String apellido_cliente) {
        this.apellido_cliente = apellido_cliente;
    }

    public void setEdad_cliente(String edad_cliente) {
        this.edad_cliente = edad_cliente;
    }

    public void setCodigoCorreo_cliente(String CodigoCorreo_cliente) {
        this.CodigoCorreo_cliente = CodigoCorreo_cliente;
    }

    public void setCodigoDireccion_cliente(String CodigoDireccion_cliente) {
        this.CodigoDireccion_cliente = CodigoDireccion_cliente;
    }

    public void setCodigoTelefono_cliente(String CodigoTelefono_cliente) {
        this.CodigoTelefono_cliente = CodigoTelefono_cliente;
    }

    public void setDPI_cliente(String DPI_cliente) {
        this.DPI_cliente = DPI_cliente;
    }
    
       @Override
    public String toString() {
        return "Cliente {" + "PK_id_cliente=" + PK_id_cliente + 
                ", nombre_cliente=" +  nombre_cliente + 
                ",apellido_cliente=" + apellido_cliente + 
                ",edad_cliente" + edad_cliente + 
                ",CodigoCorreo_cliente" + CodigoCorreo_cliente + 
                ",CodigoDireccion_cliente"  + CodigoDireccion_cliente + 
                ", CodigoTelefono_cliente" + CodigoTelefono_cliente+ 
                ",DPI_cliente="  + DPI_cliente +
                 + '}';
    }
            
            
}
