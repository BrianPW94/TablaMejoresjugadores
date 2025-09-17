// Configura las variables de entorno DB_URL, DB_USER y DB_PASSWORD con tus credenciales de MySQL.

// Ejemplo: export DB_URL="jdbc:mysql://localhost:3306/tu_db?useSSL=false&useTimezone=true&serverTimezone=UTC"

package BaseDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConexionPublicEditarla {
    
    public static Connection getConexion() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = System.getenv("DB_URL") != null ? System.getenv("DB_URL") : "jdbc:mysql://localhost:3306/[Nombre base de datos]?useSSL=false&useTimezone=true&serverTimezone=UTC";
            String usr = System.getenv("DB_USER") != null ? System.getenv("DB_USER") : "[usuario]";
            String psw = System.getenv("DB_PASSWORD") != null ? System.getenv("DB_PASSWORD") : "contraseña";
            con = DriverManager.getConnection(url, usr, psw);
        } catch (ClassNotFoundException e) {
            System.out.println("Error >> Driver no Instalado!!" + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error >> de conexión con la BD" + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error >> general : " + e.getMessage());
        }
        return con;
    }

    public static void closeConexion(Connection con) {
        try {
            con.close();
        } catch (SQLException e) {
            System.out.println("Problemas al cerrar la conexion");
        }
    }
}