public class Producto {
    private String nombre;
    private double precio;
    private String categoria;

    public Producto(String nombre, double precio, String categoria) {
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
    }

    public String obtenerDescripcion() {
        return nombre + " (" + categoria + ") - $" + precio;
    }

    public double getPrecio() { return precio; }
}
