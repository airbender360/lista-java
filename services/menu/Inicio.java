package menu;
import gui.Ui;
import lista.Lista;
import java.util.List;

public class Inicio {
    private boolean exit = false;

    public void ejecucion(){ // Función de ejecución 
        Ui interfaz = new Ui();
        Lista nuevaLista = new Lista();
        try {
            while (exit == false) {
                interfaz.interfazInicio(nuevaLista.getCantidad());
                int opcion = interfaz.recibirOpcion();
                switch (opcion) {
                    case 1:{
                        List<Object> datosProducto = interfaz.interfazAgregarProducto();
                        String nombre = (String) datosProducto.get(0);
                        String descripcion = (String) datosProducto.get(1);
                        double precio = (double) datosProducto.get(2);
                        int cantidad = (int) datosProducto.get(3);
        
                        try {
                            nuevaLista.agregarProducto(nombre, descripcion, precio, cantidad);
                        }
                        finally {
                            System.out.println("Se ha agregado el producto con éxito.\n\n");
                        }
                        break;
                    }
                    case 2:{
                        if (nuevaLista.getCantidad() != 0){
                            System.out.println("Opcion 3");
                        }
                        else{
                            System.out.println("Opción inválida, por favor agregue un producto.");
                        }
                        break;
                    }
                    case 3:{
                        if (nuevaLista.getCantidad() != 0){
                            boolean edit = true;
                            while (edit == true){
                                Ui.interfazMostrarProductos(nuevaLista.getLista(), nuevaLista.getCantidad());
                                int numeroProducto = interfaz.interfazModificarProducto(nuevaLista.getCantidad());
                                if (numeroProducto == 0){
                                    edit = false;
                                }
                                else {
                                    List<Object> datosModificacion = interfaz.interfazModificarAtributo();
                                    if ((datosModificacion.get(0).equals(0)) && (datosModificacion.get(1) instanceof Boolean)){
                                        edit = false;
                                    }
                                    else {
                                        nuevaLista.modificarProducto(numeroProducto, datosModificacion.get(0), datosModificacion.get(1));
                                    }
                                    
                                }
                            }
                        }
                        else{
                            System.out.println("Opción inválida, por favor agregue un producto.");
                        }
                        break;
                    }
                    case 4:{
                        if (nuevaLista.getCantidad() != 0){
                            Ui.interfazMostrarProductos(nuevaLista.getLista(), nuevaLista.getCantidad());
                        }
                        else{
                            System.out.println("Opción inválida, por favor agregue un producto.");
                        }
                        break;
                    }
                    case 0:{
                        exit = true;
                        System.out.println("Ha elegido Salir.");
                        break;
                    }
                    default:{
                        System.out.println("Opción inválida.");
                    }
                }
            }
        }
        finally{
            interfaz.cerrarScanner();
        }
    }
    public static void main(String[] args) { 
        Inicio inicio = new Inicio(); 
        try {
            if (inicio != null) {
                System.out.println("Iniciando...");
            }
        } catch (Exception e){
            System.out.println("Error: " + e);
        }
        inicio.ejecucion();
    }
}