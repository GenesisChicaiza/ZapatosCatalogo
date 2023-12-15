package dominio;

public class ZapatoElegante extends Producto {
    private String estilo;
/*
 * extiende la clase Producto, y añade al constructor
 */
    public ZapatoElegante(String marca, String modelo, double talla, double precio, String estilo) {
        super(marca, modelo, talla, precio);
        this.estilo = estilo;
    }

    /*
     * declaro los getters del constructor
     */
    public String getEstilo() {
        return estilo;
    }


    @Override
    public String toString() {
        return super.toString() + ", Estilo: " + estilo;
    }
}










