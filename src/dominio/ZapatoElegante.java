package dominio;

/**
     * Clase que representa un zapato elegante, que es un tipo especifico de producto (zapato).
     * @author Genesis Chicaiza
     * tiene un atributo adicional (estilo)
     */
public class ZapatoElegante extends Producto {
    private String estilo;
    
/**
 * Constructor de la clase ZapatoElegante
 * @param marca: marca 
 * @param modelo: modelo 
 * @param talla: talla
 * @param precio: precio
 * @param estilo: estilo
 * Permite crear un objeto ZapatoElegante especificando la marca, modelo, talla, precio y el estilo.
 */
    public ZapatoElegante(String marca, String modelo, double talla, double precio, String estilo) {
        super(marca, modelo, talla, precio);
        this.estilo = estilo;
    }
/**
 * getter the estilo
 * @return El estilo del zapato elegante.
 * retorna el estilo
 */
    public String getEstilo() {
        return estilo;
    }

 /**
     * to String
     * @return metodo toString
     * Devuelve una representación en formato de cadena de este objeto ZapatoElegante.
     */

    @Override
    public String toString() {
        return super.toString() + ", Estilo: " + estilo;
    }
}










