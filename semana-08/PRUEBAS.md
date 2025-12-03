# PRUEBAS - Semana 08 (Café Aroma)

1. Agregar Producto válido
   - Entrada: PR010, "Latte", 7000, 10, "BEBIDA"
   - Resultado esperado: Producto añadido y listado

2. Agregar Producto duplicado
   - Entrada: PR001 (ya existe)
   - Resultado: Error "Código duplicado"

3. Registrar Cliente y Crear Pedido
   - Entrada: Cliente C001, luego pedido con PR001 x2
   - Resultado: Pedido creado, stock reducido

4. Vender con stock insuficiente
   - Entrada: pedir 100 unidades de PR002 (stock 5)
   - Resultado: Error "Stock insuficiente" o mensaje claro

5. Listar estadísticas
   - Tras ventas, mostrar productos más vendidos con conteo