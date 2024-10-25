package com.matiasrojas.controladores;

import com.matiasrojas.modelos.Cancion;

import com.matiasrojas.servicios.ServicioCanciones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ControladorCanciones {

    @Autowired
    private ServicioCanciones servicioCanciones;

    @GetMapping("/canciones")
    public String desplegarCanciones(Model model) {
        List<Cancion> listaCanciones = servicioCanciones.obtenerTodasLasCanciones();
        model.addAttribute("canciones", listaCanciones);
        return "canciones.jsp"; 
    }

    @GetMapping("/canciones/detalle/{id}")
    public String desplegarDetalleCancion(@PathVariable Long id, Model model) {
        Cancion cancion = servicioCanciones.obtenerCancionPorId(id);
        model.addAttribute("cancion", cancion);
        return "detalleCancion.jsp"; 
    }
}
