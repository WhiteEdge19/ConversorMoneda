package com.conversor.monedas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HistorialArray {
    List<HashMap<String,String>> historial = new ArrayList<>();

    public void agregarHistorial(String busqueda,double valor,String cambio,double cambiofinal){
        HashMap<String,String> historialMap = new HashMap<>();
        historialMap.put("busqueda",busqueda);
        historialMap.put("valor",String.valueOf(valor));
        historialMap.put("cambio",cambio);
        historialMap.put("resultado",String.format("%.2f",cambiofinal));
        historial.add(historialMap);
        System.out.println("Historial agregado");        
    }

    public String getHistorial(){
        if (historial.isEmpty()) {
            return "No hay historial";            
        }
        String historialString = "";
        for (int i = 0; i < historial.size(); i++) {
            historialString += i +" -- "+ " "+historial.get(i).get("valor") +" "+ historial.get(i).get("busqueda")+" equivalen a "+" "+historial.get(i).get("resultado")+" "+ historial.get(i).get("cambio")+"\n";
        }
        return historialString;
    }
}
