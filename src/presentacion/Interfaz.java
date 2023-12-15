package presentacion;

import dominio.CatalogoZapatos;
import dominio.Producto;
import dominio.Sandalia;
import dominio.ZapatoDeportivo;
import dominio.ZapatoElegante;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Interfaz {
    private CatalogoZapatos catalogo;
    private Scanner scanner;

    public Interfaz() {
        catalogo = new CatalogoZapatos();
        scanner = new Scanner(System.in);
        leer();

    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Agregar Producto");
            System.out.println("2. Eliminar Producto");
            System.out.println("3. Mostrar Catálogo");
            System.out.println("4. Guardar Catálogo en Carrito de compra");
            System.out.println("5. Cargar Catálogo desde Carrito de compra");
            System.out.println("0. Salir");
            System.out.print("Ingrese su opción: ");
            opcion = obtenerEntero();

            switch (opcion) {
                case 1:
                    agregarProducto();
                    break;
                case 2:
                    eliminarProducto();
                    break;
                case 3:
                    mostrarCatalogo();
                    break;
                case 4:
                    guardarEnArchivo();
                    break;
                case 5:
                    cargarDesdeArchivo();
                    break;
                case 0:
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    grabar();
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
                    break;
            }
        } while (opcion != 0);
    }
     
    
private void leer(){
        ObjectInputStream obj;
    File file = new File("CatalogoZapatos.txt");
    try{
        obj = new ObjectInputStream(new FileInputStream(file));
        try{catalogo = (CatalogoZapatos)obj.readObject();
        }catch(Exception e){System.out.println(e);}
        obj.close();
        System.out.println("leido");
    } catch(Exception e){
        System.out.println("no leido");
       // Producto = new ArrayList<Producto>();
    }

}
  private void grabar(){

    ObjectOutputStream obj;
                File file = new File("CatalogoZapatos.txt");
                try{
                    obj = new ObjectOutputStream(new FileOutputStream(file));
                    obj.writeObject(catalogo);
                    obj.close();
                    System.out.println("Guardado");
                } catch(Exception e){
                System.out.println("Error al guardar");
                System.out.println(e);
                };

    }

    /*
     * agrega el producto que el usuario ingrese
     */
    private void agregarProducto() {
        System.out.println("\nIngrese los detalles del producto:");
        System.out.print("Marca: ");
        String marca = scanner.nextLine();
        System.out.print("Modelo: ");
        String modelo = scanner.nextLine();
        System.out.print("Talla: ");
        double talla = obtenerDouble();
        System.out.print("Precio: $");
        double precio = obtenerDouble();

        System.out.println("Seleccione el tipo de producto:");
        System.out.println("1. Zapato Deportivo");
        System.out.println("2. Zapato Elegante");
        System.out.println("3. Sandalia");
        int tipoProducto = obtenerEntero("Ingrese su opción: ");
/*
 * aqui pongo lo que tiene que hacer dependiendo del numero que ingrese el usuario
 */
        switch (tipoProducto) {
            case 1:
                System.out.print("Tipo de Deporte: ");
                String tipoDeporte = scanner.next();
                catalogo.agregarProducto(new ZapatoDeportivo(marca, modelo, talla, precio, tipoDeporte));
                break;
            case 2:
                System.out.print("Estilo: ");
                String estilo = scanner.next();
                catalogo.agregarProducto(new ZapatoElegante(marca, modelo, talla, precio, estilo));
                break;
            case 3:
                System.out.print("¿Tiene Tacon? (true/false): ");
                boolean tieneTacon = obtenerBoolean();
                catalogo.agregarProducto(new Sandalia(marca, modelo, talla, precio, tieneTacon));
                break;
            default:
                System.out.println("Opción inválida.");
        }
    }

    /*
     * metodo para eliminar producto que el usuario ha creado 
     */

    private void  eliminarProducto(){

        CatalogoZapatos zapatos = new CatalogoZapatos();
        Scanner sc = new Scanner(System.in);
        System.out.print("Nombre del modelo a borrar: ");
        String n = sc.nextLine(); 
        catalogo.eliminarProducto(n);
      
    }

    /*
     * aqui muestra el catalgo
     */

    private void mostrarCatalogo() {
        System.out.println("\nCatálogo actual:");
        catalogo.mostrarCatalogo();
    }

    /*
     * aqui el usuario lo puede guardar en el carrito de compra si lo desea
     */

    private void guardarEnArchivo() {
        System.out.print("\nIngrese el nombre del archivo para guardar el catálogo: ");
        String nombreArchivo = scanner.next();
        catalogo.escribirEnArchivo(nombreArchivo);
    }
    /*
     * aqui puede ver lo que tiene en el carrito
     */
    private void cargarDesdeArchivo() {
        System.out.print("\nIngrese el nombre del archivo para cargar el catálogo: ");
        String nombreArchivo = scanner.next();
        catalogo.leerDesdeArchivo(nombreArchivo);
    }

    /*
     * asegura que el usuario ingrese un entero
     */
    private int obtenerEntero() {
        while (true) {
            try {
                int n= scanner.nextInt();
                scanner.nextLine();
                return n;
            } catch (InputMismatchException e) {
                System.out.println("Por favor, ingrese un valor entero.");
                scanner.nextLine(); // Limpiar el búfer del scanner.
            }
        }
    }



    private int obtenerEntero(String mensaje) {
        System.out.print(mensaje);
        return obtenerEntero();
    }

    private double obtenerDouble() {
        while (true) {
            try {
                return scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Por favor, ingrese un valor numérico válido.");
                scanner.next(); // Limpiar el búfer del scanner.
            }
        }
    }

    private boolean obtenerBoolean() {
        while (true) {
            System.out.print("Ingrese 'true' o 'false': ");
            String input = scanner.next().trim().toLowerCase();
            if (input.equals("true")) {
                return true;
            }
        }
    }
}
