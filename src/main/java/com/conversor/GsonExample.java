package com.conversor;

import com.google.gson.Gson;

public class GsonExample {
    public static void main(String[] args) {
        //Creando un objeto de ejemplo
        Persona persona = new Persona("Efrain", 35);

        // Convirtiendo el objeto a JSON
        Gson gson = new Gson();
        String json = gson.toJson(persona);

        System.out.println("Objeto en formato JSON: " + json);

        // Convertir el JSON de regreso a un objeto
        Persona personaDedeJson = gson.fromJson(json, Persona.class);
        System.out.println("Nombre: " + personaDedeJson.getNombre());
        System.out.println("Edad: " + personaDedeJson.getEdad());
    }
}

class Persona {
    private String nombre;
    private int edad;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }
}
