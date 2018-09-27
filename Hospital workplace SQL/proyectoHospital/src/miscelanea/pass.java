package miscelanea;

import java.io.Console;

public class pass {
	public static void main(String [] args){
		

		        Console terminal = System.console();
		       /* if (terminal==null) {
		            Throw new Exception("No se pudo instanciar la consola.");
		        } // end if
		 */
		        String user= new String (terminal.readLine("Usuario:"));
		        String pass= new String (terminal.readPassword("Password:"));
		 

		
	}
}
