package Hospital;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class conductorMetodosMedico {
	public static void main(String[] args){
		
		int codigo = -10;
		String usuario = "UsuarioModificador", usuarioConsultor = "UsuarioConsultor", pass="123";
		MedicoIMPL m1 = null;
		Calendar fecha = new GregorianCalendar();
		Date date = new Date(); date.setTime(fecha.getTimeInMillis());
		LocalDate d1 = LocalDate.of(1987, 7, 11);
		
		MetodosMedico consultor = new MetodosMedico(usuarioConsultor, pass);
		MetodosMedico modificador = new MetodosMedico(usuario, pass);
		
		fecha.clear();
		fecha.set(1987, 7, 11); //clear() documentacion
		//fecha.set
		
		/*Calendar c = fecha.getInstance();
		c.set(Calendar.YEAR, 1987);
		c.set(Calendar.MONTH, 7);
		c.set(Calendar.DAY_OF_MONTH, 11);*/
		
		/*fecha = fecha.getInstance();
		fecha.set(Calendar.YEAR, 1987);
		fecha.set(Calendar.MONTH, 7);
		fecha.set(Calendar.DAY_OF_MONTH, 11);*/
		
		int anio = fecha.get(fecha.YEAR);
		
		m1 = new MedicoIMPL("Pedro", "Piedra", fecha, "12345677A", 111, "Traumatologo", 'V');
		
		//System.out.println(fecha.getTime()+", "+fecha.YEAR+", "+anio);
		//System.out.println(c.getTime()+", "+c.YEAR);
		
		/*System.out.println(fecha.YEAR);
		System.out.println(d1.getYear());
		System.out.println();*/
		
		//ESCRIBIR MEDICO
		/*codigo = modificador.escribirMedico(m1);
		
		System.out.println(codigo);*/
		
		//P�NTAR
		//consultor.pintarMedicosEnPantalla();
		
		//COGER MEDICO
		/*m1 = consultor.getMedico(945765);
		
		System.out.println(m1.toString()+", "+m1.getFechaNacimiento().getTime());*/
		
		//BAJA MEDICO
		/*Calendar fecha1 = new GregorianCalendar();
		String fechaEnString = ""+(fecha1.get(fecha1.YEAR)-10)+"-"
				+ ""+(fecha1.get(fecha1.MONTH)+1)+"-"+fecha1.get(fecha1.DAY_OF_MONTH)+" "
						+ ""+fecha1.get(fecha1.HOUR_OF_DAY)+":"+fecha1.get(fecha1.MINUTE);
		
		codigo = modificador.darMedicoDeBaja(945765, fechaEnString);
		
		System.out.println(codigo);*/
		
		//LISTAR BAJAS DE UN MEDICO
		//consultor.historialDeBajasMedico(945765);
		
		//LISTAR MEDICOS DE BAJA
		consultor.pintarMedicosDeBaja();
	}
}
