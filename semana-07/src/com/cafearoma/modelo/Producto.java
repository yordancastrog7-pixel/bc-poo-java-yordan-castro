package com.cafearoma.modelo;

/**
 * Entidad Producto del inventario.
 */
public class Producto {
    private String codigo;
    private String nombre;
    private double precio;
    private int stock;
    private Categoria categoria;

    public Producto(String codigo, String nombre, double precio, int stock, Categoria categoria) {
        if (codigo == null || codigo.isBlank()) throw new IllegalArgumentException("Código no puede estar vacío");
        if (nombre == null || nombre.isBlank()) throw new IllegalArgumentException("Nombre no puede estar vacío");
        if (precio <= 0) throw new IllegalArgumentException("Precio debe ser mayor a 0");
        if (stock < 0) throw new IllegalArgumentException("Stock no puede ser negativo");
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.categoria = categoria;
    }

    // getters y setters mínimos
    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public int getStock() { return stock; }
    public Categoria getCategoria() { return categoria; }

    public void setPrecio(double precio) {
        if (precio <= 0) throw new IllegalArgumentException("Precio debe ser mayor a 0");
        this.precio = precio;
    }

    public void setStock(int stock) {
        if (stock < 0) throw new IllegalArgumentException("Stock no puede ser negativo");
        this.stock = stock;
    }

    public void disminuirStock(int cantidad) {
        this.stock -= cantidad;
    }

    @Override
    public String toString() {
        return String.format("%s - %s | $%.2f | stock: %d | %s",
                codigo, nombre, precio, stock, categoria);
    }
}
