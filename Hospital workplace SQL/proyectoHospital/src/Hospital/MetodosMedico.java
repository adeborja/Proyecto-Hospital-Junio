/**
 * nombre de programa: MetodosMedico.java
 * 
 * propiedades basicas:
 * 	nombre: cadena
 * 	contrasenia: cadena
 * 
 * propiedades derivadas:
 * 	no hay
 * 
 * propiedades compartidas:
 * 	sourceURL: cadena
 * 
 * metodos adicionales:
 * 	int crearMedico()
 * 	int escribirMedico(MedicoIMPL m)
 * 	void pintarMedicosEnPantalla()
 * 	MedicoIMPL getMedico(int numeroColegiado)
 * 	int darMedicoDeBaja(int numeroColegiado, String fechaInicio)
 * 	int darMedicoDeAlta(int numeroColegiado, String fechaFin)
 * 	void historialDeBajasMedico(int numeroColegiado)
 * 	void medicosDeBaja()
 */
package Hospital;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class MetodosMedico
{
	
	private static String sourceURL = "jdbc:sqlserver://localhost";
	
	private String usuario, contrasenia;
	
	public MetodosMedico(String nUsuario, String nContrasenia)
	{
		this.usuario=nUsuario;
		this.contrasenia=nContrasenia;
	}
	
	
	
	/**
	 * cabecera: int crearMedico()
	 * comentario: metodo para introducir los parametros de un nuevo medico
	 * precondiciones: nada
	 * entrada: nada
	 * e/s: nada
	 * salida: un entero
	 * postcondiciones: asociado al nombre devuelve el codigo recibido del metodo escribirMedico
	 */
	public int crearMedico()
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		MedicoIMPL medico = null;
		
		boolean dniCorrecto=false, sexoCorrecto=false;
		String nombre="", apellidos="", dniConLetra="", especialidad="", dni="";
		int anio=0, mes=0, dia=0, numeroColegiado=0, codigoDevuelto=-1;
		Calendar fechaNacimiento = null;
		char correcto=' ', sexo=' ';
		
		do
		{
			System.out.println("Introduce nombre");
			try
			{
				nombre = br.readLine().toUpperCase();
			}
			catch(IOException e)
			{
				
			}
		}
		while(nombre == "" || nombre.length()>20);
		
		do
		{
			System.out.println("Introduce apellidos");
			try
			{
				apellidos = br.readLine().toUpperCase();
			}
			catch(IOException e)
			{
				
			}
		}
		while(apellidos == "" || apellidos.length()>20);
		
		System.out.println("Introduce anio de nacimiento");
		try
		{
			anio = Integer.parseInt(br.readLine());
		}
		catch(IOException e)
		{
			
		}
		catch(NumberFormatException e)
		{
			
		}
		
		System.out.println("Introduce mes de nacimiento en digito(enero -> 1)");
		try
		{
			mes = Integer.parseInt(br.readLine())-1;
		}
		catch(IOException e)
		{
			
		}
		catch(NumberFormatException e)
		{
			
		}
		
		System.out.println("Introduce dia de nacimiento");
		try
		{
			dia = Integer.parseInt(br.readLine());
		}
		catch(IOException e)
		{
			
		}
		catch(NumberFormatException e)
		{
			
		}
		
		do
		{
			System.out.println("Introduce DNI sin letra");
			try
			{
				dni = br.readLine();
				
				if(dni.length()==8){
					dniCorrecto=true;
					dniConLetra = MetodosGenerales.aniadirLetraDni(Integer.parseInt(dni));
				}
			}
			catch(IOException e)
			{
				
			}
			catch(NumberFormatException e)
			{
				
			}
		}
		while(!dniCorrecto);
		
		System.out.println("Introduce numero de colegiado");
		try
		{
			numeroColegiado = Integer.parseInt(br.readLine());
		}
		catch(IOException e)
		{
			
		}
		catch(NumberFormatException e)
		{
			
		}
		
		do
		{
			System.out.println("Introduce sexo");
			try
			{
				sexo = br.readLine().toUpperCase().charAt(0);
				if(sexo=='V' || sexo=='M') sexoCorrecto=true;
			}
			catch(Exception e)
			{
				
			}
		}
		while(!sexoCorrecto);
		
		System.out.println("Introduce especialidad");
		try
		{
			especialidad = br.readLine().toUpperCase();
		}
		catch(IOException e)
		{
			
		}
		
		fechaNacimiento = new GregorianCalendar(anio, mes, dia);
		
		do
		{
			System.out.println("Comprueba los datos para confirmar");
			System.out.println("\nNombre: "+nombre);
			System.out.println("Apellidos: "+apellidos);
			System.out.println("Fecha de nacimiento: "+fechaNacimiento.getTime());
			System.out.println("DNI: "+dniConLetra);
			System.out.println("Especialidad: "+especialidad);
			System.out.println("Numero Colegiado: "+numeroColegiado);
			System.out.println("Sexo: "+sexo);
			System.out.println("\nEs correcto? S/N");
			try
			{
				correcto = br.readLine().toUpperCase().charAt(0);
			}
			catch(IOException e)
			{
				
			}
		}
		while(correcto!='S'&&correcto!='N');
		
		if(correcto=='S')
		{
			medico = new MedicoIMPL(nombre, apellidos, fechaNacimiento, dniConLetra, numeroColegiado, especialidad, sexo);
			codigoDevuelto = escribirMedico(medico);
			//decidir que dise�o hacer para los datos de usuario
			
			//Ponerla como clase de instancias y que tengas que crearla con el id del medico, llamar a un
			//metodo que verifique que el medico este en la base de datos y no est� de baja. Si todo es
			//correcto, devuelve el nombre y la contrase�a del usuario que se utilizara para introducir
			//datos en la base de datos.
			
			//Crear clase usuarioSQL con nombre y contrase�a?
			
			//Crear una base de datos a parte con login y contrase�a de los medicos, y si son correctos devuelve
			//los datos del usuario para trabajar en la base de datos del hospital
		}
		
		
		return codigoDevuelto;
	}
	
	/**
	 * cabecera: int escribirMedico(MedicoIMPL m)
	 * comentario: metodo para escribir un objeto de medico en la tabla Medicos
	 * precondiciones: nada
	 * entrada: un objeto tipo MedicoIMPL
	 * e/s: nada
	 * salida: un entero
	 * postcondiciones: asociado al nombre devuelve 0 si el medico se ha introducido correctamente, 1 si no se ha podido conectar a la base de datos, 2 si el medico ya existe en la base de datos, y -1 en caso de error
	 */
	public int escribirMedico(MedicoIMPL m)
	{
		
		Calendar fechaCalendar = m.getFechaNacimiento();
		
		Connection conexionBBDD = null;
		Statement sentencia = null;
		
		int codigoSalida = -1, filasAfectadas = -1, anio = fechaCalendar.get(fechaCalendar.YEAR), 
				mes = fechaCalendar.get(fechaCalendar.MONTH)+1, dia = fechaCalendar.get(fechaCalendar.DAY_OF_MONTH);
		//String sourceURL = "jdbc:sqlserver://localhost";
		String comando;
		String comandoFecha = "DATEFROMPARTS("+anio+","+mes+","+dia+")";
		
		try
		{
			conexionBBDD = DriverManager.getConnection(sourceURL, this.usuario, this.contrasenia);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			//e.getErrorCode(); recoge el numero que lanza la excepcion
			codigoSalida = 1; //No puede realizarse la conexion
		}
		
		
		if(codigoSalida != 1)
		{
			//insertar comando en sql
			
			try
			{
				sentencia = conexionBBDD.createStatement();
				
				comando = "INSERT INTO Medicos (Nombre, Apellidos, FechaNacimiento, DNI, NumeroColegiado, Especialidad, Sexo) VALUES "
						+ "( '"+m.getNombre()+"','"+m.getApellidos()+"',"+comandoFecha+",'"+m.getDNI()+"',"+m.getNumeroColegiado()+",'"+m.getEspecialidad()+"','"+m.getSexo()+"' )";
				
				filasAfectadas = sentencia.executeUpdate(comando); //puede saltar excepcion si ya existe?
				
				if(filasAfectadas == 1) codigoSalida=0;
			}
			catch(SQLException e)
			{
				e.printStackTrace();
				codigoSalida = 2; //Ya existe la primary key
			}
			
		}
		
		try
		{
			sentencia.close();
		}
		catch(SQLException e)
		{
			//e.printStackTrace();
		}
		try
		{
			conexionBBDD.close();
		}
		catch(SQLException e)
		{
			//e.printStackTrace();
		}
		
		return codigoSalida;
	}
	
	
	/**
	 * cabecera: void pintarMedicosEnPantalla()
	 * comentario: metodo para pintar los medicos existentes en la tabla Medicos en pantalla
	 * precondiciones: nada
	 * entrada: nada
	 * e/s: nada
	 * salida: nada
	 * postcondiciones: nada, pinta en pantalla los medicos guardados en la tabla Medicos
	 */
	public void pintarMedicosEnPantalla()
	{
		
		Connection conexionBBDD = null;
		Statement sentencia = null;
		ResultSet resultado = null;
		
		String comando="SELECT nombre, apellidos, dni, fechanacimiento, numerocolegiado, especialidad, sexo from Medicos";
		
		try
		{
			conexionBBDD = DriverManager.getConnection(sourceURL, this.usuario, this.contrasenia);
			sentencia = conexionBBDD.createStatement();
			resultado = sentencia.executeQuery(comando);
			
			while(resultado.next())
			{
				System.out.println(resultado.getString("nombre")+", "+resultado.getString("apellidos")+", "+
						resultado.getString("dni")+", "+resultado.getDate("fechanacimiento")+", "+
						resultado.getInt("numerocolegiado")+", "+resultado.getString("especialidad")+", "+
						resultado.getString("sexo"));
				
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * cabecera: MedicoIMPL getMedico(int numeroColegiado)
	 * comentario: Metodo para obtener los datos de un medico
	 * precondiciones: nada
	 * entrada: un entero
	 * e/s: nada
	 * salida: un objeto tipo MedicoIMPL
	 * postcondiciones: asociado al nombre devuelve el objeto MedicoIMPL buscado, o null si no existe en la base de datos
	 */
	public MedicoIMPL getMedico(int numeroColegiado)
	{
		
		MedicoIMPL m = null;
		//Date fecha = null;
		java.sql.Date fecha = null;
		Calendar fechaFinal = null;
		String nombre="", apellidos="", dni="", especialidad="";
		int numero=0;
		char sexo=' ';
		
		Connection conexion = null;
		Statement sentencia = null;
		ResultSet resultado = null;
		String comando = "SELECT nombre, apellidos, dni, fechanacimiento, numerocolegiado, especialidad, sexo from Medicos where numerocolegiado="+numeroColegiado;
		
		try
		{
			conexion = DriverManager.getConnection(sourceURL, this.usuario, this.contrasenia);
			
			sentencia = conexion.createStatement();
			
			resultado = sentencia.executeQuery(comando);
			
			resultado.next();
			
			//System.out.println(resultado.getString("nombre"));
			
			nombre = resultado.getString("Nombre");
			apellidos = resultado.getString("Apellidos");
			dni = resultado.getString("DNI");
			fecha = resultado.getDate("FechaNacimiento");
			numero = resultado.getInt("NumeroColegiado");
			especialidad = resultado.getString("Especialidad");
			sexo = resultado.getString("Sexo").charAt(0);
			
			/**/
			//System.out.println(fecha+", "+fecha.getTime());
			/**/
			
			fechaFinal = new GregorianCalendar();
			//fechaFinal.setTime(fecha);
			fechaFinal.setTimeInMillis(fecha.getTime());
			
			m = new MedicoIMPL(nombre, apellidos, fechaFinal, dni, numero, especialidad, sexo);
		}
		catch(SQLException e)
		{
			//e.printStackTrace();
			//System.out.println(e.getErrorCode());
		}
		finally
		{
			try
			{
				resultado.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			try
			{
				sentencia.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			try
			{
				conexion.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		
		return m;
	}
	
	
	/*
	 * buscar el medico en la base de datos NO NECESARIO ----
	 * 
	 * si el medico existe NO ----
	 * 		buscar si ya estaba de baja ----
	 * 		si no lo estaba----
	 * 			escribir baja
	 * 		fin si----
	 * fin si NO ----
	 * 
	 * 0: dado de baja correctamente
	 * 1: ya se encontraba de baja
	 * 2: medico no encontrado
	 */
	//public int darMedicoDeBaja(int numeroColegiado, Calendar fechaInicio)
	
	/**
	 * cabecera: int darMedicoDeBaja(int numeroColegiado, String fechaInicio)
	 * comentario: metodo para dar de baja a un medico
	 * precondiciones: nada
	 * entrada: un entero y una cadena
	 * e/s: nada
	 * salida: un entero
	 * postcondiciones: asociado al nombre devuelve 0 si se ha insertado la baja correctamente, 1 si no se ha podido conectar a la base de datos, 2 si ya estaba de baja, 3 si no existe el medico en la base de datos
	 */
	public int darMedicoDeBaja(int numeroColegiado, String fechaInicio)
	{
		Connection conexion = null;
		Statement sentencia = null;
		ResultSet resultado = null;
		
		int codigo = -1;
		//int anio = fechaInicio.get(fechaInicio.YEAR);
		//int mes = fechaInicio.get(fechaInicio.MONTH)+1;
		//int dia = fechaInicio.get(fechaInicio.DAY_OF_MONTH);
		//int hora = fechaInicio.get(fechaInicio.HOUR);
		//int minuto = fechaInicio.get(fechaInicio.MINUTE);
		//String comando = "execute EscribirBajaDeMedico "+numeroColegiado+", SMALLDATETIMEFROMPARTS("+anio+","+mes+","+dia+","+hora+","+minuto+")"; 
		String comando = "execute EscribirBajaDeMedico "+numeroColegiado;
		if (fechaInicio!="null") comando = comando+", '"+fechaInicio+"'";

		
		
		//preguntar a leo si se puede coger en java lo que devuelve el procedimiento o si es necesario 
		//crear una funcion que llame al procedimiento
		
		//simplemente escribir la baja, si ya existe nos devuelve una excepcion
		
		try
		{
			conexion = DriverManager.getConnection(sourceURL, this.usuario, this.contrasenia);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			codigo = 1; //no se ha podido realizar la conexion
		}
		
		if(codigo!=1)
		{
			try
			{
				sentencia = conexion.createStatement();
				resultado = sentencia.executeQuery(comando);
				codigo = 0;
			}
			catch (SQLException e)
			{
				if(e.getErrorCode()==51001)
				{
					codigo = 2; //ya esta de baja ese medico
				}
				else if(e.getErrorCode()==547)
				{
					codigo = 3; //No existe ese medico en la base de datos
				}
				else if(e.getErrorCode()==0)
				{
					codigo = 0; //Salta porque no devuelve nada si se inserta correctamente
				}
				else
				{
					e.printStackTrace();
					System.out.println("Codigo de error: "+e.getErrorCode()); 
				}
			}
			finally
			{
				try
				{
					resultado.close();
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
				catch(NullPointerException e)
				{
					
				}
				try
				{
					sentencia.close();
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
				try
				{
					conexion.close();
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
		
		
		return codigo;
	}
	
	
	
	/**
	 * cabecera: int darMedicoDeAlta(int numeroColegiado, String fechaFin)
	 * comentario: metodo para dar de alta a un medico que esta de baja
	 * precondiciones: nada
	 * entrada: un entero y una cadena
	 * e/s: nada
	 * salida: un entero
	 * postcondiciones: asociado al nombre devuelve 1 si se ha dado de alta correcatmente, 0 si no estaba de baja y -1 si sucede un error
	 */
	
	/**
	 * PG
	 * inicio
	 * 	mandar comando a sql
	 *  devolver resultado de operacion
	 * fin
	 */
	public int darMedicoDeAlta(int numeroColegiado, String fechaFin)
	{
		Connection conexion = null;
		Statement sentencia = null;
		
		int filasAfectadas=-1;
		if (fechaFin=="null") fechaFin = "current_timestamp";
		String comando = "update MedicosDeBaja set FechaFin = "+fechaFin+" where NumeroColegiadoMedico="+numeroColegiado+" and FechaFin is null";
		
		try
		{
			conexion = DriverManager.getConnection(sourceURL,this.usuario, this.contrasenia);
			sentencia = conexion.createStatement();
			
			filasAfectadas = sentencia.executeUpdate(comando); //si devuelve 0 fracaso, 1 exito
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
				sentencia.close();
			}
			catch(SQLException e)
			{
				
			}
			try
			{
				conexion.close();
			}
			catch(SQLException e)
			{
				
			}
		}
		
		return filasAfectadas;
	}
	
	
	/**
	 * cabecera: void historialDeBajasMedico(int numeroColegiado)
	 * comentario: metodo para pintar en pantalla el historial de bajas de un medico
	 * precondiciones: nada
	 * entrada: un entero
	 * e/s: nada
	 * salida: nada
	 * postcondiciones: nada, pinta en pantalla el historial de bajas del medico deseado
	 */
	public void historialDeBajasMedico(int numeroColegiado)
	{
		Connection conexion = null;
		Statement sentencia = null;
		ResultSet resultado = null;
		
		String comando = "SELECT ID, FechaInicio, FechaFin from MedicosDeBaja WHERE NumeroColegiadoMedico="+numeroColegiado;
		
		try
		{
			conexion = DriverManager.getConnection(sourceURL, this.usuario, this.contrasenia);
			sentencia = conexion.createStatement();
			resultado = sentencia.executeQuery(comando);
			
			while(resultado.next())
			{
				System.out.println(resultado.getInt("ID")+", "+resultado.getTimestamp(("FechaInicio"))+", "+resultado.getTimestamp("FechaFin"));
			}
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
				resultado.close();
			}
			catch(SQLException e)
			{
				
			}
			catch(NullPointerException e)
			{
				
			}
			try
			{
				sentencia.close();
			}
			catch(SQLException e)
			{
				
			}
			try
			{
				conexion.close();
			}
			catch(SQLException e)
			{
				
			}
		}
	}
	
	
	/**
	 * cabecera: void medicosDeBaja()
	 * comentario: metodo para pintar en pantalla todos los medicos que se encuentran de baja actualmente
	 * precondiciones: nada
	 * entrada: nada
	 * e/s: nada
	 * salida: nada
	 * postcondiciones: nada, pinta en pantalla los medicos que se encuentran de baja
	 */
	public void pintarMedicosDeBaja()
	{
		Connection conexion = null;
		Statement sentencia = null;
		ResultSet resultado = null;
		
		String comando = "SELECT MB.NumeroColegiadoMedico, M.Nombre, M.Apellidos, MB.FechaInicio from MedicosDeBaja as MB inner join Medicos as M on MB.NumeroColegiadoMedico=M.NumeroColegiado WHERE MB.FechaFin IS NULL";
		
		try
		{
			conexion = DriverManager.getConnection(sourceURL, this.usuario, this.contrasenia);
			sentencia = conexion.createStatement();
			resultado = sentencia.executeQuery(comando);
			
			while(resultado.next())
			{
				//System.out.println(resultado.getInt("NumeroColegiadoMedico")+", "+resultado.getString("Nombre")+", "+resultado.getString("Apellidos")+", "+resultado.getTimestamp(("FechaInicio")));
				
				System.out.println("Numero colegiado medico: "+resultado.getInt("NumeroColegiadoMedico")
						+"\nNombre: "+resultado.getString("Nombre")
						+"\nApellidos: "+resultado.getString("Apellidos")
						+"\nFecha de inicio de baja: "+resultado.getTimestamp(("FechaInicio"))+"\n");
			}
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
				resultado.close();
			}
			catch(SQLException e)
			{
				
			}
			catch(NullPointerException e)
			{
				
			}
			try
			{
				sentencia.close();
			}
			catch(SQLException e)
			{
				
			}
			try
			{
				conexion.close();
			}
			catch(SQLException e)
			{
				
			}
		}
	}
	
	
	
}