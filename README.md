# Funcionamiento del Conversor de Monedas

# Clase `RequestApi`

## Descripción

La clase `RequestApi` es responsable de realizar solicitudes a una API externa para obtener tasas de cambio de divisas. Proporciona un método que permite convertir una cantidad específica de una moneda a otra usando estas tasas.

## Métodos Clave

### `obtenerData(String busqueda, double valor, String cambio)`

- **Propósito**: Obtener el valor convertido de una moneda a otra.
- **Parámetros**:
  - `busqueda`: La moneda de origen (por ejemplo, "USD").
  - `valor`: La cantidad a convertir.
  - `cambio`: La moneda de destino (por ejemplo, "EUR").
- **Proceso**:
  1. Construye la URL para la solicitud a la API de tasas de cambio.
  2. Envía la solicitud y recibe la respuesta.
  3. Si la respuesta es exitosa (código 200), analiza el JSON para extraer la tasa de cambio.
  4. Calcula y devuelve el valor convertido.
- **Manejo de Errores**: Si la solicitud falla, imprime un mensaje de error y devuelve 0.0.

## Ejemplo de Uso

```java
RequestApi api = new RequestApi();
double resultado = api.obtenerData("USD", 1000.0, "EUR");
```

# Clase `HistorialArray`

## Descripción

La clase `HistorialArray` gestiona el historial de conversiones de monedas realizadas por el usuario. Permite almacenar los detalles de cada conversión y recuperar el historial en un formato legible.

## Métodos Clave

### `agregarHistorial(String busqueda, double valor, String cambio, double cambiofinal)`

- **Propósito**: Agregar un registro de conversión al historial.
- **Parámetros**:
  - `busqueda`: La moneda de origen.
  - `valor`: La cantidad convertida.
  - `cambio`: La moneda de destino.
  - `cambiofinal`: El resultado de la conversión.
- **Proceso**:
  1. Crea un `HashMap` para almacenar los detalles de la conversión.
  2. Agrega este mapa a una lista que representa el historial.
  3. Imprime un mensaje de confirmación.

### `getHistorial()`

- **Propósito**: Recuperar el historial de conversiones.
- **Proceso**:
  - Comprueba si el historial está vacío.
  - Si no lo está, itera sobre la lista y construye una cadena con las conversiones.
- **Devuelve**: Un `String` que contiene el historial de conversiones.

## Ejemplo de Uso

```java
HistorialArray historial = new HistorialArray();
historial.agregarHistorial("USD", 1000.0, "EUR", 850.50);
String historialString = historial.getHistorial();
```

# Clase `Main`

## Descripción

La clase `Main` es el punto de entrada de la aplicación del conversor de monedas. Su principal función es interactuar con el usuario, permitir la selección de conversiones y mostrar los resultados. También gestiona el historial de conversiones realizadas.

## Métodos Clave

### `main(String[] args)`

- **Propósito**: Configurar y ejecutar la aplicación.
- **Proceso**:
  1. **Inicialización**:
     - Crea instancias de `RequestApi` y `HistorialArray`.
     - Configura un `Scanner` para la entrada del usuario.
  2. **Menú de Opciones**:
     - Presenta un menú con varias opciones de conversión.

### Bucle `while`

- **Funcionalidad**:
  - Un bucle `while` se utiliza para permitir que el usuario realice múltiples conversiones hasta que decida salir de la aplicación.
  - La condición del bucle es `opcion != 0`, lo que significa que el bucle seguirá ejecutándose mientras el usuario no elija la opción de salir.

- **Proceso Dentro del Bucle**:
  1. **Mostrar el Menú**: Al inicio de cada iteración, se muestra el menú de opciones al usuario.
  2. **Lectura de Opción**: Se lee la opción elegida por el usuario usando `scanner.nextInt()`.
  3. **Manejo de Opciones**:
     - Utiliza un `switch` para manejar diferentes conversiones según la opción seleccionada.
     - Dependiendo de la opción, se establecen las monedas de origen y destino.
  4. **Conversión**:
     - Se solicita al usuario que ingrese el valor a convertir.
     - Llama al método `obtenerData` de `RequestApi` para obtener el resultado de la conversión.
     - Agrega la conversión al historial usando `HistorialArray`.
  5. **Salida de Resultados**: Muestra el resultado de la conversión al usuario.
  6. **Continuar o Salir**: Pide al usuario que presione Enter para continuar o verifica si desea salir.

- **Manejo de Errores**:
  - Si el usuario ingresa una opción no válida, se le notifica y se vuelve a mostrar el menú.

## Flujo de Uso

1. **Ejecutar la Aplicación**:
   - El usuario inicia la aplicación. Al hacerlo, se muestra un mensaje de bienvenida y el menú de opciones disponibles.

2. **Ver el Menú de Opciones**:
   - Se presenta un menú con varias conversiones disponibles. Por ejemplo:
  
   **************************************************************
   Bienvenido al conversor de monedas...
   A continuación tienes las siguientes conversiones disponibles:
   1) Dólar a Peso Argentino
   2) Peso Argentino a Dólar
   3) Dólar a Real brasileño
   4) Real brasileño a Dólar
   5) Dólar a Peso colombiano
   6) Peso colombiano a Dólar
   7) Dólar a Nuevo Sol
   8) Nuevo Sol a Dólar
   9) Ver historial de conversiones

   10) Salir

   Elige una opción válida:
   **************************************************************


3. **Seleccionar una Opción**:
- El usuario ingresa un número correspondiente a la conversión deseada, por ejemplo, `1` para convertir de Dólar a Peso Argentino.

4. **Ingresar el Valor a Convertir**:
- Se solicita al usuario que ingrese la cantidad que desea convertir:

    `Ingresa el valor a convertir:`

- El usuario escribe, por ejemplo, `1000`.

5. **Realizar la Conversión**:
- La aplicación utiliza el método `obtenerData` de la clase `RequestApi` para obtener la tasa de cambio actual y calcular el valor convertido.

6. **Mostrar el Resultado**:
- El resultado de la conversión se muestra al usuario:

    `El resultado es: 1000.0 USD equivalen a 850.50 ARS`


7. **Ver el Historial de Conversiones**:
- Si el usuario elige la opción `9`, puede ver un historial de todas las conversiones realizadas:

    `0 -- 1000.0 USD equivalen a 850.50 ARS`


8. **Continuar o Salir**:
- El usuario puede presionar Enter para continuar, elegir otra conversión o ingresar `0` para salir de la aplicación:

    `Saliendo... Gracias por usar el conversor de monedas.`