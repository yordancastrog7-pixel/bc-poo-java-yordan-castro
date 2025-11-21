public class Producto {
    private String nombre;
    private double precio;

    // Constructor completo
    public Producto(String nombre, double precio) {
        setNombre(nombre);
        setPrecio(precio);
    }

    // Constructor alterno
    public Producto(String nombre) {
        this(nombre, 5000);
    }

    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("Nombre inválido");
        }
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        if (precio <= 0) throw new IllegalArgumentException("Precio inválido");
        this.precio = precio;
    }
}
