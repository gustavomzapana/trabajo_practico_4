package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import ar.edu.unju.fi.model.Alumno;

public class ListadoDeAlumnos {
	public static List<Alumno> la = new ArrayList<Alumno>();
	
	public static List<Alumno> listarAlumnos() {
		Predicate<Alumno> disponible = a -> a.isEstado();		
		return la.stream().filter(disponible).collect(Collectors.toList());
	}
	
	public static int buscarPosicionAlumno(String codigo) {
		int p=-1;
		for (int i=0;i<la.size() && p==-1;i++) {
			if (la.get(i).getLu().equals(codigo)) {
				p=i;
			}
		}
		return p;
	}
	
	public static Alumno buscarAlumno(String lu) {
		int p=buscarPosicionAlumno(lu);
		return (p!=-1) ? la.get(p) : null;
	}
	
	public static void agregarAlumno(Alumno a) {
		a.setEstado(true);
		la.add(a);
	}
	
	public static void modificarAlumno(Alumno a) {	
		int p=buscarPosicionAlumno(a.getLu());
		if (p!=-1) {
			la.set(p,a);
		}
	}
	
	public static void eliminarAlumno(String lu) {
		int p=buscarPosicionAlumno(lu);
		if (p!=-1) {	
			la.get(p).setEstado(false);
		}
	}
	
}