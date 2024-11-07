
package Modelo;
import java.text.DecimalFormat;

public class Cliente {
    private String nomb;
    private int dni;
    private String contra;
    private String code;

    public Cliente() {
    }
    
    public Cliente(String nomb, int dni, String contra, String code) {
        this.nomb = nomb;
        this.dni = dni;
        this.contra = contra;
        this.code = code;
    }


    
    /**
     * @return the nomb
     */
    public String getNomb() {
        return nomb;
    }

    /**
     * @param nomb the nomb to set
     */
    public void setNomb(String nomb) {
        this.nomb = nomb;
    }

    /**
     * @return the dni
     */
    public int getDni() {
        return dni;
    }

    /**
     * @param dni the dni to set
     */
    public void setDni(int dni) {
        this.dni = dni;
    }

    /**
     * @return the contra
     */
    public String getContra() {
        return contra;
    }

    /**
     * @param contra the contra to set
     */
    public void setContra(String contra) {
        this.contra = contra;
    }

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    
    
    
    
}
