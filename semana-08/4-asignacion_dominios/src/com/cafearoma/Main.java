package com.cafearoma;

import com.cafearoma.modelo.*;
import com.cafearoma.servicio.*;
import com.cafearoma.util.Validador;

import java.util.Map;
import java.util.Scanner;

/**
 * Main con menú de consola que demuestra los ejercicios de la Semana 8.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== Café Aroma - Semana 08: Colecciones y Genéricos ===");
        Scanner sc = new Scanner(System.in);

        // Repositorio global de productos (map genérico)
        GenericRepository<String, Producto> productosRepo = new GenericRepository<>();
        InventarioService inventario = new InventarioService();
        // cargamos algunos productos de ejemplo
        Producto p1 = new Producto("PR001", "Capuccino", 8000, 10, "BEBIDA");
        Producto p2 = new Producto("PR002", "Torta Chocolate", 12000, 5, "POSTRE");
        Producto p3 = new Producto("PR003", "Jugo Naranja", 6000, 8, "BEBIDA");

        productosRepo.save(p1.getCodigo(), p1);
        productosRepo.save(p2.getCodigo(), p2);
        productosRepo.save(p3.getCodigo(), p3);

        inventario.agregarProducto(p1);
        inventario.agregarProducto(p2);
        inventario.agregarProducto(p3);

        ClienteService clienteService = new ClienteService();
        CategoriaService categoriaService = new CategoriaService();
        categoriaService.agregarCategoria("BEBIDA");
        categoriaService.agregarCategoria("POSTRE");

        PedidoService pedidoService = new PedidoService(productosRepo);

        boolean salir = false;
        while (!salir) {
            System.out.println("\nMenu:");
            System.out.println("1) Listar inventario");
            System.out.println("2) Agregar producto");
            System.out.println("3) Registrar cliente");
            System.out.println("4) Crear pedido (ejemplo rápido)");
            System.out.println("5) Mostrar estadísticas (productos más vendidos)");
            System.out.println("6) Mostrar categorías (Set)");
            System.out.println("0) Salir");
            System.out.print("Elige opción: ");
            String op = sc.nextLine();

            try {
                switch (op) {
                    case "1":
                        inventario.listarTodos().forEach(System.out::println);
                        break;
                    case "2":
                        System.out.print("Código: "); String cod = sc.nextLine();
                        System.out.print("Nombre: "); String nom = sc.nextLine();
                        System.out.print("Precio: "); double pr = Double.parseDouble(sc.nextLine());
                        System.out.print("Stock: "); int st = Integer.parseInt(sc.nextLine());
                        System.out.print("Categoria: "); String cat = sc.nextLine();
                        Producto nuevo = new Producto(cod, nom, pr, st, cat);
                        inventario.agregarProducto(nuevo);
                        productosRepo.save(nuevo.getCodigo(), nuevo);
                        categoriaService.agregarCategoria(cat);
                        System.out.println("Producto agregado.");
                        break;
                    case "3":
                        System.out.print("ID cliente: "); String id = sc.nextLine();
                        System.out.print("Nombre: "); String nombre = sc.nextLine();
                        System.out.print("Email: "); String email = sc.nextLine();
                        System.out.print("Teléfono: "); String tel = sc.nextLine();
                        Cliente c = new Cliente(id, nombre, email, tel);
                        clienteService.registrarCliente(c);
                        System.out.println("Cliente registrado.");
                        break;
                    case "4":
                        System.out.print("ID cliente (para crear pedido): "); String cid = sc.nextLine();
                        Cliente cliente = clienteService.buscarCliente(cid);
                        if (cliente == null) {
                            System.out.println("Cliente no encontrado. Registre primero.");
                            break;
                        }
                        Pedido ped = pedidoService.crearPedido(cid, cliente);
                        System.out.print("Código producto: "); String cprod = sc.nextLine();
                        System.out.print("Cantidad: "); int cant = Integer.parseInt(sc.nextLine());
                        pedidoService.agregarDetalle(ped, cprod, cant);
                        System.out.println("Pedido creado: " + ped);
                        break;
                    case "5":
                        Map<String,Integer> stats = pedidoService.productosMasVendidos();
                        if (stats.isEmpty()) System.out.println("No hay ventas aún.");
                        else stats.forEach((k,v) -> System.out.println(k + " -> " + v + " unidades vendidas"));
                        break;
                    case "6":
                        System.out.println("Categorías: " + categoriaService.listarCategorias());
                        break;
                    case "0":
                        salir = true;
                        break;
                    default:
                        System.out.println("Opción inválida.");
                }
            } catch (Exception e) {
                System.err.println("ERROR: " + e.getMessage());
            }
        }

        sc.close();
        System.out.println("SALIENDO. ¡Éxitos con tu entrega!");
    }
}
