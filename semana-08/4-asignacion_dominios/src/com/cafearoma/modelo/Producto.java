package com.cafearoma.modelo;

/**
 * Representa un producto de la cafetería.
 */
public class Producto {
    private String codigo;
    private String nombre;
    private double precio;
    private int stock;
    private String categoria;

    public Producto(String codigo, String nombre, double precio, int stock, String categoria) {
        if (codigo == null || codigo.isBlank()) throw new IllegalArgumentException("Código no puede estar vacío");
        if (nombre == null || nombre.isBlank()) throw new IllegalArgumentException("Nombre no puede estar vacío");
        if (precio <= 0) throw new IllegalArgumentException("Precio debe ser mayor a 0");
        if (stock < 0) throw new IllegalArgumentException("Stock no puede ser negativo");
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.categoria = categoria == null ? "OTRO" : categoria;
    }

    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public int getStock() { return stock; }
    public String getCategoria() { return categoria; }

    public void setPrecio(double precio) {
        if (precio <= 0) throw new IllegalArgumentException("Precio debe ser mayor a 0");
        this.precio = precio;
    }

    public void setStock(int stock) {
        if (stock < 0) throw new IllegalArgumentException("Stock no puede ser negativo");
        this.stock = stock;
    }

    public void disminuirStock(int cantidad) {
        if (cantidad <= 0) throw new IllegalArgumentException("Cantidad debe ser mayor que 0");
        if (cantidad > stock) throw new IllegalArgumentException("Cantidad mayor al stock disponible");
        this.stock -= cantidad;
    }

    @Override
    public String toString() {
        return String.format("%s | %s | $%.2f | stock:%d | %s", codigo, nombre, precio, stock, categoria);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Producto)) return false;
        Producto p = (Producto) o;
        return codigo.equalsIgnoreCase(p.codigo);
    }

    @Override
    public int hashCode() {
        return codigo.toLowerCase().hashCode();
    }
}
