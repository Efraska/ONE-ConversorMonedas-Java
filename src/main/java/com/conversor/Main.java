package com.conversor;

import com.conversor.config.ApiConfig;
import com.conversor.http.HttpClientExample;
import com.conversor.model.ExchangeRates;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Obtener la clave de API desde el archivo de configuración
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
            System.out.println("Tasas de cambio filtradas:");
            filteredRates.forEach((currency, rate) ->
                    System.out.println(currency + ": " + rate));
        } catch (RuntimeException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
