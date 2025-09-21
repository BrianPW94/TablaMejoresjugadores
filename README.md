# TablaMejoresjugadores

Proyecto jsp para gestionar datos de jugadores.

## Configuración

- A la base de datos se le puede poner cualquier nombre y una vez creada se pega el contenido del script sql MejoresJugadores.sql

- - Edita `MySQLConexionPublicEditarla.class` con tus credenciales o usa variables de entorno:
  - `DB_URL=jdbc:mysql://localhost:3306/[nombre_de_tu_db]?useSSL=false&useTimezone=true&serverTimezone=UTC`
  - `DB_USER=tu_usuario`
  - `DB_PASSWORD=tu_contraseña`
- Añade el driver MySQL JDBC (`mysql-connector-java-x.x.xx.jar`) al classpath.

## Requisitos
- Java JDK 8+
- MySQL Server
- DBeaver o similar (MYSQL)
- Eclipse IDE
- Apache Tomcat
