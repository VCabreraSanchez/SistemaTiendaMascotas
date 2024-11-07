
package Modelo;
import java.util.Date;
public class Detalle extends Producto{
    private String facnum;
    private int cantidad;
    private String fecha;

    public Detalle() {
    }

    public Detalle(int cantidad, String fecha) {
        this.cantidad = cantidad;
        this.fecha = fecha;
    }
    
    
    public double precio(){
        return cantidad*super.getPrecioU();
    }
    
    /**
     * @return the cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the facnum
     */
    public String getFacnum() {
        return facnum;
    }

    /**
     * @param facnum the facnum to set
     */
    public void setFacnum(String facnum) {
        this.facnum = facnum;
    }
    
}
