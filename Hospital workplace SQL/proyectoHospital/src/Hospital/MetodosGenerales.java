/**
 * nombre del programa: MetodosGenerales.java
 * 
 * propiedades basicas:
 * 	no hay
 * 
 * propiedades derivadas:
 * 	no hay
 * 
 * metodos adicionales:
 * 	String quitarEspaciosDeCadena(String s)
 * 	String agregarEspaciosEnCadena(String s, int maximo)
 * 	String aniadirLetraDni(int dni)
 */

package Hospital;


public class MetodosGenerales {
	
	/**
	 * cabecera: String quitarEspaciosDeCadena(String s)
	 * comentario: metodo para quitar los espacios en blanco usados para rellenar una cadena
	 * precondiciones: nada
	 * entrada: una cadena
	 * e/s: nada
	 * salida: una cadena
	 * postcondiciones: asociado al nombre devuelve la cadena sin los espacios de relleno
	 */
	public static String quitarEspaciosDeCadena(String s){
		String cadenaSinEspacios = "";
		char letraInicial=' ', siguienteLetra=' ';
		
		letraInicial = s.charAt(0); siguienteLetra = s.charAt(1);
		for(int i=2;i<s.length() || (siguienteLetra!=' ' && letraInicial!=' ');i++){
			if(letraInicial!=' ' || (letraInicial==' ' && siguienteLetra!=' ')) cadenaSinEspacios=cadenaSinEspacios+letraInicial;
			letraInicial = siguienteLetra;
			siguienteLetra = s.charAt(i);
			
		}
		
		return cadenaSinEspacios;
	}
	
	
	/**
	 * cabecera: String agregarEspaciosEnCadena(String s, int maximo)
	 * comentario: metodo para agregar espacios en blanco para rellenar una cadena
	 * precondiciones: nada
	 * entrada: una cadena
	 * e/s: nada
	 * salida: una cadena
	 * postcondiciones: asociado al nombre devuelve la cadena con espacios de relleno despues del contenido de la cadena original
	 */
	public static String agregarEspaciosEnCadena(String s, int maximo){
		String cadenaConEspacios = s;
		
		while(cadenaConEspacios.length()<maximo){
			cadenaConEspacios=cadenaConEspacios+" ";
		}
		
		return cadenaConEspacios;
	}
	
	
	/**
	 * cabecera: String aniadirLetraDni(int dni)
	 * comentario: metodo para calcular y a�adir la letra a un dni sin letra
	 * precondiciones: nada
	 * entrada: un entero
	 * e/s: nada
	 * salida: una cadena
	 * postcondiciones: asociado al nombre devuelve el dni con su letra correspondiente
	 */
	public static String aniadirLetraDni(int dni){
		String letras = "TRWAGMYFPDXBNJZSQVHLCKE", dniConLetra;
		int posicionLetra=dni%23;
		char letra = letras.charAt(posicionLetra);
		
		dniConLetra = ""+dni+letra;
		
		return dniConLetra;
	}
	
	
	/**
	 * cabecera: void estadisticaEdadPacientes()
	 * comentario: metodo para calcular y mostrar en pantalla la edad de los pacientes
	 * precondiciones: nada
	 * entrada: nada
	 * e/s: nada
	 * salida: nada
	 * postcondiciones: nada, pinta en pantalla la edad de los pacientes
	 */
	/*@Deprecated
	public static void estadisticaEdadPacientes(){
		
		RandomAccessFile archivo = null;
		Calendar fecha = new GregorianCalendar();
		Paciente p = null;
		
		long milisFecha=0;
		int[] edades = new int[91];
		int edad=-1, numeroSS=0, total=0;
		String nombre="", apellidos="", dniConLetra="";
		char sexo=' ';
		
		
		try{
			archivo = new RandomAccessFile(MetodosPaciente.archivoPacientes, "r");
			
			while(archivo.getFilePointer()<archivo.length()){
				apellidos=archivo.readUTF();
				nombre=archivo.readUTF();
				milisFecha=archivo.readLong();
				dniConLetra=archivo.readUTF();
				sexo=archivo.readChar();
				numeroSS=archivo.readInt();
				
				fecha.setTimeInMillis(milisFecha);
				
				p = new Paciente(nombre, apellidos, fecha, dniConLetra, numeroSS, sexo);
				
				edad = p.getEdad();
				
				if(edad<90){
					edades[edad]++;
				}
				else{
					edades[91]++;
				}
				
				total++;
			}
			
			for(int i=0, j=0;j<total;i++){
				if(edades[i]>0){
					System.out.println("Pacientes de edad "+i+": "+edades[i]);
					j++;
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	*/
	
	/**
	 * cabecera: void esdisticaSexoPacientes()
	 * comentario: metodo para calcular y mostrar en pantalla el sexo de los pacientes
	 * precondiciones: nada
	 * entrada: nada
	 * e/s: nada
	 * salida: nada
	 * postcondiciones: nada, pinta en pantalla el sexo de los pacientes
	 */
	/*@Deprecated
	public static void esdisticaSexoPacientes(){
		
		RandomAccessFile archivo = null;
		
		int varon=0, mujer=0, tamanioDatosSinMirar = MetodosPaciente.tamanioRegistroCompleto-MetodosPaciente.posicionRegistroSexo;
		char sexo=' ';
		long puntero = MetodosPaciente.posicionRegistroSexo;
		
		try{
			archivo = new RandomAccessFile(MetodosPaciente.archivoPacientes, "r");
			
			archivo.seek(puntero);
			
			while(archivo.getFilePointer()<archivo.length()){
				
				sexo = archivo.readChar();
				
				if(sexo=='V') varon++;
				else mujer++;
				
				archivo.skipBytes(MetodosPaciente.tamanioRegistroCompleto-tamanioDatosSinMirar);
			}
			
			System.out.println("Numero de pacientes varones: "+varon);
			System.out.println("Numero de pacientes mujeres: "+mujer+"\n");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	*/
	
}
