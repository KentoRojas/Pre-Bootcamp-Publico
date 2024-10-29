package com.matiasrojas.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.matiasrojas.modelos.Artista;
import com.matiasrojas.servicios.ServicioArtistas;

import jakarta.validation.Valid;

@Controller	
public class ControladorArtistas {
	@Autowired
    private ServicioArtistas servicioArtistas;

	@GetMapping("/artistas")
	public String desplegarArtistas(Model model) {
	    model.addAttribute("artistas", servicioArtistas.obtenerTodosLosArtistas());
	    return "artistas";
	}

    @GetMapping("/artistas/detalle/{idArtista}")
    public String desplegarDetalleArtista(@PathVariable("idArtista") Long idArtista, Model model) {
        Artista artista = servicioArtistas.obtenerArtistaPorId(idArtista);
        if (artista != null) {
            model.addAttribute("artista", artista);
            return "detalleArtista";
        } else {
            return "redirect:/artistas";
        }
    }

    @GetMapping("/artistas/formulario/agregar")
    public String formularioAgregarArtista(Model model) {
        model.addAttribute("artista", new Artista());
        return "agregarArtista";
    }

    @PostMapping("/artistas/procesa/agregar")
    public String procesarAgregarArtista(@Valid @ModelAttribute("artista") Artista artista,
                                         BindingResult result, Model model,
                                         RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "agregarArtista";
        }
        servicioArtistas.agregarArtista(artista);
        redirectAttributes.addFlashAttribute("mensaje", "Artista agregado exitosamente");
        return "redirect:/artistas";
    }
	
}
