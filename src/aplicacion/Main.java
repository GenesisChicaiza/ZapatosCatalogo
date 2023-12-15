package aplicacion;

import presentacion.Interfaz;


/**
 * Desde la clase Main, el programa se ejecuta
 * @author Genesis 
 */

public class Main {

     /**
     * Punto de entrada principal para la aplicacion.
     * Crea una instancia de la interfaz y llama al método para mostrar el menu interactivo.
     *
     * @param args Argumentos de la linea de comandos (no se utilizan en este caso).
     */
    public static void main(String[] args) {
        Interfaz interfaz = new Interfaz();
        interfaz.mostrarMenu();
    }
}
