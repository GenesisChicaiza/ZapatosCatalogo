package presentacion;

import dominio.CatalogoZapatos;
import dominio.Sandalia;
import dominio.ZapatoDeportivo;
import dominio.ZapatoElegante;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.InputMismatchException;
import java.util.Scanner;


/**
 * @author Genesis Chicaiza
 * sirve como punto de entrada y coordinacion para la interaccion del usuario.
 */
public class Interfaz {
    private CatalogoZapatos catalogo;
    private Scanner scanner;

    /**
     * Constructor
     * Inicializa nueva instancia de la interfaz, crea nuevo catalogo de zapatos y scanner para entrada del usuario.
     * Realiza la lectura inicial para configurar la interfaz.
     */
    public Interfaz() {
        catalogo = new CatalogoZapatos();
        scanner = new Scanner(System.in);
        leer();

    }
    
    /**
 * Mostrar un menu y gestionar las opciones seleccionadas por el usuario.
 * Menú incluye opciones para agregar, eliminar, mostrar y gestionar productos en el catalogo.
 * Ofrece funciones para guardar y cargar el catalogo desde un archivo.
 * Finaliza cuando el usuario elige la opción de salir (0).
 */

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
     
    /**
 * Leer catalogo de zapatos desde un archivo.
 * Si el archivo existe, carga el catálogo almacenado; de lo contrario, se maneja la excepcion.
 */
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

    /**
 * Guardar catalogo de zapatos en un archivo.
 * Si el archivo no existe, se crea; de lo contrario, se sobrescribe.
 */

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

    /**
 * Agregar un nuevo producto al catalogo.
 * Solicita detalles como marca, modelo, talla y precio, y luego solicita el tipo especifico de producto.
 * Dependiendo del tipo seleccionado,recopila informacion adicional.
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

    /**
 * Eliminar producto del catalogo por nombre de modelo.
 * Solicita al usuario el nombre del modelo a borrar y realiza la eliminacion correspondiente.
 */

    private void  eliminarProducto(){

        CatalogoZapatos zapatos = new CatalogoZapatos();
        Scanner sc = new Scanner(System.in);
        System.out.print("Nombre del modelo a borrar: ");
        String n = sc.nextLine(); 
        catalogo.eliminarProducto(n);
      
    }

    /**
 * Mostrar catalogo actual de productos
 * Imprime en la consola la lista de productos existentes en el catalogo.
 */
    private void mostrarCatalogo() {
        System.out.println("\nCatálogo actual:");
        catalogo.mostrarCatalogo();
    }

    /**
 * Guardar catalogo en un archivo especificado.
 * Solicita al usuario el nombre del archivo y utiliza el catalogo para escribir los datos en ese archivo.
 */

    private void guardarEnArchivo() {
        System.out.print("\nIngrese el nombre del archivo para guardar el catálogo: ");
        String nombreArchivo = scanner.next();
        catalogo.escribirEnArchivo(nombreArchivo);
    }
   
    /**
 * Cargar catalogo desde un archivo especificado.
 * Solicita al usuario el nombre del archivo y utiliza el catalogo para leer los datos desde ese archivo.
 */
    private void cargarDesdeArchivo() {
        System.out.print("\nIngrese el nombre del archivo para cargar el catálogo: ");
        String nombreArchivo = scanner.next();
        catalogo.leerDesdeArchivo(nombreArchivo);
    }

    /**
 * Obtener valor entero ingresado por usuario
 * @return valor entero ingresado
 * retorna valor entero
 */
    private int obtenerEntero() {
        while (true) {
            try {
                int n= scanner.nextInt();
                scanner.nextLine();
                return n;
            } catch (InputMismatchException e) {
                System.out.println("Por favor, ingrese un valor entero.");
                scanner.nextLine(); 
            }
        }
    }


    /**
 * Asegurar de obtener valor entero
 * @param mensaje: El mensaje a mostrar antes de solicitar la entrada del usuario.
 * Muestra el mensaje proporcionado, solicita al usuario ingresar un valor entero y maneja excepciones de tipo de entrada incorrecta.
 * @return El valor entero ingresado por el usuario.
 * valor
 */
    private int obtenerEntero(String mensaje) {
        System.out.print(mensaje);
        return obtenerEntero();
    }

    /**
 * Asegurar de obtener valor decimal
 * @return El valor decimal ingresado por el usuario.
 * devuelve valor decimal
 */
    private double obtenerDouble() {
        while (true) {
            try {
                return scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Por favor, ingrese un valor numérico válido.");
                scanner.next(); 
            }
        }
    }

    /**
 * Asegurar de obtener valor booleano
 * @return El valor booleano 
 * devuelve valor boleano
 */

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
