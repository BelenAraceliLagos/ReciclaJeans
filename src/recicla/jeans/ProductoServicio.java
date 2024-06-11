package recicla.jeans;

import java.util.ArrayList;
import java.util.Iterator;

public class ProductoServicio {

    ArrayList<Object> listaProductos = new ArrayList<>();

    public ProductoServicio(){
    }

    public ProductoServicio(ArrayList listaProductos) {
        this.listaProductos = listaProductos;
    }

    public ArrayList getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(ArrayList listaProductos) {
        this.listaProductos = listaProductos;
    }

    public void listarProductos(){

        Iterator<Object> it = listaProductos.iterator();

        while(it.hasNext()) {
            System.out.println(it.next());
        }
    }

    public void agregarProducto(Producto producto) {
    }

    public void editarProductos(String codigo, int opcion, String nuevoValor) {
    }
}
