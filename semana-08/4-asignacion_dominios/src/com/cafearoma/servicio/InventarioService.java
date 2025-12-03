package com.cafearoma.servicio;

import com.cafearoma.modelo.Producto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Servicio que usa ArrayList para operaciones de inventario simples.
 */
public class InventarioService {
    private List<Producto> productos = new ArrayList<>();

    public void agregarProducto(Producto p) {
        if (p == null) throw new IllegalArgumentException("Producto no puede ser null");
        Optional<Producto> existe = productos.stream()
                .filter(x -> x.getCodigo().equalsIgnoreCase(p.getCodigo()))
                .findFirst();
        if (existe.isPresent()) throw new IllegalArgumentException("Código duplicado: " + p.getCodigo());
        productos.add(p);
    }

    public List<Producto> listarTodos() {
        return new ArrayList<>(productos);
    }

    public Producto buscarPorCodigo(String codigo) {
        return productos.stream()
                .filter(p -> p.getCodigo().equalsIgnoreCase(codigo))
                .findFirst()
                .orElse(null);
    }

    public void actualizarPrecio(String codigo, double nuevoPrecio) {
        Producto p = buscarPorCodigo(codigo);
        if (p == null) throw new IllegalArgumentException("Producto no encontrado: " + codigo);
        p.setPrecio(nuevoPrecio);
    }

    public void eliminarProducto(String codigo) {
        Producto p = buscarPorCodigo(codigo);
        if (p == null) throw new IllegalArgumentException("Producto no encontrado: " + codigo);
        productos.remove(p);
    }

    public List<Producto> filtrarPorCategoria(String categoria) {
        List<Producto> out = new ArrayList<>();
        for (Producto p : productos) {
            if (p.getCategoria().equalsIgnoreCase(categoria)) out.add(p);
        }
        return out;
    }
}
