package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.collections.ListadoDeCarreras;
import ar.edu.unju.fi.model.Carrera;

@Controller
public class CarreraController {

	@Autowired
	Carrera nuevaCarrera;

	@GetMapping("/formularioCarrera")
	public ModelAndView getFormCarrera() {
		ModelAndView modelView=new ModelAndView("formCarrera");
		//agregar el objeto
		modelView.addObject("nuevaCarrera",nuevaCarrera);
		modelView.addObject("flag",false);
		return modelView;
	}

	@GetMapping("/mostrarCarreras")
	public ModelAndView listarLasCarreras() {
		//mostrar el listado
		ModelAndView modelView=new ModelAndView("listaDeCarreras");
		modelView.addObject("listadoCarreras",ListadoDeCarreras.listarCarreras());
		return modelView;
	}

	@GetMapping("/modificarCarrera/{codigo}")
	public ModelAndView editarCarrera(@PathVariable(name="codigo") String codigo) {
		//buscar
		Carrera c=ListadoDeCarreras.buscarCarrera(codigo);
		//mostrar el nuevo formulario
		ModelAndView modelView=new ModelAndView("formCarrera");	
		modelView.addObject("nuevaCarrera",c);
		modelView.addObject("flag",true);
		return modelView;
	}

	@PostMapping("/modificarCarrera")
	public ModelAndView modificarCarreraListado(@ModelAttribute("nuevaCarrera") Carrera c) {
		//guardar
		ListadoDeCarreras.modificarCarrera(c);
		//mostrar el listado
		ModelAndView modelView=new ModelAndView("listaDeCarreras");
		modelView.addObject("listadoCarreras",ListadoDeCarreras.listarCarreras());
		return modelView;
	}

	@PostMapping("/guardarCarrera")
	public ModelAndView saveCarrera(@ModelAttribute("nuevaCarrera") Carrera c) {
		//carrera a guardar
		ListadoDeCarreras.agregarCarrera(c);

		//mostrar el listado
		ModelAndView modelView=new ModelAndView("listaDeCarreras");
		modelView.addObject("listadoCarreras",ListadoDeCarreras.listarCarreras());
		return modelView;
	}

	@GetMapping("/eliminarCarrera/{codigo}")
	public ModelAndView borrarCarreraListado(@PathVariable(name="codigo") String codigo) {
		//borrar
		ListadoDeCarreras.eliminarCarrera(codigo);

		//mostrar el nuevo listado
		ModelAndView modelView=new ModelAndView("listaDeCarreras");
		modelView.addObject("listadoCarreras",ListadoDeCarreras.listarCarreras());		
		return modelView;
	}

}