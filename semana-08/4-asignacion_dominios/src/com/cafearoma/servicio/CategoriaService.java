package com.cafearoma.servicio;

import java.util.HashSet;
import java.util.Set;

/**
 * Servicio para manejar categorías únicas (Set).
 */
public class CategoriaService {
    private Set<String> categorias = new HashSet<>();

    public boolean agregarCategoria(String cat) {
        if (cat == null || cat.isBlank()) throw new IllegalArgumentException("Categoría inválida");
        return categorias.add(cat.toUpperCase());
    }

    public Set<String> listarCategorias() {
        return new HashSet<>(categorias);
    }

    public boolean existeCategoria(String cat) {
        return categorias.contains(cat.toUpperCase());
    }
}
