package objetos;

public class Producto {
    private String nombreProducto;
    private String descripcionProducto;
    private double precioProducto;
    private int cantidadProducto;

    public Producto(String nombreProducto, String descripcionProducto, double precioProducto, int cantidadProducto){
        this.nombreProducto = nombreProducto;
        this.descripcionProducto = descripcionProducto;
        this.precioProducto = precioProducto;
        this.cantidadProducto = cantidadProducto;
    }

    public String getNombre(){
        return nombreProducto;
    }

    public void setNombre(String nombre){
        nombreProducto = nombre;
    }

    public String getDescripcion(){
        return descripcionProducto;
    }

    public void setDescripcion(String descripcion){
        descripcionProducto = descripcion;
    }

    public double getPrecio(){
        return precioProducto;
    }

    public void setPrecio(double precio){
        precioProducto = precio;
    }

    public int getCantidad(){
        return cantidadProducto;
    }

    public void setCantidad(int cantidad){
        cantidadProducto = cantidad;
    }
    
}