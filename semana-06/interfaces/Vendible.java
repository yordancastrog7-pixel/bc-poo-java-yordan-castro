package semana06.interfaces;

public interface Vendible {
    // devuelve true si hay suficiente stock (implementación libre)
    boolean estaDisponible();

    // realiza la venta y devuelve el precio cobrado
    double vender(int cantidad);
}
