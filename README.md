# Conversor de Monedas

## 📖 Descripción
El **Conversor de Monedas** es una aplicación interactiva en Java que permite realizar conversiones de moneda utilizando datos en tiempo real de tasas de cambio proporcionados por una API externa. Este proyecto fue desarrollado como parte del programa **ONE (Oracle Next Education)**, en el contexto de un desafío técnico para fortalecer habilidades en el desarrollo backend con Java.

## 🛠️ Características
- Conversión entre monedas basadas en tasas de cambio actualizadas.
- Interfaz interactiva en consola para que el usuario pueda seleccionar opciones y realizar conversiones fácilmente.
- Uso de la biblioteca Gson para manipular datos JSON.
- Filtrado de monedas seleccionadas: USD, ARS, BOB, BRL, CLP y COP.
- Implementación modular con clases y métodos claros y reutilizables.

## 🚀 Tecnologías utilizadas
- **Lenguaje:** Java (versión 11 o superior)
- **Biblioteca:** Gson para análisis JSON
- **Herramientas adicionales:** IntelliJ IDEA, Postman
- **API:** [ExchangeRate-API](https://www.exchangerate-api.com/)

## 📂 Estructura del proyecto
├── src │ ├── main │ │ ├── java │ │ │ ├── com │ │ │ │ ├── conversor │ │ │ │ │ ├── Main.java │ │ │ │ ├── config │ │ │ │ │ ├── ApiConfig.java │ │ │ │ ├── http │ │ │ │ │ ├── HttpClientExample.java │ │ │ │ │ ├── HttpRequestBuilder.java │ │ │ │ ├── model │ │ │ │ │ ├── ExchangeRates.java │ │ │ │ ├── logic │ │ │ │ │ ├── CurrencyConverter.java

## 📝 Instalación y ejecución
1. **Clonar el repositorio:**
   ```bash
   git clone https://github.com/tu-usuario/conversor-monedas.git
   cd conversor-monedas

   ## Configurar el archivo ApiConfig



## 🧪 Ejemplo de uso

1. Selecciona una opción del menú.
2. Ingresa las monedas de origen y destino.
3. Ingresa el monto a convertir.
4. Obtén el resultado de la conversión.

## 📈 Próximas mejoras

- Implementar una interfaz gráfica.
- Agregar soporte para más monedas.
- Mejorar el manejo de errores y validaciones.

## 🙌 Agradecimientos

Este proyecto fue desarrollado como parte del programa **ONE (Oracle Next Education)**.  
Agradezco a los mentores y compañeros por el apoyo brindado durante este aprendizaje.


