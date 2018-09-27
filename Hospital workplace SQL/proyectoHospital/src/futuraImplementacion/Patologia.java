/**
 * nombre de la interfaz: Patologia
 * 
 * propiedades basicas:
 * 	Tipo: String, consultable y modificable
 * 	Clasificacion: String, consultable y modificable
 * 	Nombre: String, consultable y modificable
 * 	numeroSSPaciente: int, consultable y modificable
 * 
 * propiedades derivadas:
 * 	no hay
 * 
 * setters y getters
 * 
 * 	public void setTipo(String nTipo);
 *	public void setClasificacion(String nClasi);
 *	public void setNombre(String nNombre);
 *	public void setNumeroSSPaciente(int nNumeroSSPaciente);
 *	
 *	public String getTipo();
 *	public String getClasificacion();
 *	public String getNombre();
 *	public int getNumeroSSPaciente();
 *
 * metodos adicionales
 * 	no hay
 */

package futuraImplementacion;

import Hospital.ExcepcionHospital;

public interface Patologia {
	public void setTipo(String nTipo) throws ExcepcionHospital;
	public void setClasificacion(String nClasi) throws ExcepcionHospital;
	public void setNombre(String nNombre);
	public void setNumeroSSPaciente(int nNumeroSSPaciente);
	
	public String getTipo();
	public String getClasificacion();
	public String getNombre();
	public int getNumeroSSPaciente();
}
