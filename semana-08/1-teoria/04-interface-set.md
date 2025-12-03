# Interfaz Set (HashSet / TreeSet)

- `Set` representa un conjunto sin elementos duplicados.
- `HashSet`:
  - No garantiza orden.
  - Operaciones típicas en O(1).
  - Ideal para chequear existencia y almacenar únicos.
- `TreeSet`:
  - Mantiene orden natural o por comparador.
  - Operaciones típicas en O(log n).
  - Útil cuando se requiere orden.
- Buenas prácticas:
  - Implementar `equals` y `hashCode` para objetos en `HashSet`.
  - Usar `TreeSet` cuando necesites datos ordenados.
