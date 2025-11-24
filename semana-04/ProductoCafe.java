public class ProductoCafe {
    protected String nombre;
    protected double precio;
    protected String tamano;

    public ProductoCafe(String nombre, double precio, String tamano) {
        this.nombre = nombre;
        this.precio = precio;
        this.tamano = tamano;
    }

    public void mostrarInfo() {
        System.out.println("Producto: " + nombre);
        System.out.println("Tamaño: " + tamano);
        System.out.println("Precio: $" + precio);
    }

    public double calcularPrecioFinal() {
        return precio;
    }
}
