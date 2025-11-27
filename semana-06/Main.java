package semana06;

import semana06.abstractas.ProductoAbstract;
import semana06.implementaciones.Bebida;
import semana06.implementaciones.Postre;
import semana06.implementaciones.Sandwich;
import semana06.interfaces.Vendible;
import semana06.interfaces.Descontable;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== CAFETERÍA: CAFÉ AROMA - Semana 06 ===\n");

        // Sección 1: Polimorfismo con clase abstracta
        System.out.println("--- Sección 1: Polimorfismo (Productos) ---\n");
        ProductoAbstract[] menu = new ProductoAbstract[4];
        menu[0] = new Bebida("B001", "Capuccino", 6000, false, 10);
        menu[1] = new Bebida("B002", "Té Helado", 4500, true, 5);
        menu[2] = new Postre("P001", "Torta Chocolate", 4000, 2, 3);
        menu[3] = new Sandwich("S001", "Sandwich Pollo", 5500, false, 4);

        for (ProductoAbstract p : menu) {
            p.mostrarInfo();
            System.out.println("Precio final: $" + p.calcularPrecioFinal());
            System.out.println("----------------------------");
        }

        // Sección 2: Uso de interfaces (referencias de tipo interfaz)
        System.out.println("\n--- Sección 2: Interfaces (Vendible / Descontable) ---\n");
        Vendible vendible = (Vendible) menu[0];
        System.out.println("Disponibilidad " + ((ProductoAbstract) vendible).nombre + ": " + vendible.estaDisponible());
        double cobro = vendible.vender(2);
        System.out.println("Venta cobrada por 2 unidades: $" + cobro);

        // Sección 3: Múltiple implementación
        System.out.println("\n--- Sección 3: Implementación múltiple y descuentos ---\n");
        Descontable d = (Descontable) menu[1]; // Té Helado (fría) -> Descontable
        if (d.esElegibleDescuento()) {
            double precioConDesc = d.aplicarDescuento(10);
            System.out.println("Precio con 10% descuento: $" + precioConDesc);
        } else {
            System.out.println("No aplica descuento para: " + ((ProductoAbstract)d).nombre);
        }

        // Ejemplo de mezcla: lista polimórfica y venta masiva
        System.out.println("\n--- Sección 4: Lista polimórfica y resumen de ventas ---\n");
        double totalVentas = 0;
        for (ProductoAbstract p : menu) {
            if (p instanceof Vendible) {
                Vendible v = (Vendible) p;
                double cobrado = v.vender(1);
                totalVentas += cobrado;
                System.out.println("Vendido 1 unidad de " + p.nombre + " -> $" + cobrado);
            }
        }
        System.out.println("\nTotal ventas demostración: $" + totalVentas);

        System.out.println("\n=== FIN ===");
    }
}
