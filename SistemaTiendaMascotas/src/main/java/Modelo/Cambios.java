
package Modelo;

public class Cambios {
    private String cpro;
    private String cemp;
    private String fecha;

    public Cambios() {
    }

    public Cambios(String cpro, String cemp, String fecha) {
        this.cpro = cpro;
        this.cemp = cemp;
        this.fecha = fecha;
    }

    
    /**
     * @return the cpro
     */
    public String getCpro() {
        return cpro;
    }

    /**
     * @param cpro the cpro to set
     */
    public void setCpro(String cpro) {
        this.cpro = cpro;
    }

    /**
     * @return the cemp
     */
    public String getCemp() {
        return cemp;
    }

    /**
     * @param cemp the cemp to set
     */
    public void setCemp(String cemp) {
        this.cemp = cemp;
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
    
    
}
