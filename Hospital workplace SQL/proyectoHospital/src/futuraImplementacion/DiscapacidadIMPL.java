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

public class DiscapacidadIMPL implements Discapacidad,Comparable<DiscapacidadIMPL>, Serializable{
	
	private String tipo, clasificacion, descripcion;
	private int numeroSSPaciente;
	
	public DiscapacidadIMPL(){
		this.tipo="";
		this.clasificacion="";
		this.descripcion="";
		this.numeroSSPaciente=0;
	}
	
	public DiscapacidadIMPL(String nTipo, String nClasi, String nDescripcion, int nNumeroSSPaciente){
		this.tipo=nTipo;
		this.clasificacion=nClasi;
		this.descripcion=nDescripcion;this.numeroSSPaciente=nNumeroSSPaciente;
	}
	
	public DiscapacidadIMPL(DiscapacidadIMPL d){
		this.tipo=d.getTipo();
		this.clasificacion=d.getClasificacion();
		this.descripcion=d.getDescripcion();
		this.numeroSSPaciente=d.getNumeroSSPaciente();
	}
	
	
	
	public void setTipo(String nTipo) throws ExcepcionHospital{
		String[] tiposValidos = {"fisica", "sensorial", "psiquica", "mental"};
		
		if(nTipo.toLowerCase().hashCode()!=tiposValidos[0].hashCode() && nTipo.toLowerCase().hashCode()!=tiposValidos[1].hashCode()){
			throw new ExcepcionHospital("El tipo introducido no es correcto. Debe ser fisica, sensorial, psiquica o mental");
		}
		else{
			this.tipo=nTipo;
		}
	}
	
	public void setClasificacion(String nClasi) throws ExcepcionHospital{
		
		String[] ClasificacionSensorialValidos = {"auditiva", "visual"};
		
		if(this.tipo.toLowerCase().hashCode()!="sensorial".hashCode()) this.clasificacion=nClasi;
		else{
			if(nClasi.toLowerCase().hashCode()!=ClasificacionSensorialValidos[0].hashCode() && nClasi.toLowerCase().hashCode()!=ClasificacionSensorialValidos[1].hashCode()){
				throw new ExcepcionHospital("La clasificacion introducida no es correcta, debe ser auditiva o visual");
			}
			else{
				this.clasificacion=nClasi;
			}
		}
	}
	
	public void setDescripcion(String nDescripcion){
		this.descripcion=nDescripcion;
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
	
	public String getDescripcion(){
		return this.descripcion;
	}
	
	public int getNumeroSSPaciente(){
		return this.numeroSSPaciente;
	}
	
	
	@Override
	public String toString(){
		String s = ""+this.tipo+","+this.clasificacion+","+this.descripcion+","+this.numeroSSPaciente;
		return s;
	}
	
	public int compareTo(DiscapacidadIMPL d){
		int compara = 0;
		
		if(this.numeroSSPaciente<d.getNumeroSSPaciente()) compara = -1;
		else if (this.numeroSSPaciente>d.getNumeroSSPaciente()) compara = 1;
		
		return compara;
	}
}
