package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import ar.edu.unju.fi.model.Materia;

public class ListadoDeMaterias {
	public static List<Materia> lm = new ArrayList<Materia>();
	
	public static List<Materia> listarMaterias() {
		Predicate<Materia> disponible = m -> m.isEstado();		
		return lm.stream().filter(disponible).collect(Collectors.toList());
	}
	
	public static int buscarPosicionMateria(String codigo) {
		int p=-1;
		for (int i=0;i<lm.size() && p==-1;i++) {
			if (lm.get(i).getCodigo().equals(codigo)) {
				p=i;
			}
		}
		return p;
	}
	
	public static Materia buscarMateria(String codigo) {
		int p=buscarPosicionMateria(codigo);
		return (p!=-1) ? lm.get(p) : null;
	}
	
	public static void agregarMateria(Materia m) {		
		m.setEstado(true);
		m.setNombre(m.getNombre().toUpperCase());
		lm.add(m);
	}
	
	public static void modificarMateria(Materia m) {	
		int p=buscarPosicionMateria(m.getCodigo());
		if (p!=-1) {
			lm.set(p,m);
		}
	}
	
	public static void eliminarMateria(String codigo) {
		int p=buscarPosicionMateria(codigo);
		if (p!=-1) {
			lm.get(p).setEstado(false);
		}
	}
	
}