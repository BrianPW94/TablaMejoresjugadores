package clases;

public class Equipo {

	private int equipoId;
	private String nombre;
	
	
	public Equipo(int equipoId, String nombre) {
		this.equipoId = equipoId;
		this.nombre = nombre;
	}


	public Equipo(String nombre) {
		this(0, nombre);
	}
	
	public Equipo() {
		this(0, "");
	}


	public int getEquipoId() {
		return equipoId;
	}


	public void setEquipoId(int equipoId) {
		this.equipoId = equipoId;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
}
