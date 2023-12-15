package dominio;

import java.io.Serializable;

/**
     * Clase que representa una sandalia, extendiendo la funcionalidad de la clase Producto.
     * @author Genesis Chicaiza
     * tiene un atributo adicional(tieneTacon)
     */

public class Sandalia extends Producto {
    private boolean tieneTacon;
  /**
 * Constructor de la clase Sandalia. 
 * @param marca: marca 
 * @param modelo: modelo
 * @param talla: talla
 * @param precio: precio
 * @param tieneTacon: tieneTacon
 * Permite crear un objeto Sandalia especificando la marca, modelo, talla, precio y si tiene tacon.
 */

    public Sandalia(String marca, String modelo, double talla, double precio, boolean tieneTacon) {
        super(marca, modelo, talla, precio);
        this.tieneTacon = tieneTacon;
    }

    /**
 * Verifica si la sandalia tiene tacon.
 * @return tieneTacon
 * true si la sandalia tiene tacon, false en caso contrario
 */

    public boolean tieneTacon() {
        return tieneTacon;
    }

    /**
     * to String
     * @return metodo toString
     * Devuelve una representación en formato de cadena de este objeto Sandalia.
     */
    @Override
    public String toString() {
        return super.toString() + ", Tiene Tacon: " + (tieneTacon ? "Sí" : "No");
    }
}
