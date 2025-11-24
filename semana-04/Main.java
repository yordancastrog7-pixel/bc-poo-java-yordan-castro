public class Main {
    public static void main(String[] args) {

        ProductoCafe[] productos = new ProductoCafe[4];

        productos[0] = new CafeCaliente("Capuccino", 8000, "Mediano", "Espresso + Vapor");
        productos[1] = new CafeCaliente("Latte", 7500, "Grande", "Espresso + Leche espumada");
        productos[2] = new CafeFrio("Cold Brew", 9000, "Mediano", true);
        productos[3] = new CafeFrio("Frappe Mocca", 11000, "Grande", true);

        for (ProductoCafe p : productos) {
            System.out.println("-------------------------");
            p.mostrarInfo();
            System.out.println("Precio final: $" + p.calcularPrecioFinal());
        }
    }
}
