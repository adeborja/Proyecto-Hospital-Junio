/**
 * nombre del programa: ProgramaPrincipal.java
 * 
 * entradas: 
 * 
 * salidas:
 * 
 * restricciones:
 * 
 * PG nivel 0
 * inicio
 * 	Si opcionMenu no es salir y esCorrecto es falso
 * 		ValidarUsuario
 * 	fin Si
 * 
 * 	si esCorrecto es verdadero
 * 		Repetir(0)
 * 			menuPrincipal()
 * 			LeerValidarOpcionMenu
 * 			
 * 			Si opcionMenu no es salir
 * 				Segun opcionMenu
 * 					Caso 1: Acciones con pacientes
 * 					Caso 2: Acciones con medicos
 * 					Caso 3: Programar evento
 * 				fin Segun
 * 			Fin si
 * 		Mientras opcionMenu no sea salir
 * 	fin Si
 * fin
 * 
 * 
 * PG nivel 1 de Acciones con pacientes
 * inicio
 * 	Repetir(2)
 * 		Repetir(3)
 * 			menuPacientes()
 * 			LeerOpcionSubmenu
 * 		Mientras opcionSubmenu no sea valido
 * 		
 * 		Si opcionSubmenu no es salir
 * 			Segun opcionSubmenu
 * 				Caso 1: Ingresar un nuevo paciente
 * 				Caso 2: Ingresar un paciente existente
 * 				Caso 3: Dar de alta a un paciente
 * 				Caso 4: Mostrar datos de un paciente
 * 				Caso 5: Mostrar historial de un paciente
 * 				Caso 6: Mostrar todos los pacientes que se encuentran ingresados
 * 			fin segun
 * 		Fin si
 * 	Mientras opcionSubmenu no sea salir
 * fin
 * 
 * 
 * PG nivel 1 de Acciones con medicos
 * inicio
 * 	Repetir(4)
 * 		Repetir(5)
 * 			menuMedicos()
 * 			LeerOpcionSubmenu
 * 		Mientras opcionSubmenu no sea valido
 * 		
 * 		Si opcionSubmenu no es salir
 * 			Segun opcionSubmenu
 * 				Caso 1: Introducir un nuevo medico
 * 				Caso 2: Dar de baja a un medico
 * 				Caso 3: Dar de alta a un medico de baja
 * 				Caso 4: Mostrar datos de un medico
 * 				Caso 5: Mostrar el historial de intervenciones de un medico
 * 				Caso 6: Mostrar los medicos que se encuentran de baja
 * 			fin segun
 * 		Fin si
 * 	Mientras opcionSubmenu no sea salir
 * fin
 * 
 * 
 * PG nivel 1 de Acciones con eventos
 * inicio
 * 	Repetir(6)
 * 		Repetir(7)
 * 			menuEventos()
 * 			LeerOpcionSubmenu
 * 		Mientras opcionSubmenu no sea valido
 * 		
 * 		Si opcionSubmenu no es salir
 * 			Segun opcionSubmenu
 * 				Caso 1: Programar intervencion
 * 				Caso 2: Cancelar intervencion
 * 				Caso 3: Mostrar datos de una intervencion
 * 			fin segun
 * 		Fin si
 * 	Mientras opcionSubmenu no sea salir
 * fin
 * 
 */

package Hospital;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProgramaPrincipal
{
	
	public static void menuPrincipal()
	{
		System.out.println("\n\tMENU PRINCIPAL\n-------------------------------");
		System.out.println("1. Gestion de pacientes");
		System.out.println("2. Gestion de medicos");
		System.out.println("3. Gestion de eventos");
		System.out.println("0. Salir");
	}
	
	public static void menuPacientes()
	{
		System.out.println("\n\tGESTION DE PACIENTES\n--------------------------------------");
		System.out.println("1. Ingresar un nuevo paciente");
		System.out.println("2. Ingresar un paciente existente");
		System.out.println("3. Dar de alta a un paciente");
		System.out.println("4. Mostrar datos de un paciente");
		System.out.println("5. Mostrar historial de un paciente");
		System.out.println("6. Mostrar todos los pacientes que se encuentran ingresados");
		System.out.println("0. Salir");
	}
	
	public static void menuMedicos()
	{
		System.out.println("\n\tGESTION DE MEDICOS\n--------------------------------------");
		System.out.println("1. Introducir un nuevo medico");
		System.out.println("2. Dar de baja a un medico");
		System.out.println("3. Dar de alta a un medico de baja");
		System.out.println("4. Mostrar datos de un medico");
		System.out.println("5. Mostrar el historial de intervenciones de un medico");
		System.out.println("6. Mostrar los medicos que se encuentran de baja");
		System.out.println("0. Salir");
	}
	
	public static void menuEventos()
	{
		System.out.println("\n\tGESTION DE EVENTOS\n--------------------------------------");
		System.out.println("1. Programar intervencion");
		System.out.println("2. Cancelar intervencion");
		System.out.println("3. Mostrar datos de una intervencion");
		System.out.println("0. Salir");
	}
	
	
	
	public static void main(String[] args)
	{
		//String usuario = "UsuarioModificador", contrasenia = "123";
		MetodosMedico mm = null;
		MetodosPaciente mp = null;
		MetodosIntervencion mi = null;
		
		int numeroIntroducido = -1;
		String contraseniaIntroducida = "", datosUsuario="";
		
		
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
		MedicoIMPL medico = null;
		Paciente paciente = null;
		IntervencionIMPL intervencion = null;
		
		int opcionMenu=-1, opcionSubMenu=-1, numero=-1, esValido=-2;//, numeroSS=0, numeroColegiado=0;
		boolean esCorrecto=false;
		int codigoSalida = -1;
		String pintar=" ";
		

		//Console console = null;
		
		
		
		do
		{
			if(opcionMenu!=0 && !esCorrecto)
			{
				do
				{
					//Validar usuario
					System.out.print("Introduce tu numero de colegiado: ");
					try
					{
						numeroIntroducido = Integer.parseInt(teclado.readLine());
					}
					catch(IOException e)
					{}
					catch(NumberFormatException e)
					{}
					
					System.out.print("Introduce tu contrasenia: ");
					try
					{
						//console.readPassword();
						contraseniaIntroducida = teclado.readLine();
					}
					catch(IOException e)
					{}
					catch(NumberFormatException e)
					{}
					
					esValido = MetodosValidacion.validarUsuario(numeroIntroducido, contraseniaIntroducida);
					
					if(esValido==0)
					{
						datosUsuario = MetodosValidacion.obtenerUsuario(numeroIntroducido);
						String[] aux = datosUsuario.split(",");
						
						mm = new MetodosMedico(aux[0], aux[1]);
						mp = new MetodosPaciente(aux[0], aux[1]);
						mi = new MetodosIntervencion(aux[0], aux[1]);
						
						esCorrecto=true;
					}
					else System.out.println("El usuario o la contrasenia son incorrectos\n");
					
				}
				while(!esCorrecto);
			}
			
			//Resto del programa
			if(esCorrecto)
			{
				do
				{
					menuPrincipal();
					try
					{
						opcionMenu = Integer.parseInt(teclado.readLine());
					}
					catch(IOException e)
					{}
					catch(NumberFormatException e)
					{}
					
				}
				while(opcionMenu<0 || opcionMenu>3);
				
				if(opcionMenu!=0)
				{
					
					switch(opcionMenu)
					{
					case 1:
						do
						{
							do
							{
								menuPacientes();
								try
								{
									opcionSubMenu = Integer.parseInt(teclado.readLine());
								}
								catch(IOException e)
								{
									e.printStackTrace();
								}
								catch(NumberFormatException e
										){}
							}
							while(opcionSubMenu<0 || opcionSubMenu>6);
						
							if(opcionSubMenu!=0)
							{
								switch(opcionSubMenu)
								{
								case 1:
									codigoSalida = mp.crearPaciente();
									
									if(codigoSalida==0)
									{
										pintar = "Exito en la operacion";
									}
									else if(codigoSalida==1)
									{
										pintar = "Error, no se ha podido contactar con la base de datos";
									}
									else if(codigoSalida==2)
									{
										pintar = "Error, ya existe un paciente con ese numero de seguridad social";
									}
									else
									{
										pintar = "Ha ocurrido un error durante la operacion";
									}
									
									System.out.println(pintar);
									break;
									
								case 2:
									System.out.println("Introduce el numero de seguridad social del paciente que deseas ingresar");
									try
									{
										numero = Integer.parseInt(teclado.readLine());
									}
									catch(IOException e)
									{}
									catch(NumberFormatException e)
									{}
									
									codigoSalida = mp.ingresarPaciente(numero, "null");
									
									if(codigoSalida==0)
									{
										System.out.println("El ingreso se ha realizado correctamente");
									}
									else if(codigoSalida==1)
									{
										System.out.println("Error al conectar con la base de datos");
									}
									else if(codigoSalida==2)
									{
										System.out.println("El paciente ya se encontraba ingresado, no puede ser ingresado nuevamente");
									}
									else if(codigoSalida==3)
									{
										System.out.println("El paciente introducido no existe en la base de datos");
									}
									else{
										System.out.println("Ha ocurrido un error durante la operacion	");
									}
									
									break;
									
								case 3:
									System.out.println("Introduce el numero de seguridad social del paciente que deseas dar de alta");
									try
									{
										numero = Integer.parseInt(teclado.readLine());
									}
									catch(IOException e)
									{}
									catch(NumberFormatException e)
									{}
									
									codigoSalida = mp.darPacienteDeAlta(numero, "null");
									
									if(codigoSalida==0){
										System.out.println("El paciente especificado no se encuentra ingresado");
									}
									else if(codigoSalida==1){
										System.out.println("El paciente ha sido dado de alta correctamente");
									}
									else{
										System.out.println("Ha ocurrido un error en la operacion");
									}
									
									break;
									
								case 4:
									System.out.println("Introduce el numero de seguridad social del paciente");
									try
									{
										numero = Integer.parseInt(teclado.readLine());
									}
									catch(IOException e)
									{
										e.printStackTrace();
									}
									
									paciente = mp.getPaciente(numero);
									
									if(paciente==null)
									{
										System.out.println("Paciente no encontrado");
									}
									else
									{
										System.out.println(paciente.datosEnBonito());
									}
									
									break;
									
								case 5:
									System.out.println("Introduce el numero de seguridad social del paciente");
									try
									{
										numero = Integer.parseInt(teclado.readLine());
									}
									catch(IOException e)
									{
										e.printStackTrace();
									}
									
									paciente = mp.getPaciente(numero);
									
									if(paciente==null)
									{
										System.out.println("Paciente no encontrado");
									}
									else
									{
										System.out.println(paciente.datosEnBonito());
										System.out.println("\nHISTORIAL DE INGRESOS");
										mp.historialDeIngresosPaciente(numero);
										System.out.println("\nHISTORIAL DE INTERVENCIONES");
										mi.pintarIntervencionesDePaciente(numero);
									}
									
									break;
									
								case 6:
									
									mp.pintarPacientesIngresados();
									
									break;
								
								}
							}
						}
						while(opcionSubMenu!=0);
						
						break;
					case 2:
						do
						{
							do
							{
								menuMedicos();
								try
								{
									opcionSubMenu = Integer.parseInt(teclado.readLine());
								}
								catch(IOException e)
								{}
								catch(NumberFormatException e)
								{}
							}
							while(opcionSubMenu<0 || opcionSubMenu>6);
						
							if(opcionSubMenu!=0)
							{
								switch(opcionSubMenu)
								{
								case 1:
									codigoSalida = mm.crearMedico();
									
									if(codigoSalida==0)
									{
										pintar = "Exito en la operacion";
									}
									else if(codigoSalida==1)
									{
										pintar = "Error, no se ha podido contactar con la base de datos";
									}
									else if(codigoSalida==2)
									{
										pintar = "Error, ya existe un medico con ese numero de colegiado";
									}
									else
									{
										pintar = "Ha ocurrido un error durante la operacion";
									}
									
									System.out.println(pintar);
									break;
									
								case 2:
									System.out.println("Introduce el numero de colegiado del medico que deseas dar de baja");
									try
									{
										numero = Integer.parseInt(teclado.readLine());
									}
									catch(IOException e)
									{}
									catch(NumberFormatException e)
									{}
									codigoSalida = mm.darMedicoDeBaja(numero, "null");
									
									if(codigoSalida==0)
									{
										System.out.println("La baja se ha realizado correctamente");
									}
									else if(codigoSalida==1)
									{
										System.out.println("Error al conectar con la base de datos");
									}
									else if(codigoSalida==2)
									{
										System.out.println("El medico ya se encontraba de baja, no puede ser dado nuevamente de baja");
									}
									else if(codigoSalida==3)
									{
										System.out.println("El medico introducido no existe en la base de datos");
									}
									else{
										System.out.println("Ha ocurrido un error durante la operacion	");
									}
									
									break;
									
									
								case 3:
									
									System.out.println("Introduce el numero de colegiado del medico que deseas dar de alta");
									try
									{
										numero = Integer.parseInt(teclado.readLine());
									}
									catch(IOException e)
									{}
									catch(NumberFormatException e)
									{}
									codigoSalida = mm.darMedicoDeAlta(numero, "null");
									
									if(codigoSalida==0)
									{
										System.out.println("Error, el medico no estaba de baja");
									}
									else if(codigoSalida==1)
									{
										System.out.println("El medico ha sido dado de alta correctamente");
									}
									else{
										System.out.println("Ha ocurrido un error durante la operacion");
									}
									
									break;
									
								case 4:
									System.out.println("Introduce el numero de colegiado del medico");
									try{
										numero = Integer.parseInt(teclado.readLine());
									}
									catch(IOException e){
										e.printStackTrace();
									}
									
									medico = mm.getMedico(numero);
									
									if(medico==null){
										System.out.println("Medico no encontrado");
									}
									else{
										System.out.println(medico.datosEnBonito());
									}
									
									break;
									
								case 5:
									System.out.println("Introduce el numero de colegiado del medico");
									try
									{
										numero = Integer.parseInt(teclado.readLine());
									}
									catch(IOException e)
									{
										e.printStackTrace();
									}
									
									medico = mm.getMedico(numero);
									
									if(medico==null){
										System.out.println("Medico no encontrado");
									}
									else{
										
										System.out.println(medico.datosEnBonito());
										System.out.println("\nHISTORIAL DE INTERVENCIONES");
										mi.pintarIntervencionesDeMedico(numero);
									}
									
									
									
									break;
									
								case 6:
									/*System.out.println("Introduce el numero de colegiado del medico");
									try
									{
										numero = Integer.parseInt(teclado.readLine());
									}
									catch(IOException e)
									{
										e.printStackTrace();
									}*/
									
									mm.pintarMedicosDeBaja();
									
									break;
									
								}
							}
						}
						while(opcionSubMenu!=0);
						
						break;
					case 3:
						do
						{
							do
							{
								menuEventos();
								try
								{
									opcionSubMenu = Integer.parseInt(teclado.readLine());
								}
								catch(IOException e)
								{}
								catch(NumberFormatException e)
								{}
							}
							while(opcionSubMenu<0 || opcionSubMenu>3);
							
							if(opcionSubMenu!=0)
							{
								switch(opcionSubMenu)
								{
								case 1:
									codigoSalida = mi.crearIntervencion();
									
									if(codigoSalida==0)
									{
										pintar = "Se ha introducido la intervencion correctamente";
									}
									else
									{
										pintar = "Ha ocurrido un error durante la operacion";
									}
									
									System.out.println(pintar);
									break;
									
								case 2:
									System.out.println("Introduce el ID de la operacion");
									try
									{
										numero = Integer.parseInt(teclado.readLine());
									}
									catch(IOException e)
									{}
									catch(NumberFormatException e)
									{}
									
									
									codigoSalida = mi.borrarIntervencion(numero);
									
									if(codigoSalida==0)
									{
										System.out.println("La intervencion no existe");
									}
									else if(codigoSalida==1)
									{
										System.out.println("Exito en la cancelacion");
									}
									else
									{
										System.out.println("La intervencion no puede ser cancelada porque ya ha sido realizada");
									}
									break;
								
								case 3:
									System.out.println("Introduce el ID de la operacion");
									try
									{
										numero = Integer.parseInt(teclado.readLine());
									}
									catch(IOException e)
									{}
									catch(NumberFormatException e)
									{}
									
									intervencion = mi.getIntervencion(numero);
									
									if(intervencion==null)
									{
										System.out.println("Intervencion no encontrado");
									}
									else
									{
										System.out.println(intervencion.datosEnBonito());
									}
									
									break;
									
								}
							}
						}
						while(opcionSubMenu!=0);
						
						break;
					
					}
				}
			}
		}
		while(opcionMenu!=0);
		
		try
		{
			teclado.close();
		}
		catch(IOException e)
		{
			//e.printStackTrace();
		}
	}
}
