package com.matiasrojas.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.matiasrojas.modelos.Cancion;
import com.matiasrojas.servicios.ServicioCanciones;

import jakarta.validation.Valid;

@Controller
public class ControladorCanciones {
	@Autowired private ServicioCanciones servicioCanciones;
	
	@GetMapping("/canciones")
	public String desplegarCanciones(Model model) {
	    List<Cancion> canciones = servicioCanciones.obtenerTodasLasCanciones();
	    model.addAttribute("canciones", canciones);
	    return "canciones.jsp";
	}	
	@GetMapping("/canciones/detalle/{idCancion}")
	public String desplegarDetalleCancion(@PathVariable("idCancion") Long idCancion, Model model) {
	    Cancion cancion = servicioCanciones.obtenerCancionPorId(idCancion);
	    if (cancion != null) {
	        model.addAttribute("cancion", cancion);
	        return "detalleCancion.jsp";
	    }
		return null;
		}
	@GetMapping("/canciones/formulario/agregar/{idCancion}")
	public String formularioAgregarCancion(@PathVariable("idCancion") Long idCancion, Model model) {
	    Cancion cancion = new Cancion();  
	    model.addAttribute("cancion", cancion);
	    return "agregarCancion.jsp";
	}
	@PostMapping("/canciones/procesa/agregar")
    public String procesarAgregarCancion(
        @Valid @ModelAttribute("cancion") Cancion cancion,
        BindingResult result,
        Model model) {
        
        if (result.hasErrors()) {
            return "agregarCancion.jsp";
        }
        servicioCanciones.agregarCancion(cancion);
        return "redirect:/canciones";
    }
	 @GetMapping("/canciones/formulario/editar/{idCancion}")
	    public String formularioEditarCancion(@PathVariable("idCancion") Long idCancion, Model model) {
	        Cancion cancion = servicioCanciones.obtenerCancionPorId(idCancion);
	        if (cancion != null) {
	            model.addAttribute("cancion", cancion);
	            return "editarCancion.jsp";
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
	            return "editarCancion.jsp";
	        }
	        
	        cancion.setId(idCancion);
	        servicioCanciones.actualizaCancion(cancion);
	        return "redirect:/canciones";
	    }
}