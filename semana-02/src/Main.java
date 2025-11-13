public class Main {
    public static void main(String[] args) {
        // Crear clientes y productos
        Cliente c1 = new Cliente("María Pérez", "maria@correo.com", "3104567890");
        Producto p1 = new Producto("Capuchino", 8500, "Bebida");
        Producto p2 = new Producto("Brownie", 6000, "Postre");

        // Crear pedidos
        Pedido ped1 = new Pedido(c1, p1, 2);
        Pedido ped2 = new Pedido(c1, p2, 1);

        // Gestionar en la cafetería
        Cafeteria cafe = new Cafeteria("Café Aroma");
        cafe.agregarPedido(ped1);
        cafe.agregarPedido(ped2);

        // Mostrar resultados
        cafe.mostrarPedidos();
        System.out.println("Total pedidos: " + cafe.contarPedidos());
    }
}
