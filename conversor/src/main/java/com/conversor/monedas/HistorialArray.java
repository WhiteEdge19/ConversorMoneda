package com.conversor.monedas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HistorialArray {
    List<HashMap<String,String>> historial = new ArrayList<>();

    public void agregarHistorial(String busqueda,float valor,String cambio,float resultado){
        HashMap<String,String> historialMap = new HashMap<>();
        historialMap.put("busqueda",busqueda);
        historialMap.put("valor",String.valueOf(valor));
        historialMap.put("cambio",cambio);
        historialMap.put("resultado",String.valueOf(resultado));
        historial.add(historialMap);
        System.out.println("Historial agregado");        
    }

    public String getHistorial(){
        String historialString = "";
        for (int i = 0; i < historial.size(); i++) {
            historialString += historial.get(i).get("busqueda")+" "+historial.get(i).get("valor")+" "+historial.get(i).get("cambio")+" "+historial.get(i).get("resultado")+"\n";
        }
        return historialString;
    }
}
