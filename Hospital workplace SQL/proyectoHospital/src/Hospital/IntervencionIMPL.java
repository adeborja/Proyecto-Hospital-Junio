/**
 * 
 * 
 * tamaño en archivo: numeroSS 4, numeroCol 4, fecha 8, descripcion 32+2: total=50
 */

package Hospital;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.io.Serializable;

public class IntervencionIMPL implements Intervencion, Comparable<IntervencionIMPL>, Serializable{
	
	
	private int numeroSSPaciente, numeroColegiado;
	private Calendar fecha;
	private String descripcion;
	
	public IntervencionIMPL(int nNumeroSSPaciente, int nNumeroColegiado, Calendar nFecha, String nDescripcion){
		this.numeroSSPaciente=nNumeroSSPaciente;
		this.numeroColegiado=nNumeroColegiado;
		this.fecha=nFecha;
		this.descripcion=nDescripcion;
	}
	
	public int getNumeroSSPaciente(){
		return this.numeroSSPaciente;
	}
	
	public int getNumeroColegiado(){
		return this.numeroColegiado;
	}
	
	public Calendar getFecha(){
		return this.fecha;
	}
	
	public String getDescripcion(){
		return this.descripcion;
	}
	
	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	@Override
	public String toString(){
		String s = ""+this.numeroSSPaciente+","+this.numeroColegiado+","+this.fecha.getTimeInMillis()+","+this.descripcion;
		return s;
	}
	
	public int compareTo(IntervencionIMPL i){
		int compara = 0;
		
		if(this.fecha.getTimeInMillis()<i.getFecha().getTimeInMillis()) compara = -1;
		else if(this.fecha.getTimeInMillis()>i.getFecha().getTimeInMillis()) compara = 1;
		
		return compara;
	}
	
	@Override
	public boolean equals(Object o){
		boolean esIgual = false;
		
		if(o instanceof IntervencionIMPL){
			IntervencionIMPL i = (IntervencionIMPL) o;
			
			if(this.fecha.getTimeInMillis()==i.getFecha().getTimeInMillis()) esIgual=true;
		}
		
		return esIgual;
	}
	
	
	/**
	 * cabecera: String datosEnBonito()
	 * comentario: metodo que devuelve los parametros para que sean agradables a la vista
	 * precondiciones: nada
	 * entrada: nada
	 * e/s: nada
	 * salida: una cadena
	 * postcondiciones: asociado al nombre devuelve una cadena con los datos del medico
	 */
	public String datosEnBonito(){
		String s = "Numero de seguridad social de paciente: "+this.numeroSSPaciente+"\nNumero de colegiado: "+this.numeroColegiado+"\nFecha de intervencion: "+this.fecha.getTime()+"\nDescripcion: "+this.descripcion;
		return s;
	}
	
}
