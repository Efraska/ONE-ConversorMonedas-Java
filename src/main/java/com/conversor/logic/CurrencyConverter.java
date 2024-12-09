package com.conversor.logic;

import java.util.Map;

public class CurrencyConverter {
    public static double convert(Map<String, Double> rates, String fromCurrency, String toCurrency, double amount) {
        if (!rates.containsKey(fromCurrency) || !rates.containsKey(toCurrency)) {
            throw new IllegalArgumentException("Moneda no soportada: " + fromCurrency + " o " + toCurrency);
        }

        double rateFromBase = rates.get(fromCurrency); // Tasa de cambio de la moneda base a la moneda de origen
        double rateToBase = rates.get(toCurrency);    // Tasa de cambio de la moneda base a la moneda de destino

        // Realizar la conversión
        return (amount / rateFromBase) * rateToBase;
    }
}
