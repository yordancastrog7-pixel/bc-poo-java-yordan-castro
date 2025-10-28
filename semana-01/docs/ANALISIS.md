# Análisis del Dominio: Cafetería “Café Aroma”

## 1. Identificación de Objetos

---

### ☕ Objeto Principal: Pedido
- **¿Qué es?:** Representa la solicitud de consumo que realiza un cliente en la cafetería.  
- **Justificación:** Es el elemento central que conecta a las personas, los productos y las mesas.  
- **Atributos identificados:** número, fecha, cliente, productos, total, estado.  
- **Comportamientos:** registrarPedido(), agregarProducto(), calcularTotal(), cambiarEstado(), entregarPedido().  

---

### 👤 Objeto 2: Persona
- **¿Qué es?:** Individuo que interactúa dentro de la cafetería, ya sea cliente o empleado (barista, mesero).  
- **Justificación:** Permite representar a todos los actores humanos del negocio sin separar en múltiples clases.  
- **Atributos identificados:** nombre, rol, identificación, contacto, turno.  
- **Comportamientos:** realizarPedido(), atenderMesa(), prepararBebida(), pagarConsumo().  

---

### 🍰 Objeto 3: Producto
- **¿Qué es?:** Cualquier artículo disponible para la venta, como bebidas, postres o desayunos.  
- **Justificación:** Los pedidos se componen de productos, por lo que son esenciales para el funcionamiento del negocio.  
- **Atributos identificados:** nombre, categoría, precio, stockDisponible, descripción.  
- **Comportamientos:** mostrarInformación(), actualizarStock(), aplicarDescuento(), cambiarPrecio().  

---

### 🪑 Objeto 4: Mesa
- **¿Qué es?:** Espacio físico asignado a los clientes para consumir sus pedidos.  
- **Justificación:** Permite controlar la disponibilidad y la ubicación de los pedidos dentro del local.  
- **Atributos identificados:** número, capacidad, estado (libre, ocupada, reservada), ubicación.  
- **Comportamientos:** asignarCliente(), liberarMesa(), actualizarEstado(), asociarPedido().  

---

### 🏠 Objeto 5: Cafeteria
- **¿Qué es?:** Representa el sistema general que administra los pedidos, productos, mesas y personas.  
- **Justificación:** Sirve como punto de control central para coordinar la operación del negocio.  
- **Atributos identificados:** nombre, dirección, listaDePedidos, listaDeProductos, listaDePersonas, listaDeMesas.  
- **Comportamientos:** registrarPedido(), agregarProducto(), asignarMesa(), listarPedidos(), mostrarResumen().  

---

## 2. Diagrama de Relaciones (Descripción Textual)
- Una **Cafeteria** tiene varias **Mesas**, **Personas**, **Pedidos** y **Productos**.  
- Un **Pedido** pertenece a una **Persona (cliente)** y puede incluir varios **Productos**.  
- Cada **Pedido** se realiza en una **Mesa** específica.  
- Los **Empleados (baristas o meseros)** son instancias del objeto **Persona** con roles diferentes.

---

## 3. Decisiones de Diseño
- Se decidió que **Persona** agrupe los roles humanos para simplificar el modelo.  
- **Pedido** se definió como el objeto principal por ser el eje de las operaciones.  
- **Cafeteria** actúa como clase controladora, gestionando los demás objetos.  
- Se usó un nivel de detalle que permite implementar las clases fácilmente en Java.

---

## 4. Dificultades Encontradas
- Evitar repetir información entre los objetos **Persona** y **Pedido**.  
- Elegir qué atributos debía tener cada clase sin que se solaparan responsabilidades.  
- Mantener el modelo claro y aplicable para la programación orientada a objetos.
