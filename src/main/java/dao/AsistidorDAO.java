package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import BaseDatos.MySQLConexion;
import clases.Futbolista;
import interfaces.IAsistidorDAO;

public class AsistidorDAO implements IAsistidorDAO {

	private static IAsistidorDAO instancia;
	
	public static IAsistidorDAO getInstancia() {
		
		if(instancia == null){
			instancia = new AsistidorDAO();
		}
		return instancia;
	}
	
	private AsistidorDAO() {
		
	}
	@Override
	public ArrayList<Futbolista> listar() {
		ArrayList<Futbolista> lista = new ArrayList<Futbolista>();
		Connection cone = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			
			cone = MySQLConexion.getConexion();
			String sql ="select f.futbolista_id, f.nombres , f.apellidos , e.nombre as Equipo , f.asistencias, f.partidos_jugados , f.edad , f.puesto , p.nombre_pais as pais , p.codigo_pais from futbolistas f join paises p on f.pais_id = p.pais_id join mejoresjugadores.equipos e on f.equipo_id = e.equipo_id where f.asistencias  >=1 order by f.asistencias desc, f.partidos_jugados asc, f.apellidos asc";
			ps = cone.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Futbolista futbolista = new Futbolista(
						rs.getInt("futbolista_id"),
						0,
						rs.getString("nombres"),
						rs.getString("apellidos"),
						0,
						rs.getInt("asistencias"),
						rs.getInt("partidos_jugados"),
						rs.getString("puesto"),
						rs.getInt("edad"),
						0
						);
				futbolista.setNombreEquipo(rs.getString("equipo")); 
				futbolista.setNombrePais(rs.getString("pais")); 
				futbolista.setCodigoPais(rs.getString("codigo_pais"));
				lista.add(futbolista);
						
			}
		}catch (Exception e) {
			System.out.println("Error al listar: " + e.getMessage());
		} finally {
			MySQLConexion.closeConexion(cone);
		}
		return lista;
	}

}
