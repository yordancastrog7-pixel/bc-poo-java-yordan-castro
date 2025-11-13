# Semana 02 - Clases y Objetos
## Dominio: Cafetería “Café Aroma”  

## Descripción
En esta segunda semana se amplía el proyecto **Café Aroma** incorporando clases relacionadas entre sí mediante composición y colecciones (`ArrayList`).  
El objetivo es representar de forma más real el funcionamiento de una cafetería donde los clientes realizan pedidos de distintos productos.  



## Objetivos Cumplidos  
- [x] Creación de nuevas clases: `Cliente` y `Producto`.  
- [x] Implementación de relaciones entre objetos (`Pedido` usa `Cliente` y `Producto`).  
- [x] Uso de `ArrayList` en la clase `Cafeteria` para gestionar pedidos.  
- [x] Programa principal funcional en `Main.java`.  



##  Clases Implementadas  

### Cliente.java  
Representa a la persona que realiza pedidos.  
**Atributos:** nombre, correo, teléfono.  
**Métodos:** constructor, getters.

### Producto.java  
Define los artículos que ofrece la cafetería.  
**Atributos:** nombre, precio, categoría.  
**Métodos:** constructor, getters.

### Pedido.java  
Relaciona un `Cliente` con un `Producto`.  
**Atributos:** cliente, producto, cantidad.  
**Métodos:** calcularTotal(), mostrarPedido().

### Cafeteria.java  
Gestiona los pedidos usando `ArrayList<Pedido>`.  
**Atributos:** nombre, lista de pedidos.  
**Métodos:** agregarPedido(), mostrarPedidos(), contarPedidos().

###  Main.java  
Crea objetos y prueba el funcionamiento completo del sistema.

---

## Ejecución  
```bash
cd semana-02
javac *.java
java Main