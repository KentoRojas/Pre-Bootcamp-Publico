package com.matiasrojas.controladores;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;

@RestController
public class ControladorPeliculas {

    private static HashMap<String, String> listaPeliculas = new HashMap<>();

    public ControladorPeliculas() {
        listaPeliculas.put("Winnie the Pooh", "Don Hall");    
        listaPeliculas.put("El zorro y el sabueso", "Ted Berman");
        listaPeliculas.put("Tarzán", "Kevin Lima");        
        listaPeliculas.put("Mulán", "Barry Cook");
        listaPeliculas.put("Oliver", "Kevin Lima");    
        listaPeliculas.put("Big Hero 6", "Don Hall");    
    }

    @GetMapping("/peliculas")
    public String obtenerTodasLasPeliculas() {
        return listaPeliculas.keySet().toString();
    }

    @GetMapping("/peliculas/{nombre}")
    public String obtenerPeliculaPorNombre(@PathVariable String nombre) {
        if (listaPeliculas.containsKey(nombre)) {
            return "Película: " + nombre + ", Director: " + listaPeliculas.get(nombre);
        } else {
            return "La película no se encuentra en nuestra lista.";
        }
    }

    @GetMapping("/peliculas/director/{nombre}")
    public String obtenerPeliculasPorDirector(@PathVariable String nombre) {
        StringBuilder peliculasDelDirector = new StringBuilder();
        for (String pelicula : listaPeliculas.keySet()) {
            if (listaPeliculas.get(pelicula).equals(nombre)) {
                peliculasDelDirector.append(pelicula).append(", ");
            }
        }
        if (peliculasDelDirector.length() > 0) {
            return "Películas dirigidas por " + nombre + ": " + peliculasDelDirector.toString();
        } else {
            return "No contamos con películas con ese director en nuestra lista.";
        }
    }
}
