package com.matiasrojas.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;

@Controller
public class ControladorRecetas {
    private static String[] listaRecetas = {"Pizza", "Espagueti", "Lasaña"};
    private static HashMap<String, String[]> recetasConIngredientes = new HashMap<>();

    public ControladorRecetas() {
        String[] pizza = {"Pan", "Salsa de tomate", "Queso", "Pepperoni"};
        recetasConIngredientes.put("Pizza", pizza);
        String[] espagueti = {"Pasta", "Salsa de tomate", "Carne molida", "Queso parmesano"};
        recetasConIngredientes.put("Espagueti", espagueti);
        String[] lasaña = {"Pasta", "Salsa de tomate", "Queso", "Albahaca", "Espinaca", "Champiñones"};
        recetasConIngredientes.put("Lasaña", lasaña);
    }

    @GetMapping("/recetas")
    public String obtenerTodasLasRecetas(Model model) {
        model.addAttribute("listaRecetas", listaRecetas);
        return "recetas"; // Nombre de la vista JSP
    }

    @GetMapping("/recetas/{nombre}")
    public String obtenerRecetaPorNombre(@PathVariable String nombre, Model model) {
        String[] ingredientes = recetasConIngredientes.get(nombre);
        if (ingredientes != null) {
            model.addAttribute("nombreReceta", nombre);
            model.addAttribute("ingredientes", ingredientes);
            return "detalleReceta"; // Nombre de la vista JSP
        } else {
            model.addAttribute("mensaje", "La receta no se encuentra en nuestra lista.");
            return "detalleReceta"; // Redirigir al JSP de detalles con el mensaje
        }
    }
}
