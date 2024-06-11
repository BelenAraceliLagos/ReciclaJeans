package recicla.jeans;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ArchivoServicio {
    private ProductoServicio nuevoProducto;

    public ArchivoServicio() {
    }

    public ArchivoServicio(ProductoServicio productoServicio) {
        this.nuevoProducto = productoServicio;
    }


    public void cargarDatos(String rutaArchivo) {
        String linea;
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                Producto producto = new Producto(datos[0], datos[1], datos[2], datos[3], datos[4], datos[5], datos[6]);
                nuevoProducto.agregarProducto(producto);
            }
            System.out.println("Los datos se cargaron correctamente\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
