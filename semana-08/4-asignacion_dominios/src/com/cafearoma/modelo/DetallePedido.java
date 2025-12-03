package com.cafearoma.modelo;

/**
 * Detalle de un pedido (producto + cantidad).
 */
public class DetallePedido {
    private Producto producto;
    private int cantidad;

    public DetallePedido(Producto producto, int cantidad) {
        if (producto == null) throw new IllegalArgumentException("Producto no puede ser null");
        if (cantidad <= 0) throw new IllegalArgumentException("Cantidad debe ser mayor que 0");
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Producto getProducto() { return producto; }
    public int getCantidad() { return cantidad; }

    public double subtotal() { return producto.getPrecio() * cantidad; }

    @Override
    public String toString() {
        return producto.getNombre() + " x" + cantidad + " -> $" + subtotal();
    }
}
