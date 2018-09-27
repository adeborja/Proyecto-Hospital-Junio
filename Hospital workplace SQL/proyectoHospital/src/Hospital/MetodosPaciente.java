/**
 * nombre de programa: MetodosPaciente.java
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



public class MetodosPaciente
{
	
	private static String sourceURL = "jdbc:sqlserver://localhost";
	
	private String usuario, contrasenia;
	
	public MetodosPaciente(String nUsuario, String nContrasenia)
	{
		this.usuario=nUsuario;
		this.contrasenia=nContrasenia;
	}
	
	
	
	/**
	 * cabecera: int crearPaciente()
	 * comentario: metodo para introducir los parametros de un nuevo Paciente
	 * precondiciones: nada
	 * entrada: nada
	 * e/s: nada
	 * salida: un entero
	 * postcondiciones: asociado al nombre devuelve el codigo recibido del metodo escribirPaciente
	 */
	public int crearPaciente()
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Paciente paciente = null;
		
		boolean dniCorrecto=false, sexoCorrecto=false;
		String nombre="", apellidos="", dniConLetra="", dni="";
		int anio=0, mes=0, dia=0, numeroSS=0, codigoDevuelto=-1;
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
		
		System.out.println("Introduce numero de seguridad social");
		try
		{
			numeroSS = Integer.parseInt(br.readLine());
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
		
		
		fechaNacimiento = new GregorianCalendar(anio, mes, dia);
		
		do
		{
			System.out.println("Comprueba los datos para confirmar");
			System.out.println("\nNombre: "+nombre);
			System.out.println("Apellidos: "+apellidos);
			System.out.println("Fecha de nacimiento: "+fechaNacimiento.getTime());
			System.out.println("DNI: "+dniConLetra);
			System.out.println("Numero Seguridad Social: "+numeroSS);
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
			paciente = new Paciente(nombre, apellidos, fechaNacimiento, dniConLetra, numeroSS, sexo);
			codigoDevuelto = escribirPaciente(paciente);
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
	 * cabecera: int escribirPaciente(Paciente p)
	 * comentario: metodo para escribir un objeto de paciente en la tabla Pacientes
	 * precondiciones: nada
	 * entrada: un objeto tipo Paciente
	 * e/s: nada
	 * salida: un entero
	 * postcondiciones: asociado al nombre devuelve 0 si el paciente se ha introducido correctamente, 1 si no se ha podido conectar a la base de datos, 2 si el paciente ya existe en la base de datos, y -1 en caso de error
	 */
	public int escribirPaciente(Paciente p)
	{
		
		Calendar fechaCalendar = p.getFechaNacimiento();
		
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
				
				comando = "INSERT INTO Pacientes (Nombre, Apellidos, FechaNacimiento, DNI, NumeroSeguridadSocial, Sexo) VALUES "
						+ "( '"+p.getNombre()+"','"+p.getApellidos()+"',"+comandoFecha+",'"+p.getDNI()+"',"+p.getNumeroSeguridadSocial()+",'"+p.getSexo()+"' )";
				
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
	 * cabecera: void pintarPacientesEnPantalla()
	 * comentario: metodo para pintar los pacientes existentes en la tabla Pacientes en pantalla
	 * precondiciones: nada
	 * entrada: nada
	 * e/s: nada
	 * salida: nada
	 * postcondiciones: nada, pinta en pantalla los pacientes guardados en la tabla Pacientes
	 */
	public void pintarPacientesEnPantalla()
	{
		
		Connection conexionBBDD = null;
		Statement sentencia = null;
		ResultSet resultado = null;
		
		String comando="SELECT nombre, apellidos, dni, fechanacimiento, numeroseguridadsocial, sexo from Pacientes";
		
		try
		{
			conexionBBDD = DriverManager.getConnection(sourceURL, this.usuario, this.contrasenia);
			sentencia = conexionBBDD.createStatement();
			resultado = sentencia.executeQuery(comando);
			
			while(resultado.next())
			{
				System.out.println(resultado.getString("nombre")+", "+resultado.getString("apellidos")+", "+
						resultado.getString("dni")+", "+resultado.getDate("fechanacimiento")+", "+
						resultado.getInt("numeroseguridadsocial")+", "+resultado.getString("sexo"));
				
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * cabecera: Paciente getPaciente(int numeroSS)
	 * comentario: Metodo para obtener los datos de un paciente
	 * precondiciones: nada
	 * entrada: un entero
	 * e/s: nada
	 * salida: un objeto tipo Paciente
	 * postcondiciones: asociado al nombre devuelve el objeto Paciente buscado, o null si no existe en la base de datos
	 */
	public Paciente getPaciente(int numeroSS)
	{
		
		Paciente p = null;
		java.sql.Date fecha = null;
		Calendar fechaFinal = null;
		String nombre="", apellidos="", dni="";
		int numero=0;
		char sexo=' ';
		
		Connection conexion = null;
		Statement sentencia = null;
		ResultSet resultado = null;
		String comando = "SELECT nombre, apellidos, dni, fechanacimiento, numeroseguridadsocial, sexo from Pacientes where numeroseguridadsocial="+numeroSS;
		
		try
		{
			conexion = DriverManager.getConnection(sourceURL, this.usuario, this.contrasenia);
			
			sentencia = conexion.createStatement();
			
			resultado = sentencia.executeQuery(comando);
			
			resultado.next();
			
			nombre = resultado.getString("Nombre");
			apellidos = resultado.getString("Apellidos");
			dni = resultado.getString("DNI");
			fecha = resultado.getDate("FechaNacimiento");
			numero = resultado.getInt("NumeroSeguridadSocial");
			sexo = resultado.getString("Sexo").charAt(0);
			
			fechaFinal = new GregorianCalendar();
			fechaFinal.setTimeInMillis(fecha.getTime());
			
			p = new Paciente(nombre, apellidos, fechaFinal, dni, numero, sexo);
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
				//e.printStackTrace();
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
		
		return p;
	}
	
	
	/**
	 * cabecera: int ingresarPaciente(int numeroSS, String fechaInicio)
	 * comentario: metodo para dar de baja a un paciente
	 * precondiciones: nada
	 * entrada: un entero y una cadena
	 * e/s: nada
	 * salida: un entero
	 * postcondiciones: asociado al nombre devuelve 0 si se ha ingresado al paciente correctamente, 1 si no se ha podido conectar a la base de datos, 2 si ya estaba ingresado, 3 si no existe el paciente en la base de datos
	 */
	public int ingresarPaciente(int numeroSS, String fechaInicio)
	{
		Connection conexion = null;
		Statement sentencia = null;
		ResultSet resultado = null;
		
		int codigo = -1;
		
		String comando = "execute EscribirIngresoPaciente "+numeroSS;
		if (fechaInicio!="null") comando = comando+", '"+fechaInicio+"'"; 
		
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
				if(e.getErrorCode()==51002)
				{
					codigo = 2; //ya esta ingresado ese paciente
				}
				else if(e.getErrorCode()==547)
				{
					codigo = 3; //No existe ese paciente en la base de datos
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
	 * cabecera: int darPacienteDeAlta(int numeroSS, String fechaFin)
	 * comentario: metodo para dar de alta a un paciente que esta ingresado
	 * precondiciones: nada
	 * entrada: un entero y una cadena
	 * e/s: nada
	 * salida: un entero
	 * postcondiciones: asociado al nombre devuelve 1 si se ha dado de alta correctamente, 0 si no estaba ingresado y -1 si sucede un error
	 */
	public int darPacienteDeAlta(int numeroSS, String fechaFin)
	{
		Connection conexion = null;
		Statement sentencia = null;
		
		int filasAfectadas=-1;
		
		if(fechaFin=="null") fechaFin = "CURRENT_TIMESTAMP";
		String comando = "update IngresoDePacientes set FechaDeAlta = "+fechaFin+" where NumeroSeguridadSocialPaciente="+numeroSS+" and FechaDeAlta is null";
		
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
	 * cabecera: void historialDeIngresosPaciente(int numeroSS)
	 * comentario: metodo para pintar en pantalla el historial de ingresos de un paciente
	 * precondiciones: nada
	 * entrada: un entero
	 * e/s: nada
	 * salida: nada
	 * postcondiciones: nada, pinta en pantalla el historial de ingresos del paciente deseado
	 */
	public void historialDeIngresosPaciente(int numeroSS)
	{
		Connection conexion = null;
		Statement sentencia = null;
		ResultSet resultado = null;
		
		String comando = "SELECT ID, FechaDeIngreso, FechaDeAlta from IngresoDePacientes WHERE NumeroSeguridadSocialPaciente="+numeroSS;
		
		try
		{
			conexion = DriverManager.getConnection(sourceURL, this.usuario, this.contrasenia);
			sentencia = conexion.createStatement();
			resultado = sentencia.executeQuery(comando);
			
			while(resultado.next())
			{
				//System.out.println(resultado.getInt("ID")+", "+resultado.getTimestamp(("FechaDeIngreso"))+", "+resultado.getTimestamp("FechaDeAlta"));
				
				System.out.println("ID de ingreso: "+resultado.getInt("ID")
						+"\nFecha de ingreso: "+resultado.getTimestamp(("FechaDeIngreso"))
						+"\nFecha de alta: "+resultado.getTimestamp("FechaDeAlta")+"\n");
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
	 * cabecera: void pintarPacientesIngresados()
	 * comentario: metodo para pintar en pantalla todos los pacientes que se encuentran ingresados actualmente
	 * precondiciones: nada
	 * entrada: nada
	 * e/s: nada
	 * salida: nada
	 * postcondiciones: nada, pinta en pantalla los pacientes que se encuentran ingresados
	 */
	public void pintarPacientesIngresados()
	{
		Connection conexion = null;
		Statement sentencia = null;
		ResultSet resultado = null;
		
		String comando = "SELECT IP.NumeroSeguridadSocialPaciente, P.Nombre, P.Apellidos, IP.FechaDeIngreso FROM IngresoDePacientes AS IP inner join Pacientes as P on IP.NumeroSeguridadSocialPaciente=P.NumeroSeguridadSocial WHERE IP.FechaDeAlta IS NULL";
		/*int numeroPaciente=-1, numeroMedico=-1;
		Calendar fecha = new GregorianCalendar();
		String descripcion = "";*/
		
		try
		{
			conexion = DriverManager.getConnection(sourceURL, this.usuario, this.contrasenia);
			sentencia = conexion.createStatement();
			resultado = sentencia.executeQuery(comando);
			
			while(resultado.next())
			{
				//System.out.println(resultado.getInt("NumeroSeguridadSocialPaciente")+", "+resultado.getString("Nombre")+", "+resultado.getString("Apellidos")+", "+resultado.getTimestamp(("FechaDeIngreso")));
				/*numeroPaciente = resultado.getInt("NumeroSeguridadSocialPaciente");
				numeroMedico = */
				
				System.out.println("Numero Seguridad Social paciente: "+resultado.getInt("NumeroSeguridadSocialPaciente")
						+"\nNombre: "+resultado.getString("Nombre")
						+"\nApellidos: "+resultado.getString("Apellidos")
						+"\nFecha de ingreso: "+resultado.getTimestamp(("FechaDeIngreso"))+"\n");
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