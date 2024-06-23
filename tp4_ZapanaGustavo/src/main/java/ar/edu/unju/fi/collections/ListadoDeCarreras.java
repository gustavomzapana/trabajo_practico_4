package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import ar.edu.unju.fi.model.Carrera;

public class ListadoDeCarreras {
	public static List<Carrera> lc = new ArrayList<Carrera>();
	
	public static List<Carrera> listarCarreras() {
		Predicate<Carrera> disponible = c -> c.isEstado();		
		return lc.stream().filter(disponible).collect(Collectors.toList());
	}
	
	public static int buscarPosicionCarrera(String codigo) {
		int p=-1;
		for (int i=0;i<lc.size() && p==-1;i++) {
			if (lc.get(i).getCodigo().equals(codigo)) {
				p=i;
			}
		}
		return p;
	}
	
	public static Carrera buscarCarrera(String codigo) {
		int p=buscarPosicionCarrera(codigo);
		return (p!=-1) ? lc.get(p) : null;
	}
	
	public static void agregarCarrera(Carrera c) {		
		c.setEstado(true);
		c.setNombre(c.getNombre().toUpperCase());
		lc.add(c);
	}
	
	public static void modificarCarrera(Carrera c) {	
		int p=buscarPosicionCarrera(c.getCodigo());
		if (p!=-1) {
			lc.set(p,c);
		}		
	}
	
	public static void eliminarCarrera(String codigo) {
		int p=buscarPosicionCarrera(codigo);
		if (p!=-1) {			
			lc.get(p).setEstado(false);
		}
	}
	
}