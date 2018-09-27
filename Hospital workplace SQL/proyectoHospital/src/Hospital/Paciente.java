/**
 * nombre de la clase: Paciente
 * hereda de: PersonaIMPL
 * 
 * propiedades basicas:
 * 	numeroSeguridadSocial: int, consultable y modificable
 * 
 * propiedades derivadas:
 * 	no hay
 * 
 * getters y setters
 * 
 *	public void setNumeroSeguridadSocial(int nNumero)
 *
 *	public int getNumeroSeguridadSocial()
 *
 * 
 * Criterio de igualdad: por numeroSeguridadSocial
 * 
 * Metodos adicionales:
 *  int getDniSinLetra()
 * 	String toString()
 * 	int compareTo(Persona p)
 * 	boolean equals(Object o)
 *  String datosEnBonito()
 * 
 * tamaño en archivo: apellido 20+2, nombre 20+2, fechaNacimiento 8, dni 9+2, sexo 2, SS 4. Total:69
 */

package Hospital;

import java.util.Calendar;
import java.io.Serializable;

public class Paciente extends PersonaIMPL implements Serializable{
	
	private int numeroSeguridadSocial;
	/*private String nombre, apellidos, dni;
	private Calendar fechaNacimiento;
	private char sexo;*/
	
	public Paciente(){
		/*this.nombre="";
		this.apellidos="";
		this.fechaNacimiento=null;
		this.dni="";
		this.sexo=' ';*/
		super();
		this.numeroSeguridadSocial=0;
	}
	
	public Paciente(String nNombre, String nApellidos, Calendar nFecha, String nDni, int nNumeroSeguridadSocial, char nSexo){
		/*this.nombre=nNombre;
		this.apellidos=nApellidos;
		this.fechaNacimiento=nFecha;
		this.dni=nDni;
		this.sexo=nSexo;*/
		super(nNombre, nApellidos, nFecha, nDni, nSexo);
		this.numeroSeguridadSocial=nNumeroSeguridadSocial;
	}
	
	public Paciente(Paciente p){
		/*this.nombre=p.getNombre();
		this.apellidos=p.getApellidos();
		this.fechaNacimiento=p.getFechaNacimiento();
		this.dni=p.getDNI();
		this.sexo=p.getSexo();*/
		super(p);
		this.numeroSeguridadSocial=p.getNumeroSeguridadSocial();
	}
	
	
	/*
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public String getDNI() {
		return dni;
	}

	public Calendar getFechaNacimiento() {
		return fechaNacimiento;
	}
	
	public int getEdad(){
		int edad;
		long milisActual, milisCumple, diferencia;
		
		milisActual = System.currentTimeMillis();
		milisCumple = this.fechaNacimiento.getTimeInMillis();
		diferencia = milisActual-milisCumple;
		edad = (int)((diferencia/86400000)/365.25);
		
		return edad;
	}*/
	
	
	public void setNumeroSeguridadSocial(int nNumero){
		this.numeroSeguridadSocial=nNumero;
	}

	public int getNumeroSeguridadSocial() {
		return numeroSeguridadSocial;
	}
	
	public int getDniSinLetra(){
		//String sinLetra = this.dni.substring(0, 8);
		String sinLetra = this.getDNI().substring(0, 8);
		int dni = Integer.parseInt(sinLetra);
		
		return dni;
	}
	
	
	@Override
	public String toString(){
		//String s = ""+this.getApellidos()+","+this.getNombre()+","+this.getFechaNacimiento().YEAR+","+this.getFechaNacimiento().MONTH+","+this.getFechaNacimiento().DAY_OF_MONTH+","+this.dni+","+this.numeroSeguridadSocial;
		String s = ""+super.toString()+","+this.numeroSeguridadSocial;
		return s;
	}
	
	public int compareTo(Paciente p){
		int compara = 0;
		
		if(this.numeroSeguridadSocial<p.getNumeroSeguridadSocial()){
			compara = -1;
		}
		else if(this.numeroSeguridadSocial>p.getNumeroSeguridadSocial()){
			compara = 1;
		}
		
		return compara;
	}
	
	@Override
	public boolean equals(Object o){
		boolean esIgual = false;
		
		if(o instanceof Paciente){
			Paciente p = (Paciente) o;
			
			if(this.numeroSeguridadSocial==p.getNumeroSeguridadSocial()) esIgual=true;
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
	 * postcondiciones: asociado al nombre devuelve una cadena con los datos del paciente
	 */
	public String datosEnBonito(){
		String s = "Apellidos: "+this.getApellidos()+"\nNombre: "+this.getNombre()+"\nFecha nacimiento: "+this.getFechaNacimiento().getTime()+"\nDNI: "+this.getDNI()+"\nSexo:"+this.getSexo()+"\nNumero Seguridad Social:"+this.numeroSeguridadSocial;
		return s;
	}
}
