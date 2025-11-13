public class Pedido {
    private Cliente cliente;
    private Producto producto;
    private int cantidad;

    public Pedido(Cliente cliente, Producto producto, int cantidad) {
        this.cliente = cliente;
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public double calcularTotal() {
        return producto.getPrecio() * cantidad;
    }

    public void mostrarResumen() {
        System.out.println(cliente.obtenerInfo() + " pidió " + cantidad + 
                           " x " + producto.obtenerDescripcion() + 
                           " | Total: $" + calcularTotal());
    }
}
