package dominio;

public class Sandalia extends Producto {
    private boolean tieneTacon;
/*
 * sandalia extends la clase producto. Y añado al constructor
 */
    public Sandalia(String marca, String modelo, double talla, double precio, boolean tieneTacon) {
        super(marca, modelo, talla, precio);
        this.tieneTacon = tieneTacon;
    }

    public boolean tieneTacon() {
        return tieneTacon;
    }

    /*
     * el metodo toString
     */
    @Override
    public String toString() {
        return super.toString() + ", Tiene Tacon: " + (tieneTacon ? "Sí" : "No");
    }
}
