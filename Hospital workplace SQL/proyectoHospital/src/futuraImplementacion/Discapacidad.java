/**
 * nombre de la interfaz: Discapacidad.java
 * 
 * propiedades basicas:
 * 	Tipo: String, consultable y modificable
 * 	Clasificacion: String, consultable y modificable
 * 	Descripcion: String, consultable y modificable
 * 	numeroSSPaciente: int, consultable y modificable
 * 	
 * propiedades derivadas:
 * 	no hay
 * 
 * setters y getters
 * 	public void setTipo(String nTipo);
 *	public void setClasificacion(String nClasi);
 *	public void setDescripcion(String nDescripcion);
 *	public void setNumeroSSPaciente(int nNumeroSSPaciente);
 *
 *	public String getTipo();
 *	public String getClasificacion();
 *	public String getDescripcion();
 *	public int getNumeroSSPaciente();
 * 
 * metodos adicionales
 * 	no hay
 */

package futuraImplementacion;

import Hospital.ExcepcionHospital;

public interface Discapacidad {
	
	public void setTipo(String nTipo) throws ExcepcionHospital;
	public void setClasificacion(String nClasi) throws ExcepcionHospital;
	public void setDescripcion(String nDescripcion);
	public void setNumeroSSPaciente(int nNumeroSSPaciente);
	
	public String getTipo();
	public String getClasificacion();
	public String getDescripcion();
	public int getNumeroSSPaciente();
}
