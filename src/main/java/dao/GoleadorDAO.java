package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import BaseDatos.MySQLConexion;
import clases.Futbolista;
import interfaces.IGoleadorDAO;

public class GoleadorDAO implements IGoleadorDAO {

	private static IGoleadorDAO instancia;

	public static IGoleadorDAO getInstancia() {
	
	if (instancia == null) {
		instancia = new GoleadorDAO();;
	}
	return instancia;
	}
	
	private GoleadorDAO(){
		
	}
	@Override
	public ArrayList<Futbolista> listar() {
		
		ArrayList<Futbolista> lista = new ArrayList<Futbolista>();
		Connection cone = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			
			cone = MySQLConexion.getConexion();
			String sql ="SELECT f.futbolista_id, f.nombres, f.apellidos, e.nombre AS Equipo, f.goles, f.partidos_jugados, f.edad, f.puesto, p.nombre_pais AS pais, p.codigo_pais FROM futbolistas f JOIN paises p ON f.pais_id = p.pais_id JOIN equipos e ON f.equipo_id = e.equipo_id WHERE f.goles >= 1 ORDER BY f.goles DESC, f.partidos_jugados, f.apellidos ASC";
			ps = cone.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Futbolista futbolista = new Futbolista(
						rs.getInt("futbolista_id"),
						0,
						rs.getString("nombres"),
						rs.getString("apellidos"),
						rs.getInt("goles"),
						0,
						rs.getInt("partidos_jugados"),
						rs.getString("puesto"),
						rs.getInt("edad"),
						0
						);
				futbolista.setNombreEquipo(rs.getString("Equipo"));
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
