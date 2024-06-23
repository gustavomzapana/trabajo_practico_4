package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.collections.ListadoDeDocentes;
import ar.edu.unju.fi.model.Docente;

@Controller
public class DocenteController {
	
	@Autowired
	Docente nuevoDocente;
	
	@GetMapping("/formularioDocente")
	public ModelAndView getFormDocente() {
		ModelAndView modelView=new ModelAndView("formDocente");
		//agregar el objeto
		modelView.addObject("nuevoDocente",nuevoDocente);
		modelView.addObject("flag",false);
		return modelView;
	}
	
	@GetMapping("/mostrarDocentes")
	public ModelAndView listarLosdocentes() {
		//mostrar el listado
		ModelAndView modelView=new ModelAndView("listaDeDocentes");
		modelView.addObject("listadoDocentes",ListadoDeDocentes.listarDocentes());
		return modelView;
	}
	
	@GetMapping("/modificarDocente/{legajo}")
	public ModelAndView editarDocente(@PathVariable(name="legajo") String legajo) {
		//buscar
		Docente d=ListadoDeDocentes.buscarDocente(legajo);
		//mostrar el nuevo formulario
		ModelAndView modelView=new ModelAndView("formDocente");	
		modelView.addObject("nuevoDocente",d);
		modelView.addObject("flag",true);
		return modelView;
	}
	
	@PostMapping("/modificarDocente")
	public ModelAndView modificarDocenteListado(@ModelAttribute("nuevoDocente") Docente d) {
		//guardar
		ListadoDeDocentes.modificarDocente(d);
		//mostrar el listado
		ModelAndView modelView=new ModelAndView("listaDeDocentes");
		modelView.addObject("listadoDocentes",ListadoDeDocentes.listarDocentes());
		return modelView;
	}
	
	@PostMapping("/guardarDocente")
	public ModelAndView saveDocente(@ModelAttribute("nuevoDocente") Docente d) {
		//carrera a guardar
		ListadoDeDocentes.agregarDocente(d);
		
		//mostrar el listado
		ModelAndView modelView=new ModelAndView("listaDeDocentes");
		modelView.addObject("listadoDocentes",ListadoDeDocentes.listarDocentes());
		return modelView;
	}
	
	@GetMapping("/eliminarDocente/{legajo}")
	public ModelAndView borrarDocenteListado(@PathVariable(name="legajo") String legajo) {
		//borrar
		ListadoDeDocentes.eliminarDocente(legajo);
		
		//mostrar el nuevo listado
		ModelAndView modelView=new ModelAndView("listaDeDocentes");
		modelView.addObject("listadoDocentes",ListadoDeDocentes.listarDocentes());		
		return modelView;
	}
	
}