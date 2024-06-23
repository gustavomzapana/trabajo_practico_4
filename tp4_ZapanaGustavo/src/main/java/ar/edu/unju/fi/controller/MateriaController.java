package ar.edu.unju.fi.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.collections.ListadoDeCarreras;
import ar.edu.unju.fi.collections.ListadoDeDocentes;
import ar.edu.unju.fi.collections.ListadoDeMaterias;
import ar.edu.unju.fi.model.Materia;

@Controller
public class MateriaController {

	@Autowired
	Materia nuevaMateria;

	@GetMapping("/formularioMateria")
	public ModelAndView getFormMateria() {
		ModelAndView modelView=new ModelAndView("formMateria");
		//agregar el objeto
		modelView.addObject("nuevaMateria",nuevaMateria);
		modelView.addObject("listadoDocentes",ListadoDeDocentes.listarDocentes());
		modelView.addObject("listadoCarreras",ListadoDeCarreras.listarCarreras());
		modelView.addObject("flag",false);
		return modelView;
	}

	@PostMapping("/guardarMateria")
	public ModelAndView saveMateria(@ModelAttribute("nuevaCarrera") Materia m) {
		//guardar
		m.setDocente(ListadoDeDocentes.buscarDocente(m.getDocente().getLegajo()));
		m.setCarrera(ListadoDeCarreras.buscarCarrera(m.getCarrera().getCodigo()));
		ListadoDeMaterias.agregarMateria(m);

		//mostrar el listado
		ModelAndView modelView=new ModelAndView("listaDeMaterias");
		modelView.addObject("listadoMaterias",ListadoDeMaterias.listarMaterias());
		return modelView;
	}

	@GetMapping("/mostrarMaterias")
	public ModelAndView listarLasMaterias() {
		//mostrar el listado
		ModelAndView modelView=new ModelAndView("listaDeMaterias");
		modelView.addObject("listadoMaterias",ListadoDeMaterias.listarMaterias());
		return modelView;
	}

	@GetMapping("/modificarMateria/{codigo}")
	public ModelAndView editarMateria(@PathVariable(name="codigo") String codigo) {
		//buscar
		Materia m=ListadoDeMaterias.buscarMateria(codigo);
		//mostrar el nuevo formulario
		ModelAndView modelView=new ModelAndView("formMateria");	
		modelView.addObject("nuevaMateria",m);
		modelView.addObject("flag",true);
		modelView.addObject("listadoDocentes",ListadoDeDocentes.listarDocentes());
		modelView.addObject("listadoCarreras",ListadoDeCarreras.listarCarreras());
		return modelView;
	}

	@PostMapping("/modificarMateria")
	public ModelAndView modificarMateriaListado(@ModelAttribute("nuevaMateria") Materia m) {
		//entidades a guardar
		m.setDocente(ListadoDeDocentes.buscarDocente(m.getDocente().getLegajo()));
		m.setCarrera(ListadoDeCarreras.buscarCarrera(m.getCarrera().getCodigo()));
		ListadoDeMaterias.modificarMateria(m);
		//mostrar el listado
		ModelAndView modelView=new ModelAndView("listaDeMaterias");
		modelView.addObject("listadoMaterias",ListadoDeMaterias.listarMaterias());
		return modelView;
	}

	@GetMapping("/eliminarMateria/{codigo}")
	public ModelAndView borrarMateriaListado(@PathVariable(name="codigo") String codigo) {
		//borrar
		ListadoDeMaterias.eliminarMateria(codigo);

		//mostrar el nuevo listado
		ModelAndView modelView=new ModelAndView("listaDeMaterias");
		modelView.addObject("listadoMaterias",ListadoDeMaterias.listarMaterias());
		return modelView;
	}

}