# Iteradores y bucles para colecciones

- Formas de recorrer colecciones:
  - `for (Elemento e : coleccion)` → for-each (simple y seguro).
  - `for (int i = 0; i < list.size(); i++)` → cuando necesitas índice.
  - `Iterator<T> it = coleccion.iterator()` → para eliminar durante recorrido.
- Uso de `Iterator`:
  - `Iterator<T> it = set.iterator();`
  - `while (it.hasNext()) { T x = it.next(); if(cond) it.remove(); }`
- Streams (Java 8+): `coleccion.stream().filter(...).collect(...)` para filtrado y transformación.
- Buenas prácticas:
  - No modificar la colección directamente dentro de un for-each (usa iterator.remove()).
  - Preferir for-each para lectura simple.
