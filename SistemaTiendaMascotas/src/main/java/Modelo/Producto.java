
package Modelo;

import java.text.DecimalFormat;

public class Producto{
    private String nombP;
    private String code; //P0000
    private int stock;
    private double precioU;
    private String marca;
    private String animal;//tipo de animal

    public Producto() {
    }
    
    
    /**
     * @return the nombP
     */
    public String getNombP() {
        return nombP;
    }

    /**
     * @param nombP the nombP to set
     */
    public void setNombP(String nombP) {
        this.nombP = nombP;
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

    /**
     * @return the stock
     */
    public int getStock() {
        return stock;
    }

    /**
     * @param stock the stock to set
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * @return the precioU
     */
    public double getPrecioU() {
        return precioU;
    }

    /**
     * @param precioU the precioU to set
     */
    public void setPrecioU(double precioU) {
        this.precioU = precioU;
    }

    /**
     * @return the marca
     */
    public String getMarca() {
        return marca;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * @return the animal
     */
    public String getAnimal() {
        return animal;
    }

    /**
     * @param animal the animal to set
     */
    public void setAnimal(String animal) {
        this.animal = animal;
    }
    
}
