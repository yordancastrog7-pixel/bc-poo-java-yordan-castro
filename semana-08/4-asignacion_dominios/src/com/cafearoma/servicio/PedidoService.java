package com.cafearoma.servicio;

import com.cafearoma.modelo.*;

import java.util.*;

/**
 * Servicio de pedidos que usa List<Pedido> y Map<String, Producto> para validaciones.
 */
public class PedidoService {
    private List<Pedido> pedidos = new ArrayList<>();
    private GenericRepository<String, Producto> productos; // repositorio de productos (por codigo)
    private int contador = 1;

    public PedidoService(GenericRepository<String, Producto> productosRepo) {
        this.productos = productosRepo;
    }

    public Pedido crearPedido(String clienteId, Cliente cliente) {
        if (cliente == null) throw new IllegalArgumentException("Cliente inválido");
        String id = String.format("PED%03d", contador++);
        Pedido p = new Pedido(id, cliente);
        pedidos.add(p);
        return p;
    }

    public void agregarDetalle(Pedido pedido, String codigoProducto, int cantidad) {
        if (pedido == null) throw new IllegalArgumentException("Pedido null");
        Optional<Producto> opt = productos.find(codigoProducto);
        if (opt.isEmpty()) throw new IllegalArgumentException("Producto no encontrado: " + codigoProducto);
        Producto prod = opt.get();
        if (prod.getStock() < cantidad) throw new IllegalArgumentException("Stock insuficiente: " + prod.getStock());
        // reducir stock
        prod.disminuirStock(cantidad);
        pedido.agregarDetalle(new DetallePedido(prod, cantidad));
    }

    public List<Pedido> listarPedidos() {
        return new ArrayList<>(pedidos);
    }

    public List<Pedido> listarPedidosPorCliente(String clienteId) {
        List<Pedido> out = new ArrayList<>();
        for (Pedido p : pedidos) {
            if (p.getCliente().getId().equalsIgnoreCase(clienteId)) out.add(p);
        }
        return out;
    }

    // Ejemplo de estadística: productos más vendidos (por código)
    public Map<String, Integer> productosMasVendidos() {
        Map<String,Integer> contador = new HashMap<>();
        for (Pedido p : pedidos) {
            for (DetallePedido d : p.getDetalles()) {
                String c = d.getProducto().getCodigo();
                contador.put(c, contador.getOrDefault(c, 0) + d.getCantidad());
            }
        }
        return contador;
    }
}
