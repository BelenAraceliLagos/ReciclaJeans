package recicla.jeans;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {
        ProductoServicio nuevoProducto = new ProductoServicio(new ArrayList<>());
        ArchivoServicio archivoServicio = new ArchivoServicio(nuevoProducto);
        Scanner sc = new Scanner(System.in);

        Menu menu = new Menu(nuevoProducto, archivoServicio, sc);
        menu.mostrarMenu();
    }

    private ProductoServicio prod;
    private ArchivoServicio archivo;
    private Scanner sca;

    public Menu() {
    }

    public Menu(ProductoServicio prod, ArchivoServicio archivo, Scanner sca) {
        this.prod = prod;
        this.archivo = archivo;
        this.sca = sca;
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("1. Listar Productos");
            System.out.println("2. Editar Datos");
            System.out.println("3. Importar Datos");
            System.out.println("4. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = sca.nextInt();

            switch (opcion) {
                case 1: listarProductos();
                    break;
                case 2: editarDatos();
                    break;
                case 3: importarDatos();
                    break;
                case 4: System.out.println("Ha salido del programa");
                    break;
                default: System.out.println("La opción no es válida.");
            }
        } while (opcion != 4);
    }

    private void listarProductos() {
        prod.listarProductos();
    }

    private void editarDatos() {
        System.out.println("Editar Producto");
        System.out.println("Ingrese el código del producto: ");
        sca.nextLine();
        String codigo = sca.nextLine();
        Producto producto = null;
        for (Object p : prod.getListaProductos()) {
            if (p.toString().equals(codigo)) {
                producto = (Producto) p;
                break;
            }
        }

        if (producto != null) {
            System.out.println("1.-El nombre del articulo actual es: " + producto.getArticulo());
            System.out.println("2.-El código del producto: " + producto.getCodigo());
            System.out.println("3.-El color del producto: " + producto.getColor());
            System.out.println("4.-La descripción del producto: " + producto.getDescripcion());
            System.out.println("5.-La marca del producto: " + producto.getMarca());
            System.out.println("6.-El precio del producto: " + producto.getPrecio());
            System.out.println("7.-La talla del producto: " + producto.getTalla());
            System.out.print("Ingrese la opción a editar de los datos del producto: ");
            int opcion = sca.nextInt();
            sca.nextLine();
            System.out.print("Ingrese el nuevo valor: ");
            String nuevoValor = sca.nextLine();
            prod.editarProductos(codigo, opcion, nuevoValor);
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    private void importarDatos() {
        System.out.println("Cargar datos");
        System.out.println("Ingresa la ruta del archivo que quieres importar: ");
        sca.nextLine();
        String ruta = sca.nextLine();
        archivo.cargarDatos(ruta);
    }
}
