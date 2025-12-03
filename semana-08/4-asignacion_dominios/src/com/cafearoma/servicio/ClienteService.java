package com.cafearoma.servicio;

import com.cafearoma.modelo.Cliente;

import java.util.*;

/**
 * Servicio de clientes usando Map (clave = id).
 */
public class ClienteService {
    private GenericRepository<String, Cliente> repo = new GenericRepository<>();

    public void registrarCliente(Cliente c) {
        if (c == null) throw new IllegalArgumentException("Cliente no puede ser null");
        if (repo.exists(c.getId())) throw new IllegalArgumentException("Cliente ya registrado: " + c.getId());
        repo.save(c.getId(), c);
    }

    public Cliente buscarCliente(String id) {
        return repo.find(id).orElse(null);
    }

    public void eliminarCliente(String id) {
        repo.delete(id);
    }

    public Collection<Cliente> listarClientes() {
        return repo.findAll();
    }
}
