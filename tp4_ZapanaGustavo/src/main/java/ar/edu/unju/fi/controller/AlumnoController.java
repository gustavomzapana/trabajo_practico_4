package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.collections.ListadoDeAlumnos;
import ar.edu.unju.fi.model.Alumno;

@Controller
public class AlumnoController {
	
	@Autowired
	Alumno nuevoAlumno;
	
	@GetMapping("/formularioAlumno")
	public ModelAndView getFormAlumno() {
		ModelAndView modelView=new ModelAndView("formAlumno");
		//agregar el objeto
		modelView.addObject("nuevoAlumno",nuevoAlumno);
		modelView.addObject("flag",false);
		return modelView;
	}
	
	@GetMapping("/mostrarAlumnos")
	public ModelAndView listarLosAlumnos() {
		//mostrar el listado
		ModelAndView modelView=new ModelAndView("listaDeAlumnos");
		modelView.addObject("listadoAlumnos",ListadoDeAlumnos.listarAlumnos());
		return modelView;
	}
	
	@GetMapping("/modificarAlumno/{lu}")
	public ModelAndView editarAlumno(@PathVariable(name="lu") String lu) {
		//buscar
		Alumno a=ListadoDeAlumnos.buscarAlumno(lu);
		//mostrar el nuevo formulario
		ModelAndView modelView=new ModelAndView("formAlumno");	
		modelView.addObject("nuevoAlumno",a);
		modelView.addObject("flag",true);
		return modelView;
	}
	
	@PostMapping("/modificarAlumno")
	public ModelAndView modificarAlumnoListado(@ModelAttribute("nuevoAlumno") Alumno a) {
		//guardar
		ListadoDeAlumnos.modificarAlumno(a);
		//mostrar el listado
		ModelAndView modelView=new ModelAndView("listaDeAlumnos");
		modelView.addObject("listadoAlumnos",ListadoDeAlumnos.listarAlumnos());
		return modelView;
	}
	
	
	@PostMapping("/guardarAlumno")
	public ModelAndView saveAlumno(@ModelAttribute("nuevoAlumno") Alumno a) {
		//carrera a guardar
		ListadoDeAlumnos.agregarAlumno(a);
		
		//mostrar el listado
		ModelAndView modelView=new ModelAndView("listaDeAlumnos");
		modelView.addObject("listadoAlumnos",ListadoDeAlumnos.listarAlumnos());
		return modelView;
	}
	
	@GetMapping("/eliminarAlumno/{lu}")
	public ModelAndView borrarAlumnoListado(@PathVariable(name="lu") String lu) {
		//borrar
		ListadoDeAlumnos.eliminarAlumno(lu);
		
		//mostrar el nuevo listado
		ModelAndView modelView=new ModelAndView("listaDeAlumnos");
		modelView.addObject("listadoAlumnos",ListadoDeAlumnos.listarAlumnos());		
		return modelView;
	}
	
}