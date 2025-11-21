public class Pedido {
    private Cliente cliente;
    private Producto producto;
    private int cantidad;

    // Constructor completo
    public Pedido(Cliente cliente, Producto producto, int cantidad) {
        setCliente(cliente);
        setProducto(producto);
        setCantidad(cantidad);
    }

    // Constructor alterno
    public Pedido(Cliente cliente) {
        this(cliente, new Producto("Café Americano", 4000), 1);
    }

    public Cliente getCliente() { return cliente; }
    public Producto getProducto() { return producto; }
    public int getCantidad() { return cantidad; }

    public void setCliente(Cliente cliente) {
        if (cliente == null) throw new IllegalArgumentException("Cliente obligatorio");
        this.cliente = cliente;
    }

    public void setProducto(Producto producto) {
        if (producto == null) throw new IllegalArgumentException("Producto obligatorio");
        this.producto = producto;
    }

    public void setCantidad(int cantidad) {
        if (cantidad <= 0) throw new IllegalArgumentException("Cantidad inválida");
        this.cantidad = cantidad;
    }

    public double calcularTotal() {
        return producto.getPrecio() * cantidad;
    }
}
