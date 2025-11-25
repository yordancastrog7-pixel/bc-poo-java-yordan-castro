import java.util.ArrayList;

public class InventarioCafeteria {

    private ArrayList<Producto> productos;

    public InventarioCafeteria() {
        productos = new ArrayList<>();
    }

    // --- SOBRECARGA ---
    // Agregar un producto
    public void agregarProducto(Producto p) {
        productos.add(p);
    }

    // Agregar varios productos
    public void agregarProducto(Producto p1, Producto p2) {
        productos.add(p1);
        productos.add(p2);
    }

    // --- POLIMORFISMO DINÁMICO ---
    public void mostrarInventario() {
        for (Producto p : productos) {
            p.mostrarInfo();
            System.out.println("Precio final: $" + p.calcularPrecio());
            System.out.println("----------------------");
        }
    }
}
