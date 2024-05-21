package lista;
import objetos.Producto;
import java.util.List;
import java.util.ArrayList;

public class Lista {
    private int cantidadProductos;
    private int valorTotal;
    private List<Producto> listaProductos;

    public Lista(){
        listaProductos = new ArrayList<>();
    }

    public void agregarProducto(String nombre, String descripcion, double precio, int cantidad){
        Producto producto = new Producto(nombre, descripcion, precio, cantidad);
        listaProductos.add(producto);
        actualizarCantidad();
    }

    public void eliminarProducto(int numeroProducto){
        listaProductos.remove(numeroProducto-1);
        actualizarCantidad();
    }

    public void modificarProducto(int numeroProducto, Object atributo, Object dato){
        int entero = (int) atributo;
        Producto productoModificar = listaProductos.get(numeroProducto-1);
        switch (entero) {
            case 1:
            String nuevoNombre = (String) dato;
            productoModificar.setNombre(nuevoNombre);
            break;
    
            case 2:
            String nuevaDescripcion = (String) dato;
            productoModificar.setDescripcion(nuevaDescripcion);
            break;

            case 3:
            double nuevoPrecio = (double) dato;
            productoModificar.setPrecio(nuevoPrecio);
            break;

            case 4:
            int nuevaCantidad = (int) dato;
            productoModificar.setCantidad(nuevaCantidad);
            break;
        }
        try{
            listaProductos.set(numeroProducto-1, productoModificar);
        }
        catch (Exception e){
            System.out.println("Error: " + e);
        }
        finally{
            System.out.println("Producto modificado con éxito.");
        }
    }

    public int getValorTotal(){
        return valorTotal;
    }

    public void actualizarCantidad(){
        cantidadProductos = listaProductos.size();
    }

    public int getCantidad(){
        return cantidadProductos;
    } 

    public List<Producto> getLista(){
        return listaProductos;
    }
}
