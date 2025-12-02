package com.cafearoma;

import com.cafearoma.modelo.Producto;
import com.cafearoma.modelo.Categoria;
import com.cafearoma.servicio.InventarioServicio;
import com.cafearoma.excepciones.ProductoNoEncontradoException;
import com.cafearoma.excepciones.StockInvalidoException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;

/**
 * Main de demostración para la Semana 07.
 * Contiene 5 casos de prueba: éxitos y errores.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== Sistema Cafetería - Semana 07 ===\n");
        InventarioServicio servicio = new InventarioServicio();

        // Precargar algunos productos
        servicio.precargarEjemplos();

        // Caso 1: Operación exitosa - mostrar inventario
        System.out.println("--- Caso 1: Mostrar inventario (OK) ---");
        servicio.mostrarInventario();

        // Caso 2: Agregar producto con precio inválido -> IllegalArgumentException
        System.out.println("\n--- Caso 2: Agregar producto con precio inválido (IllegalArgumentException) ---");
        try {
            Producto malPrecio = new Producto("P004", "Pan", -2000, 10, Categoria.SNACK);
            servicio.agregarProducto(malPrecio);
        } catch (IllegalArgumentException e) {
            System.err.println(" Error: " + e.getMessage());
        }

        // Caso 3: Buscar producto inexistente -> ProductoNoEncontradoException
        System.out.println("\n--- Caso 3: Buscar producto inexistente (ProductoNoEncontradoException) ---");
        try {
            servicio.buscarProducto("PX99");
        } catch (ProductoNoEncontradoException e) {
            System.err.println(" Producto no encontrado: " + e.getMessage());
        }

        // Caso 4: Vender con stock insuficiente -> StockInvalidoException
        System.out.println("\n--- Caso 4: Vender con stock insuficiente (StockInvalidoException) ---");
        try {
            servicio.venderProducto("P002", 20); // Torta Chocolate tiene stock 5
        } catch (ProductoNoEncontradoException e) {
            System.err.println(" Producto no encontrado: " + e.getMessage());
        } catch (StockInvalidoException e) {
            System.err.println(" Stock inválido: " + e.getMessage());
        }

        // Caso 5: Venta exitosa y recuperación después de error
        System.out.println("\n--- Caso 5: Venta exitosa (recuperación) ---");
        try {
            servicio.venderProducto("P001", 2);
            System.out.println(" Venta realizada correctamente.");
            servicio.mostrarInventario();
        } catch (Exception e) {
            System.err.println(" Error inesperado: " + e.getMessage());
        }

        // Ejemplo finalmente: lectura de archivo (demostración)
        System.out.println("\n--- Ejemplo finally: lectura segura de archivo ---");
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("config.txt"));
            System.out.println("Leyendo archivo de configuración...");
            String linea = reader.readLine();
            System.out.println("Primera línea (si existe): " + linea);
        } catch (IOException e) {
            System.err.println(" Error leyendo archivo: " + e.getMessage());
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                    System.out.println("Se cerró el archivo correctamente (finally).");
                } catch (IOException e) {
                    System.err.println(" Error cerrando archivo: " + e.getMessage());
                }
            } else {
                System.out.println("No había archivo para cerrar (finally).");
            }
        }

        System.out.println("\n=== FIN DEMOSTRACIÓN Semana 07 ===");
    }
}
