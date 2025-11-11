public class Mesa {
    private int numero;
    private boolean ocupada;

    public Mesa(int numero) {
        this.numero = numero;
        this.ocupada = false;
    }

    public int getNumero() {
        return numero;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public void asignar() {
        ocupada = true;
    }

    public void liberar() {
        ocupada = false;
    }

    @Override
    public String toString() {
        return "Mesa #" + numero + (ocupada ? " (Ocupada)" : " (Libre)");
    }
}
