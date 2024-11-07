
package Modelo;

public class Cabecera extends Cliente{
    private String Fnum;
    private String fecha;
    private double totalP;

    /**
     * @return the Fnum
     */
    public String getFnum() {
        return Fnum;
    }

    /**
     * @param Fnum the Fnum to set
     */
    public void setFnum(String Fnum) {
        this.Fnum = Fnum;
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
     * @return the totalP
     */
    public double getTotalP() {
        return totalP;
    }

    /**
     * @param totalP the totalP to set
     */
    public void setTotalP(double totalP) {
        this.totalP = totalP;
    }
    
}
