package com.conversor.monedas;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        RequestApi api = new RequestApi();
        double cambiofinal = 0.0;       
        HistorialArray historial = new HistorialArray(); 
        Scanner scanner = new Scanner(System.in);
        String monedaInicial = "USD";
        String monedaFinal = "PEN";
        double cantidad = 0.0;
        int opcion = 1000;        

        String menu = """
                **************************************************************
                Bienvenido al conversor de monedas...
                A continuacion tienes las siguientes conversiones disponibles:
                1) Dólar a Peso Argentino
                2) Peso Argentino a Dolar
                3) Dólar a Real brasileño
                4) Real brasileño a Dolar
                5) Dólar a Peso colombiano
                6) Peso colombiano a Dolar
                7) Dolar a Nuevo Sol
                8) Nuevo Sol a Dolar
                9) Ver historial de conversiones

                0) Salir

                Elije una opcion valida:
                **************************************************************
                """;
        
        while (opcion != 0) {
            System.out.println(menu);
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    monedaInicial = "USD";
                    monedaFinal = "ARS";
                    break;
                case 2:
                    monedaInicial = "ARS";
                    monedaFinal = "USD";
                    break;
                case 3:
                    monedaInicial = "USD";
                    monedaFinal = "BRL";
                    break;
                case 4:
                    monedaInicial = "BRL";
                    monedaFinal = "USD";
                    break;
                case 5:
                    monedaInicial = "USD";
                    monedaFinal = "COP";
                    break;
                case 6:
                    monedaInicial = "COP";
                    monedaFinal = "USD";
                    break;
                case 7:
                    monedaInicial = "USD";
                    monedaFinal = "PEN";
                    break;
                case 8:
                    monedaInicial = "PEN";
                    monedaFinal = "USD";
                    break;
                case 9:
                    System.out.println(historial.getHistorial());
                    System.out.println("Ingresa enter para continuar");
                    scanner.nextLine();
                    scanner.nextLine();
                    continue;
                default:
                    if (opcion == 0) {
                        System.out.println("Saliendo...");
                        System.out.println("Gracias por usar el conversor de monedas");
                        scanner.close();
                        continue;
                    }
                    System.out.println("Opcion no valida");
                    continue;
            }

            System.out.println("Ingresa el valor a convertir: ");
            cantidad = scanner.nextDouble();
            cambiofinal = api.obtenerData(monedaInicial, cantidad, monedaFinal);
            historial.agregarHistorial(monedaInicial, cantidad, monedaFinal, cambiofinal);
            System.out.println("El resultado es: "+ cantidad + " " + monedaInicial + " equivalen a " + String.format("%.2f",cambiofinal) + " " + monedaFinal) ;
            System.out.println("Ingresa enter para continuar");
            scanner.nextLine();
            scanner.nextLine();

        }

    }
}