
package Modelo;

import java.text.DecimalFormat;

public class Empleado{
    private String nombE;
    private int dni;
    private String contr;
    private String code;

    public Empleado() {
    }

    public Empleado(String nombE, int dni, String contr, String code) {
        this.nombE = nombE;
        this.dni = dni;
        this.contr = contr;
        this.code = code;
    }
    
    /**
     * @return the nombE
     */
    public String getNombE() {
        return nombE;
    }

    /**
     * @param nombE the nombE to set
     */
    public void setNombE(String nombE) {
        this.nombE = nombE;
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
     * @return the contr
     */
    public String getContr() {
        return contr;
    }

    /**
     * @param contr the contr to set
     */
    public void setContr(String contr) {
        this.contr = contr;
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
