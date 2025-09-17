package fabrica;
import interfaces.IFutbolistaDAO;
import interfaces.IGoleadorDAO;
import interfaces.IPaisDAO;
import interfaces.IAsistidorDAO;
import interfaces.IEquipoDAO;


public abstract class DAOFactory {

	public static final int MYSQL = 1;
	public static final int ORACLE = 2;
	public static final int SQLSERVER = 3;
	public static final int POSGRESQL = 4;
	
	public static DAOFactory getDAOFactory() {
		return getDAOFactory(MYSQL); // qui debo definir con qué base de datos voy a trabajar
	}
	
	private static DAOFactory getDAOFactory(int db) {
		switch (db) {
			case MYSQL:
				return MySqlDAOFactory.getInstancia();
			case ORACLE:
				return null;
			case SQLSERVER:
				return null;
			case POSGRESQL:
				return null;
			default:
				return null;
		}
	}
	
	public abstract IFutbolistaDAO getFutbolistaDAO();
	public abstract IGoleadorDAO getGoleadorDAO();
	public abstract IAsistidorDAO getAsistenciaDAO();
	public abstract IEquipoDAO getEquipoDAO();
	public abstract IPaisDAO getPaisDAO();
	
}
