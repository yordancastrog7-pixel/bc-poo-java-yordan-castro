package com.cafearoma.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Pedido simple con lista de detalles.
 */
public class Pedido {
    private String id;
    private Cliente cliente;
    private LocalDate fecha;
    private List<DetallePedido> detalles = new ArrayList<>();
    private String estado; // e.g. "CREADO", "ENTREGADO"

    public Pedido(String id, Cliente cliente) {
        if (id == null || id.isBlank()) throw new IllegalArgumentException("ID no puede estar vacío");
        if (cliente == null) throw new IllegalArgumentException("Cliente no puede ser null");
        this.id = id;
        this.cliente = cliente;
        this.fecha = LocalDate.now();
        this.estado = "CREADO";
    }

    public String getId() { return id; }
    public Cliente getCliente() { return cliente; }
    public LocalDate getFecha() { return fecha; }
    public List<DetallePedido> getDetalles() { return detalles; }
    public String getEstado() { return estado; }

    public void agregarDetalle(DetallePedido d) {
        if (d == null) throw new IllegalArgumentException("Detalle no puede ser null");
        detalles.add(d);
    }

    public double total() {
        return detalles.stream().mapToDouble(DetallePedido::subtotal).sum();
    }

    public void setEstado(String estado) { this.estado = estado; }

    @Override
    public String toString() {
        return String.format("Pedido %s - Cliente: %s - Fecha: %s - Total: $%.2f - Estado: %s",
                id, cliente.getNombre(), fecha, total(), estado);
    }
}
