package miscelanea;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import Hospital.MetodosMedico;

public class fechas {
	public static void main(String[] args){
		
		Calendar fecha1 = new GregorianCalendar();
		
		int codigo = -11;
		
		/*fecha1.set(Calendar.YEAR, 1987);
		fecha1.set(Calendar.MONTH, 7);
		fecha1.set(Calendar.DAY_OF_MONTH, 11);*/
		
		//System.out.println(fecha1.getTime()+"\n"+fecha1.get(fecha1.YEAR));
		
		
		
		MetodosMedico m1 = new MetodosMedico("UsuarioModificador", "123");
		String fechaEnString = ""+(fecha1.get(fecha1.YEAR)-10)+"-"
				+ ""+(fecha1.get(fecha1.MONTH)+1)+"-"+fecha1.get(fecha1.DAY_OF_MONTH)+" "
						+ ""+fecha1.get(fecha1.HOUR_OF_DAY)+":"+fecha1.get(fecha1.MINUTE);
		
		codigo = m1.darMedicoDeBaja(945765, fechaEnString);
		
		System.out.println(codigo);
	}
}
