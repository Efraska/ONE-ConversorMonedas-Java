package com.conversor.http;

import java.net.URI;
import java.net.http.HttpRequest;

public class HttpRequestBuilder {
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/";

    public static HttpRequest buildGetRequest(String apiKey, String baseCurrency) {
        String endpoint = API_URL + apiKey + "/latest/" + baseCurrency;

        // Crear una solicitud GET personalizada
        return HttpRequest.newBuilder()
                .uri(URI.create(endpoint)) // Define el URI del endpoint
                .header("Accept", "application/json") //Configura el encabezado
                .GET() //Define el método HTTP como GET
                .build();
    }
}
