package com.conversor.monedas;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        RequestApi api = new RequestApi();
        float cambiofinal = api.obtenerData("USD", 1000.0f, "EUR");
        System.out.println(cambiofinal);
        HistorialArray historial = new HistorialArray();
        historial.agregarHistorial("USD", 1000.0f, "EUR", cambiofinal);
        System.out.println(historial.getHistorial());
        historial.agregarHistorial("USD", 1000.0f, "EUR", cambiofinal);
        System.out.println(historial.getHistorial());

        
        Scanner cantidadMoneda = new Scanner(System.in);
        Scanner opcion = new Scanner(System.in);
        
        while (condition) {
            
        }

    }
}