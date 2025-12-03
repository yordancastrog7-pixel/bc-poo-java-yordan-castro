# Interfaz List (ArrayList / LinkedList)

- `List` es una colección ordenada que permite duplicados.
- `ArrayList`:
  - Basado en un array dinámico.
  - Acceso por índice O(1).
  - Inserciones al final rápidas; en medio pueden ser costosas.
- `LinkedList`:
  - Basado en nodos enlazados.
  - Inserciones y eliminaciones en medio más eficientes.
  - Acceso por índice O(n).
- Usos típicos:
  - `ArrayList` para consultas frecuentes.
  - `LinkedList` para muchas inserciones/eliminaciones.
- Métodos comunes: `add`, `get`, `remove`, `size`, `contains`, `indexOf`.
