package com.cafearoma.util;

/**
 * Utilidades de validación simples.
 */
public class Validador {
    public static boolean esNuloOVacio(String s) {
        return s == null || s.isBlank();
    }
}
