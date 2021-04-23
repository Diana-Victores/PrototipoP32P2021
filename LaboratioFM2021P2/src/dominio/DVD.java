/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

/**
 *
 * @author PERSONAL
 */
public class DVD {

    int PK_id_registrovideo;
    String nombre_registro;
    String Codigo_registro;
    String Clasificacion;
    String Valor_registro;

    public int getPK_id_registrovideo() {
        return PK_id_registrovideo;
    }

    public String getNombre_registro() {
        return nombre_registro;
    }

    public String getCodigo_registro() {
        return Codigo_registro;
    }

    public String getClasificacion() {
        return Clasificacion;
    }

    public String getValor_registro() {
        return Valor_registro;
    }

    public void setPK_id_registrovideo(int PK_id_registrovideo) {
        this.PK_id_registrovideo = PK_id_registrovideo;
    }

    public void setNombre_registro(String nombre_registro) {
        this.nombre_registro = nombre_registro;
    }

    public void setCodigo_registro(String Codigo_registro) {
        this.Codigo_registro = Codigo_registro;
    }

    public void setClasificacion(String Clasificacion) {
        this.Clasificacion = Clasificacion;
    }

    public void setValor_registro(String Valor_registro) {
        this.Valor_registro = Valor_registro;
    }

   

 
  @Override
    public String toString() {
        return "Renta {" + "PK_id_registrovideo=" + PK_id_registrovideo + 
                ", nombre_registro=" +  nombre_registro + 
                ",Codigo_registro=" + Codigo_registro + 
                ",Clasificacion" + Clasificacion + 
                ",Valor_registro" + Valor_registro + 
                
                 + '}';
    }
    
    

}
