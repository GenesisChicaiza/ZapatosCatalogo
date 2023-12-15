package dominio;

public class ZapatoDeportivo extends Producto {
    private String tipoDeporte;
/*
 * extiende la clase Producto, y añade al constructor
 */
    public ZapatoDeportivo(String marca, String modelo, double talla, double precio, String tipoDeporte) {
        super(marca, modelo, talla, precio);
        this.tipoDeporte = tipoDeporte;
    }

    public String getTipoDeporte() {
        return tipoDeporte;
    }
    /*
     * metodo toString
     */

    @Override
    public String toString() {
        return super.toString() + ", Tipo de Deporte: " + tipoDeporte;
    }
}
