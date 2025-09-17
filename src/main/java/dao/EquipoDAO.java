package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import BaseDatos.MySQLConexion;
import clases.Equipo;

import interfaces.IEquipoDAO;

public class EquipoDAO implements IEquipoDAO {

	//singleton
	private static IEquipoDAO instancia;
	
	public static IEquipoDAO getInstancia() {
		if (instancia == null) {
			instancia = new EquipoDAO();
		}
		return instancia;
	}
	private EquipoDAO() {
		
	}
	//singleton cierra
	
	//metodos crud
	@Override
	public int crear(Equipo equipo) {
		int value = 0;
		Connection cone = null;
		PreparedStatement  ps = null;
		
		try {
			
			cone = MySQLConexion.getConexion();
			String sql = "INSERT INTO equipos VALUES(null, ?)";
			ps = cone.prepareStatement(sql);
			ps.setString(1,  equipo.getNombre());
			value = ps.executeUpdate();
		} 
		catch (Exception e) {
			System.out.println("Error al hacer: " + e.getMessage());
		} 
		finally {
			MySQLConexion.closeConexion(cone);
		}
	 return value;
}

	@Override
	public ArrayList<Equipo> listar() {
		ArrayList<Equipo> lista = new ArrayList<Equipo>();
		Connection cone = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			
			cone = MySQLConexion.getConexion();
			String sql = "Select * from equipos";
			ps = cone.prepareStatement(sql);
			rs =   ps.executeQuery();
			
			while(rs.next()) {
				
				Equipo equipo = new Equipo(
					
					rs.getInt("equipo_id"),
					rs.getString("nombre")
				);
				lista.add(equipo);
			}
					
		} catch (Exception e) {
			System.out.println("Error al listar: " + e.getMessage());
		} finally {
			
			MySQLConexion.closeConexion(cone);
		}
		return lista;
	}

	@Override
	public Equipo obtener(int equipoId) {
		
		Equipo equipo = null;
		Connection cone = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {	
			cone = MySQLConexion.getConexion();
			String sql = "select * from equipos where equipo_id = ?";
			ps = cone.prepareStatement(sql);
			ps.setInt(1, equipoId);
			rs = ps.executeQuery();
		 
			if(rs.next()) {
				equipo = new Equipo(
						rs.getInt("equipo_Id"),
						rs.getString("nombre")
						);
			}
		} catch (Exception e) {
			System.out.println("Error al obtener el registro: " + e.getMessage());
		}
		finally {
			
			MySQLConexion.closeConexion(cone);
		}
		return equipo;
	}

	@Override
	public int actualizar(Equipo equipo) {
		int value = 0;
		Connection cone = null;
		PreparedStatement ps = null;
		try {
		
			cone = MySQLConexion.getConexion();
			String sql = "update equipos set nombre = ? where equipo_id = ? ";
			ps = cone.prepareStatement(sql);
			ps.setString(1, equipo.getNombre());
			ps.setInt(2, equipo.getEquipoId());
			
			value =  ps.executeUpdate();
		}
		catch (Exception e) {
			System.out.println("Error al obtener el registro: " + e.getMessage());
		}
		finally{
			MySQLConexion.closeConexion(cone);
		}
		return value;
	}

	@Override
	public int eliminar(int equipoId) {
		int value= 0;
		Connection cone = null;
		PreparedStatement ps = null;
	
		try {
			cone = MySQLConexion.getConexion();
			String sql = "delete from equipos where equipo_id = ?";
			ps = cone.prepareStatement(sql);
			ps.setInt(1, equipoId);
			
			value = ps.executeUpdate();
		
		
	} catch (Exception e) {
		System.out.println("Error al actualizar el registro: " + e.getMessage());
	} finally {
		MySQLConexion.closeConexion(cone);
	}
				return value;
	}
	
	



}
