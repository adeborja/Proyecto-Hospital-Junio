/**
 * nombre de la interfaz: Intervencion.java
 * 
 * propiedades basicas:
 * 	numeroSSPaciente: int, consultable
 * 	numeroColegiado: int, consultable
 * 	fecha: Calendar, consultable
 * 	Descripcion: String, consultable
 *  
 * propiedades derivadas:
 * 	no hay
 * 
 * setters y getters
 *	
 *	public int getNumeroSSPaciente();
 *	public int getNumeroColegiado();
 *	public Calendar getFecha();
 *	public String getDescripcion();
 * 
 * metodos adicionales
 * 	no hay
 */

package Hospital;

import java.util.Calendar;

public interface Intervencion {
	public int getNumeroSSPaciente();
	public int getNumeroColegiado();
	public Calendar getFecha();
	public String getDescripcion();
}
