package com.matiasrojas.controladores;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.matiasrojas.modelos.Artista;
import com.matiasrojas.modelos.Cancion;
import com.matiasrojas.servicios.ServicioArtistas;
import com.matiasrojas.servicios.ServicioCanciones;

import jakarta.validation.Valid;

@Controller
public class ControladorCanciones {

    @Autowired private ServicioCanciones servicioCanciones;
    @Autowired private ServicioArtistas servicioArtistas;

    @GetMapping("/canciones")
    public String desplegarCanciones(Model model) {
        List<Cancion> canciones = servicioCanciones.obtenerTodasLasCanciones();
        model.addAttribute("canciones", canciones);
        return "canciones";
    }

    @GetMapping("/canciones/detalle/{idCancion}")
    public String desplegarDetalleCancion(@PathVariable("idCancion") Long idCancion, Model model) {
        Cancion cancion = servicioCanciones.obtenerCancionPorId(idCancion);
        if (cancion != null) {
            model.addAttribute("cancion", cancion);
            return "detalleCancion";
        }
        return "redirect:/canciones";
    }

    @GetMapping("/canciones/formulario/agregar")
    public String formularioAgregarCancion(Model model) {
        Cancion cancion = new Cancion();
        List<Artista> listaArtistas = servicioArtistas.obtenerTodosLosArtistas();
        model.addAttribute("cancion", cancion);
        model.addAttribute("artistas", listaArtistas);
        return "agregarCancion";
    }

    @PostMapping("/canciones/procesa/agregar")
    public String procesarAgregarCancion(
        @Valid @ModelAttribute("cancion") Cancion cancion,
        BindingResult result,
        @RequestParam("idArtista") Long idArtista,
        Model model,
        RedirectAttributes redirectAttributes) {
        
        if (result.hasErrors()) {
            List<Artista> listaArtistas = servicioArtistas.obtenerTodosLosArtistas();
            model.addAttribute("artistas", listaArtistas);
            return "agregarCancion";
        }
        
        Artista artista = servicioArtistas.obtenerArtistaPorId(idArtista);
        if (artista != null) {
            cancion.setArtista(artista);
            servicioCanciones.agregarCancion(cancion);
            redirectAttributes.addFlashAttribute("mensaje", "Canción agregada exitosamente");
            return "redirect:/canciones";
        } else {
            redirectAttributes.addFlashAttribute("error", "El artista seleccionado no es válido");
            return "redirect:/canciones/formulario/agregar";
        }
    }

    @GetMapping("/canciones/formulario/editar/{idCancion}")
    public String formularioEditarCancion(@PathVariable("idCancion") Long idCancion, Model model) {
        Cancion cancion = servicioCanciones.obtenerCancionPorId(idCancion);
        if (cancion != null) {
            model.addAttribute("cancion", cancion);
            return "editarCancion";
        }
        return "redirect:/canciones";
    }

    @PutMapping("/canciones/procesa/editar/{idCancion}")
    public String procesarEditarCancion(
        @Valid @ModelAttribute("cancion") Cancion cancion,
        BindingResult result,
        @PathVariable("idCancion") Long idCancion,
        Model model) {
        
        if (result.hasErrors()) {
            return "editarCancion";
        }
        
        cancion.setId(idCancion);
        servicioCanciones.actualizaCancion(cancion);
        return "redirect:/canciones";
    }

    @DeleteMapping("/canciones/procesa/eliminar/{idCancion}")
    public String procesarEliminarCancion(@PathVariable("idCancion") Long idCancion) {
        servicioCanciones.eliminarCancion(idCancion);
        return "redirect:/canciones";
    }
}
