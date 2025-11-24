public class Postre extends Producto {

    private int porciones;

    public Postre(String codigo, String nombre, double precioBase, int porciones) {
        super(codigo, nombre, precioBase);
        this.porciones = porciones;
    }

    @Override
    public double calcularPrecio() {
        return precioBase * porciones;
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Porciones: " + porciones);
    }
}
