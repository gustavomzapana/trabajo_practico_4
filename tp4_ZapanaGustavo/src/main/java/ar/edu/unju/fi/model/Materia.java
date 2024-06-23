package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

@Component
public class Materia {
	private String codigo;
	private String nombre;
	private String curso;
	private int duracion;
	private boolean modalidad;
	private Docente docente;
	private Carrera carrera;
	private boolean estado;
	
	public Materia() {
		// TODO Auto-generated constructor stub
	}

	public Materia(String codigo, String nombre, String curso, int duracion, boolean modalidad, Docente docente, Carrera carrera, boolean estado) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.curso = curso;
		this.duracion = duracion;
		this.modalidad = modalidad;
		this.docente = docente;
		this.carrera = carrera;
		this.estado = estado;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
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

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public boolean isModalidad() {
		return modalidad;
	}

	public void setModalidad(boolean modalidad) {
		this.modalidad = modalidad;
	}

	public Docente getDocente() {
		return docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}

	public Carrera getCarrera() {
		return carrera;
	}

	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}

	@Override
	public String toString() {
		return "Materia [codigo=" + codigo + ", nombre=" + nombre + ", curso=" + curso + ", duracion=" + duracion
				+ ", modalidad=" + modalidad + ", docente=" + docente + ", carrera=" + carrera + ", estado=" + estado
				+ "]";
	}
	
}