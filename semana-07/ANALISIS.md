# ANÁLISIS – Semana 07  
## Paquetes y Excepciones  
### Proyecto: Cafetería “Café Aroma”

---

## 1. Organización en paquetes

Esta semana se reorganizó el proyecto para seguir buenas prácticas de modularidad.  
Los paquetes creados fueron:

- **com.cafearoma.modelo**  
  Contiene las clases del dominio: `Producto` y `Categoria`.

- **com.cafearoma.excepciones**  
  Contiene las excepciones personalizadas necesarias para el inventario:
  - `ProductoNoEncontradoException`
  - `StockInvalidoException`

- **com.cafearoma.servicio**  
  Contiene `InventarioServicio`, que implementa la lógica de negocio.

- **com.cafearoma**  
  Contiene la clase `Main`, donde se ejecutan los casos de prueba.

Esta estructura facilita la lectura, mantenimiento y escalabilidad futura del proyecto.

---

## 2. Manejo de Excepciones

El sistema implementa validaciones y excepciones personalizadas para controlar errores comunes:

- `ProductoNoEncontradoException`  
  Se lanza cuando se intenta acceder a un producto que no existe.

- `StockInvalidoException`  
  Se lanza cuando se solicita una cantidad mayor al stock disponible o una cantidad inválida.

Además, se conservan validaciones internas como:
- Stock no negativo  
- Precio mayor a cero  
- Código y nombre no vacíos  
- No permitir duplicación de códigos  

Estas reglas evitan que el sistema almacene datos incorrectos.

---

## 3. Justificación del diseño

El uso de **excepciones checked** obliga a que el Main maneje explícitamente los posibles errores del inventario.  
Esto:

- Previene fallos en tiempo de ejecución.  
- Asegura que los errores del dominio se gestionen de manera correcta.  
- Hace que el sistema sea más robusto.

La separación por paquetes también permite crecer el proyecto sin afectar otros módulos.

---

## 4. Casos de prueba realizados en `Main`

En la clase `Main` se desarrollaron 5 pruebas obligatorias:

1. **Mostrar Inventario** (correcto)  
2. **Agregar producto con precio inválido** (IllegalArgumentException)  
3. **Buscar producto inexistente** (ProductoNoEncontradoException)  
4. **Vender con stock insuficiente** (StockInvalidoException)  
5. **Venta exitosa y validación final del inventario**

Se usaron bloques:

- `try`  
- `catch`  
- `finally`  

El bloque `finally` se evidenció mediante lectura de archivo.

---

## 5. Conclusión

La semana 7 permitió reorganizar el proyecto en paquetes bien definidos y aplicar correctamente excepciones personalizadas.  
El inventario ahora es más seguro, legible, modular y fácil de escalar.

