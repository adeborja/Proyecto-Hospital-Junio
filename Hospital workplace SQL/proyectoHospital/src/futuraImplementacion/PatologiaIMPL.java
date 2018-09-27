/**
 * Criterio de igualdad: por numeroSSPaciente
 * 
 * Metodos adicionales:
 * 	String toString()
 * 	int compareTo(DiscapacidadIMPL d)
 */


package futuraImplementacion;

import java.io.Serializable;

import Hospital.ExcepcionHospital;

public class PatologiaIMPL implements Patologia, Comparable<PatologiaIMPL>, Serializable{
	
	private String tipo, clasificacion, nombre;
	private int numeroSSPaciente;
	
	public PatologiaIMPL(){
		this.tipo="";
		this.clasificacion="";
		this.nombre="";
		this.numeroSSPaciente=0;
	}
	
	public PatologiaIMPL(String nTipo, String nClasi, String nNombre, int nNumeroSSPaciente){
		this.tipo=nTipo;
		this.clasificacion=nClasi;
		this.nombre=nNombre;
		this.numeroSSPaciente=nNumeroSSPaciente;
	}
	
	public PatologiaIMPL(PatologiaIMPL p){
		this.tipo=p.getTipo();
		this.clasificacion=p.getClasificacion();
		this.nombre=p.getNombre();
		this.numeroSSPaciente=p.getNumeroSSPaciente();
	}
	
	
	
	public void setTipo(String nTipo) throws ExcepcionHospital{
		String[] tiposValidos = {"general", "sistematica"};
		
		if(nTipo.toLowerCase().hashCode()!=tiposValidos[0].hashCode() && nTipo.toLowerCase().hashCode()!=tiposValidos[1].hashCode()){
			throw new ExcepcionHospital("El tipo introducido no es correcto. Debe ser general o sistematico");
		}
		else{
			this.tipo=nTipo;
		}
	}
	
	public void setClasificacion(String nClasi) throws ExcepcionHospital{
		String[] ClasificacionValidos = {"patologico", "hereditario"};
		
		if(nClasi.toLowerCase().hashCode()!=ClasificacionValidos[0].hashCode() && nClasi.toLowerCase().hashCode()!=ClasificacionValidos[1].hashCode()){
			throw new ExcepcionHospital("La clasificacion introducida no es correcta. Debe ser patologico o hereditario");
		}
		else{
			this.clasificacion=nClasi;
		}
	}
	
	public void setNombre(String nNombre){
		this.nombre=nNombre;
	}
	
	public void setNumeroSSPaciente(int nNumeroSSPaciente){
		this.numeroSSPaciente=nNumeroSSPaciente;
	}
	
	public String getTipo(){
		return this.tipo;
	}
	
	public String getClasificacion(){
		return this.clasificacion;
	}
	
	public String getNombre(){
		return this.nombre;
	}
	
	public int getNumeroSSPaciente(){
		return this.numeroSSPaciente;
	}
	
	
	@Override
	public String toString(){
		String s = ""+this.tipo+","+this.clasificacion+","+this.nombre+","+this.numeroSSPaciente;
		return s;
	}
	
	public int compareTo(PatologiaIMPL p){
		int compara = 0;
		
		if(this.numeroSSPaciente<p.getNumeroSSPaciente()) compara = -1;
		else if (this.numeroSSPaciente>p.getNumeroSSPaciente()) compara = 1;
		
		return compara;
	}
	
}
