# Interfaz Map (HashMap / TreeMap)

- `Map` almacena pares clave → valor.
- `HashMap`:
  - Búsqueda, inserción y eliminación promedio O(1).
  - No mantiene orden de claves.
- `TreeMap`:
  - Mantiene claves ordenadas.
  - Operaciones en O(log n).
- Métodos clave: `put`, `get`, `remove`, `containsKey`, `keySet`, `values`.
- Recomendación: declarar como `Map<K,V>` y usar la implementación necesaria.
