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
        String apiKey = ApiConfig.getApiKey();
        String baseCurrency = "USD";

        try {
            // Obtener las tasas de cambio
            ExchangeRates exchangeRates = HttpClientExample.fetchExchangeRates(apiKey, baseCurrency);

            // Definir los códigos de moneda a filtrar
            List<String> currenciesToFilter = Arrays.asList("ARS", "BOB", "BRL", "CLP", "COP", "USD");

            // Filtrar las monedas
            Map<String, Double> filteredRates = HttpClientExample.filterCurrencies(exchangeRates, currenciesToFilter);

            // Mostrar las tasas de cambio filtradas
            System.out.println("Tasas de cambio disponibles:");
            filteredRates.forEach((currency, rate) ->
                    System.out.println(currency + ": " + rate));

            // Solicitar al usuario datos para la conversión
            Scanner scanner = new Scanner(System.in);

            System.out.print("\nIngresa la moneda de origen (ej. USD): ");
            String fromCurrency = scanner.nextLine().toUpperCase();

            System.out.print("Ingresa la moneda de destino (ej. ARS): ");
            String toCurrency = scanner.nextLine().toUpperCase();

            System.out.print("Ingresa el monto a convertir: ");
            double amount = scanner.nextDouble();

            // Realizar la conversión
            double convertedAmount = CurrencyConverter.convert(filteredRates, fromCurrency, toCurrency, amount);

            System.out.printf("Monto convertido: %.2f %s\n", convertedAmount, toCurrency);

        } catch (RuntimeException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
