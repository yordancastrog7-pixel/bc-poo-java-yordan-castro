package semana06.implementaciones;

import semana06.abstractas.ProductoAbstract;
import semana06.interfaces.Vendible;
import semana06.interfaces.Descontable;

public class Sandwich extends ProductoAbstract implements Vendible, Descontable {
    private boolean esVegetariano;
    private int stock;

    public Sandwich(String codigo, String nombre, double precioBase, boolean esVegetariano, int stock) {
        super(codigo, nombre, precioBase);
        this.esVegetariano = esVegetariano;
        this.stock = stock;
    }

    @Override
    public double calcularPrecioFinal() {
        double extra = esVegetariano ? 0 : 800; // recargo si no es vegetariano
        return precioBase + extra;
    }

    @Override
    public boolean estaDisponible() {
        return stock > 0;
    }

    @Override
    public double vender(int cantidad) {
        if (cantidad <= 0) return 0;
        if (stock >= cantidad) {
            stock -= cantidad;
            return calcularPrecioFinal() * cantidad;
        } else {
            double vend = calcularPrecioFinal() * stock;
            stock = 0;
            return vend;
        }
    }

    @Override
    public boolean esElegibleDescuento() {
        // ejemplo: sandwiches no vegetarianos y precioBase>4000
        return !esVegetariano && precioBase > 4000;
    }

    @Override
    public double aplicarDescuento(double porcentaje) {
        if (!esElegibleDescuento()) return calcularPrecioFinal();
        return calcularPrecioFinal() * ((100 - porcentaje) / 100.0);
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Vegetariano: " + (esVegetariano ? "Sí" : "No"));
        System.out.println("Stock: " + stock);
    }
}
