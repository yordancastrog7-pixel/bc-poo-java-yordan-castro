Sistema: Gestión de Cafetería – Café Aroma


1. Identificación de Abstracciones
1.1 Clase Abstracta Principal
Nombre: Bebida
¿Por qué es abstracta?

Elegí convertir Bebida en una clase abstracta porque:

Representa un concepto general dentro del dominio: todas las bebidas del café.

Comparte atributos comunes: nombre, precio base, tamaño.

Todas las bebidas deben poder calcular su precio final, pero la forma de calcularlo varía según el tipo de bebida.

Ej.: en un café depende de los extras (leche, jarabe),

en un té depende de la intensidad o tipo de hierbas.

Necesito comportamiento genérico + comportamiento obligatorio, y eso se logra solo con una clase abstracta.

Atributos protegidos (protected):

protected String nombre;

protected double precioBase;

protected String tamano;

Método abstracto:

public abstract double calcularPrecioFinal();

Cada subclase lo implementa diferente.

Método concreto:

public void mostrarInformacion()

Imprime nombre, tamaño y precio base.

Jerarquía
             <<abstract>>
                 Bebida
              /             \
        CafeEspecial       TeOrganico

2. Interfaces Implementadas
2.1 Interface 1: Preparacion
Capacidad que define

Representa la habilidad de preparar un producto.
Permite que diferentes bebidas describan los pasos de preparación.

Métodos:

preparar()

servir()

Clases que la implementan
Clase	Justificación
CafeEspecial	Requiere describir preparación: molienda, extracción, espumado, etc.
TeOrganico	Describe infusión, reposo y filtrado.
2.2 Interface 2: Personalizable
Capacidad que define

Permite que una bebida agregue o modifique ciertos elementos (extras).

Métodos:

agregarExtra(String extra, double costo)

listarExtras()

Clases que la implementan
Clase	Razón
CafeEspecial	Se permiten jarabes, leches, toppings.
TeOrganico	Puede agregarse miel, limón, hierbas adicionales.
2.3 Interface 3 (Opcional): Descontable
Capacidad que define

Permite aplicar descuento según políticas del café.

Métodos:

double aplicarDescuento(double porcentaje);

boolean esElegibleDescuento();

Clases que la implementan
Clase	Razón
CafeEspecial	Bebidas especiales pueden entrar a promociones.
TeOrganico	Promociones de bebidas saludables.
3. Decisiones de Diseño
3.1 ¿Por qué Clase Abstracta y no Interface?

Elegí que Bebida sea clase abstracta porque:

Existe una clara relación “es un”:

Café es una bebida

Té es una bebida

Comparten atributos reales, por ejemplo precioBase, que NO pueden existir en una interfaz.

Se necesitaba compartir métodos con implementación real (mostrar información).

Por eso abstract class es la opción correcta.

3.2 ¿Por qué interfaces para comportamientos?

Elegí interfaces porque:

Son capacidades independientes del tipo de bebida.

Una bebida puede:

Prepararse

Personalizarse

Tener descuento
sin necesidad de pertenecer a una misma jerarquía.

Las interfaces permiten múltiple implementación, reforzando la flexibilidad del sistema.

4. Principios SOLID Aplicados
✔ Single Responsibility Principle (SRP)

Cada clase tiene una responsabilidad clara:

Bebida: define estructura general.

CafeEspecial: calcula precio según extras.

TeOrganico: calcula precio según preparación e infusión.

Interfaces definen capacidades concretas (preparar, personalizar, descontar).

✔ Open/Closed Principle (OCP)

El sistema es extensible sin modificar código existente.
Puedo crear:

ChocolateCaliente

Smoothie

Frappuccino

simplemente extendiendo Bebida o implementando las interfaces.

✔ Liskov Substitution Principle (LSP)

Cualquier subclase de Bebida puede usarse como Bebida,
porque todas implementan:

calcularPrecioFinal()

mostrarInformacion()

Esto permite usar polimorfismo en listas de tipo Bebida.

✔ Interface Segregation Principle (ISP)

Cada interfaz define un conjunto limitado de métodos, no obliga a implementar cosas innecesarias.

Preparación → solo métodos de preparación

Personalización → solo extras

Descuentable → solo descuentos

No hay interfaces gigantes que obliguen a clases a implementar métodos inútiles.

✔ Dependency Inversion Principle (DIP)

El Main depende de abstracciones, no de clases concretas:

Lista de Bebida

Referencias de tipo Preparacion, Personalizable, Descontable

Esto reduce el acoplamiento.

5. Mejoras Logradas
Antes (Semana 05)

Sistema funcional pero limitado.

Clases concretas con poca organización y sin separación clara de responsabilidades.

No había abstracción general.

No había comportamientos reutilizables.

Era difícil agregar nuevas bebidas sin modificar código previo.

Después (Semana 06)

Se creó una estructura profesional orientada a objetos.

Se implementó el núcleo abstracto del sistema: Bebida.

Se agregaron interfaces reutilizables para capacidades comunes.

Se logró polimorfismo real en el Main.

El código ahora es escalable, ordenado y extensible.

Endiende SOLID y diseño extensible.

6. Diagrama de Clases
                          <<interface>>
                           Preparacion
                                 |
                          ---------------
                          |             |
                 CafeEspecial     TeOrganico
                          |             |
             <<abstract>> Bebida
                          |
                 <<interface>> Personalizable
                          |
                 <<interface>> Descontable

7. Desafíos y Soluciones
Desafío 1: Elegir la clase abstracta correcta

Solución: Analicé las bebidas del menú y verifiqué que todas compartieran atributos y comportamiento esencial.

Desafío 2: Evitar interfaces demasiado grandes

Solución: Dividí “capacidades” en interfaces pequeñas: preparación, personalización y descuento.

Desafío 3: Manejo del precio final

Solución: Cada subclase implementa su propio cálculo, cumpliendo polimorfismo.

Desafío 4: Implementación múltiple

Solución: Definí interfaces específicas y simples, lo que facilita que una clase implemente varias sin conflictos.

8. Próximos Pasos

Agregar nuevas bebidas como Smoothies o Frappés.

Implementar una interfaz adicional para “Calificable”.

Crear un módulo de inventario.

Integrar sistema de pedidos con historial.

Refinar descuentos según días u horarios