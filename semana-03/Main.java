public class Main {
    public static void main(String[] args) {

        // Actividad 3
        CafeOrder o1 = new CafeOrder("001", "Laura", 15000);
        CafeOrder o2 = new CafeOrder("002", "Carlos", 22000);
        CafeOrder o3 = new CafeOrder("003", "Diana", 18000);

        o1.showInfo();
        o2.showInfo();
        o3.showInfo();

        // Clases encapsuladas semana 03
        Cliente c1 = new Cliente("María", "maria@mail.com");
        Producto p1 = new Producto("Capuchino", 8500);
        Pedido pedido = new Pedido(c1, p1, 2);

        System.out.println("TOTAL PEDIDO: $" + pedido.calcularTotal());
    }
}
