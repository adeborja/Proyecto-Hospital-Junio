/**
 * nombre: Medico.java
 * 
 * propiedades basicas:
 * 	numeroColegiado: int, consultable
 * 	especialidad: String, consultable y modificable
 * 
 * propiedades derivadas:
 * 	no hay
 * 
 * setters y getters
 * 	public void setEspecialidad(String e);
 *	
 *	public int getNumeroColegiado();
 *	public String getEspecialidad();
 * 
 * metodos adicionales
 * 	no hay
 */

package Hospital;

public interface Medico extends Persona{
	
	public void setEspecialidad(String especialidad);
	
	public int getNumeroColegiado();
	public String getEspecialidad();
}
