package semana06.implementaciones;

import semana06.abstractas.ProductoAbstract;
import semana06.interfaces.Vendible;
import semana06.interfaces.Descontable;

public class Bebida extends ProductoAbstract implements Vendible, Descontable {
    private boolean fria;
    private int stock;

    public Bebida(String codigo, String nombre, double precioBase, boolean fria, int stock) {
        super(codigo, nombre, precioBase);
        this.fria = fria;
        this.stock = stock;
    }

    @Override
    public double calcularPrecioFinal() {
        double extra = fria ? 500 : 0; // recargo por frío
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
            // si no hay stock suficiente, vendemos lo disponible
            double vend = calcularPrecioFinal() * stock;
            stock = 0;
            return vend;
        }
    }

    @Override
    public boolean esElegibleDescuento() {
        // por ejemplo: bebidas frías con precio base > 3000 aplican
        return fria && precioBase > 3000;
    }

    @Override
    public double aplicarDescuento(double porcentaje) {
        if (!esElegibleDescuento()) return calcularPrecioFinal();
        double factor = (100 - porcentaje) / 100.0;
        return calcularPrecioFinal() * factor;
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Tipo: " + (fria ? "Fría" : "Caliente"));
        System.out.println("Stock: " + stock);
    }
}
