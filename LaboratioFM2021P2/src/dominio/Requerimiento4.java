/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

/**
 *
 * @author SIPAQUE.RITA
 */
public class Requerimiento4 {
    
    private int ID;
   private String Nombre; 
   private String Apellido;
   private String DPI;
   private String Tipo;
   private String Genero;
   private String FechaAlquiler; 
   private String FechaCaducidad; 
   private String FechaTarde;
   private String ImporteCargo;
   private String total; 

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getDPI() {
        return DPI;
    }

    public void setDPI(String DPI) {
        this.DPI = DPI;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String Genero) {
        this.Genero = Genero;
    }

    public String getFechaAlquiler() {
        return FechaAlquiler;
    }

    public void setFechaAlquiler(String FechaAlquiler) {
        this.FechaAlquiler = FechaAlquiler;
    }

    public String getFechaCaducidad() {
        return FechaCaducidad;
    }

    public void setFechaCaducidad(String FechaCaducidad) {
        this.FechaCaducidad = FechaCaducidad;
    }

    public String getFechaTarde() {
        return FechaTarde;
    }

    public void setFechaTarde(String FechaTarde) {
        this.FechaTarde = FechaTarde;
    }

    public String getImporteCargo() {
        return ImporteCargo;
    }

    public void setImporteCargo(String ImporteCargo) {
        this.ImporteCargo = ImporteCargo;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Requerimiento4{" + "ID=" + ID + ", Nombre=" + Nombre + ", Apellido=" + Apellido + ", DPI=" + DPI + ", Tipo=" + Tipo + ", Genero=" + Genero + ", FechaAlquiler=" + FechaAlquiler + ", FechaCaducidad=" + FechaCaducidad + ", FechaTarde=" + FechaTarde + ", ImporteCargo=" + ImporteCargo + ", total=" + total + '}';
    }

    public Requerimiento4 query(Requerimiento4 proveedorAConsultar) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }




 
 
    
}
