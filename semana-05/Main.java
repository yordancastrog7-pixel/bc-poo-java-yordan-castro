public class Main {

    public static void main(String[] args) {

        InventarioCafeteria inventario = new InventarioCafeteria();

        Producto p1 = new Bebida("B001", "Capuccino", 6000, false);
        Producto p2 = new Bebida("B002", "Jugo de Naranja", 5000, true);
        Producto p3 = new Postre("P001", "Torta Chocolate", 4000, 2);
        Producto p4 = new Postre("P002", "Cheesecake", 5000, 1);
        Producto p5 = new Bebida("B003", "Té Helado", 4500, true);

        // Sobrecarga
        inventario.agregarProducto(p1);
        inventario.agregarProducto(p2, p3);

        // Normales
        inventario.agregarProducto(p4);
        inventario.agregarProducto(p5);

        // Mostrar inventario
        inventario.mostrarInventario();
    }
}
