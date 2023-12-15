package dominio;

import java.io.Serializable;


    /**
     * Clase que representa un producto (zapato) serializable
     * @author Genesis Chicaiza
     */
public class Producto implements Serializable {
    private String marca;
    private String modelo;
    private double talla;
    private double precio;

    /**
     * constructor de la clase Producto
     * @param marca: la marca
     * @param modelo: el modelo 
     * @param talla: la talla
     * @param precio: el precio
     * construye un zapato con los parametros dados
     */
    public Producto(String marca, String modelo, double talla, double precio) {
        this.marca = marca;
        this.modelo = modelo;
        this.talla = talla;
        this.precio = precio;

    }
    /**
     * Constructor alternativo de la clase Producto
     * @param n: modelo del producto (zapato)
     */
    public Producto(String n){
        modelo = n;
    }

    /**
     * getter de Marca
     * @return la marca del objeto (zapato)
     * retorna la marca del zapato
     */
    public String getMarca() {  
        return marca;
    }

    /**
     * getter de talla
     * @return la talla del producto (zapato)
     * retorna la talla de producto(zapato)
     */

    public double getTalla() {
        return talla;
    }

    /**
     * getter de Modelo
     * @return el modelo del producto(zapato)
     * obtiene el modelo del producto(zapato)
     */ 
    public String getModelo(){
        return modelo;
    }

    /**
     * getter de Precio
     * @return el precio del producto(zapato)
     * obtiene el precio del producto(zapato)
     */
    public double getPrecio() {
        return precio;
    }

    
/**
 * equals
 *  @param obj: El objeto a comparar con este Producto.
 * @return true si los modelos de los zapatos son iguales, false en caso contrario.
 * Compara este objeto Producto con otro objeto para determinar si son iguales.
 */
    public boolean equals(Object obj){   
        Producto p = (Producto) obj;
        return this.modelo.equals(p.modelo);
    
    }

    /**
     * to String
     * @return metodo toString
     * Devuelve una representación en formato de cadena de este objeto Producto.
     */
    @Override
    public String toString() {
        return "Marca: " + marca + ", Modelo: " + modelo + ", Talla: " + talla + ", Precio: $" + precio;
    }
}





