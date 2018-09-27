/**
 * nombre de la interfaz: Intervencion.java
 * 
 * propiedades basicas:
 * 	numeroSSPaciente: int, consultable
 * 	numeroColegiado: int, consultable
 * 	fecha: Calendar, consultable
 * 	Tipo: String, consultable
 * 	descripcion: String, consultable
 *  
 * propiedades derivadas:
 * 	no hay
 * 
 * setters y getters
 *	
 *	public int getNumeroSSPaciente();
 *	public int getNumeroColegiado();
 *	public Calendar getFecha();
 *	public String getTipo();
 *	public String getDescripcion();
 * 
 * metodos adicionales
 * 	no hay
 * 
 * TIPO: periodica, urgencia
 */

package futuraImplementacion;

import java.util.Calendar;

public interface Revision {
	public int getNumeroSSPaciente();
	public int getNumeroColegiado();
	public Calendar getFecha();
	public String getTipo();
	public String getDescripcion();
}
