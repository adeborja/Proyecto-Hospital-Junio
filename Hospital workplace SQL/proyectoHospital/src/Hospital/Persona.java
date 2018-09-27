/**
 * nombre de la interfaz: Persona.java
 * 
 * Propiedades basicas:
 * 	nombre: String, consultable y modificable
 * 	apellidos: String, consultable y modificable
 * 	fechaNacimiento: Date, consultable
 * 	DNI: String, consultable
 *  Sexo: String, consultable y modificable
 * 	
 * Propiedades derivadas:
 * 	edad: int, consultable
 * 	
 * Getters y Setters
 * 	String getNombre()
 * 	String getApellidos()
 * 	Date getFechaNacimiento()
 * 	String getDNI()
 * 	int getEdad()
 * 
 * 	void setNombre(String n)
 * 	void setApellidos(String a)
 * 	void setFechaNacimiento(Date f)
 * 
 * metodos adicionales
 * 	no hay
 */

package Hospital;

import java.util.Calendar;

public interface Persona{
	String getNombre();
	String getApellidos();
	Calendar getFechaNacimiento();
	String getDNI();
	int getEdad();
	char getSexo();
	
	void setNombre(String nombre);
	void setApellidos(String apellidos);
	void setSexo(char sexo);
}
