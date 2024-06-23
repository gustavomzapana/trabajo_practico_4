package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

@Component
public class Carrera {
	private String codigo;
	private String nombre;
	private int duracion;
	private boolean estado;
	
	public Carrera() {
	// TODO Auto-generated constructor stub
	}

	public Carrera(String codigo, String nombre, int duracion, boolean estado) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.duracion = duracion;
		this.estado = estado;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Carrera [codigo=" + codigo + ", nombre=" + nombre + ", duracion=" + duracion + ", estado=" + estado
				+ "]";
	}

}