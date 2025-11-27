package semana06.abstractas;

public abstract class ProductoAbstract {
    protected String codigo;
    protected String nombre;
    protected double precioBase;

    public ProductoAbstract(String codigo, String nombre, double precioBase) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precioBase = precioBase;
    }

    // Método concreto reutilizable
    public void mostrarInfo() {
        System.out.println("Producto: " + nombre);
        System.out.println("Código: " + codigo);
        System.out.println("Precio base: $" + precioBase);
    }

    // Método abstracto que varía según tipo de producto
    public abstract double calcularPrecioFinal();

    // Otro método concreto opcional (por ejemplo, descripción corta)
    public String obtenerDescripcion() {
        return nombre + " - $" + precioBase;
    }
}
