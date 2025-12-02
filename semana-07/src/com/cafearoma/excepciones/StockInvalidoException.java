package com.cafearoma.excepciones;

/**
 * Excepción lanzada cuando el stock solicitado no es válido (mayor que el disponible o negativo).
 */
public class StockInvalidoException extends Exception {
    public StockInvalidoException(String mensaje) {
        super(mensaje);
    }
    public StockInvalidoException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}
