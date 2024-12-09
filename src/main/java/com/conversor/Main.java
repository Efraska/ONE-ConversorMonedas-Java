package com.conversor;

import com.conversor.config.ApiConfig;
import com.conversor.http.HttpClientExample;
import com.conversor.logic.CurrencyConverter;
import com.conversor.model.ExchangeRates;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Arte ASCII para el encabezado
        System.out.println("""
                 /$$$$$$                                                                                        /$$      /$$                                     /$$                   \s
                 /$$__  $$                                                                                      | $$$    /$$$                                    | $$                   \s
                | $$  \\__/  /$$$$$$  /$$$$$$$  /$$    /$$ /$$$$$$   /$$$$$$   /$$$$$$$  /$$$$$$   /$$$$$$       | $$$$  /$$$$  /$$$$$$  /$$$$$$$   /$$$$$$   /$$$$$$$  /$$$$$$   /$$$$$$$
                | $$       /$$__  $$| $$__  $$|  $$  /$$//$$__  $$ /$$__  $$ /$$_____/ /$$__  $$ /$$__  $$      | $$ $$/$$ $$ /$$__  $$| $$__  $$ /$$__  $$ /$$__  $$ |____  $$ /$$_____/
                | $$      | $$  \\ $$| $$  \\ $$ \\  $$/$$/| $$$$$$$$| $$  \\__/|  $$$$$$ | $$  \\ $$| $$  \\__/      | $$  $$$| $$| $$  \\ $$| $$  \\ $$| $$$$$$$$| $$  | $$  /$$$$$$$|  $$$$$$\s
                | $$    $$| $$  | $$| $$  | $$  \\  $$$/ | $$_____/| $$       \\____  $$| $$  | $$| $$            | $$\\  $ | $$| $$  | $$| $$  | $$| $$_____/| $$  | $$ /$$__  $$ \\____  $$
                |  $$$$$$/|  $$$$$$/| $$  | $$   \\  $/  |  $$$$$$$| $$       /$$$$$$$/|  $$$$$$/| $$            | $$ \\/  | $$|  $$$$$$/| $$  | $$|  $$$$$$$|  $$$$$$$|  $$$$$$$ /$$$$$$$/
                 \\______/  \\______/ |__/  |__/    \\_/    \\_______/|__/      |_______/  \\______/ |__/            |__/     |__/ \\______/ |__/  |__/ \\_______/ \\_______/ \\_______/|_______/\s
                                                                                                                                                                                        \s
                """);
        String apiKey = ApiConfig.getApiKey();
        String baseCurrency = "USD";

        try {
            // Obtener las tasas de cambio
            ExchangeRates exchangeRates = HttpClientExample.fetchExchangeRates(apiKey, baseCurrency);

            // Definir los códigos de moneda a filtrar
            List<String> currenciesToFilter = Arrays.asList("ARS", "BOB", "BRL", "CLP", "COP", "USD");

            // Filtrar las monedas
            Map<String, Double> filteredRates = HttpClientExample.filterCurrencies(exchangeRates, currenciesToFilter);

            // Configurar el menú interactivo
            Scanner scanner = new Scanner(System.in);
            boolean running = true;

            while (running) {
                System.out.println("\n--- Conversor de Monedas ---");
                System.out.println("1. Mostrar tasas de cambio disponibles");
                System.out.println("2. Realizar conversión de monedas");
                System.out.println("3. Salir");
                System.out.print("Selecciona una opción: ");
                int option = scanner.nextInt();
                scanner.nextLine(); // Consumir la nueva línea

                switch (option) {
                    case 1:
                        // Mostrar las tasas de cambio
                        System.out.println("\nTasas de cambio disponibles:");
                        filteredRates.forEach((currency, rate) ->
                                System.out.println(currency + ": " + rate));
                        break;

                    case 2:
                        // Solicitar datos para la conversión
                        System.out.print("Ingresa la moneda de origen (ej. USD): ");
                        String fromCurrency = scanner.nextLine().toUpperCase();

                        System.out.print("Ingresa la moneda de destino (ej. ARS): ");
                        String toCurrency = scanner.nextLine().toUpperCase();

                        System.out.print("Ingresa el monto a convertir: ");
                        double amount = scanner.nextDouble();

                        // Realizar la conversión
                        try {
                            double convertedAmount = CurrencyConverter.convert(filteredRates, fromCurrency, toCurrency, amount);
                            System.out.printf("Monto convertido: %.2f %s\n", convertedAmount, toCurrency);
                        } catch (IllegalArgumentException e) {
                            System.err.println("Error: " + e.getMessage());
                        }
                        break;

                    case 3:
                        // Salir del programa
                        System.out.println("¡Gracias por usar el conversor de monedas! Hasta pronto.");
                        running = false;
                        break;

                    default:
                        System.out.println("Opción no válida. Por favor, selecciona una opción del menú.");
                        break;
                }
            }

        } catch (RuntimeException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
