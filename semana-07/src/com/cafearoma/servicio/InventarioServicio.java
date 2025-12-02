package com.cafearoma.servicio;

import com.cafearoma.modelo.Producto;
import com.cafearoma.modelo.Categoria;
import com.cafearoma.excepciones.ProductoNoEncontradoException;
import com.cafearoma.excepciones.StockInvalidoException;

import java.util.ArrayList;
import java.util.List;

/**
 * Servicio para gestión del inventario de la cafetería.
 */
public class InventarioServicio {
    private List<Producto> productos = new ArrayList<>();

    public void agregarProducto(Producto p) {
        // Validación: no duplicados por código
        try {
            buscarProducto(p.getCodigo());
            throw new IllegalArgumentException("Ya existe un producto con el código: " + p.getCodigo());
        } catch (ProductoNoEncontradoException e) {
            // no existe -> lo agregamos
            productos.add(p);
            System.out.println("Producto agregado: " + p.getCodigo());
        }
    }

    public Producto buscarProducto(String codigo) throws ProductoNoEncontradoException {
        return productos.stream()
                .filter(p -> p.getCodigo().equalsIgnoreCase(codigo))
                .findFirst()
                .orElseThrow(() -> new ProductoNoEncontradoException("Producto no encontrado: " + codigo));
    }

    public void eliminarProducto(String codigo) throws ProductoNoEncontradoException {
        Producto p = buscarProducto(codigo);
        productos.remove(p);
        System.out.println(" Producto eliminado: " + codigo);
    }

    /**
     * Vender (reducir stock). Lanza excepción si stock insuficiente.
     */
    public void venderProducto(String codigo, int cantidad) throws ProductoNoEncontradoException, StockInvalidoException {
        if (cantidad <= 0) throw new StockInvalidoException("Cantidad debe ser mayor que 0");
        Producto p = buscarProducto(codigo);
        if (p.getStock() < cantidad) {
            throw new StockInvalidoException("Stock insuficiente para " + codigo + ". Disponible: " + p.getStock());
        }
        p.disminuirStock(cantidad);
        System.out.println(" Venta procesada: " + codigo + " x" + cantidad);
    }

    public void actualizarStock(String codigo, int nuevoStock) throws ProductoNoEncontradoException {
        if (nuevoStock < 0) throw new IllegalArgumentException("Stock no puede ser negativo");
        Producto p = buscarProducto(codigo);
        p.setStock(nuevoStock);
        System.out.println(" Stock actualizado: " + codigo + " -> " + nuevoStock);
    }

    public void mostrarInventario() {
        System.out.println("=== Inventario Café Aroma ===");
        if (productos.isEmpty()) {
            System.out.println("Sin productos.");
            return;
        }
        for (Producto p : productos) {
            System.out.println(p);
        }
    }

    // Método de ayuda para pruebas: crear ejemplo básico
    public void precargarEjemplos() {
        productos.add(new Producto("P001", "Capuccino", 8000, 10, Categoria.BEBIDA));
        productos.add(new Producto("P002", "Torta Chocolate", 12000, 5, Categoria.POSTRE));
        productos.add(new Producto("P003", "Jugo Naranja", 6000, 8, Categoria.BEBIDA));
    }
}
