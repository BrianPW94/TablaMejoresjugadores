package fabrica;

import interfaces.IAsistidorDAO;
import interfaces.IEquipoDAO;
import interfaces.IFutbolistaDAO;
import interfaces.IGoleadorDAO;
import interfaces.IPaisDAO;

public class MySqlDAOFactory extends DAOFactory {

	//singleton
	
	private static MySqlDAOFactory instancia;

	public static MySqlDAOFactory getInstancia() {
		if (instancia == null) {
			instancia = new MySqlDAOFactory();
		}
		return instancia;
	}
	
	private MySqlDAOFactory() {
		
		
	}
	@Override
	public IFutbolistaDAO getFutbolistaDAO() {
		// TODO Auto-generated method stub
		return dao.FutbolistaDAO.getInstancia();
	}

	@Override
	public IGoleadorDAO getGoleadorDAO() {
		// TODO Auto-generated method stub
		return dao.GoleadorDAO.getInstancia();
	}

	@Override
	public IAsistidorDAO getAsistenciaDAO() {
		// TODO Auto-generated method stub
		return dao.AsistidorDAO.getInstancia();
	}

	@Override
	public IEquipoDAO getEquipoDAO() {
		// TODO Auto-generated method stub
		return dao.EquipoDAO.getInstancia();
	}

	@Override
	public IPaisDAO getPaisDAO() {
		// TODO Auto-generated method stub
		return dao.PaisDAO.getInstancia();
	}

}
