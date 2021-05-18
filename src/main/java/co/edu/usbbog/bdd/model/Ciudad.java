package co.edu.usbbog.bdd.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Ciudad {

	@Id
	private int id;
	
	private String nombre;

	public Ciudad() {
		super();
		this.id = id;
		this.nombre = nombre;
	}
	
	public Ciudad(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
