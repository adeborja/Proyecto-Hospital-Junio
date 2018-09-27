package futuraImplementacion;

import java.util.*;

public class conductorRevision {
	public static void main(String[] args){
		
		RevisionIMPL r1 = new RevisionIMPL(123445, 443785, new GregorianCalendar(), "mal", "mu mal");
		
		Calendar fecha = new GregorianCalendar();
		fecha.setTimeInMillis((r1.getFecha().getTimeInMillis())+2000);
		
		RevisionIMPL r2 = new RevisionIMPL(134552, 111123, fecha, "mol", "to");
			
		System.out.println(r1.getNumeroSSPaciente());
		System.out.println(r1.getNumeroColegiado());
		System.out.println(r1.getFecha().getTime());
		System.out.println(r2.getFecha().getTime());
		System.out.println(r1.getTipo());
		System.out.println(r1.getDescripcion());
		
		System.out.println(r1.toString());
		System.out.println(r2.toString());
		
		System.out.println(r1.compareTo(r2));
		System.out.println(r1.equals(r2));
		System.out.println(r1.compareTo(r1));
		System.out.println(r1.equals(r1));
		System.out.println(r2.compareTo(r1));
		System.out.println(r2.equals(r1));
		
	}
}
