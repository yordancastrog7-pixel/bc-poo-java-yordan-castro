package semana06.implementaciones;

import semana06.abstractas.ProductoAbstract;
import semana06.interfaces.Vendible;

public class Postre extends ProductoAbstract implements Vendible {
    private int porciones;
    private int stock;

    public Postre(String codigo, String nombre, double precioBase, int porciones, int stock) {
        super(codigo, nombre, precioBase);
        this.porciones = porciones;
        this.stock = stock;
    }

    @Override
    public double calcularPrecioFinal() {
        // precio por porción
        return precioBase * porciones;
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
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Porciones: " + porciones);
        System.out.println("Stock: " + stock);
    }
}
