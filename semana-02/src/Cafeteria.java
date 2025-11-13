import java.util.ArrayList;

public class Cafeteria {
    private String nombre;
    private ArrayList<Pedido> pedidos;

    public Cafeteria(String nombre) {
        this.nombre = nombre;
        this.pedidos = new ArrayList<>();
    }

    public void agregarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public void mostrarPedidos() {
        System.out.println("Pedidos en " + nombre + ":");
        for (Pedido pedido : pedidos) {
            pedido.mostrarResumen();
        }
    }

    public int contarPedidos() {
        return pedidos.size();
    }
}

