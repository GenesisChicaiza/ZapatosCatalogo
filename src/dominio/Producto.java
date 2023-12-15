package dominio;

import java.io.Serializable;

public class Producto implements Serializable {
    private String marca;
    private String modelo;
    private double talla;
    private double precio;

    public Producto(String marca, String modelo, double talla, double precio) {
        this.marca = marca;
        this.modelo = modelo;
        this.talla = talla;
        this.precio = precio;

    }
    /*
     * creo los getters del constructor
     */
    public Producto(String n){
        modelo = n;
    }

    public String getMarca() {  //si la funcion es de algun tipo necesitamos un return de una variable de ese tipo
        return marca;
    }

    public double getTalla() {
        return talla;
    }

    public String getModelo(){
        return modelo;
    }

    public double getPrecio() {
        return precio;
    }

    
/*
 * este metodo me ayuda para el eliminar producto
 */
    public boolean equals(Object obj){   
        Producto p = (Producto) obj;
        return this.modelo.equals(p.modelo);
    
    }

    /*
     * el metodo toString, muestra la salida
     */
    @Override
    public String toString() {
        return "Marca: " + marca + ", Modelo: " + modelo + ", Talla: " + talla + ", Precio: $" + precio;
    }
}





