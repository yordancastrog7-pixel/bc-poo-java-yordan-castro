package semana06.interfaces;

public interface Descontable {
    // verifica si el producto aplica para descuento
    boolean esElegibleDescuento();

    // aplica un porcentaje de descuento y devuelve precio con descuento
    double aplicarDescuento(double porcentaje);
}

