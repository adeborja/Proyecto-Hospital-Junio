/**
 * nombre de la interfaz: Habitacion.java
 * 
 * propiedades basicas:
 * 	numeroSSPaciente: int, consultable y modificable
 * 	planta: int, consultable y modificable
 *  numero: int, consultable y modificable
 *  
 * propiedades derivadas:
 * 	no hay
 * 
 * setters y getters
 * 
 * 	public void setNumeroSSPaciente(int nNumero);
 *	public void setPlanta(int p);
 *	public void setNumero(int nNumero);
 *	
 *	public int getNumeroSSPaciente();
 *	public int getPlanta();
 *	public int getNumero();
 * 
 * metodos adicionales
 * 	no hay
 */

package futuraImplementacion;

public interface Habitacion {
	public void setNumeroSSPaciente(int nNumero);
	public void setPlanta(int p);
	public void setNumero(int nNumero);
	
	public int getNumeroSSPaciente();
	public int getPlanta();
	public int getNumero();
}
