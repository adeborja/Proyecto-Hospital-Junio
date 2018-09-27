/**
 * Criterio de igualdad: por fecha
 * 
 * MEtodos adicionales:
 * 	String toString()
 * 	int compareTo(RevisionIMPL r)
 * 	boolean equals(Object o)
 */

package futuraImplementacion;

import java.util.Calendar;
import java.io.Serializable;

public class RevisionIMPL implements Revision, Comparable<RevisionIMPL>, Serializable{
	
	private int numeroSSPaciente, numeroColegiado;
	private Calendar fecha;
	private String tipo, descripcion;
	
	public RevisionIMPL(int nNumeroSSPaciente, int nNumeroColegiado, Calendar nFecha, String nTipo, String nDescripcion){
		this.numeroSSPaciente=nNumeroSSPaciente;
		this.numeroColegiado=nNumeroColegiado;
		this.fecha=nFecha;
		this.tipo=nTipo;
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
	
	public String getTipo(){
		return this.tipo;
	}
	
	public String getDescripcion(){
		return this.descripcion;
	}
	
	@Override
	public String toString(){
		//String s = ""+this.numeroSSPaciente+","+this.numeroColegiado+","+this.fecha.YEAR+","+this.fecha.MONTH+","+this.fecha.DAY_OF_MONTH+","+this.tipo+","+this.descripcion;
		String s = ""+this.numeroSSPaciente+","+this.numeroColegiado+","+this.fecha.getTimeInMillis()+","+this.tipo+","+this.descripcion;
		return s;
	}
	
	public int compareTo(RevisionIMPL r){
		int compara = 0;
		
		if(this.fecha.getTimeInMillis()<r.getFecha().getTimeInMillis()) compara = -1;
		else if(this.fecha.getTimeInMillis()>r.getFecha().getTimeInMillis()) compara = 1;
		
		return compara;
	}
	
	@Override
	public boolean equals(Object o){
		boolean esIgual = false;
		
		if(o instanceof RevisionIMPL){
			RevisionIMPL r = (RevisionIMPL) o;
			
			if(this.fecha.getTimeInMillis()==r.getFecha().getTimeInMillis()) esIgual=true;
		}
		
		return esIgual;
	}
}
