# Análisis de Polimorfismo – Café Aroma

## 1. Sobrecarga
### Métodos
- agregarProducto(Producto p)
- agregarProducto(Producto p1, Producto p2)

### Justificación
Permite agregar uno o varios productos al inventario según la necesidad.

---

## 2. Sobrescritura
El método `calcularPrecio()` se sobrescribe en:
- Bebida → suma recargo si es fría
- Postre → multiplica por número de porciones

---

## 3. Polimorfismo Dinámico
Se usa un ArrayList<Producto>:

```java
for (Producto p : productos) {
    p.mostrarInfo();
    p.calcularPrecio();
}
