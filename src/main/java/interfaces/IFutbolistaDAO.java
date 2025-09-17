package interfaces;

import java.util.ArrayList;

import clases.Futbolista;

public interface IFutbolistaDAO {

	public int crear (Futbolista futbolista);
	public ArrayList<Futbolista> listar();
	public Futbolista obtener (int futbolistaId);
	public int actualizar (Futbolista futbolista);
	public int eliminar (int futbolistaId);
}
