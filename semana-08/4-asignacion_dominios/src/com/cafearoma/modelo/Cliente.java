package com.cafearoma.modelo;

/**
 * Representa un cliente.
 */
public class Cliente {
    private String id; // puede ser DNI o código
    private String nombre;
    private String email;
    private String telefono;

    public Cliente(String id, String nombre, String email, String telefono) {
        if (id == null || id.isBlank()) throw new IllegalArgumentException("ID no puede estar vacío");
        if (nombre == null || nombre.isBlank()) throw new IllegalArgumentException("Nombre no puede estar vacío");
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public String getEmail() { return email; }
    public String getTelefono() { return telefono; }

    public void setEmail(String email) { this.email = email; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    @Override
    public String toString() {
        return String.format("%s | %s | %s | %s", id, nombre, email == null ? "-" : email, telefono == null ? "-" : telefono);
    }
}
