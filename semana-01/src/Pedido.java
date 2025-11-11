import java.util.HashMap;
import java.util.Map;

public class Pedido {
    private int numero;
    private Persona cliente;
    private Map<Producto, Integer> productos;
    private double total;
    private String estado;
    private Mesa mesa;

    public Pedido(int numero, Persona cliente) {
        this.numero = numero;
        this.cliente = cliente;
        this.productos = new HashMap<>();
        this.total = 0;
        this.estado = "Pendiente";
    }

    public void agregarProducto(Producto producto, int cantidad) {
        productos.put(producto, cantidad);
        total += producto.getPrecio() * cantidad;
        producto.actualizarStock(-cantidad);
    }

    public void asignarMesa(Mesa mesa) {
        this.mesa = mesa;
        mesa.asignar();
    }

    public void cambiarEstado(String nuevoEstado) {
        this.estado = nuevoEstado;
    }

    public void mostrarResumen() {
        System.out.println("Pedido #" + numero + " - Cliente: " + cliente.getNombre());
        System.out.println("Mesa: " + (mesa != null ? mesa.getNumero() : "Sin asignar"));
        System.out.println("Estado: " + estado);
        System.out.println("Productos:");
        for (Map.Entry<Producto, Integer> p : productos.entrySet()) {
            System.out.println("- " + p.getKey().getNombre() + " x" + p.getValue());
        }
        System.out.println("Total: $" + total);
    }
}
