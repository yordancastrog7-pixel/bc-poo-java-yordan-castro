# Semana 07: Paquetes y Excepciones - Cafetería Café Aroma

## Información del Estudiante
- **Nombre:** [Eisin Yordan Castro Guerrero]
- **Ficha:** [3228970a]
- **Dominio:** Cafetería - Café Aroma
- **Fecha:** [02/02/2025]

## Descripción
Aplicación de ejemplo para gestionar el inventario de la cafetería. Incluye organización en paquetes, validaciones y manejo de excepciones personalizadas.

## Estructura de Paquetes
- `com.cafearoma.modelo` - Clases del dominio (Producto, Categoria)
- `com.cafearoma.servicio` - Lógica de negocio (InventarioServicio)
- `com.cafearoma.excepciones` - Excepciones personalizadas
- `com.cafearoma.Main` - Punto de entrada con casos de prueba

## Excepciones Personalizadas
1. `ProductoNoEncontradoException` (Checked) - Lanzada cuando se busca un producto inexistente.
2. `StockInvalidoException` (Checked) - Lanzada cuando se intenta vender más stock del disponible o cantidad inválida.

## Cómo compilar y ejecutar
Desde la carpeta `semana-07`:
```bash
# Compilar
javac -d bin src/com/cafearoma/modelo/*.java src/com/cafearoma/excepciones/*.java src/com/cafearoma/servicio/*.java src/com/cafearoma/*.java

# Ejecutar
java -cp bin com.cafearoma.Main
