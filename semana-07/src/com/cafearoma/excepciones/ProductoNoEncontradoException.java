package com.cafearoma.excepciones;

/**
 * Excepción lanzada cuando un producto no se encuentra en el inventario.
 */
public class ProductoNoEncontradoException extends Exception {
    public ProductoNoEncontradoException(String mensaje) {
        super(mensaje);
    }
    public ProductoNoEncontradoException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}
