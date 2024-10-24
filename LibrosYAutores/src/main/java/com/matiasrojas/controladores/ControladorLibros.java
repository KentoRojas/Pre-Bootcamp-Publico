package com.matiasrojas.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

@Controller
public class ControladorLibros {

    private static HashMap<String, String> listaLibros = new HashMap<String, String>();

    public ControladorLibros() {
        listaLibros.put("Odisea", "Homero");
        listaLibros.put("Don Quijote de la Mancha", "Miguel de Cervantes");
        listaLibros.put("El Código Da Vinci", "Dan Brown");
        listaLibros.put("Alicia en el país de las maravillas", "Lewis Carroll");
        listaLibros.put("El Hobbit", "J.R.R. Tolkien");
        listaLibros.put("El alquimista", "Paulo Coelho");
    }

    @GetMapping("/libros")
    public String obtenerTodosLosLibros(Model model) {
        model.addAttribute("listaLibros", listaLibros.keySet());
        return "libros";
    }

    @GetMapping("/libros/{nombre}")
    public String obtenerInformacionDeLibro(@PathVariable String nombre, Model model) {
        String autor = listaLibros.get(nombre);
        if (autor != null) {
            model.addAttribute("nombreLibro", nombre);
            model.addAttribute("nombreAutor", autor);
            return "detalleLibro";
        } else {
            model.addAttribute("mensaje", "El libro no se encuentra en nuestra lista.");
            return "detalleLibro";
        }
    }

    @GetMapping("/libros/formulario")
    public String formularioLibro() {
        return "formularioLibros";
    }

    @PostMapping("/procesa/libro")
    public String procesaLibro(@RequestParam String nombreLibro, @RequestParam String nombreAutor) {
        listaLibros.put(nombreLibro, nombreAutor);
        return "redirect:/libros";
    }
}
