package com.conversor.model;

import java.util.Map;

public class ExchangeRates {
    private String base_code; // Representa la moneda base
    private Map<String, Double> conversion_rates; // Contiene las tasas de conversión

    //Getters y Setters

    public String getBase_code() {
        return base_code;
    }

    public void setBase_code(String base_code) {
        this.base_code = base_code;
    }

    public Map<String, Double> getConversion_rates() {
        return conversion_rates;
    }

    public void setConversion_rates(Map<String, Double> conversion_rates) {
        this.conversion_rates = conversion_rates;
    }
}
