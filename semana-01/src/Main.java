public class Main {
    public static void main(String[] args) {
        // Crear personas
        Persona cliente = new Persona("Laura Gómez", "Cliente");

        // Crear productos
        Producto capuccino = new Producto("Capuccino", 6000, 10);
        Producto torta = new Producto("Torta de chocolate", 8000, 5);

        // Crear mesa
        Mesa mesa1 = new Mesa(1);

        // Crear pedido
        Pedido pedido1 = new Pedido(101, cliente);
        pedido1.agregarProducto(capuccino, 2);
        pedido1.agregarProducto(torta, 1);
        pedido1.asignarMesa(mesa1);
        pedido1.cambiarEstado("Entregado");

        // Mostrar resumen
        pedido1.mostrarResumen();
    }
}

