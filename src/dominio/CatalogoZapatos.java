package dominio;
import java.io.*;
import java.util.ArrayList;

/**
 * Clase para representar un catalogo de zapatos serializable.
 * @author Genesis Chicaiza
 */
public class CatalogoZapatos implements Serializable {
    
     /**
     * Lista que almacena los productos (zapatos) en el catalogo.
     */
    private ArrayList<Producto> productos = new ArrayList<>();

     /**
     * Agrega un nuevo producto (zapato) al catalogo.
     * 
     * @param producto: producto se agrega al catalogo
     */

    public void agregarProducto(Producto producto) { 
        productos.add(producto);
    }

    /**
     * Elimina un producto (zapato) del catalogo por su nombre.
     * 
     * @param n: El nombre del modelo de zapato que se va a eliminar.
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
    * @param nombreArchivo: nombre del archivo desde el cual se va a leer el catalogo.
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
