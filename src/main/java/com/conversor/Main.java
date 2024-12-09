package com.conversor;

import com.conversor.config.ApiConfig;

public class Main {
    public static void main(String[] args) {
        String apiKey = ApiConfig.getApiKey();
        System.out.println("Clave de API cargada: " + apiKey);
    }
}
