package com.conversor.monedas;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class RequestApi {
    
    public double obtenerData(String busqueda,double valor,String cambio) {

        String url = "https://v6.exchangerate-api.com/v6/5d104d91e71fd6d96acc8a8c/latest/" + busqueda;
        HttpClient client = HttpClient.newHttpClient();
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();
                    
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode()==200) {
                String body = response.body();
                JsonObject json = JsonParser.parseString(body).getAsJsonObject();
                JsonObject conversiones = json.get("conversion_rates").getAsJsonObject();
                float valorDeCambio = conversiones.get(cambio).getAsFloat();
                return valor * valorDeCambio;
            }
            else {
                System.out.println("Error1: " + response.statusCode());;
                return 0.0;
            }
        } catch (Exception e) {
            System.out.println("Error2: " + e.getMessage());
            return 0.0;
            }            
            
    }
}
