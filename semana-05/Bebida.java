public class Bebida extends Producto {

    private boolean fria;

    public Bebida(String codigo, String nombre, double precioBase, boolean fria) {
        super(codigo, nombre, precioBase);
        this.fria = fria;
    }

    @Override
    public double calcularPrecio() {
        return fria ? precioBase + 1000 : precioBase;
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Tipo: " + (fria ? "Fría" : "Caliente"));
    }
}
