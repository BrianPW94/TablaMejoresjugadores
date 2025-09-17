package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import BaseDatos.MySQLConexion;
import clases.Pais;
import interfaces.IPaisDAO;

public class PaisDAO implements IPaisDAO {
	
	//singleton 
	private static IPaisDAO instancia;
	public static 	IPaisDAO getInstancia() {
		
		if(instancia == null) {
			
			instancia = new PaisDAO();
		}
	
		return instancia;
	}
	
	private PaisDAO() {
		
	}
	@Override
	public ArrayList<Pais> listar() {
		
		ArrayList<Pais> lista = new ArrayList<Pais>();
		Connection cone = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			
			cone = MySQLConexion.getConexion();
			String sql = "select * from paises";
			ps = cone.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Pais pais = new Pais(
						rs.getInt("pais_id"),
						rs.getString("codigo_pais"),
						rs.getString("nombre_pais")
						);
				lista.add(pais);
				
			}
		} catch (Exception e) {
			
			System.out.println("Error al listar: " + e.getMessage());
		} finally {
			MySQLConexion.closeConexion(cone);
		}
		
		return lista;
	}

}
