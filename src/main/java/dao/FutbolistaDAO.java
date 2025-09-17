package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import BaseDatos.MySQLConexion;
import clases.Futbolista;
import interfaces.IFutbolistaDAO;

public class FutbolistaDAO implements IFutbolistaDAO {

	private static IFutbolistaDAO instancia;
	
	public static IFutbolistaDAO getInstancia() {
		if(instancia == null) {
			
			instancia = new FutbolistaDAO();
		}
		return instancia;
		
	}
	
	private FutbolistaDAO() {
	}
	
	
	@Override
	public int crear(Futbolista futbolista) {
		int value = 0;
		Connection cone = null;
		PreparedStatement ps = null;
		
		try {
			
			cone = MySQLConexion.getConexion();
			String sql = "insert into futbolistas values(null, ?, ?, ?, ?, ?, ? ,?,?, ?)";
			
			ps = cone.prepareStatement(sql);
			ps.setInt(1, futbolista.getPaisId());
			ps.setString(2, futbolista.getNombres());
			ps.setString(3, futbolista.getApellidos());
			ps.setInt(4, futbolista.getGoles());
			ps.setInt(5,  futbolista.getAsistencias());
			ps.setInt(6, futbolista.getPartidos());
			ps.setString(7, futbolista.getPuesto());
			ps.setInt(8, futbolista.getEdad());
			ps.setInt(9, futbolista.getEquipoId());
			
		value = ps.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("Error al crear: " + e.getMessage());
		} finally {
			MySQLConexion.closeConexion(cone);
		}
		return value;
	}

	@Override
	public ArrayList<Futbolista> listar() {
		ArrayList<Futbolista> lista = new ArrayList<Futbolista>();		
		Connection cone = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
		cone = MySQLConexion.getConexion();
		String sql = "SELECT f.*, e.nombre AS Equipo, p.nombre_pais as Pais, p.codigo_pais FROM futbolistas f LEFT JOIN equipos e ON f.equipo_id = e.equipo_id LEFT JOIN paises p ON f.pais_id = p.pais_id";
		ps = cone.prepareStatement(sql);
	    rs = ps.executeQuery();
			while(rs.next()) {
				
				Futbolista futbolista = new  Futbolista(
						rs.getInt("futbolista_id"),
						rs.getInt("pais_id"),
						rs.getString("nombres"),
						rs.getString("apellidos"),
						rs.getInt("goles"),
						rs.getInt("asistencias"),
						rs.getInt("partidos_jugados"),
						rs.getString("puesto"),
						rs.getInt("edad"),
						rs.getInt("equipo_id")
						);
				//Agregando Nombre Equipo
				futbolista.setNombreEquipo(rs.getString("Equipo"));
				//Agregando nombre Pais
				futbolista.setNombrePais(rs.getString("Pais"));
				
				futbolista.setCodigoPais(rs.getString("codigo_pais")); 
				lista.add(futbolista);
			}
		} catch (Exception e) {
			System.out.println("Error al listar: " + e.getMessage());
		} finally {
			MySQLConexion.closeConexion(cone);
		}
		return lista;
	}

	@Override
	public Futbolista obtener(int futbolistaId) {
		Futbolista futbolista = null;
		Connection cone = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			
			cone = MySQLConexion.getConexion();
			String sql = "select * from futbolistas where futbolista_id = ?";
			
			ps = cone.prepareStatement(sql);
			ps.setInt(1, futbolistaId);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				
				futbolista = new Futbolista(
						rs.getInt("futbolista_Id"),
						rs.getInt("pais_id"),
						rs.getString("nombres"),
						rs.getString("apellidos"),
						rs.getInt("goles"),
						rs.getInt("asistencias"),
						rs.getInt("partidos_jugados"),
						rs.getString("puesto"),
						rs.getInt("edad"),
						rs.getInt("equipo_id")
						);
			}
		} catch (Exception e) {
			System.out.println("Error al listar: " + e.getMessage());
		} finally {
			MySQLConexion.closeConexion(cone);
		}
		return futbolista;
	}

	@Override
	public int actualizar(Futbolista futbolista) {
		int value = 0;
		Connection cone = null;
		PreparedStatement ps = null;
		try {
			cone = MySQLConexion.getConexion();
			String sql = "update futbolistas set pais_id = ?, nombres = ?, apellidos = ?, goles = ?, asistencias = ?, partidos_jugados = ?, puesto = ?, edad = ?, equipo_id = ? where futbolista_id = ?";
					ps = cone.prepareStatement(sql);
					ps.setInt(1, futbolista.getPaisId());
					ps.setString(2, futbolista.getNombres());
					ps.setString(3, futbolista.getApellidos());
					ps.setInt(4, futbolista.getGoles());
					ps.setInt(5, futbolista.getAsistencias());
					ps.setInt(6, futbolista.getPartidos());
					ps.setString(7, futbolista.getPuesto());
					ps.setInt(8, futbolista.getEdad());
					ps.setInt(9, futbolista.getEquipoId());
					ps.setInt(10, futbolista.getFutbolistaId());
			
					value = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error al actualizar el registro: " + e.getMessage());
		} finally {
			MySQLConexion.closeConexion(cone);
		}
		return value;
	}
	

	@Override
	public int eliminar(int futbolistaId) {
		int value = 0;
		Connection cone = null;
		PreparedStatement ps = null;
		try {
			cone = MySQLConexion.getConexion();
			String sql = "delete  from futbolistas where futbolista_id = ? ";
			ps = cone.prepareStatement(sql);
		    ps.setInt(1, futbolistaId);
			
		value = ps.executeUpdate();

	} catch (Exception e) {
		System.out.println("Error al actualizar el registro: " + e.getMessage());
	} finally {
		MySQLConexion.closeConexion(cone);
	}
	return value;
}	

}
