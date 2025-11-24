public class CafeCaliente extends ProductoCafe {
    private String tipoPreparacion;

    public CafeCaliente(String nombre, double precio, String tamano, String tipoPreparacion) {
        super(nombre, precio, tamano);
        this.tipoPreparacion = tipoPreparacion;
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Preparación: " + tipoPreparacion);
    }

    @Override
    public double calcularPrecioFinal() {
        return precio + 1000; // Recargo por ser caliente
    }
}
