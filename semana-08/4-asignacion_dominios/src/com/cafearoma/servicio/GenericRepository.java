package com.cafearoma.servicio;

import java.util.*;

/**
 * Repositorio genérico simple (Map-based).
 * K = tipo de clave, T = entidad.
 */
public class GenericRepository<K, T> {
    private Map<K, T> store = new HashMap<>();

    public void save(K key, T entity) {
        store.put(key, entity);
    }

    public Optional<T> find(K key) {
        return Optional.ofNullable(store.get(key));
    }

    public boolean exists(K key) {
        return store.containsKey(key);
    }

    public void delete(K key) {
        store.remove(key);
    }

    public Collection<T> findAll() {
        return store.values();
    }

    public Set<K> keySet() { return store.keySet(); }
}
