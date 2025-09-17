package clases;

public class Pais {
private int paisId;
private String codigoPais;
private String nombrePais;


public Pais(int paisId, String codigoPais, String nombrePais) {
	this.paisId = paisId;
	this.codigoPais = codigoPais;
	this.nombrePais = nombrePais;
}

public Pais(String codigoPais, String nombrePais) {
	this(0, codigoPais, nombrePais);
}

public Pais() {
	this(0, "", "");
}

public int getPaisId() {
	return paisId;
}

public void setPaisId(int paisId) {
	this.paisId = paisId;
}

public String getCodigoPais() {
	return codigoPais;
}

public void setCodigoPais(String codigoPais) {
	this.codigoPais = codigoPais;
}

public String getNombrePais() {
	return nombrePais;
}

public void setNombrePais(String nombrePais) {
	this.nombrePais = nombrePais;
} 


}