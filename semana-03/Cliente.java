public class Cliente {
    private String nombre;
    private String email;

    // Constructor completo
    public Cliente(String nombre, String email) {
        setNombre(nombre);
        setEmail(email);
    }

    // Constructor básico
    public Cliente(String nombre) {
        this(nombre, nombre.toLowerCase() + "@example.com");
    }

    public String getNombre() { return nombre; }
    public String getEmail() { return email; }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("Nombre inválido");
        }
        this.nombre = nombre;
    }

    public void setEmail(String email) {
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Email inválido");
        }
        this.email = email;
    }
}
