package Hospital;

import java.util.Calendar;
import java.io.Serializable;

public class PersonaIMPL implements Comparable<PersonaIMPL>, Serializable{
	
	private String nombre, apellidos, dni;
	private Calendar fechaNacimiento;
	private char sexo;
	
	public PersonaIMPL(){
		this.nombre="";
		this.apellidos="";
		this.fechaNacimiento=null;
		this.dni="";
		this.sexo=' ';
	}
	
	public PersonaIMPL(String nNombre, String nApellidos, Calendar nFecha, String nDni, char nSexo){
		this.nombre=nNombre;
		this.apellidos=nApellidos;
		this.fechaNacimiento=nFecha;
		this.dni=nDni;
		this.sexo=nSexo;
	}
	
	public PersonaIMPL(PersonaIMPL m){
		this.nombre=m.nombre;
		this.apellidos=m.apellidos;
		this.fechaNacimiento=m.fechaNacimiento;
		this.dni=m.dni;
		this.sexo=m.sexo;
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
	}
	
	
	@Override
	public String toString(){
		String s = ""+this.getApellidos()+","+this.getNombre()+","+this.fechaNacimiento.getTimeInMillis()+","+this.dni+","+this.sexo;
		return s;
	}
	
	public int compareTo(PersonaIMPL p){
		int compara = 0;
		
		if(this.getEdad()<p.getEdad()){
			compara = -1;
		}
		else if(this.getEdad()>p.getEdad()){
			compara = 1;
		}
		
		return compara;
	}
	
	@Override
	public boolean equals(Object o){
		boolean esIgual = false;
		
		if(o instanceof PersonaIMPL){
			PersonaIMPL p = (PersonaIMPL) o;
			
			if(this.getEdad()==p.getEdad()) esIgual=true;
		}
		
		return esIgual;
	}
}
