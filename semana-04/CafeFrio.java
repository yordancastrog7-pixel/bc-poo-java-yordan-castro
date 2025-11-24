public class CafeFrio extends ProductoCafe {
    private boolean conHielo;

    public CafeFrio(String nombre, double precio, String tamano, boolean conHielo) {
        super(nombre, precio, tamano);
        this.conHielo = conHielo;
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Incluye hielo: " + (conHielo ? "Sí" : "No"));
    }

    @Override
    public double calcularPrecioFinal() {
        return precio + (conHielo ? 500 : 0);
    }
}
