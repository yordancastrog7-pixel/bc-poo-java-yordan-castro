# Jerarquía de Clases - Semana 04 (Cafetería Café Aroma)

## Diagrama

             ProductoCafe
                 |
        +--------+--------+
        |                 |
   CafeCaliente       CafeFrio


## Justificación
En la cafetería existen distintos tipos de café, pero todos comparten
atributos como nombre, precio y tamaño. Por ello se usa una clase padre
`ProductoCafe`.  
Las subclases `CafeCaliente` y `CafeFrio` representan categorías reales
del menú y permiten adaptar el cálculo del precio y la información mostrada.

## Atributos Heredados
- nombre
- precio
- tamano

## Métodos Sobrescritos
- mostrarInfo() → Cada tipo de café añade detalles propios
- calcularPrecioFinal() → Cada tipo ajusta el precio según sus reglas
