package gui;
import java.util.Scanner;
import java.util.Arrays;
import java.util.List;

import objetos.Producto;

public class Ui {
    private Scanner scanner;
    public int flag;

    public Ui(){
        this.scanner = new Scanner(System.in);
        flag = 0;
    }

    public int recibirOpcion(){
        int opcion = Integer.parseInt(scanner.nextLine());
        System.out.println("\n");
        return opcion;
    }

    public void interfazInicio(int flag) {
        if (flag == 0 && this.flag ==0){
            System.out.println("Bienvenido!");
            this.flag = 1;
        }
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("Por favor indique la operación que desea realizar: \n1. Agregar un nuevo producto.");
        if (flag != 0){
            System.out.println("2. Eliminar un producto.\n3. Modificar un producto.\n4. Visualizar lista de productos.");
        }
        System.out.println("0. Salir.");
        System.out.println("----------------------------------------------------------------------------------");
    }

    public List<Object> interfazAgregarProducto(){
        System.out.println("Ingrese el nombre del producto: ");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese la descripción del producto: ");
        String descripcion = scanner.nextLine();
        System.out.println("Ingrese el precio del producto: ");
        double precio = Double.parseDouble(scanner.nextLine());
        System.out.println("Ingrese la cantidad del producto: ");
        int cantidad = Integer.parseInt(scanner.nextLine()); 
        return Arrays.asList(nombre, descripcion, precio, cantidad);
    }

    public List<Object> interfazModificarAtributo(){
        Object nuevoDato = null;
        int numeroAtributo = 0;
        while (nuevoDato == null){
            System.out.println("\n--------------------------------------\n¿Qué atributo desea modificar?\n1. Nombre.\n2. Descripción.\n3. Precio.\n4. Cantidad.\n0. Cancelar.");
            numeroAtributo = Integer.parseInt(scanner.nextLine());
            switch (numeroAtributo){
                case 0:
                    System.out.println("Modificación cancelada.");
                    nuevoDato = true;
                break;
                case 1:
                    System.out.println("Ingrese el nuevo nombre para el producto:");
                    nuevoDato = scanner.nextLine();
                break;
                case 2:
                    System.out.println("Ingrese la nueva descripción para el producto:");
                    nuevoDato = scanner.nextLine();
                break;
                case 3:
                    System.out.println("Ingrese el nuevo precio para el producto:");
                    nuevoDato = Double.parseDouble(scanner.nextLine());
                break;
                case 4:
                System.out.println("Ingrese la nueva cantidad para el producto:");
                    nuevoDato = Integer.parseInt(scanner.nextLine());
                break;
                default:
                System.out.println("Atributo inválido.");
                break;
            }
        }
        return Arrays.asList(numeroAtributo, nuevoDato);
    }

    public int interfazModificarProducto(int cantidadProductos){
        int numeroItem = 0;
        while (numeroItem == 0){
            System.out.println("Digite el número del producto que desea modificar o digite '0' para salir:");
            numeroItem = Integer.parseInt(scanner.nextLine());
            if ((numeroItem <= cantidadProductos) && (numeroItem > 0)){
                System.out.println("Producto #" + numeroItem + " seleccionado.");
            }
            else if (numeroItem == 0) {
                System.out.println("Ha elegido salir.");
                break;
            }
            else {
                System.out.println("Ese número de producto no existe");
                numeroItem = 0;
            }
        }
        return numeroItem;
        
    }

    public int interfazEliminarProducto(int cantidadProductos){
        int numeroItem = 0;
        while (numeroItem == 0){
            System.out.println("Digite el número del producto que desea eliminar o digite '0' para salir:");
            numeroItem = Integer.parseInt(scanner.nextLine());
            if ((numeroItem <= cantidadProductos) && (numeroItem > 0)){
                System.out.println("Producto #" + numeroItem + " seleccionado.\nEstá seguro de querer continuar con la eliminación?\n1. Sí.\n2. No.");
                int confirmacion = Integer.parseInt(scanner.nextLine());
                if (confirmacion == 1){
                    return numeroItem;
                }
                else {
                    break;
                }
            }
            else if (numeroItem == 0) {
                System.out.println("Ha elegido salir.");
                break;
            }
            else {
                System.out.println("Ese número de producto no existe");
                numeroItem = 0;
            }
        }
        return numeroItem;
    }
    

    public static void interfazMostrarProductos(List<Producto> listaProductos, int cantidadProductos){
        System.out.println("------------ Productos: -- " + cantidadProductos + " ------");
        int contador = 1;
        for (Producto producto : listaProductos) {
            System.out.println("----" + contador + "----");
            System.out.println("Nombre producto: " + producto.getNombre());
            System.out.println("Descripción producto: " + producto.getDescripcion());
            System.out.println("Precio producto: " + producto.getPrecio());
            System.out.println("Cantidad producto: " + producto.getCantidad());
            System.out.println("------------------------------------------\n");
            contador++;
        }
    }

    public void cerrarScanner(){
        scanner.close();
    }
}