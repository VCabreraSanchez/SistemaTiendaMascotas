package util;
import java.sql.*;
public class SQLConexion
 { 
public static Connection getConexion(){ 
Connection con = null;
 try { Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
String url ="jdbc:sqlserver://LAPTOP-7LJN53A4\\EQUIPO:1433;database=BDTIENDA_MASCOTA"; 
String usr = "saAdmin"; 
String psw = "alumno"; 
con = DriverManager.getConnection(url,usr,psw); 
System.out.println("Conexion correcta");
 } 
catch (ClassNotFoundException ex) { System.out.println("No hay Driver!!"); } 
catch (SQLException ex) 
{ System.out.println("Error con la BD"); }
 return con; }
 } 