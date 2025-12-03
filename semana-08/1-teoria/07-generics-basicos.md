# Genéricos básicos (Generics) en Java

- Los genéricos permiten parametrizar tipos: `List<String>`, `Map<String, Producto>`.
- Ventajas:
  - Seguridad de tipos en tiempo de compilación.
  - Evita casts explícitos.
  - Código reutilizable y limpio.
- Sintaxis:
  - Clase genérica: `class Repo<T> { ... }`
  - Método genérico: `public <T> void proc(T t) { ... }`
- Wildcards:
  - `?` comodín: `List<?>`
  - `? extends T` (covarianza) → lectura segura
  - `? super T` (contravarianza) → escritura segura
- Buenas prácticas:
  - Usar genéricos siempre que sea posible para colecciones.
  - Evitar raw types (`List` sin `<T>`).
