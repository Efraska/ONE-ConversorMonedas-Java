package com.conversor.http;

import com.conversor.model.ExchangeRates;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HttpClientExample {

    public static ExchangeRates fetchExchangeRates(String apiKey, String baseCurrency) {
        // Crear un cliente HTTP
        HttpClient client = HttpClient.newHttpClient();

        // Construir la solicitud usando HttpRequestBuilder
        HttpRequest request = HttpRequestBuilder.buildGetRequest(apiKey, baseCurrency);

        try {
            // Enviar la solicitud y obtener la respuesta
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            // Procesar la respuesta
            int statusCode = response.statusCode();
            if (statusCode == 200) { // Verificar si el código de estado es 200 (OK)
                // Analizar el JSON con GSON
                Gson gson = new Gson();
                return gson.fromJson(response.body(), ExchangeRates.class);
            } else if (statusCode == 404) {
                throw new RuntimeException("Endpoint no encontrado. Código de estado: " + statusCode);
            } else {
                throw new RuntimeException("Error en la solicitud. Código de estado: " + statusCode);
            }
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Error al realizar la solicitud HTTP: " + e.getMessage());
        }
    }

    // Metodo para filtrar monedas
    public static Map<String, Double> filterCurrencies(ExchangeRates exchangeRates, List<String> currencyCodes) {
        Map<String, Double> filteredRates = new HashMap<>();
        Map<String, Double> conversionRates = exchangeRates.getConversion_rates();

        for (String code : currencyCodes) {
            if (conversionRates.containsKey(code)) {
                filteredRates.put(code, conversionRates.get(code));
            }
        }
        return filteredRates;
    }
}
