package interfaces;

import java.util.ArrayList;

import clases.Equipo;

public interface IEquipoDAO {

	public int crear (Equipo equipo);
	public ArrayList<Equipo> listar();
	public Equipo obtener (int equipoId);
	public int actualizar (Equipo equipo);
	public int eliminar (int equipoId);

}
