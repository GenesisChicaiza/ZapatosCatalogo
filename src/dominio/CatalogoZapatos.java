package dominio;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class CatalogoZapatos implements Serializable {
    /**
    @author Genesis
    *arryalist de productos
    */
    private ArrayList<Producto> productos = new ArrayList<>();

    public void agregarProducto(Producto producto) { //void para que no devuelva nada
        productos.add(producto);
    }

    /**
     * @param n: nombre del producto a eliminar
     * Eliminando productos
     */

     public void eliminarProducto(String n) {   
        Producto p = new Producto(n);
        int posicion = productos.indexOf(p); //devuelve posicion 
        if(posicion == -1){
            System.out.println("Nombre de Modelo de Zapato no se encuentra");
        }else{
            
            productos.remove(posicion);
            System.out.println("Zapato borrado");
            System.out.println("pulse <ENTER> para continuar");
   
        }
    }

/**
 * muestra el catalogo por pantalla
 */

    public void mostrarCatalogo() {
        for (Producto producto : productos) {
            System.out.println(producto);
        }
    }
/**
 * graba el catalogo en un archivo
 * @param nombreArchivo: nombre del archivo donde se guarda los datos. 
 */
    public void escribirEnArchivo(String nombreArchivo) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {
            oos.writeObject(productos);
            System.out.println("Catálogo guardado en " + nombreArchivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

   /**
    * lee el catalogo de un archivo
    * @param nombreArchivo: nombre de donde se lee el archivo
    */
    public void leerDesdeArchivo(String nombreArchivo) {
        try (ObjectInputStream n = new ObjectInputStream(new FileInputStream(nombreArchivo))) {
            productos = (ArrayList<Producto>) n.readObject();
            System.out.println("Catálogo cargado desde " + nombreArchivo);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
 
}
