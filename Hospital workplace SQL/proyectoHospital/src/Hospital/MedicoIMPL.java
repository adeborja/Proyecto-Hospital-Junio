/**
 * 
 * Criterio de igualdad: numeroColegiado
 * 
 * Metodos adicionales:
 * 	int getDniSinLetra()
 * 	String toString()
 * 	int compareTo(Persona p)
 * 	boolean equals(Object o)
 * 	String datosEnBonito()
 * 
 * tamaño en archivo: apellido 20+2, nombre 20+2, fechaNacimiento 8, dni 9+2, especialidad 20+2, numeroColegiado 4, sexo 2. Total:91
 */

package Hospital;

import java.util.Calendar;
import java.io.Serializable;

public class MedicoIMPL implements Medico, Comparable<MedicoIMPL>, Serializable{
	
	private String nombre, apellidos, dni, especialidad;
	private Calendar fechaNacimiento;
	private int numeroColegiado;
	private char sexo;
	
	public MedicoIMPL(){
		this.nombre="";
		this.apellidos="";
		this.fechaNacimiento=null;
		this.dni="";
		this.numeroColegiado=0;
		this.especialidad="";
		this.sexo=' ';
	}
	
	public MedicoIMPL(String nNombre, String nApellidos, Calendar nFecha, String nDni, int nNumero, String nEspecialidad, char nSexo){
		this.nombre=nNombre;
		this.apellidos=nApellidos;
		this.fechaNacimiento=nFecha;
		this.dni=nDni;
		this.numeroColegiado=nNumero;
		this.especialidad=nEspecialidad;
		this.sexo=nSexo;
	}
	
	public MedicoIMPL(MedicoIMPL m){
		this.nombre=m.getNombre();
		this.apellidos=m.getApellidos();
		this.fechaNacimiento=m.getFechaNacimiento();
		this.dni=m.getDNI();
		this.numeroColegiado=m.getNumeroColegiado();
		this.especialidad=m.getEspecialidad();
		this.sexo=m.getSexo();
	}
	
	

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

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
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

	public int getNumeroColegiado() {
		return numeroColegiado;
	}
	
	public int getEdad(){
		int edad;
		long milisActual, milisCumple, diferencia;
		
		milisActual = System.currentTimeMillis();
		milisCumple = this.fechaNacimiento.getTimeInMillis();
		diferencia = milisActual-milisCumple;
		edad = (int)((diferencia/86400000)/365.25);
		
		return edad;
	}
	
	public int getDniSinLetra(){
		String sinLetra = this.dni.substring(0, 8);
		int dni = Integer.parseInt(sinLetra);
		
		return dni;
	}
	
	
	@Override
	public String toString(){
		String s = ""+this.getApellidos()+","+this.getNombre()+","+this.fechaNacimiento.getTimeInMillis()+","+this.dni+","+this.especialidad+","+this.numeroColegiado+","+this.sexo;
		return s;
	}
	
	
	public int compareTo(MedicoIMPL m){
		int compara = 0;
		
		if(this.numeroColegiado<m.getNumeroColegiado()){
			compara = -1;
		}
		else if(this.numeroColegiado>m.getNumeroColegiado()){
			compara = 1;
		}
		
		return compara;
	}
	
	@Override
	public boolean equals(Object o){
		boolean esIgual = false;
		
		if(o instanceof MedicoIMPL){
			MedicoIMPL m = (MedicoIMPL) o;
			
			if(this.numeroColegiado==m.getNumeroColegiado()) esIgual=true;
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
		String s = "Apellidos: "+this.apellidos+"\nNombre: "+this.nombre+"\nFecha nacimiento: "+this.fechaNacimiento.getTime()+"\nDNI: "+this.dni+"\nEspecialidad: "+this.especialidad+"\nNumero Colegiado:"+this.numeroColegiado+"\nSexo:"+this.sexo;
		return s;
	}
	
}
