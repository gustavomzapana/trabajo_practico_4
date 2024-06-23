package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import ar.edu.unju.fi.model.Docente;

public class ListadoDeDocentes {
	public static List<Docente> ld = new ArrayList<Docente>();
	
	public static List<Docente> listarDocentes() {
		Predicate<Docente> disponible = d -> d.isEstado();		
		return ld.stream().filter(disponible).collect(Collectors.toList());
	}
	
	public static int buscarPosicionDocente(String legajo) {
		int p=-1;
		for (int i=0;i<ld.size() && p==-1;i++) {
			if (ld.get(i).getLegajo().equals(legajo)) {
				p=i;
			}
		}
		return p;
	}
	
	public static Docente buscarDocente(String legajo) {
		int p=buscarPosicionDocente(legajo);
		return (p!=-1) ? ld.get(p) : null;
	}
	
	public static void agregarDocente(Docente d) {
		d.setEstado(true);
		ld.add(d);
	}
	
	public static void modificarDocente(Docente d) {	
		int p=buscarPosicionDocente(d.getLegajo());
		if (p!=-1) {
			ld.set(p,d);
		}
	}
	
	public static void eliminarDocente(String legajo) {
		int p=buscarPosicionDocente(legajo);
		if (p!=-1) {
			ld.get(p).setEstado(false);		
		}
	}
	
}