/**
 * nombre del programa: MetodosValidacion.java
 * 
 * propiedades basicas:
 * 	no hay
 * 
 * propiedades derivadas:
 * 	no hay
 * 
 * metodos adicionales:
 * 	int validarUsuario(int numero, String contrasenia)
 *  String obtenerUsuario(int numero)
 */


package Hospital;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MetodosValidacion {
	
	
	/**
	 * cabecera: int validarUsuario(int numero, String contrasenia)
	 * comentario: metodo para validar un usuario introducido con la base de datos
	 * precondiciones: nada
	 * entrada: una cadena
	 * e/s: nada
	 * salida: un entero
	 * postcondiciones: asociado al nombre devuelve el codigo recibido por la base de datos
	 */
	public static int validarUsuario(int numero, String contrasenia)
	{
		
		Connection conexion = null;
		Statement sentencia = null;
		ResultSet res = null;
		
		int codigoLogin=-2;
		String comandoValidar = "select dbo.ValidarLogin ("+numero+", "+contrasenia+") as codigoDevuelto";
		
		try
		{
			conexion = DriverManager.getConnection("jdbc:sqlserver://localhost","LoginBBDD","123");
			sentencia = conexion.createStatement();
			res = sentencia.executeQuery(comandoValidar);
			
			res.next();
			
			codigoLogin = res.getInt("codigoDevuelto");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			System.out.println(e.getErrorCode());
		}
		finally
		{
			try
			{
				res.close();
			}
			catch(SQLException e)
			{}
			try
			{
				sentencia.close();
			}
			catch(SQLException e)
			{}
			try
			{
				conexion.close();
			}
			catch(SQLException e)
			{}
		}
			
		return codigoLogin;
	}
	
	
	/**
	 * cabecera: String obtenerUsuario(int numero)
	 * comentario: metodo para obtener los datos de un usuario de la base de datos
	 * precondiciones: nada
	 * entrada: una cadena
	 * e/s: nada
	 * salida: una cadena
	 * postcondiciones: asociado al nombre devuelve el nombre asignado y la contrase�a del usuario seleccionado
	 */
	public static String obtenerUsuario(int numero)
	{
		
		Connection conexion = null;
		Statement sentencia = null;
		ResultSet res = null;
		
		String comandoDatos = "select dbo.BuscarUsuarioDeMedico_AD_Hospital ("+numero+") as datosLogin";
		String datosDevueltos = "";
		
		try
		{
			conexion = DriverManager.getConnection("jdbc:sqlserver://localhost","LoginBBDD","123");
			sentencia = conexion.createStatement();
			res = sentencia.executeQuery(comandoDatos);
			
			res.next();
			
			datosDevueltos = res.getString("datosLogin");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			System.out.println(e.getErrorCode());
		}
		finally
		{
			try
			{
				res.close();
			}
			catch(SQLException e)
			{}
			try
			{
				sentencia.close();
			}
			catch(SQLException e)
			{}
			try
			{
				conexion.close();
			}
			catch(SQLException e)
			{}
		}
		
		return datosDevueltos;
	}
	
}