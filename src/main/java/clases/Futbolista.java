package clases;

public class Futbolista {

	private int futbolistaId;
	private	int paisId;
	private	String nombres;
	private	String apellidos;
	private	int goles;
	private	int asistencias;
	private	int partidos;
	private	String puesto;
	private	int edad;
	private	int equipoId;
	
	private String nombrePais; // solo para el dropdrown
	private String nombreEquipo; 
	
	public String codigoPais;
	
	public Futbolista(int futbolistaId, int paisId, String nombres, String apellidos, int goles, int asistencias,
			int	partidos, String puesto, int edad, int equipoId) {
		this.futbolistaId = futbolistaId;
		this.paisId = paisId;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.goles = goles;
		this.asistencias = asistencias;
		this.partidos = partidos;
		this.puesto = puesto;
		this.edad = edad;
		this.equipoId = equipoId;
	}


	public Futbolista(int paisId, String nombres, String apellidos, int goles, int asistencias, int partidos,
			String puesto, int edad, int equipoId) {
		this(0, paisId, nombres, apellidos, goles, asistencias, partidos, puesto, edad, equipoId);
	}


	public Futbolista() {
		this(0,0 , "", "", 0, 0, 0,"",0,0);
	
	}
	
	public Futbolista(String nombres, String apellidos, int goles, int asistencias, int partidos, String puesto, 
            int edad, String nombreEquipo, String nombrePais, String codigoPais) {
this(0, 0, nombres, apellidos, goles, asistencias, partidos, puesto, edad, 0);
this.nombreEquipo = nombreEquipo;
this.nombrePais = nombrePais;
this.codigoPais = codigoPais;
}
	
	public int getFutbolistaId() {
		return futbolistaId;
	}


	public void setFutbolistaId(int futbolistaId) {
		this.futbolistaId = futbolistaId;
	}





	public int getPaisId() {
		return paisId;
	}


	public void setPaisId(int paisId) {
		this.paisId = paisId;
	}


	public String getNombres() {
		return nombres;
	}


	public void setNombres(String nombres) {
		this.nombres = nombres;
	}


	public String getApellidos() {
		return apellidos;
	}


	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	public int getGoles() {
		return goles;
	}


	public void setGoles(int goles) {
		this.goles = goles;
	}


	public int getAsistencias() {
		return asistencias;
	}


	public void setAsistencias(int asistencias) {
		this.asistencias = asistencias;
	}


	public int getPartidos() {
		return partidos;
	}


	public void setPartidos(int partidos) {
		this.partidos = partidos;
	}


	public String getPuesto() {
		return puesto;
	}


	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}


	public int getEdad() {
		return edad;
	}


	public void setEdad(int edad) {
		this.edad = edad;
	}


	public int getEquipoId() {
		return equipoId;
	}


	public void setEquipoId(int equipoId) {
		this.equipoId = equipoId;
	}
	

	public String getNombrePais() {
		return nombrePais;
	}


	public void setNombrePais(String nombrePais) {
		this.nombrePais = nombrePais;
	}
	
	public String getNombreEquipo() {
		return nombreEquipo;
	}


	public void setNombreEquipo(String nombreEquipo) {
		this.nombreEquipo = nombreEquipo;
	}
	
	public String getCodigoPais() {
	    return codigoPais;
	}

	public void setCodigoPais(String codigoPais) {
	    this.codigoPais = codigoPais;
	}
	
}
