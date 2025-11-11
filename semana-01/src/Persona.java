public class Persona {
    private String nombre;
    private String tipo; // barista, mesero, cliente

    public Persona(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }
}
