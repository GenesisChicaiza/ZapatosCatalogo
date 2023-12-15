package dominio;


    /**
     * Clase que representa un zapato deportivo, extendiendo la funcionalidad de la clase Producto.
     * @author Genesis Chicaiza
     * tiene un atributo adicional (tipoDeporte)
     */
public class ZapatoDeportivo extends Producto {
    private String tipoDeporte;

 /**
 * Constructor de la clase ZapatoDeportivo. 
 * @param marca: marca 
 * @param modelo:  modelo 
 * @param talla: talla
 * @param precio: precio
 * @param tipoDeporte: tipo de deporte
 * Permite crear un zapato, dependiendo del deporte
 */
    public ZapatoDeportivo(String marca, String modelo, double talla, double precio, String tipoDeporte) {
        super(marca, modelo, talla, precio);
        this.tipoDeporte = tipoDeporte;
    }

    /**
     * getter de tipo de deporte
     * @return tipo de deporte del zapato deportivo
     */
    public String getTipoDeporte() {
        return tipoDeporte;
    }
    /**
     * to String
     * @return metodo toString
     * Devuelve una representacion en formato de cadena de este objeto ZapatoDeportivo.
     */
    @Override
    public String toString() {
        return super.toString() + ", Tipo de Deporte: " + tipoDeporte;
    }
}
